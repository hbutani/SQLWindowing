package com.sap.hadoop.windowing.runtime.mr;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.hadoop.windowing.MRBaseTest;

class CompositeDataTypeMRTest extends MRBaseTest
{

	@Test
	void test1()
	{
		wshell.execute("""
		from table1
    partition by a
	order by a
	with
		sum(<b?.size()>) as cn[int]
	select a, b, c, d, cn
	into path='/tmp/wout' 
	serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' 
	format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}
	
	@Test
	void test2()
	{
		wshell.execute("""
		from table1
	partition by a
	order by a
	with
		sum(<b?.size()>) as cn[int]
	select a, <b && b.size() \\> 0 ? b[0..0] : b > as bsubset['array<string>'], c, d, cn
	into path='/tmp/wout'
	serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
	format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}
}