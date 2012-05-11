package com.sap.hadoop.ds;

import java.util.Comparator;

import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector.PrimitiveCategory;

import com.sap.hadoop.windowing.WindowingException;

public class PrimitiveComparator<T extends Comparable<T>> implements Comparator<T>
{
	public PrimitiveComparator(Class<T> cls)
	{
		
	}

	@Override
	public int compare(T o1, T o2)
	{
		if ( o1 == null && o2 == null)
		{
			throw new UnsupportedOperationException("Cannot compare 2 nulls");
		}
		
		return o1 != null ? o1.compareTo(o2) : -o2.compareTo(o1);
	}
	
	public static final PrimitiveComparator<Boolean> BOOLEAN_COMPARATOR = new PrimitiveComparator<Boolean>(Boolean.class);
	public static final PrimitiveComparator<Byte> BYTE_COMPARATOR = new PrimitiveComparator<Byte>(Byte.class);
	public static final PrimitiveComparator<Short> SHORT_COMPARATOR = new PrimitiveComparator<Short>(Short.class);
	public static final PrimitiveComparator<Integer> INT_COMPARATOR = new PrimitiveComparator<Integer>(Integer.class);
	public static final PrimitiveComparator<Long> LONG_COMPARATOR = new PrimitiveComparator<Long>(Long.class);
	public static final PrimitiveComparator<Float> FLOAT_COMPARATOR = new PrimitiveComparator<Float>(Float.class);
	public static final PrimitiveComparator<Double> DOUBLE_COMPARATOR = new PrimitiveComparator<Double>(Double.class);
	public static final PrimitiveComparator<String> STRING_COMPARATOR = new PrimitiveComparator<String>(String.class);
	
	public static PrimitiveComparator<?> getComparator(PrimitiveCategory pC) throws WindowingException
	{
		switch(pC)
		{
		case BOOLEAN:
			return BOOLEAN_COMPARATOR;
		case BYTE:
			return BYTE_COMPARATOR;
		case SHORT:
			return SHORT_COMPARATOR;
		case INT:
			return INT_COMPARATOR;
		case LONG:
			return LONG_COMPARATOR;
		case FLOAT:
			return FLOAT_COMPARATOR;
		case DOUBLE:
			return DOUBLE_COMPARATOR;
		case STRING:
			return STRING_COMPARATOR;
		default:
			throw new WindowingException("Unsupported primitive type: " + pC);
		}
	}

}
