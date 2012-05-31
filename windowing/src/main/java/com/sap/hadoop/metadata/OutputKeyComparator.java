package com.sap.hadoop.metadata;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.JobConfigurable;

public class OutputKeyComparator implements RawComparator<Object>,
		JobConfigurable
{
	@Override
	public void configure(JobConf job)
	{
	}

	public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2)
	{
		return WritableComparator.get(WindowingKey.class).compare(b1, s1, l1, b2, s2, l2);
	}

	@Override
	public int compare(Object arg0, Object arg1)
	{
		WindowingKey key1 = (WindowingKey) arg0;
		WindowingKey key2 = (WindowingKey) arg1;
		return key1.compareTo(key2);
	}
}