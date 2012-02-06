package com.sap.hadoop.windowing.functions

import java.util.Map;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;

import java.util.ArrayList;

import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
import com.sap.hadoop.windowing.query.Column;
import com.sap.hadoop.windowing.query.FuncArg;
import com.sap.hadoop.windowing.query.FuncSpec;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.runtime.ArgType;
import com.sap.hadoop.windowing.runtime.IPartitionIterator;
import com.sap.hadoop.windowing.runtime.OutputObj;
import com.sap.hadoop.windowing.runtime.Partition;
import com.sap.hadoop.windowing.runtime.Partitioner;
import com.sap.hadoop.windowing.runtime.Row;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.runtime.IPartition;


class WindowingTableFunction extends AbstractTableFunction
{
	Query qry
	ArrayList<IWindowFunction> wnFns
	ArrayList<String> wnAliases
	
	WindowingTableFunction(Query qry)
	{
		this.qry = qry
		wnFns = qry.wnFns
		wnAliases = qry.wnAliases
	}
	
	protected IPartition execute(IPartition inpPart) throws WindowingException
	{
		OutputPartition op = new OutputPartition(inpPart)
		OutputObj orow = op.getRowObject();
		for (i in 0..<wnFns.size())
		{
			orow.resultMap[wnAliases[i]] = wnFns[i].processPartition(inpPart)
		}
		return op;
	}
	
	Map<String, TypeInfo> getOutputShape()
	{
		Map m = new HashMap<String, TypeInfo>();
		for(int i in 0..<qry.wnAliases.size())
		{
			FuncSpec fSpec = qry.qSpec.funcSpecs[i]
			m.put(qry.wnAliases[i], inferType(i, fSpec))
		}
		return m
	}
	
	/*
	 * use functions specified type or the fn's predetermined type or the 1st args type if it is an identifier
	 */
	TypeInfo inferType(int i, FuncSpec fSpec)
	{
		if ( fSpec.typeName)
		{
			return TypeInfoFactory.getPrimitiveTypeInfo(fSpec.typeName)
		}
		Class<? extends IWindowFunction> fCls = qry.wnFns[i].class
		FunctionDef fDef = fCls.getAnnotation(FunctionDef.class);
		if ( fDef.typeName() )
		{
			return TypeInfoFactory.getPrimitiveTypeInfo(fDef.typeName())
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
						return ic.typeInfo
					}
				}
			}
		}
		//3. for now assume type is 'double'. (revisit: analyze groovy expressions to infer type)
		return TypeInfoFactory.getPrimitiveTypeInfo('double')
	}
}

class OutputPartition extends IPartition
{
	Partition inputPartition
	OutputObj outObj
	
	OutputPartition(Partition p)
	{
		inputPartition = p
		outObj = new OutputObj();
		outObj.p = p
		outObj.resultMap = [:]
	}
	
	Row getAt(i)
	{
		outObj.iObj = inputPartition[i];
		return outObj;
	}
	int size() { return inputPartition.size();}
	Row getRowObject() { return outObj; }
}
