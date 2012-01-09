package com.sap.hadoop.windowing.census;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.hadoop.windowing.MRBaseTest;

class CensusTest extends MRBaseTest
{
	/*
	 * @CTAS create table census_q1 as select county, tract, arealand from geo_header_sf1 where sumlev = 140 ;
	 */
	@Test
	void testQ1()
	{
		wshell.execute("""
		from census_q1 
		partition by county 
		order by county, arealand desc 
		with rank() as r 
		select county, tract, arealand, r 
		into path='/tmp/wout' format='org.apache.hadoop.mapred.TextOutputFormat''""")
	}
	
	/*
	 * @CTAS create table census_q2 as 
	 select county, cousub, name, POP100 from geo_header_sf1 where sumlev='060';
	 */
	@Test
	void testQ2()
	{
		wshell.execute("""
		from census_q2
		partition by county
		order by pop100 desc
		with rank() as r,
			sum(pop100) as s
		select county, name, pop100, r, <sprintf("%4.2f",((double)pop100)/s *100)> as percentPop[string]
		into path='/tmp/wout' format='org.apache.hadoop.mapred.TextOutputFormat''""")
	}
	
	/*
	 * top 2 subcounties for each county
	 */
	@Test
	void testQ22()
	{
		wshell.execute("""
		from census_q2
		partition by county
		order by pop100 desc
		with rank() as r,
			sum(pop100) as s
		select county, name, pop100, r
		where <r < 3>
		into path='/tmp/wout' format='org.apache.hadoop.mapred.TextOutputFormat''""")
	}
}
