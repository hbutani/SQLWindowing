package com.sap.hadoop.windowing.runtime

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

class Partition 
{
	StructObjectInspector standardOI;
	private ArrayList elems;
	InputObj pObj
	def partitionColumnFields
	
	Partition(ObjectInspector OI, ObjectInspector standardOI, partitionColumnFields)
	{
		this.standardOI = standardOI
		this.elems = []
		this.partitionColumnFields = partitionColumnFields
		pObj = new InputObj(p: this)
	}
	
	def getAt(i) 
	{ 
		pObj.idx = i
		return pObj
	}
	def leftShift(o)
	{
//		def jo = ObjectInspectorUtils.copyToStandardObject(o, OI, ObjectInspectorCopyOption.JAVA)
//			StructObjectInspector soi = (StructObjectInspector) OI
//			List<? extends StructField> fields = soi.getAllStructFieldRefs();
//			ArrayList<Object> struct = new ArrayList<Object>(fields.size());
//			for (StructField f : fields) {
//				println soi.getStructFieldData(o, f)
//			}
//		println jo
		elems << o
	}
	boolean belongs(o)
	{
		if (! elems) return true
		for(k in partitionColumnFields)
		{
			def eval = standardOI.getStructFieldData(elems[0], k)
			def val = standardOI.getStructFieldData(o, k)
			if ( (eval == null && val == null ) || (eval != val ) )
				return false
		}
		return true;
	}
	def iterator() { return new PItr(this); }
	
	def size() { return elems.size() }
}

class PItr implements Iterator
{
	Partition p
	int idx
	
	PItr(p) 
	{ 
		this.p = p; 
		idx = 0
	}
	
	boolean hasNext() { return idx < p.size(); }
	def next() { return p[idx++]; }
	void remove() { throw new UnsupportedOperationException() }
}

