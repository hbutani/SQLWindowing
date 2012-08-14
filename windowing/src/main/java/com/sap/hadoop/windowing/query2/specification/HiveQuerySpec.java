package com.sap.hadoop.windowing.query2.specification;

public class HiveQuerySpec  extends QueryInputSpec
{
	String hiveQuery;

	public HiveQuerySpec() {}
	
	public HiveQuerySpec(String hiveQuery)
	{
		super();
		this.hiveQuery = hiveQuery;
	}

	public String getHiveQuery()
	{
		return hiveQuery;
	}

	public void setHiveQuery(String hiveQuery)
	{
		this.hiveQuery = hiveQuery;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hiveQuery == null) ? 0 : hiveQuery.hashCode());
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
		HiveQuerySpec other = (HiveQuerySpec) obj;
		if (hiveQuery == null)
		{
			if (other.hiveQuery != null)
				return false;
		}
		else if (!hiveQuery.equals(other.hiveQuery))
			return false;
		return true;
	}
	
	public String toString()
	{
		StringBuilder buf = new StringBuilder();
		
		buf.append("<").append(hiveQuery).append(">");
		if ( partition != null )
		{
			buf.append(" ").append(partition);
			if ( order != null ) buf.append(" ").append(order);
		}
		
		return buf.toString();
	}
}
