package com.sap.hadoop.windowing.runtime

import groovy.lang.Binding;

import java.util.Iterator;
import java.util.Map;

import com.sap.hadoop.windowing.WindowingException;

class OutputObj extends Row
{
	InputObj iObj
	Map resultMap
	Partition p
	
	def getVariable(String name)
	{
		switch(name)
		{
			case resultMap:
				return resultMap[name][iObj.idx]
			default:
				return iObj.getVariable(name)
		}
	}
	
	def getValue(int idx, String name)
	{
		int currIdx = iObj.idx
		try
		{
			iObj.idx = idx
			return iObj[name]
		}
		finally
		{
			iObj.idx = currIdx
		}
	}
	
	def lag(String name, int amt)
	{
		int idx = iObj.idx - amt
		idx = (idx < 0 ? 0 : idx)
		idx = ( idx > p.size() -1 ? p.size() - 1 : idx)

		if ( name in resultMap )
		{
			return resultMap[name][idx]
		}
		else
		{
			return getValue(idx, name)
		}
	}
	
	def lead(String name, int amt)
	{
		int idx = iObj.idx + amt
		idx = (idx < 0 ? 0 : idx)
		idx = ( idx > p.size() -1 ? p.size() - 1 : idx)

		if ( name in resultMap )
		{
			return resultMap[name][idx]
		}
		else
		{
			return getValue(idx, name)
		}
	}
	

	void registerFunctions(Script sc)
	{
		if ( sc )
		{
			sc.lag = this.&lag
			sc.lead = this.&lead
		}
	}
}

