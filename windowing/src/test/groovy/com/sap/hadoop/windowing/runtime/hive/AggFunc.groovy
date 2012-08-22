package com.sap.hadoop.windowing.runtime.hive

import java.util.ArrayList;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluatorFactory;
import org.apache.hadoop.hive.ql.exec.FunctionRegistry;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.WindowingTypeCheckProcFactory;
import com.sap.hadoop.windowing.query2.specification.WindowFunctionSpec;

class AggFunc
{
	EvalContext eCtx;
	String name;
	boolean isDistinct;
	boolean isAllColumns;
	GenericUDAFEvaluator funcEvaluator;
	WindowFunctionSpec funcSpec;
	
	ExprNodeDesc[] funcArgNodes;
	ExprNodeEvaluator[] funcArgEvaluators;
	Object[] funcArgVals;
	
	ObjectInspector[] funcArgOIs;
	ObjectInspector OI;
	
	AggregationBuffer aggBuffer;
	
	void setupFunction()
	{
		name = funcSpec.name
		isDistinct = funcSpec.isDistinct
		isAllColumns = funcSpec.isStar
	}
	
	void setupArgExprNodes()
	{
		// Convert children to aggParameters
		ArrayList<ExprNodeDesc> aggParameters = new ArrayList<ExprNodeDesc>();
		HashMap<Node, Object> map;
		for (int i = 0; i < funcSpec.getArgs().size(); i++) 
		{
		  ASTNode paraExpr = (ASTNode) funcSpec.args[i];
		  map = WindowingTypeCheckProcFactory.genExprNode(paraExpr, eCtx.typeChkCtx)
		  aggParameters.add(map.get(paraExpr))
		}
		funcArgNodes = aggParameters.toArray(new ExprNodeDesc[aggParameters.size()])
	}
	
	void setupEvaluator() throws WindowingException
	{
		ArrayList<ObjectInspector> originalParameterTypeInfos = 	getWritableObjectInspector(funcArgNodes);
		funcEvaluator = FunctionRegistry.getGenericUDAFEvaluator(name, originalParameterTypeInfos, isDistinct, isAllColumns);
		if (null == funcEvaluator) {
			String reason = "Looking for UDAF Evaluator\"" + name 	+ "\" with parameters " + originalParameterTypeInfos;
			throw new WindowingException(reason);
		}
	}
	
	void setupArgExprEvaluators()
	{
		funcArgEvaluators = new ExprNodeEvaluator[funcArgNodes.length];
		for(int i=0; i < funcArgNodes.length; i++)
		{
			funcArgEvaluators[i] = ExprNodeEvaluatorFactory.get(funcArgNodes[i]);
		}
	}
	
	void setupFunctionArgOutput()
	{
		funcArgVals = new Object[funcArgNodes.length];
	}
	
	void initEvaluators(ObjectInspector inOI) throws HiveException
	{
		if (funcArgNodes != null )
		{
			funcArgOIs = new ObjectInspector[funcArgNodes.length];
			int i = 0;
			for(ExprNodeEvaluator funcArgEval : funcArgEvaluators)
			{
				funcArgOIs[i++] = funcArgEval.initialize(inOI);
			}
		}
		
		OI = funcEvaluator.init(GenericUDAFEvaluator.Mode.COMPLETE, funcArgOIs)
	}
	
	void startAgg()
	{
		aggBuffer = funcEvaluator.getNewAggregationBuffer()
	}
	
	void process(Object row) throws HiveException
	{
		for(int i=0; i < funcArgEvaluators.length; i++) processArg(i, row);
		funcEvaluator.aggregate(aggBuffer, funcArgVals)
	}
	
	Object finishAgg()
	{
		return funcEvaluator.evaluate(aggBuffer);
	}
	
	private void processArg(int i, Object row)
	{
		try
		{
			funcArgVals[i] = funcArgEvaluators[i].evaluate(row);
		}
		catch (HiveException e) 
		{
			throw e;
		}
		catch (RuntimeException e) 
		{
			throw new HiveException("Error evaluating " 	+ funcArgNodes[i].getExprString(), e);
		}
	}
	
	static ArrayList<ObjectInspector> getWritableObjectInspector(ExprNodeDesc[] exprNodes)
	{
		ArrayList<ObjectInspector> result = new ArrayList<ObjectInspector>();
		for (ExprNodeDesc expr : exprNodes)
		{
			result.add(expr.getWritableObjectInspector());
		}
		return result;
	}
	
}
