package com.sap.hadoop.windowing.query2.translate;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.ArgDef;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.HiveQueryDef;
import com.sap.hadoop.windowing.query2.definition.HiveTableDef;
import com.sap.hadoop.windowing.query2.definition.OrderColumnDef;
import com.sap.hadoop.windowing.query2.definition.OrderDef;
import com.sap.hadoop.windowing.query2.definition.PartitionDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryOutputDef;
import com.sap.hadoop.windowing.query2.definition.SelectDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.definition.WhereDef;
import com.sap.hadoop.windowing.query2.definition.WindowDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.CurrentRowDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.RangeBoundaryDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.ValueBoundaryDef;
import com.sap.hadoop.windowing.query2.definition.WindowFunctionDef;

public class QueryDefVisitor
{
	QueryDef qDef;
	
	public void initialize(QueryDef qDef)
	{
		this.qDef = qDef;
	}
	
	public void finish() throws WindowingException
	{
		
	}
	
	public void visit(HiveTableDef hiveTable) throws WindowingException
	{
	}
	
	public void visit(HiveQueryDef hiveQuery) throws WindowingException
	{
	}
	
	public void preVisit(TableFuncDef tblFunc) throws WindowingException
	{
	}
	
	public void visit(TableFuncDef tblFunc) throws WindowingException
	{
	}
	
	public void visit(ArgDef arg) throws WindowingException
	{
	}
	
	public void visit(WindowDef window) throws WindowingException
	{
	}
	
	public void visit(PartitionDef partition) throws WindowingException
	{
	}
	
	public void visit(OrderDef order) throws WindowingException
	{
	}
	
	public void visit(WindowFrameDef windowFrame) throws WindowingException
	{
	}
	
	public void visit(ColumnDef column) throws WindowingException
	{
	}
	
	public void visit(OrderColumnDef column) throws WindowingException
	{
	}
	
	public void visit(CurrentRowDef boundary) throws WindowingException
	{
	}
	
	public void visit(RangeBoundaryDef boundary) throws WindowingException
	{
	}
	
	public void visit(ValueBoundaryDef boundary) throws WindowingException
	{
	}
	
	public void visit(WindowFunctionDef wFn) throws WindowingException
	{
	}
	
	public void visit(WhereDef where) throws WindowingException
	{
	}
	
	public void visit(SelectDef select) throws WindowingException
	{
	}
	
	public void visit(QueryOutputDef output) throws WindowingException
	{
	}
}
