package com.sap.hadoop.windowing.runtime.mr

import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.metadata.CompositeDataType;
import com.sap.hadoop.metadata.CompositeWritable;

class Map extends MapReduceBase implements Mapper<Writable, Writable, Writable, Writable> {
	Deserializer de;
	StructObjectInspector inputOI;

	String[] sortCols;
	CompositeDataType partDataType;
	CompositeWritable wkey;
	
	public void configure(JobConf jobconf) {
		try {
			de = HiveUtils.getDeserializer(jobconf.get(Job.WINDOWING_INPUT_DATABASE), jobconf.get(Job.WINDOWING_INPUT_TABLE), jobconf)
			inputOI = (StructObjectInspector) de.getObjectInspector();
			
			String partColStr = jobconf.get(Job.WINDOWING_PARTITION_COLS);
			sortCols = partColStr.split(",");
			String s = jobconf.get(Job.WINDOWING_KEY_TYPE);
			partDataType = new CompositeDataType();
			partDataType.readFields(s);
			wkey = partDataType.create();
		}
		catch(Exception me) {
			throw new RuntimeException(me);
		}
	}

	@Override
	public void map(Writable key, Writable value,
	OutputCollector<Writable, Writable> output, Reporter reporter)
	throws IOException {
		try {
			Object o = de.deserialize(value);
			int si = 0
			for(String sCol : sortCols) {
				StructField iField = inputOI.getStructFieldRef(sCol);
				Object val = inputOI.getStructFieldData(o, iField);
				wkey.setElement(val, iField.getFieldObjectInspector(), si++);
			}

			output.collect(wkey, value);
		}
		catch(SerDeException se) {
			throw new IOException(se);
		}
	}

}


