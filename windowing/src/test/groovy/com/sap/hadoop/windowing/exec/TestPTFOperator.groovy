package com.sap.hadoop.windowing.exec


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.hadoop.windowing.MRBase2Test;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.runtime2.mr.QueryDefExecutor


class TestPTFOperator extends MRBase2Test
{
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@BeforeClass
	public static void setupClass()
	{
		MRBase2Test.setupClass();
	}
	
	@Before
	public void setup()
	{
		super.setup();
	}
	

	
	@Test
	void test1()
	{
		System.out.println("Beginning testReduceOnlyPlan");
	    
	    
	    QueryDef qdef =  wshell.translate("select  p_mfgr,p_name, p_size, rank() as r, denserank() as dr " +
  		"from part " +
  		"partition by p_mfgr " +
  		"order by p_mfgr " +
  		"window w1 as rows between 2 preceding and 2 following " +
  		"into path='/tmp/wout2' " +
  		"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' " +
  		"with serdeproperties('field.delim'=',') " +
  		"format 'org.apache.hadoop.mapred.TextOutputFormat'");
  
/*	    QueryDef qdef = wshell.translate("select p_mfgr,p_name,p_size,p_comment " +
	  		"from part " +
	  		"partition by p_mfgr " +
	  		"order by p_size " +
	  		"into path='/tmp/wout-pk' " +
	  		"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' " +
	  		"with serdeproperties('field.delim'=',') " +
	  		"format 'org.apache.hadoop.mapred.TextOutputFormat'");
		  
*/	    	int exitVal = QueryDefExecutor.executeQuery(wshell.getCfg(), qdef);
			String testName = new Exception().getStackTrace()[1].getMethodName();
			if (exitVal != 0) {
				  System.out.println(testName + " execution failed with exit status: "
					  + exitVal);
			}else
				System.out.println(testName + " execution completed successfully");

	}
	
}
