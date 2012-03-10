package com.sap.hadoop.windowing.runtime.mr

import java.io.IOException;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.apache.hadoop.io.Writable;

class Reduce2 extends Reducer<Writable,Writable,Writable,Writable>
{
	ReduceBase base = new ReduceBase();
	
	protected void setup(Context context) throws IOException, InterruptedException 
	{
		base.configure(context.getConfiguration())
	}
	
	protected void reduce(Writable key, Iterable<Writable> values, Context context) throws IOException, InterruptedException 
	{
		ReduceOutput rOut = new ReduceOutput() {
			public void collectOutput(Writable okey, Writable ovalue)
			{
				context.write(okey, ovalue);
			}
		}
		base.reduce(key, values, rOut);
	}
}
