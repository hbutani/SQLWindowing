package com.sap.hadoop.windowing.runtime

import groovy.lang.Script;
import groovy.lang.Binding;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector.Category;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.io.Writable

import com.sap.hadoop.ds.list.ByteBasedList;
import com.sap.hadoop.ds.list.PartitionedByteBasedList;
import com.sap.hadoop.windowing.io.WindowingInput;

/**
 * represents a row in a partition.
 * @author harish.butani
 *
 */
class Row extends Binding
{
	void bind(Script sc)
	{
		sc.binding = this;
		registerFunctions(sc);
	}
	
	void registerFunctions(Script sc) {}
}

/**
* A Partition is a container of all rows.
*/
abstract class IPartition implements Iterable<Row>
{
	abstract Row getAt(i); 
	abstract int size();
	abstract Row getRowObject();
	Iterator<Row> iterator() { return new PItr(this); }
}

class PItr implements Iterator<Row>
{
	IPartition p
	int idx
	
	PItr(p)
	{
		this.p = p;
		idx = 0
	}
	
	boolean hasNext() { return idx < p.size(); }
	Row next() { return p[idx++]; }
	void remove() { throw new UnsupportedOperationException() }
}


/**
 * A Partition for the input from a WindowingInput.
 * Input rows are held as Writables. Partition returns rows as {@link InputObj} which is a Groovy Binding that 
 * converts fields to Java values on demand.
 *
 */
class Partition extends IPartition
{
	StructObjectInspector inputOI;
	Deserializer deserializer
	WindowingInput wInput
	ByteBasedList elems;
	InputObj pObj
	ArrayList<StructField> partitionColumnFields
	private ArrayList partitionFieldVals = []
	
	Partition(WindowingInput wInput, ObjectInspector inputOI, Deserializer deserializer, 
		ArrayList<StructField> partitionColumnFields, int partitionMemSize)
	{
		this.wInput = wInput
		this.inputOI = inputOI
		this.deserializer = deserializer
		this.elems = new PartitionedByteBasedList(partitionMemSize)
		this.partitionColumnFields = partitionColumnFields
		pObj = new InputObj(p: this)
	}
	
	Row getAt(i) 
	{ 
		pObj.idx = i
		return pObj
	}
	
	def leftShift(Writable o)
	{
		elems.append(o);
	}

	boolean belongs(Writable o)
	{
		if ( o == null )
			return false;
		TmpInputObj t = new TmpInputObj(this, o)
		if (elems.size() == 0) 
		{
			for(k in partitionColumnFields)
			{
				def eval = t[k.fieldName]
				partitionFieldVals << eval
			}
			return true
		}
		int i = 0
		for(k in partitionColumnFields)
		{
			def eval = partitionFieldVals[i++]
			def val = t[k.fieldName]
			if ( (eval == null && val == null ) || (eval != val ) )
				return false
		}
		return true;
	}
	
	int size() { return elems.size() }
	Row getRowObject() { return pObj; }
}

class TmpInputObj extends Binding
{
	Partition p
	Object o
	
	TmpInputObj(Partition p, Writable wObj)
	{
		this.p = p
		this.wObj = wObj
		o = p.deserializer.deserialize(wObj)
	}
	
	def getVariable(String name)
	{
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
}

