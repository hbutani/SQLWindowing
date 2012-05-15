package com.sap.hadoop.windowing.runtime.mr;

import static org.junit.Assert.*;

import org.apache.hadoop.hive.ql.metadata.Hive;
import org.junit.Test;

import com.sap.hadoop.windowing.MRBaseTest;

class MultipleDBTest extends MRBaseTest
{

	/*
	 * Setup:
		create database test;
		use test;
		create table p (
    	  p_partkey INT,
    		p_name STRING,
    		p_mfgr STRING,
    		p_brand STRING,
    		p_type STRING,
    		p_size INT,
    		p_container STRING,
    		p_retailprice DOUBLE,
    		p_comment STRING
		);
	  load data local inpath '/media/MyPassport/windowing/windowing/src/test/groovy/data/partsmall/000000_0' into table p;
	 */
	@Test
	void test1()
	{
		Hive.get(wshell.cfg).setCurrentDatabase("test")
		wshell.execute("""
		from p
		partition by p_mfgr
		order by p_mfgr, p_name desc
		with
		rank() as r
select p_partkey, p_mfgr,p_name, p_size, r
		into path='/tmp/wout2'""")
	}
	

}
