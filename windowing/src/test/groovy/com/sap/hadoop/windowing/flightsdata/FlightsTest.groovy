package com.sap.hadoop.windowing.flightsdata;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.hadoop.windowing.MRBaseTest;

class FlightsTest extends MRBaseTest
{
	/*
	* list flights to NY on Mondays, for which there are no flights within 1 hour before this flight.
	*/
   @Test
   void testQ1()
   {
	   wshell.execute("""
	   from <select origin_city_name, year, month, day_of_month, dep_time 
             from flightsdata 
             where dest_city_name = 'New York' and dep_time != '' and day_of_week = 1>
	   partition by origin_city_name, year, month, day_of_month
	   order by dep_time
	   with count(<year>) as c
	   select origin_city_name, year, month, day_of_month, dep_time, <lag('dep_time', 1)> as lastdep[string]
	   where <((dep_time[0..1] as int) - (lag('dep_time', 1)[0..1] as int)) * 60 + 
	   			((dep_time[2..3] as int) - (lag('dep_time',1)[2..3] as int)) \\> 60>
	   into path='/tmp/wout' 
	   serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
	   with serdeproperties('field.delim'=',')
	   format 'org.apache.hadoop.mapred.TextOutputFormat'""")
   }

   /*
    * list incidents where a Flight(to NY) has been late 5 or more times in a row.
    */
   @Test
   void testQ2()
   {
	   wshell.execute("""
	   from <select origin_city_name, year, month, day_of_month, arr_delay, fl_num
			 from flightsdata
			 where dest_city_name = 'New York' and dep_time != ''>
	   partition by fl_num
	   order by year, month, day_of_month
	   with sum(<arr_delay < 0 ? 1 : 0>) over rows between 5 preceding and current row as delaycount[int]
	   select origin_city_name, fl_num, year, month, day_of_month, delaycount
	   where <delaycount \\>= 5>
	   into path='/tmp/wout'
	   serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
	   with serdeproperties('field.delim'=',')
	   format 'org.apache.hadoop.mapred.TextOutputFormat'""")
   }
   
   /*
    * list incidents by airline where a passenger would have missed
    * a connecting flight (of the same airline) because of a delay.
    * 
    * - create a set of flights arriving or leaving NY by doing a union all on 2 queries on flightsdata
    * - tag arriving flights as 1, leaving as 2
    * - partition by carrier, because we are comparing flights from the same airline
    * - sort by carrier, year, month, day_of_month and time(arrival or departure)
    * - for any arriving flight look forward to find any leaving flight within the window delay + 30 mins.
    *	1. possible soln:
    *		sum(<1>) over range current row and <t+ delay> 30.0 more as numflights
    *		count flights that are within 30's or arrival time. Problem need to only look at departing flights
    *	2. here just showing expression to compare with next row. Soln is a better soln.
    *	3. Custom function. 
    */
   
   @Test
   void testQ3()
   {
	   wshell.execute("""
	   from <select * from (select unique_carrier, fl_num, year, month, day_of_month, CRS_ARR_TIME as t, arr_delay as delay, 1 as flight
      from flightsdata
      where  dest_city_name = 'New York' and dep_time != '' and arr_delay is not null
      union all
      select unique_carrier, fl_num, year, month, day_of_month, CRS_DEP_TIME as t, dep_delay as delay, 2 as flight
      from flightsdata
      where  origin_city_name = 'New York' and dep_time != '') t>
	   partition by unique_carrier
	   order by year, month, day_of_month, t
	   with count(<1>) as dummy
	   select unique_carrier, fl_num, year, month, day_of_month, t
	   where <(flight == 1) && (delay + 30.0 \\> (((lead('t', 1)[0..1] as int) - (t[0..1] as int)) * 60 + 
                            ((lead('t', 1)[2..3] as int) - (t[2..3] as int))
                          )
                  )>
	   into path='/tmp/wout'
	   serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
	   with serdeproperties('field.delim'=',')
	   format 'org.apache.hadoop.mapred.TextOutputFormat'""")
   }
}

