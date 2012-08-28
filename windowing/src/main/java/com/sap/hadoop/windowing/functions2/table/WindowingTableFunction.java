package com.sap.hadoop.windowing.functions2.table;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.functions2.TableFunctionResolver;
import com.sap.hadoop.windowing.runtime2.Partition;

public class WindowingTableFunction extends TableFunctionEvaluator
{

	@Override
	public Partition execute(Partition iPart) throws WindowingException
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public static class WindowingTableFunctionResolver extends TableFunctionResolver
	{

		@Override
		protected void setupOI() throws WindowingException
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		protected TableFunctionEvaluator setupEvaluator()
		{
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
