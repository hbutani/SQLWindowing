package com.sap.hadoop.windowing.testutils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;
import org.junit.Before;
import org.junit.BeforeClass;

import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.query2.translate.Translator;
import com.sap.hadoop.windowing.runtime2.LocalExecutor;
import com.sap.hadoop.windowing.runtime2.QueryOutputPrinter;
import com.sap.hadoop.windowing.runtime2.WindowingShell;

public class LocalExecutorTest
{
	protected static WindowingShell wshell;
	protected static String basedir = "src/test/java/data";
	protected static ByteArrayOutputStream outStream;
	protected static QueryOutputPrinter outPrinter;
	
	@BeforeClass
	public static void setupClass()
	{
		outStream = new ByteArrayOutputStream();
		
		Configuration conf = HOME();
		conf.setBoolean(Constants.WINDOWING_TEST_LOCAL_MODE, true);
		conf.set(Constants.WINDOWING_TEST_DATA_DIR, basedir);
		HiveConf hCfg = new HiveConf(conf, conf.getClass());
		
		wshell = new WindowingShell(hCfg, new Translator(), new LocalExecutor(new PrintStream(outStream)));
		//wshell.hiveQryExec = new ThriftBasedHiveQueryExecutor(conf)
		outPrinter = null;
	}
	
	@Before
	public void setup()
	{
		outStream.reset();
	}
	
	public static Configuration HOME()
	{
		Configuration conf = new Configuration();
		
		//conf.set("fs.default.name", "hdfs://localhost:8020");
		//conf.set("mapred.job.tracker", "localhost:8021");
		
		//conf.set("hive.metastore.uris", "thrift://localhost:9083");
		conf.set("javax.jdo.option.ConnectionURL", 
			"jdbc:mysql://localhost/hivems?createDatabaseIfNotExist=true");
		conf.set("javax.jdo.option.ConnectionDriverName", "com.mysql.jdbc.Driver");
		conf.set("javax.jdo.option.ConnectionUserName", "hiveuser");
		conf.set("javax.jdo.option.ConnectionPassword", "hive");
		conf.set("hive.metastore.local", "true");
		
		
		return conf;
	}
}
