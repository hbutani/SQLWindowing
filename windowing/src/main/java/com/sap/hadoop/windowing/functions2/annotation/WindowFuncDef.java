package com.sap.hadoop.windowing.functions2.annotation;

import org.apache.hadoop.hive.ql.exec.Description;

public @interface WindowFuncDef 
{
	Description description ();
	/**
	 * controls whether this function can be applied to a Window
	 */
	boolean supportsWindow() default true;
	/**
	 * A WindowFunc is implemented as {@link GenericUDAFResolver2}. It returns only one value.
	 * If this is true then the function must return a List which is taken to be the column for this function in the Output table returned by the
	 * {@link WindowTableFunction}. Otherwise the output is assumed to be a single value, the column of the Output will contain the same value
	 * for all the rows.
	 */
	boolean pivotResult() default false;
}
