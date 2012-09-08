package com.sap.hadoop.windowing.functions2.table;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.functions2.TableFunctionResolver;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.runtime2.Partition;

public class NoopWithMap extends Noop
{
	@Override
	public void setupOI() throws WindowingException
	{
		OI = tDef.getInput().getOI();
	}
	
	@Override
	public void setupMapOI() throws WindowingException
	{
		mapOI = tDef.getInput().getOI();
	}
	
	@Override
	public Partition execute(Partition iPart) throws WindowingException
	{
		return iPart;
	}

	@Override
	protected Partition _mapExecute(Partition iPart) throws WindowingException
	{
		return iPart;
	}

	public static class NoopWithMapResolver extends TableFunctionResolver
	{

		@Override
		protected void setHasMapPhase() throws WindowingException
		{
			hasMapPhase = true;
		}
		


		@Override
		protected TableFunctionEvaluator createEvaluator(QueryDef qDef, TableFuncDef tDef)
		{
			return new NoopWithMap();
		}
		
	}


}
