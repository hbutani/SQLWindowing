package com.sap.hadoop.windowing.runtime2;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.io.WindowingInput;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;

/*
 * given a WindowingInput, slices it into an iteration of Partitions.
 * Used by the LocalExecutor.
 */
public class PartitionsIterator implements Iterator<Partition>
{
	WindowingInput wIn;
	QueryDef qDef;
	String partClassName;
	int partMemSize;
	Object currObject;
	SerDe serDe;
	StructObjectInspector OI;
	StructObjectInspector stdOI;
	Writable w;
	ArrayList<String> partColumns;
	ArrayList<StructField> objFields;
	ArrayList<StructField> stdObjFields;

	public PartitionsIterator(WindowingInput wIn, QueryDef qDef) throws WindowingException
	{
		super();
		this.wIn = wIn;
		this.qDef = qDef;
		TableFuncDef tabDef = (TableFuncDef) qDef.getInput();
		TableFunctionEvaluator tEval = tabDef.getFunction();
		partClassName = tEval.getPartitionClass();
		partMemSize = tEval.getPartitionMemSize();
		
		serDe = (SerDe) wIn.getDeserializer();
		try
		{
			OI = (StructObjectInspector) serDe.getObjectInspector();
			w  = wIn.createRow();
		}
		catch(Exception se)
		{
			throw new WindowingException(se);
		}
		
		stdOI = (StructObjectInspector) ObjectInspectorUtils.getStandardObjectInspector(OI);
		
		partColumns = new ArrayList<String>();
		objFields = new ArrayList<StructField>();
		stdObjFields = new ArrayList<StructField>();
		ArrayList<ColumnDef> cols = tabDef.getWindow().getPartDef().getColumns();
		for(ColumnDef colDef : cols)
		{
			String colName = colDef.getAlias();
			StructField f = OI.getStructFieldRef(colName);
			StructField stdF = stdOI.getStructFieldRef(colName);
			partColumns.add(colName);
			objFields.add(f);
			stdObjFields.add(stdF);
		}
	}

	@Override
	public boolean hasNext()
	{
		return currObject != null || wIn.hasNext();
	}

	@Override
	public Partition next()
	{
		try
		{
			Partition p = new Partition(partClassName, partMemSize, serDe, OI);

			if (currObject == null)
			{
				w = (Writable) wIn.next();
				Object o = wIn.getDeserializer().deserialize(w);
				currObject = ObjectInspectorUtils.copyToStandardObject(o, OI);
			}
			p.append(w);

			boolean reachedNextPart = false;
			while (wIn.next(w) != -1)
			{
				Object o = wIn.getDeserializer().deserialize(w);
				if (isInPartition(o))
				{
					p.append(w);
				}
				else
				{
					currObject = ObjectInspectorUtils.copyToStandardObject(o, OI);
					reachedNextPart = true;
					break;
				}
			}
			if (!reachedNextPart)
			{
				currObject = null;
			}
			return p;
		}
		catch (Exception we)
		{
			throw new RuntimeException(we);
		}
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
	
	private boolean isInPartition(Object o)
	{
		for(int i=0; i < partColumns.size(); i++)
		{
			if (ObjectInspectorUtils.compare(OI.getStructFieldData(o, objFields.get(i)), objFields.get(i).getFieldObjectInspector(), 
					stdOI.getStructFieldData(currObject, stdObjFields.get(i)), stdObjFields.get(i).getFieldObjectInspector()) != 0)
			{
				return false;
			}
		}
		return true;
	}

}
