package com.sap.hadoop.windowing.runtime

import groovy.lang.Binding;

import java.util.Map;

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
}

