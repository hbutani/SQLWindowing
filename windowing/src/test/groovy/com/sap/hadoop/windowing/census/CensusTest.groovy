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
	void testRC()
	{
		wshell.execute("""
		from census_q1 
		partition by county 
		order by county, arealand desc 
		with rank() as r 
		select county, tract, arealand, r 
		into path='/tmp/wout' format='org.apache.hadoop.mapred.TextOutputFormat''""")
	}
}
