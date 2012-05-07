package com.sap.hadoop.windowing.functions.marketbasket

import java.awt.ItemSelectable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.io.WritableUtils;

class ItemSet implements WritableComparable<ItemSet>
{
	byte sz;
	int[] itemIds;
	
	public ItemSet() {}
	
	public ItemSet(byte sz, int... itemIds)
	{
		this.sz = sz
		assert itemIds.length == sz
		this.itemIds = itemIds
	}
	
	/*
	 * invoke only from ItemSetIterator
	 */
	protected ItemSet(byte sz)
	{
		this.sz = sz
		this.itemIds = new int[sz]
	}
	
	protected reset(int... itemIds)
	{
		System.arraycopy(itemIds, 0, this.itemIds, 0, sz)
	}
	
	protected reset(ItemSet... subSets)
	{
		int idx = 0
		for(int i=0; i < subSets.length; i++)
		{
			System.arraycopy(subSets[i].itemIds, 0, this.itemIds, idx, subSets[i].itemIds.length)
			idx += subSets[i].itemIds.length
		}
	}

	@Override
	public void write(DataOutput out) throws IOException
	{
		out.writeByte(sz)
		itemIds.each { iId ->
			WritableUtils.writeVInt(out, iId);
		}
		
	}

	@Override
	public void readFields(DataInput din) throws IOException
	{
		sz = din.readByte()
		itemIds = new int[sz]
		(0..<sz).each { i ->
			itemIds[i] = WritableUtils.readVInt(din)
		}
	}

	@Override
	public int compareTo(ItemSet other)
	{
		byte sDiff = sz - other.sz
		if ( sDiff != 0 )
		{
			return (sDiff < 0) ? -1 : 1
		}
		
		(0..<sz).each { i ->
			int diff = itemIds[i] - other.itemIds[i]
			if ( diff != 0 )
			{
				return (diff < 0) ? -1 : 1
			}
		}
		return 0;
	}
	
	public String toString()
	{
		return itemIds.toString()
	}
	
	/** A Comparator optimized for ByteWritable. */
	public static class Comparator extends WritableComparator 
	{
	  public Comparator() {
		super(ItemSet.class);
	  }
  
	  public int compare(byte[] b1, int s1, int l1,
						 byte[] b2, int s2, int l2) 
	  {
		byte thisValue = b1[s1];
		byte thatValue = b2[s2];
		return (thisValue < thatValue ? -1 : (thisValue == thatValue ? 0 : 1));
		
		
		ByteArrayInputStream is1 = new ByteArrayInputStream(b1, s1, l1)
		DataInputStream din1 = new DataInputStream(is1)
		ByteArrayInputStream is2 = new ByteArrayInputStream(b2, s2, l2)
		DataInputStream din2 = new DataInputStream(is2)
		
		//compare sz
		byte sz1 = din1.readByte()
		byte sz2 = din2.readByte()
		if ( sz1 != sz2)
		{
			return sz1 < sz2 ? -1 : 1;
		}
		
		(0..<sz1).each {
			int i1 = WritableUtils.readVInt(din1)
			int i2 = WritableUtils.readVInt(din2)
			if ( i1 != i2)
			{
				return i1 < i2 ? -1 : 1;
			}
		}
		return 0;
	  }
	}
  
	static {                                        // register this comparator
	  WritableComparator.define(ItemSet.class, new Comparator());
	}

}
