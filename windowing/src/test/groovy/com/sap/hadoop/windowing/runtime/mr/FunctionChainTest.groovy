package com.sap.hadoop.windowing.runtime.mr;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.query.Query;

class FunctionChainTest extends MRBaseTest
{	
	@Test
	void test1()
	{
//		int jobId = System.currentTimeMillis()
//		String jobWorkingDir = JobBase.getJobWorkingDir(wshell.cfg, jobId)
		
		wshell.execute("""
		from noop(
               noop(
                 noop(part_rc partition by p_mfgr order by p_mfgr, p_name)
			   ) partition by p_mfgr order by p_mfgr, p_name
             ) partition by p_mfgr order by p_mfgr, p_name
with
  rank() as r
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}
	
	@Test
	void test2()
	{
//		int jobId = System.currentTimeMillis()
//		String jobWorkingDir = JobBase.getJobWorkingDir(wshell.cfg, jobId)
		wshell.execute("""
		from noop(
			   noopwithmap(
				 noop(part_rc partition by p_mfgr order by p_mfgr, p_name)
			   )
			 ) partition by p_mfgr order by p_mfgr, p_name
with
  rank() as r
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}
}
