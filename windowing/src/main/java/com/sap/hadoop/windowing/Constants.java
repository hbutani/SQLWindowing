package com.sap.hadoop.windowing;

import com.sap.hadoop.metadata.CompositeDataType;

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
	
	
	public static final String WINDOWING_JAR_FILE = "windowing.jar.file";
	public static final String WINDOWING_PARTITION_COLS = "windowing.partition.cols";
	public static final String WINDOWING_SORT_COLS = "windowing.sort.cols";
	public static final String WINDOWING_SORT_COLS_ORDER = "windowing.sort.order";
	public static final String WINDOWING_INPUT_DATABASE = "windowing.input.database";
	public static final String WINDOWING_INPUT_TABLE = "windowing.input.table";
	public static final String WINDOWING_KEY_TYPE = CompositeDataType.COMPOSITE_DATA_TYPE;
	public static final String WINDOWING_NUM_PARTION_COLUMNS = "windowing.number.of.partition.columns";
	public static final String WINDOWING_QUERY_STRING = "windowing.query.string";
	public static final String WINDOWING_TEMP_TABLE = "windowing.hivequery.temptable";
	public static final String WINDOWING_JOB_WORKING_DIR = "windowing.job.working.dir";
	public static final String WINDOWING_JOB_QUERY_FILE = "windowing.job.query.file";
	
	public static final String WINDOWING_TEST_MODE = "windowing.test.mode";
	
	public static final String WINDOWING_OUTPUT_QUERY_RESULT = "windowing.output.query.result";
	
	public static final String DEFAULT_SERDE_CLASSNAME = "org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe";
	public static final String DEFAULT_OUTPUTFORMAT_CLASSNAME = "org.apache.hadoop.mapred.TextOutputFormat";
	public static final String DEFAULT_RECORDWRITER_CLASSNAME = "org.apache.hadoop.hive.contrib.util.typedbytes.TypedBytesRecordWriter";

}
