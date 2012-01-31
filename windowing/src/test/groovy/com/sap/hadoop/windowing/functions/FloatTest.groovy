package com.sap.hadoop.windowing.functions;

import org.junit.Test;
import com.sap.hadoop.windowing.BaseTest;
import static org.junit.Assert.*;

class FloatTest extends BaseTest 
{
	@Test
	void test1() 
	{
		
		def types = ['float', 'double']
		def exprs = ['p_retailprice', '<p_retailprice>']
		
		for( t in types)
		{
			for(e in exprs)
			{
				String q = sprintf("""
					from tableinput(
								 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
								 keyClass='org.apache.hadoop.io.Text',
								 valueClass='org.apache.hadoop.io.Text',
								 inputPath='$basedir/com/sap/hadoop/windowing/parttiny',
								 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
								 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
								 columns = 'p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment',
								 'columns.types' = 'int,string,string,string,string,int,string,%s,string'
									)
					partition by p_mfgr
					order by p_mfgr, p_name
					with
						rank() as r,
						sum(%s) as s
					select r, <lag('r', 1)> as l1""", t, e)
				//printf q
				wshell.execute(q)
			}
		}
	}
}