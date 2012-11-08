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
}
