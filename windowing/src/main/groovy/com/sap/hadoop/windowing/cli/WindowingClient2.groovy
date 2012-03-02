package com.sap.hadoop.windowing.cli

import org.apache.hadoop.hive.cli.CliDriver;
import org.apache.hadoop.hive.conf.HiveConf;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.runtime.HiveQueryExecutor;
import com.sap.hadoop.windowing.runtime.Mode;
import com.sap.hadoop.windowing.runtime.WindowingShell;
import com.sap.hadoop.windowing.runtime.mr.Job;

class WindowingClient2 implements HiveQueryExecutor
{
	String windowingJar;
	HiveConf hConf;
	CliDriver hiveDriver;
	WindowingShell wshell;

	WindowingClient2(HiveConf hConf, String windowingJar, CliDriver hiveDriver) throws WindowingException
	{
		this.hConf = hConf
		this.windowingJar = windowingJar
		this.hiveDriver = hiveDriver
		Mode wMode = Mode.MR
		this.hConf.set(Job.WINDOWING_JAR_FILE, windowingJar);
		wshell = new WindowingShell( this.hConf, wMode.getTranslator(), wMode.getExecutor())
		wshell.hiveQryExec = this
	}
	
	void executeQuery(String query) throws WindowingException
	{
		wshell.execute(query)
	}
	
	void executeHiveQuery(String hQry) throws WindowingException
	{
		int rc;
		ClassLoader cl = setClassLoader()
		try
		{
			println "Executing Embedded Hive Query..."
			rc = hiveDriver.processCmd(hQry)
			println "done executing Embedded Hive Query."
		}
		catch(Throwable t)
		{
			throw new WindowingException(sprintf("Failed to execute Hive Query %s", hQry), t)
		}
		finally
		{
			Thread.currentThread().setContextClassLoader(cl);
		}
		if ( rc != 0) throw new WindowingException(sprintf("Failed to execute Hive Query %s", hQry))
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
	
	void killServer() {}
	
	private ClassLoader setClassLoader()
	{
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		if ( cl instanceof WindowingClassLoader)
		{
			cl.setParentAsThreadLoader()
		}
		return cl;
	}
}
