package com.sap.hadoop.windowing.query2.definition;

import java.util.ArrayList;

import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.query2.specification.HiveTableSpec;
import com.sap.hadoop.windowing.query2.specification.TableFuncSpec;

public class TableFuncDef extends QueryInputDef
{
	ArrayList<ArgDef> args;
	QueryInputDef input;
	TableFunctionEvaluator tFunction;
	ObjectInspector mapOI;
	
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
		return getTableFuncSpec().getName();
	}

	public TableFunctionEvaluator getFunction()
	{
		return tFunction;
	}

	public void setFunction(TableFunctionEvaluator tFunction)
	{
		this.tFunction = tFunction;
	}
	
	public HiveTableSpec getHiveTableSpec()
	{
		return input.getHiveTableSpec();
	}

	public ObjectInspector getMapOI()
	{
		return mapOI;
	}

	public void setMapOI(ObjectInspector mapOI)
	{
		this.mapOI = mapOI;
	}

	@Override
	public HiveTableDef getHiveTableDef() {
		return input.getHiveTableDef();
	}
}
