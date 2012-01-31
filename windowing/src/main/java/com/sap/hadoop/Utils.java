package com.sap.hadoop;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Properties;

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

}
