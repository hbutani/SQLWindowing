package com.sap.hadoop.windowing.functions2.table;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.functions2.TableFunctionResolver;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.runtime2.Partition;

public class Noop extends TableFunctionEvaluator
{
	
	@Override
	public Partition execute(Partition iPart) throws WindowingException
	{
		return iPart;
	}
	
	@Override
	public void setupOI() throws WindowingException
	{
		OI = tDef.getInput().getOI();
	}


	public static class NoopResolver extends TableFunctionResolver
	{

		@Override
		protected TableFunctionEvaluator createEvaluator(QueryDef qDef, TableFuncDef tDef)
		{
			return new Noop();
		}
		
	}

}
