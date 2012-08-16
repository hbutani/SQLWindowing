package com.sap.hadoop.windowing.query2.definition;

import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;

import com.sap.hadoop.windowing.query2.specification.ColumnSpec;

/*
 * represents a Column reference in a Partition or Order Spec or an Expr in the SelectSpec.
 */
public class ColumnDef
{
	/*
	 * non-null if this is a Column reference in a Partition or Order Spec.
	 */
	ColumnSpec colSpec;
	
	String alias;
	
	ASTNode expression;
	ExprNodeDesc exprNode;
	
	StructField field;
	ObjectInspector OI;
	
	public ColumnSpec getColSpec()
	{
		return colSpec;
	}
	
	public void setColSpec(ColumnSpec colSpec)
	{
		this.colSpec = colSpec;
		setAlias(colSpec.getColumnName());
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
	
	public StructField getField()
	{
		return field;
	}
	
	public void setField(StructField field)
	{
		this.field = field;
		this.OI = field.getFieldObjectInspector();
	}
	
	public ObjectInspector getOI()
	{
		return OI;
	}
	
	public void setOI(ObjectInspector oI)
	{
		OI = oI;
		this.field = null;
	}

}
