package com.sap.hadoop.windowing.functions2;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.hadoop.hive.ql.exec.FunctionInfo;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFResolver;

import com.sap.hadoop.windowing.functions2.annotation.WindowFuncDef;
import com.sap.hadoop.windowing.functions2.window.GenericUDAFCumeDist;
import com.sap.hadoop.windowing.functions2.window.GenericUDAFDenseRank;
import com.sap.hadoop.windowing.functions2.window.GenericUDAFNTile;
import com.sap.hadoop.windowing.functions2.window.GenericUDAFPercentRank;
import com.sap.hadoop.windowing.functions2.window.GenericUDAFRank;
import com.sap.hadoop.windowing.functions2.window.GenericUDAFRowNumber;

@SuppressWarnings("deprecation")
public class FunctionRegistry
{
	static org.apache.hadoop.hive.ql.exec.FunctionRegistry HiveFR  = null;
	
	static Map<String, WindowFunctionInfo> windowFunctions = Collections.synchronizedMap(new LinkedHashMap<String, WindowFunctionInfo>());
	
	static
	{
		registerHiveUDAFsAsWindowFunctions();
		registerWindowFunction("rownumber", new GenericUDAFRowNumber());
		registerWindowFunction("rank", new GenericUDAFRank());
		registerWindowFunction("denserank", new GenericUDAFDenseRank());
		registerWindowFunction("percentrank", new GenericUDAFPercentRank());
		registerWindowFunction("cumedist", new GenericUDAFCumeDist());
		registerWindowFunction("ntile", new GenericUDAFNTile());
	}

	public static boolean isWindowFunction(String name)
	{
		 WindowFunctionInfo wFInfo = windowFunctions.get(name.toLowerCase());
		 return wFInfo != null;
	}
	
	@SuppressWarnings("static-access")
	static void registerHiveUDAFsAsWindowFunctions()
	{
		Set<String> fNames = HiveFR.getFunctionNames();
		for(String fName : fNames)
		{
			FunctionInfo fInfo = HiveFR.getFunctionInfo(fName);
			if ( fInfo.isGenericUDAF())
			{
				WindowFunctionInfo wInfo = new WindowFunctionInfo(fInfo);
				windowFunctions.put(fName, wInfo);
			}
		}
	}
	
	@SuppressWarnings("static-access")
	public static void registerWindowFunction(String name, GenericUDAFResolver wFn)
	{
		HiveFR.registerGenericUDAF(true, name, wFn);
		FunctionInfo fInfo = HiveFR.getFunctionInfo(name);
		WindowFunctionInfo wInfo = new WindowFunctionInfo(fInfo);
		windowFunctions.put(name.toLowerCase(), wInfo);
	}
	
	static class WindowFunctionInfo
	{
		boolean supportsWindow = true;
		boolean pivotResult = false;
		FunctionInfo fInfo;
		
		WindowFunctionInfo(FunctionInfo fInfo)
		{
			assert fInfo.isGenericUDAF();
			this.fInfo = fInfo;
			Class<? extends GenericUDAFResolver> wfnCls = fInfo.getGenericUDAFResolver().getClass();
			WindowFuncDef def = wfnCls.getAnnotation(WindowFuncDef.class);
			if ( def != null)
			{
				supportsWindow = def.supportsWindow();
				pivotResult = def.pivotResult();
			}
		}
	}
}
