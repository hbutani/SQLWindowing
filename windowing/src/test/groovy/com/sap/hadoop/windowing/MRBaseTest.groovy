package com.sap.hadoop.windowing;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.ThreadPoolExecutor.Worker;

import org.junit.Before;
import org.junit.BeforeClass;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;

import com.sap.hadoop.windowing.runtime.mr.MRTranslator;
import com.sap.hadoop.windowing.runtime.mr.MRExecutor;
import com.sap.hadoop.windowing.runtime.Mode;
import com.sap.hadoop.windowing.runtime.TestExecutor;
import com.sap.hadoop.windowing.runtime.ThriftBasedHiveQueryExecutor;
import com.sap.hadoop.windowing.runtime.WindowingShell;

abstract class MRBaseTest
{
	static WindowingShell wshell;
	static basedir = "src/test/groovy"
	static ByteArrayOutputStream outStream;
	
	@BeforeClass
	public static void setupClass()
	{
		outStream = new ByteArrayOutputStream()

		Configuration conf = WORK();
		conf.setBoolean(Constants.WINDOWING_TEST_MODE, true)
		HiveConf hCfg = new HiveConf(conf, conf.getClass())

		wshell = new WindowingShell(hCfg, new MRTranslator(), 
			new MRExecutor())
		wshell.hiveQryExec = new ThriftBasedHiveQueryExecutor(conf)
	}

	@Before
	public void setup()
	{
		outStream.reset();
	}

	public static Configuration WORK()
	{
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://localhost:9000");
		conf.set("mapred.job.tracker", "localhost:9001");
		conf.set("hive.metastore.uris", "thrift://localhost:9083");
		conf.set("hive.metastore.local", "false");
		conf.set("windowing.jar.file", "/home/saplabs/Projects/SQLWindowing/windowing/target/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar");
		
		conf.set(Constants.HIVE_THRIFTSERVER, "localhost");
		conf.setInt(Constants.HIVE_THRIFTSERVER_PORT, 10000)
		conf.set("HIVE_HOME", "/home/saplabs/Projects/hive/build/dist");
		conf.set("hadoop.bin.path", "/home/pkalmegh/Projects/hadoop/bin/hadoop");
		return conf;
	}

	public static Configuration HOME()
	{
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://localhost:9000");
		conf.set("mapred.job.tracker", "localhost:9001");
		conf.set("hive.metastore.uris", "thrift://localhost:9083");
		conf.set("hive.metastore.local", "false");
		conf.set("windowing.jar.file", "/home/pkalmegh/Projects/SQLWindowing/windowing/target/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar");
		
		conf.set(Constants.HIVE_THRIFTSERVER, "localhost");
		conf.setInt(Constants.HIVE_THRIFTSERVER_PORT, 10000)
		conf.set("HIVE_HOME", "/home/pkalmegh/Projects/hive/build/dist");
		conf.set("hadoop.bin.path", "/home/pkalmegh/Projects/hadoop/bin/hadoop");
		return conf;
	}

	public static Configuration HOME_LOCALMR()
	{
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://localhost:9000");
		//conf.set("mapred.job.tracker", "localhost:9001");
		conf.set("hive.metastore.uris", "thrift://localhost:9083");
		conf.set("hive.metastore.local", "false");
		conf.set("windowing.jar.file", "/home/pkalmegh/Projects/SQLWindowing/windowing/target/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar");

		conf.set(Constants.HIVE_THRIFTSERVER, "localhost");
		conf.setInt(Constants.HIVE_THRIFTSERVER_PORT, 10000)
		conf.set("HIVE_HOME", "/home/pkalmegh/Projects/hive/build/dist");
		conf.set("hadoop.bin.path", "/home/pkalmegh/Projects/hadoop/bin/hadoop");
		conf.set("hive.exec.submitviachild","false");
		conf.set("mapred.job.tracker","nonlocal");
		return conf;
	}

	public static Configuration WORK_LOCALMR()
	{
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://localhost:9000");
		//conf.set("mapred.job.tracker", "localhost:9001");
		conf.set("hive.metastore.uris", "thrift://localhost:9083");
		conf.set("hive.metastore.local", "false");
		conf.set("windowing.jar.file", "/home/saplabs/Projects/SQLWindowing/windowing/target/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar");
		
		conf.set(Constants.HIVE_THRIFTSERVER, "localhost");
		conf.setInt(Constants.HIVE_THRIFTSERVER_PORT, 10000)
		conf.set("HIVE_HOME", "/home/saplabs/Projects/hive/build/dist");
		conf.set("hadoop.bin.path", "/home/pkalmegh/Projects/hadoop/bin/hadoop");
		conf.set("hive.exec.submitviachild","false");

		return conf;
	}
}
