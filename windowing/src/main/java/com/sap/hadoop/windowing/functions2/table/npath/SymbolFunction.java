package com.sap.hadoop.windowing.functions2.table.npath;

import java.util.ArrayList;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorConverters;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorConverters.Converter;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.runtime2.PartitionIterator;


public abstract class SymbolFunction
{
	public static class SymbolFunctionResult
	{
		/*
		 * does the row match the pattern represented by this SymbolFunction
		 */
		public boolean matches;
		/*
		 * what is the index of the row beyond the set of rows that match this pattern.
		 */
		public int nextRow;
	}
	
	SymbolFunctionResult result;
	
	public SymbolFunction()
	{
		result = new SymbolFunctionResult();
	}
	
	public static SymbolFunctionResult match(SymbolFunction syFn, Object row, PartitionIterator<Object> pItr) throws WindowingException
	{
		int resetToIdx = pItr.getIndex() - 1;
		try
		{
			return syFn.match(row, pItr);
		}
		finally
		{
			pItr.resetToIndex(resetToIdx);
		}
	}
	
	protected abstract SymbolFunctionResult match(Object row, PartitionIterator<Object> pItr) throws WindowingException;
	
	protected abstract boolean isOptional();
	
	public static class Symbol extends SymbolFunction
	{
		ExprNodeEvaluator symbolExprEval;
		Converter converter;
		
		public Symbol(ExprNodeEvaluator symbolExprEval, ObjectInspector symbolOI)
		{
			this.symbolExprEval = symbolExprEval;
			converter = ObjectInspectorConverters.getConverter(
					symbolOI,
					PrimitiveObjectInspectorFactory.javaBooleanObjectInspector);
		}
		
		protected SymbolFunctionResult match(Object row, PartitionIterator<Object> pItr) throws WindowingException
		{
			Object val = null;
			try
			{
				val = symbolExprEval.evaluate(row);
			}
			catch(HiveException he)
			{
				throw new WindowingException(he);
			}
			val = converter.convert(val);
			result.matches = ((Boolean) val).booleanValue();
			result.nextRow = pItr.getIndex();
			
			return result;
		}
		
		protected boolean isOptional()
		{
			return false;
		}
	}
	
	public static class Star extends SymbolFunction
	{
		SymbolFunction symbolFn;
		
		public Star(SymbolFunction symbolFn)
		{
			this.symbolFn = symbolFn;
		}
		
		protected SymbolFunctionResult match(Object row, PartitionIterator<Object> pItr) throws WindowingException
		{
			result.matches = true;
			SymbolFunctionResult rowResult = symbolFn.match(row, pItr);
			
			while ( rowResult.matches && pItr.hasNext() )
			{
				row = pItr.next();
				rowResult = symbolFn.match(row, pItr);
			}
			
			result.nextRow = pItr.getIndex() - 1;
			return result;
		}
		
		protected boolean isOptional()
		{
			return true;
		}
	}
	
	public static class Plus extends SymbolFunction
	{
		SymbolFunction symbolFn;
		
		public Plus(SymbolFunction symbolFn)
		{
			this.symbolFn = symbolFn;
		}
		
		protected SymbolFunctionResult match(Object row, PartitionIterator<Object> pItr) throws WindowingException
		{
			SymbolFunctionResult rowResult = symbolFn.match(row, pItr);
			
			if ( !rowResult.matches )
			{
				result.matches = false;
				result.nextRow = pItr.getIndex() - 1;
				return result;
			}
			
			result.matches = true;
			while ( rowResult.matches && pItr.hasNext() )
			{
				row = pItr.next();
				rowResult = symbolFn.match(row, pItr);
			}
			
			result.nextRow = pItr.getIndex() - 1;
			return result;
		}
		
		protected boolean isOptional()
		{
			return false;
		}
	}
	
	public static class Chain extends SymbolFunction
	{
		ArrayList<SymbolFunction> components;
		
		public Chain(ArrayList<SymbolFunction> components)
		{
			this.components = components;
		}
		
		/*
		 * Iterate over the Symbol Functions in the Chain:
		 * - If we are not at the end of the Iterator (i.e. row != null )
		 *   - match the current componentFn
		 *   - if it returns false, then return false
		 *   - otherwise set row to the next row  from the Iterator.
		 * - if we are at the end of the Iterator
		 *   - skip any optional Symbol Fns (star patterns) at the end.
		 *   - but if we come to a non optional Symbol Fn, return false.
		 * - if we match all Fns in the chain return true.
		 */
		protected SymbolFunctionResult match(Object row, PartitionIterator<Object> pItr) throws WindowingException
		{
			SymbolFunctionResult componentResult = null;
			for(SymbolFunction sFn : components)
			{
				if ( row != null )
				{
					componentResult = sFn.match(row, pItr);
					if ( !componentResult.matches )
					{
						result.matches = false;
						result.nextRow = componentResult.nextRow;
						return result;
					}
					row = pItr.resetToIndex(componentResult.nextRow);
				}
				else
				{
					if ( !sFn.isOptional() )
					{
						result.matches = false;
						result.nextRow = componentResult.nextRow;
						return result;
					}
				}
			}
			
			result.matches = true;
			result.nextRow = componentResult.nextRow;
			return result;
		}
		
		protected boolean isOptional()
		{
			return false;
		}
	}
}
