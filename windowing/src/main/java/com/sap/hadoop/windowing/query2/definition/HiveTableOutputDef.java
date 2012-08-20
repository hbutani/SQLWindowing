package com.sap.hadoop.windowing.query2.definition;

public class HiveTableOutputDef extends QueryOutputDef
{
	public String getHiveTable()
	{
		return outputSpec.getHiveTable();
	}

	public String getPartitionClause()
	{
		return outputSpec.getPartitionClause();
	}

	public boolean isOverwriteHiveTable()
	{
		return outputSpec.isOverwriteHiveTable();
	}

}
