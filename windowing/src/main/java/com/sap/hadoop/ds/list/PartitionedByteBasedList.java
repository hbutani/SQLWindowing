package com.sap.hadoop.ds.list;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.Serializer;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.io.Writable;

import com.google.common.io.Files;
import com.sap.hadoop.ds.BaseException;
import com.sap.hadoop.ds.LockUtils;

public class PartitionedByteBasedList extends ByteBasedList
{
	ArrayList<ByteBasedList> partitions;
	ArrayList<Integer> partitionOffsets;
	File dir;
	int batchSize;
	
	public PartitionedByteBasedList(int batchSize) throws BaseException
	{
		this.batchSize = batchSize;
		currentSize = 0;
		dir = Files.createTempDir();
		Runtime.getRuntime().addShutdownHook(new Thread() {
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
		});
		
		partitions = new ArrayList<ByteBasedList>();
		partitionOffsets = new ArrayList<Integer>();
		addPartition();
	}
	
	public PartitionedByteBasedList() throws BaseException
	{
		this(ByteBasedList.LARGE_SIZE);
	}
	
	private void addPartition() throws BaseException
	{
		try
		{
			if ( partitions.size() > 0 )
			{
				int idx = partitions.size() - 1;
				ByteBasedList bl = partitions.get(idx);
				File f = File.createTempFile("wdw", null, dir);
				PersistentByteBasedList.store(bl, f);
				partitions.set(idx, new PersistentByteBasedList(f, bl));
				
			}
			ByteBasedList bl = new ByteBasedList(currentSize, batchSize);
			partitions.add(bl);
			partitionOffsets.add(currentSize);
		}
		catch(IOException ie)
		{
			throw new BaseException(ie);
		}
	}
	
	private ByteBasedList getPartition(int i) throws BaseException
	{
		LockUtils.lock(lock.readLock());
		try
		{
			int numSplits = partitions.size();
			if ( numSplits == 0) return partitions.get(0);
			int start = 0;
			int end = numSplits - 1;
			
			while(start < end)
			{
				int mid = (start + end + 1) >>> 1;
				int val = partitionOffsets.get(mid);
				if ( val == i )
				{
					return partitions.get(mid);
				}
				else if ( val < i )
				{
					if ( end == mid)
					{
						return partitions.get(end);
					}
					start = mid;
				}
				else
				{
					end = mid - 1;
				}
			}
			return partitions.get(start);
		}
		finally
		{
			lock.readLock().unlock();
		}
	}
	
	public void get(int i, Writable wObj) throws BaseException
	{
		ByteBasedList bl = getPartition(i);
		bl.get(i, wObj);
	}
	
	public void append(Writable obj) throws BaseException
	{
		LockUtils.lock(lock.writeLock());
		try
		{
			partitions.get(partitions.size() -1).append(obj);
			currentSize += 1;
			lastModified = System.nanoTime();
		}
		catch(ListFullException le)
		{
			addPartition();
			append(obj);
		}
		finally
		{
			lock.writeLock().unlock();
		}
		
	}
	
	public Object get(int i, Deserializer deserializer, Writable wObj) throws BaseException
	{
		ByteBasedList bl = getPartition(i);
		return bl.get(i, deserializer, wObj);
	}
	
	public void append(Object obj, ObjectInspector OI, Serializer serializer) throws BaseException
	{
		LockUtils.lock(lock.writeLock());
		try
		{
			partitions.get(partitions.size() -1).append(obj, OI, serializer);
			currentSize += 1;
			lastModified = System.nanoTime();
		}
		catch(ListFullException le)
		{
			addPartition();
			append(obj, OI, serializer);
		}
		finally
		{
			lock.writeLock().unlock();
		}
	}
	
	public Iterator<Writable> iterator(Writable wObj) throws BaseException
	{
		return new WIterator(wObj); 
	}
	
	class WIterator implements Iterator<Writable>
	{
		Writable wObj;
		long checkTime;
		int i;
		Iterator<Writable> pIter;
		
		WIterator(Writable wObj) throws BaseException
		{
			this.wObj = wObj;
			checkTime = lastModified;
			i = 0;
			pIter = partitions.get(i).iterator(wObj);
		}

		@Override
		public boolean hasNext()
		{
			if ( pIter.hasNext() ) return true;
			if (checkTime != lastModified)
                throw new ConcurrentModificationException();
			try
			{
				if ( i < partitions.size() )
				{
					pIter = partitions.get(i++).iterator(wObj);
					return hasNext();
				}
				return false;
			}
			catch(BaseException e)
			{
				throw new RuntimeException(e);
			}
		}

		@Override
		public Writable next()
		{
			 if (checkTime != lastModified)
	                throw new ConcurrentModificationException();
			 return pIter.next();
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}

}
