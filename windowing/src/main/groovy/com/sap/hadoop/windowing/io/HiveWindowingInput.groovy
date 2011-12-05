package com.sap.hadoop.windowing.io

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe;
import org.apache.hadoop.hive.contrib.util.typedbytes.TypedBytesRecordReader;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.io.Writable;


public class HiveWindowingInput extends TypedBytesRecordReader implements WindowingInput
{
	private SerDe serDe;
	Writable value;
	boolean isValueValid;

	
	public Deserializer getDeserializer()
	{
		return serDe;
	}
	
	public void initialize(InputStream ins, Configuration conf, Properties tbl) throws IOException
	{
		super.initialize(System.in, conf, tbl);
		setupSerDe(conf, tbl);
		value = createRow();
	}
	
	private void setupSerDe(Configuration conf, Properties serDeProps) throws IOException
	{
		try
		{
			serDe = new TypedBytesSerDe();
			serDe.initialize(conf, serDeProps);
		}
		catch(Exception e)
		{
			throw new IOException(e);
		}
	}
	
	boolean hasNext()
	{
		int nbytes = next(value)
		isValueValid = (nbytes >= 0)
		return isValueValid;
	}
	
	Writable next()
	{
		return value;
	}
	void remove() { throw new UnsupportedOperationException() }
}
