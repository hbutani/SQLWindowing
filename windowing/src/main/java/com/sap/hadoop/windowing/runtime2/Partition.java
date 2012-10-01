package com.sap.hadoop.windowing.runtime2;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.ds.list.ByteBasedList;
import com.sap.hadoop.ds.list.ListFactory;
import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.WindowingException;

/*
 * represents a collection of rows that is acted upon by a TableFunction or a WindowFunction. 
 */
public class Partition
{
	SerDe serDe;
	StructObjectInspector OI;
	private ByteBasedList elems;
	private Writable wRow;
	private int sz;
	
	public Partition(HiveConf cfg, SerDe serDe, StructObjectInspector oI) throws WindowingException
	{
		String partitionClass = cfg.get(Constants.WINDOW_PARTITION_CLASS, Constants.DEFAULT_WINDOW_PARTITION_CLASS);
		int partitionMemSize = cfg.getInt(Constants.WINDOW_PARTITION_MEM_SIZE, ByteBasedList.LARGE_SIZE);
		init(partitionClass, partitionMemSize, serDe, oI);
	}
	
	public Partition(String partitionClass, int partitionMemSize, SerDe serDe, StructObjectInspector oI) throws WindowingException
	{
		init(partitionClass, partitionMemSize, serDe, oI);
	}
	
	private void init(String partitionClass, int partitionMemSize, SerDe serDe, StructObjectInspector oI) throws WindowingException
	{
		this.serDe = serDe;
		OI = oI;
		elems = ListFactory.createList(partitionClass, partitionMemSize);
		sz = 0;
		wRow = createWritable();
	}
	
	public SerDe getSerDe()
	{
		return serDe;
	}
	public void setSerDe(SerDe serDe)
	{
		this.serDe = serDe;
	}
	public StructObjectInspector getOI()
	{
		return OI;
	}
	public void setOI(StructObjectInspector oI)
	{
		OI = oI;
	}
	
	private Writable createWritable() throws WindowingException 
	{
		try
		{
			return serDe.getSerializedClass().newInstance();
		}
		catch(Throwable t)
		{
			throw new WindowingException(t);
		}
	}
	
	public Object getAt(int i) throws WindowingException 
	{
		try
		{
			elems.get(i, wRow);
			Object o = serDe.deserialize(wRow);
			return o;
		}
		catch(Exception  se)
		{
			throw new WindowingException(se);
		}
	}
	
	public Object getWritableAt(int i) throws WindowingException 
	{
		try
		{
			elems.get(i, wRow);
			return wRow;
		}
		catch(Exception  se)
		{
			throw new WindowingException(se);
		}
	}
	
	public void append(Writable o) throws WindowingException 
	{
		try
		{
			elems.append(o);
			sz++;
		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
	}
	
	public void append(Object o) throws WindowingException 
	{
		try
		{
			append(serDe.serialize(o, OI));
		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
	}
	
	public int size()
	{ 
		return sz;
	}
	
	public PartitionIterator<Object> iterator()
	{
		return new PItr(0, size());
	}
	
	public PartitionIterator<Object> range(int start, int end)
	{
		assert(start >= 0);
		assert(end < size());
		assert(start <= end);
		return new PItr(start, end);
	}
	
	class PItr implements PartitionIterator<Object>
	{
		int idx;
		int start;
		int end;
		int createTimeSz;
		
		PItr(int start, int end)
		{
			this.idx = start;
			this.start = start;
			this.end = end;
			createTimeSz = Partition.this.size();
		}
		
		public boolean hasNext() 
		{
			checkForComodification() ;
			return idx < end;
		}
		
		public Object next() 
		{ 
			checkForComodification();
			try
			{
				return Partition.this.getAt(idx++);
			}
			catch(WindowingException e)
			{
				throw new RuntimeException(e);
			}
		}
		
		public void remove() 
		{ 
			throw new UnsupportedOperationException();
		}
		
		final void checkForComodification() 
		{
		    if (createTimeSz != Partition.this.size())
			throw new ConcurrentModificationException();
		}

		@Override
		public int getIndex()
		{
			return idx;
		}
		
		private Object getAt(int i)
		{
			try
			{
				return Partition.this.getAt(idx++);
			}
			catch(WindowingException e)
			{
				throw new RuntimeException(e);
			}
		}

		@Override
		public Object lead(int amt)
		{
			int i = idx + amt;
			i = i >= end ? end - 1 : i;
			return getAt(i);
		}

		@Override
		public Object lag(int amt)
		{
			int i = idx - amt;
			i = i < start ? start : i;
			return getAt(i);
		}

		@Override
		public void resetToIndex()
		{
			getAt(idx);
		}
	};
	
}
