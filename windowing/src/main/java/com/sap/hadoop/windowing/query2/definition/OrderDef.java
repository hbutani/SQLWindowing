package com.sap.hadoop.windowing.query2.definition;

import java.util.ArrayList;

import com.sap.hadoop.windowing.query2.specification.OrderSpec;

public class OrderDef
{
	OrderSpec spec;
	ArrayList<OrderColumnDef> columns;
	
	public OrderDef(OrderSpec spec)
	{
		this.spec = spec;
	}
	
	public OrderDef(PartitionDef pDef)
	{
		this.spec = new OrderSpec(pDef.getSpec());
		for(ColumnDef cDef : pDef.getColumns())
		{
			addColumn(new OrderColumnDef(cDef));
		}
	}
	
	public OrderSpec getSpec()
	{
		return spec;
	}
	
	public ArrayList<OrderColumnDef> getColumns()
	{
		return columns;
	}
	
	public void setColumns(ArrayList<OrderColumnDef> columns)
	{
		this.columns = columns;
	}
	
	public void addColumn(OrderColumnDef c)
	{
		columns = columns == null ? new ArrayList<OrderColumnDef>() : columns;
		columns.add(c);
	}
}
