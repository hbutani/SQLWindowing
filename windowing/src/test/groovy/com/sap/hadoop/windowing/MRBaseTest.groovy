package com.sap.hadoop.windowing;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

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
		Configuration conf = HOME();
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
		conf.set("fs.default.name", "hdfs://hbserver1.dhcp.pal.sap.corp:8020");
		conf.set("mapred.job.tracker", "hbserver1.dhcp.pal.sap.corp:8021");
		
		conf.set("hive.metastore.uris", "thrift://hbserver7.dhcp.pal.sap.corp:9083");
		//conf.set("hive.metastore.uris", "thrift://localhost:9083");
		conf.set("hive.metastore.local", "false");
		conf.set("windowing.jar.file", "e:/windowing/windowing/target/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar");
		conf.set(" mapred.reduce.tasks", "8");
		
		conf.set(Constants.HIVE_THRIFTSERVER, "hbserver7.dhcp.pal.sap.corp")
		conf.setInt(Constants.HIVE_THRIFTSERVER_PORT, 10000)
		conf.set("HIVE_HOME", "e:/hadoop/hive-0.9.0-bin")
		conf.set("hadoop.bin.path", "/home/pkalmegh/Projects/hadoop/bin/hadoop");
		conf.set("hive.added.jars.path", "file:///home/pkalmegh/Projects/hive/build/dist/lib/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar," +
			"file:///home/pkalmegh/Projects/hive/build/dist/lib/antlr-runtime-3.0.1.jar," +
			"file:///home/pkalmegh/Projects/hive/build/dist/lib/groovy-all-1.8.0.jar," +
			"file:///home/pkalmegh/Projects/hive/build/dist/lib/hive-metastore-0.10.0-SNAPSHOT.jar");

		conf.set("hadoop.job.ugi", "hbutani,users");
		return conf;
	}
	
	public static Configuration HOME()
	{
		Configuration conf = new Configuration();
		
		conf.set("fs.default.name", "hdfs://localhost:8020");
		conf.set("mapred.job.tracker", "localhost:8021");
		
		conf.set("hive.metastore.uris", "thrift://localhost:9083");
		conf.set("hive.metastore.local", "false");
		
		conf.set("windowing.jar.file", "/media/MyPassport/windowing/windowing/target/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar");
		//conf.set(" mapred.reduce.tasks", "2");
		
		
		conf.set("io.sort.mb", "200");
		conf.set("mapred.compress.map.output", "true");
		
		conf.set(Constants.HIVE_THRIFTSERVER, "localhost")
		conf.setInt(Constants.HIVE_THRIFTSERVER_PORT, 10000)
		String hiveHome = "/media/MyPassport/hadoop/hive2/hive/build/dist";
		conf.set("HIVE_HOME", hiveHome)
		conf.set(HiveConf.ConfVars.HIVEADDEDJARS.toString(), 
			"file:///media/MyPassport/windowing/windowing/target/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar," +
			"file://$hiveHome/lib/antlr-runtime-3.0.1.jar," +
			"file://$hiveHome/lib/groovy-all-1.8.0.jar," +
			"file://$hiveHome/lib/hive-metastore-0.10.0-SNAPSHOT.jar");
		conf.set("mapred.child.java.opts", "-Xms1024m -Xmx2048m")
		return conf;
	}
	
	public static Configuration HOME_LOCALMR()
	{
		Configuration conf = new Configuration();
		
		/*conf.addResource("/media/MyPassport/hadoop/hime-configuration/hadoop-site.xml")
		conf.addResource("/media/MyPassport/hadoop/hime-configuration/hdfs-site.xml")
		//conf.addResource("/media/MyPassport/hadoop/hime-configuration/mapred-site.xml")
		conf.addResource("/media/MyPassport/hadoop/hime-configuration/hive-site.xml")*/
		
		conf.set("fs.default.name", "hdfs://localhost:8020");
		//conf.set("mapred.job.tracker", "localhost:8021");
		
		conf.set("hive.metastore.uris", "thrift://localhost:9083");
		conf.set("hive.metastore.local", "false");
		
		conf.set("windowing.jar.file", "/media/MyPassport/windowing/windowing/target/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar");
		//conf.set(" mapred.reduce.tasks", "4");
		
		conf.set(Constants.HIVE_THRIFTSERVER, "localhost")
		conf.setInt(Constants.HIVE_THRIFTSERVER_PORT, 10000)
		conf.set("HIVE_HOME", "/media/MyPassport/hadoop/hive-0.9.0-bin")
		conf.set("hadoop.bin.path", "/home/pkalmegh/Projects/hadoop/bin/hadoop");
		conf.set("hive.exec.submitviachild","false");
		conf.set("mapred.job.tracker","local");
		conf.set("hive.added.jars.path", "file:///home/pkalmegh/Projects/hive/build/dist/lib/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar," +
			"file:///home/pkalmegh/Projects/hive/build/dist/lib/antlr-runtime-3.0.1.jar," +
			"file:///home/pkalmegh/Projects/hive/build/dist/lib/groovy-all-1.8.0.jar," +
			"file:///home/pkalmegh/Projects/hive/build/dist/lib/hive-metastore-0.10.0-SNAPSHOT.jar");
		return conf;
	}
	
	public static Configuration WORK_LOCALMR()
	{
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://hbserver1.dhcp.pal.sap.corp:8020");
		//conf.set("mapred.job.tracker", "hbserver1.dhcp.pal.sap.corp:8021");
		
		conf.set("hive.metastore.uris", "thrift://hbserver7.dhcp.pal.sap.corp:9083");
		//conf.set("hive.metastore.uris", "thrift://localhost:9083");
		conf.set("hive.metastore.local", "false");
		conf.set("windowing.jar.file", "e:/windowing/windowing/target/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar");
		
		conf.set(Constants.HIVE_THRIFTSERVER, "hbserver7.dhcp.pal.sap.corp")
		conf.setInt(Constants.HIVE_THRIFTSERVER_PORT, 10000)
		conf.set("HIVE_HOME", "e:/hadoop/hive-0.9.0-bin")
		conf.set("hadoop.bin.path", "/home/pkalmegh/Projects/hadoop/bin/hadoop");
		conf.set("hive.exec.submitviachild","false");
		conf.set("mapred.job.tracker","local");
		conf.set("hive.added.jars.path", "file:///home/pkalmegh/Projects/hive/build/dist/lib/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar," +
			"file:///home/pkalmegh/Projects/hive/build/dist/lib/antlr-runtime-3.0.1.jar," +
			"file:///home/pkalmegh/Projects/hive/build/dist/lib/groovy-all-1.8.0.jar," +
			"file:///home/pkalmegh/Projects/hive/build/dist/lib/hive-metastore-0.10.0-SNAPSHOT.jar");
		
		return conf;
	}
}
