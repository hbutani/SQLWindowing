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
		sum(p_size) over rows between unbounded preceding and current row as s,
		sum(p_size) over rows between current row and unbounded following as s1,
		min(<p_size>) over rows between 2 preceding and 2 following as m[int],
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
select p_mfgr,p_name, p_size, r, s, s1, m, dr, cud, pr, nt, c, ca, cd, avg, st, fv,lv, fv2
		into path='/tmp/wout' format='org.apache.hadoop.mapred.TextOutputFormat'""")
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
		sum(p_size) over rows between unbounded preceding and current row as s,
		sum(p_size) over rows between current row and unbounded following as s1,
		min(<p_size>) over rows between 2 preceding and 2 following as m[int],
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
select p_mfgr,p_name, p_size, r, s, s1, m, dr, cud, pr, nt, c, ca, cd, avg, st, fv,lv, fv2
		into path='/tmp/wout2' format='org.apache.hadoop.mapred.TextOutputFormat'""")
	}

}
