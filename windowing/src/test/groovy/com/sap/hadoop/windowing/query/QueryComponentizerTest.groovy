package com.sap.hadoop.windowing.query;


import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.functions.AbstractTableFunction;
import com.sap.hadoop.windowing.functions.FunctionRegistry;
import com.sap.hadoop.windowing.functions.Noop;
import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
import com.sap.hadoop.windowing.runtime.mr.JobBase;
import com.sap.hadoop.windowing.runtime.mr.JobSpec;

class QueryComponentizerTest extends MRBaseTest
{
	
	@BeforeClass
	public static void setupClass()
	{
		FunctionRegistry.registerTableClass(Noop2.class)
		FunctionRegistry.registerTableClass(Noop3.class)
		FunctionRegistry.registerTableClass(MapNoop4.class)
		MRBaseTest.setupClass()
	}
	
	@Test
	void test1()
	{
		int jobId = System.currentTimeMillis()
		String jobWorkingDir = JobBase.getJobWorkingDir(wshell.cfg, jobId)
		
		Query qry = wshell.translate("""
		from noop3(
               noop2(
                 noop(part_rc partition by p_mfgr order by p_mfgr, p_name)
			   ) partition by p_mfgr order by p_mfgr, p_name
             ) partition by p_mfgr order by p_mfgr, p_name
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		QueryComponentizer qC = new QueryComponentizer(qry, wshell.hiveQryExec);
		ArrayList<QuerySpec> components = qC.componentize();
		//println components
		JobSpec jSpec = new JobSpec(components)
		println jSpec
	}
	
	@Test
	void test2()
	{
		int jobId = System.currentTimeMillis()
		String jobWorkingDir = JobBase.getJobWorkingDir(wshell.cfg, jobId)
		
		Query qry = wshell.translate("""
		from noop2(
			   mapnoop4(
				 noop(part_rc partition by p_mfgr order by p_mfgr, p_name)
			   )
			 ) partition by p_mfgr order by p_mfgr, p_name
with
  rank() as r
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		QueryComponentizer qC = new QueryComponentizer(qry, wshell.hiveQryExec);
		ArrayList<QuerySpec> components = qC.componentize();
		//println components
		
		JobSpec jSpec = new JobSpec(components)
		println jSpec
	}
	
	@Test
	void test3()
	{
		int jobId = System.currentTimeMillis()
		String jobWorkingDir = JobBase.getJobWorkingDir(wshell.cfg, jobId)
		
		Query qry = wshell.translate("""
		from part_rc partition by p_mfgr order by p_mfgr, p_name
with
  rank() as r
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		QueryComponentizer qC = new QueryComponentizer(qry, wshell.hiveQryExec);
		ArrayList<QuerySpec> components = qC.componentize();
		//println components
		JobSpec jSpec = new JobSpec(components)
		println jSpec
	}
}

@FunctionDef(
	name = "noop2",
	supportsWindow = true,
	args = [],
	description = "test function2"
)
class Noop2 extends Noop
{
	
}

@FunctionDef(
	name = "noop3",
	supportsWindow = true,
	args = [],
	description = "test function3"
)
class Noop3 extends Noop
{
	
}

@FunctionDef(
	name = "mapnoop4",
	supportsWindow = true,
	args = [],
	hasMapPhase = true,
	description = "test function3"
)
class MapNoop4 extends Noop
{
	
}