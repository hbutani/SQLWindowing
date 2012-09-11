package com.sap.hadoop.windowing.functions2;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.hadoop.hive.ql.exec.FunctionInfo;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFResolver;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.annotation.TableFuncDef;
import com.sap.hadoop.windowing.functions2.annotation.WindowFuncDef;
import com.sap.hadoop.windowing.functions2.window.GenericUDAFCumeDist;
import com.sap.hadoop.windowing.functions2.window.GenericUDAFDenseRank;
import com.sap.hadoop.windowing.functions2.window.GenericUDAFFirstValue;
import com.sap.hadoop.windowing.functions2.window.GenericUDAFLastValue;
import com.sap.hadoop.windowing.functions2.window.GenericUDAFNTile;
import com.sap.hadoop.windowing.functions2.window.GenericUDAFPercentRank;
import com.sap.hadoop.windowing.functions2.window.GenericUDAFRank;
import com.sap.hadoop.windowing.functions2.window.GenericUDAFRowNumber;

import com.sap.hadoop.windowing.functions2.table.Noop.NoopResolver;
import com.sap.hadoop.windowing.functions2.table.NoopWithMap.NoopWithMapResolver;
import com.sap.hadoop.windowing.functions2.table.WindowingTableFunction.WindowingTableFunctionResolver;

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
		registerWindowFunction("first_value", new GenericUDAFFirstValue());
		registerWindowFunction("last_value", new GenericUDAFLastValue());
	}

	public static boolean isWindowFunction(String name)
	{
		 WindowFunctionInfo wFInfo = windowFunctions.get(name.toLowerCase());
		 return wFInfo != null;
	}
	
	public static WindowFunctionInfo getWindowFunctionInfo(String name)
	{
		return windowFunctions.get(name.toLowerCase());
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
	
	public static class WindowFunctionInfo
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

		public boolean isSupportsWindow()
		{
			return supportsWindow;
		}

		public boolean isPivotResult()
		{
			return pivotResult;
		}

		public FunctionInfo getfInfo()
		{
			return fInfo;
		}
	}
	
	public static final String WINDOWING_TABLE_FUNCTION = "windowingtablefunction";
	public static final String NOOP_TABLE_FUNCTION = "noop";
	
	static Map<String, TableFunctionInfo> tableFunctions = Collections.synchronizedMap(new LinkedHashMap<String, TableFunctionInfo>());
	
	static
	{
		registerTableFunction(NOOP_TABLE_FUNCTION, NoopResolver.class);
		registerTableFunction("noopwithmap", NoopWithMapResolver.class);
		registerTableFunction(WINDOWING_TABLE_FUNCTION,  WindowingTableFunctionResolver.class);
	}
	
	public static boolean isTableFunction(String name)
	{
		TableFunctionInfo tFInfo = tableFunctions.get(name.toLowerCase());
		 return tFInfo != null && !tFInfo.isInternal();
	}
	
	public static TableFunctionResolver getTableFunctionResolver(String name) throws WindowingException
	{
		TableFunctionInfo tfInfo = tableFunctions.get(name.toLowerCase());
		try
		{
			return tfInfo != null ? tfInfo.getFunctionResolver().newInstance() : null;
		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
	}
	
	public static TableFunctionResolver getWindowingTableFunction() throws WindowingException
	{
		return getTableFunctionResolver(WINDOWING_TABLE_FUNCTION);
	}
	
	public static TableFunctionResolver getNoopTableFunction() throws WindowingException
	{
		return getTableFunctionResolver(NOOP_TABLE_FUNCTION);
	}
	
	public static void registerTableFunction(String name, Class<? extends TableFunctionResolver> tFnCls)
	{
		TableFunctionInfo tInfo = new TableFunctionInfo(name, tFnCls);
		tableFunctions.put(name.toLowerCase(), tInfo);
	}
	
	static class TableFunctionInfo
	{
		String displayName;
		Class<? extends TableFunctionResolver>  functionResolver;
		boolean isInternal;
		
		public TableFunctionInfo(String displayName, Class<? extends TableFunctionResolver> tFnCls)
		{
			super();
			this.displayName = displayName;
			this.functionResolver = tFnCls;
			isInternal = false;
			TableFuncDef def = functionResolver.getAnnotation(TableFuncDef.class);
			if ( def != null)
			{
				isInternal = def.isInternal();
			}
		}

		public String getDisplayName()
		{
			return displayName;
		}

		public Class<? extends TableFunctionResolver> getFunctionResolver()
		{
			return functionResolver;
		}

		public boolean isInternal()
		{
			return isInternal;
		} 
		
	}
}
