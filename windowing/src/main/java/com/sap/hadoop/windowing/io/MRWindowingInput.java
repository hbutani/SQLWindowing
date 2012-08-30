package com.sap.hadoop.windowing.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.SerDeUtils;
import org.apache.hadoop.hive.serde2.Serializer;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.WindowingException;

public class MRWindowingInput implements WindowingInput 
{
	private static final Log LOG = LogFactory.getLog("com.sap.hadoop.windowing.io");
	
	private SerDe serDe;
	
	public void initialize(InputStream in1, Configuration conf, Properties tbl) throws IOException 
	{
		String dbName = null;
		if ( conf.get(Constants.WINDOWING_INPUT_DATABASE) != null)
			dbName = conf.get(Constants.WINDOWING_INPUT_DATABASE);
		String tableName = conf.get(Constants.WINDOWING_INPUT_TABLE);
		
		try
		{
			serDe = (SerDe) HiveUtils.getDeserializer(dbName, tableName, conf);
		}
		catch(WindowingException we)
		{
			throw new IOException(we);
		}
	}
	
	void initialize(Configuration conf, String serDeClassName, Properties tbl) throws WindowingException
	{
		if (serDeClassName == null) 
		{
		  throw new WindowingException("Cannot initialize MRWindowingInput, serDeClass is null"); 
		}
		
		try 
		{
		  serDe = (SerDe) SerDeUtils.lookupDeserializer(serDeClassName);
		  serDe.initialize(conf, tbl);
		} 
		catch (RuntimeException e) 
		{
		  throw e;
		} 
		catch (Exception e) 
		{
		  LOG.error("error in initSerDe: " + e.getClass().getName() + " "  + e.getMessage());
		  throw new WindowingException(e.getClass().getName() + " " + e.getMessage());
		}
	}

	public Writable createRow() throws IOException 
	{
		//throw new UnsupportedOperationException();
		try
		{
			return serDe.getSerializedClass().newInstance();
		}
		catch(Throwable t)
		{
			throw new IOException(t);
		}
	}

	/**
	 * Returns the number of bytes that we consumed.
	 * -1 means end of stream.
	 */
	public int next(Writable row) throws IOException 
	{
		throw new UnsupportedOperationException();
	}

	public void close() throws IOException {
	}

	public Deserializer getDeserializer() 
	{
		return serDe;
	}
	
	public Serializer getSerializer()
	{
		return serDe;
	}

	public boolean hasNext() 
	{
		throw new UnsupportedOperationException();
	}

	public Writable next() 
	{
		throw new UnsupportedOperationException();
	}
	public void remove() {
		throw new UnsupportedOperationException();
	}
}

