package com.sap.hadoop.windowing.query2.translate;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.apache.hadoop.hive.ql.metadata.HiveException;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.runtime2.WindowingShell;

public class Translator
{
	
	public QueryDef translate(QuerySpec qSpec, WindowingShell wShell) throws WindowingException
	{
		// clone the cfg
		HiveConf qCfg = new HiveConf(wShell.getCfg());
		QueryDef qry = new QueryDef();
		qry.setqSpec(qSpec);
		
		QueryTranslationInfo transInfo = new QueryTranslationInfo();
		transInfo.setHiveCfg(qCfg);
		transInfo.setWshell(wShell);
		try
		{
			transInfo.setHive(Hive.get(qCfg));
			transInfo.setHiveMSClient(HiveUtils.getClient(qCfg));
		}
		catch(HiveException he)
		{
			throw new WindowingException(he);
		}
		qry.setTranslationInfo(transInfo);
		
		InputTranslation.translate(qry);
		WhereTranslation.translate(qry);
		OutputTranslation.translate(qry);
		
		return qry;
	}
	
}
