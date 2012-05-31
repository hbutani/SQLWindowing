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
import com.sap.hadoop.metadata.WindowingKey;
import com.sap.hadoop.metadata.WindowingKeySerializer;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query.QuerySpec;
import com.sap.hadoop.windowing.query.TableInput;

class MapBase
{
	Deserializer de;
	StructObjectInspector inputOI;

	WindowingKeySerializer wkS;
	WindowingKey wkey;
	
	public void configure(Configuration jobconf) {
		try {
//			de = HiveUtils.getDeserializer(jobconf.get(Job.WINDOWING_INPUT_DATABASE), jobconf.get(Job.WINDOWING_INPUT_TABLE), jobconf)
//			inputOI = (StructObjectInspector) de.getObjectInspector();
			
			setupInput(jobconf)
			
			wkey = new WindowingKey();
			wkS = new WindowingKeySerializer();
			wkS.initialize(jobconf, null);
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
			wkey = (WindowingKey) wkS.serialize(o, inputOI);
		}
		catch(SerDeException se) {
			throw new IOException(se);
		}
	}

}
