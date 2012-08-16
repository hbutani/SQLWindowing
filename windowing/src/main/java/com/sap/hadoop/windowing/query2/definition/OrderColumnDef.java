package com.sap.hadoop.windowing.query2.definition;

import com.sap.hadoop.metadata.Order;
import com.sap.hadoop.windowing.query2.specification.ColumnSpec;
import com.sap.hadoop.windowing.query2.specification.OrderColumnSpec;

public class OrderColumnDef extends ColumnDef
{
	public void setColSpec(ColumnSpec colSpec)
	{
		assert colSpec instanceof OrderColumnSpec;
		super.setColSpec(colSpec);
	}
	
	public Order getOrder()
	{
		return ((OrderColumnSpec)getColSpec()).getOrder();
	}

}
