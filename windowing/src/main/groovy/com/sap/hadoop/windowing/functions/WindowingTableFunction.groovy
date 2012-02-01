package com.sap.hadoop.windowing.functions

import java.util.ArrayList;

import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.runtime.AbstractTableFunction;
import com.sap.hadoop.windowing.runtime.IPartitionIterator;
import com.sap.hadoop.windowing.runtime.OutputObj;
import com.sap.hadoop.windowing.runtime.Partition;
import com.sap.hadoop.windowing.runtime.Partitioner;
import com.sap.hadoop.windowing.runtime.Row;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.runtime.IPartition;


abstract class WindowingTableFunction extends AbstractTableFunction
{
	ArrayList<IWindowFunction> wnFns
	ArrayList<String> wnAliases
	
	WindowingTableFunction(Query qry)
	{
		super(new Partitioner(qry))
		wnFns = qry.wnFns
		wnAliases = qry.wnAliases
	}
	
	protected IPartition execute(IPartition inpPart) throws WindowingException
	{
		OutputPartition op = new OutputPartition(inpPart)
		OutputObj orow = op.getRowObject();
		for (i in 0..<wnFns.size())
		{
			orow.resultMap[wnAliases[i]] = wnFns[i].processPartition(inpPart)
		}
		return op;
	}
}

class OutputPartition extends IPartition
{
	Partition inputPartition
	OutputObj outObj
	
	OutputPartition(Partition p)
	{
		inputPartition = p
		outObj = new OutputObj();
		outObj.p = p
		outObj.resultMap = [:]
	}
	
	Row getAt(i)
	{
		outObj.iObj = inputPartition[i];
		return outObj;
	}
	int size() { return inputPartition.size();}
	Row getRowObject() { return outObj; }
}
