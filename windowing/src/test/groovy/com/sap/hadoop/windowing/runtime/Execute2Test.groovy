package com.sap.hadoop.windowing.runtime

import java.beans.XMLEncoder;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.hadoop.windowing.MRBase2Test;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.functions2.TableFunctionResolver;
import com.sap.hadoop.windowing.io.IOUtils;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.runtime.hive.EvalContext;
import com.sap.hadoop.windowing.runtime2.Partition;

import java.beans.ExceptionListener;
import java.io.PrintWriter;

class Execute2Test extends MRBase2Test
{
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
		
// TODO: revisit persistence of QueryDef.
//		File f = File.createTempFile("SQW-", null);
//		FileOutputStream out = new FileOutputStream(f);
//		
//		XMLEncoder e = new XMLEncoder(out);
//		e.setExceptionListener( new EL());
//		// workaround for java 1.5
//			
//		e.writeObject(qDef);
//		e.close();
		
		TableFuncDef tabDef = (TableFuncDef) qDef.getInput();
		TableFunctionEvaluator tEval = tabDef.getEvaluator();
		TableFunctionResolver tResolver = tEval.getResolver();
		String partClassName = tResolver.getPartitionClass();
		int partMemSize = tResolver.getPartitionMemSize();
		
		Partition p = IOUtils.createPartition(partClassName, partMemSize, eCtx.wIn);
		
		Partition oP = tEval.execute(p);
		IOUtils.dumpPartition(oP, System.out);
	}
}

class EL implements ExceptionListener
{
      public void exceptionThrown(Exception e) {
        throw new RuntimeException("Cannot serialize the query plan", e);
      }
    }
