package com.sap.hadoop.windowing.runtime2;

import junit.framework.Assert;

import org.junit.Test;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.testutils.MRBaseTest;

public class MRExecutorTest extends MRBaseTest
{
	
	@Test
	public void testLead() throws WindowingException
	{
		wshell.execute(
				"	 select  p_mfgr,p_name, p_size,	 p_size - lead(p_size,1) as deltaSz \n"
						+ "from part_tiny \n"
						+ "partition by p_mfgr \n"
						+ "order by p_mfgr \n"
						+ "window w1 as rows between 2 preceding and 2 following \n"
						+ "into path='/tmp/testLead' \n"
						+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n"
						+ "with serdeproperties('field.delim'=',') \n"
						+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		// System.out.println(r);
		String e = "";
		Assert.assertEquals(r, e);	

	}

	@Test
	public void testLag() throws WindowingException
	{
		wshell.execute(
				"	 select  p_mfgr,p_name, p_size,	 p_size - lag(p_size,1) as deltaSz \n"
						+ "from part_tiny \n"
						+ "partition by p_mfgr \n"
						+ "order by p_mfgr \n"
						+ "window w1 as rows between 2 preceding and 2 following \n"
						+ "into path='/tmp/testLag' \n"
						+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n"
						+ "with serdeproperties('field.delim'=',') \n"
						+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		// System.out.println(r);
		String e = "";
		Assert.assertEquals(r, e);	

	}

	// sum(row(i) - row(i-1)) = row(n) - row(1)
	@Test
	public void testSumDelta() throws WindowingException
	{
		wshell.execute(
				"	 select  p_mfgr,p_name, p_size,	 sum(p_size - lag(p_size,1)) as deltaSum \n"
						+ "from part_tiny \n"
						+ "partition by p_mfgr \n"
						+ "order by p_mfgr \n"
						+ "window w1 as rows between 2 preceding and 2 following \n"
						+ "into path='/tmp/testSumDelta' \n"
						+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n"
						+ "with serdeproperties('field.delim'=',') \n"
						+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		// System.out.println(r);
		String e = "";
		Assert.assertEquals(r, e);	
	}

	
}
