package com.sap.hadoop.windowing.functions

import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions.annotations.FunctionDef;
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
	
	abstract protected IPartition execute(IPartition inpPart) throws WindowingException;
	
	abstract Map<String, TypeInfo> getOutputShape();
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