package com.sap.hadoop.ds.sortedmap;

import java.io.File;
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
import static com.sap.hadoop.ds.sortedmap.ByteBasedSortedMapTest.*;

public class PersistentByteBasedSortedMapTest
{
	static LazySimpleSerDe sd;
	RawComparator<?> comparator;
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
		comparator = WritableComparator.get(Text.class);
		bm = new ByteBasedSortedMap(comparator);
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
		
		File f = File.createTempFile("wdw", null);
		f.deleteOnExit();
		
		PersistentByteBasedSortedMap.store(bm, f);
		bm = null;
		PersistentByteBasedSortedMap pm = new PersistentByteBasedSortedMap(f, comparator);
		
		Assert.assertEquals(table.length, pm.size());
//		bldr.setLength(0);
//		pm.dump(bldr, wEntry);
//		System.out.println(bldr);
				
		for(i=0; i < table.length; i++)
		{
			pm.getKey(i, wObj);
			Assert.assertEquals(table[i], wObj.toString());
			pm.getValue(wObj, value);
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
		
		File f = File.createTempFile("wdw", null);
		f.deleteOnExit();
		
		PersistentByteBasedSortedMap.store(bm, f);
		bm = null;
		PersistentByteBasedSortedMap pm = new PersistentByteBasedSortedMap(f, comparator);		
		Assert.assertEquals(table.length, pm.size());
		
		Iterator<Writable> it = pm.keyIterator(wObj);
		i=0;
		while(it.hasNext())
		{
			Writable we = it.next();
			Assert.assertEquals(table[i], we.toString());
			pm.getValue(we, value);
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
		File f = File.createTempFile("wdw", null);
		f.deleteOnExit();
		
		PersistentByteBasedSortedMap.store(bm, f);
		bm = null;
		PersistentByteBasedSortedMap pm = new PersistentByteBasedSortedMap(f, comparator);		
		Assert.assertEquals(table.length, pm.size());
		
		Iterator<ByteBasedSortedMap.WritableEntry> it = pm.entryIterator(wEntry);
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
	public void testRandomPut() throws Exception
	{
		int i = 0;
		for(i = 0; i < table.length; i++)	
		{
			int j = (i + 13) % table.length;
			bm.put(new Text(table[j]), new VIntWritable(j));
		}
		File f = File.createTempFile("wdw", null);
		f.deleteOnExit();
		
		PersistentByteBasedSortedMap.store(bm, f);
		bm = null;
		PersistentByteBasedSortedMap pm = new PersistentByteBasedSortedMap(f, comparator);		
		Assert.assertEquals(table.length, pm.size());
		for(i=0; i < table.length; i++)
		{
			pm.getKey(i, wObj);
			Assert.assertEquals(table[i], wObj.toString());
			pm.getValue(wObj, value);
			Assert.assertEquals(value.get(), i);
		}
	}
}
