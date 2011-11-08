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
	denserank() as dr
select r, dr""")

		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		String e = """[1, 1]
[1, 1]
[3, 2]
[4, 3]
[5, 4]
[6, 5]
[1, 1]
[2, 2]
[3, 3]
[4, 4]
[5, 5]
[1, 1]
[2, 2]
[3, 3]
[4, 4]
[5, 5]
[1, 1]
[2, 2]
[3, 3]
[4, 4]
[5, 5]
[1, 1]
[2, 2]
[3, 3]
[4, 4]
[5, 5]
"""
		assert r == e
	}
}
