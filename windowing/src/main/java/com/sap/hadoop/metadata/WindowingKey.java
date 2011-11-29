package com.sap.hadoop.metadata;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


/**
 * 
 * This one will not work because Text columns embed the size at the beginning of their byte representation. So comparing bytes causes 
 * longer Strings to sort later than shorter strings.
 * @author I821656
 *
 */
public class WindowingKey implements WritableComparable<WindowingKey>
{
	BytesWritable partitionValue;
	BytesWritable sortValue;
	
	public WindowingKey()
	{
		super();
		partitionValue = new BytesWritable();
		sortValue = new BytesWritable();
	}

	public BytesWritable getPartitionValue()
	{
		return partitionValue;
	}


	public void setPartitionValue(BytesWritable partitionValue)
	{
		this.partitionValue = partitionValue;
	}


	public BytesWritable getSortValue()
	{
		return sortValue;
	}


	public void setSortValue(BytesWritable sortValue)
	{
		this.sortValue = sortValue;
	}
	
	/**
	 * for test purpose only
	 * @return
	 */
	byte[] getBytes()
	{
		int pSz = toInt(partitionValue.getBytes(), 0);
		int sSz = toInt(sortValue.getBytes(), 0);
		byte[] buf = new byte[4 + pSz + 4 + sSz];
		System.arraycopy(partitionValue.getBytes(), 0, buf, 0, 4 + pSz);
		System.arraycopy(sortValue.getBytes(), 0, buf, 4 + pSz, 4 + sSz);
		return buf;
	}


	@Override
	public void write(DataOutput out) throws IOException
	{
		partitionValue.write(out);
		sortValue.write(out);
	}
	
	public void readFields(DataInput in) throws IOException
	{
		partitionValue.readFields(in);
		sortValue.readFields(in);
	}


	@Override
	public int compareTo(WindowingKey o)
	{
		int c = partitionValue.compareTo(o.partitionValue);
		if ( c == 0)
			c = sortValue.compareTo(o.sortValue);
		return c;
	}
	
	@Override
	public String toString()
	{
		return "" + partitionValue.toString() + ": " + sortValue.toString();
	}
	

	public static class Comparator extends WritableComparator
	{

		public Comparator()
		{
			super(WindowingKey.class);
		}

		@Override
		public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2)
		{
			int pSz1 = toInt(b1, s1);
			int pSz2 = toInt(b2, s2);
			int c = compareBytes(b1, s1 + 4, pSz1, b2, s2 + 4, pSz2);
			if ( c != 0 ) return c;
			
			int sSz1 = toInt(b1, s1+4+pSz1);
			int sSz2 = toInt(b2, s2+4+pSz2);
			c = compareBytes(b1, s1 + 4 + pSz1 + 4, sSz1, b2, s2 + 4 + pSz2 +4, sSz2);
			return c;
		}
	}

	static
	{
		WritableComparator.define(WindowingKey.class, new Comparator());
	}
	
	static int toInt(byte[] buf, int i)
	{
		return ((0xFF & buf[i]) << 24) | ((0xFF & buf[i + 1]) << 16)
				| ((0xFF & buf[i + 2]) << 8) | (0xFF & buf[i + 3]);

	}

}

