package com.sap.hadoop.windowing.functions.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Describes a WindowingFunction.
 * - typeName specifies the o/p type of the Function. An empty string implies that the type is dynamic.
 * - a function may optionally support a Window specification
 * - function may have one or more Args
 * 
 * @author harish.butani
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FunctionDef
{
	String name();
	String description() default "";
	String typeName() default "";
	ArgDef[] args() default {};
	boolean supportsWindow();
}
