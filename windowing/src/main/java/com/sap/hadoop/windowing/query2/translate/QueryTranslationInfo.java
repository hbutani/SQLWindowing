package com.sap.hadoop.windowing.query2.translate;

import java.util.Map;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.query2.definition.WindowDef;
import com.sap.hadoop.windowing.runtime2.HiveQueryExecutor;
import com.sap.hadoop.windowing.runtime2.WindowingShell;


/*
 * The information captured during translation of a QuerySpec into a QueryDef
 */
public class QueryTranslationInfo
{
	HiveConf hCfg;
	WindowingShell wshell;
	Hive hive;
	HiveMetaStoreClient hiveMSC;
	
	/*
	 * A map from a QueryInput to the WindowDefns defined on it.
	 * 	In the future this will enable (Partition, Order) specification for a QueryInput to refer to a Window definition. 
	 * This will require that we accept window definitions on DataSets other then the input to the Windowing Table Function. 
	 */
	Map<String, Map<String, WindowDef>> windowDefMap;
	
	/*
	 * A map from a QueryInput to its Shape.
	 */
	Map<String, StructObjectInspector> OIMap;
	
	public HiveConf getHiveCfg()
	{
		return hCfg;
	}

	public void setHiveCfg(HiveConf hCfg)
	{
		this.hCfg = hCfg;
	}

	public WindowingShell getWshell()
	{
		return wshell;
	}

	public void setWshell(WindowingShell wshell)
	{
		this.wshell = wshell;
	}

	public HiveMetaStoreClient getHiveMSClient()
	{
		return hiveMSC;
	}

	public void setHiveMSClient(HiveMetaStoreClient hiveMSC)
	{
		this.hiveMSC = hiveMSC;
	}

	public Hive getHive()
	{
		return hive;
	}

	public void setHive(Hive hive)
	{
		this.hive = hive;
	}
	
	public HiveQueryExecutor getHiveQueryExecutor()
	{
		return getWshell().getHiveQryExec();
	}

}
