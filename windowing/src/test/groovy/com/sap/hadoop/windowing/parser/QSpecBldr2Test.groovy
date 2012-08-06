package com.sap.hadoop.windowing.parser;

import static org.junit.Assert.*;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.Token;

import org.apache.hadoop.hive.ql.parse.ASTNode;

import org.junit.Test;

import com.sap.hadoop.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.BaseTest;
import com.sap.hadoop.windowing.WindowingException;


public class QSpecBldr2Test extends BaseTest
{
	
	@Test
	void test1()
	{
		QuerySpec qSpec = build("""
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
		
		println qSpec
		assert qSpec.toString().replaceAll(QuerySpec.NL, "\n") == """select 
  (TABLEORCOL p_mfgr),
  (TABLEORCOL p_name),
  (TABLEORCOL p_size),
  rank() as r,
  denserank() as dr,
  cumedist() as cud,
  percentrank() as pr,
  ntile(3) as nt,
  count((TABLEORCOL p_size)) as c,
  count((TABLEORCOL p_size), 'all') as ca,
  count((TABLEORCOL p_size), 'distinct') as cd,
  avg((TABLEORCOL p_size)) as avg,
  stddev((TABLEORCOL p_size)) as st,
  first_value((TABLEORCOL p_size)) as fv,
  last_value((TABLEORCOL p_size)) as lv,
  first_value((TABLEORCOL p_size), 'true') window(start=range(2 PRECEDING), end=range(2 FOLLOWING))  as fv2
from part partitionColumns=[p_mfgr] orderColumns=[p_mfgr ASC, p_name ASC]
into output('/tmp/wout2', serde = 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' with 'field.delim' = ',' format'org.apache.hadoop.mapred.TextOutputFormat')
"""
	}
	
	@Test
	void testWindowClause()
	{
		QuerySpec qSpec = build("""
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
		
//		println qSpec
		assert qSpec.toString().replaceAll(QuerySpec.NL, "\n") == """select 
  (TABLEORCOL p_mfgr),
  (TABLEORCOL p_name),
  (TABLEORCOL p_size),
  rank() as r,
  denserank() as dr,
  cumedist() as cud,
  percentrank() as pr,
  ntile(3) as nt,
  count((TABLEORCOL p_size)) as c,
  count((TABLEORCOL p_size), 'all') as ca,
  count((TABLEORCOL p_size), 'distinct') as cd,
  avg((TABLEORCOL p_size)) as avg,
  stddev((TABLEORCOL p_size)) as st,
  first_value((TABLEORCOL p_size)) as fv,
  last_value((TABLEORCOL p_size)) as lv,
  first_value((TABLEORCOL p_size), 'true') w1  as fv2
from part partitionColumns=[p_mfgr] orderColumns=[p_mfgr ASC, p_name ASC]
window 
  w1 as window(start=range(2 PRECEDING), end=range(2 FOLLOWING)) 
into output('/tmp/wout2', serde = 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' with 'field.delim' = ',' format'org.apache.hadoop.mapred.TextOutputFormat')
"""
	}
	
	@Test
	void testStarAndDistinct()
	{
		QuerySpec qSpec = build("""
select  p_mfgr,
	count(*) as c,
	count(distinct p_size) as cd
from part
partition by p_mfgr
order by p_mfgr, p_name
window w1 as rows between 2 preceding and 2 following
into path='/tmp/wout2'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
with serdeproperties('field.delim'=',')
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
//		println qSpec
		assert qSpec.toString().replaceAll(QuerySpec.NL, "\n") == """select 
  (TABLEORCOL p_mfgr),
  count(*) as c,
  count(distinct (TABLEORCOL p_size)) as cd
from part partitionColumns=[p_mfgr] orderColumns=[p_mfgr ASC, p_name ASC]
window 
  w1 as window(start=range(2 PRECEDING), end=range(2 FOLLOWING)) 
into output('/tmp/wout2', serde = 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' with 'field.delim' = ',' format'org.apache.hadoop.mapred.TextOutputFormat')
"""
	}

	@Test
	void testExpressions()
	{
		QuerySpec qSpec = build("""
select  p_mfgr,p_name, p_size,
	rank(p_size / 2 + 7) as r,
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
		
//		println qSpec
		assert qSpec.toString().replaceAll(QuerySpec.NL, "\n") == """select 
  (TABLEORCOL p_mfgr),
  (TABLEORCOL p_name),
  (TABLEORCOL p_size),
  rank((+ (/ (TABLEORCOL p_size) 2) 7)) as r,
  first_value((TABLEORCOL p_size), 'true') w1  as fv1
from part partitionColumns=[p_mfgr] orderColumns=[p_mfgr ASC, p_name ASC]
where (and (> TRUE (TABLEORCOL p_size) 5) (like TRUE (TABLEORCOL p_mfgr) 'abc%'))
window 
  w1 as window(start=range(2 PRECEDING), end=range(2 FOLLOWING)) 
into output('/tmp/wout2', serde = 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' with 'field.delim' = ',' format'org.apache.hadoop.mapred.TextOutputFormat')
"""
	}
	
	@Test
	void testMultipleWindows()
	{
		QuerySpec qSpec = build("""
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
		
//		println qSpec
		assert qSpec.toString().replaceAll(QuerySpec.NL, "\n") == """select 
  (TABLEORCOL p_mfgr),
  (TABLEORCOL p_name),
  (TABLEORCOL p_size),
  rank((+ (/ (TABLEORCOL p_size) 2) 7)) as r,
  denserank() as dr,
  cumedist() as cud,
  sum((TABLEORCOL p_size)) window(start=range(Unbounded PRECEDING), end=currentRow)  as s1,
  sum((TABLEORCOL p_size)) window(start=value((TABLEORCOL p_size) 5 PRECEDING), end=currentRow)  as s2,
  first_value((TABLEORCOL p_size), 'true') w1  as fv1
from part partitionColumns=[p_mfgr] orderColumns=[p_mfgr ASC, p_name ASC]
where (and (> TRUE (TABLEORCOL p_size) 5) (like TRUE (TABLEORCOL p_mfgr) 'abc%'))
window 
  w1 as window(start=range(2 PRECEDING), end=range(2 FOLLOWING)) 
into output('/tmp/wout2', serde = 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' with 'field.delim' = ',' format'org.apache.hadoop.mapred.TextOutputFormat')
"""
	}
	
	@Test
	void testNPath()
	{
		QuerySpec qSpec = build("""
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
		
//		println qSpec
		assert qSpec.toString().replaceAll(QuerySpec.NL, "\n") == """select 
  (TABLEORCOL p_mfgr),
  (TABLEORCOL p_name),
  (TABLEORCOL p_size),
  (TABLEORCOL avgSize),
  (TABLEORCOL sizes)
from npath(
  Fileinput(inputPath = 'src/test/groovy/data/parttiny', keyClass = 'org.apache.hadoop.io.Text', serdeClass = 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe', recordreaderclass = 'com.sap.hadoop.windowing.io.TableWindowingInput', columns = 'p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment', inputformatClass = 'org.apache.hadoop.mapred.TextInputFormat', 'columns.types' = 'int,string,string,string,string,int,string,double,string', valueClass = 'org.apache.hadoop.io.Text') partitionColumns=[p_mfgr] orderColumns=[p_mfgr ASC, p_name ASC]
  'BIG.BIG*', (FUNCTION map "BIG" "p_size > 5"), (FUNCTION array "p_mfgr" "p_name" "p_size" (FUNCTION array "(path.sum() { it.p_size})/((double)count)" "int" "avgSize") (FUNCTION array "path.collect {it.p_size}" "string" "sizes"))
  )
"""
	}
	
	@Test
	void testFlights()
	{
		QuerySpec qSpec = build("""
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
		
//		println qSpec
		assert qSpec.toString().replaceAll(QuerySpec.NL, "\n") == """select 
  (TABLEORCOL origin_city_name),
  (TABLEORCOL year),
  (TABLEORCOL month),
  (TABLEORCOL day_of_month),
  (TABLEORCOL dep_time),
  (FUNCTION lag 'dep_time' 1) as lastdep
from <select origin_city_name, year, month, day_of_month, dep_time
	  from flightsdata
	  where dest_city_name = 'New York' and dep_time != '' and day_of_week = 1> partitionColumns=[origin_city_name, year, month, day_of_month] orderColumns=[dep_time ASC]
where (> TRUE (- (TABLEORCOL dep_time) (FUNCTION lag 'dep_time' 1)) 60)
into output('/tmp/wout', serde = 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' with 'field.delim' = ',' format'org.apache.hadoop.mapred.TextOutputFormat')
"""
	}
	
	@Test
	void testFunctionChain()
	{
		QuerySpec qSpec = build("""
from noop(
	   noop(
		  noop(part_rc partition by p_mfgr order by p_mfgr, p_name)
	   ) partition by p_mfgr order by p_mfgr, p_name
	   ) partition by p_mfgr order by p_mfgr, p_name
select p_mfgr,p_name, p_size, rank() as r
into path='/tmp/wout'
serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
//		println qSpec
		assert qSpec.toString().replaceAll(QuerySpec.NL, "\n") == """select 
  (TABLEORCOL p_mfgr),
  (TABLEORCOL p_name),
  (TABLEORCOL p_size),
  rank() as r
from noop(
  noop(
  noop(
  part_rc partitionColumns=[p_mfgr] orderColumns=[p_mfgr ASC, p_name ASC]
  )
  ) partitionColumns=[p_mfgr] orderColumns=[p_mfgr ASC, p_name ASC]
  ) partitionColumns=[p_mfgr] orderColumns=[p_mfgr ASC, p_name ASC]
into output('/tmp/wout', serde = 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' format'org.apache.hadoop.mapred.TextOutputFormat')
"""
	}
	
	@Test
	void testMarketBasket()
	{
		QuerySpec qSpec = build("""
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
		
//		println qSpec
		assert qSpec.toString().replaceAll(QuerySpec.NL, "\n") == """select 
  (TABLEORCOL itemset)
from candidateFrequentItemSets(
  <select * from basketdata
	 distribute by basketName
	 sort by basketName, itemName> partitionColumns=[itemset] orderColumns=[itemset ASC]
  'basketName', 'itemName', 0.15
  )
into output('/tmp/wout2', serde = 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe' with 'field.delim' = ',' format'org.apache.hadoop.mapred.TextOutputFormat')
"""
	}

	public static QuerySpec build(String query) throws WindowingException
	{
		Windowing2Lexer lexer;
		CommonTokenStream tokens;
		Windowing2Parser parser;
		CommonTree t;
		CommonTreeNodeStream nodes;
		QSpecBuilder2 qSpecBldr;
		String err;
		
		try
		{
			lexer = new Windowing2Lexer(new ANTLRStringStream(query));
			tokens = new CommonTokenStream(lexer);
			parser = new Windowing2Parser(tokens);
			parser.setTreeAdaptor(ParserTest2.adaptor);
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
		
		try
		{
			
			nodes = new CommonTreeNodeStream(t);
			nodes.setTokenStream(tokens)
			qSpecBldr = new QSpecBuilder2(nodes);
			qSpecBldr.query()
	
			err = qSpecBldr.getWindowingParseErrors()
			if ( err != null )
			{
				throw new WindowingException(err)
			}
			
			return qSpecBldr.qSpec
		}
		catch(Throwable te)
		{
			err = qSpecBldr.getWindowingParseErrors()
			if ( err != null )
			{
				throw new WindowingException(err)
			}
			throw new WindowingException("Parse Error:" + te.toString(), te)
		}
	}
}
