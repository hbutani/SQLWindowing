package com.sap.hadoop.windowing.query2.definition;

import com.sap.hadoop.metadata.Order;
import com.sap.hadoop.windowing.query2.specification.OrderColumnSpec;

public class OrderColumnDef extends ColumnDef
{
	public OrderColumnDef(OrderColumnSpec spec)
	{
		super(spec);
	}
	
	public OrderColumnDef(ColumnDef cDef)
	{
		super(cDef);
		this.spec = new OrderColumnSpec(spec);
	}
	
	public Order getOrder()
	{
		return ((OrderColumnSpec)getSpec()).getOrder();
	}

}
