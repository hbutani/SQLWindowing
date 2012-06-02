package com.sap.hadoop.windowing.benchmark.tpch;

import org.junit.Test;

import com.sap.hadoop.windowing.MRBaseTest;

class BasicPerfTest  extends MRBaseTest
{
	@Test
	void testText()
	{
		wshell.execute("""
		from part
		partition by p_mfgr
		order by p_mfgr, p_name
		with
		rank() as r
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout2'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		with serdeproperties('field.delim'=',')
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}

}
