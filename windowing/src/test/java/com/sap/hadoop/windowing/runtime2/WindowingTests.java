package com.sap.hadoop.windowing.runtime2;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.testutils.MRBaseTest;
import com.sap.hadoop.windowing.testutils.WParameterized;
import com.sap.hadoop.windowing.testutils.WindowingTest;

@RunWith(WParameterized.class)
public class WindowingTests extends MRBaseTest
{
	public WindowingTest wTest;
	
	public WindowingTests(WindowingTest wTest)
	{
		this.wTest = wTest;
	}
	
	@Parameters
	public static Collection<Object[]> propertyNames() 
	{
		return Arrays.asList(WindowingTestsFactory.TESTS);
	}
	
	@Test
	public void testWQuery() throws WindowingException
	{
		System.out.println("Running test: " + wTest.getName());
		wshell.execute(wTest.getQuery(), outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		Assert.assertEquals(r, wTest.getResult());
	}
}
