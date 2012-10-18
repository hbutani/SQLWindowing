package com.sap.hadoop.windowing.runtime.mr


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.hadoop.windowing.MRBase2Test;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.runtime2.mr.MRExecutor


class TestPTFOperator extends MRBase2Test {
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@BeforeClass
	public static void setupClass() {
		MRBase2Test.setupClass();
	}

	@Before
	public void setup() {
		super.setup();
	}

	private void execute(QueryDef qdef){
		MRExecutor mrExec = new MRExecutor();
		mrExec.execute(qdef, wshell);
	}

	@Test
	void testMap()
	{
		System.out.println("Beginning testMap");
		QueryDef qDef = wshell.translate("""
		select p_mfgr,p_name, p_size,
		rank() as r,
		denserank() as dr,
		cumedist() as cud,
		percentrank() as pr,
		ntile(3) as nt,
		count(p_size) as c,
		count(p_size, 'all') as ca,
		count(p_size, 'distinct') as cd,
		first_value(p_size) as fv,
		last_value(p_size) as lv,
		first_value(p_size, 'true') as fv2
		from noopwithmap(part_rc
		partition by p_mfgr
		order by p_mfgr, p_name)
		window w1 as rows between 2 preceding and 2 following 
		into path='/tmp/testMap'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		with serdeproperties('field.delim'=',')
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		execute(qDef)
	}

/*	@Test
	void test1() {
		System.out.println("Beginning test1");
		QueryDef qdef =  wshell.translate("select  p_mfgr,p_name, p_size, rank() as r, denserank() as dr " +
				"from part " +
				"partition by p_mfgr " +
				"order by p_mfgr " +
				"window w1 as rows between 2 preceding and 2 following " +
				"into path='/tmp/test1' " +
				"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' " +
				"with serdeproperties('field.delim'=',') " +
				"format 'org.apache.hadoop.mapred.TextOutputFormat'");
		execute(qdef);
	}

	@Test
	void test2(){
		System.out.println("Beginning test2");
		QueryDef qdef = wshell.translate("select p_mfgr,p_name,p_size,p_comment " +
				"from part " +
				"partition by p_mfgr " +
				"order by p_size " +
				"into path='/tmp/test2' " +
				"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' " +
				"with serdeproperties('field.delim'=',') " +
				"format 'org.apache.hadoop.mapred.TextOutputFormat'");
		execute(qdef);
	}


	@Test
	void testSum() {
		System.out.println("Beginning testSum");
		QueryDef qDef = wshell.translate("""
		 select  p_mfgr,p_name, p_size,
		 sum(p_size) as s
		 from part
		 partition by p_mfgr
		 order by p_mfgr
		 window w1 as rows between 2 preceding and 2 following
		 into path='/tmp/testSum'
		 serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		 with serdeproperties('field.delim'=',')
		 format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		execute(qDef)
	}

	@Test
	void testSumWindow() {
		System.out.println("Beginning testSumWindow");
		QueryDef qDef = wshell.translate("""
		 select  p_mfgr,p_name, p_size,
		 sum(p_size) over w1 as s,
		 sum(p_size) over rows between current row and current row as s2
		 from part
		 partition by p_mfgr
		 order by p_mfgr
		 window w1 as rows between 2 preceding and 2 following
		 into path='/tmp/testSumWindow'
		 serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		 with serdeproperties('field.delim'=',')
		 format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		execute(qDef)
	}

	@Test
	void testFirstLastValue() {
		System.out.println("Beginning testFirstLastValue");
		QueryDef qDef = wshell.translate("""
		 select  p_mfgr,p_name, p_size,
		 sum(p_size) over rows between current row and current row as s2,
		 first_value(p_size) over w1 as f,
		 last_value(p_size, false) over w1 as l
		 from part
		 partition by p_mfgr
		 order by p_mfgr
		 window w1 as rows between 2 preceding and 2 following
		 into path='/tmp/testFirstLastValue'
		 serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		 with serdeproperties('field.delim'=',')
		 format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		execute(qDef)
	}

	@Test
	void testWhere() {
		System.out.println("Beginning testWhere");
		QueryDef qDef = wshell.translate("""
		 select  p_mfgr,p_name, p_size,
		 rank() as r,
		 sum(p_size) over rows between current row and current row as s2,
		 first_value(p_size) over w1 as f,
		 last_value(p_size, false) over w1 as l
		 from part
		 partition by p_mfgr
		 order by p_mfgr
		 where r < 7 or p_mfgr = 'Manufacturer#3'
		 window w1 as rows between 2 preceding and 2 following
		 into path='/tmp/testWhere'
		 serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		 with serdeproperties('field.delim'=',')
		 format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		execute(qDef)
	}


	@Test
	void testLead() {
		System.out.println("Beginning testLead");
		QueryDef qDef = wshell.translate("""
	 select  p_mfgr,p_name, p_size,
	 p_size - lead(p_size,1) as deltaSz
	 from part
	 partition by p_mfgr
	 order by p_mfgr
	 window w1 as rows between 2 preceding and 2 following
	 into path='/tmp/testLead'
	 serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
	 with serdeproperties('field.delim'=',')
	 format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		execute(qDef)
	}
	@Test
	void testLag() {
		System.out.println("Beginning testLag");
		QueryDef qDef = wshell.translate("""
	 select  p_mfgr,p_name, p_size,
	 p_size - lag(p_size,1) as deltaSz
	 from part
	 partition by p_mfgr
	 order by p_mfgr
	 window w1 as rows between 2 preceding and 2 following
	 into path='/tmp/testLag'
	 serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
	 with serdeproperties('field.delim'=',')
	 format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		execute(qDef)
	}
	// sum(row(i) - row(i-1)) = row(n) - row(1)
	@Test
	void testSumDelta()
	{
		System.out.println("Beginning testSumDelta");
		QueryDef qDef = wshell.translate("""
	 select  p_mfgr,p_name, p_size,
	 sum(p_size - lag(p_size,1)) as deltaSum
	 from part
	 partition by p_mfgr
	 order by p_mfgr
	 window w1 as rows between 2 preceding and 2 following
	 into path='/tmp/testSumDelta'
	 serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
	 with serdeproperties('field.delim'=',')
	 format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		execute(qDef)
	}
	@Test
	void testWhereLead()
	{
		System.out.println("Beginning testWhereLead");
		QueryDef qDef = wshell.translate("""
	 select  p_mfgr,p_name, p_size
	 from part
	 partition by p_mfgr
	 order by p_mfgr
	 where lead(p_size, 1) <= p_size
	 into path='/tmp/testWhereLead'
	 serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
	 with serdeproperties('field.delim'=',')
	 format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		execute(qDef)
	}
*/
	

}
