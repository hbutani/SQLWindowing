package com.sap.hadoop.windowing.functions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.hadoop.windowing.BaseTest;
import com.sap.hadoop.windowing.WindowingException;

import static org.junit.Assert.*;

class TableFuncTest extends BaseTest 
{
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	void test1() {
		wshell.execute("""
	from noop(tableinput(
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
	order by p_mfgr, p_name)
	select p_mfgr, p_name""")

		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		//println r
		String e = """[Manufacturer#1, almond antique burnished rose metallic]
[Manufacturer#1, almond antique burnished rose metallic]
[Manufacturer#1, almond antique chartreuse lavender yellow]
[Manufacturer#1, almond antique salmon chartreuse burlywood]
[Manufacturer#1, almond aquamarine burnished black steel]
[Manufacturer#1, almond aquamarine pink moccasin thistle]
[Manufacturer#2, almond antique violet chocolate turquoise]
[Manufacturer#2, almond antique violet turquoise frosted]
[Manufacturer#2, almond aquamarine midnight light salmon]
[Manufacturer#2, almond aquamarine rose maroon antique]
[Manufacturer#2, almond aquamarine sandy cyan gainsboro]
[Manufacturer#3, almond antique chartreuse khaki white]
[Manufacturer#3, almond antique forest lavender goldenrod]
[Manufacturer#3, almond antique metallic orange dim]
[Manufacturer#3, almond antique misty red olive]
[Manufacturer#3, almond antique olive coral navajo]
[Manufacturer#4, almond antique gainsboro frosted violet]
[Manufacturer#4, almond antique violet mint lemon]
[Manufacturer#4, almond aquamarine floral ivory bisque]
[Manufacturer#4, almond aquamarine yellow dodger mint]
[Manufacturer#4, almond azure aquamarine papaya violet]
[Manufacturer#5, almond antique blue firebrick mint]
[Manufacturer#5, almond antique medium spring khaki]
[Manufacturer#5, almond antique sky peru orange]
[Manufacturer#5, almond aquamarine dodger light gainsboro]
[Manufacturer#5, almond azure blanched chiffon midnight]
"""
		assert r == e
	}
	
	@Test
	void testFuncChain() {
		wshell.execute("""
	from noop(noop(tableinput(
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
	order by p_mfgr, p_name))
	select p_mfgr, p_name""")

		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		//println r
		String e = """[Manufacturer#1, almond antique burnished rose metallic]
[Manufacturer#1, almond antique burnished rose metallic]
[Manufacturer#1, almond antique chartreuse lavender yellow]
[Manufacturer#1, almond antique salmon chartreuse burlywood]
[Manufacturer#1, almond aquamarine burnished black steel]
[Manufacturer#1, almond aquamarine pink moccasin thistle]
[Manufacturer#2, almond antique violet chocolate turquoise]
[Manufacturer#2, almond antique violet turquoise frosted]
[Manufacturer#2, almond aquamarine midnight light salmon]
[Manufacturer#2, almond aquamarine rose maroon antique]
[Manufacturer#2, almond aquamarine sandy cyan gainsboro]
[Manufacturer#3, almond antique chartreuse khaki white]
[Manufacturer#3, almond antique forest lavender goldenrod]
[Manufacturer#3, almond antique metallic orange dim]
[Manufacturer#3, almond antique misty red olive]
[Manufacturer#3, almond antique olive coral navajo]
[Manufacturer#4, almond antique gainsboro frosted violet]
[Manufacturer#4, almond antique violet mint lemon]
[Manufacturer#4, almond aquamarine floral ivory bisque]
[Manufacturer#4, almond aquamarine yellow dodger mint]
[Manufacturer#4, almond azure aquamarine papaya violet]
[Manufacturer#5, almond antique blue firebrick mint]
[Manufacturer#5, almond antique medium spring khaki]
[Manufacturer#5, almond antique sky peru orange]
[Manufacturer#5, almond aquamarine dodger light gainsboro]
[Manufacturer#5, almond azure blanched chiffon midnight]
"""
		assert r == e
	}
	
	@Test
	void testWithClauseCheck()
	{
		//expectedEx.expect(WindowingException.class);
		//expectedEx.expectMessage("With clause not supported with pure table Functions");

		wshell.execute("""
	from noop(tableinput(
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
	order by p_mfgr, p_name)
	with rank() as r
	select p_mfgr, p_name""")
	}
}