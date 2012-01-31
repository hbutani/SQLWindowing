package com.sap.hadoop.ds.streams;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Streams
{
	public static ThreadLocal<ByteArrayIS> bis = new ThreadLocal<ByteArrayIS>()
	{
		protected ByteArrayIS initialValue()
		{
			return new ByteArrayIS();
		}
	};
	
	public static ThreadLocal<DataIStream> dis = new ThreadLocal<DataIStream>()
	{
		protected DataIStream initialValue()
		{
			return new DataIStream(bis.get());
		}
	};
	
	public static ThreadLocal<ByteArrayOS> bos = new ThreadLocal<ByteArrayOS>()
	{
		protected ByteArrayOS initialValue()
		{
			return new ByteArrayOS();
		}
	};
	
	public static ThreadLocal<DataOStream> dos = new ThreadLocal<DataOStream>()
	{
		protected DataOStream initialValue()
		{
			return new DataOStream(bos.get());
		}
	};
	
	
	public static class DataIStream extends DataInputStream
	{
		public DataIStream(ByteArrayIS in)
		{
			super(in);
		}

		public ByteArrayIS getUnderlyingStream() { return (ByteArrayIS) in; }
	}
	
	public static class DataOStream extends DataOutputStream
	{
		public DataOStream(ByteArrayOS out)
		{
			super(out);
		}

		public ByteArrayOS getUnderlyingStream() { return (ByteArrayOS) out; }
	}
	
	public static class ByteArrayOS extends ByteArrayOutputStream
	{
		public ByteArrayOS() { super(); }
		public ByteArrayOS(int size) { super(size); }
		public final byte[] bytearray() { return buf; }
		public final int len() { return count; }
		
	}
	
	public static class ByteArrayIS extends ByteArrayInputStream
	{
		public ByteArrayIS() { super(new byte[0]); }
		public final byte[] bytearray() { return buf; }
		public final void setBuffer(byte[] buf, int offset, int len)
		{
			this.buf = buf;
	        this.pos = offset;
	        this.count = Math.min(offset + len, buf.length);
	        this.mark = offset;
		}
		
	}
	
}
