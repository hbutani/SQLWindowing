package com.sap.hadoop.windowing.runtime;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.apache.hadoop.conf.Configuration;

import com.sap.hadoop.ds.list.ByteBasedList;
import com.sap.hadoop.windowing.query.LocalTranslator;
import com.sap.hadoop.windowing.runtime.Mode;
import com.sap.hadoop.windowing.runtime.TestExecutor;
import com.sap.hadoop.windowing.runtime.WindowingShell;
import com.sap.hadoop.windowing.BaseTest;
import com.sap.hadoop.windowing.Constants;

class LargePartitionTest extends BaseTest 
{
	@BeforeClass
	public static void setupClass()
	{
		outStream = new ByteArrayOutputStream()
		Configuration cfg = new Configuration()
		cfg.setInt(Constants.WINDOW_PARTITION_MEM_SIZE, ByteBasedList.LARGE_SIZE);
		wshell = new WindowingShell(cfg, new LocalTranslator(), new TestExecutor(out : new PrintStream(outStream)))
	}

	@Test
	void testLag() {
		wshell.execute("""
	from tableinput(
				 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
				 keyClass='org.apache.hadoop.io.Text',
				 valueClass='org.apache.hadoop.io.Text',
				 inputPath='$basedir/data/partvlarge',
				 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
				 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
				 columns = 'p_partkey,p_name,p_mfgr,p_brand,p_type,p_size,p_container,p_retailprice,p_comment',
				 'columns.types' = 'int,string,string,string,string,int,string,double,string'
					)
	partition by p_mfgr
	order by p_mfgr, p_name
	with
		count(<p_name>) as c
	select c""")

		String r = outStream.toString()
		//r = r.replace("\r\n", "\n")
		String[] rows = r.split("\\n")
		assert rows[0] == "[1000000]"
	}
}
