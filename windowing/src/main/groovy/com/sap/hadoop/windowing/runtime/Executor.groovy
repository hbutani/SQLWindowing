package com.sap.hadoop.windowing.runtime

import groovy.lang.Binding;

import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe;
import org.apache.hadoop.hive.contrib.util.typedbytes.TypedBytesRecordWriter;
import org.apache.hadoop.hive.serde2.objectinspector.SettableStructObjectInspector;

import com.sap.hadoop.windowing.io.WindowingInput;
import com.sap.hadoop.windowing.query.OrderColumn;
import com.sap.hadoop.windowing.query.OutputColumn;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QueryOutput;

class Executor
{
	Map envProps;
	
	void execute(Query qry)
	{
		Configuration conf = qry.cfg
		QueryOutput qryOut = qry.output
		boolean applyWhere = (qry.whereExpr != null)
		
		def windowFns = qry.wnFns
		def windowFnAliases = qry.wnAliases
			
		OutputObj orow = new OutputObj();
		for(OutputColumn oc in qry.output.columns)
		{
			oc.groovyExpr.binding = orow
			orow.registerFunctions(oc.groovyExpr)
		}
		
		if ( applyWhere )
		{
			qry.whereExpr.binding = orow
			orow.registerFunctions(qry.whereExpr)
		}
		
		orow.resultMap = [:]
		Partitioner partitions = new Partitioner(qry)
		while(partitions.hasNext())
		{
			Partition p = partitions.next()
			orow.p = p
			orow.resultMap.clear()
			for (i in 0..<windowFns.size())
			{
				orow.resultMap[windowFnAliases[i]] = windowFns[i].processPartition(p)
			}
			
			for(row in p)
			{
				orow.iObj = row
				if ( !applyWhere || qry.whereExpr.run() )
					writeOutputRow(orow, qry)
			}
			
		}
		endOutput(qry);
	}
	
	void writeOutputRow(OutputObj orow, Query qry)
	{
		QueryOutput qryOut = qry.output
		ArrayList o = []
		for(OutputColumn oc in qry.output.columns)
		{
			o << oc.groovyExpr.run()
		}
		qryOut.wrtr.write(qryOut.serDe.serialize(o, qryOut.processingOI))
	}
	
	void endOutput(Query qry)
	{
		QueryOutput qryOut = qry.output
		qryOut.wrtr.close();
	}
}

class TestExecutor extends Executor
{
	PrintStream out = System.out
	
	void writeOutputRow(OutputObj orow, Query qry)
	{
		QueryOutput qryOut = qry.output
		ArrayList o = []
		for(OutputColumn oc in qry.output.columns)
		{
			o << oc.groovyExpr.run()
		}
		out.println(o)
	}
	
	void endOutput(Query qry)
	{
		QueryOutput qryOut = qry.output
		out.flush()
	}

}


