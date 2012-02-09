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
			from npath(tableinput(
						 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
						 keyClass='org.apache.hadoop.io.Text',
						 valueClass='org.apache.hadoop.io.Text',
						 inputPath='$basedir/data/parttiny',
						 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
						 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
						 columns = 'p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment',
						 'columns.types' = 'int,string,string,string,string,int,string,double,string'
							)
			partition by p_mfgr
			order by p_mfgr, p_name,
					'BIG.BIG.BIG',
					<[BIG : "p_size \\> 5"]>,
					<["p_mfgr", "p_name", "p_size", 
						["(path.sum() { it.p_size})/((double)count)", "int", "avgSize"],
						["path.collect {it.p_size}", "string", "sizes"]
					]>
							)
			select p_mfgr, p_name, p_size, avgSize, sizes""")
	
		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		println r
	}
	
}