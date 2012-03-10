package com.sap.hadoop.windowing.runtime.mr

import java.util.ArrayList;

import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils.ObjectInspectorCopyOption;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.windowing.functions.AbstractTableFunction;
import com.sap.hadoop.windowing.query.Column;
import com.sap.hadoop.windowing.query.OutputColumn;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QueryInput;
import com.sap.hadoop.windowing.query.QueryOutput;
import com.sap.hadoop.windowing.query.QuerySpec;
import com.sap.hadoop.windowing.runtime.IPartition;
import com.sap.hadoop.windowing.runtime.IPartitionIterator;
import com.sap.hadoop.windowing.runtime.OutputObj;
import com.sap.hadoop.windowing.runtime.Row;
import com.sap.hadoop.windowing.runtime.WindowingShell;

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
			public void collect(Writable okey, Writable ovalue)
			{
				output.collect(okey, ovalue);
			}
		}
		base.reduce(key, values, rOut);
	}	
}

