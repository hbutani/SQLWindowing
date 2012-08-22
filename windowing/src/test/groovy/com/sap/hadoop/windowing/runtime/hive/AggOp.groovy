package com.sap.hadoop.windowing.runtime.hive

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.query2.specification.WindowFunctionSpec;

class AggDesc
{
	ArrayList<WindowFunctionSpec> funcSpecs;
	ArrayList<String> columnNames;
}

class AggOp
{
	EvalContext eCtx;
	ObjectInspector inOI
	protected transient AggFunc[] funcs;
	transient Object[] output;
	ObjectInspector outOI
	
	protected void initialize(AggDesc desc, ObjectInspector inOI) throws HiveException
	{
		this.inOI = inOI
		funcs = new AggFunc[desc.funcSpecs.size()];
		
		for (int i = 0; i < desc.funcSpecs.size(); i++) 
		{
		  assert (desc.funcSpecs.get(i) != null);
		  funcs[i] = new AggFunc(eCtx : eCtx, funcSpec : desc.funcSpecs[i] )
		  funcs[i].setupFunction()
		  funcs[i].setupArgExprNodes()
		  funcs[i].setupEvaluator()
		  funcs[i].setupArgExprEvaluators();
		  funcs[i].setupFunctionArgOutput();
		  funcs[i].initEvaluators(inOI)
		}
	
		output = new Object[funcs.length];
		outOI = initEvaluatorsAndReturnStruct(funcs, desc.columnNames, inOI);
	}
	
	public void startAggregation() throws HiveException
	{
		for (int i = 0; i < funcs.length; i++) 
		{
			funcs[i].startAgg()
		}
	}
	
	public void process(Object row) throws HiveException
	{
		for (int i = 0; i < funcs.length; i++) 
		{
			funcs[i].process(row);
		}
	}
	
	public void finishAggregation() throws HiveException
	{
		for (int i = 0; i < funcs.length; i++)
		{
			output[i] = funcs[i].finishAgg()
		}
	}
	
	protected static StructObjectInspector initEvaluatorsAndReturnStruct(AggFunc[] funcs, List<String> outputColName, ObjectInspector rowInspector) throws HiveException
	{
		ObjectInspector[] fieldObjectInspectors = initFuncEvaluators(funcs, rowInspector);
		return ObjectInspectorFactory.getStandardStructObjectInspector(outputColName, Arrays.asList(fieldObjectInspectors));
	}
		
	protected static ObjectInspector[] initFuncEvaluators(AggFunc[] funcs, ObjectInspector  OI) throws HiveException
	{
		ObjectInspector[] funcOIs = new ObjectInspector[funcs.length];
		int i = 0;
		for(AggFunc f : funcs)
		{
			f.initEvaluators(OI)
			funcOIs[i++] = f.OI
		}
		return funcOIs
	}
}


