package com.sap.hadoop.ds.sortedmap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.Utils;
import com.sap.hadoop.ds.BaseException;
import com.sap.hadoop.ds.LockUtils;


public class PersistentByteBasedSortedMap extends ByteBasedSortedMap
{
	private static int headerSize() { return (Integer.SIZE + Integer.SIZE + Integer.SIZE + Long.SIZE) / Byte.SIZE;}
	protected static void store(ByteBasedSortedMap m, File f) throws IOException
	{
		/*
		 * write startOffset:bytesUsed:currentSize:lastModified
		 */
		int hdrSize = headerSize();
		ByteBuffer buf = ByteBuffer.allocate(hdrSize);
		
		buf.putInt(m.startOffset);
		buf.putInt(m.bytesUsed);
		buf.putInt(m.currentSize);
		buf.putLong(m.lastModified);
		buf.flip();
		
		/*
		 * note: could save this space by using Memory-Mapped I/O and directly writing to the MM buffer. 
		 */
		ByteBuffer keyoffsetB = ByteBuffer.allocate((Integer.SIZE/Byte.SIZE) * 2 * m.currentSize);
		IntBuffer iB = keyoffsetB.asIntBuffer();
		iB.put(m.keyOffsetsArray, 0, m.currentSize * 2);
		
		ByteBuffer valueoffsetB = ByteBuffer.allocate((Integer.SIZE/Byte.SIZE) * 2 * m.currentSize);
		IntBuffer iB2 = valueoffsetB.asIntBuffer();
		iB2.put(m.valueOffsetsArray, 0, m.currentSize * 2);
		
		ByteBuffer bytesB = ByteBuffer.wrap(m.bytes, 0, m.bytesUsed);
		
		ByteBuffer[] bufs = new ByteBuffer[] { buf, keyoffsetB, valueoffsetB, bytesB};
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
	
	protected static void load(ByteBasedSortedMap m, File f) throws IOException
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
			m.startOffset = buf0.getInt();
			m.bytesUsed = buf0.getInt();
			m.currentSize = buf0.getInt();
			m.lastModified = buf0.getLong();
			
			/*
			 * note: could save this space by using Memory-Mapped I/O and directly writing to the MM buffer. 
			 */
			ByteBuffer keyoffsetB = ByteBuffer.allocate((Integer.SIZE/Byte.SIZE) * 2 * m.currentSize);
			ByteBuffer valueoffsetB = ByteBuffer.allocate((Integer.SIZE/Byte.SIZE) * 2 * m.currentSize);
			ByteBuffer bytesB = ByteBuffer.allocate(m.bytesUsed);
			ByteBuffer[] bufs = new ByteBuffer[] { keyoffsetB, valueoffsetB, bytesB };
			while (fc.read(bufs) > 0);
			
			m.keyOffsetsArray = new int[m.currentSize * 2];
			keyoffsetB.flip();
			IntBuffer iB = keyoffsetB.asIntBuffer();
			iB.get(m.keyOffsetsArray);
			
			m.valueOffsetsArray = new int[m.currentSize * 2];
			valueoffsetB.flip();
			IntBuffer iB2 = valueoffsetB.asIntBuffer();
			iB2.get(m.valueOffsetsArray);
			
			m.bytes = bytesB.array();
		}
		finally
		{
			fis.close();
		}
	}
	
	File file;
	SoftReference<ByteBasedSortedMap> memMap;
	
	protected PersistentByteBasedSortedMap(File file, ByteBasedSortedMap m, RawComparator<?> comparator)
	{
		super(file, comparator);
		this.file = file;
		memMap = new SoftReference<ByteBasedSortedMap>(m);
	}
	
	protected PersistentByteBasedSortedMap(File file, RawComparator<?> comparator)
	{
		this(file, null, comparator);
	}

	protected ByteBasedSortedMap getMemoryMap() throws BaseException
	{ 
		LockUtils.lock(lock.readLock());
		try
		{
			ByteBasedSortedMap map = memMap.get();
			if (map == null)
			{
				try
				{
					map = new ByteBasedSortedMap(file, comparator);
					load(map, file);
					memMap = new SoftReference<ByteBasedSortedMap>(map);
				}
				catch(Exception ie)
				{
					throw new RuntimeException(ie);
				}
			}
			return map;
		}
		finally
		{
			lock.readLock().unlock();
		}
	}
	public void put(Writable key, Writable value) throws BaseException
	{
		getMemoryMap().put(key, value);
	}
	public void put(Writable key) throws BaseException
	{
		getMemoryMap().put(key);
	}
	public void getKey(int i, Writable wObj) throws BaseException
	{
		getMemoryMap().getKey(i, wObj);
	}
	public void getEntry(int i, WritableEntry entry) throws BaseException
	{
		getMemoryMap().getEntry(i, entry);
	}
	public int getIndex(Writable w) throws BaseException
	{
		return getMemoryMap().getIndex(w);
	}
	public int getValue(Writable key, Writable value) throws BaseException
	{
		return getMemoryMap().getValue(key, value);
	}
	public int size() throws BaseException
	{
		return getMemoryMap().size();
	}
	public Iterator<Writable> keyIterator(Writable wObj) throws BaseException
	{
		return getMemoryMap().keyIterator(wObj);
	}
	public void dump(StringBuilder bldr, WritableEntry wObj)
			throws IOException, BaseException
	{
		getMemoryMap().dump(bldr, wObj);
	}
	public ByteBasedSortedMap[] split() throws BaseException
	{
		return getMemoryMap().split();
	}
	protected byte[] getLastKey() throws BaseException { return getMemoryMap().getLastKey(); }
	
	public String toString()
	{
		ByteBasedSortedMap map = memMap.get();
		if ( map != null )
		{
			return map.toString();
		}
		return Utils.sprintf("(<not in memory>)");
	}
}
