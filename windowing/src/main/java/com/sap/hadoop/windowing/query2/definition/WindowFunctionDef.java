package com.sap.hadoop.windowing.query2.definition;

import java.util.ArrayList;

import com.sap.hadoop.windowing.query2.specification.WindowFunctionSpec;

public class WindowFunctionDef
{
	WindowFunctionSpec wSpec;
	ArrayList<WindowDef> argNodes;
	WindowDef window;
	
	public WindowFunctionSpec getSpec()
	{
		return wSpec;
	}
	
	public void setSpec(WindowFunctionSpec wSpec)
	{
		this.wSpec = wSpec;
	}
	
	public ArrayList<WindowDef> getArgNodes()
	{
		return argNodes;
	}
	
	public void setArgNodes(ArrayList<WindowDef> exprNodes)
	{
		this.argNodes = exprNodes;
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
