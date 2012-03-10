package com.sap.hadoop.windowing.runtime.mr

import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.io.Writable;

public class Reduce extends MapReduceBase implements Reducer<Writable, Writable, Writable, Writable>
{
	ReduceBase base = new ReduceBase();
	
	public void configure(JobConf job) 
	{
		base.configure(job)
	}

	@Override
	public void reduce(Writable key, Iterator<Writable> values,
			OutputCollector<Writable, Writable> output, Reporter reporter)
			throws IOException
	{		
		ReduceOutput rOut = new ReduceOutput() {
			public void collectOutput(Writable okey, Writable ovalue)
			{
				output.collect(okey, ovalue);
			}
		}
		base.reduce(key, values, rOut);
	}	
}

