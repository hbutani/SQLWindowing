package com.sap.hadoop.windowing.runtime;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;

import com.sap.hadoop.ds.list.ByteBasedList;
import com.sap.hadoop.windowing.query.LocalTranslator;
import com.sap.hadoop.windowing.runtime.Mode;
import com.sap.hadoop.windowing.runtime.TestExecutor;
import com.sap.hadoop.windowing.runtime.WindowingShell;
import com.sap.hadoop.windowing.BaseTest;
import com.sap.hadoop.windowing.Constants;

class CompositeDataTypesTest extends BaseTest 
{
	@BeforeClass
	public static void setupClass()
	{
		outStream = new ByteArrayOutputStream()
		Configuration cfg = new Configuration()
		HiveConf hConf = new HiveConf(cfg, cfg.getClass())
		cfg.set(Constants.WINDOW_PARTITION_CLASS, "com.sap.hadoop.ds.list.PartitionedByteBasedList")
		cfg.setInt(Constants.WINDOW_PARTITION_MEM_SIZE, ByteBasedList.LARGE_SIZE);
		wshell = new WindowingShell(hConf, new LocalTranslator(), new TestExecutor(out : new PrintStream(outStream)))
	}

	@Test
	void test1() {
		wshell.execute("""
	from tableinput(
				 recordreaderclass='com.sap.hadoop.windowing.io.TableWindowingInput',
				 keyClass='org.apache.hadoop.io.Text',
				 valueClass='org.apache.hadoop.io.Text',
				 inputPath='$basedir/data/compositedatatypes',
				 inputformatClass='org.apache.hadoop.mapred.TextInputFormat',
				 serdeClass='org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe',
				 columns = 'a,b,c,d',
				 'columns.types' = 'string,array<string>,array<map<string,string>>,map<string,array<string>>'
					)
	partition by a
	order by a
	with
		sum(<b?.size()>) as cn
	select a, cn""")

		String r = outStream.toString()
		r = r.replace("\r\n", "\n")
		//println r
		assert r == """[a0, 2]
[a1, 1]
[a2, 0]
[a3, null]
"""
	}
}