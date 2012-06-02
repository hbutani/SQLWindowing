package com.sap.hadoop.windowing.benchmark.tpch;

import static org.junit.Assert.*;

import org.apache.hadoop.hive.ql.metadata.Hive;
import org.junit.Test;

import com.sap.hadoop.windowing.MRBaseTest;

class TPCHTest  extends MRBaseTest
{

//	@Test
	void test1()
	{
		String currDB = Hive.get(wshell.cfg).getCurrentDatabase()
		Hive.get(wshell.cfg).setCurrentDatabase("benchmark")
		try
		{
			wshell.execute("""
from lineitem
partition by l_partkey, l_suppkey
order by l_partkey, l_suppkey, l_extendedprice
with 
  rank() as r
select l_partkey, l_suppkey, l_extendedprice, r
into path='/tmp/tpch-sqw-qry1'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		with serdeproperties('field.delim'=',')
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		}
		finally
		{
			Hive.get(wshell.cfg).setCurrentDatabase(currDB)
		}
	}
}

