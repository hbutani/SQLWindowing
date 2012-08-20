package com.sap.hadoop.windowing.query2.definition;

import com.sap.hadoop.windowing.query2.specification.HiveQuerySpec;

public class HiveQueryDef extends HiveTableDef
{
	
	public HiveQuerySpec getHiveQuerySpec()
	{
		return (HiveQuerySpec) inputSpec;
	}
	
}
