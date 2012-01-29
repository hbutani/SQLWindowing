package com.sap.hadoop.windowing.runtime;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.hadoop.windowing.BaseTest;

class LargePartitionTest extends BaseTest {
	@Test
	void testLag() {
		wshell.execute("""
	from tableinput(
				 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
				 keyClass='org.apache.hadoop.io.Text',
				 valueClass='org.apache.hadoop.io.Text',
				 inputPath='$basedir/data/partvlarge',
				 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
				 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
				 columns = 'p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment',
				 'columns.types' = 'int,string,string,string,string,int,string,double,string'
					)
	partition by p_mfgr
	order by p_mfgr, p_name
	with
		count(<p_name>) as c
	select c""")

		String r = outStream.toString()
		//r = r.replace("\r\n", "\n")
		String[] rows = r.split("\\n")
		assert rows[0] == "[1000000]"
	}
}
