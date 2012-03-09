package com.sap.hadoop.ds.sortedmap;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.Writable;

import com.google.common.io.Files;
import com.sap.hadoop.ds.BaseException;
import com.sap.hadoop.ds.LockUtils;
import com.sap.hadoop.ds.streams.Streams;
import com.sap.hadoop.ds.streams.Streams.ByteArrayOS;
import com.sap.hadoop.ds.streams.Streams.DataOStream;

public class PartitionedByteBasedSortedMap extends ByteBasedSortedMap
{
	int componentCapacity;
	SplitList splitList;
	ArrayList<ByteBasedSortedMap> partitions;
	boolean fixStartPositions;
	File dir;
	/*
	 * for 2 percent of the puts, attempt to persist a Partition.
	 */
	int percentPersist = 2;
	
	public PartitionedByteBasedSortedMap(int startOffset, int capacity, RawComparator<?> comparator)
	{
		super(startOffset, capacity, comparator);
		componentCapacity = capacity;
		splitList = new SplitList();
		partitions = new ArrayList<ByteBasedSortedMap>();
		splitList = new SplitList();
		fixStartPositions = false;
		partitions.add(new ByteBasedSortedMap(capacity, comparator));
		dir = Files.createTempDir();
		Runtime.getRuntime().addShutdownHook(new ShutdownHook(dir));
	}
	
	public PartitionedByteBasedSortedMap(RawComparator<?> comparator)
	{
		this(0, MEDIUM_SIZE, comparator);
	}
	
	public PartitionedByteBasedSortedMap(int capacity, RawComparator<?> comparator)
	{
		this(0, capacity, comparator);
	}
	
	private ByteBasedSortedMap persist(int i) throws BaseException
	{
		try
		{
			ByteBasedSortedMap mp = partitions.get(i);
			if ( !(mp instanceof PersistentByteBasedSortedMap ) )
			{
				File f = File.createTempFile("wdw", null, dir);
				mp = new PersistentByteBasedSortedMap(f, mp, comparator);
				partitions.set(i, mp);
			}
			return mp;
		}
		catch(IOException ie)
		{
			throw new BaseException(ie);
		}
	}
	
	private void persistRandom() throws BaseException
	{
		int percent = (int) (System.currentTimeMillis() % 100);
		if ( percent >= percentPersist )
			return;
		int i = (int) (System.currentTimeMillis() % partitions.size());
		persist(i);
	}
	
	protected ByteBasedSortedMap bringInMemory(int p) throws BaseException
	{
		ByteBasedSortedMap mp = partitions.get(p);
		mp = mp.getMemoryMap();
		partitions.set(p, mp);
		return mp;
	}
	
	public void put(Writable key, Writable value) throws BaseException
	{
		LockUtils.lock(lock.writeLock());
		
		try
		{
			DataOStream dos = Streams.dos.get();
			ByteArrayOS bos = dos.getUnderlyingStream();
			bos.reset();
			key.write(dos);
			int p = splitList.getPartition(bos.bytearray(), 0, bos.len());
			ByteBasedSortedMap mp = bringInMemory(p);
			
			try
			{
				int prevSz = mp.size();
				mp.put(key, value);
				if ( mp.size() > prevSz )
					currentSize++;
				fixStartPositions = true;
				persistRandom();
			}
			catch(MapFullException oe)
			{
				ByteBasedSortedMap[] parts = mp.split();
//				System.out.println(parts[0]);
//				System.out.println(parts[1]);
				partitions.set(p, parts[1]);
				partitions.add(p, parts[0]);
				byte[] b = parts[0].getLastKey();
				splitList.splitPartition(p, b, 0, b.length);
				put(key, value);
			}
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
	
	private ByteBasedSortedMap getPartition(int idx) throws BaseException
	{
		int cumSz = 0;
		for(ByteBasedSortedMap m : partitions)
		{
			if ( idx < cumSz + m.size())
				return m;
			cumSz += m.size();
		}
		throw new BaseException("Index out of range " + idx);
	}
	

	
	public void getKey(int i, Writable wObj) throws BaseException
	{
		fixStartPositions();
		LockUtils.lock(lock.readLock());
		try
		{
			ByteBasedSortedMap m = getPartition(i);
			m.getKey(i, wObj);
		}
		finally
		{
			lock.readLock().unlock();
		}
	}
	
	protected byte[] getLastKey() throws BaseException
	{
		ByteBasedSortedMap m = partitions.get(partitions.size() - 1);
		return m.getLastKey();
	}
	
	public void getEntry(int i, WritableEntry entry) throws BaseException
	{
		fixStartPositions();
		LockUtils.lock(lock.readLock());
		try
		{
			ByteBasedSortedMap m = getPartition(i);
			m.getEntry(i, entry);
		}
		finally
		{
			lock.readLock().unlock();
		}
	}
	
	public int getIndex(Writable w) throws BaseException
	{
		fixStartPositions();
		LockUtils.lock(lock.readLock());
		try
		{
			DataOStream dos = Streams.dos.get();
			ByteArrayOS bos = dos.getUnderlyingStream();
			bos.reset();
			w.write(dos);
			int p = splitList.getPartition(bos.bytearray(), 0, bos.len());
			ByteBasedSortedMap mp = partitions.get(p);
			return mp.getIndex(w);
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
			DataOStream dos = Streams.dos.get();
			ByteArrayOS bos = dos.getUnderlyingStream();
			bos.reset();
			key.write(dos);
			int p = splitList.getPartition(bos.bytearray(), 0, bos.len());
			ByteBasedSortedMap mp = partitions.get(p);
			return mp.getValue(key, value);
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
	
	public ByteBasedSortedMap[] split() throws BaseException
	{
		throw new UnsupportedOperationException();
	}
	
	private void fixStartPositions() throws BaseException
	{
		LockUtils.lock(lock.writeLock());
		try
		{
			if ( fixStartPositions )
			{
				int cumSz = 0;
				for(int i=0; i < partitions.size(); i++)
				{
					ByteBasedSortedMap m = partitions.get(i);
					if ( m.startOffset != cumSz )
					{
						m = bringInMemory(i);
					}
					m.startOffset = cumSz;
					m = persist(i);
					cumSz += m.size();
				}
				fixStartPositions = false;
			}
		}
		finally
		{
			lock.writeLock().unlock();
		}
	}
	
	public Iterator<Writable> keyIterator(Writable wObj)  throws BaseException
	{
		fixStartPositions();
		return new KeyIterator(wObj, startOffset); 
	}
	
	public Iterator<WritableEntry> entryIterator(WritableEntry wObj)  throws BaseException
	{
		fixStartPositions();
		return new EntryIterator(wObj, startOffset); 
	}
	
	public String toString()
	{
		try
		{
			fixStartPositions();
		}
		catch(BaseException be)
		{
			return "<Failed to create String representation of Map>";
		}
		StringBuilder buf = new StringBuilder();
		buf.append("[\n");
		for(ByteBasedSortedMap bm : partitions)
		{
			buf.append(bm).append("\n");
		}
		buf.append("]\n");
		return buf.toString();
	}
	
	class SplitList
	{
		/*
		 * Partition[i] contains  keys <= splitKeys[i+1]
		 */
		ArrayList<byte[]> splitKeys;
		int numSplits;
		
		SplitList()
		{
			numSplits = 0;
			splitKeys = new ArrayList<byte[]>();
		}
		
		int getPartition(byte[] bytes, int offset, int sz)
		{
			if ( numSplits == 0) return 0;
			int start = 0;
			int end = numSplits - 1;
			
			while(start <= end)
			{
				int mid = (start + end) >>> 1;
				byte[] mBytes = splitKeys.get(mid);
				int cmp = comparator.compare(bytes, offset, sz, mBytes, 0, mBytes.length);
				if ( cmp == 0 )
				{
					return mid;
				}
				else if ( cmp > 0 )
				{
					start = mid + 1;
				}
				else
				{
					if ( mid == 0 )
					{
						return mid;
					}
					mBytes = splitKeys.get(mid-1);
					cmp = comparator.compare(bytes, offset, sz, mBytes, 0, mBytes.length);
					if ( cmp > 0 ) return mid;
					end = mid - 1;
				}
			}
			return start;
		}
		
		void splitPartition(int k, byte[] bytes, int offset, int sz)
		{
			numSplits++;
			byte[] b = new byte[sz];
			System.arraycopy(bytes, offset, b, 0, sz);
			splitKeys.add(k, b);
		}
	}
	
	static class ShutdownHook extends Thread
	{
		File dir;
		
		public ShutdownHook(File dir)
		{
			this.dir = dir;
		}
		
		public void run()
		{
			try
			{
				Files.deleteRecursively(dir);
			}
			catch(IOException ie)
			{
			}
		}
		
	}
}
