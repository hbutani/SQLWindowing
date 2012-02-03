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
	MR(new MRTranslator(), new MRExecutor()),
	MRTEST(new MRTranslator(), new MRExecutor());
	
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
	
}
