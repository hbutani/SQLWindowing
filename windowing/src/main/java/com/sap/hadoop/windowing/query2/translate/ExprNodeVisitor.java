package com.sap.hadoop.windowing.query2.translate;

import org.apache.hadoop.hive.ql.plan.ExprNodeColumnDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeConstantDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeFieldDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeGenericFuncDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeNullDesc;

import com.sap.hadoop.windowing.WindowingException;

public class ExprNodeVisitor
{
	public void visit(ExprNodeColumnDesc e) throws WindowingException
	{
	}
	
	public void visit(ExprNodeConstantDesc e) throws WindowingException
	{
	}
	
	public void visit(ExprNodeFieldDesc e) throws WindowingException
	{
	}
	
	public void visit(ExprNodeGenericFuncDesc e) throws WindowingException
	{
	}
	
	public void visit(ExprNodeNullDesc e) throws WindowingException
	{
	}
}
