package com.sap.hadoop.metadata;

import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Partitioner;

import com.sap.hadoop.windowing.Constants;

public class WindowingKeyPartitioner implements Partitioner<WindowingKey, org.apache.hadoop.io.Writable>
{
	int numPCols;
	
	public int getPartition(WindowingKey key, org.apache.hadoop.io.Writable value, int numPartitions)
	{
		return Math.abs(key.hashCode()) % numPartitions;
	}

	@Override
	public void configure(JobConf job)
	{
		numPCols = job.getInt(Constants.WINDOWING_NUM_PARTION_COLUMNS, 0);
	}
}

