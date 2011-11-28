package com.sap.hadoop.metadata;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

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
