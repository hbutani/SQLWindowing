package com.sap.hadoop.windowing.query2.translate;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluatorFactory;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeGenericFuncDesc;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;

import com.sap.hadoop.windowing.functions2.GenericUDFLeadLag;

/*
 * when translating lead/lag Functions. Hold on to them in QueryTranslationInfo.
 */

public class WindowingExprNodeEvaluatorFactory
{
	public static ExprNodeEvaluator get(QueryTranslationInfo tInfo, ExprNodeDesc desc) 
	{
	    if (desc instanceof ExprNodeGenericFuncDesc) 
	    {
	    	ExprNodeGenericFuncDesc fnDesc = (ExprNodeGenericFuncDesc) desc;
	    	GenericUDF fn = fnDesc.getGenericUDF();
	    	if ( fn instanceof GenericUDFLeadLag)
	    	{
	    		tInfo.addLeadLagFunction((GenericUDFLeadLag)fn);
	    	}
	    }
	    return ExprNodeEvaluatorFactory.get(desc);
	  }
}
