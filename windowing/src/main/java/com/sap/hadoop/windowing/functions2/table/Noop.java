package com.sap.hadoop.windowing.functions2.table;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.functions2.TableFunctionResolver;
import com.sap.hadoop.windowing.runtime2.Partition;

public class Noop extends TableFunctionEvaluator
{
	
	@Override
	public Partition execute(Partition iPart) throws WindowingException
	{
		return iPart;
	}


	public static class NoopResolver extends TableFunctionResolver
	{

		@Override
		protected void setupOI() throws WindowingException
		{
			OI = tDef.getInput().getOI();
		}

		@Override
		public TableFunctionEvaluator setupEvaluator()
		{
			return new Noop();
		}
		
	}

}
