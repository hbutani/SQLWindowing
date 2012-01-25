package com.sap.hadoop.ds.streams;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class ByteBufferOutputStream extends OutputStream
{
	ByteBuffer buffer;
	
	public void intialize(ByteBuffer buffer)
	{
		this.buffer = buffer;
	}
	
	public void intialize(ByteBuffer buffer, int off, int len)
	{
		buffer = buffer.duplicate();
		buffer.position(off);
		buffer.limit(off + len);
		this.buffer = buffer.slice();
	}

	@Override
	public void write(int b) throws IOException
	{
		buffer.put((byte) b);	
	}
	
	public void write(byte b[], int off, int len)
	{
		int remaining = buffer.remaining();
		if ( len > remaining )
		{
			throw new IndexOutOfBoundsException();
		}
		buffer.put(b, off, len);
	}
}
