package com.sap.hadoop.ds.streams;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferInputStream extends InputStream
{
	ByteBuffer buffer;
	int mark = -1;
	
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
	public int read() throws IOException
	{
		return buffer.hasRemaining() ? (buffer.get() & 0xff) : -1;
	}
	
	@Override
	public int read(byte b[], int off, int len) throws IOException
	{
		int remaining = buffer.remaining();
		len= len <= remaining ? len : remaining;
		buffer.get(b, off, len);
		return len;
	}
	
	public boolean markSupported() { return true; }
	
	public void mark(int readAheadLimit)
	{
		mark = buffer.position();
	}

	public void reset()
	{
		if ( mark == -1 ) throw new IllegalStateException();
		buffer.position(mark);
		mark = -1;
	}
}
