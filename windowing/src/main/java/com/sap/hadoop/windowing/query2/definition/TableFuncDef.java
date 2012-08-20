package com.sap.hadoop.windowing.query2.definition;

import java.util.ArrayList;

import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;

import com.sap.hadoop.windowing.query2.specification.TableFuncSpec;

public class TableFuncDef extends QueryInputDef
{
	ArrayList<ExprNodeDesc> argExprNodes;
	QueryInputDef input;
	
	public TableFuncSpec getTableFuncSpec()
	{
		return (TableFuncSpec) inputSpec;
	}

	public ArrayList<ExprNodeDesc> getArgExprNodes()
	{
		return argExprNodes;
	}

	public void setArgExprNodes(ArrayList<ExprNodeDesc> argExprNodes)
	{
		this.argExprNodes = argExprNodes;
	}

	public QueryInputDef getInput()
	{
		return input;
	}

	public void setInput(QueryInputDef input)
	{
		this.input = input;
	}
}
