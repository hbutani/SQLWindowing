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
public class Partition implements Iterable<Object>
{
	SerDe serDe;
	StructObjectInspector OI;
	private ByteBasedList elems;
	private Writable wRow;
	private int sz;
	
	public Partition(HiveConf cfg, SerDe serDe, StructObjectInspector oI) throws WindowingException
	{
		this.serDe = serDe;
		OI = oI;
		String partitionClass = cfg.get(Constants.WINDOW_PARTITION_CLASS, Constants.DEFAULT_WINDOW_PARTITION_CLASS);
		int partitionMemSize = cfg.getInt(Constants.WINDOW_PARTITION_MEM_SIZE, ByteBasedList.LARGE_SIZE);
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
	
	public int size()
	{ 
		return sz;
	}
	
	@Override
	public Iterator<Object> iterator()
	{
		return new PItr(0, size());
	}
	
	public Iterator<Object> range(int start, int end)
	{
		assert(start >= 0);
		assert(end < size());
		assert(start <= end);
		return new PItr(start, end);
	}
	
	class PItr implements Iterator<Object>
	{
		int idx;
		int end;
		int createTimeSz;
		
		PItr(int start, int end)
		{
			this.idx = start;
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
	};
	
}
