package com.sap.hadoop.windowing.runtime.mr;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QuerySpec;

class TableFunctionTest extends MRBaseTest
{

	@Test
	void test1()
	{
		wshell.execute("""
		from noop(part_rc
		partition by p_mfgr
		order by p_mfgr, p_name)
		select p_mfgr,p_name, p_size
		into path='/tmp/wout' 
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}


}
