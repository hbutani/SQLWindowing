package com.sap.hadoop.windowing.runtime2;

import org.junit.Test;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.testutils.MRBaseTest;

public class MRExecutorTest extends MRBaseTest
{
	@Test
	public void test1() throws WindowingException
	{
		QueryDef qDef = wshell.translate("select  p_mfgr,p_name, p_size,\n" +
				"rank() as r,\n" +
				"denserank() as dr\n" +
				"from part\n" +
				"partition by p_mfgr\n" +
				"order by p_mfgr\n" +
				"window w1 as rows between 2 preceding and 2 following\n" +
				"into path='/tmp/wout2'\n" +
				"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'\n" +
				"with serdeproperties('field.delim'=',')\n" +
				"format 'org.apache.hadoop.mapred.TextOutputFormat'");
		
		execute(qDef);
		
		String s = getOutput(qDef);
		System.out.println(s);
	}
}
