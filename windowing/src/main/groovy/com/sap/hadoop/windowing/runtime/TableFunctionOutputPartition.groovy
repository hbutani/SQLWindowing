package com.sap.hadoop.windowing.runtime

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.Writable;
import com.sap.hadoop.ds.list.ByteBasedList;
import com.sap.hadoop.ds.list.ListFactory;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe;
import org.apache.hadoop.hive.serde2.lazybinary.LazyBinarySerDe;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector.Category;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils.ObjectInspectorCopyOption;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions.AbstractTableFunction;
import com.sap.hadoop.windowing.query.TypeUtils;
import com.sap.hadoop.windowing.runtime.Row
import org.apache.hadoop.hive.serde.Constants as HiveConstants
import com.sap.hadoop.windowing.Constants
/*
 * A generic Partition for TableFunction output.
 */
class TableFunctionOutputPartition extends IPartition
{
	AbstractTableFunction tableFunction
	/*
	 * is this being used in a Map Task
	 */
	boolean mapSide
	
	SerDe serDe;
	StructObjectInspector oI
	StructObjectInspector processingOI
	ByteBasedList elems;
	TblFunctionOutputRow pObj
	
	public void initialize(Configuration cfg) throws WindowingException
	{
		Map<String, TypeInfo> typeMap = mapSide ? tableFunction.getMapPhaseOutputShape() : tableFunction.getOutputShape()
		initialize(cfg, typeMap)
	}
	
	protected void initialize(Configuration cfg, Map<String, TypeInfo> typeMap) throws WindowingException
	{
		if ( serDe == null )
		{
			serDe = TypeUtils.createLazyBinarySerDe(cfg, typeMap)
		}
		
		try
		{
			oI = serDe.getObjectInspector()
			processingOI = ObjectInspectorUtils.getStandardObjectInspector(oI, ObjectInspectorCopyOption.JAVA)
		}
		catch(Throwable t)
		{
			throw new WindowingException(
				sprintf("Failed to setup tableFunction Output SerDe %s", tableFunction), t)
		}
		
		String byteListParttionClassName = cfg.get(Constants.WINDOW_PARTITION_CLASS, Constants.DEFAULT_WINDOW_PARTITION_CLASS);
		int byteListPartitionMemSize = cfg.getInt(Constants.WINDOW_PARTITION_MEM_SIZE, ByteBasedList.MEDIUM_SIZE);
		this.elems = ListFactory.createList(byteListParttionClassName, byteListPartitionMemSize);
		pObj = new TblFunctionOutputRow(p: this)
	}
	
	def leftShift(Object o)
	{
		Writable w = serDe.serialize(o, processingOI)
		elems.append(w);
	}
	
	Writable createRow() throws IOException
	{
		try
		{
			return serDe.getSerializedClass().newInstance();
		}
		catch(Throwable t)
		{
			throw new IOException(t);
		}
	}
	
	Iterator<Writable> writableIterator()
	{
		return elems.iterator(createRow());
	}
	
	Row getAt(i)
	{
		pObj.idx = i
		return pObj
	}
	int size()
	{
		return elems.size()
	}
	
	Row getRowObject()
	{
		return pObj;
	}
}

class TblFunctionOutputRow extends Row
{
	TableFunctionOutputPartition p
	int idx
	Writable wObj
	
	def getVariable(String name)
	{
		Object o = p.serDe.deserialize(wObj)
		try
		{
			StructField fRef = p.oI.getStructFieldRef(name)
			if (fRef)
			{
				Object val = p.oI.getStructFieldData(o, fRef)
				ObjectInspector oi = fRef.getFieldObjectInspector()
				switch (oi.category)
				{
					case Category.PRIMITIVE:
						return ((PrimitiveObjectInspector)oi).getPrimitiveJavaObject(val);
					case Category.LIST:
						//return ((ListObjectInspector)oi).getList(val);
						return ObjectInspectorUtils.copyToStandardObject(val, oi, ObjectInspectorCopyOption.JAVA);
					case Category.MAP:
						return ObjectInspectorUtils.copyToStandardObject(val, oi, ObjectInspectorCopyOption.JAVA);
					default:
						return val;
				}
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
		if ( i != idx || wObj == null)
		{
			idx = i
			wObj = p.createRow()
			p.elems.get(i, wObj)
		}
	}
	
}
