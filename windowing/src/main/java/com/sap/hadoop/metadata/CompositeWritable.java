package com.sap.hadoop.metadata;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.hive.serde2.io.ShortWritable;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector.Category;
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
import org.apache.hadoop.io.BooleanWritable;
import org.apache.hadoop.io.ByteWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.WritableComparable;

public class CompositeWritable implements WritableComparable<CompositeWritable>
{
	CompositeDataType type;
	WritableComparable<?>[] elements;
	
	/**
	 * @nopub used by writable mechanics; don't invoke
	 */
	public CompositeWritable()
	{
		
	}
	
	CompositeWritable(CompositeDataType type, WritableComparable<?>... components)
	{
		this.type = type;
		this.elements = components;
	}
	
	public WritableComparable<?>[] getElements()
	{
		return elements;
	}

	protected void setElements(WritableComparable<?>[] elements)
	{
		this.elements = elements;
	}
	
	protected CompositeDataType getType()
	{
		return type;
	}

	protected void setType(CompositeDataType type)
	{
		this.type = type;
	}
	
	public void set(Object obj, StructObjectInspector soi) throws IOException
	{
		List<? extends StructField> fields = soi.getAllStructFieldRefs();

		for (int i = 0; i < elements.length; i++)
		{
			Object o = soi.getStructFieldData(obj, fields.get(i));
			ObjectInspector oi = fields.get(i).getFieldObjectInspector();
			setElement(o, oi, i);
		}
	}
	
	public void setElement(Object o, ObjectInspector oi, int i) throws IOException
	{
		if ( oi.getCategory() != Category.PRIMITIVE )
		{
			throw new IOException("Cannot handle non primitve fields for partitioning/sorting");
		}
		
		PrimitiveObjectInspector poi = (PrimitiveObjectInspector) oi;
		switch (poi.getPrimitiveCategory())
		{
		case BOOLEAN:
		{
			BooleanObjectInspector boi = (BooleanObjectInspector) poi;
			BooleanWritable r = (BooleanWritable) elements[i];
			r.set(boi.get(o));
			return;
		}
		case BYTE:
		{
			ByteObjectInspector boi = (ByteObjectInspector) poi;
			ByteWritable r = (ByteWritable) elements[i];
			r.set(boi.get(o));
			return;
		}
		case SHORT:
		{
			ShortObjectInspector spoi = (ShortObjectInspector) poi;
			ShortWritable r = (ShortWritable) elements[i];
			r.set(spoi.get(o));
			return;
		}
		case INT:
		{
			IntObjectInspector ioi = (IntObjectInspector) poi;
			IntWritable r = (IntWritable) elements[i];
			r.set(ioi.get(o));
			return;
		}
		case LONG:
		{
			LongObjectInspector loi = (LongObjectInspector) poi;
			LongWritable r = (LongWritable) elements[i];
			r.set(loi.get(o));
			return;
		}
		case FLOAT:
		{
			FloatObjectInspector foi = (FloatObjectInspector) poi;
			FloatWritable r = (FloatWritable) elements[i];
			r.set(foi.get(o));
			return;
		}
		case DOUBLE:
		{
			DoubleObjectInspector doi = (DoubleObjectInspector) poi;
			DoubleWritable r = (DoubleWritable) elements[i];
			r.set(doi.get(o));
			return;
		}
		case STRING:
		{
			StringObjectInspector soi = (StringObjectInspector) poi;
			elements[i] = soi.getPrimitiveWritableObject(o);
			return;
		}
		default:
		{
			throw new RuntimeException("Unsupported type: " + poi.getPrimitiveCategory());
		}
		}
	}


	@Override
	public void write(DataOutput out) throws IOException
	{
		int i = 0;
		for(i=0; i < elements.length - 1; i++)
		{
			elements[i].write(out);
			//type.fieldSep.write(out);
		}
		elements[i].write(out);
	}

	@Override
	public void readFields(DataInput in) throws IOException
	{
		int i = 0;
		//Text t = new Text();
		for(i=0; i < elements.length - 1; i++)
		{
			elements[i].readFields(in);
			//t.readFields(in);
		}
		elements[i].readFields(in);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(CompositeWritable o)
	{
		int cmp = 0;
		int i = 0;
		for(DataType<?> eType : type.elementTypes)
		{
			//elements[i].compareTo(o.elements[i]);
			cmp = eType.cast(elements[i]).compareTo(
					eType.cast(o.elements[i])
					);
			if ( cmp != 0 ) return cmp;
			i++;
		}
		return cmp;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(elements);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeWritable other = (CompositeWritable) obj;
		if (!type.equals(other.type))
			return false;
		if (!Arrays.equals(elements, other.elements))
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		StringBuilder buf = new StringBuilder();
		String sep = type.fieldSep.toString();
		int i = 0;
		for(i=0; i < elements.length - 1; i++)
		{
			buf.append(elements[i]);
			buf.append(sep);
		}
		buf.append(elements[i]);
		
		return buf.toString();
	}
	
}
