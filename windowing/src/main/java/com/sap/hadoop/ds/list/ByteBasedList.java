package com.sap.hadoop.ds.list;

import java.io.File;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.Serializer;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.ds.BaseException;
import com.sap.hadoop.ds.LockUtils;
import com.sap.hadoop.ds.streams.Streams;
import com.sap.hadoop.ds.streams.Streams.ByteArrayIS;
import com.sap.hadoop.ds.streams.Streams.ByteArrayOS;
import com.sap.hadoop.ds.streams.Streams.DataIStream;
import com.sap.hadoop.ds.streams.Streams.DataOStream;
import static com.sap.hadoop.Utils.*;

public class ByteBasedList
{
	int startOffset;
	
	/*
	 * (offset,size) of Writables.
	 * entry i at position i << 1
	 * this array is resizable. 
	 */
	int[] offsetsArray;
	
	/*
	 * contains actual bytes of Writables.
	 * not resizable
	 */
	byte[] bytes;
	int bytesUsed;
	
	int currentSize;
	ReentrantReadWriteLock lock;
	long lastModified;
	
	
	public ByteBasedList(int startOffset, int capacity)
	{
		this.startOffset = startOffset;
		bytes = new byte[capacity];
		offsetsArray = new int[INCREMENT_SIZE];
		bytesUsed = 0;
		currentSize = 0;
		lock = new ReentrantReadWriteLock();
		lastModified = System.nanoTime();
	}
	
	public ByteBasedList()
	{
		this(0, MEDIAN_SIZE);
	}
	
	/*
	 * internal api; used by {@link PersistentByteBasedList} to setup BBList from a file.
	 */
	protected ByteBasedList(File file)
	{
		lock = new ReentrantReadWriteLock();
	}
	
	private void ensureCapacity(int wlen) throws ListFullException
	{
		if ( bytesUsed + wlen > bytes.length)
		{
			throw new ListFullException();
		}
		
		if (offsetsArray.length == 2 * currentSize)
		{
			int[] na = new int[currentSize + INCREMENT_SIZE];
			System.arraycopy(offsetsArray, 0, na, 0, offsetsArray.length);
			offsetsArray = na;
		}
	}
	
	private int index(int i) throws BaseException
	{
		int j = i - startOffset;
		j = j << 1;
		if ( i > currentSize )
		{
			throw new BaseException(sprintf("index invalid %i", i));
		}
		return j;
	}
	
	private void write(Writable w) throws BaseException, IOException
	{
		DataOStream dos = Streams.dos.get();
		ByteArrayOS bos = dos.getUnderlyingStream();
		bos.reset();
		w.write(dos);
		ensureCapacity(bos.len());
		int i = currentSize * 2;
		System.arraycopy(bos.bytearray(), 0, bytes, bytesUsed, bos.len());
		offsetsArray[i] = bytesUsed;
		offsetsArray[i+1] = bos.len();
		currentSize += 1;
		bytesUsed += bos.len();
		lastModified = System.nanoTime();
	}
	
	
	public int size() throws BaseException
	{
		LockUtils.lock(lock.readLock());
		try
		{
			return currentSize;
		}
		finally
		{
			lock.readLock().unlock();
		}
	}
	
	public void get(int i, Writable wObj) throws BaseException
	{
		LockUtils.lock(lock.readLock());
		try
		{
			i = index(i);
			DataIStream dis = Streams.dis.get();
			ByteArrayIS bis = dis.getUnderlyingStream();
			bis.setBuffer(bytes, offsetsArray[i], offsetsArray[i+1]);
			wObj.readFields(dis);
		}
		catch(IOException ie)
		{
			throw new BaseException(ie);
		}
		finally
		{
			lock.readLock().unlock();
		}
	}
	
	public void append(Writable obj) throws BaseException
	{
		LockUtils.lock(lock.writeLock());
		try
		{
			write(obj);
		}
		catch(IOException ie)
		{
			throw new BaseException(ie);
		}
		finally
		{
			lock.writeLock().unlock();
		}
		
	}
	
	public Object get(int i, Deserializer deserializer, Writable wObj) throws BaseException
	{
		try
		{
			get(i, wObj);
			return deserializer.deserialize(wObj);
		}
		catch(SerDeException ie)
		{
			throw new BaseException(ie);
		}
	}
	
	public void append(Object obj, ObjectInspector OI, Serializer serializer) throws BaseException
	{
		try
		{
			append(serializer.serialize(obj, OI));
		}
		catch(SerDeException ie)
		{
			throw new BaseException(ie);
		}
	}
	
	public Iterator<Writable> iterator(Writable wObj) throws BaseException
	{
		return new WIterator(wObj); 
	}
	
	public Iterator<Object> iterator(Deserializer deserializer, Writable wObj)  throws BaseException
	{
		return new OIterator(deserializer, wObj); 
	}
	
	public void dump(StringBuilder bldr, Writable wObj) throws IOException, BaseException
	{
		bldr.append("[");
		Iterator<Writable> wi = iterator(wObj);
		while(wi.hasNext())
		{
			wObj = wi.next();
			bldr.append(wObj).append(", ");
		}
		bldr.append("]\n");
	}
	
	public void dump(StringBuilder bldr, Deserializer deserializer, Writable wObj) throws IOException, BaseException
	{
		bldr.append("[");
		Iterator<Object> oi = iterator(deserializer, wObj);
		while(oi.hasNext())
		{
			bldr.append(oi.next()).append(", ");
		}
		bldr.append("]\n");
	}
	
	class WIterator implements Iterator<Writable>
	{
		Writable wObj;
		long checkTime;
		int i;
		
		WIterator(Writable wObj)
		{
			this.wObj = wObj;
			checkTime = lastModified;
			i = 0;
		}

		@Override
		public boolean hasNext()
		{
			return i < currentSize;
		}

		@Override
		public Writable next()
		{
			 if (checkTime != lastModified)
	                throw new ConcurrentModificationException();
			 try
			 {
				 get(i++, wObj);
				 return wObj;
			 }
			 catch(BaseException be)
			 {
				 throw new RuntimeException(be);
			 }
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	class OIterator implements Iterator<Object>
	{
		Deserializer deserializer;
		Iterator<Writable> wi;
		
		OIterator(Deserializer deserializer, Writable wObj) throws BaseException
		{
			wi = iterator(wObj);
			this.deserializer = deserializer;
		}
		
		@Override
		public boolean hasNext()
		{
			return wi.hasNext();
		}

		@Override
		public Object next()
		{
			Writable wObj = wi.next();
			try
			{
				return deserializer.deserialize(wObj);
			}catch(SerDeException se)
			 {
				 throw new RuntimeException(se);
			 }
		}
		
		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	public static class ListFullException extends BaseException
	{
		private static final long serialVersionUID = 4745303310812778989L;

		public ListFullException()
		{
			super();
		}

		public ListFullException(String message, Throwable cause)
		{
			super(message, cause);
		}

		public ListFullException(String message)
		{
			super(message);
		}

		public ListFullException(Throwable cause)
		{
			super(cause);
		}
		
	}
	
	private static final int INCREMENT_SIZE = (int) Math.pow(2, 16); 
	
	@SuppressWarnings("unused")
	private static final int SMALL_SIZE =  (int) Math.pow(2, 6 +10);           // 64KB
	private static final int MEDIAN_SIZE = (int) Math.pow(2, (10 + 10));            // 1 MB
	@SuppressWarnings("unused")
	private static final int LARGE_SIZE = (int) Math.pow(2, (6 + 10 + 10));         // 64 MB

}
