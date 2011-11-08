package com.sap.hadoop.windowing

import groovy.lang.Binding;

import java.util.Map;
import java.util.Properties;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.windowing.parser.WindowingLexer;
import com.sap.hadoop.windowing.parser.WindowingParser;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QuerySpec;
import com.sap.hadoop.windowing.query.QuerySpecBuilder;
import com.sap.hadoop.windowing.runtime.Mode;
import com.sap.hadoop.windowing.runtime.Utils;

class WindowingDriver
{
	/* turn off logging */
	static {
		System.setProperty("org.apache.commons.logging.Log",
											 "org.apache.commons.logging.impl.NoOpLog");
 }

	Configuration cfg;
	Mode mode;
	String query;
	
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
			return v.qSpec
		}
		catch(RecognitionException re)
		{
			throw new WindowingException("Parse Error:" + re.getMessage(), re)
		}
	}
	
	public Query translate(Mode m, GroovyShell wshell, QuerySpec qSpec, Configuration cfg) throws WindowingException
	{
		return m.getTranslator().translate(wshell, qSpec, cfg);
	}
	
	public void execute(Mode m, GroovyShell wshell, Query qry) throws WindowingException
	{
		m.getExecutor().execute(qry)
	}

	void configure(CommandLine cmdLine) throws Exception
	{
		cfg = new Configuration();
		mode = Mode.LOCAL
		if ( cmdLine.hasOption('m'))
			mode = Mode.getMode(cmdLine.getOptionValue('m'))
		query = cmdLine.getOptionValue('q')
		query = Utils.unescapeQueryString(query);
		
		/*
		 * this is for testing purposes only
		 */
		if ( (mode == Mode.HIVE || mode == Mode.HIVETEST )&& cmdLine.hasOption('i'))
		{
			String iFile = cmdLine.getOptionValue('i');
			System.setIn(new FileInputStream(iFile));
		}
	}
	
	WindowingDriver(CommandLine cmdLine) throws WindowingException
	{
		configure(cmdLine);
	}
	
	public void process() throws WindowingException
	{
		GroovyShell wshell = new GroovyShell()
		QuerySpec qSpec = parse(query)
		Query q = translate(mode, wshell, qSpec, cfg)
		execute(mode, wshell, q)
	}

	public static void main(String[] args) throws Exception
	{
		CommandLineParser parser = new PosixParser();
		Options opts = options();
		CommandLine cmdLine = parser.parse(opts, args);
		
		if ( cmdLine.hasOption('h'))
		{
			HelpFormatter hf = new HelpFormatter();
			hf.printHelp("windowingDriver", opts);
			System.exit(0);
		}
		WindowingDriver drvr = new WindowingDriver(cmdLine);
		drvr.process();
	}
	
	static Options options()
	{
		Options options = new Options();
		options.addOption(OptionBuilder.withLongOpt("help").withDescription("help").hasArg(false).create('h'));
		options.addOption(OptionBuilder.withArgName("mode").withLongOpt("mode").withDescription("exec. mode").hasArg().create('m'));
		options.addOption(OptionBuilder.withArgName("query").withLongOpt("query").withDescription("com.sap.hadoop.windowing query").hasArg().isRequired().create('q'));
		options.addOption(OptionBuilder.withArgName("file").withLongOpt("hiveinput").withDescription("simulate hive input").hasArg().create('i'));
		
		return options;
	}
	
}

