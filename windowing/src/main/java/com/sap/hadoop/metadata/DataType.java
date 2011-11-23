package com.sap.hadoop.metadata;

import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.serde2.io.ShortWritable;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector.PrimitiveCategory;
import org.apache.hadoop.io.BooleanWritable;
import org.apache.hadoop.io.ByteWritable;
import org.apache.hadoop.io.DataInputBuffer;
import org.apache.hadoop.io.DataOutputBuffer;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.VIntWritable;
import org.apache.hadoop.io.VLongWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.ReflectionUtils;
import org.apache.hadoop.hive.serde.Constants;

import static com.sap.hadoop.metadata.Utils.*;

public class DataType<T extends Writable>
{
	Class<T> valueClass;
	
	
	public DataType() {}
	
	public DataType(Class<T> valueClass)
	{
		this.valueClass = valueClass;
	}

	/**
	 * use to instantiate an Writable object that can be used to hold instances of this type.
	 * @return
	 */
	public T create()
	{
		return create(null);
	}

	public T create(Configuration conf)
	{
		return ReflectionUtils.newInstance(valueClass, conf);
	}
	
	/**
	 * cast a WritableComparable to the subtype associated with this datatype;
	 * @param o
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T cast(Writable o)
	{
		return (T) o;
	}

	public T cloneInstance(T instance) throws IOException
	{
		DataOutputBuffer obuffer = serializeBuffers.get();
		obuffer.reset();
		instance.write(obuffer);
		DataInputBuffer ibuffer = materializeBuffers.get();
		byte[] b = obuffer.getData();
		ibuffer.reset(b, 0, b.length);
		T nv = create();
		nv.readFields(ibuffer);
		return nv;
	}
	
	public static DataType<BooleanWritable> BOOLEAN = 
		new DataType<BooleanWritable>(BooleanWritable.class) {};
	public static DataType<ByteWritable> BYTE = 
		new DataType<ByteWritable>(ByteWritable.class) {};
	public static DataType<ShortWritable> SHORT = 
		new DataType<ShortWritable>(ShortWritable.class) {};
	public static DataType<IntWritable> INT = 
		new DataType<IntWritable>(IntWritable.class) {};
	public static DataType<VIntWritable> VINT = 
		new DataType<VIntWritable>(VIntWritable.class) {};
	public static DataType<LongWritable> LONG = 
		new DataType<LongWritable>(LongWritable.class) {};
	public static DataType<VLongWritable> VLONG = 
		new DataType<VLongWritable>(VLongWritable.class) {};
	public static DataType<FloatWritable> FLOAT = 
		new DataType<FloatWritable>(FloatWritable.class) {};
	public static DataType<DoubleWritable> DOUBLE = 
		new DataType<DoubleWritable>(DoubleWritable.class) {};
	public static DataType<Text> TEXT = 
		new DataType<Text>(Text.class) {};
		
		
	public static DataType<?> getDataType(PrimitiveObjectInspector pOI)
	{
		PrimitiveCategory pC = pOI.getPrimitiveCategory();
		switch(pC)
		{
		case BOOLEAN: return BOOLEAN;
		case BYTE : return BYTE;
		case SHORT: return SHORT;
		case INT: return INT;
		case LONG: return LONG;
		case FLOAT: return FLOAT;
		case DOUBLE: return DOUBLE;
		case STRING: return TEXT;
		default:
			throw new RuntimeException(sprintf("Unsupported primitive type %s", pC));
		}
	}
			

	static HashMap<String, DataType<? extends Writable>> nameToTypeMap = 
			new HashMap<String, DataType<? extends Writable>>();

	static
	{
		nameToTypeMap.put(Constants.BOOLEAN_TYPE_NAME, BOOLEAN);
		nameToTypeMap.put(Constants.TINYINT_TYPE_NAME, BYTE);
		nameToTypeMap.put(Constants.SMALLINT_TYPE_NAME, SHORT);
		nameToTypeMap.put(Constants.INT_TYPE_NAME, INT);
		nameToTypeMap.put("vint", VINT);
		nameToTypeMap.put(Constants.BIGINT_TYPE_NAME, LONG);
		nameToTypeMap.put("vlong", VLONG);
		nameToTypeMap.put(Constants.FLOAT_TYPE_NAME, FLOAT);
		nameToTypeMap.put(Constants.DOUBLE_TYPE_NAME, DOUBLE);
		nameToTypeMap.put(Constants.STRING_TYPE_NAME, TEXT);
	};

	
	private static ThreadLocal<DataInputBuffer> materializeBuffers = new ThreadLocal<DataInputBuffer>()
	{
		protected synchronized DataInputBuffer initialValue()
		{
			return new DataInputBuffer();
		}
	};
	
	private static ThreadLocal<DataOutputBuffer> serializeBuffers = new ThreadLocal<DataOutputBuffer>()
	{
		protected synchronized DataOutputBuffer initialValue()
		{
			return new DataOutputBuffer();
		}
	};


}
