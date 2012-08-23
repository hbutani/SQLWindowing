package com.sap.hadoop.windowing.functions2.annotation;

import org.apache.hadoop.hive.ql.exec.Description;

import com.sap.hadoop.windowing.functions.WindowingTableFunction;

public @interface TableFuncDef
{
	Description description ();
	
	/**
	 * if true it is not usable in the language. {@link WindowingTableFunction} is the only internal function.
	 */
	boolean isInternal() default false;
}
