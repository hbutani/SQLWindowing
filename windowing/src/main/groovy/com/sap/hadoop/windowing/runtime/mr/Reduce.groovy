package com.sap.hadoop.windowing.runtime.mr

import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Writable;

@SuppressWarnings("deprecation")
public class Reduce extends MapReduceBase implements Reducer<Writable, Writable, Writable, Writable>
{

	@Override
	public void reduce(Writable key, Iterator<Writable> values,
			OutputCollector<Writable, Writable> output, Reporter reporter)
			throws IOException
	{
		while(values.hasNext())
		{
			output.collect(NullWritable.get(), values.next());
		}
	}
	
}

