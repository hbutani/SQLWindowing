package com.sap.hadoop.windowing.runtime.mr

import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.io.Writable;

class Map extends MapReduceBase implements Mapper<Writable, Writable, Writable, Writable> {
	MapBase base = new MapBase();
	
	public void configure(JobConf jobconf) {
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
	throws IOException {
		base.map(key, value);
		output.collect(base.wkey, value);
	}

}


