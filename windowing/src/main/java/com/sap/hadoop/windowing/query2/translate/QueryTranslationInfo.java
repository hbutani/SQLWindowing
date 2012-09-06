package com.sap.hadoop.windowing.query2.translate;

import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.apache.hadoop.hive.ql.parse.RowResolver;
import org.apache.hadoop.hive.ql.parse.TypeCheckCtx;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.TableFunctionResolver;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
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
	Map<QueryInputDef, InputInfo> inputInfoMap;
	
	/*
	 * InputInfos for table functions that rehape the input map-side.
	 */
	Map<TableFuncDef, InputInfo> mapReshapeInfoMap;
	
	/*
	 * A mapping from a name to WindowDef. A Window Defintion specified at the Query level can be used in multiple Inputs. Hence the
	 * 2 level map.
	 */
	Map<String, Map<QueryInputDef, WindowDef>> nameToWindowDef;
	
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
	
	void addInput(String alias, QueryInputDef input) throws WindowingException
	{
		inputInfoMap = inputInfoMap == null ? new HashMap<QueryInputDef, QueryTranslationInfo.InputInfo>() : inputInfoMap;
		inputInfoMap.put(input, new InputInfo(alias, input.getOI()));
	}
	
	InputInfo getMapInputInfo(TableFuncDef tDef) throws WindowingException
	{
		TableFunctionResolver tFn = tDef.getFunction();
		if ( !tFn.hasMapPhase() )
		{
			return null;
		}
		mapReshapeInfoMap = mapReshapeInfoMap == null ? new HashMap<TableFuncDef, InputInfo>() : mapReshapeInfoMap;
		InputInfo ii = mapReshapeInfoMap.get(tDef);
		if ( ii == null )
		{
			ii = new InputInfo(tDef.getName(), tFn.getMapOutputOI());
			mapReshapeInfoMap.put(tDef, ii);
		}
		return ii;
	}
	
	InputInfo getInputInfo(QueryInputDef input)
	{
		return inputInfoMap.get(input);
	}
	
	static class InputInfo
	{
		String tabAlias;
		StructObjectInspector OI;
		RowResolver rr;
		TypeCheckCtx tCtx;
		
		InputInfo(String tabAlias, StructObjectInspector OI) throws WindowingException
		{
			this.tabAlias = tabAlias;
			this.OI = OI;
			rr = HiveUtils.getRowResolver(tabAlias, OI);
			tCtx = new TypeCheckCtx(rr);
			tCtx.setUnparseTranslator(null);
		}
	}
	
	WindowDef getWindowDef(String name, QueryInputDef iDef)
	{
		Map<QueryInputDef, WindowDef> inpDefMap = nameToWindowDef == null ? null : nameToWindowDef.get(name);
		WindowDef wDef = inpDefMap == null ? null : inpDefMap.get(iDef);
		return wDef;
	}
	
	void addWindowDef(String name, QueryInputDef iDef, WindowDef wDef)
	{
		nameToWindowDef = nameToWindowDef == null ? new HashMap<String, Map<QueryInputDef,WindowDef>>() : nameToWindowDef;
		Map<QueryInputDef, WindowDef> inpDefMap = nameToWindowDef.get(name);
		if ( inpDefMap == null)
		{
			inpDefMap = new HashMap<QueryInputDef, WindowDef>();
			nameToWindowDef.put(name, inpDefMap);
		}
		inpDefMap.put(iDef, wDef);
	}

}
