package com.sap.hadoop.windowing.functions2.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.hadoop.hive.ql.exec.Description;

import com.sap.hadoop.windowing.functions.WindowingTableFunction;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface TableFuncDef
{
	Description description ();
	
	/**
	 * if true it is not usable in the language. {@link WindowingTableFunction} is the only internal function.
	 */
	boolean isInternal() default false;
}
