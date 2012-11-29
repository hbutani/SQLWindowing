package com.sap.hadoop.windowing.functions2.table;

import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.functions2.TableFunctionResolver;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.runtime2.Partition;

public class NoopWithMap extends Noop
{
	@Override
	public Partition execute(Partition iPart) throws WindowingException
	{
		return iPart;
	}

	@Override
	protected Partition _transformRawInput(Partition iPart) throws WindowingException
	{
		return iPart;
	}

	public static class NoopWithMapResolver extends TableFunctionResolver
	{

		@Override
		protected TableFunctionEvaluator createEvaluator(QueryDef qDef, TableFuncDef tDef)
		{
			return new NoopWithMap();
		}

		@Override
		public void setupOutputOI() throws WindowingException
		{
			StructObjectInspector OI = getEvaluator().getTableDef().getInput().getOI();
			setOutputOI(OI);
		}
		
		@Override
		public void setupRawInputOI() throws WindowingException
		{
			StructObjectInspector OI = getEvaluator().getTableDef().getInput().getOI();
			setRawInputOI(OI);
		}

		@Override
		public boolean transformsRawInput()
		{
			return true;
		}
		
	}


}
