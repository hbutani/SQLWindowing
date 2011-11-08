package com.sap.hadoop.windowing.query

import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.ql.exec.RecordWriter;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.objectinspector.SettableStructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoUtils;

import com.sap.hadoop.windowing.functions.IWindowFunction;
import com.sap.hadoop.windowing.io.WindowingInput;
import com.sap.hadoop.windowing.query.Order;

class Query
{
	QuerySpec qSpec;
	GroovyShell wshell
	Configuration cfg
	QueryInput input
	ArrayList<IWindowFunction> wnFns
	ArrayList<String> wnAliases
	QueryOutput output
}

/**
 * Encapsulates information about the Input:
 * <ol>
 * <li> The WindowingInput provides a stream of Writables & metadata about Input
 * <li> inputOI represents the structure of the input
 * <li> serDe converts Writables to Objects
 * <li> processingOI is used to convert the Objects from the input to a standard form
 * used inside the processing layer. The Standard form used is based on the StandardObjectInspector
 * using the JAVA mode. So rows are represented as lists of java objects.
 * <li> partitionColumn represents information about the columns used to partition the input.
 * </ol>
 * @author harish.butani
 *
 */
class QueryInput
{
	WindowingInput wInput;
	StructObjectInspector inputOI;
	SerDe serDe
	StructObjectInspector processingOI;
	ArrayList<Column> columns = []
	ArrayList<Column> partitionColumns = []
	ArrayList<Column> orderColumns = []
}

class Column
{
	StructField field;
	Script groovyExpr;
	Order order;
	
	String getName() { return field.fieldName; }
	
	TypeInfo getTypeInfo()
	{
		TypeInfoUtils.getTypeInfoFromObjectInspector(field.getFieldObjectInspector())
	}
}

/*
 * Encapsulates a Query Output
 * <ol>
 * <li> columns represent the information about the columns
 * <li> processingOI is used to read the O/P of the com.sap.hadoop.windowing processing
 * <li> serde writes an O/p row to a Writable
 * <li> wrtr is responsible for streaming the writable.
 * </ol>
 */
class QueryOutput
{
	ArrayList<OutputColumn> columns = []
	StructObjectInspector outputOI;
	SerDe serDe
	StructObjectInspector processingOI;
	RecordWriter wrtr
}

class OutputColumn extends Column
{
	String alias
	TypeInfo typeInfo
	
	String getName() { return alias; }
}