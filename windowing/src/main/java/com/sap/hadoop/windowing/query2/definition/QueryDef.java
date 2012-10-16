package com.sap.hadoop.windowing.query2.definition;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sap.hadoop.windowing.query2.SerializationUtils;
import com.sap.hadoop.windowing.query2.specification.HiveTableSpec;
import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo;

public class QueryDef
{
	@SuppressWarnings("unused")
	private static final Log LOG = LogFactory.getLog(QueryDef.class.getName());
	QuerySpec spec;
	transient QueryTranslationInfo translationInfo;
	Map<String, WindowDef> windowDefs;
	SelectDef selectList;
	QueryInputDef input;
	WhereDef whereDef;
	ReduceInputDef reduceInput;
	QueryOutputDef output;
	
	static{
		SerializationUtils.makeTransient(QueryDef.class, "translationInfo");
	}
	
	public QueryDef(){
		
	}
	
	public QuerySpec getSpec()
	{
		return spec;
	}
	
	public void setSpec(QuerySpec spec)
	{
		this.spec = spec;
	}
	
	public QueryTranslationInfo getTranslationInfo()
	{
		return translationInfo;
	}
	
	public void setTranslationInfo(QueryTranslationInfo translationInfo)
	{
		this.translationInfo = translationInfo;
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
	
	/*
	 * get the Hive Table associated with this input chain.
	 */
	public HiveTableSpec getHiveTableSpec()
	{
		return getInput().getHiveTableSpec();
	}
	
	public HiveTableDef getHiveTableDef()
	{
		return getInput().getHiveTableDef();
	}

}