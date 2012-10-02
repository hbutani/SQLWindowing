package com.sap.hadoop.windowing.query2.definition;

import java.util.ArrayList;

import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.Utils;
import com.sap.hadoop.windowing.query2.specification.SelectSpec;

public class SelectDef
{
	SelectSpec selectSpec;
	ArrayList<WindowFunctionDef> windowFuncs;
	ArrayList<ColumnDef> columns;
	transient StructObjectInspector OI;
	
	static{
		Utils.makeTransient(SelectDef.class, "OI");
	}

	
	public SelectDef(){
		
	}
	
	public SelectSpec getSelectSpec()
	{
		return selectSpec;
	}
	
	public void setSelectSpec(SelectSpec selectSpec)
	{
		this.selectSpec = selectSpec;
	}
	
	public ArrayList<WindowFunctionDef> getWindowFuncs()
	{
		return windowFuncs;
	}
	
	public void setWindowFuncs(ArrayList<WindowFunctionDef> windowFuncs)
	{
		this.windowFuncs = windowFuncs;
	}

	public ArrayList<ColumnDef> getColumns()
	{
		return columns;
	}

	public void setColumns(ArrayList<ColumnDef> columns)
	{
		this.columns = columns;
	}
	
	public void addColumn(ColumnDef cDef)
	{
		columns = columns == null ? new ArrayList<ColumnDef>() : columns;
		columns.add(cDef);
	}

	public StructObjectInspector getOI()
	{
		return OI;
	}

	public void setOI(StructObjectInspector oI)
	{
		OI = oI;
	}
}
