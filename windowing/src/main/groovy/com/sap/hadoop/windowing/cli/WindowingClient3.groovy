package com.sap.hadoop.windowing.cli

import org.apache.hadoop.conf.Configuration;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.WindowingHiveCliDriver;
import com.sap.hadoop.windowing.runtime.HiveQueryExecutor;
import com.sap.hadoop.windowing.runtime.Mode;
import com.sap.hadoop.windowing.runtime.WindowingShell;

/*
 * An embedded Client to be used when using version 3.0.1 of  Antlr.  
 */
class WindowingClient3 implements HiveQueryExecutor
{
	WindowingHiveCliDriver hiveDriver;
	WindowingShell wshell;
	
	WindowingClient3(WindowingHiveCliDriver hiveDriver) throws WindowingException
	{
		this.hiveDriver = hiveDriver
		Mode wMode = Mode.MR
		wshell = new WindowingShell( hiveDriver.cfg, wMode.getTranslator(), wMode.getExecutor())
		wshell.hiveQryExec = this
	}
	
	void executeQuery(String query) throws WindowingException
	{
		wshell.execute(query);
	}
	
	void checkQuery(String query) throws WindowingException
	{
		wshell.checkQuery(query)
	}
	
	public void executeHiveQuery(String hQry) throws WindowingException
	{
		println "Executing Embedded Hive Query:\n ${hQry}\n" 
		int rc = 0;
		try
		{
			rc = hiveDriver.processEmbeddedQuery(hQry)
		}
		catch(Throwable t)
		{
			throw new WindowingException(sprintf("Error while executing hive query '%s'", hQry), t);
		}
		finally
		{
			println "Finished Executing Embedded Hive Query\n"
		}
		
		if ( rc != 0)
		{
			throw new WindowingException(sprintf("Failed to execute query '%s', return = %d", hQry, rc));
		}
	}
	
	public String createTableAsQuery(String hQry) throws WindowingException
	{
		String tableName = "WindowingTempTable_${System.currentTimeMillis()}"
		hQry = "Create table ${tableName} as ${hQry}"
		executeHiveQuery(hQry)
		return tableName
	}
	
	public void dropTable(String tableName) throws WindowingException
	{
		String hQry = "drop table ${tableName}"
		executeHiveQuery(hQry);
	}
}
