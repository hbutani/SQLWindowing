package com.sap.hadoop.windowing.runtime2;

import com.sap.hadoop.windowing.WindowingException;

public interface HiveQueryExecutor
{
	void executeHiveQuery(String hQry) throws WindowingException;
	String createTableAsQuery(String hQry) throws WindowingException;
	void dropTable(String tableName) throws WindowingException;
}
