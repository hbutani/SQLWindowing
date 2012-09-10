package com.sap.hadoop.windowing.functions.marketbasket;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.hadoop.windowing.BaseTest;
import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QuerySpec;


import static org.junit.Assert.*;

class MarketBasketAnalysisTest extends MRBaseTest 
{
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	void test1() {
		String reds = wshell.cfg.get("mapred.reduce.tasks");
		try
		{			
			wshell.cfg.set("mapred.reduce.tasks", "1");
			wshell.execute("""
				from candidateFrequentItemSets(
				   <select * from basketdata 
					distribute by basketName
					sort by basketName, itemName>
				   partition by itemset order by itemset,
				  'basketName', 'itemName', <0.15>)
				select itemset
			into path='/tmp/wout2'
			serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
			with serdeproperties('field.delim'=',')
			format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		}
		finally
		{
				wshell.cfg.set("mapred.reduce.tasks", reds);

		}
	}
	
	@Test
	void testDb1000() {
		String reds = wshell.cfg.get("mapred.reduce.tasks");
		try
		{
			wshell.cfg.set("mapred.reduce.tasks", "1");
			wshell.execute("""
				from candidateFrequentItemSets(
				   <select * from basketdata_db10000
					distribute by basketName
					sort by basketName, itemName>
				   partition by itemset order by itemset,
				  'basketName', 'itemName', <0.2>)
				select itemset
			into path='/tmp/wout2'
			serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
			with serdeproperties('field.delim'=',')
			format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		}
		finally
		{
				wshell.cfg.set("mapred.reduce.tasks", reds);
		}
	}
}
