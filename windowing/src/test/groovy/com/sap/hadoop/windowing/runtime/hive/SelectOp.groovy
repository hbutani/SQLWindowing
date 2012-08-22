package com.sap.hadoop.windowing.runtime.hive

import java.util.List;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluatorFactory;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.SelectDesc;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

class SelectOp
{
	ObjectInspector inOI
	protected transient ExprNodeEvaluator[] eval;
	transient Object[] output;
	ObjectInspector outOI
	
	protected void initialize(SelectDesc conf, ObjectInspector inOI) throws HiveException
	{
		this.inOI = inOI
		ArrayList<ExprNodeDesc> colList = conf.getColList();
		eval = new ExprNodeEvaluator[colList.size()];
		for (int i = 0; i < colList.size(); i++)
		{
			assert (colList.get(i) != null);
			eval[i] = ExprNodeEvaluatorFactory.get(colList.get(i));
		}

		output = new Object[eval.length];

		outOI = initEvaluatorsAndReturnStruct(eval, conf	.getOutputColumnNames(), inOI);
	}
	
	protected static StructObjectInspector initEvaluatorsAndReturnStruct(ExprNodeEvaluator[] evals, List<String> outputColName, ObjectInspector rowInspector) throws HiveException
	{
		ObjectInspector[] fieldObjectInspectors = initEvaluators(evals, rowInspector);
		return ObjectInspectorFactory.getStandardStructObjectInspector(outputColName, Arrays.asList(fieldObjectInspectors));
	}
		
	protected static ObjectInspector[] initEvaluators(ExprNodeEvaluator[] evals, ObjectInspector rowInspector) throws HiveException
	{
		ObjectInspector[] result = new ObjectInspector[evals.length];
		for (int i = 0; i < evals.length; i++)
		{
			result[i] = evals[i].initialize(rowInspector);
		}
		return result;
	}
		
	public void process(Object row) throws HiveException
	{
		for (int i = 0; i < eval.length; i++) {
			try
			{
			  output[i] = eval[i].evaluate(row);
			}
			catch (HiveException e) {
			  throw e;
			}
			catch (RuntimeException e) {
			  throw new HiveException("Error evaluating "
				  + conf.getColList().get(i).getExprString(), e);
			}
		}
	}

}
