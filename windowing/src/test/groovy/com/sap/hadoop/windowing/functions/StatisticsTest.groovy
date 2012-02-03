package com.sap.hadoop.windowing.functions;

import org.junit.Test;
import com.sap.hadoop.windowing.BaseTest;
import static org.junit.Assert.*;


class StatisticsTest extends BaseTest {
	@Test
	void testVariance() {
		wshell.execute("""
	from tableinput(
				 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
				 keyClass='org.apache.hadoop.io.Text',
				 valueClass='org.apache.hadoop.io.Text',
				 inputPath='$basedir/data/statistics',
				 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
				 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
				 columns = 'p_partkey,p_name,p_mfgr,val1,val2',
				 'columns.types' = 'int,string,string,int,int'
					)
	partition by p_mfgr
	order by p_mfgr, p_name
	with
		variance(val1) as v,
		stddev(val1) as s
	select v, s""")

		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		String e = """[2.9166666666666665, 1.707825127659933]
[2.9166666666666665, 1.707825127659933]
[2.9166666666666665, 1.707825127659933]
[2.9166666666666665, 1.707825127659933]
[2.9166666666666665, 1.707825127659933]
[2.9166666666666665, 1.707825127659933]
"""
		assert r == e
	}
	
	@Test
	void testCoVariance() {
		wshell.execute("""
	from tableinput(
				 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
				 keyClass='org.apache.hadoop.io.Text',
				 valueClass='org.apache.hadoop.io.Text',
				 inputPath='$basedir/data/statistics',
				 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
				 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
				 columns = 'p_partkey,p_name,p_mfgr,val1,val2',
				 'columns.types' = 'int,string,string,int,int'
					)
	partition by p_mfgr
	order by p_mfgr, p_name
	with
		covariance(val1, val2) as cv
	select cv""")

		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		String e = """[-2.9166666666666665]
[-2.9166666666666665]
[-2.9166666666666665]
[-2.9166666666666665]
[-2.9166666666666665]
[-2.9166666666666665]
"""
		assert r == e
	}
}
