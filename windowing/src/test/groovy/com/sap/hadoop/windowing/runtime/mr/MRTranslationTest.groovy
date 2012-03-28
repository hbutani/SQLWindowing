package com.sap.hadoop.windowing.runtime.mr;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.WindowingException;

class MRTranslationTest  extends MRBaseTest
{
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	void test1()
	{
		expectedEx.expect(WindowingException.class);
		expectedEx.expectMessage("Illegal Output Spec: RecordWriter class not valid in MR mode");
		
		wshell.execute("""
		from part
		partition by p_mfgr
		order by p_mfgr, p_name desc
		with
		rank() as r
select p_mfgr,p_name, p_size, r
		into path='/tmp/wout2'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		recordwriter 'org.apache.hadoop.hive.contrib.util.typedbytes.TypedBytesRecordWriter'""")
	}
	
	/**
	* Issue #13 reproted by Pan Fei
	*/
   @Test
   void testEnsureOutputPath()
   {
	   expectedEx.expect(WindowingException.class);
	   expectedEx.expectMessage("Query doesn't contain an output Path for results");
	   wshell.execute("""
from part
	   partition by p_mfgr
	   order by p_mfgr, p_name
	   with
		   rank() as r
	   select p_mfgr,p_name, p_size, r""")
   }
   
   /**
   * Prerequite: create table emptytable(id int, dep string, salary float);
   * 
   * todo: catch this error and at least disallow queries on empty tables.
   */
  @Test
  void testEmptyTable()
  {
	  expectedEx.expect(WindowingException.class);
	  expectedEx.expectMessage("java.lang.ArrayIndexOutOfBoundsException: 0");
	  wshell.execute("""
from emptytable partition by dep order by dep, salary desc with rank() as r select dep, id, salary, r into path = '/tmp/wout'""")
  }

}
