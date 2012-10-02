package com.sap.hadoop.windowing.query2.definition;

import org.apache.hadoop.hive.serde2.SerDe;

import com.sap.hadoop.windowing.query2.specification.QueryOutputSpec;

public class QueryOutputDef
{
	QueryOutputSpec outputSpec;
	transient SerDe serDe;
	
	public QueryOutputDef(){
		
	}
	
	public QueryOutputSpec getSpec()
	{
		return outputSpec;
	}
	
	public void setSpec(QueryOutputSpec outputSpec)
	{
		this.outputSpec = outputSpec;
	}
	
	public SerDe getSerDe()
	{
		return serDe;
	}

	public void setSerDe(SerDe serDe)
	{
		this.serDe = serDe;
	}

	public QueryOutputSpec getOutputSpec()
	{
		return outputSpec;
	}

	public void setOutputSpec(QueryOutputSpec outputSpec)
	{
		this.outputSpec = outputSpec;
	}
		
}
