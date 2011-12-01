package com.sap.hadoop.windowing.runtime.mr

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Partitioner;
import com.sap.hadoop.metadata.CompositeWritable;

class Partition implements Partitioner<CompositeWritable, org.apache.hadoop.io.Writable>
{
	int numPCols;
	
	public int getPartition(CompositeWritable key, org.apache.hadoop.io.Writable value, int numPartitions)
	{
		WritableComparable<?>[] elems = key.getElements()
		final int prime = 31;
		int result = 1;
		
		for(int i=0; i < numPCols; i++)
		{
			result = prime * result + elems[i].hashCode();
		}
		return result % numPartitions;
	}

	@Override
	public void configure(JobConf job)
	{
		numPCols = job.getInt(Job.WINDOWING_NUM_PARTION_COLUMNS, 0);
	}
}
