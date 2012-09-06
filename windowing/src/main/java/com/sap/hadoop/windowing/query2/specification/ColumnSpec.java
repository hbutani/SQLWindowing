package com.sap.hadoop.windowing.query2.specification;

import static com.sap.hadoop.Utils.sprintf;

public class ColumnSpec
{
	String tableName;
	String columnName;
	
	public ColumnSpec() {}
	
	public ColumnSpec(String tableName, String columnName)
	{
		super();
		setTableName(tableName);
		setColumnName(columnName);
	}
	
	public ColumnSpec(ColumnSpec cSpec)
	{
		this(cSpec.getTableName(), cSpec.getColumnName());
	}

	public String getTableName()
	{
		return tableName;
	}

	public void setTableName(String tableName)
	{
		this.tableName = tableName;
	}

	public String getColumnName()
	{
		return columnName;
	}

	public void setColumnName(String columnName)
	{
		this.columnName = columnName;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((columnName == null) ? 0 : columnName.hashCode());
		result = prime * result
				+ ((tableName == null) ? 0 : tableName.hashCode());
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
		ColumnSpec other = (ColumnSpec) obj;
		if (columnName == null)
		{
			if (other.columnName != null)
				return false;
		}
		else if (!columnName.equals(other.columnName))
			return false;
		if (tableName == null)
		{
			if (other.tableName != null)
				return false;
		}
		else if (!tableName.equals(other.tableName))
			return false;
		return true;
	}

	public String toString()
	{
		if ( tableName != null )
			return sprintf("%s.%s", tableName, columnName);
		return columnName;
	}
	
}
