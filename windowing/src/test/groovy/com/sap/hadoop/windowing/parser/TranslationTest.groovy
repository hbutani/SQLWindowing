package com.sap.hadoop.windowing.parser;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.hadoop.windowing.BaseTest;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query.Query;

class TranslationTest extends BaseTest
{
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	void test1()
	{
		Query qry = wshell.translate("""
from tableinput(
			 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
			 keyClass='org.apache.hadoop.io.Text',
			 valueClass='org.apache.hadoop.io.Text',
			 inputPath='$basedir/com/sap/hadoop/windowing/partsmall',
			 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
			 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
			 columns = 'p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment',
			 'columns.types' = 'int,string,string,string,string,int,string,double,string'
				)
partition by p_mfgr
order by p_mfgr, p_name
with
	rank() as r,
	sum(p_size) over rows between unbounded preceding and current row as s,
	sum(p_size) over rows between current row and unbounded following as s1,
	min(<p_size>) over rows between 2 preceding and 2 following as m[int],
	denserank() as dr,
	cumedist() as cud,
	percentrank() as pr,
	ntile(<3>) as nt,
	count(<p_size>) as c,
	count(<p_size>, 'all') as ca,
	count(<p_size>, 'distinct') as cd,
	avg(<p_size>) as avg, stddev(p_size) as st,
	first_value(p_size) as fv, last_value(p_size) as lv,
	first_value(p_size, 'true') over rows between 2 preceding and 2 following as fv2
select p_mfgr,p_name, p_size, r, s, s1, m, dr, cud, pr, nt, c, ca, cd, avg, st, fv,lv, fv2""")

	}
	
	@Test
	void test2()
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("Unknown identifier p_sie");

		Query qry = wshell.translate("""
from tableinput(
			 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
			 keyClass='org.apache.hadoop.io.Text',
			 valueClass='org.apache.hadoop.io.Text',
			 inputPath='$basedir/com/sap/hadoop/windowing/partsmall',
			 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
			 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
			 columns = 'p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment',
			 'columns.types' = 'int,string,string,string,string,int,string,double,string'
				)
partition by p_mfgr
order by p_mfgr, p_name
with
	rank() as r,
	sum(p_sie) over rows between unbounded preceding and current row as s
select p_mfgr,p_name, p_size, r, s""")
	}
		
	@Test
	void testArgCheck()
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("Function ntile: arg error(strVal=3) argType not supported for arg");

		Query qry = wshell.translate("""
from tableinput(
			 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
			 keyClass='org.apache.hadoop.io.Text',
			 valueClass='org.apache.hadoop.io.Text',
			 inputPath='$basedir/com/sap/hadoop/windowing/partsmall',
			 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
			 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
			 columns = 'p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment',
			 'columns.types' = 'int,string,string,string,string,int,string,double,string'
				)
partition by p_mfgr
order by p_mfgr, p_name
with
	rank() as r,
	ntile('3') as nt
select p_mfgr,p_name, p_size, r, nt""")
	}

	
	@Test
	void testMissingArg()
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("Function ntile(alias=nt, param=[], type=null, window=null) missing required arg nbuckets");

		Query qry = wshell.translate("""
from tableinput(
			 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
			 keyClass='org.apache.hadoop.io.Text',
			 valueClass='org.apache.hadoop.io.Text',
			 inputPath='$basedir/com/sap/hadoop/windowing/partsmall',
			 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
			 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
			 columns = 'p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment',
			 'columns.types' = 'int,string,string,string,string,int,string,double,string'
				)
partition by p_mfgr
order by p_mfgr, p_name
with
	rank() as r,
	ntile() as nt
select p_mfgr,p_name, p_size, r, nt""")
	}

	@Test
	void testCheckWindowingSupport()
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("Function rank doesn't support Windowing specification");

		Query qry = wshell.translate("""
from tableinput(
			 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
			 keyClass='org.apache.hadoop.io.Text',
			 valueClass='org.apache.hadoop.io.Text',
			 inputPath='$basedir/com/sap/hadoop/windowing/partsmall',
			 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
			 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
			 columns = 'p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment',
			 'columns.types' = 'int,string,string,string,string,int,string,double,string'
				)
partition by p_mfgr
order by p_mfgr, p_name
with
	rank() over rows between 2 preceding and 2 following as r,
	ntile() as nt
select p_mfgr,p_name, p_size, r, nt""")
	}

}
