package com.sap.hadoop.windowing;

public class Constants
{
	public static final String INPUT_PATH = "inputpath";
	public static final String INPUT_KEY_CLASS = "keyclass";
	public static final String INPUT_VALUE_CLASS = "valueclass";
	public static final String INPUT_INPUTFORMAT_CLASS = "inputformatclass";
	
	public static final String WINDOW_EXPRESSION = "com.sap.hadoop.windowing.expression";
	public static final String INPUT_RECORD_READER_CLASS = "recordreaderclass";
	public static final String WINDOW_PARTITION_COLUMNS = "com.sap.hadoop.windowing.partition.columns";
	public static final String WINDOW_ORDER_COLUMNS = "com.sap.hadoop.windowing.order.columns";
	
	public static final String INPUT_SERDE_CLASS = "serdeclass";
	
	public static final String HIVE_THRIFTSERVER = "com.sap.hadoop.windowing.hivethriftserver";
	public static final String HIVE_THRIFTSERVER_PORT = "com.sap.hadoop.windowing.hivethriftserver.port";
	
	public static final String WINDOW_PARTITION_MEM_SIZE = "com.sap.hadoop.windowing.partition.memory.size";
	
	public static final String WINDOW_PARTITION_CLASS = "com.sap.hadoop.windowing.partition.class";
	public static final String DEFAULT_WINDOW_PARTITION_CLASS = "com.sap.hadoop.ds.list.ByteBasedList";
	
	/*
	 * the difference between script & expression is that script is only parsed during translation,
	 * and the parsed script is provided to the function, whereas expression is evaluated and the
	 * result of evaluation is passed to the function.
	 */
	public static final String GROOVYSCRIPT_TYPE = "script";
	public static final String GROOVYEXPRESSION_TYPE = "expression";		
}
