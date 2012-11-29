package com.sap.hadoop.windowing.functions2.table;

import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.functions2.TableFunctionResolver;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.runtime2.Partition;
import com.sap.hadoop.windowing.runtime2.PartitionIterator;

public class Noop extends TableFunctionEvaluator
{
	
	@Override
	public Partition execute(Partition iPart) throws WindowingException
	{
		return iPart;
	}
	
	protected void execute(PartitionIterator<Object> pItr, Partition oPart)
	{
		throw new UnsupportedOperationException();
	}
	
	public static class NoopResolver extends TableFunctionResolver
	{

		@Override
		protected TableFunctionEvaluator createEvaluator(QueryDef qDef, TableFuncDef tDef)
		{
			return new Noop();
		}

		@Override
		public void setupOutputOI() throws WindowingException
		{
			StructObjectInspector OI = getEvaluator().getTableDef().getInput().getOI();
			setOutputOI(OI);
		}

		@Override
		public boolean transformsRawInput()
		{
			return false;
		}
		
	}

}
