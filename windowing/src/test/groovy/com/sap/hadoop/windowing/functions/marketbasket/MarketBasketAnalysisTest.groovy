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
		wshell.execute("""
			from candidateFrequentItemSets(basketdata partition by itemset order by itemset,
			  'basketName', 'itemName', <0.05>)
			select itemset
		into path='/tmp/wout2'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		with serdeproperties('field.delim'=',')
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
	}
}
