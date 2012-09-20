package com.sap.hadoop.windowing.query2.specification;

import java.util.HashMap;
import java.util.Map;

public class HdfsLocationSpec extends QueryInputSpec implements INameValueList
{
	Map<String, String>	properties;

	public Map<String, String> getProperties()
	{
		return properties;
	}

	public void setProperties(Map<String, String> properties)
	{
		this.properties = properties;
	}
	
	public void addProperty(String name, String value)
	{
		properties = properties == null ? new HashMap<String, String>() : properties;
		properties.put(name, value);
	}
	
	@Override
	public void add(String name, String value)
	{
		addProperty(name, value);
		
	}
	
	public boolean sourcedFromHive()
	{
		return false;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((properties == null) ? 0 : properties.hashCode());
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
		HdfsLocationSpec other = (HdfsLocationSpec) obj;
		if (properties == null)
		{
			if (other.properties != null)
				return false;
		}
		else if (!properties.equals(other.properties))
			return false;
		return true;
	}
	
	public String toString()
	{
		StringBuilder buf = new StringBuilder();
		
		buf.append("Fileinput(");
		if ( properties != null )
		{
			boolean first = true;
			for(Map.Entry<String, String> prop : properties.entrySet())
			{
				if ( first) first = false; else buf.append(", ");
				buf.append(prop.getKey()).append(" = ").append(prop.getValue());
			}
		}
		buf.append(")");
		if ( partition != null )
		{
			buf.append(" ").append(partition);
			if ( order != null ) buf.append(" ").append(order);
		}
		
		return buf.toString();
	}	
	
}
