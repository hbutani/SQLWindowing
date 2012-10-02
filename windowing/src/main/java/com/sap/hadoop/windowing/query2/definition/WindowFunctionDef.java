package com.sap.hadoop.windowing.query2.definition;

import java.util.ArrayList;

import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

import com.sap.hadoop.windowing.query2.specification.WindowFunctionSpec;

public class WindowFunctionDef
{
	WindowFunctionSpec wSpec;
	ArrayList<ArgDef> args;
	WindowDef window;
	transient GenericUDAFEvaluator wFnEval;
	transient ObjectInspector OI;
	
	public WindowFunctionDef(){
		
	}
	
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

	public void addArg(ArgDef arg)
	{
		args = args == null ? new ArrayList<ArgDef>() : args;
		args.add(arg);
	}

	public WindowDef getWindow()
	{
		return window;
	}
	
	public void setWindow(WindowDef window)
	{
		this.window = window;
	}

	public GenericUDAFEvaluator getEvaluator()
	{
		return wFnEval;
	}

	public void setEvaluator(GenericUDAFEvaluator wFnEval)
	{
		this.wFnEval = wFnEval;
	}

	public ObjectInspector getOI()
	{
		return OI;
	}

	public void setOI(ObjectInspector oI)
	{
		OI = oI;
	}
	
}
