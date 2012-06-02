package com.sap.hadoop.metadata;

import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.Serializer;
import org.apache.hadoop.hive.serde2.binarysortable.OutputByteBuffer;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.BooleanObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.ByteObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.DoubleObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.FloatObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.IntObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.LongObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.ShortObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.StringObjectInspector;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.windowing.Constants;

public class WindowingKeySerializer implements Serializer
{
	String[] sortCols;
	boolean[] ordering;
	int numPCols;
	OutputByteBuffer outputByteBuffer = new OutputByteBuffer();
	WindowingKey wKey = new WindowingKey();

	public void initialize(Configuration conf, Properties tbl)
			throws SerDeException
	{
		String sortColStr = conf.get(Constants.WINDOWING_SORT_COLS);
		sortCols = sortColStr.split(",");

		String sortOrder = conf.get(Constants.WINDOWING_SORT_COLS_ORDER);
		String[] orders = sortOrder.split(",");
		int len = orders.length;
		ordering = new boolean[len];
		for (int i = 0; i < len; i++)
		{
			String os = orders[i];
			Order o = Order.valueOf(Order.class, os);
			ordering[i] = (o == Order.DESC);
		}
		numPCols = conf.getInt(Constants.WINDOWING_NUM_PARTION_COLUMNS, 0);
	}

	public Class<? extends Writable> getSerializedClass()
	{
		return WindowingKey.class;
	}

	public Writable serialize(Object obj, ObjectInspector objInspector)
			throws SerDeException
	{
		StructObjectInspector inputOI = (StructObjectInspector) objInspector;
		outputByteBuffer.reset();
		int grpSize = 0;
		int i = 0;
		int hashCode = 0;
		for (; i < sortCols.length; i++)
		{
			if (i == numPCols)
			{
				grpSize = outputByteBuffer.getLength();
			}
			String sCol = sortCols[i];
			StructField iField = inputOI.getStructFieldRef(sCol);
			Object val = inputOI.getStructFieldData(obj, iField);
			ObjectInspector fieldOI = iField.getFieldObjectInspector();
			// wkey.setElement(val, iField.getFieldObjectInspector(), si++);
			serialize(outputByteBuffer, val, fieldOI, ordering[i]);
			if ( i < numPCols)
			{
				hashCode = hashCode * 31
	              + ObjectInspectorUtils.hashCode(val, fieldOI);
			}
		}
		if (i == numPCols)
		{
			grpSize = outputByteBuffer.getLength();
		}
		wKey.unchecked_set(outputByteBuffer.getData(), outputByteBuffer.getLength(), grpSize);
		wKey.setHashCode(hashCode);

		return wKey;
	}

	/*
	 * copied from BinarySortableSerDe::serialize
	 */
	static void serialize(OutputByteBuffer buffer, Object o,
			ObjectInspector oi, boolean invert)
	{
		// Is this field a null?
		if (o == null)
		{
			buffer.write((byte) 0, invert);
			return;
		}
		// This field is not a null.
		buffer.write((byte) 1, invert);

		switch (oi.getCategory())
		{
		case PRIMITIVE:
		{
			PrimitiveObjectInspector poi = (PrimitiveObjectInspector) oi;
			switch (poi.getPrimitiveCategory())
			{
			case VOID:
			{
				return;
			}
			case BOOLEAN:
			{
				boolean v = ((BooleanObjectInspector) poi).get(o);
				buffer.write((byte) (v ? 2 : 1), invert);
				return;
			}
			case BYTE:
			{
				ByteObjectInspector boi = (ByteObjectInspector) poi;
				byte v = boi.get(o);
				buffer.write((byte) (v ^ 0x80), invert);
				return;
			}
			case SHORT:
			{
				ShortObjectInspector spoi = (ShortObjectInspector) poi;
				short v = spoi.get(o);
				buffer.write((byte) ((v >> 8) ^ 0x80), invert);
				buffer.write((byte) v, invert);
				return;
			}
			case INT:
			{
				IntObjectInspector ioi = (IntObjectInspector) poi;
				int v = ioi.get(o);
				buffer.write((byte) ((v >> 24) ^ 0x80), invert);
				buffer.write((byte) (v >> 16), invert);
				buffer.write((byte) (v >> 8), invert);
				buffer.write((byte) v, invert);
				return;
			}
			case LONG:
			{
				LongObjectInspector loi = (LongObjectInspector) poi;
				long v = loi.get(o);
				buffer.write((byte) ((v >> 56) ^ 0x80), invert);
				buffer.write((byte) (v >> 48), invert);
				buffer.write((byte) (v >> 40), invert);
				buffer.write((byte) (v >> 32), invert);
				buffer.write((byte) (v >> 24), invert);
				buffer.write((byte) (v >> 16), invert);
				buffer.write((byte) (v >> 8), invert);
				buffer.write((byte) v, invert);
				return;
			}
			case FLOAT:
			{
				FloatObjectInspector foi = (FloatObjectInspector) poi;
				int v = Float.floatToIntBits(foi.get(o));
				if ((v & (1 << 31)) != 0)
				{
					// negative number, flip all bits
					v = ~v;
				}
				else
				{
					// positive number, flip the first bit
					v = v ^ (1 << 31);
				}
				buffer.write((byte) (v >> 24), invert);
				buffer.write((byte) (v >> 16), invert);
				buffer.write((byte) (v >> 8), invert);
				buffer.write((byte) v, invert);
				return;
			}
			case DOUBLE:
			{
				DoubleObjectInspector doi = (DoubleObjectInspector) poi;
				long v = Double.doubleToLongBits(doi.get(o));
				if ((v & (1L << 63)) != 0)
				{
					// negative number, flip all bits
					v = ~v;
				}
				else
				{
					// positive number, flip the first bit
					v = v ^ (1L << 63);
				}
				buffer.write((byte) (v >> 56), invert);
				buffer.write((byte) (v >> 48), invert);
				buffer.write((byte) (v >> 40), invert);
				buffer.write((byte) (v >> 32), invert);
				buffer.write((byte) (v >> 24), invert);
				buffer.write((byte) (v >> 16), invert);
				buffer.write((byte) (v >> 8), invert);
				buffer.write((byte) v, invert);
				return;
			}
			case STRING:
			{
				StringObjectInspector soi = (StringObjectInspector) poi;
				Text t = soi.getPrimitiveWritableObject(o);
				byte[] data = t.getBytes();
				int length = t.getLength();
				for (int i = 0; i < length; i++)
				{
					if (data[i] == 0 || data[i] == 1)
					{
						buffer.write((byte) 1, invert);
						buffer.write((byte) (data[i] + 1), invert);
					}
					else
					{
						buffer.write(data[i], invert);
					}
				}
				buffer.write((byte) 0, invert);
				return;
			}
			default:
			{
				throw new RuntimeException("Unrecognized type: "
						+ poi.getPrimitiveCategory());
			}
			}
		}
		default:
		{
			throw new RuntimeException("Unsupported type in WindowingKey : "
					+ oi.getCategory());
		}
		}

	}
}
