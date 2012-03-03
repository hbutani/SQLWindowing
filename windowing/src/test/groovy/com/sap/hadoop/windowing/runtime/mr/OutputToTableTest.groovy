package com.sap.hadoop.windowing.runtime.mr;

import static org.junit.Assert.*;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.hive.ql.io.RCFile;
import org.junit.Test;

import com.sap.hadoop.windowing.MRBaseTest;

class OutputToTableTest extends MRBaseTest
{

	/*
	 * Setup part_win table:
	 * CREATE TABLE part_win( 
		p_partkey INT,
    	p_mfgr STRING,
    	p_name STRING,
    	p_size INT,
    	p_rank int
	)
	 */
	@Test
	void test1()
	{
		wshell.execute("""
		from part
		partition by p_mfgr
		order by p_mfgr, p_name desc
		with
		rank() as r
select p_partkey, p_mfgr,p_name, p_size, r
		into path='/tmp/wout2'
        load overwrite into table part_win""")
	}
	
	/*
	* Setup part_winrc table:
	* CREATE TABLE part_winrc(
	   p_partkey INT,
	   p_mfgr STRING,
	   p_name STRING,
	   p_size INT,
	   p_rank int
   )
   ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.columnar.ColumnarSerDe'
   STORED AS RCFILE 
	*/
   @Test
   void test2()
   {
	   wshell.execute("""
	   from part
	   partition by p_mfgr
	   order by p_mfgr, p_name desc
	   with
	   rank() as r
select p_partkey, p_mfgr,p_name, p_size, r
	   into path='/tmp/wout2'
	   load overwrite into table part_winrc""")
   }
   
//   @Test
//   void test3()
//   {
//	   String outputURI = "/tmp/wout2/part-00000"
//	   org.apache.hadoop.fs.FileSystem fs = org.apache.hadoop.fs.FileSystem.get(URI.create(outputURI), wshell.cfg);
//	   org.apache.hadoop.fs.Path outputPath = new org.apache.hadoop.fs.Path(outputURI)
//	   new RCFile.Reader(fs, outputPath, wshell.cfg);
//   }
}