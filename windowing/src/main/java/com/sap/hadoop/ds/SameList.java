package com.sap.hadoop.ds;

import java.util.AbstractList;

public class SameList<E> extends AbstractList<E>
{
	int sz;
	E val;
	
	public SameList(int sz, E val)
	{
		this.sz = sz;
		this.val = val;
	}

	@Override
	public E get(int index)
	{
		return val;
	}

	@Override
	public int size()
	{
		return sz;
	}

}
