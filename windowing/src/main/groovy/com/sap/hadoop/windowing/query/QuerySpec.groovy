package com.sap.hadoop.windowing.query

import com.sap.hadoop.windowing.runtime.ArgType;


class QuerySpec
{
	String queryStr
	TableInput tableIn
	ArrayList<FuncSpec> funcSpecs
	ArrayList<String> partitionColumns
	ArrayList<OrderColumn> orderColumns
	String whereExpr
	TableOutput tableOut
	ArrayList<SelectColumn> selectColumns
	
	QuerySpec()
	{
		tableIn = new TableInput()
		funcSpecs = []
		partitionColumns = []
		orderColumns = []
		tableOut = new TableOutput()
		selectColumns = []
	}
	
	public String toString()
	{
		return sprintf(
			"Query:\n\ttableInput=(%s)\n\tpartitionColumns=%s\n\torderColumns=%s\n\tfuncSpecs=[%s]\n\tselect=%s\n\twhereExpr=%s\n\ttableOutput=(%s)\n", 
			tableIn, partitionColumns.join(", "), orderColumns.join(", "), funcSpecs.join(",\n\t\t"), selectColumns.join(", "), whereExpr, tableOut)
	}
	
}

/**
 * <ul>
 * <li> if tableName is specified and it is possible to connect to a HIve MetaStore then rest of the information is extracted from MStore
 * <li> o.w. in hiveMode: 
 * </ul>
 * @author "Harish Butani"
 *
 */
class TableInput
{
	String tableName
	String hiveQuery
	String windowingInputClass
	String inputPath
	String keyClass
	String valueClass
	String inputFormatClass
	String serDeClass
	Properties serDeProps = new Properties()
	
	public String toString()
	{
		if (tableName != null )
		{
			return sprintf('hiveTable=%s', tableName)
		}
		else if ( hiveQuery != null )
		{
			return sprintf('hiveQuery=<%s>', hiveQuery)
		}
		return sprintf( 'windowInputClass=%s, inputPath=%s, keyClass=%s, valueClass=%s, inputFormatClass=%s, serDeClass=%s, serDeProps=%s', 
			windowingInputClass, inputPath, keyClass, valueClass, inputFormatClass, serDeClass, serDeProps)
	}
}

class TableOutput
{
	String outputFormat
	String outputPath
	Properties serDeProps = new Properties()
	public String toString()
	{
		return sprintf( 'serDeProps=%s, outputPath=%s, outputFormat=%s', serDeProps, outputPath, outputFormat)
	}
}

class FuncSpec
{
	String name
	String alias
	String typeName
	ArrayList<FuncArg> params; 
	Window window
	
	FuncSpec()
	{
		params = []
	}

	public String toString()
	{
		return sprintf( '%s(alias=%s, param=%s, type=%s, window=%s)', 
			name, alias, params, typeName, window)
	}
}

class FuncArg
{
	String str
	String expr
	String id
	int iVal
	
	public String toString()
	{
		switch(argType)
		{
		case ArgType.STRING:
			return sprintf( 'strVal=%s', str)
		case ArgType.SCRIPT:
			return sprintf( 'expr=%s', expr)
		case ArgType.ID:
			return sprintf( 'id=%s', id)
		case ArgType.NUMBER:
			return sprintf( 'intValue=%s', iVal)
		}
	}
	
	ArgType getArgType()
	{
		if ( expr )
			return ArgType.SCRIPT;
		else if ( str )
			return ArgType.STRING;
		else if ( id )
			return ArgType.ID;
		else if ( iVal )
			return ArgType.NUMBER;
		return ArgType.STRING;
	}
}

enum Order
{
	ASC,
	DESC;
}

class OrderColumn
{
	String name
	Order order
	
	public String toString()
	{
		return sprintf( '%s %s', name, order)
	}
}

class SelectColumn
{
	String alias
	String expr
	String typeName
	
	public String toString()
	{
		if ( expr  )
			return sprintf( '%s as %s%s', expr, alias, (typeName ? "[" + typeName + "]" : ""))
		else
			return sprintf( '%s%s', alias, (typeName ? "[" + typeName + "]" : ""))
	}
}