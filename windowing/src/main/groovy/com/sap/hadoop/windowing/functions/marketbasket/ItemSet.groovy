package com.sap.hadoop.windowing.functions.marketbasket

import java.awt.ItemSelectable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.io.WritableUtils;

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

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
		if ( !itemIds || itemIds.length < sz)
		{
			itemIds = new int[sz]
		}
		(0..<sz).each { i ->
			itemIds[i] = WritableUtils.readVInt(din)
		}
	}
	
	public void writeJson(JsonBuilder json, Text t)
	{
		json( { "items" itemIds 
			"sz" sz
		})
		t.set(json.toString())
	}
	
	public void readJson(JsonSlurper json, Text t)
	{
		def o = json.parseText(t.toString())
		sz = (byte) o.sz
		if ( !itemIds || itemIds.length < sz)
		{
			itemids = new int[sz]
		}
		(0..<itemIds.length).each { i -> itemIds[i] = o.items[i] }
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
		int i1, i2
		for(int i=0; i < sz1; i++)
		{
			i1 = WritableUtils.readVInt(din1)
			i2 = WritableUtils.readVInt(din2)
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
