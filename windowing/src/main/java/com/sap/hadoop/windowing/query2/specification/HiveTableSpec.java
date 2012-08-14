package com.sap.hadoop.windowing.query2.specification;

public class HiveTableSpec extends QueryInputSpec
{
	String dbName;
	String tableName;
	
	public HiveTableSpec() {}
	
	public HiveTableSpec(String dbName, String tableName)
	{
		super();
		this.dbName = dbName;
		this.tableName = tableName;
	}

	public String getDbName()
	{
		return dbName;
	}
	
	public void setDbName(String dbName)
	{
		this.dbName = dbName;
	}
	
	public String getTableName()
	{
		return tableName;
	}
	
	public void setTableName(String tableName)
	{
		this.tableName = tableName;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dbName == null) ? 0 : dbName.hashCode());
		result = prime * result
				+ ((tableName == null) ? 0 : tableName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		HiveTableSpec other = (HiveTableSpec) obj;
		if (dbName == null)
		{
			if (other.dbName != null)
				return false;
		}
		else if (!dbName.equals(other.dbName))
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
		StringBuilder buf = new StringBuilder();
		
		if ( dbName != null) buf.append(dbName).append(".");
		buf.append(tableName);
		
		if ( partition != null )
		{
			buf.append(" ").append(partition);
			if ( order != null ) buf.append(" ").append(order);
		}
		
		return buf.toString();
	}
	
}
