package com.sap.hadoop.windowing.runtime

import java.util.Iterator;
import org.apache.hadoop.io.Writable;
import java.util.NoSuchElementException;

import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils.ObjectInspectorCopyOption;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.io.WindowingInput;
import com.sap.hadoop.windowing.query.Column;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QueryInput;

/**
 * Given an Iterator of Writables it produces an Iterator of Partitions.
 * @author harish.butani
 *
 */
class Partitioner implements Iterator<Partition>
{
	Query qry
	QueryInput qryIn
	ArrayList<StructField> partitionColumnFields = []
	def currElem = null
	
	Partitioner(Query qry)
	{
		this.qry = qry
		qryIn = qry.input
		for(Column c in qryIn.partitionColumns)
		{
			partitionColumnFields << c.field
		}

	}
	
	boolean hasNext() 
	{ 
		return currElem != null || qryIn.wInput.hasNext() 
	}
	
	def next() 
	{
		if (currElem == null)
		{
			currElem = qryIn.wInput.next()
		}
		Partition p = new Partition(qry, qryIn.wInput, qryIn.inputOI, qryIn.deserializer, partitionColumnFields)
		while ( p.belongs(currElem) )
		{
			p << currElem
			if ( qryIn.wInput.hasNext())
				currElem = qryIn.wInput.next()
			else
				currElem = null
		}
		return p
	}
	void remove() { throw new UnsupportedOperationException() }
}

