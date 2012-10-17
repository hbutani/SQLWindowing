package com.sap.hadoop.windowing.runtime2;

import org.junit.Test;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.testutils.MRBaseTest;

public class MRExecutorTest extends MRBaseTest
{
	@Test
	public void test1() throws WindowingException {
		System.out.println("Beginning test1");
		QueryDef qdef =  wshell.translate("select  p_mfgr,p_name, p_size, rank() as r, denserank() as dr " +
				"from part " +
				"partition by p_mfgr " +
				"order by p_mfgr " +
				"window w1 as rows between 2 preceding and 2 following " +
				"into path='/tmp/test1' " +
				"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' " +
				"with serdeproperties('field.delim'=',') " +
				"format 'org.apache.hadoop.mapred.TextOutputFormat'");
		execute(qdef);
		String s = getOutput(qdef);
		System.out.println(s);
	}
		@Test
	 public void test2() throws WindowingException {
		 System.out.println("Beginning test2");
		 QueryDef qdef = wshell.translate("select p_mfgr,p_name,p_size,p_comment " +
		 "from part " +
		 "partition by p_mfgr " +
		 "order by p_size " +
		 "into path='/tmp/test2' " +
		 "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' " +
		 "with serdeproperties('field.delim'=',') " +
		 "format 'org.apache.hadoop.mapred.TextOutputFormat'");
		 execute(qdef);
			String s = getOutput(qdef);
			System.out.println(s);
	 }

	 
	 @Test
	 public void testSum()
	  throws WindowingException {
		 System.out.println("Beginning testSum");
		 QueryDef qDef = wshell.translate("select  p_mfgr,p_name, p_size, \n" + 
		 		"sum(p_size) as s \n" + 
		 		"from part		" +
		 		" partition by p_mfgr \n" + 
		 		"order by p_mfgr \n" + 
		 		"window w1 as rows between 2 preceding and 2 following \n" + 
		 		"into path='/tmp/testSum' \n" + 
		 		"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'		" +
		 		"with serdeproperties('field.delim'=',') \n" + 
		 		"format 'org.apache.hadoop.mapred.TextOutputFormat'");
		 execute(qDef);
			String s = getOutput(qDef);
			System.out.println(s);
	 }
	 
	 @Test
	 public void testSumWindow()
	  throws WindowingException {
		 System.out.println("Beginning testSumWindow");
		 QueryDef qDef = wshell.translate("select  p_mfgr,p_name, p_size, \n" + 
		 		"sum(p_size) over w1 as s, \n" + 
		 		"sum(p_size) over rows between current row and current row as s2 \n" + 
		 		"from part \n" + 
		 		"partition by p_mfgr \n" + 
		 		"order by p_mfgr \n" + 
		 		"window w1 as rows between 2 preceding and 2 following \n" + 
		 		"into path='/tmp/testSumWindow' \n" + 
		 		"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n" + 
		 		"with serdeproperties('field.delim'=',') \n" + 
		 		"format 'org.apache.hadoop.mapred.TextOutputFormat'");
		 	execute(qDef);
			String s = getOutput(qDef);
			System.out.println(s);
	 }
	 
	 @Test
	 public void testFirstLastValue()
	  throws WindowingException {
		 System.out.println("Beginning testFirstLastValue");
		 QueryDef qDef = wshell.translate("select  p_mfgr,p_name, p_size, \n" + 
		 		"sum(p_size) over rows between current row and current row as s2, \n" + 
		 		"first_value(p_size) over w1 as f, \n" + 
		 		"last_value(p_size, false) over w1 as l \n" + 
		 		"from part \n" + 
		 		"partition by p_mfgr \n" + 
		 		"order by p_mfgr \n" + 
		 		"window w1 as rows between 2 preceding and 2 following \n" + 
		 		"into path='/tmp/testFirstLastValue' \n" + 
		 		"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n" + 
		 		"with serdeproperties('field.delim'=',') \n" + 
		 		"format 'org.apache.hadoop.mapred.TextOutputFormat'");
		 execute(qDef);
			String s = getOutput(qDef);
			System.out.println(s);

	 }

	 @Test
	 public void testWhere()
	  throws WindowingException {
		 System.out.println("Beginning testWhere");
		 QueryDef qDef = wshell.translate("		 select  p_mfgr,p_name, p_size, \n" + 
		 		"rank() as r, \n" + 
		 		"sum(p_size) over rows between current row and current row as s2, \n" + 
		 		"first_value(p_size) over w1 as f, \n" + 
		 		"last_value(p_size, false) over w1 as l \n" + 
		 		"from part \n" + 
		 		"partition by p_mfgr \n" + 
		 		"order by p_mfgr \n" + 
		 		"where r < 7 or p_mfgr = 'Manufacturer#3' \n" + 
		 		"window w1 as rows between 2 preceding and 2 following \n" + 
		 		"into path='/tmp/testWhere' \n" + 
		 		"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n" + 
		 		"with serdeproperties('field.delim'=',') \n" + 
		 		"format 'org.apache.hadoop.mapred.TextOutputFormat'");
		 execute(qDef);
			String s = getOutput(qDef);
			System.out.println(s);

	 }

		
	 		@Test
	 public void testLead()
	  throws WindowingException {
	 System.out.println("Beginning testLead");
	 QueryDef qDef = wshell.translate("	 select  p_mfgr,p_name, p_size,	 p_size - lead(p_size,1) as deltaSz \n" + 
	 		"from part \n" + 
	 		"partition by p_mfgr \n" + 
	 		"order by p_mfgr \n" + 
	 		"window w1 as rows between 2 preceding and 2 following \n" + 
	 		"into path='/tmp/testLead' \n" + 
	 		"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n" + 
	 		"with serdeproperties('field.delim'=',') \n" + 
	 		"format 'org.apache.hadoop.mapred.TextOutputFormat'");
	 execute(qDef);
		String s = getOutput(qDef);
		System.out.println(s);

	 }
 @Test
	 public void testLag()
	  throws WindowingException {
	 System.out.println("Beginning testLag");
	 QueryDef qDef = wshell.translate("	 select  p_mfgr,p_name, p_size,	 p_size - lag(p_size,1) as deltaSz \n" + 
	 		"from part \n" + 
	 		"partition by p_mfgr \n" + 
	 		"order by p_mfgr \n" + 
	 		"window w1 as rows between 2 preceding and 2 following \n" + 
	 		"into path='/tmp/testLag' \n" + 
	 		"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n" + 
	 		"with serdeproperties('field.delim'=',') \n" + 
	 		"format 'org.apache.hadoop.mapred.TextOutputFormat'");
	 execute(qDef);
		String s = getOutput(qDef);
		System.out.println(s);

	 }
	 // sum(row(i) - row(i-1)) = row(n) - row(1)
	 @Test
	 public void testSumDelta()
	  throws WindowingException {
	 System.out.println("Beginning testSumDelta");
	 QueryDef qDef = wshell.translate("	 select  p_mfgr,p_name, p_size,	 sum(p_size - lag(p_size,1)) as deltaSum \n" + 
	 		"from part \n" + 
	 		"partition by p_mfgr \n" + 
	 		"order by p_mfgr \n" + 
	 		"window w1 as rows between 2 preceding and 2 following \n" + 
	 		"into path='/tmp/testSumDelta' \n" + 
	 		"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n" + 
	 		"with serdeproperties('field.delim'=',') \n" + 
	 		"format 'org.apache.hadoop.mapred.TextOutputFormat'");
	 execute(qDef);
		String s = getOutput(qDef);
		System.out.println(s);

	 }
	 @Test
	 public void testWhereLead()
	  throws WindowingException {
	 System.out.println("Beginning testWhereLead");
	 QueryDef qDef = wshell.translate("	 select  p_mfgr,p_name, p_size \n" + 
	 		"from part \n" + 
	 		"partition by p_mfgr \n" + 
	 		"order by p_mfgr \n" + 
	 		"where lead(p_size, 1) <= p_size \n" + 
	 		"into path='/tmp/testWhereLead' \n" + 
	 		"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n" + 
	 		"with serdeproperties('field.delim'=',') \n" + 
	 		"format 'org.apache.hadoop.mapred.TextOutputFormat'");
	 execute(qDef);
		String s = getOutput(qDef);
		System.out.println(s);

	 }
	 

}
