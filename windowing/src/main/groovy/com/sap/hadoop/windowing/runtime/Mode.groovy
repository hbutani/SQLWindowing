package com.sap.hadoop.windowing.runtime;

import groovy.lang.GroovyShell;

import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.apache.commons.cli.CommandLine;
import org.apache.hadoop.conf.Configuration;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.parser.WindowingLexer;
import com.sap.hadoop.windowing.parser.WindowingParser;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QuerySpec;
import com.sap.hadoop.windowing.query.QuerySpecBuilder;
import com.sap.hadoop.windowing.query.Translator;
import com.sap.hadoop.windowing.query.LocalTranslator;
import com.sap.hadoop.windowing.query.HiveTranslator;
import com.sap.hadoop.windowing.runtime.mr.MRTranslator;
import com.sap.hadoop.windowing.runtime.mr.MRExecutor;

/**
 * Is responsible for running an invocation of the Driver.
 * @author I821656
 *
 */
public enum Mode
{
	LOCAL(new LocalTranslator(), new Executor()),
	TEST(new LocalTranslator(), new TestExecutor()),
	HIVE(new HiveTranslator(), new Executor()),
	HIVETEST(new HiveTranslator(), new TestExecutor()),
	MR(new MRTranslator(), new MRExecutor());
	
	private final Translator translator;
	private final Executor executor;
	
	Mode(Translator translator, Executor executor)
	{
		this.translator = translator;
		this.executor = executor;
	}
	
	Translator getTranslator() { return translator; }
	Executor getExecutor() { return executor; }
	
	public static Mode getMode(String m)
	{
		m = m.toUpperCase().trim();
		return Mode.valueOf(m);
	}
	
	public void run(CommandLine cmdLine, Configuration cfg) throws WindowingException
	{
		String query = cmdLine.getOptionValue('q')
		query = Utils.unescapeQueryString(query);

		GroovyShell wshell = new GroovyShell()
		QuerySpec qSpec = parse(query)
		Query q = translate(wshell, qSpec, cfg)
		execute(wshell, q)
	}
	
	public static QuerySpec parse(String query) throws WindowingException
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
			return v.qSpec
		}
		catch(RecognitionException re)
		{
			throw new WindowingException("Parse Error:" + re.getMessage(), re)
		}
	}
	
	public Query translate(GroovyShell wshell, QuerySpec qSpec, Configuration cfg) throws WindowingException
	{
		return getTranslator().translate(wshell, qSpec, cfg);
	}
	
	public void execute(GroovyShell wshell, Query qry) throws WindowingException
	{
		getExecutor().execute(qry)
	}
}
