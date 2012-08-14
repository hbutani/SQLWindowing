package com.sap.hadoop.windowing.query2.specification;

import static com.sap.hadoop.Utils.sprintf;

import com.sap.hadoop.metadata.Order;

public class OrderColumnSpec extends ColumnSpec
{
	Order order;
	
	public OrderColumnSpec() {}
	
	public OrderColumnSpec(String tableName, String columnName, Order order)
	{
		super(tableName, columnName);
		this.order = order;
	}

	public Order getOrder()
	{
		return order;
	}

	public void setOrder(Order order)
	{
		this.order = order;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderColumnSpec other = (OrderColumnSpec) obj;
		if (order != other.order)
			return false;
		return true;
	}

	public String toString()
	{
		return sprintf("%s %s", super.toString(), order);
	}
}
