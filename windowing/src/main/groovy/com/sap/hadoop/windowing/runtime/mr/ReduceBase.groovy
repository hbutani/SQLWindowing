package com.sap.hadoop.windowing.runtime.mr

import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils.ObjectInspectorCopyOption;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.windowing.functions.AbstractTableFunction;
import com.sap.hadoop.windowing.query.Column;
import com.sap.hadoop.windowing.query.OutputColumn;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QueryInput;
import com.sap.hadoop.windowing.query.QueryOutput;
import com.sap.hadoop.windowing.query.QuerySpec;
import com.sap.hadoop.windowing.runtime.IPartition;
import com.sap.hadoop.windowing.runtime.IPartitionIterator;
import com.sap.hadoop.windowing.runtime.OutputObj;
import com.sap.hadoop.windowing.runtime.Row;
import com.sap.hadoop.windowing.runtime.WindowingShell;

interface ReduceOutput
{
	void collectOutput(Writable key, Writable value);
}

public class ReduceBase
{
	WindowingShell wshell
	Query qry
	ArrayList<StructField> partitionColumnFields = []
	
	public void configure(Configuration job) 
	{
		String qryStr = job.get(Job.WINDOWING_QUERY_STRING);
		HiveConf hConf = new HiveConf(job, job.getClass()) 
		wshell = new WindowingShell(hConf, new MRTaskTranslator(), new MRExecutor())
		
		//QuerySpec qSpec = wshell.parse(qryStr);
		QuerySpec qSpec = JobBase.getQuerySpec(job)
		
//		if ( qSpec.tableIn.hiveQuery != null )
//		{
//			String tt = job.get(Job.WINDOWING_TEMP_TABLE);
//			qSpec.tableIn.tableName = tt;
//		}
		
		qry = wshell.translate(qSpec, hConf)
		
		ArrayList<StructField> partitionColumnFields = []
		for(Column c in qry.input.partitionColumns)
		{
			partitionColumnFields << c.field
		}

		println qry.qSpec.toString()
	}

	@Override
	public void reduce(Writable key, Iterator<Writable> values, ReduceOutput reduceOut)
			throws IOException
	{		
		boolean applyWhere = (qry.whereExpr != null)
		
		AbstractTableFunction tFunc = qry.tableFunction;
		AbstractTableFunction inpTFunc = qry.inputtableFunction
		
		inpTFunc.input = new MRPartitioner(qry, values, partitionColumnFields)
		inpTFunc.isFirstFunctionInChain = true
		
		while(tFunc.hasNext())
		{
			IPartition p = tFunc.next();
			Row orow = p.getRowObject();
			for(OutputColumn oc in qry.output.columns)
			{
				orow.bind(oc.groovyExpr)
			}
			
			if ( applyWhere )
			{
				orow.bind(qry.whereExpr)
			}
			for(r in p)
			{
				if ( !applyWhere || qry.whereExpr.run() )
					writeOutputRow(r, qry, reduceOut)
			}
		}
	}
	
	void writeOutputRow(Row orow, Query qry, ReduceOutput reduceOut)
	{
		QueryOutput qryOut = qry.output
		ArrayList o = []
		for(OutputColumn oc in qry.output.columns)
		{
			o << oc.groovyExpr.run()
		}
		Writable outWritable = qryOut.serDe.serialize(o, qryOut.processingOI)
		reduceOut.collectOutput(NullWritable.get(), outWritable);
	}
	
}


class MRPartitioner implements IPartitionIterator
{
	Iterator<Writable> values
	boolean returnedPart
	Query qry
	ArrayList<StructField> partitionColumnFields
	
	MRPartitioner(Query qry, Iterator<Writable> values, ArrayList<StructField> partitionColumnFields)
	{
		this.qry = qry
		this.values = values
		this.returnedPart = false
		this.partitionColumnFields = partitionColumnFields
	}
	
	boolean hasNext()
	{
		return !returnedPart
	}
	
	IPartition next()
	{
		QueryInput qryIn = qry.input
		com.sap.hadoop.windowing.runtime.Partition p = new com.sap.hadoop.windowing.runtime.Partition(qry, qryIn.wInput,
			qryIn.inputOI, qryIn.deserializer, partitionColumnFields)
		while(values.hasNext())
		{
			p << values.next()
		}
		returnedPart = true
		return p
	}
	void remove() { throw new UnsupportedOperationException() }
}


