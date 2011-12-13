package com.sap.hadoop.windowing.runtime

import groovy.lang.Binding;

import java.util.Map;

import com.sap.hadoop.windowing.WindowingException;

class OutputObj extends Binding
{
	InputObj iObj
	Map resultMap
	
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
	
	def lag(String name, int amt)
	{
		if ( !(name in resultMap) )
			throw new RuntimeException(sprintf("Unknown column %s", name));
		
		def l = resultMap[name]
		int idx = iObj.idx - amt
		idx = (idx < 0 ? 0 : idx)
		idx = ( idx > l.size() -1 ? l.size() - 1 : idx)
		return l[idx]
	}
	
	def lead(String name, int amt)
	{
		if ( !(name in resultMap) )
			throw new RuntimeException(sprintf("Unknown column %s", name));
		
		def l = resultMap[name]
		int idx = iObj.idx + amt
		idx = (idx < 0 ? 0 : idx)
		idx = ( idx > l.size() -1 ? l.size() - 1 : idx)
		return l[idx]
	}
	

	def registerFunctions(Script sc)
	{
		if ( sc )
		{
			sc.lag = this.&lag
			sc.lead = this.&lead
		}
	}
}

