package com.sap.hadoop.windowing.query2.definition;

import java.util.Properties;

import com.sap.hadoop.windowing.query2.specification.HiveTableSpec;

public class HdfsLocationDef extends QueryInputDef
{
	String serdeClassName;
	Properties serdeProps;
	
	String keyClassName;
	String valueClassName;
	
	String inputFormatClassName;

	public String getSerdeClassName()
	{
		return serdeClassName;
	}

	public void setSerdeClassName(String serdeClassName)
	{
		this.serdeClassName = serdeClassName;
	}

	public Properties getSerdeProps()
	{
		return serdeProps;
	}

	public void setSerdeProps(Properties serdeProps)
	{
		this.serdeProps = serdeProps;
	}

	public String getKeyClassName()
	{
		return keyClassName;
	}

	public void setKeyClassName(String keyClassName)
	{
		this.keyClassName = keyClassName;
	}

	public String getValueClassName()
	{
		return valueClassName;
	}

	public void setValueClassName(String valueClassName)
	{
		this.valueClassName = valueClassName;
	}

	public String getInputFormatClassName()
	{
		return inputFormatClassName;
	}

	public void setInputFormatClassName(String inputFormatClassName)
	{
		this.inputFormatClassName = inputFormatClassName;
	}
	
	public HiveTableSpec getHiveTableSpec()
	{
		return null;
	}

	@Override
	public HiveTableDef getHiveTableDef() {
		return null;
	}
	
}
