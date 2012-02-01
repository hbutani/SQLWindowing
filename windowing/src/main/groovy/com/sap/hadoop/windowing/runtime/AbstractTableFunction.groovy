package com.sap.hadoop.windowing.runtime

import com.sap.hadoop.windowing.WindowingException;

abstract class AbstractTableFunction implements IPartitionIterator
{
	IPartitionIterator input;
	
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
}
