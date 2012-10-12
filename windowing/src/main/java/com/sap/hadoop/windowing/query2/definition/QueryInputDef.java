package com.sap.hadoop.windowing.query2.definition;

import java.io.Serializable;

import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.query2.SerializationUtils;
import com.sap.hadoop.windowing.query2.specification.HiveTableSpec;
import com.sap.hadoop.windowing.query2.specification.QueryInputSpec;

public abstract class QueryInputDef implements Serializable
{
	QueryInputSpec inputSpec;
	WindowDef window;
	transient StructObjectInspector OI;
	transient SerDe serde;
	String alias;
	
	static{
		SerializationUtils.makeTransient(QueryInputDef.class, "serde");
		SerializationUtils.makeTransient(QueryInputDef.class, "OI");
	}

	
	public QueryInputDef(){
		
	}
	
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

	public QueryInputSpec getInputSpec() {
		return inputSpec;
	}

	public void setInputSpec(QueryInputSpec inputSpec) {
		this.inputSpec = inputSpec;
	}
}
