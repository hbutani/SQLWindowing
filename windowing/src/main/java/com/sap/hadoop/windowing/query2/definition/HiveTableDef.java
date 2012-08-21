package com.sap.hadoop.windowing.query2.definition;

import java.util.Properties;

import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

import com.sap.hadoop.windowing.query2.specification.HiveTableSpec;

public class HiveTableDef extends QueryInputDef
{
	String tableSerdeClassName;
	Properties tableSerdeProps;
	
	String location;
	String inputFormatClassName;
	ObjectInspector OI;
	
	public HiveTableSpec getHiveTableSpec()
	{
		return (HiveTableSpec) inputSpec;
	}
	
	public String getTableSerdeClassName()
	{
		return tableSerdeClassName;
	}
	
	public void setTableSerdeClassName(String tableSerdeClassName)
	{
		this.tableSerdeClassName = tableSerdeClassName;
	}
	
	public Properties getTableSerdeProps()
	{
		return tableSerdeProps;
	}
	
	public void setTableSerdeProps(Properties tableSerdeProps)
	{
		this.tableSerdeProps = tableSerdeProps;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public String getInputFormatClassName()
	{
		return inputFormatClassName;
	}
	
	public void setInputFormatClassName(String inputFormatClassName)
	{
		this.inputFormatClassName = inputFormatClassName;
	}
	
}
