package com.sap.hadoop.windowing.query2.definition;

import java.util.Map;
import com.sap.hadoop.windowing.query2.specification.HiveTableSpec;

public class HiveTableDef extends QueryInputDef
{
	String tableSerdeClassName;
	Map<String, String> tableSerdeProps;
	
	String location;
	String inputFormatClassName;
	
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
	
	public Map<String, String> getTableSerdeProps()
	{
		return tableSerdeProps;
	}
	
	public void setTableSerdeProps(Map<String, String> tableSerdeProps)
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

	@Override
	public HiveTableDef getHiveTableDef() {
		return this;
	}
	
}
