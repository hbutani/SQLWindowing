package com.sap.hadoop.windowing.runtime.mr

import java.io.IOException;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.io.Writable;

class Map2 extends Mapper<Writable, Writable, Writable, Writable>
{
	MapBase base = new MapBase();
	
	protected void setup(Context jobconf) throws IOException, InterruptedException 
	{
		try {
			base.configure(jobconf.getConfiguration());
		}
		catch(Exception me) {
			throw new RuntimeException(me);
		}
	}
	
	@Override
	public void map(Writable key, Writable value, Context context)
	throws IOException {
		base.map(key, value);
		context.write(base.wkey, value);
	}
}
