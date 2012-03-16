package com.sap.hadoop.windowing.parser;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.hadoop.windowing.BaseTest;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QuerySpec;

class ParseErrorTest  extends BaseTest
{
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	void test1()
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("line 10:63 no viable alternative at input '<EOF>'");

		Query qry = wshell.translate("""
		from part_rc
		partition by p_mfgr
		order by p_mfgr, p_name
		with
			rank() as r,
			sum(p_size) over rows between unbounded preceding and current row as s
		select p_mfgr,p_name, p_size, r, s
		into path='/tmp/wout' 
		serde 'org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe'""")
	}
	
	@Test
	void test2()
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("line 9:23 extraneous input ''' expecting EOF");

		Query qry = wshell.translate("""
		from part_rc
		partition by p_mfgr
		order by p_mfgr, p_name
		with
			rank() as r,
			sum(p_size) over rows between unbounded preceding and current row as s
		select p_mfgr,p_name, p_size, r, s
		into path='/tmp/wout''""")
	}

	@Test
	void testTableFunction4()
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("Function 'npath' cannot have a partition clause, its input is a 'tableinput'");
		
		QuerySpec qSpec = wshell.parse("""
		from dummy(npath(<select p_mfgr, p_name, p_size
				from part_rc> partition by p_mfgr order by p_mfgr, p_name, '') partition by p_mfgr order by p_mfgr, p_name,
			  'a', 'b') partition by a order by a
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}
	
}
