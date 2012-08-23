package com.sap.hadoop.windowing.query2.definition;

import java.util.Map;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;

import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo;

public class QueryDef
{
	HiveConf hCfg;
	QuerySpec qSpec;
	transient QueryTranslationInfo qTranslationInfo;
	Map<String, WindowDef> windowDefs;
	SelectDef selectList;
	QueryInputDef input;
	ExprNodeDesc whereExprNode;
	ReduceInputDef reduceInput;
	QueryOutputDef output;
	
	public QuerySpec getSpec()
	{
		return qSpec;
	}
	
	public void setqSpec(QuerySpec qSpec)
	{
		this.qSpec = qSpec;
	}
	
	public QueryTranslationInfo getqTranslationInfo()
	{
		return qTranslationInfo;
	}
	
	public void setqTranslationInfo(QueryTranslationInfo qTranslationInfo)
	{
		this.qTranslationInfo = qTranslationInfo;
	}
	
	public Map<String, WindowDef> getWindowDefs()
	{
		return windowDefs;
	}
	
	public void setWindowDefs(Map<String, WindowDef> windowDefs)
	{
		this.windowDefs = windowDefs;
	}
	
	public SelectDef getSelectList()
	{
		return selectList;
	}
	
	public void setSelectList(SelectDef selectList)
	{
		this.selectList = selectList;
	}
	
	public QueryInputDef getInput()
	{
		return input;
	}
	public void setInput(QueryInputDef input)
	{
		this.input = input;
	}
	
	public ExprNodeDesc getWhereExprNode()
	{
		return whereExprNode;
	}
	
	public void setWhereExprNode(ExprNodeDesc whereExprNode)
	{
		this.whereExprNode = whereExprNode;
	}
	
	public ReduceInputDef getReduceInput()
	{
		return reduceInput;
	}
	
	public void setReduceInput(ReduceInputDef reduceInput)
	{
		this.reduceInput = reduceInput;
	}
	
	public QueryOutputDef getOutput()
	{
		return output;
	}
	
	public void setOutput(QueryOutputDef output)
	{
		this.output = output;
	}

	public HiveConf getHiveCfg()
	{
		return hCfg;
	}

	public void setHiveCfg(HiveConf hCfg)
	{
		this.hCfg = hCfg;
	}
}
