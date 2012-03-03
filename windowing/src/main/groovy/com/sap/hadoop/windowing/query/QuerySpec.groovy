package com.sap.hadoop.windowing.query

import com.sap.hadoop.windowing.runtime.ArgType;


class QuerySpec
{
	String queryStr
	TableInput tableIn
	TableFuncSpec tblFuncSpec
	ArrayList<FuncSpec> funcSpecs
	String whereExpr
	TableOutput tableOut
	ArrayList<SelectColumn> selectColumns
	
	QuerySpec()
	{
		tableIn = new TableInput()
		funcSpecs = []
		tableOut = new TableOutput()
		selectColumns = []
	}
	
	public String toString()
	{
		return sprintf(
			"Query:\n\ttableInput=(%s)\n\ttableFuncSpec=%s\n\tfuncSpecs=[%s]\n\tselect=%s\n\twhereExpr=%s\n\ttableOutput=(%s)\n", 
			tableIn, tblFuncSpec, funcSpecs.join(",\n\t\t"), selectColumns.join(", "), whereExpr, tableOut)
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
	ArrayList<String> partitionColumns
	ArrayList<OrderColumn> orderColumns
	
	TableInput()
	{		
		partitionColumns = []
		orderColumns = []
	}
	
	public String toString()
	{
		if (tableName != null )
		{
			return sprintf('hiveTable=%s\n\t\tpartitionColumns=%s\n\t\torderColumns=%s', tableName, partitionColumns.join(", "), orderColumns.join(", "))
		}
		else if ( hiveQuery != null )
		{
			return sprintf('hiveQuery=<%s>\n\t\tpartitionColumns=%s\n\t\torderColumns=%s', hiveQuery, partitionColumns.join(", "), orderColumns.join(", "))
		}
		return sprintf( 'windowInputClass=%s, inputPath=%s, keyClass=%s, valueClass=%s, inputFormatClass=%s, serDeClass=%s, serDeProps=%s\n\t\tpartitionColumns=%s\n\t\torderColumns=%s', 
			windowingInputClass, inputPath, keyClass, valueClass, inputFormatClass, serDeClass, serDeProps,
			partitionColumns.join(", "), orderColumns.join(", "))
	}
}

class TableOutput
{
	static final String DEFAULT_SERDE_CLASS = "org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe"
	static final String DEFAULT_FORMAT_CLASS = 'org.apache.hadoop.mapred.TextOutputFormat'
	static final String DEFAULT_RECORDWRITER_CLASS = "org.apache.hadoop.hive.contrib.util.typedbytes.TypedBytesRecordWriter"
	
	String outputPath
	String serDeClass
	Properties serDeProps = new Properties()
	String outputFormat
	String recordwriterClass
	String tableName
	String partitionClause
	boolean overwrite
	
	public String toString()
	{
		if ( recordwriterClass )
		{
			return sprintf("output(path=%s, serde=%s, serDeProps=%s, recordwriterClass=%s",
				outputPath, serDeClass, serDeProps, recordwriterClass)
		}
		else
		{
			if ( tableName )
			{
				return sprintf("output(path=%s, serde=%s, serDeProps=%s, format=%s, tableName=%s, loadClause=%s, overwrite=%s",
					outputPath, serDeClass, serDeProps, outputFormat, tableName, partitionClause, overwrite)
			}
			else
			{
				return sprintf("output(path=%s, serde=%s, serDeProps=%s, format=%s", 
					outputPath, serDeClass, serDeProps, outputFormat)
			}
		}
		
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

class TableFuncSpec extends FuncSpec
{
	TableFuncSpec inputFuncSpec
	
	public String toString()
	{
		if (!inputFuncSpec )
		{
			return sprintf( '%s(param=%s, window=%s)',
				name, params, window)
		}
		else
		{
			return sprintf( '%s(%s, param=%s, window=%s)',
				name, inputFuncSpec, params, window)
		}
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