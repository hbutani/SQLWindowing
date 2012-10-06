package com.sap.hadoop.windowing.query2.translate;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorConverters;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.WhereDef;
import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo.InputInfo;

public class WhereTranslation
{
	public static void translate(QueryDef qDef) throws WindowingException
	{
		QueryTranslationInfo tInfo = qDef.getTranslationInfo();
		QuerySpec spec = qDef.getSpec();
		
		ASTNode wExpr = spec.getWhereExpr();
		
		if ( wExpr == null ) return;
		
		WhereDef whDef = new WhereDef();
		whDef.setExpression(wExpr);
		
		QueryInputDef iDef = qDef.getInput();
		InputInfo iInfo = tInfo.getInputInfo(iDef);
		
		ExprNodeDesc exprNode = TranslateUtils.buildExprNode(wExpr, iInfo.getTypeCheckCtx());
		ExprNodeEvaluator exprEval = WindowingExprNodeEvaluatorFactory.get(tInfo, exprNode);
		ObjectInspector oi = TranslateUtils.initExprNodeEvaluator(exprEval, iInfo);
		
		try
		{
			ObjectInspectorConverters.getConverter(oi, PrimitiveObjectInspectorFactory.javaBooleanObjectInspector);
		}
		catch(Throwable t)
		{
			throw new WindowingException("Where Expr must be convertible to a boolean value", t);
		}
		
		whDef.setExprNode(exprNode);
		whDef.setExprEvaluator(exprEval);
		whDef.setOI(oi);
		
		qDef.setWhere(whDef);
	}
}
