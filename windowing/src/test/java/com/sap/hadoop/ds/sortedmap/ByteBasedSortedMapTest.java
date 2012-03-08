package com.sap.hadoop.ds.sortedmap;

import java.util.Arrays;
import java.util.Iterator;
import junit.framework.Assert;
import org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.VIntWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.hadoop.Utils;
import com.sap.hadoop.ds.BaseException;

public class ByteBasedSortedMapTest
{
	static LazySimpleSerDe sd;
	ByteBasedSortedMap bm;
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
		bm = new ByteBasedSortedMap(WritableComparator.get(Text.class));
		cls = sd.getSerializedClass();
		wObj = cls.newInstance();
		value = new VIntWritable();
		wEntry = new ByteBasedSortedMap.WritableEntry(wObj, value);
		bldr = new StringBuilder();
	}

	@Test
	public void testGeti() throws Exception
	{
		int i = 0;
		for(i = table.length - 1; i >= 0; i--)	
		{
			bm.put(new Text(table[i]), new VIntWritable(i));
		}
		Assert.assertEquals(table.length, bm.size());
//		bldr.setLength(0);
//		bm.dump(bldr, wEntry);
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
	
	static final String[] table = new String[] {
		"Manufacturer#1,2,2",
		"Manufacturer#1,2,34",
		"Manufacturer#1,34,6",
		"Manufacturer#1,6,28",
		"Manufacturer#1,28,42",
		"Manufacturer#1,42,42",
		"Manufacturer#2,14,40",
		"Manufacturer#2,40,2",
		"Manufacturer#2,2,25",
		"Manufacturer#2,25,18",
		"Manufacturer#2,18,18",
		"Manufacturer#3,17,14",
		"Manufacturer#3,14,19",
		"Manufacturer#3,19,1",
		"Manufacturer#3,1,45",
		"Manufacturer#3,45,45",
		"Manufacturer#4,10,39",
		"Manufacturer#4,39,27",
		"Manufacturer#4,27,7",
		"Manufacturer#4,7,12",
		"Manufacturer#4,12,12",
		"Manufacturer#5,31,6",
		"Manufacturer#5,6,2",
		"Manufacturer#5,2,46",
		"Manufacturer#5,46,23",
		"Manufacturer#5,23,23"
	};

}
