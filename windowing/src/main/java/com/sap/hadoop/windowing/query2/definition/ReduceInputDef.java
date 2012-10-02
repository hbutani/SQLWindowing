package com.sap.hadoop.windowing.query2.definition;

import java.util.Properties;

public class ReduceInputDef
{
	String serDeClassName;
	Properties serDeProperties;
	
	public ReduceInputDef(){
		
	}
	
	public String getSerDeClassName()
	{
		return serDeClassName;
	}
	
	public void setSerDeClassName(String serDeClassName)
	{
		this.serDeClassName = serDeClassName;
	}
	
	public Properties getSerDeProperties()
	{
		return serDeProperties;
	}
	
	public void setSerDeProperties(Properties serDeProperties)
	{
		this.serDeProperties = serDeProperties;
	}
	
}
