package com.sap.hadoop.windowing.query2.definition;

import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.query2.specification.HiveTableSpec;
import com.sap.hadoop.windowing.query2.specification.QueryInputSpec;

public abstract class QueryInputDef
{
	QueryInputSpec inputSpec;
	WindowDef window;
	StructObjectInspector OI;
	SerDe serde;
	String alias;
	
	public QueryInputSpec getSpec()
	{
		return inputSpec;
	}
	
	public void setSpec(QueryInputSpec inputSpec)
	{
		this.inputSpec = inputSpec;
	}
	
	public WindowDef getWindow()
	{
		return window;
	}
	
	public void setWindow(WindowDef window)
	{
		this.window = window;
	}

	public StructObjectInspector getOI()
	{
		return OI;
	}

	public void setOI(StructObjectInspector oI)
	{
		OI = oI;
	}

	public SerDe getSerde()
	{
		return serde;
	}

	public void setSerde(SerDe serde)
	{
		this.serde = serde;
	}

	public String getAlias()
	{
		return alias;
	}

	public void setAlias(String alias)
	{
		this.alias = alias;
	}
	
	/*
	 * get the Hive Table associated with this input chain.
	 */
	public abstract HiveTableSpec getHiveTableSpec();
	
	public abstract HiveTableDef getHiveTableDef();
}
