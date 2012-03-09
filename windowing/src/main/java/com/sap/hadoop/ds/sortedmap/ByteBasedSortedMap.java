package com.sap.hadoop.ds.sortedmap;

import static com.sap.hadoop.Utils.sprintf;

import java.io.File;
import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.Utils;
import com.sap.hadoop.ds.BaseException;
import com.sap.hadoop.ds.LockUtils;
import com.sap.hadoop.ds.streams.Streams;
import com.sap.hadoop.ds.streams.Streams.ByteArrayIS;
import com.sap.hadoop.ds.streams.Streams.ByteArrayOS;
import com.sap.hadoop.ds.streams.Streams.DataIStream;
import com.sap.hadoop.ds.streams.Streams.DataOStream;

public class ByteBasedSortedMap
{

	RawComparator<?> comparator;
	int startOffset;
	
	/*
	 * (offset,size) of Writables.
	 * entry i at position i << 1
	 * this array is resizable. 
	 */
	int[] keyOffsetsArray;
	
	// similar structure as keyOffsetsArray, but for values.
	int[] valueOffsetsArray;
	
	/*
	 * contains actual bytes of Writables.
	 * not resizable
	 */
	byte[] bytes;
	int bytesUsed;
	
	int currentSize;
	ReentrantReadWriteLock lock;
	volatile long lastModified;
	
	public ByteBasedSortedMap(int startOffset, int capacity, RawComparator<?> comparator)
	{
		this.startOffset = startOffset;
		bytes = new byte[capacity];
		keyOffsetsArray = new int[INCREMENT_SIZE];
		valueOffsetsArray = new int[INCREMENT_SIZE];
		bytesUsed = 0;
		currentSize = 0;
		lock = new ReentrantReadWriteLock();
		lastModified = System.nanoTime();
		this.comparator = comparator;
	}
	
	public ByteBasedSortedMap(RawComparator<?> comparator)
	{
		this(0, MEDIUM_SIZE, comparator);
	}
	
	public ByteBasedSortedMap(int capacity, RawComparator<?> comparator)
	{
		this(0, capacity, comparator);
	}
	
	/*
	 * internal api; used by {@link PersistentByteBasedMap} to setup BBMap from a file.
	 */
	protected ByteBasedSortedMap(File file, RawComparator<?> comparator)
	{
		lock = new ReentrantReadWriteLock();
		this.comparator = comparator;
	}
	
	private void ensureCapacity(int wlen, boolean offsetArrays) throws BaseException
	{
		if ( bytesUsed + wlen > bytes.length)
		{
			if (currentSize == 0 )
				throw new MapToSmallException();
			throw new MapFullException();
		}
		
		if (offsetArrays)
		{
			if ( (2 * currentSize + 1) > keyOffsetsArray.length )
			{
				int[] na = new int[keyOffsetsArray.length + INCREMENT_SIZE];
				System.arraycopy(keyOffsetsArray, 0, na, 0, keyOffsetsArray.length);
				keyOffsetsArray = na;
				
				na = new int[valueOffsetsArray.length + INCREMENT_SIZE];
				System.arraycopy(valueOffsetsArray, 0, na, 0, valueOffsetsArray.length);
				valueOffsetsArray = na;
			}
		}
	}
	
	public final int[] position(Comparable<EntryPosition> value)
	{
		
		int start = 0;
		int end = currentSize - 1;
		EntryPosition midVal = new EntryPosition(-1);
		
		while(start <= end )
		{
			int mid = (start + end) >>> 1;
			midVal.idx = mid;
			int c = value.compareTo(midVal);
			if (c > 0)
				start = mid + 1;
			else if (c < 0)
				end = mid - 1;
			else
			{
				return new int[] {1, mid};
			}
		}
		
		return new int[] {0, start};
	}
	
	private void rearrange(int[] offsetsArray, int pos)
	{
		int i = currentSize * 2;
		int eoffset = offsetsArray[i];
		int esz = offsetsArray[i+1];
		
		System.arraycopy(offsetsArray, pos * 2, offsetsArray, (pos+1) * 2, (currentSize - pos) * 2);
		offsetsArray[pos*2] = eoffset;
		offsetsArray[pos*2 + 1] = esz;
	}
	
	/*
	 * add the ith entry from the src Map to this map
	 */
	private void add(ByteBasedSortedMap src, int i)
	{
		i = i * 2;
		int keyOffset = src.keyOffsetsArray[i];
		int keySz = src.keyOffsetsArray[i+1];
		int valueOffset = src.valueOffsetsArray[i];
		int valueSz = src.valueOffsetsArray[i+1];
		
		int j = currentSize * 2;
		keyOffsetsArray[j] = bytesUsed;
		keyOffsetsArray[j+1] = keySz;
		System.arraycopy(src.bytes, keyOffset, bytes, bytesUsed, keySz);
		bytesUsed += keySz;
		
		valueOffsetsArray[j] = bytesUsed;
		valueOffsetsArray[j+1] = valueSz;
		System.arraycopy(src.bytes, valueOffset, bytes, bytesUsed, valueSz);
		bytesUsed += valueSz;
		
		currentSize += 1;
	}
	
	private int writeKey(Writable w) throws BaseException, IOException
	{
		DataOStream dos = Streams.dos.get();
		ByteArrayOS bos = dos.getUnderlyingStream();
		bos.reset();
		w.write(dos);
		ensureCapacity(bos.len(), true);
		int i = currentSize * 2;
		System.arraycopy(bos.bytearray(), 0, bytes, bytesUsed, bos.len());
		keyOffsetsArray[i] = bytesUsed;
		keyOffsetsArray[i+1] = bos.len();
		
		int[] posRet = position(new EntryPosition(currentSize));
		int pos = posRet[1];
		if ( posRet[0] == 0 )
		{
			rearrange(keyOffsetsArray, pos);
			rearrange(valueOffsetsArray, pos);
			currentSize += 1;
			bytesUsed += bos.len();
			lastModified = System.nanoTime();
		}
		return pos;
	}
	
	private void writeValue(Writable w, int pos) throws BaseException, IOException
	{
		int i = pos * 2;
		if ( w == null )
		{
			valueOffsetsArray[i] = 0;
			valueOffsetsArray[i+1] = 0;
			return;
		}
		DataOStream dos = Streams.dos.get();
		ByteArrayOS bos = dos.getUnderlyingStream();
		bos.reset();
		w.write(dos);
		ensureCapacity(bos.len(), false);
		System.arraycopy(bos.bytearray(), 0, bytes, bytesUsed, bos.len());
		valueOffsetsArray[i] = bytesUsed;
		valueOffsetsArray[i+1] = bos.len();
		bytesUsed += bos.len();
	}
	
	protected ByteBasedSortedMap getMemoryMap() throws BaseException { return this; }
	
	public void put(Writable key, Writable value) throws BaseException
	{
		LockUtils.lock(lock.writeLock());
		try
		{
			int pos = writeKey(key);
			writeValue(value, pos);
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
	
	public void put(Writable key) throws BaseException
	{
		put(key, null);
	}
	
	public void getKey(int i, Writable wObj) throws BaseException
	{
		LockUtils.lock(lock.readLock());
		try
		{
			i = index(i);
			DataIStream dis = Streams.dis.get();
			ByteArrayIS bis = dis.getUnderlyingStream();
			bis.setBuffer(bytes, keyOffsetsArray[i], keyOffsetsArray[i+1]);
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
	
	protected byte[] getLastKey() throws BaseException
	{
		int i = currentSize - 1;
		
		int offset = keyOffsetsArray[i * 2];
		int sz = keyOffsetsArray[i * 2 + 1];
		byte[] b = new byte[sz];
		System.arraycopy(bytes, offset, b, 0, sz);
		return b;
	}
	
	public void getEntry(int i, WritableEntry entry) throws BaseException
	{
		LockUtils.lock(lock.readLock());
		try
		{
			i = index(i);
			DataIStream dis = Streams.dis.get();
			ByteArrayIS bis = dis.getUnderlyingStream();
			bis.setBuffer(bytes, keyOffsetsArray[i], keyOffsetsArray[i+1]);
			entry.key.readFields(dis);
			bis.setBuffer(bytes, valueOffsetsArray[i], valueOffsetsArray[i+1]);
			entry.value.readFields(dis);
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
	
	public int getIndex(Writable w) throws BaseException
	{
		LockUtils.lock(lock.readLock());
		try
		{
			DataOStream dos = Streams.dos.get();
			ByteArrayOS bos = dos.getUnderlyingStream();
			bos.reset();
			w.write(dos);
			TempEntryPosition te = new TempEntryPosition(bos.bytearray(), bos.len());
			int posRet[] = position(te);
			int pos = posRet[1];
			return (posRet[0] == 1) ? startOffset + pos : -1;
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
	
	public int getValue(Writable key, Writable value) throws BaseException
	{
		LockUtils.lock(lock.readLock());
		try
		{
			int pos = getIndex(key) - startOffset;
			if ( pos != -1 )
			{
				int i = pos * 2;
				DataIStream dis = Streams.dis.get();
				ByteArrayIS bis = dis.getUnderlyingStream();
				bis.setBuffer(bytes, valueOffsetsArray[i], valueOffsetsArray[i+1]);
				value.readFields(dis);
			}
			return pos;
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
	
	public ByteBasedSortedMap[] split() throws BaseException
	{
		LockUtils.lock(lock.writeLock());
		
		try
		{
			int splitIdx = currentSize/2;
			// first subMap must contain at least 1 element.
			// also increase space in the subMap, otherwise split will be called recursively until OutOfMem
			int firstCapacity = bytes.length;
			if ( splitIdx == 0)
			{
				splitIdx = 1;
				firstCapacity = firstCapacity << 1;
				
			}
			
			ByteBasedSortedMap[] subMaps = new ByteBasedSortedMap[] {
					new ByteBasedSortedMap(startOffset, firstCapacity, comparator),
					new ByteBasedSortedMap(startOffset + splitIdx, bytes.length, comparator),
			};
			
			int i;
			for(i=0; i<splitIdx; i++) { subMaps[0].add(this, i); }
			for(; i<currentSize; i++) { subMaps[1].add(this, i); }
			
			return subMaps;
		}
		finally
		{
			lock.writeLock().unlock();
		}
	}
	
	public Iterator<Writable> keyIterator(Writable wObj)  throws BaseException
	{
		return new KeyIterator(wObj, startOffset); 
	}
	
	public Iterator<WritableEntry> entryIterator(WritableEntry wObj)  throws BaseException
	{
		return new EntryIterator(wObj, startOffset); 
	}
	
	public void dump(StringBuilder bldr, WritableEntry wObj) throws IOException, BaseException
	{
		bldr.append("[");
		Iterator<WritableEntry> oi = entryIterator(wObj);
		while(oi.hasNext())
		{
			bldr.append(oi.next()).append(", ");
		}
		bldr.append("]\n");
	}
	
	public String toString()
	{
		return Utils.sprintf("(startOffset=%d, currentSize=%d, bytesUsed=%d", startOffset, currentSize, bytesUsed);
	}
	
	private int index(int i) throws BaseException
	{
		int j = i - startOffset;
		j = j << 1;
		if ( j >  2 * currentSize )
		{
			throw new BaseException(sprintf("index invalid %d", i));
		}
		return j;
	}
	
	private class EntryPosition implements Comparable<EntryPosition>
	{
		int idx;
		
		EntryPosition(int idx) { this.idx = idx; }

		@Override
		public int compareTo(EntryPosition o)
		{
			if ( o.idx == idx )
				return 0;
			int offset = keyOffsetsArray[idx*2];
			int sz = keyOffsetsArray[idx*2 + 1];
			int oOffset = keyOffsetsArray[o.idx*2];
			int oSz = keyOffsetsArray[o.idx*2 + 1];
			return comparator.compare(bytes, offset, sz, bytes, oOffset, oSz);
		}
	}
	
	private class TempEntryPosition implements Comparable<EntryPosition>
	{
		byte[] ebytes;
		int len;

		TempEntryPosition(byte[] ebytes, int len)
		{
			super();
			this.ebytes = ebytes;
			this.len = len;
		}

		@Override
		public int compareTo(EntryPosition o)
		{
			int oOffset = keyOffsetsArray[o.idx*2];
			int oSz = keyOffsetsArray[o.idx*2 + 1];
			return comparator.compare(ebytes, 0, len, bytes, oOffset, oSz);
		}

	}
	
	class KeyIterator implements Iterator<Writable>
	{
		Writable wObj;
		long checkTime;
		int i;
		
		KeyIterator(Writable wObj, int offset)
		{
			this.wObj = wObj;
			checkTime = lastModified;
			i = offset;
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
				 getKey(i++, wObj);
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
	
	class EntryIterator implements Iterator<WritableEntry>
	{
		WritableEntry wEntry;
		long checkTime;
		int i;
		
		EntryIterator(WritableEntry wEntry, int offset)
		{
			this.wEntry = wEntry;
			checkTime = lastModified;
			i = offset;
		}

		@Override
		public boolean hasNext()
		{
			return i < currentSize;
		}

		@Override
		public WritableEntry next()
		{
			 if (checkTime != lastModified)
	                throw new ConcurrentModificationException();
			 try
			 {
				 getEntry(i++, wEntry);
				 return wEntry;
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
	
	public static class WritableEntry
	{
		Writable key;
		Writable value;
		public WritableEntry(Writable key, Writable value)
		{
			super();
			this.key = key;
			this.value = value;
		}
		public Writable getKey()
		{
			return key;
		}
		public Writable getValue()
		{
			return value;
		}
		
		public String toString()
		{
			return Utils.sprintf("(%s, %s)", key.toString(), value.toString());
		}
	}
		
	public static class MapFullException extends BaseException
	{
		private static final long serialVersionUID = 4309680640300410885L;

		public MapFullException()
		{
			super();
		}

		public MapFullException(String message, Throwable cause)
		{
			super(message, cause);
		}

		public MapFullException(String message)
		{
			super(message);
		}

		public MapFullException(Throwable cause)
		{
			super(cause);
		}
		
	}
	
	public static class MapToSmallException extends BaseException
	{
		private static final long serialVersionUID = 4309680640300410885L;

		public MapToSmallException()
		{
			super();
		}

		public MapToSmallException(String message, Throwable cause)
		{
			super(message, cause);
		}

		public MapToSmallException(String message)
		{
			super(message);
		}

		public MapToSmallException(Throwable cause)
		{
			super(cause);
		}
		
	}
	
	
	private static final int INCREMENT_SIZE = (int) Math.pow(2, 16); 
	
	static final int SMALL_SIZE =  (int) Math.pow(2, 6 +10);                // 64KB
	static final int MEDIUM_SIZE = (int) Math.pow(2, (10 + 10 + 3));            // 8 MB
	static final int LARGE_SIZE = (int) Math.pow(2, (6 + 10 + 10));         // 64 MB
}
