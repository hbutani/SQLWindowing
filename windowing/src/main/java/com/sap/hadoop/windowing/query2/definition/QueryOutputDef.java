package com.sap.hadoop.windowing.query2.definition;

import java.util.ArrayList;

import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

import com.sap.hadoop.windowing.query2.specification.QueryOutputSpec;

public class QueryOutputDef
{
	QueryOutputSpec outputSpec;
	ArrayList<ColumnDef> columnDefs;
	ObjectInspector OI;
	
	public QueryOutputSpec getSpec()
	{
		return outputSpec;
	}
	
	public void setSpec(QueryOutputSpec outputSpec)
	{
		this.outputSpec = outputSpec;
	}
	
	public ArrayList<ColumnDef> getColumnDefs()
	{
		return columnDefs;
	}
	
	public void setColumnDefs(ArrayList<ColumnDef> columnDefs)
	{
		this.columnDefs = columnDefs;
	}
	
	public ObjectInspector getOI()
	{
		return OI;
	}
	
	public void setOI(ObjectInspector oI)
	{
		OI = oI;
	}
		
}
