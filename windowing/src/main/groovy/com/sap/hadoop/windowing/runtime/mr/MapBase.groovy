package com.sap.hadoop.windowing.runtime.mr

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.SerDeUtils;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.metadata.CompositeDataType;
import com.sap.hadoop.metadata.CompositeWritable;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query.QuerySpec;
import com.sap.hadoop.windowing.query.TableInput;

class MapBase
{
	Deserializer de;
	StructObjectInspector inputOI;

	String[] sortCols;
	CompositeDataType sortDataType;
	CompositeWritable wkey;
	
	public void configure(Configuration jobconf) {
		try {
//			de = HiveUtils.getDeserializer(jobconf.get(Job.WINDOWING_INPUT_DATABASE), jobconf.get(Job.WINDOWING_INPUT_TABLE), jobconf)
//			inputOI = (StructObjectInspector) de.getObjectInspector();
			
			setupInput(jobconf)
			
			String sortColStr = jobconf.get(Job.WINDOWING_SORT_COLS);
			sortCols = sortColStr.split(",");
			String s = jobconf.get(Job.WINDOWING_KEY_TYPE);
			sortDataType = new CompositeDataType();
			sortDataType.readFields(s);
			wkey = sortDataType.create();
		}
		catch(Exception me) {
			throw new RuntimeException(me);
		}
	}
	
	/*
	 * initialize input Deserializer and inputOI
	 */
	protected void setupInput(Configuration conf) throws WindowingException
	{
		QuerySpec qSpec = JobBase.getQuerySpec(conf)
		TableInput tableIn = qSpec.tableIn
		String serDeClassName = tableIn.serDeClass
		
		try
		{
		  de = SerDeUtils.lookupDeserializer(tableIn.serDeClass);
		  de.initialize(conf, tableIn.serDeProps);
		  inputOI = (StructObjectInspector) de.getObjectInspector();
		}
		catch (RuntimeException e)
		{
		  throw e;
		}
		catch (Exception e)
		{
		  throw new WindowingException(e.getClass().getName() + " " + e.getMessage());
		}
	}

	@Override
	public void map(Writable key, Writable value)
	throws IOException {
		try {
			Object o = de.deserialize(value);
			int si = 0
			for(String sCol : sortCols) {
				StructField iField = inputOI.getStructFieldRef(sCol);
				Object val = inputOI.getStructFieldData(o, iField);
				wkey.setElement(val, iField.getFieldObjectInspector(), si++);
			}
		}
		catch(SerDeException se) {
			throw new IOException(se);
		}
	}

}
