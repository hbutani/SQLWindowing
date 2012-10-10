package com.sap.hadoop.windowing.runtime2.mr;

import org.apache.hadoop.hive.ql.plan.AbstractOperatorDesc;

import com.sap.hadoop.windowing.query2.definition.QueryDef;

public class PTFDesc extends AbstractOperatorDesc{

	private static final long serialVersionUID = 1L;
	QueryDef qdef;
	String plan;
	
	public PTFDesc(){
		
	}

    public PTFDesc(QueryDef qdef, String plan) {
    	this.qdef = qdef;
    	this.plan = plan;
	}

	public QueryDef getQdef() {
		return qdef;
	}

	public void setQdef(QueryDef qdef) {
		this.qdef = qdef;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String queryDef) {
		this.plan = queryDef;
	}

}
