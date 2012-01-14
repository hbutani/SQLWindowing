package com.sap.hadoop.windowing.runtime.mr

import org.junit.Test;
import com.sap.hadoop.windowing.MRBaseTest;

class EmbeddedHiveQueryTest extends MRBaseTest
{

	@Test
	void test1()
	{
		wshell.execute("""
		from < select p_mfgr, p_name, p_size from part_rc where p_size < 20>
		partition by p_mfgr
		order by p_mfgr, p_name
		with
		rank() as r
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout' 
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}

}
