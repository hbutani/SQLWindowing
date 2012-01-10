package com.sap.hadoop.windowing.runtime

import groovy.lang.GroovyShell;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.apache.hadoop.conf.Configuration;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.parser.WindowingLexer;
import com.sap.hadoop.windowing.parser.WindowingParser;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QuerySpec;
import com.sap.hadoop.windowing.query.QuerySpecBuilder;
import com.sap.hadoop.windowing.query.Translator;

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
		
			CommonTreeAdaptor ta = (CommonTreeAdaptor) parser.getTreeAdaptor();
			QuerySpecBuilder v = new QuerySpecBuilder(adaptor : ta)
			v.visit(t)
			v.qSpec.queryStr = query
			return v.qSpec
		}
		catch(RecognitionException re)
		{
			throw new WindowingException("Parse Error:" + re.getMessage(), re)
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
		executor.execute(q)
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
}

