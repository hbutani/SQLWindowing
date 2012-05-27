package com.sap.hadoop.windowing.functions.marketbasket;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.hadoop.windowing.BaseTest;

class MarketBasketAnalysisLocalTest  extends BaseTest {
	@Test
	void test1() {
		wshell.execute("""
	from candidateFrequentItemSets(tableinput(
				 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
				 keyClass='org.apache.hadoop.io.Text',
				 valueClass='org.apache.hadoop.io.Text',
				 inputPath='$basedir/data/marketbasket/sample',
				 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
				 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
				 columns = 'basketName,itemName',
				 'columns.types' = 'string,string',
				 'field.delim'=','
					) partition by itemset order by itemset,
			  'basketName', 'itemName', <0.15>)
		select itemset
		""")

		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		println r
	}
	
	@Test
	void testDb10000() {
		wshell.execute("""
	from candidateFrequentItemSets(tableinput(
				 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
				 keyClass='org.apache.hadoop.io.Text',
				 valueClass='org.apache.hadoop.io.Text',
				 inputPath='$basedir/data/marketbasket/db10000',
				 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
				 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
				 columns = 'basketName,itemName',
				 'columns.types' = 'string,string',
				 'field.delim'=','
					) partition by itemset order by itemset,
			  'basketName', 'itemName', <0.20>)
		select itemset
		""")

		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		println r
	}
}
