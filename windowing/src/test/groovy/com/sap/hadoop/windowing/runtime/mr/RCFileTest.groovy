package com.sap.hadoop.windowing.runtime.mr;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sap.hadoop.windowing.MRBaseTest;

class RCFileTest extends MRBaseTest
{

	/*
	 * Output can be validated by:
	 * 	create table woutrc (p_mfgr STRING, p_name STRING, p_size INT, r INT) 
	 * 	ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.columnar.ColumnarSerDe'
	 * 	STORED AS RCFILE 
	 * 	LOCATION '/tmp/wout.rc';  
	 *  
	 *  select * from woutrc;  
	 */
	@Test
	void test1()
	{
		wshell.execute("""
		from < select p_mfgr, p_name, p_size from part_rc where p_size < 20>
		partition by p_mfgr
		order by p_mfgr, p_name
		with
		rank() as r
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout.rc' 
		serde 'org.apache.hadoop.hive.serde2.columnar.ColumnarSerDe'
		format 'org.apache.hadoop.hive.ql.io.RCFileOutputFormat'""")
	}

}
