package com.sap.hadoop.windowing.query2.translate;

import java.util.ArrayList;

import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.runtime2.WindowingShell;

public class QueryComponentizer
{
	QueryDef qDef;
	WindowingShell wShell;
	
	public QueryComponentizer(QueryDef qDef, WindowingShell wShell)
	{
		super();
		this.qDef = qDef;
		this.wShell = wShell;
	}
	
	public ArrayList<QueryDef> componentize()
	{
		ArrayList<QueryDef> cqDefs = new ArrayList<QueryDef>();
		// Todo
		cqDefs.add(qDef);
		return cqDefs;
	}
}
