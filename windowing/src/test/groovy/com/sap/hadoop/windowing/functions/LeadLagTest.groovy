package com.sap.hadoop.windowing.functions;

import org.junit.Test;
import com.sap.hadoop.windowing.BaseTest;
import static org.junit.Assert.*;

class LeadLagTest extends BaseTest {
	@Test
	void testLag() {
		wshell.execute("""
	from tableinput(
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
	order by p_mfgr, p_name
	with
		rank() as r
	select r, <lag('r', 1)> as l1""")

		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		String e = """[1, 1]
[1, 1]
[3, 1]
[4, 3]
[5, 4]
[6, 5]
[1, 1]
[2, 1]
[3, 2]
[4, 3]
[5, 4]
[1, 1]
[2, 1]
[3, 2]
[4, 3]
[5, 4]
[1, 1]
[2, 1]
[3, 2]
[4, 3]
[5, 4]
[1, 1]
[2, 1]
[3, 2]
[4, 3]
[5, 4]
"""
		assert r == e
	}
	
	@Test
	void testLead() {
		wshell.execute("""
	from tableinput(
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
	order by p_mfgr, p_name
	with
		rank() as r
	select r, <lead('r', 1)> as l1""")

		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		String e = """[1, 1]
[1, 3]
[3, 4]
[4, 5]
[5, 6]
[6, 6]
[1, 2]
[2, 3]
[3, 4]
[4, 5]
[5, 5]
[1, 2]
[2, 3]
[3, 4]
[4, 5]
[5, 5]
[1, 2]
[2, 3]
[3, 4]
[4, 5]
[5, 5]
[1, 2]
[2, 3]
[3, 4]
[4, 5]
[5, 5]
"""
		assert r == e
	}
	
	/*
	 * lag on input column
	 */
	@Test
	void testLag2() {
		wshell.execute("""
	from tableinput(
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
	order by p_mfgr, p_name
	with
		rank() as r
	select p_size, <lag('p_size', 1)> as l1""")

		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		String e = """[2, 2]
[2, 2]
[34, 2]
[6, 34]
[28, 6]
[42, 28]
[14, 14]
[40, 14]
[2, 40]
[25, 2]
[18, 25]
[17, 17]
[14, 17]
[19, 14]
[1, 19]
[45, 1]
[10, 10]
[39, 10]
[27, 39]
[7, 27]
[12, 7]
[31, 31]
[6, 31]
[2, 6]
[46, 2]
[23, 46]
"""
		assert r == e
	}
	
	/*
	* lead on input column
	*/
   @Test
   void testLead2() {
	   wshell.execute("""
   from tableinput(
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
   order by p_mfgr, p_name
   with
	   rank() as r
   select p_mfgr, p_size, <lead('p_size', 1)> as l1""")

	   String r = outStream.toString()
	   r = r.replace("\r\n", "\n")
	   String e = """[Manufacturer#1, 2, 2]
[Manufacturer#1, 2, 34]
[Manufacturer#1, 34, 6]
[Manufacturer#1, 6, 28]
[Manufacturer#1, 28, 42]
[Manufacturer#1, 42, 42]
[Manufacturer#2, 14, 40]
[Manufacturer#2, 40, 2]
[Manufacturer#2, 2, 25]
[Manufacturer#2, 25, 18]
[Manufacturer#2, 18, 18]
[Manufacturer#3, 17, 14]
[Manufacturer#3, 14, 19]
[Manufacturer#3, 19, 1]
[Manufacturer#3, 1, 45]
[Manufacturer#3, 45, 45]
[Manufacturer#4, 10, 39]
[Manufacturer#4, 39, 27]
[Manufacturer#4, 27, 7]
[Manufacturer#4, 7, 12]
[Manufacturer#4, 12, 12]
[Manufacturer#5, 31, 6]
[Manufacturer#5, 6, 2]
[Manufacturer#5, 2, 46]
[Manufacturer#5, 46, 23]
[Manufacturer#5, 23, 23]
"""
	   assert r == e
   }
}
