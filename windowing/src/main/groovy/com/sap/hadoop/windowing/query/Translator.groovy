package com.sap.hadoop.windowing.query

import groovy.lang.GroovyShell;
import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.WindowingException;
import org.antlr.runtime.tree.CommonTree;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe;
import org.apache.hadoop.hive.contrib.util.typedbytes.TypedBytesRecordWriter;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils.ObjectInspectorCopyOption;
import org.apache.hadoop.hive.serde2.objectinspector.SettableStructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoUtils;
import org.apache.hadoop.hive.serde.Constants as HiveConstants

import com.sap.hadoop.windowing.functions.*;
import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
import com.sap.hadoop.windowing.io.HiveWindowingInput;
import com.sap.hadoop.windowing.io.WindowingInput;
import com.sap.hadoop.windowing.runtime.ArgType;
import com.sap.hadoop.windowing.*;

abstract class Translator
{
	
	Query translate(GroovyShell wshell, QuerySpec qrySpec, Configuration cfg)
	throws WindowingException
	{
		Query qry = new Query(qSpec: qrySpec,
			wshell : wshell,
			cfg : cfg)
		setupQueryInput(qry)
		setupWindowFunctions(wshell, qry)
		setupOutput(qry)
		return qry
	}
	
	void setupQueryInput(Query qry) throws WindowingException 
	{
		QueryInput qryIn = new QueryInput()
		qry.input = qryIn
		WindowingInput inputStream = setupWindowingInput(qry)
		qryIn.wInput = inputStream
		qryIn.deserializer = inputStream.getDeserializer()
		qryIn.inputOI = qryIn.deserializer.getObjectInspector()
		qryIn.processingOI = ObjectInspectorUtils.getStandardObjectInspector(qryIn.inputOI, ObjectInspectorCopyOption.JAVA)
		setupInputColumns(qry)
		
		//println qryIn.columns.typeInfo.typeName
	}
	
	/**
	 * <ul>
	 * <li> Create a Column object for each Field in processingOI
	 * <li> validate columns in partition clause are columns of this table
	 * <li> validate columns in order clause are columns of this table; add ordering info to Column object
	 * <li> if order columns doesn't include partition columns, add them.
	 * </ul>
	 * @param qry
	 * @throws WindowingException
	 */
	void setupInputColumns(Query qry) throws WindowingException
	{
		QueryInput qryIn = qry.input
		QuerySpec qSpec = qry.qSpec
		StructObjectInspector processingOI = qryIn.processingOI
		Map<String, Column> fieldMap = [:]
		for(StructField f in processingOI.allStructFieldRefs)
		{
			Column c = new Column(field: f)
			fieldMap[c.name] = c
			qryIn.columns << c
		}
		
		def pCols = new HashSet()
		for(String p in qSpec.partitionColumns)
		{
			if ( !(p in fieldMap) )
				throw new WindowingException(sprintf("Unknown partition column %s", p))
			qryIn.partitionColumns << fieldMap[p]
			pCols.add(p)
		}
		
		def oCols = new HashSet()
		def tl = []
		for(OrderColumn o in qSpec.orderColumns)
		{
			if ( !(o.name in fieldMap) )
				throw new WindowingException(sprintf("Unknown order column %s", o.name))
			tl << fieldMap[o.name]
			fieldMap[o.name].order = o.order
			oCols.add(o.name)
		}
		
		int numMissing = 0
		for(p in pCols)
		{
			if ( !(p in oCols)) numMissing++
		}
		
		if ( numMissing != 0 && numMissing != pCols.size())
		throw new WindowingException(sprintf("""Mismatch in partition & order specification: either specify all partition \
columns(%s) in the order clause(%s) or specify none(these will be added for you)""", pCols, oCols))
		
		if (numMissing > 0)
		{
			for(p in qryIn.partitionColumns)
			{
				p.order = Order.ASC
				qryIn.orderColumns << p
			}
		}
		qryIn.orderColumns += tl
	}
	
	abstract WindowingInput setupWindowingInput(Query qry) throws WindowingException;
	
	void setupWindowFunctions(GroovyShell wshell, Query qry)
	{
		qry.wnFns = []
		qry.wnAliases = []
		for(fnSpec in qry.qSpec.funcSpecs)
		{
			qry.wnFns << FunctionRegistry.getTranslator(fnSpec).translate(wshell, qry, fnSpec)
			qry.wnAliases << fnSpec.alias
		}
	}
	
	void setupOutput(Query qry) throws WindowingException
	{
		try
		{
			QueryOutput qryOut = new QueryOutput()
			qry.output = qryOut
			setupOutputColumns(qry)
			
			// 1. setup SerDe
			def coltypes = qryOut.columns.typeInfo.typeName.join(",")
			def colnames = qryOut.columns.alias.join(",")
			Properties props = new Properties()
			props.setProperty(HiveConstants.LIST_COLUMNS, colnames)
			props.setProperty(HiveConstants.LIST_COLUMN_TYPES, coltypes)
			qryOut.serDe = getOutputSerDe(props);
			
			// 2. setup internal processing serDe
			qryOut.serDe.initialize(qry.cfg, props);
			qryOut.outputOI = qryOut.serDe.getObjectInspector()
			qryOut.processingOI = ObjectInspectorUtils.getStandardObjectInspector(qryOut.outputOI, ObjectInspectorCopyOption.JAVA)
			
			//3. setup writer
			qryOut.wrtr = new TypedBytesRecordWriter();
			qryOut.wrtr.initialize(getOutputStream(), qry.cfg);
			
			//4. fill in fieldRefs to Columns
			for(int i in 0..<qryOut.columns.size())
			{
				Column c = qryOut.columns[i]
				c.field = qryOut.processingOI.allStructFieldRefs[i]
			}
		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
	}
	
	void setupOutputColumns(Query qry) throws WindowingException
	{
		QueryOutput qryOut = qry.output
		ArrayList<SelectColumn> selectList = qry.qSpec.selectColumns 
		for(i in 0..<selectList.size())
		{
			OutputColumn oc = new OutputColumn(alias : selectList[i].alias,
						groovyExpr: selectList[i].expr ? qry.wshell.parse(selectList[i].expr) : qry.wshell.parse(selectList[i].alias)
				)
			inferType(oc, selectList[i], qry)
			qryOut.columns << oc
		}
	}
	
	void inferType(OutputColumn oc, SelectColumn sCol, Query qry) throws WindowingException
	{
		//0. if type specified explicitly specified in sCol, use it.
		if ( sCol.typeName)
		{
			oc.typeInfo = TypeInfoFactory.getPrimitiveTypeInfo(sCol.typeName)
			return;
		}
		
		//1. if col refers to an input column, use its type
		for (Column ic in qry.input.columns)
		{
			if (oc.name == ic.name)
			{
				oc.typeInfo = ic.typeInfo
				return;
			}
		}
		
		//2. if col refers to a fn alias use its specified type or the fn's predetermined type or the 1st args type if it is an identifier
		for(int i in 0..<qry.wnAliases.size())
		{
			if (oc.name ==qry.wnAliases[i])
			{
				FuncSpec fSpec = qry.qSpec.funcSpecs[i]
				if ( fSpec.typeName)
				{
					oc.typeInfo = TypeInfoFactory.getPrimitiveTypeInfo(fSpec.typeName)
					return;
				}
				
				Class<? extends IWindowFunction> fCls = qry.wnFns[i].class
				FunctionDef fDef = fCls.getAnnotation(FunctionDef.class);
				if ( fDef.typeName() )
				{
					oc.typeInfo = TypeInfoFactory.getPrimitiveTypeInfo(fDef.typeName())
					return;
				}
				
				if ( fSpec.params.size() > 0)
				{
					FuncArg arg1 = fSpec.params[0]
					if (arg1.argType == ArgType.ID)
					{
						for (Column ic in qry.input.columns)
						{
							if (arg1.id == ic.name)
							{
								oc.typeInfo = ic.typeInfo
								return;
							}
						}
					}
				}
			}
		}
		
		//3. for now assume type is 'double'. (revisit: analyze grrovy expressions to infer type)
		oc.typeInfo = TypeInfoFactory.getPrimitiveTypeInfo('double')
	}
	
	OutputStream getOutputStream()
	{
		return System.out
	}
	
	SerDe getOutputSerDe(Properties props)
	{
		return new TypedBytesSerDe();
	}
}

class LocalTranslator extends Translator
{
	WindowingInput setupWindowingInput(Query qry) throws WindowingException
	{
		TableInput tableIn = qry.qSpec.tableIn
		Properties serDeProps = tableIn.serDeProps
		def msgs = [];
		
		if ( !tableIn.windowingInputClass)
		{
			msgs << sprintf("Param '%s' is required", Constants.INPUT_RECORD_READER_CLASS)
		}
		if ( !tableIn.keyClass)
		{
			msgs << sprintf("Param '%s' is required", Constants.INPUT_KEY_CLASS)
		}
		if ( !tableIn.valueClass)
		{
			msgs << sprintf("Param '%s' is required", Constants.INPUT_VALUE_CLASS)
		}
		if ( !tableIn.inputFormatClass)
		{
			msgs << sprintf("Param '%s' is required", Constants.INPUT_INPUTFORMAT_CLASS)
		}
		if ( !tableIn.serDeClass)
		{
			msgs << sprintf("Param '%s' is required", Constants.INPUT_SERDE_CLASS)
		}
		if ( !serDeProps[HiveConstants.LIST_COLUMN_TYPES] )
		{
			msgs << sprintf("Param '%s' is required", HiveConstants.LIST_COLUMN_TYPES)
		}
		if ( !serDeProps[HiveConstants.LIST_COLUMNS] )
		{
			msgs << sprintf("Param '%s' is required", HiveConstants.LIST_COLUMNS)
		}
		
		if (msgs)
		{
			throw new WindowingException(msgs.join("\n"))
		}
		
		try
		{
			Configuration cfg = qry.cfg
			cfg.set(Constants.INPUT_KEY_CLASS, tableIn.keyClass);
			cfg.set(Constants.INPUT_VALUE_CLASS, tableIn.valueClass);
			cfg.set(Constants.INPUT_INPUTFORMAT_CLASS, tableIn.inputFormatClass);
			cfg.set(Constants.INPUT_SERDE_CLASS, tableIn.serDeClass);
			cfg.set(Constants.INPUT_PATH, tableIn.inputPath);
			WindowingInput rdr = (WindowingInput) Class.forName(tableIn.windowingInputClass).newInstance();
			rdr.initialize(null, cfg, tableIn.serDeProps);
			return rdr;
		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
	}
}

class HiveTranslator extends Translator
{
	WindowingInput setupWindowingInput(Query qry) throws WindowingException
	{
		TableInput tableIn = qry.qSpec.tableIn
		Properties serDeProps = tableIn.serDeProps
		def msgs = [];
		
		if ( !serDeProps[HiveConstants.LIST_COLUMN_TYPES] )
		{
			msgs << sprintf("Param '%s' is required", HiveConstants.LIST_COLUMN_TYPES)
		}
		if ( !serDeProps[HiveConstants.LIST_COLUMNS] )
		{
			msgs << sprintf("Param '%s' is required", HiveConstants.LIST_COLUMNS)
		}
		
		if (msgs)
		{
			throw new WindowingException(msgs.join("\n"))
		}
		
		try
		{
			Configuration cfg = qry.cfg
			WindowingInput rdr = new HiveWindowingInput();
			rdr.initialize(null, cfg, tableIn.serDeProps);
			return rdr;
		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
	}

}


