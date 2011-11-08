package com.sap.hadoop.windowing.runtime;

import java.util.Map;

import com.sap.hadoop.windowing.query.Translator;
import com.sap.hadoop.windowing.query.LocalTranslator;
import com.sap.hadoop.windowing.query.HiveTranslator;

public enum Mode
{
	LOCAL(new LocalTranslator(), new Executor()),
	TEST(new LocalTranslator(), new TestExecutor()),
	HIVE(new HiveTranslator(), new Executor()),
	HIVETEST(new HiveTranslator(), new TestExecutor());
	
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
