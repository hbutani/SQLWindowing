package com.sap.hadoop.windowing.runtime

import groovy.lang.Binding;

class InputObj extends Binding
{
	Partition p
	int idx
	
	def getVariable(String name)
	{
		try
		{
			def fRef = p.standardOI.getStructFieldRef(name)
			if (fRef)
				return p.standardOI.getStructFieldData(p.elems[idx], fRef)
				else
				return super.getVariable(name)
		}
		catch(Throwable t)
		{
//			printf("%s, %s\n", name, name.class)
//			def fl =  p.standardOI.allStructFieldRefs.fieldName
//			println fl
//			println name in fl
//			println fl[1].class
//			println fl[1]
//			println fl[1].equals("movie_name")
//			t.printStackTrace()
			throw t
		}
	}
	
}


