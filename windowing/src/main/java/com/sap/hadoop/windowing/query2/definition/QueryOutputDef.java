package com.sap.hadoop.windowing.query2.definition;

import java.util.ArrayList;

import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.query2.specification.QueryOutputSpec;

public class QueryOutputDef
{
	QueryOutputSpec outputSpec;
	ArrayList<ColumnDef> columnDefs;
	StructObjectInspector OI;
	SerDe serDe;
	
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
	
	public StructObjectInspector getOI()
	{
		return OI;
	}
	
	public void setOI(StructObjectInspector oI)
	{
		OI = oI;
	}

	public SerDe getSerDe()
	{
		return serDe;
	}

	public void setSerDe(SerDe serDe)
	{
		this.serDe = serDe;
	}
		
}
