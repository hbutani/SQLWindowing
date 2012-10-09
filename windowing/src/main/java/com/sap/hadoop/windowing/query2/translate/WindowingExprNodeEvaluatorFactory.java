package com.sap.hadoop.windowing.query2.translate;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluatorFactory;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeGenericFuncDesc;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.GenericUDFLeadLag.GenericUDFLag;
import com.sap.hadoop.windowing.functions2.GenericUDFLeadLag.GenericUDFLead;

/*
 * When constructing the Evaluator Tree from an ExprNode Tree
 * - look for any descendant LeadLag Function Expressions
 * - if they are found:
 *   - add them to the LLInfo.leadLagExprs and
 *   - add a mapping from the Expr Tree root to the LLFunc Expr in LLInfo.mapTopExprToLLFunExprs
 */

public class WindowingExprNodeEvaluatorFactory
{
	public static ExprNodeEvaluator get(QueryTranslationInfo tInfo, ExprNodeDesc desc) throws WindowingException
	{
		FindLeadLagFuncExprs visitor = new FindLeadLagFuncExprs(tInfo, desc);
		new ExprNodeWalker(visitor).walk(desc);
		return ExprNodeEvaluatorFactory.get(desc);
	}
	
	public static class FindLeadLagFuncExprs extends ExprNodeVisitor
	{
		ExprNodeDesc topExpr;
		QueryTranslationInfo tInfo;
		
		FindLeadLagFuncExprs(QueryTranslationInfo tInfo, ExprNodeDesc topExpr)
		{
			this.tInfo = tInfo;
			this.topExpr = topExpr;
		}

		@Override
		public void visit(ExprNodeGenericFuncDesc fnExpr) throws WindowingException
		{
			GenericUDF fn = fnExpr.getGenericUDF();
			if (fn instanceof GenericUDFLead || fn instanceof GenericUDFLag )
			{
				tInfo.getLLInfo().addLLFuncExprForTopExpr(topExpr, fnExpr);
			}
		}
	}
	
}
