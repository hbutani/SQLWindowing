package com.sap.hadoop.windowing.query2.definition;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

import com.sap.hadoop.Utils;

public class WhereDef
{
	ASTNode expression;
	ExprNodeDesc exprNode;
	transient ExprNodeEvaluator exprEvaluator;
	transient ObjectInspector OI;
	
	static{
		Utils.makeTransient(WhereDef.class, "exprEvaluator");
		Utils.makeTransient(WhereDef.class, "OI");
	}

	public WhereDef(){}
	
	public ASTNode getExpression()
	{
		return expression;
	}
	
	public void setExpression(ASTNode expression)
	{
		this.expression = expression;
	}
	
	public ExprNodeDesc getExprNode()
	{
		return exprNode;
	}
	
	public void setExprNode(ExprNodeDesc exprNode)
	{
		this.exprNode = exprNode;
	}
	
	public ExprNodeEvaluator getExprEvaluator()
	{
		return exprEvaluator;
	}
	
	public void setExprEvaluator(ExprNodeEvaluator exprEvaluator)
	{
		this.exprEvaluator = exprEvaluator;
	}
	
	public ObjectInspector getOI()
	{
		return OI;
	}
	
	public void setOI(ObjectInspector oI)
	{
		OI = oI;
	}
}
