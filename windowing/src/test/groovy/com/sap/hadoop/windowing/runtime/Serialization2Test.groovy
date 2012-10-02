package com.sap.hadoop.windowing.runtime

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import org.antlr.runtime.tree.TreeWizard;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.hadoop.windowing.MRBase2Test;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.io.IOUtils;
import com.sap.hadoop.windowing.parser.Windowing2Parser;
import com.sap.hadoop.windowing.query2.SerializationUtils;
import com.sap.hadoop.windowing.query2.definition.ArgDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.WindowFunctionDef;
import com.sap.hadoop.windowing.query2.translate.TranslateUtils;
import com.sap.hadoop.windowing.runtime.hive.EvalContext;

class Serialization2Test  extends MRBase2Test
{
	static EvalContext eCtx;
	
	@BeforeClass
	public static void setupClass()
	{
		MRBase2Test.setupClass();
		eCtx = new EvalContext(wshell.cfg)
	}
	
	
	
	public static void validateSerialization(QueryDef qDef)
	{
		TableFunctionEvaluator tFn = qDef.input.function
		
		validateObjectSerialization(qDef.spec, "spec")
		
		qDef.selectList.windowFuncs.each { wFnDef ->
			wFnDef?.args.each { argDef ->
				validateObjectSerialization(argDef.expression)
				validateObjectSerialization(argDef.exprNode)
			}
		}
	}
	
	public static void validateQueryDefSerialization(QueryDef qDef)
	{
		validateObjectSerialization(qDef, "querydef")
	}
	
	
	public static void validateObjectSerialization(Object o, String suffix)
	{
		File f = File.createTempFile("SQW-", suffix);
		FileOutputStream out = new FileOutputStream(f);
		try
		{
			SerializationUtils.serialize(out, o);
		}
		finally
		{
			if (out != null) out.close()
		}
		
		FileInputStream in1 = new FileInputStream(f);
		Object o1 = SerializationUtils.deserialize(in1)
		
		if ( o instanceof ExprNodeDesc )
		{
			assert o.isSame(o1)
		}
		else if ( o instanceof ASTNode )
		{
			/*
			* there is no implementation on ASTNode; so the equals fail.
			*/
			assert o.toStringTree() == o1.toStringTree()
		}
		else
		{
			/*
			 * there is no implementation on ASTNode; 
			 * so the equals fail as ASTNode is a member of many Spec classes
			 */
			//assert o == o1
			assert o.toString() == o1.toString()
		}
	}
		
	@Before
	public void setup()
	{
		eCtx.wIn = IOUtils.createTableWindowingInput(null, "part", wshell.cfg)
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
		
		validateSerialization(qDef)
	}
	
	@Test
	void testQueryDefSerialization()
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
		
		validateQueryDefSerialization(qDef)
	}

	
	@Test
	void testExpressions()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
	rank() as r,
	denserank() as dr,
	cumedist() as cud,
	percentrank() as pr,
	ntile(3) as nt,
	count(*) as c,
	count(p_size) as ca,
	count(distinct p_size) as cd,
	avg(p_size) as avg, stddev(p_size) as st,
	first_value(p_size % 5) as fv,
	last_value(p_size) as lv,
	first_value(p_size, true) over w1 as fv1
from part
partition by p_mfgr
order by p_mfgr, p_name
where p_size > 5 and p_mfgr like 'abc%'
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		validateSerialization(qDef)
	}
	
	@Test
	void testMultipleWindows()
	{
		QueryDef qDef = wshell.translate("""
select  p_mfgr,p_name, p_size,
	rank() as r,
	denserank() as dr,
	cumedist() as cud,
	sum(p_size) over rows between unbounded preceding and current row as s1,
	sum(p_size) over range between p_size 5 less and current row as s2,
	first_value(p_size, true) over w1 as fv1
from part
partition by p_mfgr
order by p_mfgr, p_name
where p_size > 5 and p_mfgr like 'abc%'
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		validateSerialization(qDef)
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
		
		validateSerialization(qDef)
	}
}
