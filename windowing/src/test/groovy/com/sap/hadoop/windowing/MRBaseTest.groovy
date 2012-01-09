package com.sap.hadoop.windowing;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

import org.junit.Before;
import org.junit.BeforeClass;
import org.apache.hadoop.conf.Configuration;
import com.sap.hadoop.windowing.runtime.mr.MRTranslator;
import com.sap.hadoop.windowing.runtime.mr.MRExecutor;
import com.sap.hadoop.windowing.runtime.Mode;
import com.sap.hadoop.windowing.runtime.TestExecutor;
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
		
		wshell = new WindowingShell(conf, new MRTranslator(), 
			new MRExecutor())
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
		conf.set("windowing.jar.file", "e:/windowing/windowing.jar");
		
		return conf;
	}
	
	public static Configuration HOME()
	{
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://localhost:8020");
		conf.set("mapred.job.tracker", "localhost:8021");
		
		conf.set("hive.metastore.uris", "thrift://localhost:9083");
		//conf.set("hive.metastore.uris", "thrift://localhost:9083");
		conf.set("hive.metastore.local", "false");
		conf.set("windowing.jar.file", "/media/MyPassport/windowing/windowing.jar");
		
		return conf;
	}
	
	public static Configuration HOME_LOCALMR()
	{
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://localhost:8020");
		//conf.set("mapred.job.tracker", "localhost:8021");
		
		conf.set("hive.metastore.uris", "thrift://localhost:9083");
		//conf.set("hive.metastore.uris", "thrift://localhost:9083");
		conf.set("hive.metastore.local", "false");
		conf.set("windowing.jar.file", "/media/MyPassport/windowing/windowing.jar");
		
		return conf;
	}
}
