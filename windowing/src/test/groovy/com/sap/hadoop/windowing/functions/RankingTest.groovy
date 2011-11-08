package com.sap.hadoop.windowing.functions;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.hadoop.windowing.BaseTest;

class RankingTest extends BaseTest
{
	@Test
	void test1()
	{
		wshell.execute("""
from tableinput(
			 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
			 keyClass='org.apache.hadoop.io.Text',
			 valueClass='org.apache.hadoop.io.Text',
			 inputPath='$basedir/com/sap/hadoop/windowing/parttiny',
			 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
			 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
			 columns = 'p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment',
			 'columns.types' = 'int,string,string,string,string,int,string,double,string'
				)
partition by p_mfgr
order by p_mfgr, p_name
with
	rank() as r,
	denserank() as dr,
	cumedist() as cd,
	percentrank() as pr
select r, dr, cd, pr""")

		String r = outStream.toString()
		//println r
		r = r.replace("\r\n", "\n")
		String e = """[1, 1, 0.16666666666666666, 0.0]
[1, 1, 0.3333333333333333, 0.0]
[3, 2, 0.5, 0.4]
[4, 3, 0.6666666666666666, 0.6]
[5, 4, 0.8333333333333334, 0.8]
[6, 5, 1.0, 1.0]
[1, 1, 0.2, 0.0]
[2, 2, 0.4, 0.25]
[3, 3, 0.6, 0.5]
[4, 4, 0.8, 0.75]
[5, 5, 1.0, 1.0]
[1, 1, 0.2, 0.0]
[2, 2, 0.4, 0.25]
[3, 3, 0.6, 0.5]
[4, 4, 0.8, 0.75]
[5, 5, 1.0, 1.0]
[1, 1, 0.2, 0.0]
[2, 2, 0.4, 0.25]
[3, 3, 0.6, 0.5]
[4, 4, 0.8, 0.75]
[5, 5, 1.0, 1.0]
[1, 1, 0.2, 0.0]
[2, 2, 0.4, 0.25]
[3, 3, 0.6, 0.5]
[4, 4, 0.8, 0.75]
[5, 5, 1.0, 1.0]
"""
		assert r == e
	}
	
	@Test
	void testNtile()
	{
		wshell.execute("""
from tableinput(
			 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
			 keyClass='org.apache.hadoop.io.Text',
			 valueClass='org.apache.hadoop.io.Text',
			 inputPath='$basedir/com/sap/hadoop/windowing/parttiny',
			 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
			 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
			 columns = 'p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment',
			 'columns.types' = 'int,string,string,string,string,int,string,double,string'
				)
partition by p_mfgr
order by p_mfgr, p_name
with
	ntile(3) as n3,
	ntile(4) as n4,
	ntile(10) as n10
select p_mfgr, n3, n4, n10""")

		String r = outStream.toString()
		//println r
		r = r.replace("\r\n", "\n")
		String e = """[Manufacturer#1, 1, 1, 1]
[Manufacturer#1, 1, 1, 2]
[Manufacturer#1, 2, 2, 3]
[Manufacturer#1, 2, 2, 4]
[Manufacturer#1, 3, 3, 5]
[Manufacturer#1, 3, 4, 6]
[Manufacturer#2, 1, 1, 1]
[Manufacturer#2, 1, 1, 2]
[Manufacturer#2, 2, 2, 3]
[Manufacturer#2, 2, 3, 4]
[Manufacturer#2, 3, 4, 5]
[Manufacturer#3, 1, 1, 1]
[Manufacturer#3, 1, 1, 2]
[Manufacturer#3, 2, 2, 3]
[Manufacturer#3, 2, 3, 4]
[Manufacturer#3, 3, 4, 5]
[Manufacturer#4, 1, 1, 1]
[Manufacturer#4, 1, 1, 2]
[Manufacturer#4, 2, 2, 3]
[Manufacturer#4, 2, 3, 4]
[Manufacturer#4, 3, 4, 5]
[Manufacturer#5, 1, 1, 1]
[Manufacturer#5, 1, 1, 2]
[Manufacturer#5, 2, 2, 3]
[Manufacturer#5, 2, 3, 4]
[Manufacturer#5, 3, 4, 5]
"""
		assert r == e
	}
	
	
}
