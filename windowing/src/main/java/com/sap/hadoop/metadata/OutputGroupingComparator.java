package com.sap.hadoop.metadata;

import org.apache.hadoop.io.RawComparator;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.JobConfigurable;

public class OutputGroupingComparator implements RawComparator<Object>,
		JobConfigurable
{
	@Override
	public void configure(JobConf job)
	{
	}

	public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2)
	{
		/*
		 * read bytes 4-7 as grpSz
		 */
		int grpSz1 = (((b1[4] & 0xff) << 24) | ((b1[5] & 0xff) << 16) |
				  ((b1[6] & 0xff) << 8) | (b1[7] & 0xff));
		int grpSz2 = (((b2[4] & 0xff) << 24) | ((b2[5] & 0xff) << 16) |
				  ((b2[6] & 0xff) << 8) | (b2[7] & 0xff));
		return WritableComparator.compareBytes(b1, s1 + WindowingKey.LENGTH_BYTES, grpSz1, 
				b2, s2 + WindowingKey.LENGTH_BYTES, grpSz2);
	}

	@Override
	public int compare(Object arg0, Object arg1)
	{
		WindowingKey key1 = (WindowingKey) arg0;
		WindowingKey key2 = (WindowingKey) arg1;
		return key1.compareToGroup(key2);
	}
}
