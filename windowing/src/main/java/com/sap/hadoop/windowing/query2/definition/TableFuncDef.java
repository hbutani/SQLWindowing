package com.sap.hadoop.windowing.query2.definition;

import java.util.ArrayList;

import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.functions2.TableFunctionResolver;
import com.sap.hadoop.windowing.query2.specification.TableFuncSpec;

public class TableFuncDef extends QueryInputDef
{
	String name;
	ArrayList<ArgDef> args;
	QueryInputDef input;
	TableFunctionResolver tFunction;
	TableFunctionEvaluator tEvaluator;
	
	public TableFuncSpec getTableFuncSpec()
	{
		return (TableFuncSpec) inputSpec;
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

	public QueryInputDef getInput()
	{
		return input;
	}

	public void setInput(QueryInputDef input)
	{
		this.input = input;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public TableFunctionResolver getFunction()
	{
		return tFunction;
	}

	public void setFunction(TableFunctionResolver tFunction)
	{
		this.tFunction = tFunction;
	}

	public TableFunctionEvaluator getEvaluator()
	{
		return tEvaluator;
	}

	public void setEvaluator(TableFunctionEvaluator tEvaluator)
	{
		this.tEvaluator = tEvaluator;
	}
	
}
