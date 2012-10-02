package com.sap.hadoop;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

import javax.swing.JTextField;

import org.apache.hadoop.hive.serde.Constants;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe;

import com.google.common.base.Preconditions;
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
    
    //copied completely from guavar09 source
    /**
     * Deletes a file or directory and all contents recursively.
     *
     * <p>If the file argument is a symbolic link the link will be deleted
     * but not the target of the link. If the argument is a directory,
     * symbolic links within the directory will not be followed.
     *
     * @param file the file to delete
     * @throws IOException if an I/O error occurs
     * @see #deleteDirectoryContents
     */
    public static void deleteRecursively(File file) throws IOException {
      if (file.isDirectory()) {
        deleteDirectoryContents(file);
      }
      if (!file.delete()) {
        throw new IOException("Failed to delete " + file);
      }
    }

//copied completely from guavar09 source
    /**
     * Deletes all the files within a directory. Does not delete the
     * directory itself.
     *
     * <p>If the file argument is a symbolic link or there is a symbolic
     * link in the path leading to the directory, this method will do
     * nothing. Symbolic links within the directory are not followed.
     *
     * @param directory the directory to delete the contents of
     * @throws IllegalArgumentException if the argument is not a directory
     * @throws IOException if an I/O error occurs
     * @see #deleteRecursively
     */
    public static void deleteDirectoryContents(File directory)
        throws IOException {
      Preconditions.checkArgument(directory.isDirectory(),
          "Not a directory: %s", directory);
      // Symbolic links will have different canonical and absolute paths
      if (!directory.getCanonicalPath().equals(directory.getAbsolutePath())) {
        return;
      }
      File[] files = directory.listFiles();
      if (files == null) {
        throw new IOException("Error listing files for " + directory);
      }
      for (File file : files) {
        deleteRecursively(file);
      }
    }
    
    public static void makeTransient(Class<?> beanClass, String pdName){
		BeanInfo info;
		try {
			info = Introspector.getBeanInfo(beanClass);
			PropertyDescriptor[] propertyDescriptors =
	                info.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; ++i) {
				PropertyDescriptor pd = propertyDescriptors[i];
				if (pd.getName().equals(pdName)) {
					pd.setValue("transient", Boolean.TRUE);
				}
			}
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
