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

/**
 * A Table Function instance is associated with information on how input data should be partitioned and ordered.
 * Each ordered partition is provided to an instance of this Function,  instance is responsible for outputting 
 * a {@link IPartition} given an input Partition. 
 * <p>
 * A Function may also specify that it wants to operate on(map) the raw input data (before it is partitioned and ordered).
 * The Function is free to reshape the data in any way, hence it is responsible for providing the Output Shape 
 * (as a name -> TypeInfo map). If the function operates on raw data, again it is free to alter it in any fashion; 
 * but it is responsible for providing the Output Shape of the Map operation.
 * 
 * @author harish.butani
 *
 */
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
	
	/**
	 * callback used by translation mechanics to introspect on function's output.
	 * @return
	 */
	abstract Map<String, TypeInfo> getOutputShape();
	
	public boolean hasMapPhase() { return false; }
	
	protected IPartition mapExecute(IPartition inpPart) throws WindowingException
	{
		throw new WindowingException("Function's Map Execution not implemented)");
	}
	
	/**
	 * callback used by translation mechanics to introspect on function's output at Map Stage.
	 * @return
	 */
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