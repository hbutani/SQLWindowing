package com.sap.hadoop.windowing.testutils;

public class WindowingTest
{
	String name;
	String description;
	String query;
	String result;
	
	public WindowingTest(String name)
	{
		super();
		this.name = name;
	}
	
	public WindowingTest(String name, String description, String query, String result)
	{
		super();
		this.name = name;
		this.query = query;
		this.result = result;
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	protected String getDescription()
	{
		return description;
	}

	protected void setDescription(String description)
	{
		this.description = description;
	}

	public String getQuery()
	{
		return query;
	}
	public void setQuery(String query)
	{
		this.query = query;
	}
	public String getResult()
	{
		return result;
	}
	public void setResult(String result)
	{
		this.result = result;
	}
	
	
}
