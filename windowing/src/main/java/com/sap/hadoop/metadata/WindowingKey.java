package com.sap.hadoop.metadata;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.hive.ql.io.HiveKey;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


public class WindowingKey implements WritableComparable<WindowingKey>
{
	private static final Log LOG = LogFactory.getLog(WindowingKey.class);
	protected static final int LENGTH_BYTES = 8;
	private static final byte[] EMPTY_BYTES = {};

	private int size;
	private int grpSize;
	private byte[] bytes;

	public WindowingKey()
	{
		bytes = EMPTY_BYTES;
		size = 0;
		grpSize = 0;
	}

	public byte[] getBytes()
	{
		return bytes;
	}

	public int getLength()
	{
		return size;
	}

	protected final void setSize(int size)
	{
		if (size > getCapacity())
		{
			setCapacity(size * 3 / 2);
		}
		this.size = size;
	}

	private int getCapacity()
	{
		return bytes.length;
	}

	private void setCapacity(int new_cap)
	{
		byte[] new_data = new byte[new_cap];
		if (size != 0)
		{
			System.arraycopy(bytes, 0, new_data, 0, size);
		}
		bytes = new_data;
	}

	protected final void setGroupSize(int grpSize)
	{
		this.grpSize = grpSize;
	}

	protected void set(byte[] newData, int offset, int length, int grpSize)
	{
		//setSize(0);
		setSize(length);
		System.arraycopy(newData, offset, bytes, 0, size);
		setGroupSize(grpSize);
	}
	
	protected final void unchecked_set(byte[] data, int length, int grpSize)
	{
		bytes = data;
		size = length;
		this.grpSize = grpSize;
	}

	public void readFields(DataInput in) throws IOException
	{
		//setSize(0); // clear the old data
		setSize(in.readInt());
		setGroupSize(in.readInt());
		in.readFully(bytes, 0, size);
	}

	public void write(DataOutput out) throws IOException
	{
		out.writeInt(size);
		out.writeInt(grpSize);
		out.write(bytes, 0, size);
	}
	
	@Override
	public int compareTo(WindowingKey wKey)
	{
		return comparator.compare(getBytes(), 0, getLength(), wKey.getBytes(), 0, wKey.getLength());
	}
	
	public int compareToGroup(WindowingKey wKey)
	{
		return WritableComparator.compareBytes(getBytes(), 0, grpSize, wKey.getBytes(), 0, wKey.grpSize);
	}

	
	boolean hashCodeValid;
	protected int myHashCode;

	public void setHashCode(int myHashCode)
	{
		hashCodeValid = true;
		this.myHashCode = myHashCode;
	}

	@Override
	public int hashCode()
	{
		if (!hashCodeValid)
		{
			throw new RuntimeException(
					"Cannot get hashCode() from deserialized " + HiveKey.class);
		}
		return myHashCode;
	}
	
	public boolean equals(Object right_obj)
	{
		if (right_obj instanceof WindowingKey)
			return super.equals(right_obj);
		return false;
	}

	/**
	 * Generate the stream of bytes as hex pairs separated by ' '.
	 */
	public String toString()
	{
		StringBuffer sb = new StringBuffer(3 * size);
		for (int idx = 0; idx < size; idx++)
		{
			// if not the first, put a blank separator in
			if (idx != 0)
			{
				sb.append(' ');
			}
			String num = Integer.toHexString(0xff & bytes[idx]);
			// if it is only one digit, add a leading 0.
			if (num.length() < 2)
			{
				sb.append('0');
			}
			sb.append(num);
		}
		return sb.toString();
	}
	
	public static class Comparator extends WritableComparator
	{
		public Comparator()
		{
			super(WindowingKey.class);
		}

		/**
		 * Compare the buffers in serialized form.
		 */
		public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2)
		{
			return compareBytes(b1, s1 + LENGTH_BYTES, l1 - LENGTH_BYTES, b2,
					s2 + LENGTH_BYTES, l2 - LENGTH_BYTES);
		}
	}

	private static Comparator comparator = new Comparator();
	static
	{ // register this comparator
		WritableComparator.define(WindowingKey.class, comparator);
	}

}
