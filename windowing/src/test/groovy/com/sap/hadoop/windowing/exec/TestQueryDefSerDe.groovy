package com.sap.hadoop.windowing.exec;


import java.io.File;
import java.io.FileOutputStream;

import org.apache.hadoop.hive.conf.HiveConf
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.hadoop.windowing.MRBase2Test;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.SerializationUtils;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.translate.QueryDefDeserializer;
import com.sap.hadoop.windowing.query2.translate.QueryDefVisitor;
import com.sap.hadoop.windowing.query2.translate.QueryDefWalker;

public class TestQueryDefSerDe extends MRBase2Test
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
	public void test() {
		System.out.println("Beginning testReduceOnlyPlan");
	    
/*	    QueryDef qdef =  wshell.translate("select  p_mfgr,p_name, p_size, rank() as r, denserank() as dr " +
  		"from part " +
  		"partition by p_mfgr " +
  		"order by p_mfgr " +
  		"window w1 as rows between 2 preceding and 2 following " +
  		"into path='/tmp/wout2' " +
  		"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' " +
  		"with serdeproperties('field.delim'=',') " +
  		"format 'org.apache.hadoop.mapred.TextOutputFormat'");
*/  
	    QueryDef qDef = wshell.translate("select p_mfgr,p_name,p_size,p_comment " +
	  		"from part " +
	  		"partition by p_mfgr " +
	  		"order by p_size " +
	  		"into path='/tmp/wout2' " +
	  		"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' " +
	  		"with serdeproperties('field.delim'=',') " +
	  		"format 'org.apache.hadoop.mapred.TextOutputFormat'");
		  
		  int exitVal = validateObjectSerialization(qDef , ".qdef");

			String testName = new Exception().getStackTrace()[1].getMethodName();
			if (exitVal != 0) {
				  System.out.println(testName + " execution failed with exit status: "
					  + exitVal);
			}else
				System.out.println(testName + " execution completed successfully");
	}
	
	public static int validateObjectSerialization(QueryDef qdef, String suffix)
	{
		int status;
		File f = new File("SQW" + suffix);
		FileOutputStream out = new FileOutputStream(f);
		try
		{
			SerializationUtils.serialize(out, qdef);
		}
		finally
		{
			if (out != null) out.close()
		}
		
		FileInputStream in1 = new FileInputStream(f);
		Object afterQDef = SerializationUtils.deserialize(in1)
		
		if ( afterQDef instanceof QueryDef )
		{
			reconstructQueryDef((QueryDef) afterQDef, wshell.getCfg());
			if(afterQDef.equals(qdef)){
				status = 0 ;
			}
		}
		return status;
		
	}
	
	static void reconstructQueryDef(QueryDef qDef, HiveConf hiveConf){
		QueryDefVisitor qdd = new QueryDefDeserializer(hiveConf);
		QueryDefWalker qdw = new QueryDefWalker(qdd);
		try {
			qdw.walk(qDef);
		} catch (WindowingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	

}
