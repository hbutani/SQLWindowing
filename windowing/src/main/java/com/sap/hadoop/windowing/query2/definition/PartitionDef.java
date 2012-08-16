package com.sap.hadoop.windowing.query2.definition;

import java.util.ArrayList;

import com.sap.hadoop.windowing.query2.specification.PartitionSpec;

public class PartitionDef
{
	PartitionSpec pSpec;
	ArrayList<ColumnDef> columns;
	
	public PartitionSpec getpSpec()
	{
		return pSpec;
	}
	
	public void setpSpec(PartitionSpec pSpec)
	{
		this.pSpec = pSpec;
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((columns == null) ? 0 : columns.hashCode());
		result = prime * result + ((pSpec == null) ? 0 : pSpec.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartitionDef other = (PartitionDef) obj;
		if (columns == null)
		{
			if (other.columns != null)
				return false;
		}
		else if (!columns.equals(other.columns))
			return false;
		if (pSpec == null)
		{
			if (other.pSpec != null)
				return false;
		}
		else if (!pSpec.equals(other.pSpec))
			return false;
		return true;
	}
	
	public String toString()
	{
		return pSpec.toString();
	}
}
