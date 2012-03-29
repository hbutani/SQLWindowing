package com.sap.hadoop.windowing.runtime

import groovy.lang.GroovyShell;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.apache.hadoop.conf.Configuration;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.parser.QSpecBuilder;
import com.sap.hadoop.windowing.parser.WindowingLexer;
import com.sap.hadoop.windowing.parser.WindowingParser;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QueryComponentizer;
import com.sap.hadoop.windowing.query.QuerySpec;
import com.sap.hadoop.windowing.query.QuerySpecBuilder;
import com.sap.hadoop.windowing.query.Translator;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

class WindowingShell
{
	private Configuration cfg;
	Executor executor
	Translator translator
	private GroovyShell wshell
	HiveQueryExecutor hiveQryExec
	
	
	WindowingShell(Configuration cfg, Translator translator, Executor executor)
	{
		this.cfg = cfg
		this.executor = executor
		this.translator = translator
		wshell = new GroovyShell()
	}
	
	public QuerySpec parse(String query) throws WindowingException
	{
		try
		{
			WindowingLexer lexer = new WindowingLexer(new ANTLRStringStream(query));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			WindowingParser parser = new WindowingParser(tokens);
			CommonTree t = parser.query().getTree()
			
			String err = parser.getWindowingParseErrors()
			if ( err != null )
			{
				throw new WindowingException(err)
			}
			
			//println t.toStringTree()
		
//			CommonTreeAdaptor ta = (CommonTreeAdaptor) parser.getTreeAdaptor();
//			QuerySpecBuilder qSpecBldr = new QuerySpecBuilder(adaptor : ta)
//			qSpecBldr.visit(t)
			
			CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
			nodes.setTokenStream(tokens)
			QSpecBuilder qSpecBldr = new QSpecBuilder(nodes);
			qSpecBldr.query()
	
			err = qSpecBldr.getWindowingParseErrors()
			if ( err != null )
			{
				throw new WindowingException(err)
			}
			
			qSpecBldr.qSpec.queryStr = query
			return qSpecBldr.qSpec
		}
		catch(RecognitionException re)
		{
			throw new WindowingException("Parse Error:" + re.toString(), re)
		}
		catch(RuntimeException re1)
		{
			throw new WindowingException("Parse Error:" + re1.toString(), re1)
		}
	}
	
	public Query translate(String query) throws WindowingException
	{
		QuerySpec qSpec = parse(query);
		return translator.translate(wshell, qSpec, cfg, hiveQryExec);
	}
	
	public Query translate(QuerySpec qSpec) throws WindowingException
	{
		return translator.translate(wshell, qSpec, cfg, hiveQryExec);
	}

	public void execute(String query) throws WindowingException
	{
		QuerySpec qSpec = parse(query)
		Query q = translator.translate(wshell, qSpec, cfg, hiveQryExec);
		ArrayList<Query> componentQueries;
		
		if ( executor.allowQueryComponentization() )
		{
			QueryComponentizer qC = new QueryComponentizer(q, this);
			componentQueries = qC.componentize();
		}
		else
		{
			componentQueries = [q]
		}
		
		executor.beforeExecute(q, componentQueries, this);
		try
		{
			componentQueries.each { Query cq ->
				execute(cq);
			}
		}
		finally
		{
			executor.afterExecute(q, this)
		}
	}
	
	protected void execute(Query q) throws WindowingException
	{
		QuerySpec qSpec = q.qSpec
		try
		{
			executor.execute(q, this)
		}
		finally
		{
			/* delete the temporary table created */
			if ( qSpec.tableIn.hiveQuery != null && qSpec.tableIn.tableName != null )
			{
				hiveQryExec.dropTable(qSpec.tableIn.tableName)
			}
		}
		
		if ( qSpec.tableOut.tableName )
		{
			loadToOutputTable(q);
		}
	}
	
	protected void loadToOutputTable(Query qry) throws WindowingException
	{
		//LOAD DATA [LOCAL] INPATH 'filepath' [OVERWRITE] INTO TABLE tablename [PARTITION (partcol1=val1, partcol2=val2 ...)]
		String loadCmd = "load data inpath '${qry.qSpec.tableOut.outputPath}'"
		if ( qry.qSpec.tableOut.overwrite)
		{
			loadCmd += " OVERWRITE"
		}
		loadCmd += " INTO TABLE ${qry.qSpec.tableOut.tableName}"
		if ( qry.qSpec.tableOut.partitionClause )
		{
			loadCmd += " PARTITION ${qry.qSpec.tableOut.partitionClause}"
		}
		
		/*
		 * delete the _SUCCESS file; comes in the way of doing a load for RcFiles.
		 * also delete _logs directory
		 */
		if ( true )
		{
			FileSystem fs = FileSystem.get(URI.create(qry.qSpec.tableOut.outputPath), qry.cfg);
			Path p = new Path(qry.qSpec.tableOut.outputPath, "_SUCCESS")
			if ( fs.exists(p))
			{
				fs.delete(p, false)
			}
			p = new Path(qry.qSpec.tableOut.outputPath, "_logs")
			if ( fs.exists(p))
			{
				fs.delete(p, true)
			}
		}
		
		hiveQryExec.executeHiveQuery(loadCmd);
	}
	
	public void executeHiveQuery(String hQry) throws WindowingException
	{
		if ( hiveQryExec == null)
			throw new WindowingException("cannot execute hive Query: hiveQryExec not setup");
		hiveQryExec.executeHiveQuery(hQry);
	}

}

interface HiveQueryExecutor
{
	void executeHiveQuery(String hQry) throws WindowingException;
	String createTableAsQuery(String hQry) throws WindowingException;
	void dropTable(String tableName) throws WindowingException;
}

