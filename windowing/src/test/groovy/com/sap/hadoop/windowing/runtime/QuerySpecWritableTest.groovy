package com.sap.hadoop.windowing.runtime;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sap.hadoop.windowing.BaseTest;
import com.sap.hadoop.windowing.query.FuncSpec;
import com.sap.hadoop.windowing.query.OrderColumn;
import com.sap.hadoop.windowing.query.QuerySpec;
import com.sap.hadoop.windowing.query.TableInput;

class QuerySpecWritableTest  extends BaseTest
{
	DataOutputStream dout;
	
	@Before
	public void setup()
	{
		super.setup()
		dout = new DataOutputStream(outStream)
	}
	
	private void checkQuerySpec(QuerySpec qSpec)
	{
		qSpec.write(dout)
		ByteArrayInputStream bis = new ByteArrayInputStream(outStream.toByteArray())
		DataInputStream din = new DataInputStream(bis);
		
		/*qSpec.funcSpecs[1].write(dout)
		ByteArrayInputStream bis = new ByteArrayInputStream(outStream.toByteArray())
		DataInputStream din = new DataInputStream(bis);
		FuncSpec oc = new FuncSpec()
		oc.readFields(din)
		println oc*/
		
		QuerySpec qSpec2 = new QuerySpec()
		qSpec2.readFields(din)
		
		assert qSpec.toString() == qSpec2.toString()
	}
	
	@Test
	void test1() 
	{
		QuerySpec qSpec = wshell.parse("""
from tableinput(
			 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
       keyClass='org.apache.hadoop.io.Text', 
       valueClass='org.apache.hadoop.io.Text',
			 inputPath='$basedir/data/partsmall',
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
		
		checkQuerySpec(qSpec)
	}
	
	@Test
	void testTableName()
	{
		QuerySpec qSpec = wshell.parse("""
		from part
		partition by p_mfgr
		order by p_mfgr, p_name
		with
			rank() as r
		select p_mfgr,p_name, p_size, r""")
		checkQuerySpec(qSpec)
	}
	
	@Test
	void testOutputPath()
	{
		QuerySpec qSpec = wshell.parse("""
		from part
		partition by p_mfgr
		order by p_mfgr, p_name
		with
			rank() as r
		select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'""")
		checkQuerySpec(qSpec)
	}
	
	@Test
	void testOutputFormat()
	{
		QuerySpec qSpec = wshell.parse("""
		from part
		partition by p_mfgr
		order by p_mfgr, p_name
		with
			rank() as r
		select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe'
		format 'org.apache.hadoop.mapred.SequenceFileOutputFormat'""")
		checkQuerySpec(qSpec)
	}
	
	@Test
	void testEmbeddedHiveQuery()
	{
		QuerySpec qSpec = wshell.parse("""
		from <select p_mfgr, p_name, p_size
				from part_rc>
		partition by p_mfgr
		order by p_mfgr, p_name
		with
		rank() as r
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		checkQuerySpec(qSpec)
	}
	
	@Test
	void testTableFunction()
	{
		QuerySpec qSpec = wshell.parse("""
		from npath(<select p_mfgr, p_name, p_size
				from part_rc> partition by p_mfgr order by p_mfgr, p_name, '')
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		checkQuerySpec(qSpec)
	}
	
	@Test
	void testTableFunction2()
	{
		QuerySpec qSpec = wshell.parse("""
		from dummy(npath(<select p_mfgr, p_name, p_size
				from part_rc> partition by p_mfgr order by p_mfgr, p_name, ''), 'a', 'b')
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		checkQuerySpec(qSpec)
	}
	
	@Test
	void testOutputToTable()
	{
		QuerySpec qSpec = wshell.parse("""
		from <select p_mfgr, p_name, p_size
				from part_rc>
		partition by p_mfgr
		order by p_mfgr, p_name
		with
		rank() as r
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'
		load overwrite into table part_win""")
		
		checkQuerySpec(qSpec)
	}
	
	@Test
	void testOutputToTable2()
	{
		QuerySpec qSpec = wshell.parse("""
		from <select p_mfgr, p_name, p_size
				from part_rc>
		partition by p_mfgr
		order by p_mfgr, p_name
		with
		rank() as r
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'
		load into table part_win partition '(p_date=\\'12-15-2010\\')'""")
		
		checkQuerySpec(qSpec)
	}
	
	@Test
	void testClone1()
	{
		QuerySpec qSpec = wshell.parse("""
		from <select p_mfgr, p_name, p_size
				from part_rc>
		partition by p_mfgr
		order by p_mfgr, p_name
		with
		rank() as r
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'
		load into table part_win partition '(p_date=\\'12-15-2010\\')'""")
		
		QuerySpec qSpec2 = (QuerySpec) qSpec.clone();
		assert qSpec.toString() == qSpec2.toString()
	}
	
	@Test
	void testClone2()
	{
		QuerySpec qSpec = wshell.parse("""
		from npath(<select p_mfgr, p_name, p_size
				from part_rc> partition by p_mfgr order by p_mfgr, p_name, '')
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		QuerySpec qSpec2 = (QuerySpec) qSpec.clone();
		assert qSpec.toString() == qSpec2.toString()
	}
}
