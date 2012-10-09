package com.sap.hadoop.windowing.runtime2.mr;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hive.ql.plan.AbstractOperatorDesc;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;

import com.sap.hadoop.windowing.functions.OutputPartition;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.runtime.IPartition;
import com.sap.hadoop.windowing.runtime2.Partition;

public class PTFDesc extends AbstractOperatorDesc{

	private static final long serialVersionUID = 1L;
	QueryDef qdef;
/*	TableFuncDef tabDef;
	OutputPartition outPart;
	IPartition inPart;
	Partition part;
	ArrayList<ExprNodeDesc> partColList;
	ArrayList<ExprNodeDesc> inColList;
	List<String> outColList;
*/
	public PTFDesc(){
		
	}

    public PTFDesc(
		    //TableFuncDef tabDef,
		    QueryDef qdef//,
		    //final ArrayList<ExprNodeDesc> partColList
		    ) {
    	this.qdef = qdef;
    	//this.tabDef = tabDef;
    	//this.partColList = partColList;
	}

	public QueryDef getQdef() {
		return qdef;
	}

	public void setQdef(QueryDef qdef) {
		this.qdef = qdef;
	}
/*
	public TableFuncDef getTabDef() {
		return tabDef;
	}

	public void setTabDef(TableFuncDef tabDef) {
		this.tabDef = tabDef;
	}

	public OutputPartition getOutPart() {
		return outPart;
	}

	public void setOutPart(OutputPartition outPart) {
		this.outPart = outPart;
	}

	public IPartition getInPart() {
		return inPart;
	}

	public void setInPart(IPartition inPart) {
		this.inPart = inPart;
	}

	public Partition getPart() {
		return part;
	}

	public void setPart(Partition part) {
		this.part = part;
	}

	public ArrayList<ExprNodeDesc> getInColList() {
		return inColList;
	}

	public void setInColList(ArrayList<ExprNodeDesc> inColList) {
		this.inColList = inColList;
	}

	public List<String> getOutColList() {
		return outColList;
	}

	public void setOutColList(List<String> outColList) {
		this.outColList = outColList;
	}

	public ArrayList<ExprNodeDesc> getPartColList() {
		return partColList;
	}

	public void setPartColList(ArrayList<ExprNodeDesc> partColList) {
		this.partColList = partColList;
	}

*/

}
