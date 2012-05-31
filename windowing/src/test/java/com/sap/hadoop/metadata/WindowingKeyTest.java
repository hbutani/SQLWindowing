package com.sap.hadoop.metadata;

import java.util.ArrayList;
import java.util.Collections;

import junit.framework.Assert;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe;
import org.apache.hadoop.io.Text;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.hadoop.Utils;
import com.sap.hadoop.ds.list.ByteBasedList;
import com.sap.hadoop.windowing.Constants;

public class WindowingKeyTest
{
	static LazySimpleSerDe sd;
	static WindowingKeySerializer wkS;
	ByteBasedList bl;
	
	@BeforeClass
	public static void setupClass() throws Exception
	{
		sd = Utils.createLazySimpleSerDe("a,b,c", "string,int,int", ",");
		wkS = new WindowingKeySerializer();
		
		Configuration cfg = new Configuration();
		cfg.set(Constants.WINDOWING_SORT_COLS, "a,b,c");
		cfg.set(Constants.WINDOWING_SORT_COLS_ORDER, "ASC,ASC,ASC");
		cfg.setInt(Constants.WINDOWING_NUM_PARTION_COLUMNS, 1);
		wkS.initialize(cfg, null);
	}
	
	@Before
	public void setup()
	{
		bl = new ByteBasedList();
	}

	@Test
	public void test1() throws Exception
	{
		Text t = new Text();
		ArrayList<WKeyTestStruct> wl = new ArrayList<WKeyTestStruct>();
		for(String r : table)	
		{
			t.set(r);
			Object o = sd.deserialize(t);
			WindowingKey wKey = (WindowingKey) wkS.serialize(o, sd.getObjectInspector());
			bl.append(wKey);
		}
		
		for(int i=0; i < bl.size(); i++)
		{
			WindowingKey wKey = new WindowingKey();
			bl.get(i, wKey);
			wl.add(new WKeyTestStruct(wKey, table[i]));
		}
		
		Collections.sort(wl);
		StringBuilder b = new StringBuilder();
		for(WKeyTestStruct wStruct : wl)
		{
			b.append(wStruct).append("\n");

		}
		String check = "Manufacturer#1,2,2\n" +
				"Manufacturer#1,2,34\n" +
				"Manufacturer#1,6,28\n" +
				"Manufacturer#1,28,42\n" +
				"Manufacturer#1,34,6\n" +
				"Manufacturer#1,42,42\n" +
				"Manufacturer#2,2,25\n" +
				"Manufacturer#2,14,40\n" +
				"Manufacturer#2,18,18\n" +
				"Manufacturer#2,25,18\n" +
				"Manufacturer#2,40,2\n" +
				"Manufacturer#3,1,45\n" +
				"Manufacturer#3,14,19\n" +
				"Manufacturer#3,17,14\n" +
				"Manufacturer#3,19,1\n" +
				"Manufacturer#3,45,45\n" +
				"Manufacturer#4,7,12\n" +
				"Manufacturer#4,10,39\n" +
				"Manufacturer#4,12,12\n" +
				"Manufacturer#4,27,7\n" +
				"Manufacturer#4,39,27\n" +
				"Manufacturer#5,2,46\n" +
				"Manufacturer#5,6,2\n" +
				"Manufacturer#5,23,23\n" +
				"Manufacturer#5,31,6\n" +
				"Manufacturer#5,46,23\n";
		Assert.assertEquals(b.toString(), check);
	}
	
	@Test
	public void test2() throws Exception
	{
		Text t = new Text();
		ArrayList<WKeyTestStruct2> wl = new ArrayList<WKeyTestStruct2>();
		for(String r : table)	
		{
			t.set(r);
			Object o = sd.deserialize(t);
			WindowingKey wKey = (WindowingKey) wkS.serialize(o, sd.getObjectInspector());
			bl.append(wKey);
		}
		
		for(int i=0; i < bl.size(); i++)
		{
			WindowingKey wKey = new WindowingKey();
			bl.get(i, wKey);
			wl.add(new WKeyTestStruct2(wKey, table[i]));
		}
		
		Collections.sort(wl);
		StringBuilder b = new StringBuilder();
		for(WKeyTestStruct wStruct : wl)
		{
			b.append(wStruct).append("\n");
			System.out.println(wStruct);
		}
		
		String check = "Manufacturer#1,2,2\n" +
				"Manufacturer#1,2,34\n" +
				"Manufacturer#1,34,6\n" +
				"Manufacturer#1,6,28\n" +
				"Manufacturer#1,28,42\n" +
				"Manufacturer#1,42,42\n" +
				"Manufacturer#2,14,40\n" +
				"Manufacturer#2,40,2\n" +
				"Manufacturer#2,2,25\n" +
				"Manufacturer#2,25,18\n" +
				"Manufacturer#2,18,18\n" +
				"Manufacturer#3,17,14\n" +
				"Manufacturer#3,14,19\n" +
				"Manufacturer#3,19,1\n" +
				"Manufacturer#3,1,45\n" +
				"Manufacturer#3,45,45\n" +
				"Manufacturer#4,10,39\n" +
				"Manufacturer#4,39,27\n" +
				"Manufacturer#4,27,7\n" +
				"Manufacturer#4,7,12\n" +
				"Manufacturer#4,12,12\n" +
				"Manufacturer#5,31,6\n" +
				"Manufacturer#5,6,2\n" +
				"Manufacturer#5,2,46\n" +
				"Manufacturer#5,46,23\n" +
				"Manufacturer#5,23,23\n";
		Assert.assertEquals(b.toString(), check);
	}
	
	static class WKeyTestStruct implements Comparable<WKeyTestStruct>
	{
		static OutputKeyComparator kC = new OutputKeyComparator();
		WindowingKey wKey;
		String s;
		
		WKeyTestStruct(WindowingKey wKey, String s)
		{
			this.wKey = wKey;
			this.s = s;
		}
		
		public String toString()
		{
			return s;
		}


		@Override
		public int compareTo(WKeyTestStruct o)
		{
			return kC.compare(wKey, o.wKey);
		}
	}
	
	static class WKeyTestStruct2 extends WKeyTestStruct
	{
		static OutputGroupingComparator kC = new OutputGroupingComparator();
		
		WKeyTestStruct2(WindowingKey wKey, String s)
		{
			super(wKey, s);
		}
		
		@Override
		public int compareTo(WKeyTestStruct o)
		{
			return kC.compare(wKey, o.wKey);
		}
	}
	

	static final String[] table = new String[] {
		"Manufacturer#1,2,2",
		"Manufacturer#1,2,34",
		"Manufacturer#1,34,6",
		"Manufacturer#1,6,28",
		"Manufacturer#1,28,42",
		"Manufacturer#1,42,42",
		"Manufacturer#4,10,39",
		"Manufacturer#4,39,27",
		"Manufacturer#4,27,7",
		"Manufacturer#4,7,12",
		"Manufacturer#4,12,12",
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
		"Manufacturer#5,31,6",
		"Manufacturer#5,6,2",
		"Manufacturer#5,2,46",
		"Manufacturer#5,46,23",
		"Manufacturer#5,23,23"
	};
}
