package com.sap.hadoop.metadata;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.io.serializer.Deserializer;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.serializer.WritableSerialization;
import org.apache.hadoop.util.ReflectionUtils;

public class CompositeSerialization extends WritableSerialization
{
	
	public Deserializer<Writable> getDeserializer(Class<Writable> c)
	{
		if (CompositeWritable.class.isAssignableFrom(c))
			return new CompositeDeserializer(getConf(), c);
		return super.getDeserializer(c);
	}
	
	public static class CompositeDeserializer extends Configured implements Deserializer<Writable>
	{
		private Class<?> writableClass;
		private DataInputStream dataIn;
		CompositeDataType type;

		public CompositeDeserializer(Configuration conf, Class<?> c)
		{
			setConf(conf);
			this.writableClass = c;
			if (CompositeWritable.class.isAssignableFrom(writableClass))
			{
				type = new CompositeDataType();
				try
				{
					type.readFields(conf.get(CompositeDataType.COMPOSITE_DATA_TYPE));
				}
				catch (IOException ie)
				{
					throw new RuntimeException(ie);
				}
			}
			//System.out.println(c.getName() + "  " + type.toString());
		}

		public void open(InputStream in)
		{
			if (in instanceof DataInputStream)
				dataIn = (DataInputStream) in;
			else
				dataIn = new DataInputStream(in);
		}

		public Writable deserialize(Writable w) throws IOException
		{
			Writable writable;
			if (w == null)
			{
				if (type != null)
				{
					writable = new CompositeWritable();
					type.cast((CompositeWritable) writable);
				}
				else
				{
					writable = (Writable) ReflectionUtils.newInstance(writableClass, getConf());

				}
			}
			else
			{
				writable = w;
				if (type != null)
				{
					type.cast((CompositeWritable) writable);
				}
			}
			writable.readFields(dataIn);
			return writable;
		}

		public void close() throws IOException
		{
			dataIn.close();
		}
	}
}
