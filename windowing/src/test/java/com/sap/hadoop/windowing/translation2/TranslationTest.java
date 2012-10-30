package com.sap.hadoop.windowing.translation2;

import junit.framework.Assert;

import org.junit.Test;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.testutils.MRBaseTest;

public class TranslationTest extends MRBaseTest
{
	
	@Test
	public void testNPath() throws WindowingException
	{
		
		wshell.translate(
		" select origin_city_name, fl_num, year, month, day_of_month, sz, tpath " +
		" from npath( " +
		"         flights_tiny " +
		"         partition by fl_num " +
		"  		  order by year, month, day_of_month, " +
		"   	  'LATE.LATE.LATE.LATE.LATE+', " +
		"  		  'LATE', arr_delay > 15, " +
		"		  'origin_city_name, fl_num, year, month, day_of_month, size(tpath) as sz, tpath as tpath' " +
		"		) " +
		" into path='/tmp/testNPath' \n" +
		" serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' \n" +
		" with serdeproperties('field.delim'=',') \n" +
		" format 'org.apache.hadoop.mapred.TextOutputFormat'");	

	}
}