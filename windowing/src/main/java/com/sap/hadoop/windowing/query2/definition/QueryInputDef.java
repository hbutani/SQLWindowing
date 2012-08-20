package com.sap.hadoop.windowing.query2.definition;

import com.sap.hadoop.windowing.query2.specification.QueryInputSpec;

public class QueryInputDef
{
	QueryInputSpec inputSpec;
	WindowDef window;
	
	public QueryInputSpec getSpec()
	{
		return inputSpec;
	}
	
	public void setSpec(QueryInputSpec inputSpec)
	{
		this.inputSpec = inputSpec;
	}
	
	public WindowDef getWindow()
	{
		return window;
	}
	
	public void setWindow(WindowDef window)
	{
		this.window = window;
	}
	
}
