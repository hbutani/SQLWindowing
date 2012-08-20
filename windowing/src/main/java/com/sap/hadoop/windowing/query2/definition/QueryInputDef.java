package com.sap.hadoop.windowing.query2.definition;

import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.query2.specification.QueryInputSpec;

public class QueryInputDef
{
	QueryInputSpec inputSpec;
	WindowDef window;
	StructObjectInspector OI;
	
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

	public StructObjectInspector getOI()
	{
		return OI;
	}

	public void setOI(StructObjectInspector oI)
	{
		OI = oI;
	}
	
}
