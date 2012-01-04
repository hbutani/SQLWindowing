package com.sap.hadoop.windowing.runtime.mr;
import org.junit.Test;

import com.sap.hadoop.windowing.MRBaseTest;


import static org.junit.Assert.*;

class OrderingTest extends MRBaseTest
{

	@Test
	void test1()
	{
		wshell.execute("""
		from part
		partition by p_mfgr
		order by p_mfgr, p_name desc
		with
		rank() as r
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout2' format='org.apache.hadoop.mapred.TextOutputFormat'""")
	}
}
