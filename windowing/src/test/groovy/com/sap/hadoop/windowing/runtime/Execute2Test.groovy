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
Manufacturer#2,almond antique violet chocolate turquoise,14,7,2
Manufacturer#2,almond antique violet turquoise frosted,40,7,2
Manufacturer#2,almond aquamarine midnight light salmon,2,7,2
Manufacturer#2,almond aquamarine rose maroon antique,25,7,2
Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,7,2
Manufacturer#3,almond antique chartreuse khaki white,17,12,3
Manufacturer#3,almond antique forest lavender goldenrod,14,12,3
Manufacturer#3,almond antique metallic orange dim,19,12,3
Manufacturer#3,almond antique misty red olive,1,12,3
Manufacturer#3,almond antique olive coral navajo,45,12,3
Manufacturer#4,almond antique gainsboro frosted violet,10,17,4
Manufacturer#4,almond antique violet mint lemon,39,17,4
Manufacturer#4,almond aquamarine floral ivory bisque,27,17,4
Manufacturer#4,almond aquamarine yellow dodger mint,7,17,4
Manufacturer#4,almond azure aquamarine papaya violet,12,17,4
Manufacturer#5,almond antique blue firebrick mint,31,22,5
Manufacturer#5,almond antique medium spring khaki,6,22,5
Manufacturer#5,almond antique sky peru orange,2,22,5
Manufacturer#5,almond aquamarine dodger light gainsboro,46,22,5
Manufacturer#5,almond azure blanched chiffon midnight,23,22,5
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
		String e = """Manufacturer#1,almond antique burnished rose metallic,2,512
Manufacturer#1,almond antique burnished rose metallic,2,512
Manufacturer#1,almond antique chartreuse lavender yellow,34,512
Manufacturer#1,almond antique salmon chartreuse burlywood,6,512
Manufacturer#1,almond aquamarine burnished black steel,28,512
Manufacturer#1,almond aquamarine pink moccasin thistle,42,512
Manufacturer#2,almond antique violet chocolate turquoise,14,512
Manufacturer#2,almond antique violet turquoise frosted,40,512
Manufacturer#2,almond aquamarine midnight light salmon,2,512
Manufacturer#2,almond aquamarine rose maroon antique,25,512
Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,512
Manufacturer#3,almond antique chartreuse khaki white,17,512
Manufacturer#3,almond antique forest lavender goldenrod,14,512
Manufacturer#3,almond antique metallic orange dim,19,512
Manufacturer#3,almond antique misty red olive,1,512
Manufacturer#3,almond antique olive coral navajo,45,512
Manufacturer#4,almond antique gainsboro frosted violet,10,512
Manufacturer#4,almond antique violet mint lemon,39,512
Manufacturer#4,almond aquamarine floral ivory bisque,27,512
Manufacturer#4,almond aquamarine yellow dodger mint,7,512
Manufacturer#4,almond azure aquamarine papaya violet,12,512
Manufacturer#5,almond antique blue firebrick mint,31,512
Manufacturer#5,almond antique medium spring khaki,6,512
Manufacturer#5,almond antique sky peru orange,2,512
Manufacturer#5,almond aquamarine dodger light gainsboro,46,512
Manufacturer#5,almond azure blanched chiffon midnight,23,512
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
Manufacturer#1,almond aquamarine burnished black steel,28,124,28
Manufacturer#1,almond aquamarine pink moccasin thistle,42,130,42
Manufacturer#2,almond antique violet chocolate turquoise,14,126,14
Manufacturer#2,almond antique violet turquoise frosted,40,123,40
Manufacturer#2,almond aquamarine midnight light salmon,2,99,2
Manufacturer#2,almond aquamarine rose maroon antique,25,102,25
Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,76,18
Manufacturer#3,almond antique chartreuse khaki white,17,93,17
Manufacturer#3,almond antique forest lavender goldenrod,14,69,14
Manufacturer#3,almond antique metallic orange dim,19,96,19
Manufacturer#3,almond antique misty red olive,1,89,1
Manufacturer#3,almond antique olive coral navajo,45,114,45
Manufacturer#4,almond antique gainsboro frosted violet,10,122,10
Manufacturer#4,almond antique violet mint lemon,39,128,39
Manufacturer#4,almond aquamarine floral ivory bisque,27,95,27
Manufacturer#4,almond aquamarine yellow dodger mint,7,116,7
Manufacturer#4,almond azure aquamarine papaya violet,12,83,12
Manufacturer#5,almond antique blue firebrick mint,31,58,31
Manufacturer#5,almond antique medium spring khaki,6,97,6
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
Manufacturer#1,almond aquamarine burnished black steel,28,28,34,14
Manufacturer#1,almond aquamarine pink moccasin thistle,42,42,6,40
Manufacturer#2,almond antique violet chocolate turquoise,14,14,28,2
Manufacturer#2,almond antique violet turquoise frosted,40,40,42,25
Manufacturer#2,almond aquamarine midnight light salmon,2,2,14,18
Manufacturer#2,almond aquamarine rose maroon antique,25,25,40,17
Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,18,2,14
Manufacturer#3,almond antique chartreuse khaki white,17,17,25,19
Manufacturer#3,almond antique forest lavender goldenrod,14,14,18,1
Manufacturer#3,almond antique metallic orange dim,19,19,17,45
Manufacturer#3,almond antique misty red olive,1,1,14,10
Manufacturer#3,almond antique olive coral navajo,45,45,19,39
Manufacturer#4,almond antique gainsboro frosted violet,10,10,1,27
Manufacturer#4,almond antique violet mint lemon,39,39,45,7
Manufacturer#4,almond aquamarine floral ivory bisque,27,27,10,12
Manufacturer#4,almond aquamarine yellow dodger mint,7,7,39,31
Manufacturer#4,almond azure aquamarine papaya violet,12,12,27,6
Manufacturer#5,almond antique blue firebrick mint,31,31,7,2
Manufacturer#5,almond antique medium spring khaki,6,6,12,46
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
where r < 7 or p_mfgr = 'Manufacturer#3'
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		execute(qDef)
		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
//		println r
		String e = """Manufacturer#1,almond antique burnished rose metallic,2,1,2,2,34
Manufacturer#1,almond antique burnished rose metallic,2,1,2,2,6
Manufacturer#1,almond antique chartreuse lavender yellow,34,1,34,2,28
Manufacturer#1,almond antique salmon chartreuse burlywood,6,1,6,2,42
Manufacturer#1,almond aquamarine burnished black steel,28,1,28,34,14
Manufacturer#1,almond aquamarine pink moccasin thistle,42,1,42,6,40
Manufacturer#3,almond antique chartreuse khaki white,17,12,17,25,19
Manufacturer#3,almond antique forest lavender goldenrod,14,12,14,18,1
Manufacturer#3,almond antique metallic orange dim,19,12,19,17,45
Manufacturer#3,almond antique misty red olive,1,12,1,14,10
Manufacturer#3,almond antique olive coral navajo,45,12,45,19,39
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
		println r
	}
}
