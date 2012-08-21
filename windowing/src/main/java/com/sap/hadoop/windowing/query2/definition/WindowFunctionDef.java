package com.sap.hadoop.windowing.query2.definition;

import java.util.ArrayList;

import com.sap.hadoop.windowing.query2.specification.WindowFunctionSpec;

public class WindowFunctionDef
{
	WindowFunctionSpec wSpec;
	ArrayList<ArgDef> args;
	WindowDef window;
	
	public WindowFunctionSpec getSpec()
	{
		return wSpec;
	}
	
	public void setSpec(WindowFunctionSpec wSpec)
	{
		this.wSpec = wSpec;
	}
		
	public ArrayList<ArgDef> getArgs()
	{
		return args;
	}

	public void setArgs(ArrayList<ArgDef> args)
	{
		this.args = args;
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
