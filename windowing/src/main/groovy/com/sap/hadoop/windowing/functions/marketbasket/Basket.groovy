package com.sap.hadoop.windowing.functions.marketbasket

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Writer;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;

protected class Basket  implements Writable
{
	ArrayList<Integer> items
	
	protected Basket()
	{
		items = new ArrayList<Integer>();
	}
	
	void addItem(int item)
	{
		items.add(item)
	}
	
	Integer get(int i)
	{
		return items.get(i)
	}
	
	int size()
	{
		return items.size();
	}


	@Override
	public void write(DataOutput out) throws IOException
	{
		out.writeInt(items.size())
		items.each { iId ->
			WritableUtils.writeVInt(out, iId);
		}
		
	}

	@Override
	public void readFields(DataInput din) throws IOException
	{
		items.clear()
		int sz = din.readInt()
		(0..<sz).each { i ->
			items.add(WritableUtils.readVInt(din))
		}
		
	}
}
