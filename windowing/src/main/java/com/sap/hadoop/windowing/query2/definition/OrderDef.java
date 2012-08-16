package com.sap.hadoop.windowing.query2.definition;

import java.util.ArrayList;

import com.sap.hadoop.windowing.query2.specification.OrderSpec;

public class OrderDef
{
	OrderSpec oSpec;
	ArrayList<OrderColumnDef> columns;
	
	public OrderSpec getoSpec()
	{
		return oSpec;
	}
	
	public void setoSpec(OrderSpec oSpec)
	{
		this.oSpec = oSpec;
	}
	
	public ArrayList<OrderColumnDef> getColumns()
	{
		return columns;
	}
	
	public void setColumns(ArrayList<OrderColumnDef> columns)
	{
		this.columns = columns;
	}
	
	public void addColumn(OrderColumnDef ocDef)
	{
		columns = columns == null ? new ArrayList<OrderColumnDef>() : columns;
		columns.add(ocDef);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((columns == null) ? 0 : columns.hashCode());
		result = prime * result + ((oSpec == null) ? 0 : oSpec.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDef other = (OrderDef) obj;
		if (columns == null)
		{
			if (other.columns != null)
				return false;
		}
		else if (!columns.equals(other.columns))
			return false;
		if (oSpec == null)
		{
			if (other.oSpec != null)
				return false;
		}
		else if (!oSpec.equals(other.oSpec))
			return false;
		return true;
	}
	
	public String toString() { return oSpec.toString(); }
}
