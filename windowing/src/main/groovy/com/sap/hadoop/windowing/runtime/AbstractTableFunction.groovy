package com.sap.hadoop.windowing.runtime

import com.sap.hadoop.windowing.WindowingException;

abstract class AbstractTableFunction implements IPartitionIterator
{
	IPartitionIterator input;
	
	AbstractTableFunction(IPartitionIterator input)
	{
		this.input = input;
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
	
	abstract protected IPartition execute(IPartition inpPart) throws WindowingException;
}
