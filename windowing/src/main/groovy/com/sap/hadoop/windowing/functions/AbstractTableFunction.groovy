package com.sap.hadoop.windowing.functions

import groovy.lang.GroovyShell;

import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
import com.sap.hadoop.windowing.query.FuncSpec;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.Window;
import com.sap.hadoop.windowing.runtime.IPartition;
import com.sap.hadoop.windowing.runtime.IPartitionIterator;

abstract class AbstractTableFunction implements IPartitionIterator
{
	IPartitionIterator input;
	Window window
	
	AbstractTableFunction()
	{
	}
	
	boolean hasNext()
	{
		return input.hasNext();
	}
	
	IPartition next()
	{
		try
		{
			return execute(input.next());
		}
		catch(WindowingException we)
		{
			throw new RuntimeException(we);
		}
	}
	
	void remove() { input.remove(); }
	
	protected void completeTranslation(GroovyShell wshell, Query qry, FuncSpec funcSpec) throws WindowingException
	{
	}
	
	abstract protected IPartition execute(IPartition inpPart) throws WindowingException;
	
	abstract Map<String, TypeInfo> getOutputShape();
	
	public boolean hasMapPhase() { return false; }
	
	protected IPartition mapExecute(IPartition inpPart) throws WindowingException
	{
		throw new WindowingException("Function's Map Execution not implemented)");
	}
	
	public Map<String, TypeInfo> getMapPhaseOutputShape()
	{
		throw new WindowingException("Function's 'getMapPhaseOutputShape' method not implemented)");
	}
}

@FunctionDef(
	name = "noop",
	supportsWindow = true,
	args = [],
	description = "test function"
)
class Noop extends AbstractTableFunction
{
	protected IPartition execute(IPartition inpPart) throws WindowingException
	{
		return inpPart;
	}
	
	Map<String, TypeInfo> getOutputShape()
	{
		if ( input == null || ! (input instanceof AbstractTableFunction))
		{
			return null;
		}
		return ((AbstractTableFunction)input).getOutputShape();
	}
}