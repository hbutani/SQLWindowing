package com.sap.hadoop.windowing.functions

import groovy.lang.Script;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions.annotations.ArgDef;
import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
import com.sap.hadoop.windowing.query.Column;
import com.sap.hadoop.windowing.query.FuncArg;
import com.sap.hadoop.windowing.query.FuncSpec;
import com.sap.hadoop.windowing.query.OrderColumn;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QuerySpec;
import com.sap.hadoop.windowing.query.Window;
import com.sap.hadoop.windowing.runtime.ArgType;
import com.sap.hadoop.windowing.runtime.Utils;


class FunctionTranslator
{	
	IWindowFunction create(Class<? extends IWindowFunction> fnClass, Query qry, FuncSpec funSpec) throws WindowingException
	{
		QuerySpec qSpec = qry.qSpec
		try
		{
			IWindowFunction wFn = fnClass.newInstance();
			wFn.orderColumns = (OrderColumn[]) qSpec.tableIn.orderColumns
			wFn.setWindow(funSpec.window)
			return wFn
		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
		
	}
	
	AbstractTableFunction createTableFunction(Class<? extends AbstractTableFunction> fnClass, Query qry, FuncSpec funSpec) throws WindowingException
	{
		QuerySpec qSpec = qry.qSpec
		try
		{
			AbstractTableFunction wFn = fnClass.newInstance();
			wFn.setWindow(funSpec.window)
			return wFn
		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
		
	}
	
	IWindowFunction translate(GroovyShell wshell, Query qry, FuncSpec funcSpec) throws WindowingException
	{
		Class<IWindowFunction> cls = FunctionRegistry.FUNCTION_MAP[funcSpec.name];
		if (!cls)
		{
			throw new WindowingException(sprintf("Unknown function %s", funcSpec.name))
		}
		FunctionDef fDef = cls.getAnnotation(FunctionDef.class);

		//Check window spec
		if ( !fDef.supportsWindow() && funcSpec.window)
		{
			throw new WindowingException(sprintf("Function %s doesn't support Windowing specification", funcSpec.name));
		}
		if ( funcSpec.window) {
			funcSpec.window.parse(wshell)
			int cmp = funcSpec.window.start.compare(funcSpec.window.end);
			if ( cmp > 0 ) {
				throw new WindowingException(sprintf("Window range invalid: %s", funcSpec));
			}
		}

		IWindowFunction wFn = create(cls, qry, funcSpec);
		ArgDef[] args = fDef.args();
		
		for(int i=0; i < args.size(); i++)
		{
			if ( !args[i].optional() && i >= funcSpec.params.size())
			{
				throw new WindowingException(sprintf("Function %s missing required arg %s", funcSpec, args[i].name()));
			}
			if ( !args[i].optional() || i < funcSpec.params.size())
			{
				applyArg(wshell, qry, funcSpec, funcSpec.params[i], args[i], wFn)
			}
		}
		
		return wFn;
	}
	
	AbstractTableFunction translateTableFunction(GroovyShell wshell, Query qry, FuncSpec funcSpec) throws WindowingException
	{
		Class<? extends AbstractTableFunction> cls = FunctionRegistry.TABLEFUNCTION_MAP[funcSpec.name];
		if (!cls)
		{
			throw new WindowingException(sprintf("Unknown function %s", funcSpec.name))
		}
		FunctionDef fDef = cls.getAnnotation(FunctionDef.class);

		//Check window spec
		if ( !fDef.supportsWindow() && funcSpec.window)
		{
			throw new WindowingException(sprintf("Function %s doesn't support Windowing specification", funcSpec.name));
		}
		if ( funcSpec.window) {
			funcSpec.window.parse(wshell)
			int cmp = funcSpec.window.start.compare(funcSpec.window.end);
			if ( cmp > 0 ) {
				throw new WindowingException(sprintf("Window range invalid: %s", funcSpec));
			}
		}

		AbstractTableFunction wFn = createTableFunction(cls, qry, funcSpec);
		ArgDef[] args = fDef.args();
		
		for(int i=0; i < args.size(); i++)
		{
			if ( !args[i].optional() && i >= funcSpec.params.size())
			{
				throw new WindowingException(sprintf("Function %s missing required arg %s", funcSpec, args[i].name()));
			}
			if ( !args[i].optional() || i < funcSpec.params.size())
			{
				applyArg(wshell, qry, funcSpec, funcSpec.params[i], args[i], wFn)
			}
		}
		
		return wFn;
	}
	
	void applyArg(GroovyShell wshell, Query qry, FuncSpec funSpec, FuncArg arg, ArgDef argDef, IWindowFunction wFn) throws WindowingException
	{
		if ( !(arg.argType in argDef.argTypes()) )
		{
			throw new WindowingException(sprintf("Function %s: arg error(%s) argType not supported for arg", funSpec.name, arg))
		}
		def v = evaluateArg(wshell, qry, arg, argDef)
		def fName = argDef.name()
		wFn."$fName" = v
	}
	
	Object evaluateArg(GroovyShell wshell, Query qry, FuncArg arg, ArgDef argDef) throws WindowingException
	{
		String typeName = argDef.typeName()
		switch(typeName)
		{
			case "script":
			switch(arg.argType)
			{
				case ArgType.STRING:
					return wshell.parse(arg.str)
				case ArgType.SCRIPT:
					return wshell.parse(arg.expr)
				case ArgType.ID:
					validateIdentifier(qry, arg.id)
					return wshell.parse(arg.id)
				case ArgType.NUMBER:
					return wshell.parse(arg.iVal.toString())
			}
			default:
			switch(arg.argType)
			{
				case ArgType.STRING:
					return Utils.parseStr(typeName, arg.str)
				case ArgType.SCRIPT:
					return Utils.evaluate(wshell, arg.expr, typeName)
				case ArgType.ID:
					return Utils.evaluate(wshell, arg.id, typeName)
				case ArgType.NUMBER:
					return Utils.parseStr(typeName, arg.iVal.toString())
			}
		}
	}
	
	void validateIdentifier(Query qry, String id) throws WindowingException
	{
		for (Column ic in qry.input.columns)
		{
			if (id == ic.name)
			{
				return;
			}
		}
		throw new WindowingException(sprintf("Unknown identifier %s", id))
	}
	
}
