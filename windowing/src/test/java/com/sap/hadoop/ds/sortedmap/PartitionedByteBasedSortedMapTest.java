package com.sap.hadoop.ds.sortedmap;

import static com.sap.hadoop.ds.sortedmap.ByteBasedSortedMapTest.table;

import java.util.Arrays;
import java.util.Iterator;

import junit.framework.Assert;

import org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe;
import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.VIntWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.hadoop.Utils;
import com.sap.hadoop.ds.BaseException;


public class PartitionedByteBasedSortedMapTest
{
	static LazySimpleSerDe sd;
	RawComparator<?> comparator;
	PartitionedByteBasedSortedMap bm;
	Class<? extends Writable> cls;
	Writable wObj;
	VIntWritable value;
	ByteBasedSortedMap.WritableEntry wEntry;
	StringBuilder bldr;

	
	@BeforeClass
	public static void setupClass() throws BaseException
	{
		Arrays.sort(table);
		sd = Utils.createLazySimpleSerDe("a,b,c", "string,int,int", ",");
	}
	
	@Before
	public void setup() throws Exception
	{
		comparator = WritableComparator.get(Text.class);
		bm = new PartitionedByteBasedSortedMap(100, comparator);
		cls = sd.getSerializedClass();
		wObj = cls.newInstance();
		value = new VIntWritable();
		wEntry = new ByteBasedSortedMap.WritableEntry(wObj, value);
		bldr = new StringBuilder();
	}

	@Test
	public void testGeti()throws Exception
	{
		int i = 0;
		for(i = table.length - 1; i >= 0; i--)	
		{
			bm.put(new Text(table[i]), new VIntWritable(i));
		}
		
		
		Assert.assertEquals(table.length, bm.size());
//		bldr.setLength(0);
//		pm.dump(bldr, wEntry);
//		System.out.println(bldr);
				
		for(i=0; i < table.length; i++)
		{
			bm.getKey(i, wObj);
			Assert.assertEquals(table[i], wObj.toString());
			bm.getValue(wObj, value);
			Assert.assertEquals(value.get(), i);
		}
	}
	
	@Test
	public void testGeti2()throws Exception
	{
		bm = new PartitionedByteBasedSortedMap(25, comparator);
		testGeti();
	}
	
	@Test
	public void testKeyItr() throws Exception
	{
		int i = 0;
		for(i = table.length - 1; i >= 0; i--)	
		{
			bm.put(new Text(table[i]), new VIntWritable(i));
		}
		Assert.assertEquals(table.length, bm.size());
		
		Iterator<Writable> it = bm.keyIterator(wObj);
		i=0;
		while(it.hasNext())
		{
			Writable we = it.next();
			Assert.assertEquals(table[i], we.toString());
			bm.getValue(we, value);
			Assert.assertEquals(value.get(), i);
			i++;
		}
	}
	
	@Test
	public void testKeyItr2() throws Exception
	{
		bm = new PartitionedByteBasedSortedMap(25, comparator);
		testKeyItr();
	}
	
	@Test
	public void testEntryItr() throws Exception
	{
		int i = 0;
		for(i = table.length - 1; i >= 0; i--)	
		{
			bm.put(new Text(table[i]), new VIntWritable(i));
		}
		Assert.assertEquals(table.length, bm.size());
		
		Iterator<ByteBasedSortedMap.WritableEntry> it = bm.entryIterator(wEntry);
		i=0;
		while(it.hasNext())
		{
			ByteBasedSortedMap.WritableEntry e = it.next();
			Assert.assertEquals(table[i], e.getKey().toString());
			Assert.assertEquals(((VIntWritable)e.getValue()).get(), i);
			i++;
		}
	}
	
	@Test
	public void testMultiplePut() throws Exception
	{
		int i = 0;
		for(i = table.length - 1; i >= 0; i--)	
		{
			bm.put(new Text(table[i]), new VIntWritable(i));
		}
		for(i = table.length - 1; i >= 0; i--)	
		{
			bm.put(new Text(table[i]), new VIntWritable(i));
		}
		Assert.assertEquals(table.length, bm.size());
		for(i=0; i < table.length; i++)
		{
			bm.getKey(i, wObj);
			Assert.assertEquals(table[i], wObj.toString());
			bm.getValue(wObj, value);
			Assert.assertEquals(value.get(), i);
		}
	}
	
	@Test
	public void testRandomPut() throws Exception
	{
		int i = 0;
		for(i = 0; i < table.length; i++)	
		{
			int j = (i + 13) % table.length;
			bm.put(new Text(table[j]), new VIntWritable(j));
		}
		Assert.assertEquals(table.length, bm.size());
		for(i=0; i < table.length; i++)
		{
			bm.getKey(i, wObj);
			Assert.assertEquals(table[i], wObj.toString());
			bm.getValue(wObj, value);
			Assert.assertEquals(value.get(), i);
		}
	}
}
