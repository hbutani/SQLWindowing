package com.sap.hadoop.windowing.query2.translate;

import java.util.List;

import org.apache.hadoop.hive.ql.plan.ExprNodeColumnDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeConstantDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeFieldDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeGenericFuncDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeNullDesc;

import com.sap.hadoop.windowing.WindowingException;

public class ExprNodeWalker
{
	ExprNodeVisitor visitor;
	
	public ExprNodeWalker(ExprNodeVisitor visitor)
	{
		super();
		this.visitor = visitor;
	}
	
	public void walk(ExprNodeDesc e) throws WindowingException
	{
		if ( e == null ) return;
		List<ExprNodeDesc>  children = e.getChildren();
		if ( children != null )
		{
			for(ExprNodeDesc child : children)
			{
				walk(child);
			}
		}
		
		if ( e instanceof ExprNodeColumnDesc)
		{
			walk((ExprNodeColumnDesc) e);
		}
		else if ( e instanceof ExprNodeConstantDesc)
		{
			walk((ExprNodeConstantDesc) e);
		}
		else if ( e instanceof ExprNodeFieldDesc)
		{
			walk((ExprNodeFieldDesc) e);
		}
		else if ( e instanceof ExprNodeGenericFuncDesc)
		{
			walk((ExprNodeGenericFuncDesc) e);
		}
		else if ( e instanceof ExprNodeNullDesc)
		{
			walk((ExprNodeNullDesc) e);
		}
		else
		{
			throw new WindowingException("Unknown Expr Type " + e.getClass().getName());
		}
	}

	private void walk(ExprNodeColumnDesc e) throws WindowingException
	{
		visitor.visit(e);
	}
	
	private void walk(ExprNodeConstantDesc e) throws WindowingException
	{
		visitor.visit(e);
	}
	
	private void walk(ExprNodeFieldDesc e) throws WindowingException
	{
		visitor.visit(e);
	}
	
	private void walk(ExprNodeGenericFuncDesc e) throws WindowingException
	{
		visitor.visit(e);
	}
	
	private void walk(ExprNodeNullDesc e) throws WindowingException
	{
		visitor.visit(e);
	}
}
