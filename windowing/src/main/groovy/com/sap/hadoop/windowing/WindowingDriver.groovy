package com.sap.hadoop.windowing

import groovy.lang.Binding;

import java.util.Map;
import java.util.Properties;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.runtime.Mode;
import com.sap.hadoop.windowing.runtime.Utils;
import com.sap.hadoop.windowing.runtime.WindowingShell;
import com.sap.hadoop.windowing.runtime.mr.Job;

class WindowingDriver
{
	/* turn off logging */
	/*static {
		System.setProperty("org.apache.commons.logging.Log",
											 "org.apache.commons.logging.impl.NoOpLog");
 }*/

	CommandLine cmdLine
	Configuration cfg;
	Mode mode;
	
	void configure() throws Exception
	{
		if (cmdLine.hasOption('c'))
		{
			ClassLoader cLdr = HiveUtils.addToClassPath(getClass().getClassLoader(), cmdLine.getOptionValues('c'));
			Thread.currentThread().setContextClassLoader(cLdr);
		}
		
		cfg = new Configuration();
		
		mode = Mode.LOCAL
		if ( cmdLine.hasOption('m'))
			mode = Mode.getMode(cmdLine.getOptionValue('m'))
	
		/*
		 * this is for testing purposes only
		 */
		if ( (mode == Mode.HIVE || mode == Mode.HIVETEST )&& cmdLine.hasOption('i'))
		{
			String iFile = cmdLine.getOptionValue('i');
			System.setIn(new FileInputStream(iFile));
		}
		
		/*
		 * set Windowing jar
		 */
		String wJar = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		if ( mode == Mode.MR)
			cfg.set(Job.WINDOWING_JAR_FILE, wJar);
		// fixme: in test mode explicitly set this
		if ( mode == Mode.MRTEST)
			cfg.set(Job.WINDOWING_JAR_FILE, "e:/windowing/windowing.jar");
	}
	
	WindowingDriver(CommandLine cmdLine) throws WindowingException
	{
		this.cmdLine = cmdLine
		configure();
	}
	
	public void process() throws WindowingException
	{
		WindowingShell wshell = new WindowingShell(cfg, mode.translator, mode.executor);
		String query = cmdLine.getOptionValue('q')
		query = Utils.unescapeQueryString(query);
		wshell.execute(query);
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
		options.addOption(OptionBuilder.withArgName("dir").withLongOpt("confDir").withDescription("directory containing hive and hadoop conf files").hasArg().create('c'));
		
		return options;
	}
	
}

