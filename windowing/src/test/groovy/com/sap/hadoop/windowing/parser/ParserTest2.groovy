package com.sap.hadoop.windowing.parser;

import static org.junit.Assert.*;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.junit.Test;

import com.sap.hadoop.windowing.BaseTest;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query.QuerySpec;

class ParserTest2 extends BaseTest
{
	@Test
	void test1() 
	{
		CommonTree t = parse("""
from part
		partition by p_mfgr
		order by p_mfgr, p_name
select p_mfgr,p_name, p_size,
		rank() as r,
		denserank() as dr,
		cumedist() as cud,
		percentrank() as pr,
		ntile(3) as nt,
		count(p_size) as c,
		count(p_size, 'all') as ca,
		count(p_size, 'distinct') as cd,
		avg(p_size) as avg, stddev(p_size) as st,
		first_value(p_size) as fv, last_value(p_size) as lv,
		first_value(p_size, 'true') over rows between 2 preceding and 2 following as fv2 
		into path='/tmp/wout2'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		with serdeproperties('field.delim'=',')
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		println t.toStringTree()
	}
	
	@Test
	void testWindowClause()
	{
		CommonTree t = parse("""
select  p_mfgr,p_name, p_size,
	rank() as r,
	denserank() as dr,
	cumedist() as cud,
	percentrank() as pr,
	ntile(3) as nt,
	count(p_size) as c,
	count(p_size, 'all') as ca,
	count(p_size, 'distinct') as cd,
	avg(p_size) as avg, stddev(p_size) as st,
	first_value(p_size) as fv,
	last_value(p_size) as lv,
	first_value(p_size, 'true') over w1 as fv2
from part
partition by p_mfgr
order by p_mfgr, p_name
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		println t.toStringTree()
	}
	
	@Test
	void testStarAndDistinct()
	{
		CommonTree t = parse("""
select  p_mfgr,p_name, p_size,
	rank() as r,
	denserank() as dr,
	cumedist() as cud,
	percentrank() as pr,
	ntile(3) as nt,
	count(*) as c,
	count(p_size) as ca,
	count(distinct p_size) as cd,
	avg(p_size) as avg, stddev(p_size) as st,
	first_value(p_size) as fv,
	last_value(p_size) as lv,
	first_value(p_size, 'true') over w1 as fv2
from part
partition by p_mfgr
order by p_mfgr, p_name
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		println t.toStringTree()
	}
	
	@Test
	void testExpressions()
	{
		CommonTree t = parse("""
select  p_mfgr,p_name, p_size,
	rank(p_size / 2 + 7) as r,
	denserank() as dr,
	cumedist() as cud,
	percentrank() as pr,
	ntile(3) as nt,
	count(*) as c,
	count(p_size) as ca,
	count(distinct p_size) as cd,
	avg(p_size) as avg, stddev(p_size) as st,
	first_value(p_size % 5) as fv,
	last_value(p_size) as lv,
	first_value(p_size, 'true') over w1 as fv1
from part
partition by p_mfgr
order by p_mfgr, p_name
where p_size > 5 and p_mfgr like 'abc%'
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		println t.toStringTree()
	}
	
	@Test
	void testMultipleWindows()
	{
		CommonTree t = parse("""
select  p_mfgr,p_name, p_size,
	rank(p_size / 2 + 7) as r,
	denserank() as dr,
	cumedist() as cud,
	sum(p_size) over rows between unbounded preceding and current row as s1,
	sum(p_size) over range between p_size 5 less and current row as s2,
	first_value(p_size, 'true') over w1 as fv1
from part
partition by p_mfgr
order by p_mfgr, p_name
where p_size > 5 and p_mfgr like 'abc%'
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		println t.toStringTree()
	}
	
	@Test
	void testNPath()
	{
		CommonTree t = parse("""
from npath(fileinput(
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
map("BIG", "p_size > 5"),
array("p_mfgr", "p_name", "p_size",
	array("(path.sum() { it.p_size})/((double)count)", "int", "avgSize"),
	array("path.collect {it.p_size}", "string", "sizes")
)
)
select p_mfgr, p_name, p_size, avgSize, sizes""")
		
		println t.toStringTree()
	}
	
	@Test
	void testFlights()
	{
		CommonTree t = parse("""
from <select origin_city_name, year, month, day_of_month, dep_time 
      from flightsdata 
      where dest_city_name = 'New York' and dep_time != '' and day_of_week = 1>
partition by origin_city_name, year, month, day_of_month
order by dep_time
select origin_city_name, year, month, day_of_month, dep_time, lag('dep_time', 1) as lastdep
where (dep_time - lag('dep_time', 1)) > 60
into path='/tmp/wout' 
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		println t.toStringTree()
	}
	
	@Test
	void testFunctionChain()
	{
		CommonTree t = parse("""
from noop(
       noop(
          noop(part_rc partition by p_mfgr order by p_mfgr, p_name)
	   ) partition by p_mfgr order by p_mfgr, p_name
       ) partition by p_mfgr order by p_mfgr, p_name
select p_mfgr,p_name, p_size, rank() as r
into path='/tmp/wout'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		println t.toStringTree()
	}
	
	@Test
	void testMarketBasket()
	{
		CommonTree t = parse("""
from candidateFrequentItemSets(
	<select * from basketdata 
	 distribute by basketName
	 sort by basketName, itemName>
partition by itemset order by itemset,
'basketName', 'itemName', 0.15)
select itemset
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		println t.toStringTree()
	}
	
	@Test
	void testHiveFunctions()
	{
		CommonTree t = parse("""
select  p_mfgr,p_name, p_size,
	sqrt(p_size),
	rank(p_size / 2 + 7) as r,
	denserank() as dr,
	cumedist() as cud,
	percentrank() as pr,
	ntile(3) as nt,
	count(*) as c,
	count(p_size) as ca,
	count(distinct p_size) as cd,
	avg(p_size) as avg, stddev(p_size) as st,
	first_value(p_size % 5) as fv,
	last_value(p_size) as lv,
	first_value(p_size, 'true') over w1 as fv1
from part
partition by p_mfgr
order by p_mfgr, p_name
where p_size > 5 and p_mfgr like 'abc%'
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		println t.toStringTree()
	}
	
	
	public static CommonTree parse(String query) throws WindowingException
	{
		Windowing2Lexer lexer;
		CommonTokenStream tokens;
		Windowing2Parser parser;
		CommonTree t;
		String err;
		
		try
		{
			lexer = new Windowing2Lexer(new ANTLRStringStream(query));
			tokens = new CommonTokenStream(lexer);
			parser = new Windowing2Parser(tokens);
			t = parser.query().getTree()
			
			err = parser.getWindowingParseErrors()
			if ( err != null )
			{
				throw new WindowingException(err)
			}
		}
		catch(Throwable te)
		{
			err = parser.getWindowingParseErrors()
			if ( err != null )
			{
				throw new WindowingException(err)
			}
			throw new WindowingException("Parse Error:" + te.toString(), te)
		}
		
		return t;
	}
}
