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
		//println r
		String e = """[Manufacturer#1, almond antique chartreuse lavender yellow, 34, 22.666666666666668, [34, 6, 28]]
[Manufacturer#1, almond antique salmon chartreuse burlywood, 6, 25.333333333333332, [6, 28, 42]]
[Manufacturer#3, almond antique chartreuse khaki white, 17, 16.666666666666668, [17, 14, 19]]
[Manufacturer#4, almond antique gainsboro frosted violet, 10, 25.333333333333332, [10, 39, 27]]
[Manufacturer#4, almond antique violet mint lemon, 39, 24.333333333333332, [39, 27, 7]]
[Manufacturer#4, almond aquamarine floral ivory bisque, 27, 15.333333333333334, [27, 7, 12]]
"""
		assert r == e
	}
	
	@Test
	void testPlus() {
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
					'BIG+',
					<[BIG : "p_size \\> 5"]>,
					<["p_mfgr", "p_name", "p_size",
						["(path.sum() { it.p_size})/((double)count)", "int", "avgSize"],
						["path.collect {it.p_size}", "string", "sizes"]
					]>
							)
			select p_mfgr, p_name, p_size, avgSize, sizes""")
	
		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		//println r
		String e = """[Manufacturer#1, almond antique chartreuse lavender yellow, 34, 27.5, [34, 6, 28, 42]]
[Manufacturer#1, almond antique salmon chartreuse burlywood, 6, 25.333333333333332, [6, 28, 42]]
[Manufacturer#1, almond aquamarine burnished black steel, 28, 35.0, [28, 42]]
[Manufacturer#1, almond aquamarine pink moccasin thistle, 42, 42.0, [42]]
[Manufacturer#2, almond antique violet chocolate turquoise, 14, 27.0, [14, 40]]
[Manufacturer#2, almond antique violet turquoise frosted, 40, 21.0, [40, 2]]
[Manufacturer#2, almond aquamarine rose maroon antique, 25, 21.5, [25, 18]]
[Manufacturer#2, almond aquamarine sandy cyan gainsboro, 18, 18.0, [18]]
[Manufacturer#3, almond antique chartreuse khaki white, 17, 16.666666666666668, [17, 14, 19]]
[Manufacturer#3, almond antique forest lavender goldenrod, 14, 16.5, [14, 19]]
[Manufacturer#3, almond antique metallic orange dim, 19, 10.0, [19, 1]]
[Manufacturer#3, almond antique olive coral navajo, 45, 45.0, [45]]
[Manufacturer#4, almond antique gainsboro frosted violet, 10, 19.0, [10, 39, 27, 7, 12]]
[Manufacturer#4, almond antique violet mint lemon, 39, 21.25, [39, 27, 7, 12]]
[Manufacturer#4, almond aquamarine floral ivory bisque, 27, 15.333333333333334, [27, 7, 12]]
[Manufacturer#4, almond aquamarine yellow dodger mint, 7, 9.5, [7, 12]]
[Manufacturer#4, almond azure aquamarine papaya violet, 12, 12.0, [12]]
[Manufacturer#5, almond antique blue firebrick mint, 31, 18.5, [31, 6]]
[Manufacturer#5, almond antique medium spring khaki, 6, 4.0, [6, 2]]
[Manufacturer#5, almond aquamarine dodger light gainsboro, 46, 34.5, [46, 23]]
[Manufacturer#5, almond azure blanched chiffon midnight, 23, 23.0, [23]]
"""
		assert r == e
	}
	
	@Test
	void testStar() {
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
					'BIG.BIG*',
					<[BIG : "p_size \\> 5"]>,
					<["p_mfgr", "p_name", "p_size",
						["(path.sum() { it.p_size})/((double)count)", "int", "avgSize"],
						["path.collect {it.p_size}", "string", "sizes"]
					]>
							)
			select p_mfgr, p_name, p_size, avgSize, sizes""")
	
		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		//println r
		String e = """[Manufacturer#1, almond antique chartreuse lavender yellow, 34, 27.5, [34, 6, 28, 42]]
[Manufacturer#1, almond antique salmon chartreuse burlywood, 6, 25.333333333333332, [6, 28, 42]]
[Manufacturer#1, almond aquamarine burnished black steel, 28, 35.0, [28, 42]]
[Manufacturer#1, almond aquamarine pink moccasin thistle, 42, 42.0, [42]]
[Manufacturer#2, almond antique violet chocolate turquoise, 14, 27.0, [14, 40]]
[Manufacturer#2, almond antique violet turquoise frosted, 40, 21.0, [40, 2]]
[Manufacturer#2, almond aquamarine rose maroon antique, 25, 21.5, [25, 18]]
[Manufacturer#2, almond aquamarine sandy cyan gainsboro, 18, 18.0, [18]]
[Manufacturer#3, almond antique chartreuse khaki white, 17, 16.666666666666668, [17, 14, 19]]
[Manufacturer#3, almond antique forest lavender goldenrod, 14, 16.5, [14, 19]]
[Manufacturer#3, almond antique metallic orange dim, 19, 10.0, [19, 1]]
[Manufacturer#3, almond antique olive coral navajo, 45, 45.0, [45]]
[Manufacturer#4, almond antique gainsboro frosted violet, 10, 19.0, [10, 39, 27, 7, 12]]
[Manufacturer#4, almond antique violet mint lemon, 39, 21.25, [39, 27, 7, 12]]
[Manufacturer#4, almond aquamarine floral ivory bisque, 27, 15.333333333333334, [27, 7, 12]]
[Manufacturer#4, almond aquamarine yellow dodger mint, 7, 9.5, [7, 12]]
[Manufacturer#4, almond azure aquamarine papaya violet, 12, 12.0, [12]]
[Manufacturer#5, almond antique blue firebrick mint, 31, 18.5, [31, 6]]
[Manufacturer#5, almond antique medium spring khaki, 6, 4.0, [6, 2]]
[Manufacturer#5, almond aquamarine dodger light gainsboro, 46, 34.5, [46, 23]]
[Manufacturer#5, almond azure blanched chiffon midnight, 23, 23.0, [23]]
"""
		assert r == e
	}
	
}