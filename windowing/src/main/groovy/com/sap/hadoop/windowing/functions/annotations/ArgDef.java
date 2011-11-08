package com.sap.hadoop.windowing.functions.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.sap.hadoop.windowing.runtime.ArgType;

/**
 * Specifies a WindowingFunction's Argument
 * - typeName specifies the datatype. Can be any primitivetype from TypeInfos + 'script'. Script implies a dynamic type.
 * - argType specifies the manner in which the arg can be specified. (@see ArgType)
 * @author harish.butani
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ArgDef
{
	String name();
	String description() default "";
	String typeName();
	ArgType[] argTypes() default {ArgType.SCRIPT};
	boolean optional() default false;
	
}
