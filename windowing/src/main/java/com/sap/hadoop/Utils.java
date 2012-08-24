package com.sap.hadoop;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

import org.apache.hadoop.hive.serde.Constants;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe;

import com.sap.hadoop.ds.BaseException;

public class Utils
{
    public static String sprintf(String format, Object... values)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        out.printf(format, values);
        return outputStream.toString();
    }
    
    
    public static LazySimpleSerDe createLazySimpleSerDe(String columns, String types, String fieldDelim) throws BaseException
    {
    	try
    	{
	    	Properties p = new Properties();
	    	p.put(Constants.FIELD_DELIM, fieldDelim);
	    	p.put(Constants.LIST_COLUMNS, columns);
	    	p.put(Constants.LIST_COLUMN_TYPES, types);
	    	LazySimpleSerDe sd = new LazySimpleSerDe();
	    	sd.initialize(null, p);
	    	return sd;
    	}
    	catch(SerDeException se)
    	{
    		throw new BaseException(se);
    	}
    }
    
    public static String toString(List<?> col)
    {
    	StringBuilder buf = new StringBuilder();
    	buf.append("[");
    	boolean first = true;
    	for(Object o : col)
    	{
    		if ( first )
    			first = false;
    		else
    			buf.append(", ");
    		buf.append(o.toString());
    	}
    	buf.append("]");
    	return buf.toString();
    }
    
    public static String toString(Map<?, ?> col)
    {
    	StringBuilder buf = new StringBuilder();
    	buf.append("[");
    	boolean first = true;
    	for(Map.Entry<?, ?> o : col.entrySet())
    	{
    		if ( first )
    			first = false;
    		else
    			buf.append(", ");
    		buf.append(o.getKey().toString()).
    				append(" : ").
    				append(o.getValue().toString());
    	}
    	buf.append("]");
    	return buf.toString();
    }
    
    public static class ReverseIterator<T> implements Iterator<T>
    {
    	Stack<T> stack;
    	
    	public ReverseIterator(Iterator<T> it)
    	{
    		stack = new Stack<T>();
    		while(it.hasNext())
    		{
    			stack.push(it.next());
    		}
    	}

		@Override
		public boolean hasNext()
		{
			return !stack.isEmpty();
		}

		@Override
		public T next()
		{
			return stack.pop();
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
    }
    
    public static abstract class Predicate<T>
    {
    	public abstract boolean apply(T obj);
    };

}
