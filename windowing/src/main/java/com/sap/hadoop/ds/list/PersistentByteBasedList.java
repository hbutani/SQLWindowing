package com.sap.hadoop.ds.list;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;

import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.Serializer;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.ds.BaseException;
import com.sap.hadoop.ds.LockUtils;

class PersistentByteBasedList extends ByteBasedList
{
	private static int headerSize() { return (Integer.SIZE + Integer.SIZE + Integer.SIZE + Long.SIZE) / Byte.SIZE;}
	protected static void store(ByteBasedList l, File f) throws IOException
	{
		/*
		 * write startOffset:bytesUsed:currentSize:lastModified
		 */
		int hdrSize = headerSize();
		ByteBuffer buf = ByteBuffer.allocate(hdrSize);
		
		buf.putInt(l.startOffset);
		buf.putInt(l.bytesUsed);
		buf.putInt(l.currentSize);
		buf.putLong(l.lastModified);
		buf.flip();
		
		/*
		 * note: could save this space by using Memory-Mapped I/O and directly writing to the MM buffer. 
		 */
		ByteBuffer offsetB = ByteBuffer.allocate((Integer.SIZE/Byte.SIZE) * 2 * l.currentSize);
		IntBuffer iB = offsetB.asIntBuffer();
		iB.put(l.offsetsArray, 0, l.currentSize * 2);
		
		ByteBuffer bytesB = ByteBuffer.wrap(l.bytes, 0, l.bytesUsed);
		
		ByteBuffer[] bufs = new ByteBuffer[] { buf, offsetB, bytesB};
		FileOutputStream fos = new FileOutputStream(f);
		try
		{
			FileChannel fc = fos.getChannel();
			while (fc.write(bufs, 0, bufs.length) > 0);
		}
		finally
		{
			fos.close();
		}
	}
	
	protected static void load(ByteBasedList l, File f) throws IOException
	{
		int hdr = headerSize();
		FileInputStream fis = new FileInputStream(f);
		try
		{
			FileChannel fc = fis.getChannel();
			ByteBuffer buf0 = ByteBuffer.allocate(hdr);
			while (buf0.hasRemaining())
				fc.read(buf0);
			buf0.flip();
			l.startOffset = buf0.getInt();
			l.bytesUsed = buf0.getInt();
			l.currentSize = buf0.getInt();
			l.lastModified = buf0.getLong();
			
			/*
			 * note: could save this space by using Memory-Mapped I/O and directly writing to the MM buffer. 
			 */
			ByteBuffer offsetB = ByteBuffer.allocate((Integer.SIZE/Byte.SIZE) * 2 * l.currentSize);
			ByteBuffer bytesB = ByteBuffer.allocate(l.bytesUsed);
			ByteBuffer[] bufs = new ByteBuffer[] { offsetB, bytesB };
			while (fc.read(bufs) > 0);
			
			l.offsetsArray = new int[l.currentSize * 2];
			offsetB.flip();
			IntBuffer iB = offsetB.asIntBuffer();
			iB.get(l.offsetsArray);
			l.bytes = bytesB.array();
		}
		finally
		{
			fis.close();
		}
	}
	
	File file;
	SoftReference<ByteBasedList> memList;
	
	protected PersistentByteBasedList(File file, ByteBasedList l)
	{
		super(file);
		this.file = file;
		memList = new SoftReference<ByteBasedList>(l);
	}
	
	protected PersistentByteBasedList(File file)
	{
		this(file, null);
	}
	
	private ByteBasedList getList() throws BaseException
	{ 
		LockUtils.lock(lock.readLock());
		try
		{
			ByteBasedList list = memList.get();
			if (list == null)
			{
				try
				{
					list = new ByteBasedList(file);
					load(list, file);
					memList = new SoftReference<ByteBasedList>(list);
				}
				catch(Exception ie)
				{
					throw new RuntimeException(ie);
				}
			}
			return list;
		}
		finally
		{
			lock.readLock().unlock();
		}
	}
	
	public int size() throws BaseException
	{
		return getList().size();
	}
	
	public void get(int i, Writable wObj) throws BaseException
	{
		getList().get(i, wObj);
	}
	
	public void append(Writable obj) throws BaseException
	{
		throw new UnsupportedOperationException("Cannot append to a Persisted List");		
	}
	
	public Object get(int i, Deserializer deserializer, Writable wObj) throws BaseException
	{
		return getList().get(i, deserializer, wObj);
	}
	
	public void append(Object obj, ObjectInspector OI, Serializer serializer) throws BaseException
	{
		throw new UnsupportedOperationException("Cannot append to a Persisted List");		
	}
	
	public Iterator<Writable> iterator(Writable wObj) throws BaseException
	{
		return getList().iterator(wObj);
	}
	
	public Iterator<Object> iterator(Deserializer deserializer, Writable wObj) throws BaseException
	{
		return getList().iterator(deserializer, wObj);
	}
	
	public void dump(StringBuilder bldr, Writable wObj) throws IOException, BaseException
	{
		getList().dump(bldr, wObj);
	}
	
	public void dump(StringBuilder bldr, Deserializer deserializer, Writable wObj) throws IOException, BaseException
	{
		getList().dump(bldr, deserializer, wObj);
	}
}
