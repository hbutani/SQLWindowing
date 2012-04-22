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
		
		Configuration conf = HOME_LOCALMR();
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
		conf.set("windowing.jar.file", "e:/windowing/windowing/target/com.sap.hadoop.windowing-0.0.1-SNAPSHOT.jar");
		conf.set(" mapred.reduce.tasks", "8");
		
		conf.set(Constants.HIVE_THRIFTSERVER, "hbserver7.dhcp.pal.sap.corp")
		conf.setInt(Constants.HIVE_THRIFTSERVER_PORT, 10000)
		
		conf.set("HIVE_HOME", "e:/hadoop/hive2/hive/build/dist")
		
		conf.set("hadoop.job.ugi", "hbutani,users");
		
		return conf;
	}
	
	public static Configuration HOME()
	{
		Configuration conf = new Configuration();
		/*conf.addResource(new URL("file:///media/MyPassport/hadoop/home-configuration/hadoop-site.xml"))
		conf.addResource(new URL("file:///media/MyPassport/hadoop/home-configuration/hdfs-site.xml"))
		conf.addResource(new URL("file:///media/MyPassport/hadoop/home-configuration/mapred-site.xml"))
		conf.addResource(new URL("file:///media/MyPassport/hadoop/home-configuration/hive-site.xml"))*/
		
		conf.set("fs.default.name", "hdfs://localhost:8020");
		conf.set("mapred.job.tracker", "localhost:8021");
		
		conf.set("hive.metastore.uris", "thrift://localhost:9083");
		conf.set("hive.metastore.local", "false");
		
		conf.set("windowing.jar.file", "/media/MyPassport/windowing/windowing/target/com.sap.hadoop.windowing-0.0.2-SNAPSHOT.jar");
		conf.set(" mapred.reduce.tasks", "4");
		
		conf.set(Constants.HIVE_THRIFTSERVER, "localhost")
		conf.setInt(Constants.HIVE_THRIFTSERVER_PORT, 10000)
		
		conf.set("HIVE_HOME", "/media/MyPassport/hadoop/hive2/hive/build/dist")
		
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
		conf.set("HIVE_HOME", "/media/MyPassport/hadoop/hive2/hive/build/dist")
		
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
		conf.set("HIVE_HOME", "e:/hadoop/hive2/hive/build/dist")
		
		return conf;
	}
}
