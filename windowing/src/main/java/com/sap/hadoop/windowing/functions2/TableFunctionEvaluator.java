package com.sap.hadoop.windowing.functions2;

import static com.sap.hadoop.Utils.sprintf;

import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.runtime2.Partition;

/**
 * Based on Hive {@link GenericUDAFEvaluator}. Break up the responsibility of the old AsbtractTableFunction class into a Resolver and Evaluator.
 * 
 *
 */
public abstract class TableFunctionEvaluator
{
	protected TableFunctionResolver resolver;
	
	public abstract Partition execute(Partition iPart) throws WindowingException;

	public TableFunctionResolver getResolver()
	{
		return resolver;
	}

	public void setResolver(TableFunctionResolver resolver)
	{
		this.resolver = resolver;
	}
	
	public Partition mapExecute(Partition iPart) throws WindowingException
	{
		if ( !resolver.hasMapPhase())
		{
			throw new WindowingException(sprintf("Internal Error: mapExecute called on function (%s)that has no Map Phase", resolver.tDef.getName()));
		}
		return _mapExecute(iPart);
	}
	
	protected Partition _mapExecute(Partition iPart) throws WindowingException
	{
		return null;
	}
}
