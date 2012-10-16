package com.sap.hadoop.windowing.runtime2;

import junit.framework.Assert;

import org.junit.Test;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.testutils.MRBaseTest;

public class MRExecutorTest extends MRBaseTest
{
	@Test
	public void test1() throws WindowingException
	{
		wshell.execute("select  p_mfgr,p_name, p_size,\n" +
				"rank() as r,\n" +
				"denserank() as dr\n" +
				"from part_demo\n" +
				"partition by p_mfgr\n" +
				"order by p_mfgr\n" +
				"window w1 as rows between 2 preceding and 2 following\n" +
				"into path='/tmp/wout2'\n" +
				"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'\n" +
				"with serdeproperties('field.delim'=',')\n" +
				"format 'org.apache.hadoop.mapred.TextOutputFormat'", outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
//		System.out.println(r);
		String e = "Manufacturer#1	almond antique burnished rose metallic	2	1	1\n" +
				"Manufacturer#1	almond antique chartreuse lavender yellow	34	1	1\n" +
				"Manufacturer#1	almond antique burnished rose metallic	2	1	1\n" +
				"Manufacturer#1	almond antique salmon chartreuse burlywood	6	1	1\n" +
				"Manufacturer#1	almond aquamarine burnished black steel	28	1	1\n" +
				"Manufacturer#1	almond aquamarine pink moccasin thistle	42	1	1\n" +
				"Manufacturer#2	almond antique violet chocolate turquoise	14	7	2\n" +
				"Manufacturer#2	almond antique violet turquoise frosted	40	7	2\n" +
				"Manufacturer#2	almond aquamarine midnight light salmon	2	7	2\n" +
				"Manufacturer#2	almond aquamarine rose maroon antique	25	7	2\n" +
				"Manufacturer#2	almond aquamarine sandy cyan gainsboro	18	7	2\n" +
				"Manufacturer#3	almond antique metallic orange dim	19	12	3\n" +
				"Manufacturer#3	almond antique chartreuse khaki white	17	12	3\n" +
				"Manufacturer#3	almond antique forest lavender goldenrod	14	12	3\n" +
				"Manufacturer#3	almond antique misty red olive	1	12	3\n" +
				"Manufacturer#3	almond antique olive coral navajo	45	12	3\n" +
				"Manufacturer#4	almond antique gainsboro frosted violet	10	17	4\n" +
				"Manufacturer#4	almond antique violet mint lemon	39	17	4\n" +
				"Manufacturer#4	almond aquamarine floral ivory bisque	27	17	4\n" +
				"Manufacturer#4	almond aquamarine yellow dodger mint	7	17	4\n" +
				"Manufacturer#4	almond azure aquamarine papaya violet	12	17	4\n" +
				"Manufacturer#5	almond antique blue firebrick mint	31	22	5\n" +
				"Manufacturer#5	almond antique medium spring khaki	6	22	5\n" +
				"Manufacturer#5	almond antique sky peru orange	2	22	5\n" +
				"Manufacturer#5	almond aquamarine dodger light gainsboro	46	22	5\n" +
				"Manufacturer#5	almond azure blanched chiffon midnight	23	22	5\n";
		Assert.assertEquals(r, e);
	}
}
