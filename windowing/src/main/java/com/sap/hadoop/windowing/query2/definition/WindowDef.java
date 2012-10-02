package com.sap.hadoop.windowing.query2.definition;

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
	WindowSpec spec;
	PartitionDef partDef;
	OrderDef orderDef;
	WindowFrameDef window;
	
	public WindowDef(){
		
	}
	
	public WindowDef(WindowSpec spec)
	{
		this.spec = spec;
	}
	
	public WindowDef(WindowSpec spec, WindowDef srcWdwDef)
	{
		this(spec);
		partDef = srcWdwDef.partDef;
		orderDef = srcWdwDef.orderDef;
		window = srcWdwDef.window;
	}
	
	public WindowSpec getsSpec()
	{
		return spec;
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
	
	public WindowFrameDef getWindow()
	{
		return window;
	}
	
	public void setWindow(WindowFrameDef window)
	{
		this.window = window;
	}

}
