package com.sap.hadoop.windowing.testutils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.conf.HiveConf;
import org.junit.BeforeClass;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.translate.Translator;
import com.sap.hadoop.windowing.runtime2.ThriftBasedHiveQueryExecutor;
import com.sap.hadoop.windowing.runtime2.WindowingShell;
import com.sap.hadoop.windowing.runtime2.mr.MRExecutor;

public abstract class MRBaseTest extends BaseTest
{
	@BeforeClass
	public static void setupClass() throws Exception
	{
		setupCluster();
		
		HiveConf hCfg = new HiveConf(conf, conf.getClass());
		wshell = new WindowingShell(hCfg, new Translator(), new MRExecutor());
		wshell.setHiveQryExec(new ThriftBasedHiveQueryExecutor(conf));
	}
	
	public static String getOutput(QueryDef qDef) throws WindowingException
	{
		InputStream is = null;
		try
		{
			String oPathLoc = qDef.getOutput().getSpec().getPath();
			FileSystem fs = FileSystem.get(wshell.getCfg());
			Path oPath = new Path(oPathLoc).makeQualified(fs);
			
			FileStatus[] fStat = fs.listStatus(oPath);
			
			is = fs.open(fStat[0].getPath());
			return IOUtils.toString(is);

		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
		finally
		{
			if ( is != null )
			{
				try
				{
					is.close();
				}
				catch(IOException ie)
				{
				}
			}
		}
	}
}
