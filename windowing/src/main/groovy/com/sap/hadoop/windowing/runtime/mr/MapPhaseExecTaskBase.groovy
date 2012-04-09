package com.sap.hadoop.windowing.runtime.mr

import org.apache.hadoop.conf.Configuration;
import com.sap.hadoop.windowing.WindowingException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import com.sap.hadoop.windowing.functions.AbstractTableFunction;
import com.sap.hadoop.windowing.io.WindowingInput;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QuerySpec;
import com.sap.hadoop.windowing.runtime.IPartition;
import com.sap.hadoop.windowing.runtime.Partition;
import com.sap.hadoop.windowing.runtime.Row;
import com.sap.hadoop.windowing.runtime.WindowingShell;

/**
 * responsible for creating the output partition in the Map Phase.
 * @author harish.butani
 *
 */
class MapPhaseExecTaskBase extends MapBase
{
	WindowingShell wshell
	Query qry
	MapPhasePartition partition
	OutputCollector<Writable, Writable> output
	Reporter reporter
	
	public void configure(JobConf job) 
	{
		super.configure(job);
		String qryStr = job.get(Job.WINDOWING_QUERY_STRING);
		wshell = new WindowingShell(job, new MRTaskTranslator(), new MRExecutor())
		
		QuerySpec qSpec = JobBase.getQuerySpec(job)
		qry = wshell.translate(qSpec)
		partition = new MapPhasePartition(qry)
	}
	
	public void map(Writable key, Writable value,
		OutputCollector<Writable, Writable> output, Reporter reporter)
		throws IOException {
		this.output = output
		this.reporter = reporter
		partition << value
	}
		
	public void close() throws IOException 
	{
		AbstractTableFunction inpTFunc = qry.inputtableFunction
		
		IPartition p = inpTFunc.mapExecute(partition);
		Row orow = p.getRowObject();
		ArrayList o = []
		for(r in p)
		{
			o.clear()
			inpTFunc.getMapPhaseOutputShape() { name, type ->
				o << orow[name]
			}
			Writable mOutWritable = qry.mapPhase.outputSerDe.serialize(o, qry.mapPhase.outputOI)
			map(null, mOutWritable)
			output.collect(wkey, mOutWritable);
		}
	}
}

class MapPhasePartition extends Partition
{
	MapPhasePartition(Query qry)
	{
		super(qry, null, qry.mapPhase.inputOI, qry.mapPhase.inputDeserializer, null)
	}
	
	boolean belongs(Writable o)
	{
		return true
	}
}