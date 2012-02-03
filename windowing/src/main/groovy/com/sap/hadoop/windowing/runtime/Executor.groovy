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
		boolean applyWhere = (qry.whereExpr != null)
		
		AbstractTableFunction tFunc = qry.tableFunction;
		AbstractTableFunction inpTFunc = qry.inputtableFunction
		
		inpTFunc.input = new Partitioner(qry)
		
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
					writeOutputRow(r, qry)
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


