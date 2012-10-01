package com.sap.hadoop.windowing.query2.definition;

import java.util.Map;

import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo;

public class QueryDef
{
	QuerySpec qSpec;
	transient QueryTranslationInfo qTranslationInfo;
	Map<String, WindowDef> windowDefs;
	SelectDef selectList;
	QueryInputDef input;
	WhereDef whereDef;
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
	
	public QueryTranslationInfo getTranslationInfo()
	{
		return qTranslationInfo;
	}
	
	public void setTranslationInfo(QueryTranslationInfo qTranslationInfo)
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
		selectList = selectList == null ? new SelectDef() : selectList;
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
	
	public WhereDef getWhere()
	{
		return whereDef;
	}
	
	public void setWhere(WhereDef whereDef)
	{
		this.whereDef = whereDef;
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

}
