package com.sap.hadoop.ds.list;

import java.lang.reflect.Constructor;

import com.sap.hadoop.windowing.WindowingException;

public class ListFactory
{
	@SuppressWarnings("unchecked")
	public static ByteBasedList createList(String clsName, int capacity) throws WindowingException
	{
		try
		{
			Class<? extends ByteBasedList> cls = (Class<? extends ByteBasedList>) Class.forName(clsName);
			Constructor<? extends ByteBasedList> cons = cls.getConstructor(Integer.TYPE);
			return cons.newInstance(capacity);
		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
	}
}
