package com.sap.hadoop.windowing

import java.io.IOException;

import org.apache.hadoop.hive.cli.CliSessionState;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.IOException;

import com.sap.hadoop.windowing.runtime.Mode;
import com.sap.hadoop.windowing.runtime.Utils;
import org.apache.hadoop.conf.Configuration;
import com.sap.hadoop.windowing.cli.WindowingClient;
import com.sap.hadoop.windowing.query.Translator;
import com.sap.hadoop.windowing.runtime.Executor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
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

/*
 * 
 * Notes:
 * 12/12/11		Cannot get WindowingHiveCliDriver to wrap Hive CliDriver; because Hive uses antlr 3.0.1; I am using antlr 3.3
 *
 */

class WindowingHiveCliDriver extends CliDriver {
	
	CliDriver hiveDriver;
	boolean windowingMode = false;
	WindowingClient wClient;
	
	public WindowingHiveCliDriver(CliDriver hiveDriver) {
		this.hiveDriver = hiveDriver
	  }
	
	void setupClient(HiveConf hConf, String windowingJar) throws WindowingException
	{
		wClient = new WindowingClient(hConf, windowingJar)
	}
	
	public LogHelper getConsole() { return hiveDriver.console; }
	public  Configuration getConf() { return hiveDriver.conf; }
  public int processLine(String line) {
    int lastRet = 0, ret = 0;

    String command = "";
    for (String oneCmd : line.split(";")) {

      if (StringUtils.endsWith(oneCmd, "\\")) {
        command += StringUtils.chop(oneCmd) + ";";
        continue;
      } else {
        command += oneCmd;
      }
      if (StringUtils.isBlank(command)) {
        continue;
      }

      ret = processCmd(command);
      command = "";
      lastRet = ret;
      boolean ignoreErrors = HiveConf.getBoolVar(conf, HiveConf.ConfVars.CLIIGNOREERRORS);
      if (ret != 0 && !ignoreErrors) {
        CommandProcessorFactory.clean((HiveConf)conf);
        return ret;
      }
    }
    CommandProcessorFactory.clean((HiveConf)conf);
    return lastRet;
  }
	public int processReader(BufferedReader r) throws IOException { return hiveDriver.processReader(r); }
	public int processFile(String fileName) throws IOException { return hiveDriver.processFile(fileName); }
	public void processInitFiles(CliSessionState ss) throws IOException { hiveDriver.processInitFiles(ss); }
	
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
				console.printError("wmode windowing|hive");
				return 1;
			}
			console.printInfo("windowing mode is " + (windowingMode ?  "on" : "off"));
			return 0;
		}
		else if (windowingMode)
		{
			try
			{
				String query = Utils.unescapeQueryString(cmd);
				wClient.executeQuery(query);
				return 0;
			}
			catch(Exception e)
			{
				console.printError("Failed windowing query "+ cmd +" "+ e.getLocalizedMessage(),
					org.apache.hadoop.util.StringUtils.stringifyException(e));
				  return 1;
			}
		}
		else
		{
			if (cmd_trimmed.toLowerCase().equals("quit") || cmd_trimmed.toLowerCase().equals("exit"))
			{
				wClient.killServer();
			}
			return hiveDriver.processCmd(cmd);
		}
	}

	public static void main(String[] args) throws Exception {
		OptionsProcessor oproc = new OptionsProcessor();
		
		oproc.@options.addOption(OptionBuilder
        .hasArg()
        .withArgName("jar")
        .withDescription("windowing jar")
		.isRequired()
        .create('w'));
		
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

		WindowingHiveCliDriver cli = new WindowingHiveCliDriver(new CliDriver());

		// Execute -i init files (always in silent mode)
		cli.processInitFiles(ss);
		cli.setupClient(cli.conf, oproc.commandLine.getOptionValue('w'));

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
