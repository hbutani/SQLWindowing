package com.sap.hadoop.windowing

import java.io.IOException;

import org.apache.hadoop.hive.cli.CliSessionState;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.IOException;

import com.sap.hadoop.windowing.runtime.Mode;
import com.sap.hadoop.windowing.runtime.Utils;
import org.apache.hadoop.conf.Configuration;
import com.sap.hadoop.windowing.cli.WindowingClient3;
import com.sap.hadoop.windowing.query.Translator;
import com.sap.hadoop.windowing.runtime.Executor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import jline.ConsoleReader;
import jline.History;

import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.cli.CliDriver;
import org.apache.hadoop.hive.cli.CliSessionState;
import org.apache.hadoop.hive.cli.OptionsProcessor;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.exec.Utilities;
import org.apache.hadoop.hive.ql.processors.CommandProcessorFactory;
import org.apache.hadoop.hive.ql.session.SessionState;
import org.apache.hadoop.hive.ql.session.SessionState.LogHelper;
import org.apache.hadoop.hive.shims.ShimLoader;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

import com.sap.hadoop.windowing.query.QuerySpec;


/*
 * 
 * Notes:
 * 12/12/11		Cannot get WindowingHiveCliDriver to wrap Hive CliDriver; because Hive uses antlr 3.0.1; I am using antlr 3.3
 *
 */

class WindowingHiveCliDriver extends CliDriver {
	
	boolean windowingMode = true;
	WindowingClient3 wClient;
	Configuration cfg;
	LogHelper hiveConsole;
	
	public void setupWindowing() throws WindowingException
	{
		// not nice, but ...
		try
		{
			Field f = CliDriver.class.getDeclaredField("conf"); //NoSuchFieldException
			f.setAccessible(true);
			cfg = (Configuration) f.get(this); //IllegalAccessException
			
			f = CliDriver.class.getDeclaredField("console"); //NoSuchFieldException
			f.setAccessible(true);
			hiveConsole = (LogHelper) f.get(this); //IllegalAccessException
		}
		catch(Throwable t)
		{
			throw new WindowingException("Failed to access conf and console members from HiveCliDriver", t)
		}

		// initialize windowing client
		wClient = new WindowingClient3(this)
		
	}
	
//	public LogHelper getConsole() { return console; }
//	public  Configuration getConfiguration() { return this.conf; }
	
	public int processCmd(String cmd) {
		
		String cmd_trimmed = cmd.trim();
		String[] tokens = cmd_trimmed.split("\\s+");
		String cmd_1 = cmd_trimmed.substring(tokens[0].length()).trim();
		
		if (tokens[0].toLowerCase().equals("wmode") ) {
			if ( tokens.length == 2)
			{
				String m = tokens[1].toLowerCase()
				if ( m.equals("windowing"))
				{
					windowingMode = true;
					return 0;
				}
				else if ( m.equals("hive"))
				{
					windowingMode = false;
					return 0;
				}
				hiveConsole.printError("wmode windowing|hive");
				return 1;
			}
			hiveConsole.printInfo("windowing mode is " + (windowingMode ?  "on" : "off"));
			return 0;
		}
		
		/*
		 * treat a command as a windowing Query if:
		 * - we are in wmode=windowing & command starts with from. 
		 * - if this is true, try to parse it as a windowing Query; if parse succeeds treat Query as a Windowing Query.
		 */
		boolean execWQry = false
		
		if (windowingMode )
		{
			String query = Utils.unescapeQueryString(cmd);
			query = query.trim()
			if ( query.startsWith("from"))
			{
				/*
				 * try to parse it
				 */
				try
				{
					wClient.checkQuery(query)
					execWQry = true
				}
				catch(WindowingException we)
				{
					hiveConsole.printInfo("Failed to parse query as a windowing query "+ cmd +" "+ we.getLocalizedMessage(),
						org.apache.hadoop.util.StringUtils.stringifyException(we));
					hiveConsole.printInfo("treating query as hive query");
				}
			}
		}
		
		
		if (execWQry)
		{
			try
			{
				String query = Utils.unescapeQueryString(cmd);
				wClient.executeQuery(query);
				return 0;
			}
			catch(Exception e)
			{
				e.printStackTrace()
				hiveConsole.printError("Failed windowing query "+ cmd +" "+ e.getLocalizedMessage(),
					org.apache.hadoop.util.StringUtils.stringifyException(e));
				  return 1;
			}
		}
		else
		{
			return super.processCmd(cmd);
		}
	}
	
	public int processEmbeddedQuery(String hQry)
	{
		return super.processCmd(hQry);
	}

	public static void main(String[] args) throws Exception {
		OptionsProcessor oproc = new OptionsProcessor();
		
		if (!oproc.process_stage1(args)) {
			System.exit(1);
		}

		// NOTE: It is critical to do this here so that log4j is reinitialized
		// before any of the other core hive classes are loaded
		initHiveLog4j();
		
		HiveConf hConf = new HiveConf(SessionState.class);

		CliSessionState ss = new CliSessionState(hConf);
		ss.in = System.in;
		try {
			ss.out = new PrintStream(System.out, true, "UTF-8");
			ss.err = new PrintStream(System.err, true, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.exit(3);
		}

		if (!oproc.process_stage2(ss)) {
			System.exit(2);
		}

		// set all properties specified via command line
		HiveConf conf = ss.getConf();
		for (Map.Entry<Object, Object> item : ss.cmdProperties.entrySet()) {
			conf.set((String) item.getKey(), (String) item.getValue());
		}

		if (!ShimLoader.getHadoopShims().usesJobShell()) {
			// hadoop-20 and above - we need to augment classpath using hiveconf
			// components
			// see also: code in ExecDriver.java
			ClassLoader loader = conf.getClassLoader();
			String auxJars = HiveConf.getVar(conf, HiveConf.ConfVars.HIVEAUXJARS);
			if (StringUtils.isNotBlank(auxJars)) {
				loader = Utilities.addToClassPath(loader, StringUtils.split(auxJars, ","));
			}
			conf.setClassLoader(loader);
			Thread.currentThread().setContextClassLoader(loader);
		}

		SessionState.start(ss);

		// connect to Hive Server
		if (ss.getHost() != null) {
			ss.connect();
			if (ss.isRemoteMode()) {
				CliDriver.prompt = "[" + ss.host + ':' + ss.port + "] " + CliDriver.prompt;
				char[] spaces = new char[CliDriver.prompt.length()];
				Arrays.fill(spaces, ' ');
				CliDriver.prompt2 = new String(spaces);
			}
		}

		WindowingHiveCliDriver cli = new WindowingHiveCliDriver();

		// Execute -i init files (always in silent mode)
		cli.processInitFiles(ss);
		cli.setupWindowing()

		if (ss.execString != null) {
			System.exit(cli.processLine(ss.execString));
		}

		try {
			if (ss.fileName != null) {
				System.exit(cli.processFile(ss.fileName));
			}
		} catch (FileNotFoundException e) {
			System.err.println("Could not open input file for reading. (" + e.getMessage() + ")");
			System.exit(3);
		}
		
		ConsoleReader reader = new ConsoleReader();
		reader.setBellEnabled(false);
		// reader.setDebug(new PrintWriter(new FileWriter("writer.debug", true)));
		reader.addCompletor(getCommandCompletor());

		String line;
		final String HISTORYFILE = ".hivehistory";
		String historyFile = System.getProperty("user.home") + File.separator + HISTORYFILE;
		reader.setHistory(new History(new File(historyFile)));
		int ret = 0;

		String prefix = "";
		String curPrompt = prompt;
		while ((line = reader.readLine(curPrompt + "> ")) != null) {
			if (!prefix.equals("")) {
				prefix += '\n';
			}
			if (line.trim().endsWith(";") && !line.trim().endsWith("\\;")) {
				line = prefix + line;
				ret = cli.processLine(line);
				prefix = "";
				curPrompt = prompt;
			} else {
				prefix = prefix + line;
				curPrompt = prompt2;
				continue;
			}
		}

		ss.close();

		System.exit(ret);
	}
/* Copied from SessionState*/
/* Why is this done?
 *  because have beem testing with versions: hive-0.7.1-cdh3u1 and  hive-0.9.0-SNAPSHOT
 *  hive-0.9.0-SNAPSHOT initHiveLog4j method moved to LogUtils
 */
	
	public static final String HIVE_L4J = "hive-log4j.properties";
	public static final String HIVE_EXEC_L4J = "hive-exec-log4j.properties";
  
	public static void initHiveLog4j() {
	  // allow hive log4j to override any normal initialized one
	  URL hive_l4j = SessionState.class.getClassLoader().getResource(HIVE_L4J);
	  if (hive_l4j == null) {
		System.out.println(HIVE_L4J + " not found");
	  } else {
		LogManager.resetConfiguration();
		PropertyConfigurator.configure(hive_l4j);
	  }
	}
/* end: Copied from SessionState*/
  
}
