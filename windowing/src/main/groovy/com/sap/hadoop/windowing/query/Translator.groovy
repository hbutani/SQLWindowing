package com.sap.hadoop.windowing.query

import java.util.Map;

import groovy.lang.GroovyShell;

import com.sap.hadoop.ds.list.ByteBasedList;
import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.WindowingException;
import org.antlr.runtime.tree.CommonTree;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe;
import org.apache.hadoop.hive.contrib.util.typedbytes.TypedBytesRecordWriter;
import org.apache.hadoop.hive.ql.exec.RecordWriter;
import org.apache.hadoop.hive.ql.io.RCFile;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.columnar.ColumnarSerDe;
import org.apache.hadoop.hive.serde2.lazybinary.LazyBinarySerDe;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils.ObjectInspectorCopyOption;
import org.apache.hadoop.hive.serde2.objectinspector.SettableStructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoUtils;
import org.apache.hadoop.hive.serde.Constants as HiveConstants

import com.sap.hadoop.windowing.functions.*;
import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
import com.sap.hadoop.windowing.io.HiveWindowingInput;
import com.sap.hadoop.windowing.io.WindowingInput;
import com.sap.hadoop.windowing.runtime.ArgType;
import com.sap.hadoop.windowing.runtime.HiveQueryExecutor;
import com.sap.hadoop.windowing.*;
import com.sap.hadoop.windowing.functions.WindowingTableFunction;

abstract class Translator
{
	
	Query translate(GroovyShell wshell, QuerySpec qrySpec, Configuration cfg, HiveQueryExecutor hiveQryExec)
	throws WindowingException
	{
		Query qry = new Query(qSpec: qrySpec,
			wshell : wshell,
			cfg : cfg)
		setupQueryInput(qry, hiveQryExec)
		setupWindowFunctions(wshell, qry)
		setupTableFunction(wshell, qry)
		setupMapPhase(qry)
		
		/* if Query has  table functions setup of Input Partion & Order columns
		* is deferred to after function chain is setup because setting up the chain may alter the qryInput ObjectInspector.
		*/
	    if (qry.qSpec.tblFuncSpec)
	    {
		   setupInputPartitionAndOrderColumns(qry)
	    }
	   
		setupOutput(qry)
		setupWhereClause(qry)
		
//		qry.partitionMemSize = cfg.getInt(Constants.WINDOW_PARTITION_MEM_SIZE, ByteBasedList.MEDIUM_SIZE);
//		qry.partitionClass = cfg.get(Constants.WINDOW_PARTITION_CLASS, Constants.DEFAULT_WINDOW_PARTITION_CLASS);
		
		return qry
	}
	
	/**
	 * <ol>
	 * <li> If the Input to the Query is a <i>hive Query</i> execute it, store result in a Temp. table and change Query 
	 * input to the Temp. table.
	 * <li> Setup the WindowingInput for this Query: In MR mode this means extract SerDe information from the Hive metadata.
	 * <li> setup the Query's input Deserializer, and ObjectInspector from the WindowingInput. 
	 * <li> setup the Processing ObjectInspector: this is set to a StandardStructOI, which means all function execution 
	 *   happens on Java Objects.
	 * <li> setup Input Columns
	 * </ol>
	 * @param qry
	 * @param hiveQryExec
	 * @throws WindowingException
	 */
	void setupQueryInput(Query qry, HiveQueryExecutor hiveQryExec) throws WindowingException 
	{
		QueryInput qryIn = new QueryInput()
		qry.input = qryIn
		
		/*
		 * if a hive query is specified execute it and set input to the temp table created
		 */
		if ( qry.qSpec.tableIn.hiveQuery != null && qry.qSpec.tableIn.tableName == null )
		{
			if ( hiveQryExec == null )
			{
				throw new WindowingException("Attempt to execute a embedded Hive Query in an unsupported Context");
			}
			qry.qSpec.tableIn.tableName = hiveQryExec.createTableAsQuery(qry.qSpec.tableIn.hiveQuery)
		}
		
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
	 * <li> invoke setupInputPartitionAndOrderColumns to setup Partition & Order columns
	 * </ul>
	 * @param qry
	 * @throws WindowingException
	 */
	void setupInputColumns(Query qry) throws WindowingException
	{
		QueryInput qryIn = qry.input
		QuerySpec qSpec = qry.qSpec
		StructObjectInspector inputOI = qryIn.inputOI
		Map<String, Column> fieldMap = [:]
		for(StructField f in inputOI.allStructFieldRefs)
		{
			Column c = new Column(field: f)
			fieldMap[c.name] = c
			qryIn.columns << c
		}
		
		/* if Query has no table functions go ahead and setup Input Partion & Order columns.
		 * Otherwise this is deferred to after function chain is setup because setting up the chain may alter the qryInput ObjectInspector.
		 */
		if (!qry.qSpec.tblFuncSpec)
		{
			setupInputPartitionAndOrderColumns(qry)
		}
	}
	
	/**
	* <ul>
	* <li> validate columns in partition clause are columns of this table
	* <li> validate columns in order clause are columns of this table; add ordering info to Column object
	* <li> if order columns doesn't include partition columns, add them.
	* </ul>
	* 
	* The columns on the QuerySpec.QueryInput need not match the Partition & Order Columns. This is because the 
	* first TblFunction may have reshaped the Input in the Map-Side. So the Partition & Order Columns in the QueryInput
	* may point to Fields in the ObjectInspector returned by the TblFunc.
	* 
	* @param qry
	* @throws WindowingException
	*/
   void setupInputPartitionAndOrderColumns(Query qry) throws WindowingException
   {
	   QueryInput qryIn = qry.input
	   QuerySpec qSpec = qry.qSpec
	   StructObjectInspector inputOI = qryIn.inputOI
	   Map<String, StructField> fieldMap = [:]
	   for(StructField f in inputOI.allStructFieldRefs)
	   {
		   fieldMap[f.fieldName] = f
	   }
	   
	   def pCols = new HashSet()
	   for(String p in qSpec.tableIn.partitionColumns)
	   {
		   p = p.toLowerCase()
		   if ( !(p in fieldMap) )
			   throw new WindowingException(sprintf("Unknown partition column %s", p))
		   qryIn.partitionColumns << new Column(field: fieldMap[p])
		   pCols.add(p)
	   }
	   
	   def oCols = new HashSet()
	   def tl = []
	   for(OrderColumn o in qSpec.tableIn.orderColumns)
	   {
		   String oNm = o.name.toLowerCase()
		   if ( !(oNm in fieldMap) )
		   {
			   throw new WindowingException(sprintf("Unknown order column %s", o.name))
		   }
		   Column oC = new Column(field: fieldMap[oNm])
		   tl << oC
		   oC.order = o.order
		   oCols.add(oNm)
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
	
	/*
	 * If query input is reshaped based on an Map-Side TableFnc, this hook gives the Translator a chance to fix the WindowingInput
	 */
	void handleMapSideReshapeInWindowingInput(Query qry) throws WindowingException
	{
		
	}
	
	/**
	 * Setup the Window Functions for the Query. Rely on the {@link FunctionTranslator} to construct a {@link IWindowFunction} object.
	 * @param wshell
	 * @param qry
	 */
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
	
	/**
	 * Responsible for setting up the Table Function Chain.
	 * <ol>
	 * <li> The {@link QuerySpec} has a list of {@link FuncSpec} which is in the order encountered in the Query. The functions
	 * need to be applied in reverse order.
	 * <li> If windowing clauses are specified in the Query then the final function will be the {@link WindowingTableFunction}.
	 * </ol>
	 * Uses the following logic to setup the chain:
	 * <ol>
	 * <li> No Table Function used in Query: setup {@link WindowingTableFunction} as the <i>inputtableFunction</i> and also as the
	 *  <i>final</i> tableFunction of the Query.
	 *  <li> scan forward through the Func list in the QuerySpec and push them onto a Stack.
	 *  <li> now iterate on the Stack, calling on the {@link FunctionTranslator} and the 
	 *  {@link AbstractTableFunction table Function object} to translate the FuncSpec into a Function object. The Function
	 *  object are chained so that a FuncObject is linked to the previous FuncObject via its inputtableFunction variable.
	 *  <li> set the top element in the stack as the inputtableFunction, and the bottom element as the final tableFunction.
	 * </ol>
	 * @param wshell
	 * @param qry
	 * @throws WindowingException
	 */
	void setupTableFunction(GroovyShell wshell, Query qry) throws WindowingException
	{
		if ( !qry.qSpec.tblFuncSpec)
		{
			qry.tableFunction = new WindowingTableFunction(qry)
			qry.inputtableFunction = qry.tableFunction
		}
		else
		{
//			if ( ! qry?.wnFns.empty )
//			{
//				throw new WindowingException("With clause not supported with pure table Functions")
//			}
			TableFuncSpec tSpec = qry.qSpec.tblFuncSpec
			Stack<TableFuncSpec> stk = new Stack<TableFuncSpec>()
			while(tSpec != null)
			{
				stk.push(tSpec)
				tSpec = tSpec.inputFuncSpec
			}
			
			tSpec = stk.pop()
			AbstractTableFunction currFunc = FunctionRegistry.getTranslator(tSpec).translateTableFunction(wshell, qry, tSpec)
			qry.inputtableFunction = currFunc
			currFunc.completeTranslation(wshell, qry, tSpec)
			while(! stk.empty() )
			{
				tSpec = stk.pop()
				AbstractTableFunction tFunc = FunctionRegistry.getTranslator(tSpec).translateTableFunction(wshell, qry, tSpec)
				tFunc.input = currFunc
				currFunc = tFunc
				currFunc.completeTranslation(wshell, qry, tSpec)
			}
			
			if ( ! qry?.wnFns.empty )
			{
				qry.tableFunction = new WindowingTableFunction(qry)
				qry.tableFunction.input = currFunc
			}
			else
			{
				qry.tableFunction = currFunc
			}
		}
	}
	
	/**
	 * If the query's inputtableFunction has a Map Phase then the MR Job has to be setup such that:
	 * <ol>
	 * <li> During the Map Phase each Map Task collects the Input rows into a Partition. At the end it calls the
	 * TableFunction's mapExecute method. 
	 * <li> The Map Task takes the output of the mapExecute method and serializes it using the TblFunc's SerDe.
	 * <li> The Reduce phase works as always, except that it uses the TblFunc's SerDe to deserialize objects from the stream.
	 * </ol>
	 * In order for the above to work the {@link QueryMapPhase} captures information on the shape & serilization of data as it gets 
	 * operated on in the Map Phase:
	 * <ol>
	 * <li> qry.mapPhase.inputOI is set to the Query's input ObjectInspector
	 * <li> qry.mapPhase.inputDeserializer is set to the Query's input Deserializer.
	 * <li> qry.mapPhase.outputSerDe is set to the TableFunction's MapOutputSerDe
	 * <li> finally the Query's inputOI & deserializer are set to the mapPhase's outputOI and outputSerDe. The variables 
	 * inputOI and deserializer are really used during the reduce phase, since there was no map phase before there names
	 * imply that they represent the Query input.
	 * </ol>
	 * @param qry
	 * @throws WindowingException
	 */
	void setupMapPhase(Query qry) throws WindowingException
	{
		if ( !qry.inputtableFunction.hasMapPhase() )
		{
			return
		}		
		qry.mapPhase = new QueryMapPhase()
		qry.mapPhase.inputOI = qry.input.inputOI
		qry.mapPhase.inputDeserializer = qry.input.deserializer
		
		qry.mapPhase.outputSerDe = qry.inputtableFunction.getMapOutputPartitionSerDe()
		
		qry.mapPhase.outputOI = qry.mapPhase.outputSerDe.getObjectInspector()
		qry.mapPhase.processingOI = ObjectInspectorUtils.getStandardObjectInspector(qry.mapPhase.outputOI, ObjectInspectorCopyOption.JAVA)
		
		qry.input.inputOI = qry.mapPhase.outputOI
		qry.input.deserializer = qry.mapPhase.outputSerDe
		
		handleMapSideReshapeInWindowingInput(qry)
	}
	
	void setupOutput(Query qry) throws WindowingException
	{
		try
		{
			TableOutput tblOut = qry.qSpec.tableOut
			QueryOutput qryOut = new QueryOutput()
			qry.output = qryOut
			setupOutputColumns(qry)
			
			validateOutputSpec(qry)
			
			// 1. setup SerDe
			setupOutputSerDe(qry)
			
			/*
			 *  2. setup internal processing serDe.
			 *  The functions output rows as Java arrays. The QueryOutput processingOI is passed along with the array to the QueryOutput
			 *  serializer.
			 */
			qryOut.outputOI = qryOut.serDe.getObjectInspector()
			qryOut.processingOI = ObjectInspectorUtils.getStandardObjectInspector(qryOut.outputOI, ObjectInspectorCopyOption.JAVA)
			
			//3. setup writer
			setupWriter(qry)
			
			/*
			 * 4. fill in fieldRefs to Columns
			 * Link the QueryOutput columns to the Fields in the processing ObjectInspector.
			 */
			for(int i in 0..<qryOut.columns.size())
			{
				Column c = qryOut.columns[i]
				c.field = qryOut.processingOI.allStructFieldRefs[i]
			}
		}
		catch(Exception e)
		{
			//e.printStackTrace()
			throw new WindowingException(e);
		}
	}
	
	/**
	 * Query currently must have a selectList (todo allow it to be optional if there is TableFunction).
	 * For each Select List expression setup a {@link SelectColumn}. Infer its type for column based on rules in inferTyp method.
	 * @param qry
	 * @throws WindowingException
	 */
	void setupOutputColumns(Query qry) throws WindowingException
	{
		QueryOutput qryOut = qry.output
		ArrayList<SelectColumn> selectList = qry.qSpec.selectColumns 
		for(i in 0..<selectList.size())
		{
			validateOutputColumn(selectList[i], qry)
			OutputColumn oc = new OutputColumn(alias : selectList[i].alias,
						groovyExpr: selectList[i].expr ? qry.wshell.parse(selectList[i].expr) : qry.wshell.parse(selectList[i].alias)
				)
			inferType(oc, selectList[i], qry)
			qryOut.columns << oc
		}
	}
	
	/*
	 * if oc has no expression ensure alias is an inputColumn name or a name in the Output of the qry's table function.
	 */
	void validateOutputColumn(SelectColumn oc, Query qry) throws WindowingException
	{
		if ( oc.expr == null )
		{
			for (Column ic in qry.input.columns)
			{
				if (oc.alias == ic.name)
				{
					return;
				}
			}
			Map<String, TypeInfo> outputShape = qry.tableFunction.getOutputShape()
			if ( oc.alias in outputShape)
			{
				return
			}
			
			throw new WindowingException(sprintf("Unknown name '%s' in select list", oc.alias))
		}
	}
	
	/**
	 * <ol>
	 * <li> if explicitly specified by user, use this.
	 * <li> if name matches an input column, use type of input column
	 * <li> if name matches a column from the query's final table function, use its type.
	 * <li> otherwise assume type is 'double'.
	 * </ol>
	 * @param oc
	 * @param sCol
	 * @param qry
	 * @throws WindowingException
	 */
	void inferType(OutputColumn oc, SelectColumn sCol, Query qry) throws WindowingException
	{
		//0. if type specified explicitly specified in sCol, use it.
		if ( sCol.typeName)
		{
			//oc.typeInfo = TypeInfoFactory.getPrimitiveTypeInfo(sCol.typeName)
			oc.typeInfo = TypeInfoUtils.getTypeInfoFromTypeString(sCol.typeName)
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
		
		Map<String, TypeInfo> outputShape = qry.tableFunction.getOutputShape()
		if ( oc.name in outputShape)
		{
			oc.typeInfo = outputShape[oc.name]
			return
		}
		//3. for now assume type is 'double'. (revisit: analyze grrovy expressions to infer type)
		oc.typeInfo = TypeInfoFactory.getPrimitiveTypeInfo('double')
	}
	
	void setupWhereClause(Query q) throws WindowingException
	{
		String whereExpr = q.qSpec.whereExpr
		try
		{
			if (whereExpr != null)
			{
				q.whereExpr = q.wshell.parse(whereExpr)
			}
			else
			{
				q.whereExpr = null
			}
		}
		catch(Throwable t)
		{
			throw new WindowingException(sprintf("Failed to parse where Clause '%s'", whereExpr), t)
		}
	}
	
	OutputStream getOutputStream()
	{
		return System.out
	}
	
	/**
	 * <ul>
	 * <li> Instantiate Query Output SerDe
	 * <li> initialize SerDe; pass Columns & ColumnTypes in Configuration before calling initialize.
	 * </ul>
	 * @param qry
	 * @throws WindowingException
	 */
	void setupOutputSerDe(Query qry) throws WindowingException
	{
		QueryOutput qryOut = qry.output
		TableOutput tblOut = qry.qSpec.tableOut
		try
		{
			// 1. setup SerDe
			def coltypes = qryOut.columns.typeInfo.typeName.join(",")
			def colnames = qryOut.columns.alias.join(",")
			Class<? extends SerDe> c = (Class<? extends SerDe>) Class.forName(tblOut.serDeClass)
			qryOut.serDe =  c.newInstance();
			
			Properties props = tblOut.serDeProps
			props.setProperty(HiveConstants.LIST_COLUMNS, colnames)
			props.setProperty(HiveConstants.LIST_COLUMN_TYPES, coltypes)
			
			// ugly; todo: find a better way.
			if ( ColumnarSerDe.class.isInstance(qryOut.serDe))
			{
				qry.cfg.setInt(RCFile.COLUMN_NUMBER_CONF_STR, qryOut.columns.size())
			}
			
			qryOut.serDe.initialize(qry.cfg, props);
		}
		catch(Throwable t)
		{
			throw new WindowingException(
				sprintf("Failed to setup Output SerDe %s", tblOut.serDeClass), t)
		}
	}
	
	void setupWriter(Query qry) throws WindowingException
	{
		QueryOutput qryOut = qry.output
		TableOutput tblOut = qry.qSpec.tableOut
		try
		{
			Class<? extends RecordWriter> c = (Class<? extends RecordWriter>) Class.forName(tblOut.recordwriterClass)
			qryOut.wrtr = c.newInstance()
			qryOut.wrtr.initialize(getOutputStream(), qry.cfg);
		}
		catch(Throwable t)
		{
			throw new WindowingException(
				sprintf("Failed to setup Output Writer %s", tblOut.serDeClass), t)
		}
	}
	
	/**
	 * <ul>
	 * <li> check className specified for OutputSerDe.
	 * <li> check className specified for RecordWriter.
	 * </ul>
	 * @param qry
	 * @throws WindowingException
	 */
	void validateOutputSpec(Query qry) throws WindowingException
	{
		TableOutput tblOut = qry.qSpec.tableOut
		// validate serDeClass
		tblOut.serDeClass = (tblOut.serDeClass == null ? TableOutput.DEFAULT_SERDE_CLASS : tblOut.serDeClass)
		try
		{
			Class.forName(tblOut.serDeClass)
		}
		catch(Throwable t)
		{
			throw new WindowingException(sprintf("Unknown SerDe Class %s", tblOut.serDeClass), t)
		}
		
		// validate writer
		tblOut.recordwriterClass = (tblOut.recordwriterClass == null ? TableOutput.DEFAULT_RECORDWRITER_CLASS : tblOut.recordwriterClass)
		try
		{
			Class.forName(tblOut.recordwriterClass)
		}
		catch(Throwable t)
		{
			throw new WindowingException(
				sprintf("Unknown RecordWriter Class %s", tblOut.recordwriterClass), t)
		}
		
		// ensure user has not specified a FormatClass
		if ( tblOut.outputFormat != null )
		{
			throw new WindowingException("Illegal Output Spec: Output Format class only valid in MR mode")
		} 
		
		if ( tblOut.tableName != null )
		{
			throw new WindowingException("Illegal Output Spec: Load clause only valid in MR mode")
		}
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


