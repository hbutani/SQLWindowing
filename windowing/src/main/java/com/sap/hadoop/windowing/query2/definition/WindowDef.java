package com.sap.hadoop.windowing.query2.definition;

import static com.sap.hadoop.Utils.sprintf;

import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec;
import com.sap.hadoop.windowing.query2.specification.WindowSpec;

/*
 * Represents either a (Partition, Order) definition or a QueryInput or represents a WindowSpec for a WindowFunc.
 * <ul>
 * <li> <code>sourceWSpec</code> will be null when this represents a (Partition, Order) definition or a QueryInput 
 * <li> If the <code>sourceWSpec</code> has a <code>sourceId</code> then the unspecified elements in the WindowSpec are applied from the referenced WIndowSpec.
 * </ul>
 */
public class WindowDef
{
	/*
	 * this window definition is tied to the following sourc structure.
	 * In the future this will enable (Partition, Order) specification for a QueryInput to refer to a Window definition. 
	 * This will require that we accept window definitions on DataSets other then the input to the Windowing Table Function. 
	 */
	StructObjectInspector sourceStruct;
	WindowSpec sourceWSpec;
	PartitionDef partDef;
	OrderDef orderDef;
	WindowFrameSpec window;
	
	public StructObjectInspector getSourceStruct()
	{
		return sourceStruct;
	}
	
	public void setSourceStruct(StructObjectInspector sourceStruct)
	{
		this.sourceStruct = sourceStruct;
	}
	
	public WindowSpec getSourceWSpec()
	{
		return sourceWSpec;
	}
	
	public void setSourceWSpec(WindowSpec sourceWSpec)
	{
		this.sourceWSpec = sourceWSpec;
	}
	
	public PartitionDef getPartDef()
	{
		return partDef;
	}
	
	public void setPartDef(PartitionDef partDef)
	{
		this.partDef = partDef;
	}
	
	public OrderDef getOrderDef()
	{
		return orderDef;
	}
	
	public void setOrderDef(OrderDef orderDef)
	{
		this.orderDef = orderDef;
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
		result = prime * result
				+ ((orderDef == null) ? 0 : orderDef.hashCode());
		result = prime * result + ((partDef == null) ? 0 : partDef.hashCode());
		result = prime * result
				+ ((sourceWSpec == null) ? 0 : sourceWSpec.hashCode());
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
		WindowDef other = (WindowDef) obj;
		if (orderDef == null)
		{
			if (other.orderDef != null)
				return false;
		}
		else if (!orderDef.equals(other.orderDef))
			return false;
		if (partDef == null)
		{
			if (other.partDef != null)
				return false;
		}
		else if (!partDef.equals(other.partDef))
			return false;
		if (sourceWSpec == null)
		{
			if (other.sourceWSpec != null)
				return false;
		}
		else if (!sourceWSpec.equals(other.sourceWSpec))
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
		if (partDef != null) buf.append(sprintf("%s ", partDef));
		if (orderDef != null) buf.append(sprintf("%s ", orderDef));
		if (window != null)  buf.append(sprintf("%s ", window));
		if (sourceWSpec != null) buf.append(sprintf(" derived from %s ", sourceWSpec));
		return buf.toString();
	}
}
