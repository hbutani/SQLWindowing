package com.sap.hadoop.windowing.runtime2;

import org.junit.Test;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.testutils.BaseTest;

public class LocalExecutorTest extends BaseTest
{
	@Test
	public void test1() throws WindowingException
	{
		QueryDef qDef = wshell.translate("select  p_mfgr,p_name, p_size,\n" +
				"rank() as r,\n" +
				"denserank() as dr\n" +
				"from part_demo\n" +
				"partition by p_mfgr\n" +
				"order by p_mfgr\n" +
				"window w1 as rows between 2 preceding and 2 following\n" +
				"into path='/tmp/wout2'\n" +
				"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'\n" +
				"with serdeproperties('field.delim'=',')\n" +
				"format 'org.apache.hadoop.mapred.TextOutputFormat'");
		
		execute(qDef);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
//		println r
		String e = "Manufacturer#1,almond antique burnished rose metallic,2,1,1\n" +
				"Manufacturer#1,almond antique burnished rose metallic,2,1,1\n" +
				"Manufacturer#1,almond antique chartreuse lavender yellow,34,1,1\n" +
				"Manufacturer#1,almond antique salmon chartreuse burlywood,6,1,1\n" +
				"Manufacturer#1,almond aquamarine burnished black steel,28,1,1\n" +
				"Manufacturer#1,almond aquamarine pink moccasin thistle,42,1,1\n" +
				"Manufacturer#2,almond antique violet chocolate turquoise,14,7,2\n" +
				"Manufacturer#2,almond antique violet turquoise frosted,40,7,2\n" +
				"Manufacturer#2,almond aquamarine midnight light salmon,2,7,2\n" +
				"Manufacturer#2,almond aquamarine rose maroon antique,25,7,2\n" +
				"Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,7,2\n" +
				"Manufacturer#3,almond antique chartreuse khaki white,17,12,3\n" +
				"Manufacturer#3,almond antique forest lavender goldenrod,14,12,3\n" +
				"Manufacturer#3,almond antique metallic orange dim,19,12,3\n" +
				"Manufacturer#3,almond antique misty red olive,1,12,3\n" +
				"Manufacturer#3,almond antique olive coral navajo,45,12,3\n" +
				"Manufacturer#4,almond antique gainsboro frosted violet,10,17,4\n" +
				"Manufacturer#4,almond antique violet mint lemon,39,17,4\n" +
				"Manufacturer#4,almond aquamarine floral ivory bisque,27,17,4\n" +
				"Manufacturer#4,almond aquamarine yellow dodger mint,7,17,4\n" +
				"Manufacturer#4,almond azure aquamarine papaya violet,12,17,4\n" +
				"Manufacturer#5,almond antique blue firebrick mint,31,22,5\n" +
				"Manufacturer#5,almond antique medium spring khaki,6,22,5\n" +
				"Manufacturer#5,almond antique sky peru orange,2,22,5\n" +
				"Manufacturer#5,almond aquamarine dodger light gainsboro,46,22,5\n" +
				"Manufacturer#5,almond azure blanched chiffon midnight,23,22,5";
		assert r == e;
	}
	
	@Test
	public void testSum() throws WindowingException
	{
		QueryDef qDef = wshell.translate("select  p_mfgr,p_name, p_size, " +
				"	sum(p_size) as s " +
				"from part_demo " +
				"partition by p_mfgr " +
				"order by p_mfgr " +
				"window w1 as rows between 2 preceding and 2 following " +
				"into path='/tmp/wout2' " +
				"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' " +
				"with serdeproperties('field.delim'=',') " +
				"format 'org.apache.hadoop.mapred.TextOutputFormat'");
		
		execute(qDef);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
//		println r
		String e = "Manufacturer#1,almond antique burnished rose metallic,2,512\n" +
				"Manufacturer#1,almond antique burnished rose metallic,2,512\n" +
				"Manufacturer#1,almond antique chartreuse lavender yellow,34,512\n" +
				"Manufacturer#1,almond antique salmon chartreuse burlywood,6,512\n" +
				"Manufacturer#1,almond aquamarine burnished black steel,28,512\n" +
				"Manufacturer#1,almond aquamarine pink moccasin thistle,42,512\n" +
				"Manufacturer#2,almond antique violet chocolate turquoise,14,512\n" +
				"Manufacturer#2,almond antique violet turquoise frosted,40,512\n" +
				"Manufacturer#2,almond aquamarine midnight light salmon,2,512\n" +
				"Manufacturer#2,almond aquamarine rose maroon antique,25,512\n" +
				"Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,512\n" +
				"Manufacturer#3,almond antique chartreuse khaki white,17,512\n" +
				"Manufacturer#3,almond antique forest lavender goldenrod,14,512\n" +
				"Manufacturer#3,almond antique metallic orange dim,19,512\n" +
				"Manufacturer#3,almond antique misty red olive,1,512\n" +
				"Manufacturer#3,almond antique olive coral navajo,45,512\n" +
				"Manufacturer#4,almond antique gainsboro frosted violet,10,512\n" +
				"Manufacturer#4,almond antique violet mint lemon,39,512\n" +
				"Manufacturer#4,almond aquamarine floral ivory bisque,27,512\n" +
				"Manufacturer#4,almond aquamarine yellow dodger mint,7,512\n" +
				"Manufacturer#4,almond azure aquamarine papaya violet,12,512\n" +
				"Manufacturer#5,almond antique blue firebrick mint,31,512\n" +
				"Manufacturer#5,almond antique medium spring khaki,6,512\n" +
				"Manufacturer#5,almond antique sky peru orange,2,512\n" +
				"Manufacturer#5,almond aquamarine dodger light gainsboro,46,512\n" +
				"Manufacturer#5,almond azure blanched chiffon midnight,23,512\n";
		assert r == e;
	}
	
	@Test
	public void testSumWindow() throws WindowingException
	{
		QueryDef qDef = wshell.translate("select  p_mfgr,p_name, p_size, " +
				"	sum(p_size) over w1 as s, " +
				"    sum(p_size) over rows between current row and current row as s2 " +
				"from part_demo " +
				"partition by p_mfgr " +
				"order by p_mfgr " +
				"window w1 as rows between 2 preceding and 2 following " +
				"into path='/tmp/wout2' " +
				"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' " +
				"with serdeproperties('field.delim'=',') " +
				"format 'org.apache.hadoop.mapred.TextOutputFormat'");
		
		execute(qDef);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
//		println r
		String e = "Manufacturer#1,almond antique burnished rose metallic,2,38,2\n" +
				"Manufacturer#1,almond antique burnished rose metallic,2,44,2\n" +
				"Manufacturer#1,almond antique chartreuse lavender yellow,34,72,34\n" +
				"Manufacturer#1,almond antique salmon chartreuse burlywood,6,112,6\n" +
				"Manufacturer#1,almond aquamarine burnished black steel,28,124,28\n" +
				"Manufacturer#1,almond aquamarine pink moccasin thistle,42,130,42\n" +
				"Manufacturer#2,almond antique violet chocolate turquoise,14,126,14\n" +
				"Manufacturer#2,almond antique violet turquoise frosted,40,123,40\n" +
				"Manufacturer#2,almond aquamarine midnight light salmon,2,99,2\n" +
				"Manufacturer#2,almond aquamarine rose maroon antique,25,102,25\n" +
				"Manufacturer#2,almond aquamarine sandy cyan gainsboro,18,76,18\n" +
				"Manufacturer#3,almond antique chartreuse khaki white,17,93,17\n" +
				"Manufacturer#3,almond antique forest lavender goldenrod,14,69,14\n" +
				"Manufacturer#3,almond antique metallic orange dim,19,96,19\n" +
				"Manufacturer#3,almond antique misty red olive,1,89,1\n" +
				"Manufacturer#3,almond antique olive coral navajo,45,114,45\n" +
				"Manufacturer#4,almond antique gainsboro frosted violet,10,122,10\n" +
				"Manufacturer#4,almond antique violet mint lemon,39,128,39\n" +
				"Manufacturer#4,almond aquamarine floral ivory bisque,27,95,27\n" +
				"Manufacturer#4,almond aquamarine yellow dodger mint,7,116,7\n" +
				"Manufacturer#4,almond azure aquamarine papaya violet,12,83,12\n" +
				"Manufacturer#5,almond antique blue firebrick mint,31,58,31\n" +
				"Manufacturer#5,almond antique medium spring khaki,6,97,6\n" +
				"Manufacturer#5,almond antique sky peru orange,2,108,2\n" +
				"Manufacturer#5,almond aquamarine dodger light gainsboro,46,77,46\n" +
				"Manufacturer#5,almond azure blanched chiffon midnight,23,71,23\n";
		assert r == e;
	}
}
