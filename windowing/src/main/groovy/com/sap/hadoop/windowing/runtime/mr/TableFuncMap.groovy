package com.sap.hadoop.windowing.runtime.mr

import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

class TableFuncMap extends MapReduceBase implements Mapper<Writable, Writable, Writable, Writable> 
{
	MapPhaseExecTaskBase base = new MapPhaseExecTaskBase();
	
	public void configure(JobConf jobconf) 
	{
		try {
			base.configure(jobconf);
		}
		catch(Exception me) {
			throw new RuntimeException(me);
		}
	}

	@Override
	public void map(Writable key, Writable value,
					OutputCollector<Writable, Writable> output, Reporter reporter)
	throws IOException 
	{
		base.map(key, value, output, reporter);
	}
	
	public void close() throws IOException 
	{
		base.close();
	}
}
