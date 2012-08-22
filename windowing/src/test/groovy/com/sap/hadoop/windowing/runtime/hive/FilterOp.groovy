package com.sap.hadoop.windowing.runtime.hive

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluatorFactory;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;

class FilterOp
{
	ExprNodeEvaluator conditionEvaluator;
	PrimitiveObjectInspector outOI
	Boolean output
	
	protected void initialize(ExprNodeDesc predicate, ObjectInspector inOI) throws HiveException
	{
		try
		{
		  conditionEvaluator = ExprNodeEvaluatorFactory.get(predicate);
		  outOI = (PrimitiveObjectInspector) conditionEvaluator.initialize(inOI);
		}
		catch (Throwable e)
		{
		  throw new HiveException(e);
		}
	}
	
	public void process(Object row) throws HiveException
	{
		Object condition = conditionEvaluator.evaluate(row);
		output = (Boolean) outOI.getPrimitiveJavaObject(condition);
	}

}
