package com.sap.hadoop.windowing.query2;

import java.util.Map;

import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.query2.definition.WindowDef;


/*
 * The information captured during translation of a QuerySpec into a QueryDef
 */
public class QueryTranslationInfo
{
	/*
	 * A map from a QueryInput to the WindowDefns defined on it.
	 * 	In the future this will enable (Partition, Order) specification for a QueryInput to refer to a Window definition. 
	 * This will require that we accept window definitions on DataSets other then the input to the Windowing Table Function. 
	 */
	Map<String, Map<String, WindowDef>> windowDefMap;
	
	/*
	 * A map from a QueryInput to its Shape.
	 */
	Map<String, StructObjectInspector> OIMap;
}
