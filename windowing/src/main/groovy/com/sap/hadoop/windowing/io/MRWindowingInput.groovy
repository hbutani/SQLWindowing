package com.sap.hadoop.windowing.io

import org.apache.hadoop.io.Writable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.metastore.MetaStoreUtils;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.SerDeUtils;
import org.apache.hadoop.hive.serde2.Serializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.runtime.mr.Job;


class MRWindowingInput implements WindowingInput 
{
	private static final Log LOG = LogFactory.getLog("com.sap.hadoop.windowing.io");
	
	private SerDe serDe;
	
	void initialize(InputStream in1, Configuration conf, Properties tbl) throws IOException 
	{
		String dbName = null
		if ( conf.hasProperty(Job.WINDOWING_INPUT_DATABASE))
			dbName = conf.get(Job.WINDOWING_INPUT_DATABASE);
		String tableName = conf.get(Job.WINDOWING_INPUT_TABLE);
		
		serDe = HiveUtils.getDeserializer(dbName, tableName, conf);
	}
	
	void initialize(Configuration conf, String serDeClassName, Properties tbl) throws WindowingException
	{
		if (serDeClassName == null) 
		{
		  throw new WindowingException("Cannot initialize MRWindowingInput, serDeClass is null") 
		}
		
		try 
		{
		  serDe = SerDeUtils.lookupDeserializer(serDeClassName);
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

	Writable createRow() throws IOException 
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
