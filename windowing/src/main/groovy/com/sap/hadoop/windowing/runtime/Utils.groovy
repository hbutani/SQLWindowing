package com.sap.hadoop.windowing.runtime

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query.FuncArg;
import groovy.lang.GroovyShell;

class Utils
{
	static int evaluateInt(GroovyShell wshell, FuncArg arg, Binding binding=null)
	{
		if ( arg.expr)
		{
			def sc = wshell.parse(arg.expr)
			if ( binding)
				sc.binding = binding
			return (int)	sc.run()
		}
		else
		{
			return Integer.parseInt(arg.str);
		}
	}
	
	
	static int evaluateString(GroovyShell wshell, String expr, Binding binding= null)
	{
		def sc = wshell.parse(expr)
		if ( binding)
			sc.binding = binding
		return (String)	sc.run()
	}
	
	static Object parseStr(String type, String val)  throws WindowingException
	{
		try
		{
			switch(type)
			{
				case "boolean": return Boolean.parseBoolean(val);
				case "int": return Integer.parseInt(val);
				case "bigint": return Long.parseLong(val);
				case "float": return Float.parseFloat(val);
				case "double": return Double.parseDouble(val);
				case "tinyint": return Byte.parseByte(val);
				case "smallint": return Short.parseShort(val);
				case "string": return val;
			}
		}
		catch(Throwable t)
		{
			throw new WindowingException(sprintf("Failed to parse %s as %s", val.toString(), type));
		}
	}
	
	
	static int evaluate(GroovyShell wshell, String expr, String typeName, Binding binding= null)  throws WindowingException
	{
		def sc = wshell.parse(expr)
		if ( binding)
			sc.binding = binding
		def o =	sc.run()
		return cast(typeName, o);
	}
	
	static Object cast(String type, Object val) throws WindowingException
	{
		try
		{
			switch(type)
			{
				case "boolean": return (Boolean) val;
				case "int": return (Integer) val;
				case "bigint": return (Long) val;
				case "float": return (Float) val;
				case "double": return (Double) val;
				case "tinyint": return (Byte) val;
				case "smallint": return (Short) val;
				case "string": return val == null ? null : val.toString();
			}
		}
		catch(Throwable t)
		{
			throw new WindowingException(sprintf("Failed to cast %s to %s", val.toString(), type));
		}
	}
	
	static String unescapeQueryString(String qry)
	{
		qry = qry.replace("\\\"", "\"");
		qry = qry.replace("\\'", "'");
		return qry
	}
}
