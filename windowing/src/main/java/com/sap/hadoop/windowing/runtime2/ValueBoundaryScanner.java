package com.sap.hadoop.windowing.runtime2;

import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorUtils;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.ValueBoundaryDef;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.BoundarySpec;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.Direction;

/*
 * - starting from the given rowIdx scan in the given direction until a row's expr
 * evaluates to an amt that crosses the 'amt' threshold specified in the ValueBoundaryDef.
 */
public abstract class ValueBoundaryScanner
{
	ValueBoundaryDef bndDef;
	
	public ValueBoundaryScanner(ValueBoundaryDef bndDef)
	{
		this.bndDef = bndDef;
	}
	
	/*
	 * return the other end of the Boundary
	 * - when scanning backwards: go back until you reach a row where the
	 * startingValue - rowValue >= amt
	 * - when scanning forward:  go forward go back until you reach a row where the
	 *  rowValue - startingValue >= amt
	 */
	public int computeBoundaryRange(int rowIdx, Partition p) throws WindowingException
	{
		int r = rowIdx;
		Object rowValue = computeValue(p.getAt(r));
		int amt = bndDef.getAmt();
		
		if ( amt == BoundarySpec.UNBOUNDED_AMOUNT )
		{
			return bndDef.getDirection() == Direction.PRECEDING ? 0 : p.size();
		}
		
		Direction d = bndDef.getDirection();
		boolean scanNext = rowValue != null;
		r = d == Direction.FOLLOWING ? r-- : r++;
		while ( scanNext )
		{
			if ( r < 0 || r >= p.size() )
			{
				scanNext = false;
				break;
			}
			
			Object currVal = computeValue(p.getAt(rowIdx));
			if ( currVal == null )
			{
				scanNext = false;
				break;
			}
			
			switch(d)
			{
			case PRECEDING:
				scanNext = isGreater(rowValue, currVal, amt);
				r--;
			break;
			case FOLLOWING:
				scanNext = isGreater(currVal, rowValue, amt);
				r++;
			}
		}
		r = r < 0 ? 0 : (r >= p.size() ? p.size() : r);
		return r;
	}
	
	public Object computeValue(Object row) throws WindowingException
	{
		try
		{
			return bndDef.getExprEvaluator().evaluate(row);
		}
		catch(HiveException he)
		{
			throw new WindowingException(he);
		}
	}
	
	public abstract boolean isGreater(Object v1, Object v2, int amt);
	
	public static class LongValueBoundaryScanner extends ValueBoundaryScanner
	{
		public LongValueBoundaryScanner(ValueBoundaryDef bndDef)
		{
			super(bndDef);
		}
		
		@Override
		public boolean isGreater(Object v1, Object v2, int amt)
		{
			long l1 = PrimitiveObjectInspectorUtils.getLong(v1, 
					(PrimitiveObjectInspector) bndDef.getOI());
			long l2 = PrimitiveObjectInspectorUtils.getLong(v2, 
					(PrimitiveObjectInspector) bndDef.getOI());
			return (l1 -l2) >= amt;
		}
	}
	
	public static class DoubleValueBoundaryScanner extends ValueBoundaryScanner
	{
		public DoubleValueBoundaryScanner(ValueBoundaryDef bndDef)
		{
			super(bndDef);
		}
		
		@Override
		public boolean isGreater(Object v1, Object v2, int amt)
		{
			double d1 = PrimitiveObjectInspectorUtils.getDouble(v1, 
					(PrimitiveObjectInspector) bndDef.getOI());
			double d2 = PrimitiveObjectInspectorUtils.getDouble(v2, 
					(PrimitiveObjectInspector) bndDef.getOI());
			return (d1 -d2) >= amt;
		}
	}
	
	public static ValueBoundaryScanner getScanner(ValueBoundaryDef vbDef)
	{
		PrimitiveObjectInspector pOI = (PrimitiveObjectInspector) vbDef.getOI();
		switch(pOI.getPrimitiveCategory())
		{
		case BYTE:
		case INT:
		case LONG:
		case SHORT:
		case TIMESTAMP:
			return new LongValueBoundaryScanner(vbDef);
		case DOUBLE:
		case FLOAT:
			return new DoubleValueBoundaryScanner(vbDef);
		}
		return null;
	}
}
