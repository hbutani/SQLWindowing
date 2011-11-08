package com.sap.hadoop.windowing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.apache.hadoop.conf.Configuration;

import com.sap.hadoop.windowing.query.LocalTranslator;
import com.sap.hadoop.windowing.runtime.Mode;
import com.sap.hadoop.windowing.runtime.TestExecutor;

abstract class BaseTest
{
	static WindowingShell wshell;
	static basedir = "src/test/groovy"
	static ByteArrayOutputStream outStream;
	
	@BeforeClass
	public static void setupClass()
	{
		outStream = new ByteArrayOutputStream()
		wshell = new WindowingShell(new Configuration(), new LocalTranslator(), new TestExecutor(out : new PrintStream(outStream)))
	}
	
	@Before
	public void setup()
	{
		outStream.reset();
	}
}
