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
	
//	static EvalContext eCtx;
	
	@BeforeClass
	public static void setupClass()
	{
		MRBase2Test.setupClass();
//		eCtx = new EvalContext(wshell.cfg)
	}
	
	@Before
	public void setup()
	{
		super.setup();
//		eCtx.wIn = IOUtils.createTableWindowingInput(null, "part", wshell.cfg)
	}
	
	public static void execute(QueryDef qDef)
	{
		/*TableFuncDef tabDef = (TableFuncDef) qDef.getInput();
		TableFunctionEvaluator tEval = tabDef.getFunction();
		TableFunctionResolver tResolver = tEval.getResolver();
		String partClassName = tEval.getPartitionClass();
		int partMemSize = tEval.getPartitionMemSize();
		
		Partition p = IOUtils.createPartition(partClassName, partMemSize, eCtx.wIn);
		
		Partition oP = tEval.execute(p);
		IOUtils.dumpPartition(oP, System.out);*/
		wshell.executor.execute(qDef, wshell);
	}
	
	@Test
	void test1()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
	rank() as r,
	denserank() as dr
from part_demo
partition by p_mfgr
order by p_mfgr
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		execute(qDef)
		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
//		println r
		String e = """Manufacturer#1,almond antique burnished rose metallic,2,1,1
Manufacturer#1,almond antique burnished rose metallic,2,1,1
Manufacturer#1,almond antique chartreuse lavender yellow,34,1,1
Manufacturer#1,almond antique salmon chartreuse burlywood,6,1,1
Manufacturer#1,almond aquamarine burnished black steel,28,1,1
Manufacturer#1,almond aquamarine pink moccasin thistle,42,1,1
Manufacturer#2,almond antique violet chocolate turquoise,14,1,1
Manufacturer#2,almond antique violet turquoise frosted,40,1,1
Manufacturer#2,almond aquamarine midnight light salmon,2,1,1
Manufacturer#2,almond aquamarine rose maroon antique,25,1,1
Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,1,1
Manufacturer#3,almond antique chartreuse khaki white,17,1,1
Manufacturer#3,almond antique forest lavender goldenrod,14,1,1
Manufacturer#3,almond antique metallic orange dim,19,1,1
Manufacturer#3,almond antique misty red olive,1,1,1
Manufacturer#3,almond antique olive coral navajo,45,1,1
Manufacturer#4,almond antique gainsboro frosted violet,10,1,1
Manufacturer#4,almond antique violet mint lemon,39,1,1
Manufacturer#4,almond aquamarine floral ivory bisque,27,1,1
Manufacturer#4,almond aquamarine yellow dodger mint,7,1,1
Manufacturer#4,almond azure aquamarine papaya violet,12,1,1
Manufacturer#5,almond antique blue firebrick mint,31,1,1
Manufacturer#5,almond antique medium spring khaki,6,1,1
Manufacturer#5,almond antique sky peru orange,2,1,1
Manufacturer#5,almond aquamarine dodger light gainsboro,46,1,1
Manufacturer#5,almond azure blanched chiffon midnight,23,1,1
"""
		assert r == e
	}
	
	@Test
	void testAddInOrder()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
	rank() as r,
	denserank() as dr
from part_demo
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
from part_demo
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
from part_demo
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
from part_demo
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
from part_demo
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
from part_demo
partition by p_mfgr
order by p_mfgr
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		execute(qDef)
		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
//		println r
		String e = """Manufacturer#1,almond antique burnished rose metallic,2,114
Manufacturer#1,almond antique burnished rose metallic,2,114
Manufacturer#1,almond antique chartreuse lavender yellow,34,114
Manufacturer#1,almond antique salmon chartreuse burlywood,6,114
Manufacturer#1,almond aquamarine burnished black steel,28,114
Manufacturer#1,almond aquamarine pink moccasin thistle,42,114
Manufacturer#2,almond antique violet chocolate turquoise,14,99
Manufacturer#2,almond antique violet turquoise frosted,40,99
Manufacturer#2,almond aquamarine midnight light salmon,2,99
Manufacturer#2,almond aquamarine rose maroon antique,25,99
Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,99
Manufacturer#3,almond antique chartreuse khaki white,17,96
Manufacturer#3,almond antique forest lavender goldenrod,14,96
Manufacturer#3,almond antique metallic orange dim,19,96
Manufacturer#3,almond antique misty red olive,1,96
Manufacturer#3,almond antique olive coral navajo,45,96
Manufacturer#4,almond antique gainsboro frosted violet,10,95
Manufacturer#4,almond antique violet mint lemon,39,95
Manufacturer#4,almond aquamarine floral ivory bisque,27,95
Manufacturer#4,almond aquamarine yellow dodger mint,7,95
Manufacturer#4,almond azure aquamarine papaya violet,12,95
Manufacturer#5,almond antique blue firebrick mint,31,108
Manufacturer#5,almond antique medium spring khaki,6,108
Manufacturer#5,almond antique sky peru orange,2,108
Manufacturer#5,almond aquamarine dodger light gainsboro,46,108
Manufacturer#5,almond azure blanched chiffon midnight,23,108
"""
		assert r == e
	}
	
	@Test
	void testSumWindow()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
	sum(p_size) over w1 as s,
    sum(p_size) over rows between current row and current row as s2
from part_demo
partition by p_mfgr
order by p_mfgr
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		execute(qDef)
		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
//		println r
		String e = """Manufacturer#1,almond antique burnished rose metallic,2,38,2
Manufacturer#1,almond antique burnished rose metallic,2,44,2
Manufacturer#1,almond antique chartreuse lavender yellow,34,72,34
Manufacturer#1,almond antique salmon chartreuse burlywood,6,112,6
Manufacturer#1,almond aquamarine burnished black steel,28,110,28
Manufacturer#1,almond aquamarine pink moccasin thistle,42,76,42
Manufacturer#2,almond antique violet chocolate turquoise,14,56,14
Manufacturer#2,almond antique violet turquoise frosted,40,81,40
Manufacturer#2,almond aquamarine midnight light salmon,2,99,2
Manufacturer#2,almond aquamarine rose maroon antique,25,85,25
Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,45,18
Manufacturer#3,almond antique chartreuse khaki white,17,50,17
Manufacturer#3,almond antique forest lavender goldenrod,14,51,14
Manufacturer#3,almond antique metallic orange dim,19,96,19
Manufacturer#3,almond antique misty red olive,1,79,1
Manufacturer#3,almond antique olive coral navajo,45,65,45
Manufacturer#4,almond antique gainsboro frosted violet,10,76,10
Manufacturer#4,almond antique violet mint lemon,39,83,39
Manufacturer#4,almond aquamarine floral ivory bisque,27,95,27
Manufacturer#4,almond aquamarine yellow dodger mint,7,85,7
Manufacturer#4,almond azure aquamarine papaya violet,12,46,12
Manufacturer#5,almond antique blue firebrick mint,31,39,31
Manufacturer#5,almond antique medium spring khaki,6,85,6
Manufacturer#5,almond antique sky peru orange,2,108,2
Manufacturer#5,almond aquamarine dodger light gainsboro,46,77,46
Manufacturer#5,almond azure blanched chiffon midnight,23,71,23
"""
		assert r == e
	}
	
	@Test
	void testFirstLastValue()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
    sum(p_size) over rows between current row and current row as s2,
	first_value(p_size) over w1 as f,
	last_value(p_size, false) over w1 as l
from part_demo
partition by p_mfgr
order by p_mfgr
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		execute(qDef)
		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
//		println r
		String e = """Manufacturer#1,almond antique burnished rose metallic,2,2,2,34
Manufacturer#1,almond antique burnished rose metallic,2,2,2,6
Manufacturer#1,almond antique chartreuse lavender yellow,34,34,2,28
Manufacturer#1,almond antique salmon chartreuse burlywood,6,6,2,42
Manufacturer#1,almond aquamarine burnished black steel,28,28,34,42
Manufacturer#1,almond aquamarine pink moccasin thistle,42,42,6,42
Manufacturer#2,almond antique violet chocolate turquoise,14,14,14,2
Manufacturer#2,almond antique violet turquoise frosted,40,40,14,25
Manufacturer#2,almond aquamarine midnight light salmon,2,2,14,18
Manufacturer#2,almond aquamarine rose maroon antique,25,25,40,18
Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,18,2,18
Manufacturer#3,almond antique chartreuse khaki white,17,17,17,19
Manufacturer#3,almond antique forest lavender goldenrod,14,14,17,1
Manufacturer#3,almond antique metallic orange dim,19,19,17,45
Manufacturer#3,almond antique misty red olive,1,1,14,45
Manufacturer#3,almond antique olive coral navajo,45,45,19,45
Manufacturer#4,almond antique gainsboro frosted violet,10,10,10,27
Manufacturer#4,almond antique violet mint lemon,39,39,10,7
Manufacturer#4,almond aquamarine floral ivory bisque,27,27,10,12
Manufacturer#4,almond aquamarine yellow dodger mint,7,7,39,12
Manufacturer#4,almond azure aquamarine papaya violet,12,12,27,12
Manufacturer#5,almond antique blue firebrick mint,31,31,31,2
Manufacturer#5,almond antique medium spring khaki,6,6,31,46
Manufacturer#5,almond antique sky peru orange,2,2,31,23
Manufacturer#5,almond aquamarine dodger light gainsboro,46,46,6,23
Manufacturer#5,almond azure blanched chiffon midnight,23,23,2,23
"""
		assert r == e
	}
	
	@Test
	void testWhere()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
	rank() as r,
	sum(p_size) over rows between current row and current row as s2,
	first_value(p_size) over w1 as f,
	last_value(p_size, false) over w1 as l
from part_demo
partition by p_mfgr
order by p_mfgr
where l < 20 or p_mfgr = 'Manufacturer#3'
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		execute(qDef)
		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
//		println r
		String e = """Manufacturer#1,almond antique burnished rose metallic,2,1,2,2,6
Manufacturer#2,almond antique violet chocolate turquoise,14,1,14,14,2
Manufacturer#2,almond aquamarine midnight light salmon,2,1,2,14,18
Manufacturer#2,almond aquamarine rose maroon antique,25,1,25,40,18
Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,1,18,2,18
Manufacturer#3,almond antique chartreuse khaki white,17,1,17,17,19
Manufacturer#3,almond antique forest lavender goldenrod,14,1,14,17,1
Manufacturer#3,almond antique metallic orange dim,19,1,19,17,45
Manufacturer#3,almond antique misty red olive,1,1,1,14,45
Manufacturer#3,almond antique olive coral navajo,45,1,45,19,45
Manufacturer#4,almond antique violet mint lemon,39,1,39,10,7
Manufacturer#4,almond aquamarine floral ivory bisque,27,1,27,10,12
Manufacturer#4,almond aquamarine yellow dodger mint,7,1,7,39,12
Manufacturer#4,almond azure aquamarine papaya violet,12,1,12,27,12
Manufacturer#5,almond antique blue firebrick mint,31,1,31,31,2
"""
		assert r == e
	}
	
	@Test
	void testLead()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
p_size - lead(p_size,1) as deltaSz
from part_demo
partition by p_mfgr
order by p_mfgr
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		execute(qDef)
		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
//		println r
		String e = """Manufacturer#1,almond antique burnished rose metallic,2,0
Manufacturer#1,almond antique burnished rose metallic,2,-32
Manufacturer#1,almond antique chartreuse lavender yellow,34,28
Manufacturer#1,almond antique salmon chartreuse burlywood,6,-22
Manufacturer#1,almond aquamarine burnished black steel,28,-14
Manufacturer#1,almond aquamarine pink moccasin thistle,42,0
Manufacturer#2,almond antique violet chocolate turquoise,14,-26
Manufacturer#2,almond antique violet turquoise frosted,40,38
Manufacturer#2,almond aquamarine midnight light salmon,2,-23
Manufacturer#2,almond aquamarine rose maroon antique,25,7
Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,0
Manufacturer#3,almond antique chartreuse khaki white,17,3
Manufacturer#3,almond antique forest lavender goldenrod,14,-5
Manufacturer#3,almond antique metallic orange dim,19,18
Manufacturer#3,almond antique misty red olive,1,-44
Manufacturer#3,almond antique olive coral navajo,45,0
Manufacturer#4,almond antique gainsboro frosted violet,10,-29
Manufacturer#4,almond antique violet mint lemon,39,12
Manufacturer#4,almond aquamarine floral ivory bisque,27,20
Manufacturer#4,almond aquamarine yellow dodger mint,7,-5
Manufacturer#4,almond azure aquamarine papaya violet,12,0
Manufacturer#5,almond antique blue firebrick mint,31,25
Manufacturer#5,almond antique medium spring khaki,6,4
Manufacturer#5,almond antique sky peru orange,2,-44
Manufacturer#5,almond aquamarine dodger light gainsboro,46,23
Manufacturer#5,almond azure blanched chiffon midnight,23,0
"""
		assert r == e
	}
	
	@Test
	void testLag()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
p_size - lag(p_size,1) as deltaSz
from part_demo
partition by p_mfgr
order by p_mfgr
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		execute(qDef)
		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
//		println r
		String e = """Manufacturer#1,almond antique burnished rose metallic,2,0
Manufacturer#1,almond antique burnished rose metallic,2,0
Manufacturer#1,almond antique chartreuse lavender yellow,34,32
Manufacturer#1,almond antique salmon chartreuse burlywood,6,-28
Manufacturer#1,almond aquamarine burnished black steel,28,22
Manufacturer#1,almond aquamarine pink moccasin thistle,42,14
Manufacturer#2,almond antique violet chocolate turquoise,14,0
Manufacturer#2,almond antique violet turquoise frosted,40,26
Manufacturer#2,almond aquamarine midnight light salmon,2,-38
Manufacturer#2,almond aquamarine rose maroon antique,25,23
Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,-7
Manufacturer#3,almond antique chartreuse khaki white,17,0
Manufacturer#3,almond antique forest lavender goldenrod,14,-3
Manufacturer#3,almond antique metallic orange dim,19,5
Manufacturer#3,almond antique misty red olive,1,-18
Manufacturer#3,almond antique olive coral navajo,45,44
Manufacturer#4,almond antique gainsboro frosted violet,10,0
Manufacturer#4,almond antique violet mint lemon,39,29
Manufacturer#4,almond aquamarine floral ivory bisque,27,-12
Manufacturer#4,almond aquamarine yellow dodger mint,7,-20
Manufacturer#4,almond azure aquamarine papaya violet,12,5
Manufacturer#5,almond antique blue firebrick mint,31,0
Manufacturer#5,almond antique medium spring khaki,6,-25
Manufacturer#5,almond antique sky peru orange,2,-4
Manufacturer#5,almond aquamarine dodger light gainsboro,46,44
Manufacturer#5,almond azure blanched chiffon midnight,23,-23
"""
		assert r == e
	}
	
	/*
	 * sum(row(i) - row(i-1)) = row(n) - row(1)
	 */
	@Test
	void testSumDelta()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
sum(p_size - lag(p_size,1)) as deltaSum
from part_demo
partition by p_mfgr
order by p_mfgr
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		execute(qDef)
		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
//		println r
		String e = """Manufacturer#1,almond antique burnished rose metallic,2,40
Manufacturer#1,almond antique burnished rose metallic,2,40
Manufacturer#1,almond antique chartreuse lavender yellow,34,40
Manufacturer#1,almond antique salmon chartreuse burlywood,6,40
Manufacturer#1,almond aquamarine burnished black steel,28,40
Manufacturer#1,almond aquamarine pink moccasin thistle,42,40
Manufacturer#2,almond antique violet chocolate turquoise,14,4
Manufacturer#2,almond antique violet turquoise frosted,40,4
Manufacturer#2,almond aquamarine midnight light salmon,2,4
Manufacturer#2,almond aquamarine rose maroon antique,25,4
Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,4
Manufacturer#3,almond antique chartreuse khaki white,17,28
Manufacturer#3,almond antique forest lavender goldenrod,14,28
Manufacturer#3,almond antique metallic orange dim,19,28
Manufacturer#3,almond antique misty red olive,1,28
Manufacturer#3,almond antique olive coral navajo,45,28
Manufacturer#4,almond antique gainsboro frosted violet,10,2
Manufacturer#4,almond antique violet mint lemon,39,2
Manufacturer#4,almond aquamarine floral ivory bisque,27,2
Manufacturer#4,almond aquamarine yellow dodger mint,7,2
Manufacturer#4,almond azure aquamarine papaya violet,12,2
Manufacturer#5,almond antique blue firebrick mint,31,-8
Manufacturer#5,almond antique medium spring khaki,6,-8
Manufacturer#5,almond antique sky peru orange,2,-8
Manufacturer#5,almond aquamarine dodger light gainsboro,46,-8
Manufacturer#5,almond azure blanched chiffon midnight,23,-8
"""
		assert r == e
	}
	
	@Test
	void testWhereLead()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size
from part_demo
partition by p_mfgr
order by p_mfgr
where lead(p_size, 1) <= p_size
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		execute(qDef)
		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		println r
		String e = """Manufacturer#1,almond antique burnished rose metallic,2
Manufacturer#1,almond antique chartreuse lavender yellow,34
Manufacturer#1,almond aquamarine pink moccasin thistle,42
Manufacturer#2,almond antique violet turquoise frosted,40
Manufacturer#2,almond aquamarine rose maroon antique,25
Manufacturer#2,almond aquamarine sandy cyan gainsboro,18
Manufacturer#3,almond antique chartreuse khaki white,17
Manufacturer#3,almond antique metallic orange dim,19
Manufacturer#3,almond antique olive coral navajo,45
Manufacturer#4,almond antique violet mint lemon,39
Manufacturer#4,almond aquamarine floral ivory bisque,27
Manufacturer#4,almond azure aquamarine papaya violet,12
Manufacturer#5,almond antique blue firebrick mint,31
Manufacturer#5,almond antique medium spring khaki,6
Manufacturer#5,almond aquamarine dodger light gainsboro,46
Manufacturer#5,almond azure blanched chiffon midnight,23
"""
		assert r == e
	}
}
