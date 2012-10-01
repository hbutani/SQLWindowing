package com.sap.hadoop.windowing.functions2;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.exec.UDFArgumentTypeException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorUtils;

import com.sap.hadoop.windowing.runtime2.PartitionIterator;

public abstract class GenericUDFLeadLag extends GenericUDF
{
	ExprNodeEvaluator exprEvaluator;
	PartitionIterator<Object> pItr;
	
	private PrimitiveObjectInspector amtOI;
	
	@Override
	public Object evaluate(DeferredObject[] arguments) throws HiveException
	{
		Object amt = arguments[1];
		int intAmt = 0;
		try
		{
			intAmt = PrimitiveObjectInspectorUtils.getInt(amt, amtOI);
		}
		catch (NullPointerException e)
		{
			intAmt = Integer.MAX_VALUE;
		}
		catch (NumberFormatException e)
		{
			intAmt = Integer.MAX_VALUE;
		}
		
		int idx = pItr.getIndex() - 1;
		try
		{
			Object row = getRow(intAmt);
			return exprEvaluator.evaluate(row);
		}
		finally
		{
			pItr.resetToIndex(idx);
		}
		
	}

	@Override
	public ObjectInspector initialize(ObjectInspector[] arguments)
			throws UDFArgumentException
	{
		// index has to be a primitive
		if (arguments[1] instanceof PrimitiveObjectInspector)
		{
			amtOI = (PrimitiveObjectInspector) arguments[1];
		}
		else
		{
			throw new UDFArgumentTypeException(1,
					"Primitive Type is expected but "
							+ arguments[1].getTypeName() + "\" is found");
		}
	    
		return arguments[0];
	}
	
	
	
	public ExprNodeEvaluator getArgEvaluator()
	{
		return exprEvaluator;
	}

	public void setArgEvaluator(ExprNodeEvaluator exprEvaluator)
	{
		this.exprEvaluator = exprEvaluator;
	}

	public PartitionIterator<Object> getpItr()
	{
		return pItr;
	}

	public void setpItr(PartitionIterator<Object> pItr)
	{
		this.pItr = pItr;
	}

	@Override
	public String getDisplayString(String[] children)
	{
		assert (children.length == 2);
		StringBuilder sb = new StringBuilder();
		sb.append(_getFnName());
		sb.append("(");
		sb.append(children[0]);
		sb.append(", ");
		sb.append(children[1]);
		sb.append(")");
		return sb.toString();
	}

	protected abstract String _getFnName();
	
	protected abstract Object getRow(int amt);
	
	public static class GenericUDFLead extends GenericUDFLeadLag
	{

		@Override
		protected String _getFnName()
		{
			return "lead";
		}

		@Override
		protected Object getRow(int amt)
		{
			return pItr.getIndex() - 1 + amt;
		}
		
	}
	
	public static class GenericUDFLag extends GenericUDFLeadLag
	{

		@Override
		protected String _getFnName()
		{
			return "lag";
		}

		@Override
		protected Object getRow(int amt)
		{
			return pItr.getIndex() - 1 - amt;
		}
		
	}

}
