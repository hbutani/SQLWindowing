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
		wshell.execute(
				"select  p_mfgr,p_name, p_size,\n"
						+ "rank() as r,\n"
						+ "denserank() as dr\n"
						+ "from part_tiny\n"
						+ "partition by p_mfgr\n"
						+ "order by p_name\n"
						+ "window w1 as rows between 2 preceding and 2 following\n"
						+ "into path='/tmp/wout2'\n"
						+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'\n"
						+ "with serdeproperties('field.delim'=',')\n"
						+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		//System.out.println(r);
		String e = "Manufacturer#1	almond antique burnished rose metallic	2	1	1\n" +
				"Manufacturer#1	almond antique burnished rose metallic	2	1	1\n" +
				"Manufacturer#1	almond antique chartreuse lavender yellow	34	3	2\n" +
				"Manufacturer#1	almond antique salmon chartreuse burlywood	6	4	3\n" +
				"Manufacturer#1	almond aquamarine burnished black steel	28	5	4\n" +
				"Manufacturer#1	almond aquamarine pink moccasin thistle	42	6	5\n" +
				"Manufacturer#2	almond antique violet chocolate turquoise	14	1	1\n" +
				"Manufacturer#2	almond antique violet turquoise frosted	40	2	2\n" +
				"Manufacturer#2	almond aquamarine midnight light salmon	2	3	3\n" +
				"Manufacturer#2	almond aquamarine rose maroon antique	25	4	4\n" +
				"Manufacturer#2	almond aquamarine sandy cyan gainsboro	18	5	5\n" +
				"Manufacturer#3	almond antique chartreuse khaki white	17	1	1\n" +
				"Manufacturer#3	almond antique forest lavender goldenrod	14	2	2\n" +
				"Manufacturer#3	almond antique metallic orange dim	19	3	3\n" +
				"Manufacturer#3	almond antique misty red olive	1	4	4\n" +
				"Manufacturer#3	almond antique olive coral navajo	45	5	5\n" +
				"Manufacturer#4	almond antique gainsboro frosted violet	10	1	1\n" +
				"Manufacturer#4	almond antique violet mint lemon	39	2	2\n" +
				"Manufacturer#4	almond aquamarine floral ivory bisque	27	3	3\n" +
				"Manufacturer#4	almond aquamarine yellow dodger mint	7	4	4\n" +
				"Manufacturer#4	almond azure aquamarine papaya violet	12	5	5\n" +
				"Manufacturer#5	almond antique blue firebrick mint	31	1	1\n" +
				"Manufacturer#5	almond antique medium spring khaki	6	2	2\n" +
				"Manufacturer#5	almond antique sky peru orange	2	3	3\n" +
				"Manufacturer#5	almond aquamarine dodger light gainsboro	46	4	4\n" +
				"Manufacturer#5	almond azure blanched chiffon midnight	23	5	5\n";
		Assert.assertEquals(r, e);
	}
	
	@Test
	public void testRC() throws WindowingException
	{
		wshell.execute(
				"select  p_mfgr,p_name, p_size,\n"
						+ "rank() as r,\n"
						+ "denserank() as dr\n"
						+ "from partrc_tiny\n"
						+ "partition by p_mfgr\n"
						+ "order by p_name\n"
						+ "window w1 as rows between 2 preceding and 2 following\n"
						+ "into path='/tmp/wout2'\n"
						+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'\n"
						+ "with serdeproperties('field.delim'=',')\n"
						+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		//System.out.println(r);
		String e = "Manufacturer#1	almond antique burnished rose metallic	2	1	1\n" +
				"Manufacturer#1	almond antique burnished rose metallic	2	1	1\n" +
				"Manufacturer#1	almond antique chartreuse lavender yellow	34	3	2\n" +
				"Manufacturer#1	almond antique salmon chartreuse burlywood	6	4	3\n" +
				"Manufacturer#1	almond aquamarine burnished black steel	28	5	4\n" +
				"Manufacturer#1	almond aquamarine pink moccasin thistle	42	6	5\n" +
				"Manufacturer#2	almond antique violet chocolate turquoise	14	1	1\n" +
				"Manufacturer#2	almond antique violet turquoise frosted	40	2	2\n" +
				"Manufacturer#2	almond aquamarine midnight light salmon	2	3	3\n" +
				"Manufacturer#2	almond aquamarine rose maroon antique	25	4	4\n" +
				"Manufacturer#2	almond aquamarine sandy cyan gainsboro	18	5	5\n" +
				"Manufacturer#3	almond antique chartreuse khaki white	17	1	1\n" +
				"Manufacturer#3	almond antique forest lavender goldenrod	14	2	2\n" +
				"Manufacturer#3	almond antique metallic orange dim	19	3	3\n" +
				"Manufacturer#3	almond antique misty red olive	1	4	4\n" +
				"Manufacturer#3	almond antique olive coral navajo	45	5	5\n" +
				"Manufacturer#4	almond antique gainsboro frosted violet	10	1	1\n" +
				"Manufacturer#4	almond antique violet mint lemon	39	2	2\n" +
				"Manufacturer#4	almond aquamarine floral ivory bisque	27	3	3\n" +
				"Manufacturer#4	almond aquamarine yellow dodger mint	7	4	4\n" +
				"Manufacturer#4	almond azure aquamarine papaya violet	12	5	5\n" +
				"Manufacturer#5	almond antique blue firebrick mint	31	1	1\n" +
				"Manufacturer#5	almond antique medium spring khaki	6	2	2\n" +
				"Manufacturer#5	almond antique sky peru orange	2	3	3\n" +
				"Manufacturer#5	almond aquamarine dodger light gainsboro	46	4	4\n" +
				"Manufacturer#5	almond azure blanched chiffon midnight	23	5	5\n";
		Assert.assertEquals(r, e);
	}

	@Test
	public void test2() throws WindowingException {
		System.out.println("Beginning test2");
		wshell.execute("select p_mfgr,p_name,p_size "
				+ "from part_tiny " + "partition by p_mfgr "
				+ "order by p_size " + "into path='/tmp/test2' "
				+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' "
				+ "with serdeproperties('field.delim'=',') "
				+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		//System.out.println(r);
		String e = "Manufacturer#1	almond antique burnished rose metallic	2\n" +
				"Manufacturer#1	almond antique burnished rose metallic	2\n" +
				"Manufacturer#1	almond antique salmon chartreuse burlywood	6\n" +
				"Manufacturer#1	almond aquamarine burnished black steel	28\n" +
				"Manufacturer#1	almond antique chartreuse lavender yellow	34\n" +
				"Manufacturer#1	almond aquamarine pink moccasin thistle	42\n" +
				"Manufacturer#2	almond aquamarine midnight light salmon	2\n" +
				"Manufacturer#2	almond antique violet chocolate turquoise	14\n" +
				"Manufacturer#2	almond aquamarine sandy cyan gainsboro	18\n" +
				"Manufacturer#2	almond aquamarine rose maroon antique	25\n" +
				"Manufacturer#2	almond antique violet turquoise frosted	40\n" +
				"Manufacturer#3	almond antique misty red olive	1\n" +
				"Manufacturer#3	almond antique forest lavender goldenrod	14\n" +
				"Manufacturer#3	almond antique chartreuse khaki white	17\n" +
				"Manufacturer#3	almond antique metallic orange dim	19\n" +
				"Manufacturer#3	almond antique olive coral navajo	45\n" +
				"Manufacturer#4	almond aquamarine yellow dodger mint	7\n" +
				"Manufacturer#4	almond antique gainsboro frosted violet	10\n" +
				"Manufacturer#4	almond azure aquamarine papaya violet	12\n" +
				"Manufacturer#4	almond aquamarine floral ivory bisque	27\n" +
				"Manufacturer#4	almond antique violet mint lemon	39\n" +
				"Manufacturer#5	almond antique sky peru orange	2\n" +
				"Manufacturer#5	almond antique medium spring khaki	6\n" +
				"Manufacturer#5	almond azure blanched chiffon midnight	23\n" +
				"Manufacturer#5	almond antique blue firebrick mint	31\n" +
				"Manufacturer#5	almond aquamarine dodger light gainsboro	46\n";
		Assert.assertEquals(r, e);

	}

	@Test
	public void testSum() throws WindowingException
	{
		System.out.println("Beginning testSum");
		wshell.execute(
				"select  p_mfgr,p_name, p_size, \n"
						+ "sum(p_size) as s \n"
						+ "from part_tiny		"
						+ " partition by p_mfgr \n"
						+ "order by p_mfgr \n"
						+ "window w1 as rows between 2 preceding and 2 following \n"
						+ "into path='/tmp/testSum' \n"
						+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'		"
						+ "with serdeproperties('field.delim'=',') \n"
						+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		// System.out.println(r);
		String e = "";
		Assert.assertEquals(r, e);	

	}

	@Test
	public void testSumWindow() throws WindowingException
	{
		System.out.println("Beginning testSumWindow");
		wshell.execute(
				"select  p_mfgr,p_name, p_size, \n"
						+ "sum(p_size) over w1 as s, \n"
						+ "sum(p_size) over rows between current row and current row as s2 \n"
						+ "from part_tiny \n"
						+ "partition by p_mfgr \n"
						+ "order by p_mfgr \n"
						+ "window w1 as rows between 2 preceding and 2 following \n"
						+ "into path='/tmp/testSumWindow' \n"
						+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n"
						+ "with serdeproperties('field.delim'=',') \n"
						+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		// System.out.println(r);
		String e = "";
		Assert.assertEquals(r, e);	

	}

	@Test
	public void testFirstLastValue() throws WindowingException
	{
		System.out.println("Beginning testFirstLastValue");
		wshell.execute(
				"select  p_mfgr,p_name, p_size, \n"
						+ "sum(p_size) over rows between current row and current row as s2, \n"
						+ "first_value(p_size) over w1 as f, \n"
						+ "last_value(p_size, false) over w1 as l \n"
						+ "from part_tiny \n"
						+ "partition by p_mfgr \n"
						+ "order by p_mfgr \n"
						+ "window w1 as rows between 2 preceding and 2 following \n"
						+ "into path='/tmp/testFirstLastValue' \n"
						+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n"
						+ "with serdeproperties('field.delim'=',') \n"
						+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		// System.out.println(r);
		String e = "";
		Assert.assertEquals(r, e);	

	}

	@Test
	public void testWhere() throws WindowingException
	{
		System.out.println("Beginning testWhere");
		wshell.execute(
				"		 select  p_mfgr,p_name, p_size, \n"
						+ "rank() as r, \n"
						+ "sum(p_size) over rows between current row and current row as s2, \n"
						+ "first_value(p_size) over w1 as f, \n"
						+ "last_value(p_size, false) over w1 as l \n"
						+ "from part_tiny \n"
						+ "partition by p_mfgr \n"
						+ "order by p_mfgr \n"
						+ "where r < 7 or p_mfgr = 'Manufacturer#3' \n"
						+ "window w1 as rows between 2 preceding and 2 following \n"
						+ "into path='/tmp/testWhere' \n"
						+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n"
						+ "with serdeproperties('field.delim'=',') \n"
						+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		// System.out.println(r);
		String e = "";
		Assert.assertEquals(r, e);	

	}

	@Test
	public void testLead() throws WindowingException
	{
		System.out.println("Beginning testLead");
		wshell.execute(
				"	 select  p_mfgr,p_name, p_size,	 p_size - lead(p_size,1) as deltaSz \n"
						+ "from part_tiny \n"
						+ "partition by p_mfgr \n"
						+ "order by p_mfgr \n"
						+ "window w1 as rows between 2 preceding and 2 following \n"
						+ "into path='/tmp/testLead' \n"
						+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n"
						+ "with serdeproperties('field.delim'=',') \n"
						+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		// System.out.println(r);
		String e = "";
		Assert.assertEquals(r, e);	

	}

	@Test
	public void testLag() throws WindowingException
	{
		System.out.println("Beginning testLag");
		wshell.execute(
				"	 select  p_mfgr,p_name, p_size,	 p_size - lag(p_size,1) as deltaSz \n"
						+ "from part_tiny \n"
						+ "partition by p_mfgr \n"
						+ "order by p_mfgr \n"
						+ "window w1 as rows between 2 preceding and 2 following \n"
						+ "into path='/tmp/testLag' \n"
						+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n"
						+ "with serdeproperties('field.delim'=',') \n"
						+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		// System.out.println(r);
		String e = "";
		Assert.assertEquals(r, e);	

	}

	// sum(row(i) - row(i-1)) = row(n) - row(1)
	@Test
	public void testSumDelta() throws WindowingException
	{
		System.out.println("Beginning testSumDelta");
		wshell.execute(
				"	 select  p_mfgr,p_name, p_size,	 sum(p_size - lag(p_size,1)) as deltaSum \n"
						+ "from part_tiny \n"
						+ "partition by p_mfgr \n"
						+ "order by p_mfgr \n"
						+ "window w1 as rows between 2 preceding and 2 following \n"
						+ "into path='/tmp/testSumDelta' \n"
						+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n"
						+ "with serdeproperties('field.delim'=',') \n"
						+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		// System.out.println(r);
		String e = "";
		Assert.assertEquals(r, e);	
	}

	@Test
	public void testWhereLead() throws WindowingException {
		System.out.println("Beginning testWhereLead");
		wshell.execute(
				"	 select  p_mfgr,p_name, p_size \n"
						+ "from part_tiny \n"
						+ "partition by p_mfgr \n"
						+ "order by p_mfgr \n"
						+ "where lead(p_size, 1) <= p_size \n"
						+ "into path='/tmp/testWhereLead' \n"
						+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n"
						+ "with serdeproperties('field.delim'=',') \n"
						+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		// System.out.println(r);
		String e = "Manufacturer#1	almond antique chartreuse lavender yellow	34\n"
				+ "Manufacturer#1	almond aquamarine pink moccasin thistle	42\n"
				+ "Manufacturer#2	almond antique violet turquoise frosted	40\n"
				+ "Manufacturer#2	almond aquamarine rose maroon antique	25\n"
				+ "Manufacturer#3	almond antique metallic orange dim	19\n"
				+ "Manufacturer#3	almond antique chartreuse khaki white	17\n"
				+ "Manufacturer#3	almond antique forest lavender goldenrod	14\n"
				+ "Manufacturer#3	almond antique olive coral navajo	45\n"
				+ "Manufacturer#4	almond antique violet mint lemon	39\n"
				+ "Manufacturer#4	almond aquamarine floral ivory bisque	27\n"
				+ "Manufacturer#5	almond antique blue firebrick mint	31\n"
				+ "Manufacturer#5	almond antique medium spring khaki	6\n"
				+ "Manufacturer#5	almond aquamarine dodger light gainsboro	46\n"
				+ "Manufacturer#5	almond azure blanched chiffon midnight	23\n";
		Assert.assertEquals(r, e);	
	}
	
	@Test
	public void testCensus1() throws WindowingException
	{
		wshell.execute("" +
				"select county, tract, arealand, rank() as r " +
				"from census_tiny " +
				"partition by county " +
				"order by county, arealand desc " +
				"where r < 5 " +
				"into path='/tmp/wout' " +
				"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' " +
				"with serdeproperties('field.delim'=',') " +
				"format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		//System.out.println(r);
		String e ="001	451101	5.52877327E8	1\n" +
				"001	450701	2.66251308E8	2\n" +
				"001	441503	7.7476439E7	3\n" +
				"001	430102	7.6698501E7	4\n" +
				"003	010000	1.912271907E9	1\n" +
				"005	000102	4.5622349E8	1\n" +
				"005	000200	3.23078053E8	2\n" +
				"005	000301	1.95628423E8	3\n" +
				"005	000304	1.41639221E8	4\n" +
				"007	002400	1.106587526E9	1\n" +
				"007	001600	5.58529159E8	2\n" +
				"007	001500	3.50730015E8	3\n" +
				"007	003600	3.30874034E8	4\n";
		Assert.assertEquals(r, e);		
	}
	

	@Test
	public void testNoopWithWindowing() throws WindowingException
	{
		wshell.execute("" +
				"select county, tract, arealand, rank() as r " +
				"from noop(census_tiny " +
				"			partition by county " +
				"			order by county, arealand desc) " +
				"where r < 5 " +
				"into path='/tmp/NoopWithWindowing' " +
				"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' " +
				"with serdeproperties('field.delim'=',') " +
				"format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		//System.out.println(r);
		String e ="001	451101	5.52877327E8	1\n" +
				"001	450701	2.66251308E8	2\n" +
				"001	441503	7.7476439E7	3\n" +
				"001	430102	7.6698501E7	4\n" +
				"003	010000	1.912271907E9	1\n" +
				"005	000102	4.5622349E8	1\n" +
				"005	000200	3.23078053E8	2\n" +
				"005	000301	1.95628423E8	3\n" +
				"005	000304	1.41639221E8	4\n" +
				"007	002400	1.106587526E9	1\n" +
				"007	001600	5.58529159E8	2\n" +
				"007	001500	3.50730015E8	3\n" +
				"007	003600	3.30874034E8	4\n";
		Assert.assertEquals(r, e);		
	}
	
	@Test
	public void testNoopWithMapWindowing() throws WindowingException
	{
		wshell.execute("" +
				"select county, tract, arealand, rank() as r " +
				"from noopwithmap(census_tiny " +
				"			partition by county " +
				"			order by county, arealand desc) " +
				"where r < 5 " +
				"into path='/tmp/NoopWithMapWindowing' " +
				"serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' " +
				"with serdeproperties('field.delim'=',') " +
				"format 'org.apache.hadoop.mapred.TextOutputFormat'",
				outPrinter);
		String r = outStream.toString();
		r = r.replace("\r\n", "\n");
		//System.out.println(r);
		String e ="001	451101	5.52877327E8	1\n" +
				"001	450701	2.66251308E8	2\n" +
				"001	441503	7.7476439E7	3\n" +
				"001	430102	7.6698501E7	4\n" +
				"003	010000	1.912271907E9	1\n" +
				"005	000102	4.5622349E8	1\n" +
				"005	000200	3.23078053E8	2\n" +
				"005	000301	1.95628423E8	3\n" +
				"005	000304	1.41639221E8	4\n" +
				"007	002400	1.106587526E9	1\n" +
				"007	001600	5.58529159E8	2\n" +
				"007	001500	3.50730015E8	3\n" +
				"007	003600	3.30874034E8	4\n";
		Assert.assertEquals(r, e);		
	}

}
