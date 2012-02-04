package com.sap.hadoop.windowing.parser;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.hadoop.windowing.BaseTest;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query.Query;

class ParseErrorTest  extends BaseTest
{
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	void test1()
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("Parse Error:NoViableAltException(-1@[])");

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
		expectedEx.expectMessage("Parse Error:MismatchedTokenException(62!=-1)");

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
}
