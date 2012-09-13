package com.sap.hadoop.windowing.runtime

import java.beans.XMLEncoder;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.hadoop.windowing.MRBase2Test;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.functions2.TableFunctionResolver;
import com.sap.hadoop.windowing.io.IOUtils;
import com.sap.hadoop.windowing.query2.definition.OrderDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.runtime.hive.EvalContext;
import com.sap.hadoop.windowing.runtime2.Partition;

import java.beans.ExceptionListener;
import java.io.PrintWriter;

class Execute2Test extends MRBase2Test
{
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	static EvalContext eCtx;
	
	@BeforeClass
	public static void setupClass()
	{
		MRBase2Test.setupClass();
		eCtx = new EvalContext(wshell.cfg)
	}
	
	@Before
	public void setup()
	{
		eCtx.wIn = IOUtils.createTableWindowingInput(null, "part", wshell.cfg)
	}
	
	public static void execute(QueryDef qDef)
	{
		TableFuncDef tabDef = (TableFuncDef) qDef.getInput();
		TableFunctionEvaluator tEval = tabDef.getFunction();
		TableFunctionResolver tResolver = tEval.getResolver();
		String partClassName = tEval.getPartitionClass();
		int partMemSize = tEval.getPartitionMemSize();
		
		Partition p = IOUtils.createPartition(partClassName, partMemSize, eCtx.wIn);
		
		Partition oP = tEval.execute(p);
		IOUtils.dumpPartition(oP, System.out);
	}
	
	@Test
	void test1()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
	rank() as r,
	denserank() as dr
from part
partition by p_mfgr
order by p_mfgr
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		execute(qDef)
	}
	
	@Test
	void testAddInOrder()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
	rank() as r,
	denserank() as dr
from part
partition by p_mfgr
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		OrderDef oDef = qDef?.input?.window?.orderDef
		assert oDef != null
		assert oDef?.spec?.columns[0]?.columnName == 'p_mfgr'
		
	}
	
	@Test
	void testWindowClause()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
	sum(p_size) over w1 as s,
	denserank() as dr
from part
partition by p_mfgr
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		assert qDef?.selectList?.windowFuncs[0]?.window?.window?.start?.amt == 2
		assert qDef?.selectList?.windowFuncs[0]?.window?.window?.end?.amt == 2
		
	}
	
	@Test
	void testAssertIncompatiblePartitionClause()
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("Window Function 'sum((TABLEORCOL p_size)) w1 partitionColumns=[p_name] window(start=range(2 PRECEDING), end=range(2 FOLLOWING))  as s' has an incompatible partition clause");
		
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
	sum(p_size) over w1 as s,
	denserank() as dr
from part
partition by p_mfgr
window w1 as partition by p_name rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}
	
	@Test
	void testAssertIncompatibleOrderClause()
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("Window Function 'sum((TABLEORCOL p_size)) w1 partitionColumns=[p_mfgr] orderColumns=[p_name ASC] window(start=range(2 PRECEDING), end=range(2 FOLLOWING))  as s' has an incompatible order clause");
		
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
	sum(p_size) over w1 as s,
	denserank() as dr
from part
partition by p_mfgr
window w1 as partition by p_mfgr order by p_name rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}
	
	@Test
	void testInvalidValueBoundary()
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("Primitve type STRING not supported in Value Boundary expression");
		
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
	sum(p_size) over w1 as s,
	denserank() as dr
from part
partition by p_mfgr
window w1 as range between p_name 2 less and current row
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}
	
	@Test
	void testSum()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
	sum(p_size) as s
from part
partition by p_mfgr
order by p_mfgr
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		execute(qDef)
	}
	
	@Test
	void testSumWindow()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
	sum(p_size) over w1 as s,
    sum(p_size) over rows between current row and current row as s2
from part
partition by p_mfgr
order by p_mfgr
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		execute(qDef)
	}
	
	@Test
	void testFirstLastValue()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
    sum(p_size) over rows between current row and current row as s2,
	first_value(p_size) over w1 as f,
	last_value(p_size, false) over w1 as l
from part
partition by p_mfgr
order by p_mfgr
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		execute(qDef)
	}
}
