package com.sap.hadoop.windowing.functions2;

import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFResolver;

@SuppressWarnings("deprecation")
public class FunctionRegistry
{

	public static boolean isWindowFunction(String name)
	{
		 GenericUDAFResolver wfn = org.apache.hadoop.hive.ql.exec.FunctionRegistry.getGenericUDAFResolver(name);  
		 return wfn != null;
	}
}
