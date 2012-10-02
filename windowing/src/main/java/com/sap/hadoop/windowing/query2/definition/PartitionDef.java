package com.sap.hadoop.windowing.query2.definition;

import java.util.ArrayList;

import com.sap.hadoop.windowing.query2.specification.PartitionSpec;

public class PartitionDef
{
	PartitionSpec spec;
	ArrayList<ColumnDef> columns;
	
	public PartitionDef(){
		
	}
	
	public PartitionDef(PartitionSpec spec)
	{
		this.spec = spec;
	}
	
	public PartitionSpec getSpec()
	{
		return spec;
	}
	
	public ArrayList<ColumnDef> getColumns()
	{
		return columns;
	}
	
	public void setColumns(ArrayList<ColumnDef> columns)
	{
		this.columns = columns;
	}
	
	public void addColumn(ColumnDef c)
	{
		columns = columns == null ? new ArrayList<ColumnDef>() : columns;
		columns.add(c);
	}

}
