package com.sap.hadoop.windowing.testutils;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.query2.translate.Translator;
import com.sap.hadoop.windowing.runtime2.LocalExecutor;
import com.sap.hadoop.windowing.runtime2.QueryOutputPrinter;
import com.sap.hadoop.windowing.runtime2.ThriftBasedHiveQueryExecutor;
import com.sap.hadoop.windowing.runtime2.WindowingShell;

public abstract class BaseTest extends ClusterMapReduceDelegate
{
	protected  static WindowingShell wshell;
	protected static String baseDatadir = "src/test/groovy/data";
	protected static ByteArrayOutputStream outStream;
	protected static QueryOutputPrinter outPrinter;
	
	public static void startVirtualCluster() throws Exception
	{
		/** Turn down the cluster logging to filter the noise out. Do this if the test is basically working. */
		final String rootLogLevel = System.getProperty("virtual.cluster.logLevel","WARN");
		final String testLogLevel = System.getProperty("test.log.level", "INFO");
		LOG.info("Setting Log Level to " + rootLogLevel);
		LogManager.getRootLogger().setLevel(Level.toLevel(rootLogLevel));
		
		/** Turn up the logging on this class and the delegate. */
		LOG.setLevel(Level.toLevel(testLogLevel));
		ClusterMapReduceDelegate.LOG.setLevel(Level.toLevel(testLogLevel));
		
		
		setupTestClass(false);
		/** Verify that there is a JobConf object for the cluster. */
		assertNotNull("Cluster initialized Correctly", getConf());
		/** Verify that the file system object is available. */
		assertNotNull("Cluster has a file system", getFs());
	}
	
	public static void setupCluster() throws Exception
	{
		outStream = new ByteArrayOutputStream();
		startVirtualCluster();
		HOME(getConf());
		conf.setBoolean(Constants.WINDOWING_TEST_MODE, true);
		
		createTestData();
		
	}
	
	@BeforeClass
	public static void setupClass() throws Exception
	{
		setupCluster();
		
		HiveConf hCfg = new HiveConf(conf, conf.getClass());
		wshell = new WindowingShell(hCfg, new Translator(), new LocalExecutor(new PrintStream(outStream)));
		wshell.setHiveQryExec(new ThriftBasedHiveQueryExecutor(conf));
		outPrinter = null;
	}
	
	
	@AfterClass
	public static void stopVirtualCluster() throws Exception 
	{
		teardownTestClass();
	}
	
	@Before
	public void setup()
	{
		outStream.reset();
	}
	
	public static void createTestData() throws Exception
	{
		FileSystem fs = FileSystem.get(conf);
		FileUtil.copy(new File(baseDatadir + "/parttiny/"), 
				fs, new Path("/user/hive/warehouse/part_demo/"), 
				false, 
				conf);
	}
	
	public static void WORK(Configuration conf)
	{
		conf.set("hive.metastore.uris", "thrift://localhost:9083");
		conf.set("hive.metastore.local", "false");
		conf.set("windowing.jar.file", "/home/saplabs/Projects/SQLWindowing/windowing/target/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar");
		
		conf.set(Constants.HIVE_THRIFTSERVER, "localhost");
		conf.setInt(Constants.HIVE_THRIFTSERVER_PORT, 10000);
		conf.set("HIVE_HOME", "/home/saplabs/Projects/hive/build/dist");
	}
	
	public static void HOME(Configuration conf)
	{
		conf.set("hive.metastore.uris", "thrift://localhost:9083");
		conf.set("hive.metastore.local", "false");
		
		conf.set("windowing.jar.file", "/media/MyPassport/windowing/windowing/target/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar");
		
		conf.set("io.sort.mb", "200");
		conf.set("mapred.compress.map.output", "true");
		
		conf.set(Constants.HIVE_THRIFTSERVER, "localhost");
		conf.setInt(Constants.HIVE_THRIFTSERVER_PORT, 10000);
		String hiveHome = "/media/MyPassport/hadoop/hive2/hive/build/dist";
		conf.set("HIVE_HOME", hiveHome);
		conf.set(HiveConf.ConfVars.HIVEADDEDJARS.toString(), 
			"file:///media/MyPassport/windowing/windowing/target/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar," +
			"file:///media/MyPassport/hadoop/hive2/hive/build/dist/lib/antlr-runtime-3.0.1.jar," +
			"file:///media/MyPassport/hadoop/hive2/hive/build/dist/lib/groovy-all-1.8.0.jar," +
			"file:///media/MyPassport/hadoop/hive2/hive/build/dist/lib/hive-metastore-0.10.0-SNAPSHOT.jar");
		conf.set("mapred.child.java.opts", "-Xms1024m -Xmx2048m");
	}
}
