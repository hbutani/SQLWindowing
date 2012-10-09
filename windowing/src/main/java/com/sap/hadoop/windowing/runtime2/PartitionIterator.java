package com.sap.hadoop.windowing.runtime2;

import java.util.Iterator;

public interface PartitionIterator<T> extends Iterator<T>
{
	int getIndex();
	
	T lead(int amt);
	
	T lag(int amt);

	/*
	 * after a lead and lag call, allow Object associated with SerDe and writable associated with partition to be reset
	 * to the value for the current Index.
	 */
	Object resetToIndex(int idx);
}
