package com.sap.hadoop.windowing

import java.io.ByteArrayOutputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;
import org.junit.Before;
import org.junit.BeforeClass;

import com.sap.hadoop.windowing.query2.translate.Translator;
import com.sap.hadoop.windowing.runtime2.Executor;
import com.sap.hadoop.windowing.runtime2.ThriftBasedHiveQueryExecutor;
import com.sap.hadoop.windowing.runtime2.WindowingShell;

class MRBase2Test
{
	static WindowingShell wshell;
	static basedir = "src/test/groovy"
	static ByteArrayOutputStream outStream;
	
	@BeforeClass
	public static void setupClass()
	{
		outStream = new ByteArrayOutputStream()
		
		Configuration conf = MRBaseTest.HOME();
		conf.setBoolean(Constants.WINDOWING_TEST_MODE, true)
		HiveConf hCfg = new HiveConf(conf, conf.getClass())
		
		wshell = new WindowingShell(hCfg, new Translator(), new Executor())
		wshell.hiveQryExec = new ThriftBasedHiveQueryExecutor(conf)
	}
	
	@Before
	public void setup()
	{
		outStream.reset();
	}
}
