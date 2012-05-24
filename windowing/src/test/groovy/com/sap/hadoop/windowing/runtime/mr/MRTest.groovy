package com.sap.hadoop.windowing.runtime.mr;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QuerySpec;

class MRTest extends MRBaseTest
{

	@Test
	void testRC()
	{
		wshell.execute("""
		from part_rc
		partition by p_mfgr
		order by p_mfgr, p_name
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
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}


	@Test
	void testText()
	{
		wshell.execute("""
		from part
		partition by p_mfgr
		order by p_mfgr, p_name
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
		into path='/tmp/wout2'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		with serdeproperties('field.delim'=',')
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}
	
	@Test
	void testSortNumeric()
	{
		wshell.execute("""
		from  <select * from part limit 1000>
		partition by p_mfgr
		order by p_mfgr, p_retailprice desc
		with
		rank() as r
select p_mfgr,p_name, p_retailprice, r
		into path='/tmp/wout2'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		with serdeproperties('field.delim'=',')
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}

}
