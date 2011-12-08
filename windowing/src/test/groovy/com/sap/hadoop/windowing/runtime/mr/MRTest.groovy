package com.sap.hadoop.windowing.runtime.mr;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QuerySpec;

class MRTest extends MRBaseTest
{

	@Test
	void test1()
	{
		wshell.execute("""
		from part
		partition by p_mfgr
		order by p_mfgr, p_name
		with
			rank() as r
		select p_mfgr,p_name, p_size, r
		into path='/tmp/wout' format='org.apache.hadoop.mapred.SequenceFileOutputFormat'""")
	}
}
