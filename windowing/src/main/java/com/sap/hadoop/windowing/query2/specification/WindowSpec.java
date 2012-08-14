package com.sap.hadoop.windowing.query2.specification;

import static com.sap.hadoop.Utils.sprintf;

public class WindowSpec
{
	String sourceId;
	PartitionSpec partition;
	OrderSpec order;
	WindowFrameSpec window;
	
	public WindowSpec() {}
	
	public WindowSpec(String sourceId, PartitionSpec partition,
			OrderSpec order, WindowFrameSpec window)
	{
		super();
		this.sourceId = sourceId;
		this.partition = partition;
		this.order = order;
		this.window = window;
	}

	public String getSourceId()
	{
		return sourceId;
	}

	public void setSourceId(String sourceId)
	{
		this.sourceId = sourceId;
	}

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

	public WindowFrameSpec getWindow()
	{
		return window;
	}

	public void setWindow(WindowFrameSpec window)
	{
		this.window = window;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result
				+ ((partition == null) ? 0 : partition.hashCode());
		result = prime * result
				+ ((sourceId == null) ? 0 : sourceId.hashCode());
		result = prime * result + ((window == null) ? 0 : window.hashCode());
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
		WindowSpec other = (WindowSpec) obj;
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
		if (sourceId == null)
		{
			if (other.sourceId != null)
				return false;
		}
		else if (!sourceId.equals(other.sourceId))
			return false;
		if (window == null)
		{
			if (other.window != null)
				return false;
		}
		else if (!window.equals(other.window))
			return false;
		return true;
	}

	public String toString()
	{
		StringBuilder buf = new StringBuilder();
		if (sourceId != null) buf.append(sprintf("%s ", sourceId));
		if (partition != null) buf.append(sprintf("%s ", partition));
		if (order != null) buf.append(sprintf("%s ", order));
		if (window != null)  buf.append(sprintf("%s ", window));
		return buf.toString();
	}
}
