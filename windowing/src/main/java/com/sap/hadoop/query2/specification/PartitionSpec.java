package com.sap.hadoop.query2.specification;

import java.util.ArrayList;
import com.sap.hadoop.Utils;

public class PartitionSpec
{
	ArrayList<ColumnSpec> columns;
	
	public ArrayList<ColumnSpec> getColumns()
	{
		return columns;
	}

	public void setColumns(ArrayList<ColumnSpec> columns)
	{
		this.columns = columns;
	}
	
	public void addColumn(ColumnSpec c)
	{
		columns = columns == null ? new ArrayList<ColumnSpec>() : columns;
		columns.add(c);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((columns == null) ? 0 : columns.hashCode());
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
		PartitionSpec other = (PartitionSpec) obj;
		if (columns == null)
		{
			if (other.columns != null)
				return false;
		}
		else if (!columns.equals(other.columns))
			return false;
		return true;
	}

	public String toString()
	{
		return Utils.sprintf("partitionColumns=%s",Utils.toString(columns));
	}
}
