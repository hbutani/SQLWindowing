package com.sap.hadoop.windowing.runtime2;

import com.sap.hadoop.windowing.testutils.WindowingTest;

public class WindowingTestsFactory
{
	public static WindowingTest BASIC = new WindowingTest(
			"basicTest",
			"Basic Test",
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
			"Manufacturer#1	almond antique burnished rose metallic	2	1	1\n"
					+ "Manufacturer#1	almond antique burnished rose metallic	2	1	1\n"
					+ "Manufacturer#1	almond antique chartreuse lavender yellow	34	3	2\n"
					+ "Manufacturer#1	almond antique salmon chartreuse burlywood	6	4	3\n"
					+ "Manufacturer#1	almond aquamarine burnished black steel	28	5	4\n"
					+ "Manufacturer#1	almond aquamarine pink moccasin thistle	42	6	5\n"
					+ "Manufacturer#2	almond antique violet chocolate turquoise	14	1	1\n"
					+ "Manufacturer#2	almond antique violet turquoise frosted	40	2	2\n"
					+ "Manufacturer#2	almond aquamarine midnight light salmon	2	3	3\n"
					+ "Manufacturer#2	almond aquamarine rose maroon antique	25	4	4\n"
					+ "Manufacturer#2	almond aquamarine sandy cyan gainsboro	18	5	5\n"
					+ "Manufacturer#3	almond antique chartreuse khaki white	17	1	1\n"
					+ "Manufacturer#3	almond antique forest lavender goldenrod	14	2	2\n"
					+ "Manufacturer#3	almond antique metallic orange dim	19	3	3\n"
					+ "Manufacturer#3	almond antique misty red olive	1	4	4\n"
					+ "Manufacturer#3	almond antique olive coral navajo	45	5	5\n"
					+ "Manufacturer#4	almond antique gainsboro frosted violet	10	1	1\n"
					+ "Manufacturer#4	almond antique violet mint lemon	39	2	2\n"
					+ "Manufacturer#4	almond aquamarine floral ivory bisque	27	3	3\n"
					+ "Manufacturer#4	almond aquamarine yellow dodger mint	7	4	4\n"
					+ "Manufacturer#4	almond azure aquamarine papaya violet	12	5	5\n"
					+ "Manufacturer#5	almond antique blue firebrick mint	31	1	1\n"
					+ "Manufacturer#5	almond antique medium spring khaki	6	2	2\n"
					+ "Manufacturer#5	almond antique sky peru orange	2	3	3\n"
					+ "Manufacturer#5	almond aquamarine dodger light gainsboro	46	4	4\n"
					+ "Manufacturer#5	almond azure blanched chiffon midnight	23	5	5\n");

	public static WindowingTest RC = new WindowingTest(
			"testRC",
			"Basic Test on RC File",
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
			"Manufacturer#1	almond antique burnished rose metallic	2	1	1\n"
					+ "Manufacturer#1	almond antique burnished rose metallic	2	1	1\n"
					+ "Manufacturer#1	almond antique chartreuse lavender yellow	34	3	2\n"
					+ "Manufacturer#1	almond antique salmon chartreuse burlywood	6	4	3\n"
					+ "Manufacturer#1	almond aquamarine burnished black steel	28	5	4\n"
					+ "Manufacturer#1	almond aquamarine pink moccasin thistle	42	6	5\n"
					+ "Manufacturer#2	almond antique violet chocolate turquoise	14	1	1\n"
					+ "Manufacturer#2	almond antique violet turquoise frosted	40	2	2\n"
					+ "Manufacturer#2	almond aquamarine midnight light salmon	2	3	3\n"
					+ "Manufacturer#2	almond aquamarine rose maroon antique	25	4	4\n"
					+ "Manufacturer#2	almond aquamarine sandy cyan gainsboro	18	5	5\n"
					+ "Manufacturer#3	almond antique chartreuse khaki white	17	1	1\n"
					+ "Manufacturer#3	almond antique forest lavender goldenrod	14	2	2\n"
					+ "Manufacturer#3	almond antique metallic orange dim	19	3	3\n"
					+ "Manufacturer#3	almond antique misty red olive	1	4	4\n"
					+ "Manufacturer#3	almond antique olive coral navajo	45	5	5\n"
					+ "Manufacturer#4	almond antique gainsboro frosted violet	10	1	1\n"
					+ "Manufacturer#4	almond antique violet mint lemon	39	2	2\n"
					+ "Manufacturer#4	almond aquamarine floral ivory bisque	27	3	3\n"
					+ "Manufacturer#4	almond aquamarine yellow dodger mint	7	4	4\n"
					+ "Manufacturer#4	almond azure aquamarine papaya violet	12	5	5\n"
					+ "Manufacturer#5	almond antique blue firebrick mint	31	1	1\n"
					+ "Manufacturer#5	almond antique medium spring khaki	6	2	2\n"
					+ "Manufacturer#5	almond antique sky peru orange	2	3	3\n"
					+ "Manufacturer#5	almond aquamarine dodger light gainsboro	46	4	4\n"
					+ "Manufacturer#5	almond azure blanched chiffon midnight	23	5	5\n");

	public static WindowingTest NOFUNCS = new WindowingTest(
			"selectOnly",
			"Test with no Window or PTF clauses",
			"select p_mfgr,p_name,p_size "
					+ "from part_tiny "
					+ "partition by p_mfgr "
					+ "order by p_size "
					+ "into path='/tmp/test2' "
					+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' "
					+ "with serdeproperties('field.delim'=',') "
					+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
			"Manufacturer#1	almond antique burnished rose metallic	2\n"
					+ "Manufacturer#1	almond antique burnished rose metallic	2\n"
					+ "Manufacturer#1	almond antique salmon chartreuse burlywood	6\n"
					+ "Manufacturer#1	almond aquamarine burnished black steel	28\n"
					+ "Manufacturer#1	almond antique chartreuse lavender yellow	34\n"
					+ "Manufacturer#1	almond aquamarine pink moccasin thistle	42\n"
					+ "Manufacturer#2	almond aquamarine midnight light salmon	2\n"
					+ "Manufacturer#2	almond antique violet chocolate turquoise	14\n"
					+ "Manufacturer#2	almond aquamarine sandy cyan gainsboro	18\n"
					+ "Manufacturer#2	almond aquamarine rose maroon antique	25\n"
					+ "Manufacturer#2	almond antique violet turquoise frosted	40\n"
					+ "Manufacturer#3	almond antique misty red olive	1\n"
					+ "Manufacturer#3	almond antique forest lavender goldenrod	14\n"
					+ "Manufacturer#3	almond antique chartreuse khaki white	17\n"
					+ "Manufacturer#3	almond antique metallic orange dim	19\n"
					+ "Manufacturer#3	almond antique olive coral navajo	45\n"
					+ "Manufacturer#4	almond aquamarine yellow dodger mint	7\n"
					+ "Manufacturer#4	almond antique gainsboro frosted violet	10\n"
					+ "Manufacturer#4	almond azure aquamarine papaya violet	12\n"
					+ "Manufacturer#4	almond aquamarine floral ivory bisque	27\n"
					+ "Manufacturer#4	almond antique violet mint lemon	39\n"
					+ "Manufacturer#5	almond antique sky peru orange	2\n"
					+ "Manufacturer#5	almond antique medium spring khaki	6\n"
					+ "Manufacturer#5	almond azure blanched chiffon midnight	23\n"
					+ "Manufacturer#5	almond antique blue firebrick mint	31\n"
					+ "Manufacturer#5	almond aquamarine dodger light gainsboro	46\n");
	
	public static WindowingTest SUM = new WindowingTest(
			"testSum",
			"Test Sum ",
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
					"Manufacturer#1	almond antique burnished rose metallic	2	114\n" +
							"Manufacturer#1	almond antique chartreuse lavender yellow	34	114\n" +
							"Manufacturer#1	almond antique burnished rose metallic	2	114\n" +
							"Manufacturer#1	almond antique salmon chartreuse burlywood	6	114\n" +
							"Manufacturer#1	almond aquamarine burnished black steel	28	114\n" +
							"Manufacturer#1	almond aquamarine pink moccasin thistle	42	114\n" +
							"Manufacturer#2	almond antique violet chocolate turquoise	14	99\n" +
							"Manufacturer#2	almond antique violet turquoise frosted	40	99\n" +
							"Manufacturer#2	almond aquamarine midnight light salmon	2	99\n" +
							"Manufacturer#2	almond aquamarine rose maroon antique	25	99\n" +
							"Manufacturer#2	almond aquamarine sandy cyan gainsboro	18	99\n" +
							"Manufacturer#3	almond antique metallic orange dim	19	96\n" +
							"Manufacturer#3	almond antique chartreuse khaki white	17	96\n" +
							"Manufacturer#3	almond antique forest lavender goldenrod	14	96\n" +
							"Manufacturer#3	almond antique misty red olive	1	96\n" +
							"Manufacturer#3	almond antique olive coral navajo	45	96\n" +
							"Manufacturer#4	almond antique gainsboro frosted violet	10	95\n" +
							"Manufacturer#4	almond antique violet mint lemon	39	95\n" +
							"Manufacturer#4	almond aquamarine floral ivory bisque	27	95\n" +
							"Manufacturer#4	almond aquamarine yellow dodger mint	7	95\n" +
							"Manufacturer#4	almond azure aquamarine papaya violet	12	95\n" +
							"Manufacturer#5	almond antique blue firebrick mint	31	108\n" +
							"Manufacturer#5	almond antique medium spring khaki	6	108\n" +
							"Manufacturer#5	almond antique sky peru orange	2	108\n" +
							"Manufacturer#5	almond aquamarine dodger light gainsboro	46	108\n" +
							"Manufacturer#5	almond azure blanched chiffon midnight	23	108\n");
	public static WindowingTest SUMWINDOW = new WindowingTest(
			"testSumWindow",
			"Test Sum with Window",
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
					"Manufacturer#1	almond antique burnished rose metallic	2	38	2\n" +
							"Manufacturer#1	almond antique chartreuse lavender yellow	34	44	34\n" +
							"Manufacturer#1	almond antique burnished rose metallic	2	72	2\n" +
							"Manufacturer#1	almond antique salmon chartreuse burlywood	6	112	6\n" +
							"Manufacturer#1	almond aquamarine burnished black steel	28	78	28\n" +
							"Manufacturer#1	almond aquamarine pink moccasin thistle	42	76	42\n" +
							"Manufacturer#2	almond antique violet chocolate turquoise	14	56	14\n" +
							"Manufacturer#2	almond antique violet turquoise frosted	40	81	40\n" +
							"Manufacturer#2	almond aquamarine midnight light salmon	2	99	2\n" +
							"Manufacturer#2	almond aquamarine rose maroon antique	25	85	25\n" +
							"Manufacturer#2	almond aquamarine sandy cyan gainsboro	18	45	18\n" +
							"Manufacturer#3	almond antique metallic orange dim	19	50	19\n" +
							"Manufacturer#3	almond antique chartreuse khaki white	17	51	17\n" +
							"Manufacturer#3	almond antique forest lavender goldenrod	14	96	14\n" +
							"Manufacturer#3	almond antique misty red olive	1	77	1\n" +
							"Manufacturer#3	almond antique olive coral navajo	45	60	45\n" +
							"Manufacturer#4	almond antique gainsboro frosted violet	10	76	10\n" +
							"Manufacturer#4	almond antique violet mint lemon	39	83	39\n" +
							"Manufacturer#4	almond aquamarine floral ivory bisque	27	95	27\n" +
							"Manufacturer#4	almond aquamarine yellow dodger mint	7	85	7\n" +
							"Manufacturer#4	almond azure aquamarine papaya violet	12	46	12\n" +
							"Manufacturer#5	almond antique blue firebrick mint	31	39	31\n" +
							"Manufacturer#5	almond antique medium spring khaki	6	85	6\n" +
							"Manufacturer#5	almond antique sky peru orange	2	108	2\n" +
							"Manufacturer#5	almond aquamarine dodger light gainsboro	46	77	46\n" +
							"Manufacturer#5	almond azure blanched chiffon midnight	23	71	23\n");
	public static WindowingTest FIRSTLAST = new WindowingTest(
			"testFirstLast",
			"Test First Last Value",
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
					"Manufacturer#1	almond antique burnished rose metallic	2	2	2	2\n" +
							"Manufacturer#1	almond antique chartreuse lavender yellow	34	34	2	6\n" +
							"Manufacturer#1	almond antique burnished rose metallic	2	2	2	28\n" +
							"Manufacturer#1	almond antique salmon chartreuse burlywood	6	6	34	42\n" +
							"Manufacturer#1	almond aquamarine burnished black steel	28	28	2	42\n" +
							"Manufacturer#1	almond aquamarine pink moccasin thistle	42	42	6	42\n" +
							"Manufacturer#2	almond antique violet chocolate turquoise	14	14	14	2\n" +
							"Manufacturer#2	almond antique violet turquoise frosted	40	40	14	25\n" +
							"Manufacturer#2	almond aquamarine midnight light salmon	2	2	14	18\n" +
							"Manufacturer#2	almond aquamarine rose maroon antique	25	25	40	18\n" +
							"Manufacturer#2	almond aquamarine sandy cyan gainsboro	18	18	2	18\n" +
							"Manufacturer#3	almond antique metallic orange dim	19	19	19	14\n" +
							"Manufacturer#3	almond antique chartreuse khaki white	17	17	19	1\n" +
							"Manufacturer#3	almond antique forest lavender goldenrod	14	14	19	45\n" +
							"Manufacturer#3	almond antique misty red olive	1	1	17	45\n" +
							"Manufacturer#3	almond antique olive coral navajo	45	45	14	45\n" +
							"Manufacturer#4	almond antique gainsboro frosted violet	10	10	10	27\n" +
							"Manufacturer#4	almond antique violet mint lemon	39	39	10	7\n" +
							"Manufacturer#4	almond aquamarine floral ivory bisque	27	27	10	12\n" +
							"Manufacturer#4	almond aquamarine yellow dodger mint	7	7	39	12\n" +
							"Manufacturer#4	almond azure aquamarine papaya violet	12	12	27	12\n" +
							"Manufacturer#5	almond antique blue firebrick mint	31	31	31	2\n" +
							"Manufacturer#5	almond antique medium spring khaki	6	6	31	46\n" +
							"Manufacturer#5	almond antique sky peru orange	2	2	31	23\n" +
							"Manufacturer#5	almond aquamarine dodger light gainsboro	46	46	6	23\n" +
							"Manufacturer#5	almond azure blanched chiffon midnight	23	23	2	23\n");
	public static WindowingTest WHERE = new WindowingTest(
			"testWhere",
			"Test Where Clause",
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
					"Manufacturer#1	almond antique burnished rose metallic	2	1	2	2	2\n" +
							"Manufacturer#1	almond antique chartreuse lavender yellow	34	1	34	2	6\n" +
							"Manufacturer#1	almond antique burnished rose metallic	2	1	2	2	28\n" +
							"Manufacturer#1	almond antique salmon chartreuse burlywood	6	1	6	34	42\n" +
							"Manufacturer#1	almond aquamarine burnished black steel	28	1	28	2	42\n" +
							"Manufacturer#1	almond aquamarine pink moccasin thistle	42	1	42	6	42\n" +
							"Manufacturer#2	almond antique violet chocolate turquoise	14	1	14	14	2\n" +
							"Manufacturer#2	almond antique violet turquoise frosted	40	1	40	14	25\n" +
							"Manufacturer#2	almond aquamarine midnight light salmon	2	1	2	14	18\n" +
							"Manufacturer#2	almond aquamarine rose maroon antique	25	1	25	40	18\n" +
							"Manufacturer#2	almond aquamarine sandy cyan gainsboro	18	1	18	2	18\n" +
							"Manufacturer#3	almond antique metallic orange dim	19	1	19	19	14\n" +
							"Manufacturer#3	almond antique chartreuse khaki white	17	1	17	19	1\n" +
							"Manufacturer#3	almond antique forest lavender goldenrod	14	1	14	19	45\n" +
							"Manufacturer#3	almond antique misty red olive	1	1	1	17	45\n" +
							"Manufacturer#3	almond antique olive coral navajo	45	1	45	14	45\n" +
							"Manufacturer#4	almond antique gainsboro frosted violet	10	1	10	10	27\n" +
							"Manufacturer#4	almond antique violet mint lemon	39	1	39	10	7\n" +
							"Manufacturer#4	almond aquamarine floral ivory bisque	27	1	27	10	12\n" +
							"Manufacturer#4	almond aquamarine yellow dodger mint	7	1	7	39	12\n" +
							"Manufacturer#4	almond azure aquamarine papaya violet	12	1	12	27	12\n" +
							"Manufacturer#5	almond antique blue firebrick mint	31	1	31	31	2\n" +
							"Manufacturer#5	almond antique medium spring khaki	6	1	6	31	46\n" +
							"Manufacturer#5	almond antique sky peru orange	2	1	2	31	23\n" +
							"Manufacturer#5	almond aquamarine dodger light gainsboro	46	1	46	6	23\n" +
							"Manufacturer#5	almond azure blanched chiffon midnight	23	1	23	2	23\n");
	public static WindowingTest WHERELEAD = new WindowingTest(
			"testWhereLead",
			"Test with Lead in Where clause",
			"	 select  p_mfgr,p_name, p_size \n"
					+ "from part_tiny \n"
					+ "partition by p_mfgr \n"
					+ "order by p_name \n"
					+ "where lead(p_size, 1) <= p_size \n"
					+ "into path='/tmp/testWhereLead' \n"
					+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n"
					+ "with serdeproperties('field.delim'=',') \n"
					+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
			"Manufacturer#1	almond antique burnished rose metallic	2\n"
					+ "Manufacturer#1	almond antique chartreuse lavender yellow	34\n"
					+ "Manufacturer#1	almond aquamarine pink moccasin thistle	42\n"
					+ "Manufacturer#2	almond antique violet turquoise frosted	40\n"
					+ "Manufacturer#2	almond aquamarine rose maroon antique	25\n"
					+ "Manufacturer#2	almond aquamarine sandy cyan gainsboro	18\n"
					+ "Manufacturer#3	almond antique chartreuse khaki white	17\n"
					+ "Manufacturer#3	almond antique metallic orange dim	19\n"
					+ "Manufacturer#3	almond antique olive coral navajo	45\n"
					+ "Manufacturer#4	almond antique violet mint lemon	39\n"
					+ "Manufacturer#4	almond aquamarine floral ivory bisque	27\n"
					+ "Manufacturer#4	almond azure aquamarine papaya violet	12\n"
					+ "Manufacturer#5	almond antique blue firebrick mint	31\n"
					+ "Manufacturer#5	almond antique medium spring khaki	6\n"
					+ "Manufacturer#5	almond aquamarine dodger light gainsboro	46\n"
					+ "Manufacturer#5	almond azure blanched chiffon midnight	23\n");
	public static WindowingTest CENSUSTOP4 = new WindowingTest(
			"testCensusTop4",
			"List Top 4 tracts by land area for each county",
			"select county, tract, arealand, rank() as r "
					+ "from census_tiny "
					+ "partition by county "
					+ "order by county, arealand desc "
					+ "where r < 5 "
					+ "into path='/tmp/wout' "
					+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' "
					+ "with serdeproperties('field.delim'=',') "
					+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
			"001	451101	5.52877327E8	1\n" + "001	450701	2.66251308E8	2\n"
					+ "001	441503	7.7476439E7	3\n"
					+ "001	430102	7.6698501E7	4\n"
					+ "003	010000	1.912271907E9	1\n"
					+ "005	000102	4.5622349E8	1\n"
					+ "005	000200	3.23078053E8	2\n"
					+ "005	000301	1.95628423E8	3\n"
					+ "005	000304	1.41639221E8	4\n"
					+ "007	002400	1.106587526E9	1\n"
					+ "007	001600	5.58529159E8	2\n"
					+ "007	001500	3.50730015E8	3\n"
					+ "007	003600	3.30874034E8	4\n");
	public static WindowingTest NOOPWITHWINDOWING = new WindowingTest(
			"testNoopWithWindowing",
			"List Noop PTF",
			"select county, tract, arealand, rank() as r "
					+ "from noop(census_tiny "
					+ "			partition by county "
					+ "			order by county, arealand desc) "
					+ "where r < 5 "
					+ "into path='/tmp/NoopWithWindowing' "
					+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' "
					+ "with serdeproperties('field.delim'=',') "
					+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
			"001	451101	5.52877327E8	1\n" + "001	450701	2.66251308E8	2\n"
					+ "001	441503	7.7476439E7	3\n"
					+ "001	430102	7.6698501E7	4\n"
					+ "003	010000	1.912271907E9	1\n"
					+ "005	000102	4.5622349E8	1\n"
					+ "005	000200	3.23078053E8	2\n"
					+ "005	000301	1.95628423E8	3\n"
					+ "005	000304	1.41639221E8	4\n"
					+ "007	002400	1.106587526E9	1\n"
					+ "007	001600	5.58529159E8	2\n"
					+ "007	001500	3.50730015E8	3\n"
					+ "007	003600	3.30874034E8	4\n");
	public static WindowingTest NOOPWITHMAPWINDOWING = new WindowingTest(
			"testNoopWithMapWindowing",
			"List NoopWithMap PTF",
			"select county, tract, arealand, rank() as r "
					+ "from noopwithmap(census_tiny "
					+ "			partition by county "
					+ "			order by county, arealand desc) "
					+ "where r < 5 "
					+ "into path='/tmp/NoopWithWindowing' "
					+ "serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' "
					+ "with serdeproperties('field.delim'=',') "
					+ "format 'org.apache.hadoop.mapred.TextOutputFormat'",
			"001	451101	5.52877327E8	1\n" + "001	450701	2.66251308E8	2\n"
					+ "001	441503	7.7476439E7	3\n"
					+ "001	430102	7.6698501E7	4\n"
					+ "003	010000	1.912271907E9	1\n"
					+ "005	000102	4.5622349E8	1\n"
					+ "005	000200	3.23078053E8	2\n"
					+ "005	000301	1.95628423E8	3\n"
					+ "005	000304	1.41639221E8	4\n"
					+ "007	002400	1.106587526E9	1\n"
					+ "007	001600	5.58529159E8	2\n"
					+ "007	001500	3.50730015E8	3\n"
					+ "007	003600	3.30874034E8	4\n");
	
	public static WindowingTest NPATH = new WindowingTest(
			"testNPath",
			"Basic NPath test",
			" select origin_city_name, fl_num, year, month, day_of_month, sz, tpath " +
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
					" format 'org.apache.hadoop.mapred.TextOutputFormat'",
					"Baltimore	1142	2010	10	20	6	[{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":20,\"arr_delay\":23.0,\"fl_num\":\"1142\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":21,\"arr_delay\":105.0,\"fl_num\":\"1142\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":22,\"arr_delay\":54.0,\"fl_num\":\"1142\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":25,\"arr_delay\":92.0,\"fl_num\":\"1142\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":26,\"arr_delay\":123.0,\"fl_num\":\"1142\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":27,\"arr_delay\":49.0,\"fl_num\":\"1142\"}]\n" +
							"Baltimore	1142	2010	10	21	5	[{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":21,\"arr_delay\":105.0,\"fl_num\":\"1142\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":22,\"arr_delay\":54.0,\"fl_num\":\"1142\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":25,\"arr_delay\":92.0,\"fl_num\":\"1142\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":26,\"arr_delay\":123.0,\"fl_num\":\"1142\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":27,\"arr_delay\":49.0,\"fl_num\":\"1142\"}]\n" +
							"Baltimore	1142	2010	10	22	4	[{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":22,\"arr_delay\":54.0,\"fl_num\":\"1142\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":25,\"arr_delay\":92.0,\"fl_num\":\"1142\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":26,\"arr_delay\":123.0,\"fl_num\":\"1142\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":27,\"arr_delay\":49.0,\"fl_num\":\"1142\"}]\n" +
							"Baltimore	1142	2010	10	25	3	[{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":25,\"arr_delay\":92.0,\"fl_num\":\"1142\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":26,\"arr_delay\":123.0,\"fl_num\":\"1142\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":27,\"arr_delay\":49.0,\"fl_num\":\"1142\"}]\n" +
							"Baltimore	1142	2010	10	26	2	[{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":26,\"arr_delay\":123.0,\"fl_num\":\"1142\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":27,\"arr_delay\":49.0,\"fl_num\":\"1142\"}]\n" +
							"Chicago	1531	2010	10	21	2	[{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":21,\"arr_delay\":53.0,\"fl_num\":\"1531\"},{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":22,\"arr_delay\":16.0,\"fl_num\":\"1531\"}]\n" +
							"Chicago	1531	2010	10	25	3	[{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":25,\"arr_delay\":43.0,\"fl_num\":\"1531\"},{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":26,\"arr_delay\":29.0,\"fl_num\":\"1531\"},{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":27,\"arr_delay\":70.0,\"fl_num\":\"1531\"}]\n" +
							"Chicago	1531	2010	10	26	2	[{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":26,\"arr_delay\":29.0,\"fl_num\":\"1531\"},{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":27,\"arr_delay\":70.0,\"fl_num\":\"1531\"}]\n" +
							"Baltimore	1599	2010	10	21	2	[{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":21,\"arr_delay\":28.0,\"fl_num\":\"1599\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":22,\"arr_delay\":18.0,\"fl_num\":\"1599\"}]\n" +
							"Baltimore	1599	2010	10	25	3	[{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":25,\"arr_delay\":106.0,\"fl_num\":\"1599\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":26,\"arr_delay\":90.0,\"fl_num\":\"1599\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":27,\"arr_delay\":92.0,\"fl_num\":\"1599\"}]\n" +
							"Baltimore	1599	2010	10	26	2	[{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":26,\"arr_delay\":90.0,\"fl_num\":\"1599\"},{\"origin_city_name\":\"Baltimore\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":27,\"arr_delay\":92.0,\"fl_num\":\"1599\"}]\n" +
							"Chicago	361	2010	10	20	2	[{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":20,\"arr_delay\":42.0,\"fl_num\":\"361\"},{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":21,\"arr_delay\":142.0,\"fl_num\":\"361\"}]\n" +
							"Washington	7291	2010	10	27	2	[{\"origin_city_name\":\"Washington\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":27,\"arr_delay\":26.0,\"fl_num\":\"7291\"},{\"origin_city_name\":\"Washington\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":28,\"arr_delay\":45.0,\"fl_num\":\"7291\"}]\n" +
							"Chicago	897	2010	10	20	4	[{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":20,\"arr_delay\":24.0,\"fl_num\":\"897\"},{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":21,\"arr_delay\":77.0,\"fl_num\":\"897\"},{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":22,\"arr_delay\":24.0,\"fl_num\":\"897\"},{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":24,\"arr_delay\":113.0,\"fl_num\":\"897\"}]\n" +
							"Chicago	897	2010	10	21	3	[{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":21,\"arr_delay\":77.0,\"fl_num\":\"897\"},{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":22,\"arr_delay\":24.0,\"fl_num\":\"897\"},{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":24,\"arr_delay\":113.0,\"fl_num\":\"897\"}]\n" +
							"Chicago	897	2010	10	22	2	[{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":22,\"arr_delay\":24.0,\"fl_num\":\"897\"},{\"origin_city_name\":\"Chicago\",\"dest_city_name\":\"New York\",\"year\":2010,\"month\":10,\"day_of_month\":24,\"arr_delay\":113.0,\"fl_num\":\"897\"}]\n");

	public static Object[][] TESTS = new Object[][]
	{  	new Object[] { BASIC }, 
		new Object[] { RC }, 
		new Object[] { NOFUNCS }, 
		new Object[] { SUM }, 
		new Object[] { SUMWINDOW }, 
		new Object[] { FIRSTLAST },
		new Object[] { WHERE },
		new Object[] { WHERELEAD }, 
		new Object[] { CENSUSTOP4 }, 
		new Object[] { NOOPWITHWINDOWING }, 
		new Object[] { NOOPWITHMAPWINDOWING } 
	};

}
