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
	
	@Test
	void test2()
	{
		wshell.execute("""
		from noop(part_rc
		partition by p_mfgr
		order by p_mfgr, p_name)
        with
		rank() as r,
		denserank() as dr,
		cumedist() as cud,
		percentrank() as pr,
		ntile(<3>) as nt,
		count(<p_size>) as c,
		count(<p_size>, 'all') as ca,
		count(<p_size>, 'distinct') as cd,
		avg(<p_size>) as avg, stddev(p_size) as st,
		first_value(p_size) as fv, last_value(p_size) as lv,
		first_value(p_size, 'true') over rows between 2 preceding and 2 following as fv2
select p_mfgr,p_name, p_size, r, dr, cud, pr, nt, c, ca, cd, avg, st, fv,lv, fv2
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		with serdeproperties('field.delim'=',')
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}
	
	@Test
	void testMap()
	{
		wshell.execute("""
		from noopwithmap(part_rc
		partition by p_mfgr
		order by p_mfgr, p_name)
		with
		rank() as r,
		denserank() as dr,
		cumedist() as cud,
		percentrank() as pr,
		ntile(<3>) as nt,
		count(<p_size>) as c,
		count(<p_size>, 'all') as ca,
		count(<p_size>, 'distinct') as cd,
		avg(<p_size>) as avg, stddev(p_size) as st,
		first_value(p_size) as fv, last_value(p_size) as lv,
		first_value(p_size, 'true') over rows between 2 preceding and 2 following as fv2
select p_mfgr,p_name, p_size, r, dr, cud, pr, nt, c, ca, cd, avg, st, fv,lv, fv2
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		with serdeproperties('field.delim'=',')
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}


}
