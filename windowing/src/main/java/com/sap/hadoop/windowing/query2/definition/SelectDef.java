package com.sap.hadoop.windowing.query2.definition;

import java.util.ArrayList;

import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;

import com.sap.hadoop.windowing.query2.specification.SelectSpec;

public class SelectDef
{
	SelectSpec selectSpec;
	ArrayList<WindowFunctionDef> windowFuncs;
	ArrayList<ExprNodeDesc> exprNodes;
	
	public SelectSpec getSelectSpec()
	{
		return selectSpec;
	}
	
	public void setSelectSpec(SelectSpec selectSpec)
	{
		this.selectSpec = selectSpec;
	}
	
	public ArrayList<WindowFunctionDef> getWindowFuncs()
	{
		return windowFuncs;
	}
	
	public void setWindowFuncs(ArrayList<WindowFunctionDef> windowFuncs)
	{
		this.windowFuncs = windowFuncs;
	}
	
	public ArrayList<ExprNodeDesc> getExprNodes()
	{
		return exprNodes;
	}
	
	public void setExprNodes(ArrayList<ExprNodeDesc> exprNodes)
	{
		this.exprNodes = exprNodes;
	}
	
}
