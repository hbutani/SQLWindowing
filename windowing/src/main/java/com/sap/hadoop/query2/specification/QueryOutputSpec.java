package com.sap.hadoop.query2.specification;

import java.util.HashMap;
import java.util.Map;

public class QueryOutputSpec implements INameValueList
{
	String path;
	String serDeClass;
	Map<String, String> serDeProps;
	String recordWriterClass;
	String outputFormatClass;
	String hiveTable;
	String partitionClause;
	boolean overwriteHiveTable;
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public String getSerDeClass()
	{
		return serDeClass;
	}
	public void setSerDeClass(String serDeClass)
	{
		this.serDeClass = serDeClass;
	}
	public Map<String, String> getSerDeProps()
	{
		return serDeProps;
	}
	public void setSerDeProps(Map<String, String> serDeProps)
	{
		this.serDeProps = serDeProps;
	}
	public void addSerdeProperty(String name, String value)
	{
		serDeProps = serDeProps == null ? new HashMap<String, String>() : serDeProps;
		serDeProps.put(name, value);
	}
	@Override
	public void add(String name, String value)
	{
		addSerdeProperty(name, value);
		
	}
	public String getRecordWriterClass()
	{
		return recordWriterClass;
	}
	public void setRecordWriterClass(String recordWriterClass)
	{
		this.recordWriterClass = recordWriterClass;
	}
	public String getOutputFormatClass()
	{
		return outputFormatClass;
	}
	public void setOutputFormatClass(String outputFormatClass)
	{
		this.outputFormatClass = outputFormatClass;
	}
	public String getHiveTable()
	{
		return hiveTable;
	}
	public void setHiveTable(String hiveTable)
	{
		this.hiveTable = hiveTable;
	}
	public String getPartitionClause()
	{
		return partitionClause;
	}
	public void setPartitionClause(String partitionClause)
	{
		this.partitionClause = partitionClause;
	}
	public boolean isOverwriteHiveTable()
	{
		return overwriteHiveTable;
	}
	public void setOverwriteHiveTable(boolean overwriteHiveTable)
	{
		this.overwriteHiveTable = overwriteHiveTable;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((hiveTable == null) ? 0 : hiveTable.hashCode());
		result = prime
				* result
				+ ((outputFormatClass == null) ? 0 : outputFormatClass
						.hashCode());
		result = prime * result + (overwriteHiveTable ? 1231 : 1237);
		result = prime * result
				+ ((partitionClause == null) ? 0 : partitionClause.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime
				* result
				+ ((recordWriterClass == null) ? 0 : recordWriterClass
						.hashCode());
		result = prime * result
				+ ((serDeClass == null) ? 0 : serDeClass.hashCode());
		result = prime * result
				+ ((serDeProps == null) ? 0 : serDeProps.hashCode());
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
		QueryOutputSpec other = (QueryOutputSpec) obj;
		if (hiveTable == null)
		{
			if (other.hiveTable != null)
				return false;
		}
		else if (!hiveTable.equals(other.hiveTable))
			return false;
		if (outputFormatClass == null)
		{
			if (other.outputFormatClass != null)
				return false;
		}
		else if (!outputFormatClass.equals(other.outputFormatClass))
			return false;
		if (overwriteHiveTable != other.overwriteHiveTable)
			return false;
		if (partitionClause == null)
		{
			if (other.partitionClause != null)
				return false;
		}
		else if (!partitionClause.equals(other.partitionClause))
			return false;
		if (path == null)
		{
			if (other.path != null)
				return false;
		}
		else if (!path.equals(other.path))
			return false;
		if (recordWriterClass == null)
		{
			if (other.recordWriterClass != null)
				return false;
		}
		else if (!recordWriterClass.equals(other.recordWriterClass))
			return false;
		if (serDeClass == null)
		{
			if (other.serDeClass != null)
				return false;
		}
		else if (!serDeClass.equals(other.serDeClass))
			return false;
		if (serDeProps == null)
		{
			if (other.serDeProps != null)
				return false;
		}
		else if (!serDeProps.equals(other.serDeProps))
			return false;
		return true;
	}
	
	public String toString()
	{
		StringBuilder buf = new StringBuilder();
		
		buf.append("output(");
		buf.append(path);
		
		if ( serDeClass != null)
		{
			buf.append(", ").append("serde = ").append(serDeClass);
			if ( serDeProps != null)
			{
				buf.append(" with ");
				boolean sfirst = true;
				for(Map.Entry<String, String> entry : serDeProps.entrySet())
				{
					if (sfirst ) sfirst=false; else buf.append(", ");
					buf.append(entry.getKey()).append(" = ").append(entry.getValue());
				}
			}
			
			if ( outputFormatClass != null)
			{
				buf.append(" format").append(outputFormatClass);
			}
			else
			{
				buf.append(" recordwriter").append(recordWriterClass);
			}
		}
		
		if ( hiveTable != null)
		{
			buf.append(" load");
			if (overwriteHiveTable ) buf.append(" overwrite");
			buf.append(" into table");
			buf.append(hiveTable);
			if (partitionClause != null )
			{
				buf.append(" partition ").append(partitionClause);
			}
		}
		
		buf.append(")");
		return buf.toString();
	}
}
