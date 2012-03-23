package com.sap.hadoop.windowing.query;


import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.runtime.mr.JobBase;

class QueryComponentizerTest extends MRBaseTest
{
	@Test
	void test1()
	{
		int jobId = System.currentTimeMillis()
		String jobWorkingDir = JobBase.getJobWorkingDir(wshell.cfg, jobId)
		
		Query qry = wshell.translate("""
		from noop(
               noop(
                 noop(part_rc partition by p_mfgr order by p_mfgr, p_name)
			   ) partition by p_mfgr order by p_mfgr, p_name
             ) partition by p_mfgr order by p_mfgr, p_name
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		QueryComponentizer qC = new QueryComponentizer(qry, wshell.hiveQryExec);
		
		ArrayList<Integer> splits = qC.computeSplitPositions()
		
		println splits
		
		ArrayList<QuerySpec> components = qC.split(qry.qSpec, splits[0])
		println components
	}
}
