package com.sap.hadoop.windowing.runtime.mr;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.runtime.TestQueryOutputPrinter;

class QueryOutputPrintTest extends MRBaseTest
{

	@Test
	void testRC()
	{
		wshell.execute("""
		from part_rc
		partition by p_mfgr
		order by p_mfgr, p_name
		with
		rank() as r
select p_mfgr,p_name, p_size, r
where < r <= 5>
		into path='/tmp/wout' 
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'""",
		new TestQueryOutputPrinter())
	}
}
