package com.sap.hadoop.windowing.runtime2;

//import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.OrderDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.RangeBoundaryDef;
import com.sap.hadoop.windowing.testutils.LocalExecutorTest;

public class LocalExecutorTests extends LocalExecutorTest
{
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void test1() throws WindowingException
	{
		wshell.execute("select  p_mfgr,p_name, p_size,\n" +
				"rank() as r,\n" +
				"denserank() as dr\n" +
				"from part_tiny\n" +
				"partition by p_mfgr\n" +
				"order by p_mfgr\n" +
				"window w1 as rows between 2 preceding and 2 following\n" +
				"into path='/tmp/wout2'\n" +
				"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'\n" +
				"with serdeproperties('field.delim'=',')\n" +
				"format 'org.apache.hadoop.mapred.TextOutputFormat'", outPrinter);
		
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		System.out.println(r);
		//String e = WindowingTestsFactory.BASIC.getResult().replaceAll("\t", ",");
		//Assert.assertEquals(r, e);
	}
	
	@Test
	public void testAssertIncompatiblePartitionClause() throws WindowingException
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("Window Function 'sum((TABLEORCOL p_size)) w1 partitionColumns=[p_name] window(start=range(2 PRECEDING), end=range(2 FOLLOWING))  as s' has an incompatible partition clause");
		
		wshell.translate("select  p_mfgr,p_name, p_size, " +
				"sum(p_size) over w1 as s, " +
				" denserank() as dr " +
				" from part_demo " +
				" partition by p_mfgr" +
				" window w1 as partition by p_name rows between 2 preceding and 2 following" +
				" into path='/tmp/wout2'" +
				" serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'" +
				" with serdeproperties('field.delim'=',')" +
				" format 'org.apache.hadoop.mapred.TextOutputFormat'");
	}
	
	
	@Test
	public void testAssertIncompatibleOrderClause() throws WindowingException
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("Window Function 'sum((TABLEORCOL p_size)) w1 partitionColumns=[p_mfgr] orderColumns=[p_name ASC] window(start=range(2 PRECEDING), end=range(2 FOLLOWING))  as s' has an incompatible order clause");
		
		wshell.translate("select  p_mfgr,p_name, p_size, " +
				"sum(p_size) over w1 as s, " +
				" denserank() as dr " +
				" from part_demo " +
				" partition by p_mfgr" +
				" window w1 as partition by p_mfgr order by p_name rows between 2 preceding and 2 following" +
				" into path='/tmp/wout2'" +
				" serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'" +
				" with serdeproperties('field.delim'=',')" +
				" format 'org.apache.hadoop.mapred.TextOutputFormat'");
	}
	
	@Test
	public void testAddInOrder() throws WindowingException
	{
		QueryDef qDef = wshell.translate("select  p_mfgr,p_name, p_size, " +
				"sum(p_size) over w1 as s, " +
				" denserank() as dr " +
				" from part_demo " +
				" partition by p_mfgr" +
				" window w1 as rows between 2 preceding and 2 following" +
				" into path='/tmp/wout2'" +
				" serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'" +
				" with serdeproperties('field.delim'=',')" +
				" format 'org.apache.hadoop.mapred.TextOutputFormat'");
		
		OrderDef oDef = qDef.getInput().getWindow().getOrderDef();
		assert oDef != null;
		assert oDef.getSpec().getColumns().get(0).getColumnName() == "p_mfgr";
		
	}
	
	@Test
	public void testWindowClause() throws WindowingException
	{
		QueryDef qDef = wshell.translate("select  p_mfgr,p_name, p_size, " +
				"sum(p_size) over w1 as s, " +
				" denserank() as dr " +
				" from part_demo " +
				" partition by p_mfgr" +
				" window w1 as rows between 2 preceding and 2 following" +
				" into path='/tmp/wout2'" +
				" serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'" +
				" with serdeproperties('field.delim'=',')" +
				" format 'org.apache.hadoop.mapred.TextOutputFormat'");
		
		RangeBoundaryDef rBdef = (RangeBoundaryDef) qDef.getSelectList().getWindowFuncs().get(0).getWindow().getWindow().getStart();
		assert rBdef.getAmt() == 2;
		rBdef = (RangeBoundaryDef) qDef.getSelectList().getWindowFuncs().get(0).getWindow().getWindow().getEnd();
		assert rBdef.getAmt() == 2;
		
	}
	
	@Test
	public void testInvalidValueBoundary() throws WindowingException
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("Primitve type STRING not supported in Value Boundary expression");
		
		wshell.translate("select  p_mfgr,p_name, p_size, " +
				"sum(p_size) over w1 as s, " +
				" denserank() as dr " +
				" from part_demo " +
				" partition by p_mfgr" +
				" window w1 as range between p_name 2 less and current row" +
				" into path='/tmp/wout2'" +
				" serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'" +
				" with serdeproperties('field.delim'=',')" +
				" format 'org.apache.hadoop.mapred.TextOutputFormat'");
	}
	
	@Test
	public void testLead() throws WindowingException
	{
		wshell.execute("select  p_mfgr,p_name, p_size, " +
				"p_size - lead(p_size,1) as deltaSz " +
				" from part_tiny " +
				" partition by p_mfgr" +
				" window w1 as rows between 2 preceding and 2 following" +
				" into path='/tmp/wout2'" +
				" serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'" +
				" with serdeproperties('field.delim'=',')" +
				" format 'org.apache.hadoop.mapred.TextOutputFormat'", outPrinter);
		
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		System.out.println(r);
		String e = "Manufacturer#1,almond antique burnished rose metallic,2,0\n" +
				"Manufacturer#1,almond antique burnished rose metallic,2,-32\n" +
				"Manufacturer#1,almond antique chartreuse lavender yellow,34,28\n" +
				"Manufacturer#1,almond antique salmon chartreuse burlywood,6,-22\n" +
				"Manufacturer#1,almond aquamarine burnished black steel,28,-14\n" +
				"Manufacturer#1,almond aquamarine pink moccasin thistle,42,0\n" +
				"Manufacturer#2,almond antique violet chocolate turquoise,14,-26\n" +
				"Manufacturer#2,almond antique violet turquoise frosted,40,38\n" +
				"Manufacturer#2,almond aquamarine midnight light salmon,2,-23\n" +
				"Manufacturer#2,almond aquamarine rose maroon antique,25,7\n" +
				"Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,0\n" +
				"Manufacturer#3,almond antique chartreuse khaki white,17,3\n" +
				"Manufacturer#3,almond antique forest lavender goldenrod,14,-5\n" +
				"Manufacturer#3,almond antique metallic orange dim,19,18\n" +
				"Manufacturer#3,almond antique misty red olive,1,-44\n" +
				"Manufacturer#3,almond antique olive coral navajo,45,0\n" +
				"Manufacturer#4,almond antique gainsboro frosted violet,10,-29\n" +
				"Manufacturer#4,almond antique violet mint lemon,39,12\n" +
				"Manufacturer#4,almond aquamarine floral ivory bisque,27,20\n" +
				"Manufacturer#4,almond aquamarine yellow dodger mint,7,-5\n" +
				"Manufacturer#4,almond azure aquamarine papaya violet,12,0\n" +
				"Manufacturer#5,almond antique blue firebrick mint,31,25\n" +
				"Manufacturer#5,almond antique medium spring khaki,6,4\n" +
				"Manufacturer#5,almond antique sky peru orange,2,-44\n" +
				"Manufacturer#5,almond aquamarine dodger light gainsboro,46,23\n" +
				"Manufacturer#5,almond azure blanched chiffon midnight,23,0\n";
		assert r == e;
	}
	
	@Test
	public void testLag() throws WindowingException
	{
		wshell.execute("select  p_mfgr,p_name, p_size, " +
				"p_size - lag(p_size,1) as deltaSz " +
				" from part_tiny " +
				" partition by p_mfgr" +
				" window w1 as rows between 2 preceding and 2 following" +
				" into path='/tmp/wout2'" +
				" serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'" +
				" with serdeproperties('field.delim'=',')" +
				" format 'org.apache.hadoop.mapred.TextOutputFormat'", outPrinter);
		
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
//		System.out.println(r);
		String e = "Manufacturer#1,almond antique burnished rose metallic,2,0\n" +
				"Manufacturer#1,almond antique burnished rose metallic,2,0\n" +
				"Manufacturer#1,almond antique chartreuse lavender yellow,34,32\n" +
				"Manufacturer#1,almond antique salmon chartreuse burlywood,6,-28\n" +
				"Manufacturer#1,almond aquamarine burnished black steel,28,22\n" +
				"Manufacturer#1,almond aquamarine pink moccasin thistle,42,14\n" +
				"Manufacturer#2,almond antique violet chocolate turquoise,14,0\n" +
				"Manufacturer#2,almond antique violet turquoise frosted,40,26\n" +
				"Manufacturer#2,almond aquamarine midnight light salmon,2,-38\n" +
				"Manufacturer#2,almond aquamarine rose maroon antique,25,23\n" +
				"Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,-7\n" +
				"Manufacturer#3,almond antique chartreuse khaki white,17,0\n" +
				"Manufacturer#3,almond antique forest lavender goldenrod,14,-3\n" +
				"Manufacturer#3,almond antique metallic orange dim,19,5\n" +
				"Manufacturer#3,almond antique misty red olive,1,-18\n" +
				"Manufacturer#3,almond antique olive coral navajo,45,44\n" +
				"Manufacturer#4,almond antique gainsboro frosted violet,10,0\n" +
				"Manufacturer#4,almond antique violet mint lemon,39,29\n" +
				"Manufacturer#4,almond aquamarine floral ivory bisque,27,-12\n" +
				"Manufacturer#4,almond aquamarine yellow dodger mint,7,-20\n" +
				"Manufacturer#4,almond azure aquamarine papaya violet,12,5\n" +
				"Manufacturer#5,almond antique blue firebrick mint,31,0\n" +
				"Manufacturer#5,almond antique medium spring khaki,6,-25\n" +
				"Manufacturer#5,almond antique sky peru orange,2,-4\n" +
				"Manufacturer#5,almond aquamarine dodger light gainsboro,46,44\n" +
				"Manufacturer#5,almond azure blanched chiffon midnight,23,-23\n";
		assert r == e;
	}
	
}
