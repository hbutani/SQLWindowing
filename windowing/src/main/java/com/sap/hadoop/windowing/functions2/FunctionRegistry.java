package com.sap.hadoop.windowing.functions2;

import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFResolver;

import com.sap.hadoop.windowing.functions2.window.GenericUDAFRowNumber;

@SuppressWarnings("deprecation")
public class FunctionRegistry
{
	static
	{
		org.apache.hadoop.hive.ql.exec.FunctionRegistry.registerGenericUDAF(true, "rowNumber", new GenericUDAFRowNumber());
	}

	public static boolean isWindowFunction(String name)
	{
		 GenericUDAFResolver wfn = org.apache.hadoop.hive.ql.exec.FunctionRegistry.getGenericUDAFResolver(name);  
		 return wfn != null;
	}
}
