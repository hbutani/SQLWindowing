package com.sap.hadoop.windowing.runtime2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.hadoop.hive.conf.HiveConf;
import org.junit.Test;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.SerializationUtils;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.translate.QueryDefDeserializer;
import com.sap.hadoop.windowing.query2.translate.QueryDefVisitor;
import com.sap.hadoop.windowing.query2.translate.QueryDefWalker;
import com.sap.hadoop.windowing.testutils.LocalExecutorTest;

public class SerializationTest extends LocalExecutorTest
{
	public static void validateObjectSerialization(QueryDef qdef, String suffix)
			throws IOException, WindowingException
	{
		File f = new File("SQW" + suffix);
		FileOutputStream out = new FileOutputStream(f);
		try
		{
			SerializationUtils.serialize(out, qdef);
		}
		finally
		{
			if (out != null)
				out.close();
		}

		FileInputStream in1 = new FileInputStream(f);
		Object afterQDef = SerializationUtils.deserialize(in1);

		if (afterQDef instanceof QueryDef)
		{
			reconstructQueryDef((QueryDef) afterQDef, wshell.getCfg());

		}

	}

	static void reconstructQueryDef(QueryDef qDef, HiveConf hiveConf)
			throws WindowingException
	{
		QueryDefVisitor qdd = new QueryDefDeserializer(hiveConf);
		QueryDefWalker qdw = new QueryDefWalker(qdd);
		qdw.walk(qDef);
	}

	@Test
	public void test() throws Exception
	{
		System.out.println("Beginning testReduceOnlyPlan");

		QueryDef qDef = wshell
				.translate("select  p_mfgr,p_name, p_size,\n"
						+ "rank() as r,\n"
						+ "denserank() as dr\n"
						+ "from part_tiny\n"
						+ "partition by p_mfgr\n"
						+ "order by p_mfgr\n"
						+ "window w1 as rows between 2 preceding and 2 following\n"
						+ "into path='/tmp/wout2'\n"
						+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'\n"
						+ "with serdeproperties('field.delim'=',')\n"
						+ "format 'org.apache.hadoop.mapred.TextOutputFormat'");

		validateObjectSerialization(qDef, ".qdef");

	}
	
	@Test
	public void testNPath() throws Exception
	{
		System.out.println("Beginning testReduceOnlyPlan");

		QueryDef qDef = wshell
				.translate(" select origin_city_name, fl_num, year, month, day_of_month, sz, tpath " +
						" from npath( " +
						"         flights_tiny " +
						"         partition by fl_num " +
						"  		  order by year, month, day_of_month, " +
						"   	  'LATE.LATE+', " +
						"  		  'LATE', arr_delay > 15, " +
						"		  'origin_city_name, fl_num, year, month, day_of_month, size(tpath) as sz, tpath as tpath' " +
						"		) " +
						" into path='/tmp/testNPath' \n" +
						" serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n" +
						" with serdeproperties('field.delim'=',') \n" +
						" format 'org.apache.hadoop.mapred.TextOutputFormat'");

		validateObjectSerialization(qDef, ".qdef");

	}

}
