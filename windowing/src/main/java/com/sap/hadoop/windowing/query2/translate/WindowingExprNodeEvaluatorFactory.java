package com.sap.hadoop.windowing.query2.translate;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluatorFactory;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeGenericFuncDesc;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;

import com.sap.hadoop.windowing.functions2.GenericUDFLeadLag;

/*
 * when translating lead/lag Functions. 
 * - Hold on to them in QueryTranslationInfo.
 * - On the GenericUDFLeadLag object set a ExprNodeEvaluator
 *   - for this is a new ExprNodeEvaluator based on the 1st argument ExprNodeDesc
 *   - this means that the Lead/Lag expression is evaluated both for the current row and again for the correct row.
 *   - this is because no easy way to get to the children/defferedChildren instance variables on ExprNodeGenericFuncEvaluator
 *   - fixing this behavior requires extending ExprNodeGenericFuncEvaluator and reimplementing all methods
 *   - don't want to do this.
 *   - Todo(if possible): ask Hive guys to allow get/set on instance vars. 
 */

public class WindowingExprNodeEvaluatorFactory
{
	public static ExprNodeEvaluator get(QueryTranslationInfo tInfo,
			ExprNodeDesc desc)
	{
		if (desc instanceof ExprNodeGenericFuncDesc)
		{
			ExprNodeGenericFuncDesc fnDesc = (ExprNodeGenericFuncDesc) desc;
			GenericUDF fn = fnDesc.getGenericUDF();
			if (fn instanceof GenericUDFLeadLag)
			{
				GenericUDFLeadLag leadLagFn = (GenericUDFLeadLag) fn;
				tInfo.addLeadLagFunction(leadLagFn);
				ExprNodeDesc arg1 = fnDesc.getChildren().get(0);
				ExprNodeEvaluator arg1Eval = ExprNodeEvaluatorFactory.get(arg1);
				leadLagFn.setArgEvaluator(arg1Eval);
			}
		}
		return ExprNodeEvaluatorFactory.get(desc);
	}
	
}
