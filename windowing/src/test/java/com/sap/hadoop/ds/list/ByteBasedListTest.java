package com.sap.hadoop.ds.list;

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

public class ByteBasedListTest
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
	public void test1() throws Exception
	{
		for(String r : table)	
		{
			bl.append(new Text(r));
		}
		
		Class<? extends Writable> cls = sd.getSerializedClass();
		Writable wObj = cls.newInstance();
		
		Iterator<Object> it = bl.iterator(sd, wObj);
		while(it.hasNext())
		{
			sd.serialize(it.next(), sd.getObjectInspector());
		}
		
		for(int i=0; i < table.length; i++)
		{
			Object o = sd.serialize(bl.get(i, sd, wObj), sd.getObjectInspector());
			Assert.assertEquals(table[i], o.toString());
		}
	}
	
	@Test
	public void test2() throws Exception
	{
		for(String r : table)	
		{
			bl.append(new Text(r));
		}
		
		Class<? extends Writable> cls = sd.getSerializedClass();
		Writable wObj = cls.newInstance();
		
		for(int i=0; i < table.length; i++)
		{
			Object o = bl.get(i, sd, wObj);
			bl.append(o, sd.getObjectInspector(), sd);
		}
		
		for(int i=table.length; i < 2* table.length; i++)
		{
			Object o = sd.serialize(bl.get(i, sd, wObj), sd.getObjectInspector());
			Assert.assertEquals(table[i - table.length], o.toString());
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
