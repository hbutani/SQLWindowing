package com.sap.hadoop.windowing.runtime.mr;

import org.junit.Test;
import com.sap.hadoop.windowing.BaseTest;
import static org.junit.Assert.*;

import com.sap.hadoop.windowing.BaseTest;

public class WhereClauseTest extends BaseTest 
{
	@Test
	void test1() {
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
	select p_mfgr, p_name, r where <r \\> 3>""")

		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		String e = """[Manufacturer#1, almond antique salmon chartreuse burlywood, 4]
[Manufacturer#1, almond aquamarine burnished black steel, 5]
[Manufacturer#1, almond aquamarine pink moccasin thistle, 6]
[Manufacturer#2, almond aquamarine rose maroon antique, 4]
[Manufacturer#2, almond aquamarine sandy cyan gainsboro, 5]
[Manufacturer#3, almond antique misty red olive, 4]
[Manufacturer#3, almond antique olive coral navajo, 5]
[Manufacturer#4, almond aquamarine yellow dodger mint, 4]
[Manufacturer#4, almond azure aquamarine papaya violet, 5]
[Manufacturer#5, almond aquamarine dodger light gainsboro, 4]
[Manufacturer#5, almond azure blanched chiffon midnight, 5]
"""
		assert r == e
	}
	
	@Test
	void test2() {
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
	select p_mfgr, p_name, r where <r < 3>""")

		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		String e = """[Manufacturer#1, almond antique burnished rose metallic, 1]
[Manufacturer#1, almond antique burnished rose metallic, 1]
[Manufacturer#2, almond antique violet chocolate turquoise, 1]
[Manufacturer#2, almond antique violet turquoise frosted, 2]
[Manufacturer#3, almond antique chartreuse khaki white, 1]
[Manufacturer#3, almond antique forest lavender goldenrod, 2]
[Manufacturer#4, almond antique gainsboro frosted violet, 1]
[Manufacturer#4, almond antique violet mint lemon, 2]
[Manufacturer#5, almond antique blue firebrick mint, 1]
[Manufacturer#5, almond antique medium spring khaki, 2]
"""
		assert r == e
	}
}
