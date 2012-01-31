package com.sap.hadoop.ds.list;

import java.io.File;
import java.util.Iterator;

import junit.framework.Assert;

import org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.hadoop.Utils;
import com.sap.hadoop.ds.BaseException;
import com.sap.hadoop.ds.list.ByteBasedList;

public class PersistentByteBasedListTest
{
	static LazySimpleSerDe sd;
	ByteBasedList bl;
	
	@BeforeClass
	public static void setupClass() throws BaseException
	{
		sd = Utils.createLazySimpleSerDe("a,b,c", "string,int,int", ",");
	}
	
	@Before
	public void setup()
	{
		bl = new ByteBasedList();
	}

	@Test
	public void test()throws Exception
	{
		for(String r : ByteBasedListTest.table)	
		{
			bl.append(new Text(r));
		}
		
		File f = File.createTempFile("wdw", null);
		f.deleteOnExit();
		
		PersistentByteBasedList.store(bl, f);
		bl = null;
		PersistentByteBasedList pl = new PersistentByteBasedList(f);
		
		Class<? extends Writable> cls = sd.getSerializedClass();
		Writable wObj = cls.newInstance();
		
		Iterator<Object> it = pl.iterator(sd, wObj);
		while(it.hasNext())
		{
			sd.serialize(it.next(), sd.getObjectInspector());
		}
		
		for(int i=0; i < ByteBasedListTest.table.length; i++)
		{
			Object o = sd.serialize(pl.get(i, sd, wObj), sd.getObjectInspector());
			Assert.assertEquals(ByteBasedListTest.table[i], o.toString());
		}
	}
	
	@Test
	public void test2() throws Exception
	{
		for(String r : ByteBasedListTest.table)	
		{
			bl.append(new Text(r));
		}
		
		Class<? extends Writable> cls = sd.getSerializedClass();
		Writable wObj = cls.newInstance();
		
		for(int i=0; i < ByteBasedListTest.table.length; i++)
		{
			Object o = bl.get(i, sd, wObj);
			bl.append(o, sd.getObjectInspector(), sd);
		}
		File f = File.createTempFile("wdw", null);
		f.deleteOnExit();
		PersistentByteBasedList.store(bl, f);
		bl = null;
		PersistentByteBasedList pl = new PersistentByteBasedList(f);
		
		for(int i=ByteBasedListTest.table.length; i < 2* ByteBasedListTest.table.length; i++)
		{
			Object o = sd.serialize(pl.get(i, sd, wObj), sd.getObjectInspector());
			Assert.assertEquals(ByteBasedListTest.table[i - ByteBasedListTest.table.length], o.toString());
		}
	}

}
