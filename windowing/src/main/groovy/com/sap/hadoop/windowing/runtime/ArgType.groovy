package com.sap.hadoop.windowing.runtime

import java.util.Map;

import com.sap.hadoop.windowing.query.Translator;

/**
 * Specifies the manner in which an arg is specified in the langauge. Options are:
 * - a Groovy Expression; If the arg's type is unconstrained than the expr's value determines the type.
 * - a Literal String
 * - an Id; for constrained args the Id's type must match that of the arg
 * - a Literal Number
 * @author harish.butani
 *
 */
public enum ArgType
{
	SCRIPT,
	STRING,
	NUMBER,
	ID;
	
}
