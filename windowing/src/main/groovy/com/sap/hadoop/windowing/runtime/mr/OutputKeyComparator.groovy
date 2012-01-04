package com.sap.hadoop.windowing.runtime.mr

import org.apache.hadoop.io.DataInputBuffer;
import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.JobConfigurable;

import com.sap.hadoop.metadata.CompositeDataType;
import com.sap.hadoop.metadata.CompositeWritable;
import com.sap.hadoop.windowing.query.Order;


class OutputKeyComparator implements RawComparator, JobConfigurable 
{
	CompositeDataType recordType;
	CompositeWritable key1;
	CompositeWritable key2;
	private final DataInputBuffer buffer;
	boolean[] ordering;
	
	protected OutputKeyComparator()
	{
		key1 = new CompositeWritable();
		key2 = new CompositeWritable();
		buffer = new DataInputBuffer();
	}
	
	@Override
	public void configure(JobConf job)
	{
		String s = job.get(Job.WINDOWING_KEY_TYPE);
		recordType = new CompositeDataType();
		recordType.readFields(s);
		key1 = recordType.create();
		key2 = recordType.create();
		
		String sortOrder = job.get(Job.WINDOWING_SORT_COLS_ORDER)
		String[] orders = sortOrder.split(",")
		int len = orders.length
		ordering = new boolean[len]
		for(int i = 0; i < len; i++)
		{
			String os = orders[i]
			Order o = Order.valueOf(Order.class, os)
			ordering[i] = (o == Order.DESC)
		}
	}
	
	public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2)
	{
		try {
			buffer.reset(b1, s1, l1);                   // parse key1
			key1.readFields(buffer);
			
			buffer.reset(b2, s2, l2);                   // parse key2
			key2.readFields(buffer);
			
		  } catch (IOException e) {
			throw new RuntimeException(e);
		  }
		  
		  return compare(key1, key2);
	}

	@Override
	public int compare(Object arg0, Object arg1)
	{
		CompositeWritable key1 = (CompositeWritable) arg0;
		CompositeWritable key2 = (CompositeWritable) arg1;
		return key1.compareTo(key2, ordering);
	}
}