package com.sap.hadoop.windowing.runtime.mr

import org.apache.hadoop.conf.Configuration;
import org.junit.Test;

import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.io.IOUtils;
import com.sap.hadoop.windowing.io.WindowingInput;

import org.apache.hadoop.io.Writable;

class HiveRTTest extends MRBaseTest
{

	@Test
	void test1()
	{
		WindowingInput wIn = IOUtils.createTableWindowingInput(null, "part", wshell.cfg)
		
		Writable w = wIn.createRow();
		
		
		
		while( wIn.next(w) != -1)
		{
			println w
		}
	}
}
