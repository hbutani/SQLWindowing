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
}
