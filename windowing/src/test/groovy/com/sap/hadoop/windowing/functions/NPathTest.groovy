package com.sap.hadoop.windowing.functions;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.hadoop.windowing.BaseTest;

class NPathTest extends BaseTest 
{
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	void test1() {
		wshell.execute("""
	from npath(<select origin_city_name, year, month, day_of_month, arr_delay, fl_num
			 from flightsdata
			 where dest_city_name = 'New York' and dep_time != ''>
			partition by fl_num
			order by year, month, day_of_month,
			'LATE.LATE.LATE',
			<[LATE : "arr_delay > 0"]>,
			<["year", "month", "day_of_month", "arr_delay", "fl_num"]>
					)
	select origin_city_name, fl_num, year, month, day_of_month
	   into path='/tmp/wout'
	   serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
	   with serdeproperties('field.delim'=',')
	   format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}
	
}