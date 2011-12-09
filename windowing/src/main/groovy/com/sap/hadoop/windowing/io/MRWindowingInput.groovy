package com.sap.hadoop.windowing.io

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.runtime.mr.Job;


class MRWindowingInput implements WindowingInput 
{
	private SerDe serDe;
	
	void initialize(InputStream in1, Configuration conf, Properties tbl) throws IOException 
	{
		String dbName = null
		if ( conf.hasProperty(Job.WINDOWING_INPUT_DATABASE))
			dbName = conf.get(Job.WINDOWING_INPUT_DATABASE);
		String tableName = conf.get(Job.WINDOWING_INPUT_TABLE);
		
		serDe = HiveUtils.getDeserializer(dbName, tableName, conf);
	}

	Writable createRow() throws IOException 
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the number of bytes that we consumed.
	 * -1 means end of stream.
	 */
	int next(Writable row) throws IOException 
	{
		throw new UnsupportedOperationException();
	}

	void close() throws IOException {
	}

	Deserializer getDeserializer() 
	{
		return serDe;
	}
	
	Serializer getSerializer()
	{
		return serDe;
	}

	boolean hasNext() 
	{
		throw new UnsupportedOperationException();
	}

	Writable next() 
	{
		throw new UnsupportedOperationException();
	}
	void remove() {
		throw new UnsupportedOperationException()
	}
}
