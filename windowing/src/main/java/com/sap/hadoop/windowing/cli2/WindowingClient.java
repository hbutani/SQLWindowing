package com.sap.hadoop.windowing.cli2;

import org.apache.hadoop.hive.ql.session.SessionState.LogHelper;

import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.translate.Translator;
import com.sap.hadoop.windowing.runtime2.HiveQueryExecutor;
import com.sap.hadoop.windowing.runtime2.QueryOutputPrinter;
import com.sap.hadoop.windowing.runtime2.WindowingShell;
import com.sap.hadoop.windowing.runtime2.mr.MRExecutor;

import static com.sap.hadoop.Utils.sprintf;

class WindowingClient implements HiveQueryExecutor
{
	WindowingHiveCliDriver hiveDriver;
	WindowingShell wshell;
	QueryOutputPrinter qryOutPrntr;
	LogHelper hiveConsole;
	
	WindowingClient(WindowingHiveCliDriver hiveDriver) throws WindowingException
	{
		this.hiveDriver = hiveDriver;
		wshell = new WindowingShell( hiveDriver.getCfg(), new Translator(), new MRExecutor());
		wshell.setHiveQryExec(this);
		qryOutPrntr = new QueryOutputPrinter(hiveDriver.getHiveConsole());
		hiveConsole = hiveDriver.getHiveConsole();
	}
	
	void executeQuery(String query) throws WindowingException
	{
		wshell.execute(query, (outputQueryResult() ? qryOutPrntr : null));
	}
	
	void checkQuery(String query) throws WindowingException
	{
		wshell.checkQuery(query);
	}
	
	public void executeHiveQuery(String hQry) throws WindowingException
	{
		hiveConsole.printInfo(sprintf("Executing Embedded Hive Query:\n %s\n", hQry ));
		int rc = 0;
		try
		{
			rc = hiveDriver.processEmbeddedQuery(hQry);
		}
		catch(Throwable t)
		{
			throw new WindowingException(sprintf("Error while executing hive query '%s'", hQry), t);
		}
		finally
		{
			hiveConsole.printInfo(sprintf("Finished Executing Embedded Hive Query\n"));
		}
		
		if ( rc != 0)
		{
			throw new WindowingException(sprintf("Failed to execute query '%s', return = %d", hQry, rc));
		}
	}
	
	public String createTableAsQuery(String hQry) throws WindowingException
	{
		String tableName = sprintf("WindowingTempTable_%d", System.currentTimeMillis());
		hQry = sprintf("Create table %s as %s", tableName, hQry);
		executeHiveQuery(hQry);
		return tableName;
	}
	
	public void dropTable(String tableName) throws WindowingException
	{
		String hQry = sprintf("drop table %s", tableName);
		executeHiveQuery(hQry);
	}
	
	private boolean outputQueryResult()
	{
		return wshell.getCfg().getBoolean(Constants.WINDOWING_OUTPUT_QUERY_RESULT, false);
	}
}
