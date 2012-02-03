package com.sap.hadoop.windowing.runtime

import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector.Category;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.io.Writable
import groovy.lang.Binding;

class InputObj extends Row
{
	Partition p
	int idx
	Writable wObj
	
	def getVariable(String name)
	{
		Object o = p.deserializer.deserialize(wObj)
		try
		{
			StructField fRef = p.inputOI.getStructFieldRef(name)
			if (fRef)
			{
				Object val = p.inputOI.getStructFieldData(o, fRef)
				ObjectInspector oi = fRef.getFieldObjectInspector()
				if (oi.getCategory() == Category.PRIMITIVE )
				{
					return ((PrimitiveObjectInspector)oi).getPrimitiveJavaObject(val)
				}
				return val
			}
			else
				return super.getVariable(name)
		}
		catch(Throwable t)
		{
			throw t
		}
	}
	
	def setIdx(int i)
	{
		idx = i
		wObj = p.wInput.createRow()
		p.elems.get(i, wObj)
	}
	
}


