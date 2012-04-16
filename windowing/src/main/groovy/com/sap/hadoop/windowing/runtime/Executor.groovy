package com.sap.hadoop.windowing.runtime

import groovy.lang.Binding;

import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe;
import org.apache.hadoop.hive.contrib.util.typedbytes.TypedBytesRecordWriter;
import org.apache.hadoop.hive.serde2.objectinspector.SettableStructObjectInspector;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions.AbstractTableFunction;
import com.sap.hadoop.windowing.io.WindowingInput;
import com.sap.hadoop.windowing.query.OrderColumn;
import com.sap.hadoop.windowing.query.OutputColumn;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QueryOutput;

class Executor
{
	Map envProps;
	
	/*
	 * Marker method to let WShell if Executor can componentize the User Query.
	 * Componentization only supported in MR mode.
	 */
	boolean allowQueryComponentization()
	{
		return false;
	}
	
	/*
	* hook to allow Executor to setup before input Query is converted to a list of component Queries.
	*/
   void beforeComponentization(Query qry, WindowingShell wShell)
   {
	   
   }
	
	/*
	 * hook to allow Executor to setup execution for 1 or more component Queries.
	 */
	void beforeExecute(Query qry, ArrayList<Query> componentQueries, WindowingShell wShell)
	{
		
	}
	
	/*
	* hook to allow Executor to cleanup execution after 1 or more component Query executions.
	*/
   void afterExecute(Query qry, WindowingShell wShell)
   {
	   
   }
	
	void execute(Query qry, WindowingShell wShell) throws WindowingException
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
	
	void writeOutputRow(Row orow, Query qry)
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
	
	void writeOutputRow(Row orow, Query qry)
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


