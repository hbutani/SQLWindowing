package com.sap.hadoop.windowing.query2.definition;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

import com.sap.hadoop.windowing.query2.specification.ColumnSpec;

/*
 * represents a Column reference in a Partition or Order Spec or an Expr in the SelectSpec.
 */
public class ColumnDef
{
	/*
	 * non-null if this is a Column reference in a Partition or Order Spec.
	 */
	ColumnSpec spec;
	
	String alias;
	
	ASTNode expression;
	ExprNodeDesc exprNode;
	transient ExprNodeEvaluator exprEvaluator;
	transient ObjectInspector OI;
	
	public ColumnDef(){
		
	}
	
	public ColumnDef(ColumnSpec spec)
	{
		this.spec = spec;
	}
	
	public ColumnDef(ColumnDef cDef)
	{
		spec = cDef.getSpec();
		alias = cDef.getAlias();
		expression = cDef.getExpression();
		exprNode = cDef.getExprNode();
		exprEvaluator = cDef.getExprEvaluator();
		OI = cDef.getOI();
	}
	
	public void setSpec(ColumnSpec spec) {
		this.spec = spec;
	}

	public ColumnSpec getSpec()
	{
		return spec;
	}
	
	public String getAlias()
	{
		return alias;
	}
	
	public void setAlias(String alias)
	{
		this.alias = alias;
	}
	
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
	
	public ObjectInspector getOI()
	{
		return OI;
	}
	
	public void setOI(ObjectInspector oI)
	{
		OI = oI;
	}

	public ExprNodeEvaluator getExprEvaluator()
	{
		return exprEvaluator;
	}

	public void setExprEvaluator(ExprNodeEvaluator exprEvaluator)
	{
		this.exprEvaluator = exprEvaluator;
	}

}
