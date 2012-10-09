package com.sap.hadoop.windowing.query2.translate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.apache.hadoop.hive.ql.parse.RowResolver;
import org.apache.hadoop.hive.ql.parse.TypeCheckCtx;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeGenericFuncDesc;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
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
	Map<String, InputInfo> inputInfoMap;
	
	/*
	 * InputInfos for table functions that rehape the input map-side.
	 */
	Map<String, InputInfo> mapReshapeInfoMap;
	
	LeadLagInfo llInfo;
	
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
	
	void addInput(QueryInputDef input) throws WindowingException
	{
		inputInfoMap = inputInfoMap == null ? new HashMap<String, QueryTranslationInfo.InputInfo>() : inputInfoMap;
		inputInfoMap.put(input.getAlias(), new InputInfo(this, input, null));
	}
	
	public InputInfo getMapInputInfo(TableFuncDef tDef) throws WindowingException
	{
		TableFunctionEvaluator tFn = tDef.getFunction();
		if ( !tFn.hasMapPhase() )
		{
			return null;
		}
		mapReshapeInfoMap = mapReshapeInfoMap == null ? new HashMap<String, InputInfo>() : mapReshapeInfoMap;
		InputInfo ii = mapReshapeInfoMap.get(tDef.getAlias());
		if ( ii == null )
		{
			ii = new InputInfo(this, tDef, tFn.getMapOutputOI());
			mapReshapeInfoMap.put(tDef.getAlias(), ii);
		}
		return ii;
	}
	
	public InputInfo getInputInfo(QueryInputDef input)
	{
		return inputInfoMap.get(input.getAlias());
	}
	
	public static class InputInfo
	{
		private boolean forMapPhase;
		private QueryInputDef inpDef;
		private StructObjectInspector OI;
		private RowResolver rr;
		private TypeCheckCtx tCtx;
		
		InputInfo(QueryTranslationInfo tInfo, QueryInputDef input, StructObjectInspector mapOI) 
			throws WindowingException
		{
			this.inpDef = input;
			this.forMapPhase = mapOI != null;
			OI = forMapPhase ? mapOI : inpDef.getOI();
			rr = HiveUtils.getRowResolver(inpDef.getAlias(), OI);
			tCtx = new TypeCheckCtx(rr);
			tCtx.setUnparseTranslator(null);
		}

		public RowResolver getRowResolver()
		{
			return rr;
		}

		public TypeCheckCtx getTypeCheckCtx()
		{
			return tCtx;
		}
		
		public String getAlias()
		{
			return inpDef.getAlias();
		}
		
		public QueryInputDef getInputDef()
		{
			return inpDef;
		}
		
		public ObjectInspector getOI()
		{
			return OI;
		}
	}
	
	public LeadLagInfo getLLInfo()
	{
		llInfo = llInfo == null ? new LeadLagInfo() : llInfo;
		return llInfo;
	}


	public static class LeadLagInfo
	{
		List<ExprNodeGenericFuncDesc> leadLagExprs;
		Map<ExprNodeDesc, List<ExprNodeGenericFuncDesc>> mapTopExprToLLFunExprs;
			
		private void addLeadLagExpr(ExprNodeGenericFuncDesc llFunc)
		{
			leadLagExprs = leadLagExprs == null ? new ArrayList<ExprNodeGenericFuncDesc>() : leadLagExprs;
			leadLagExprs.add(llFunc);
		}
	
		public List<ExprNodeGenericFuncDesc> getLeadLagExprs()
		{
			return leadLagExprs;
		}
		
		public void addLLFuncExprForTopExpr(ExprNodeDesc topExpr, ExprNodeGenericFuncDesc llFuncExpr)
		{
			addLeadLagExpr(llFuncExpr);
			mapTopExprToLLFunExprs = mapTopExprToLLFunExprs == null ? 
					new HashMap<ExprNodeDesc, List<ExprNodeGenericFuncDesc>>() : mapTopExprToLLFunExprs;
			List<ExprNodeGenericFuncDesc> funcList = mapTopExprToLLFunExprs.get(topExpr);
			if ( funcList == null )
			{
				funcList = new ArrayList<ExprNodeGenericFuncDesc>();
				mapTopExprToLLFunExprs.put(topExpr, funcList);
			}
			funcList.add(llFuncExpr);
		}
		
		public List<ExprNodeGenericFuncDesc> getLLFuncExprsInTopExpr(ExprNodeDesc topExpr)
		{
			if ( mapTopExprToLLFunExprs == null ) return null;
			return mapTopExprToLLFunExprs.get(topExpr);
		}
	}
	
}
