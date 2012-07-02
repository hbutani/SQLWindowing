package com.sap.hadoop.query2.specification;

public abstract class QueryInputSpec
{
	PartitionSpec partition;
	OrderSpec order;
	
	public PartitionSpec getPartition()
	{
		return partition;
	}
	public void setPartition(PartitionSpec partition)
	{
		this.partition = partition;
	}
	public OrderSpec getOrder()
	{
		return order;
	}
	public void setOrder(OrderSpec order)
	{
		this.order = order;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result
				+ ((partition == null) ? 0 : partition.hashCode());
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
		QueryInputSpec other = (QueryInputSpec) obj;
		if (order == null)
		{
			if (other.order != null)
				return false;
		}
		else if (!order.equals(other.order))
			return false;
		if (partition == null)
		{
			if (other.partition != null)
				return false;
		}
		else if (!partition.equals(other.partition))
			return false;
		return true;
	}
	
}
