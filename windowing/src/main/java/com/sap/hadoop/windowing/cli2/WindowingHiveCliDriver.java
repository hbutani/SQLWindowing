package com.sap.hadoop.windowing.cli2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

import jline.Completor;
import jline.ConsoleReader;
import jline.History;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.cli.CliDriver;
import org.apache.hadoop.hive.cli.CliSessionState;
import org.apache.hadoop.hive.cli.OptionsProcessor;
import org.apache.hadoop.hive.common.LogUtils;
import org.apache.hadoop.hive.common.LogUtils.LogInitializationException;
import org.apache.hadoop.hive.common.io.CachingPrintStream;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.exec.Utilities;
import org.apache.hadoop.hive.ql.session.SessionState;
import org.apache.hadoop.hive.ql.session.SessionState.LogHelper;
import org.apache.hadoop.hive.shims.ShimLoader;

import com.sap.hadoop.Utils;
import com.sap.hadoop.windowing.WindowingException;

public class WindowingHiveCliDriver extends CliDriver
{
	boolean windowingMode = true;
	WindowingClient wClient;
	HiveConf cfg;
	LogHelper hiveConsole;

	public void setupWindowing() throws WindowingException
	{
		// not nice, but ...
		try
		{
			Field f = CliDriver.class.getDeclaredField("conf"); // NoSuchFieldException
			f.setAccessible(true);
			cfg = (HiveConf) f.get(this); // IllegalAccessException

			f = CliDriver.class.getDeclaredField("console"); // NoSuchFieldException
			f.setAccessible(true);
			hiveConsole = (LogHelper) f.get(this); // IllegalAccessException
		}
		catch (Throwable t)
		{
			throw new WindowingException(
					"Failed to access conf and console members from HiveCliDriver",
					t);
		}

		// initialize windowing client
		wClient = new WindowingClient(this);

	}

	public int processCmd(String cmd)
	{

		String cmd_trimmed = cmd.trim();
		String[] tokens = cmd_trimmed.split("\\s+");

		if (tokens[0].toLowerCase().equals("wmode"))
		{
			if (tokens.length == 2)
			{
				String m = tokens[1].toLowerCase();
				if (m.equals("windowing"))
				{
					windowingMode = true;
					return 0;
				}
				else if (m.equals("hive"))
				{
					windowingMode = false;
					return 0;
				}
				hiveConsole.printError("wmode windowing|hive");
				return 1;
			}
			hiveConsole.printInfo("windowing mode is "
					+ (windowingMode ? "on" : "off"));
			return 0;
		}

		/*
		 * treat a command as a windowing Query if: - we are in wmode=windowing
		 * & command starts with from. - if this is true, try to parse it as a
		 * windowing Query; if parse succeeds treat Query as a Windowing Query.
		 */
		boolean execWQry = false;

		if (windowingMode)
		{
			String query = Utils.unescapeQueryString(cmd);
			query = query.trim();
			if (query.startsWith("from"))
			{
				/*
				 * try to parse it
				 */
				try
				{
					wClient.checkQuery(query);
					execWQry = true;
				}
				catch (WindowingException we)
				{
					hiveConsole.printInfo(
							"Failed to parse query as a windowing query " + cmd
									+ " " + we.getLocalizedMessage(),
							org.apache.hadoop.util.StringUtils
									.stringifyException(we));
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
			catch (Exception e)
			{
				e.printStackTrace();
				hiveConsole.printError("Failed windowing query " + cmd + " "
						+ e.getLocalizedMessage(),
						org.apache.hadoop.util.StringUtils
								.stringifyException(e));
				return 1;
			}
		}
		else
		{
			return super.processCmd(cmd);
		}
	}
	
/*
 * Start copy from CliDriver.
 */
	
	public static void main(String[] args) throws Exception
	{
		int ret = run(args);
		System.exit(ret);
	}

	public static int run(String[] args) throws Exception
	{

		OptionsProcessor oproc = new OptionsProcessor();
		if (!oproc.process_stage1(args))
		{
			return 1;
		}

		// NOTE: It is critical to do this here so that log4j is reinitialized
		// before any of the other core hive classes are loaded
		boolean logInitFailed = false;
		String logInitDetailMessage;
		try
		{
			logInitDetailMessage = LogUtils.initHiveLog4j();
		}
		catch (LogInitializationException e)
		{
			logInitFailed = true;
			logInitDetailMessage = e.getMessage();
		}

		CliSessionState ss = new CliSessionState(new HiveConf(
				SessionState.class));
		ss.in = System.in;
		try
		{
			ss.out = new PrintStream(System.out, true, "UTF-8");
			ss.info = new PrintStream(System.err, true, "UTF-8");
			ss.err = new CachingPrintStream(System.err, true, "UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			return 3;
		}

		if (!oproc.process_stage2(ss))
		{
			return 2;
		}

		if (!ss.getIsSilent())
		{
			if (logInitFailed)
			{
				System.err.println(logInitDetailMessage);
			}
			else
			{
				SessionState.getConsole().printInfo(logInitDetailMessage);
			}
		}

		// set all properties specified via command line
		HiveConf conf = ss.getConf();
		for (Map.Entry<Object, Object> item : ss.cmdProperties.entrySet())
		{
			conf.set((String) item.getKey(), (String) item.getValue());
			ss.getOverriddenConfigurations().put((String) item.getKey(),
					(String) item.getValue());
		}

		SessionState.start(ss);

		// connect to Hive Server
		if (ss.getHost() != null)
		{
			ss.connect();
			if (ss.isRemoteMode())
			{
				prompt = "[" + ss.getHost() + ':' + ss.getPort() + "] "
						+ prompt;
				char[] spaces = new char[prompt.length()];
				Arrays.fill(spaces, ' ');
				prompt2 = new String(spaces);
			}
		}

		// CLI remote mode is a thin client: only load auxJars in local mode
		if (!ss.isRemoteMode() && !ShimLoader.getHadoopShims().usesJobShell())
		{
			// hadoop-20 and above - we need to augment classpath using hiveconf
			// components
			// see also: code in ExecDriver.java
			ClassLoader loader = conf.getClassLoader();
			String auxJars = HiveConf.getVar(conf,
					HiveConf.ConfVars.HIVEAUXJARS);
			if (StringUtils.isNotBlank(auxJars))
			{
				loader = Utilities.addToClassPath(loader,
						StringUtils.split(auxJars, ","));
			}
			conf.setClassLoader(loader);
			Thread.currentThread().setContextClassLoader(loader);
		}

		WindowingHiveCliDriver cli = new WindowingHiveCliDriver();
		cli.setHiveVariables(oproc.getHiveVariables());

		// use the specified database if specified
		cli.processSelectDatabase(ss);

		// Execute -i init files (always in silent mode)
		cli.processInitFiles(ss);
		
		cli.setupWindowing();

		if (ss.execString != null)
		{
			return cli.processLine(ss.execString);
		}

		try
		{
			if (ss.fileName != null)
			{
				return cli.processFile(ss.fileName);
			}
		}
		catch (FileNotFoundException e)
		{
			System.err.println("Could not open input file for reading. ("
					+ e.getMessage() + ")");
			return 3;
		}

		ConsoleReader reader = new ConsoleReader();
		reader.setBellEnabled(false);
		// reader.setDebug(new PrintWriter(new FileWriter("writer.debug",
		// true)));
		for (Completor completor : getCommandCompletor())
		{
			reader.addCompletor(completor);
		}

		String line;
		final String HISTORYFILE = ".hivehistory";
		String historyDirectory = System.getProperty("user.home");
		try
		{
			if ((new File(historyDirectory)).exists())
			{
				String historyFile = historyDirectory + File.separator
						+ HISTORYFILE;
				reader.setHistory(new History(new File(historyFile)));
			}
			else
			{
				System.err
						.println("WARNING: Directory for Hive history file: "
								+ historyDirectory
								+ " does not exist.   History will not be available during this session.");
			}
		}
		catch (Exception e)
		{
			System.err
					.println("WARNING: Encountered an error while trying to initialize Hive's "
							+ "history file.  History will not be available during this session.");
			System.err.println(e.getMessage());
		}

		int ret = 0;

		String prefix = "";
		String curDB = getFormattedDb(conf, ss);
		String curPrompt = prompt + curDB;
		String dbSpaces = spacesForString(curDB);

		while ((line = reader.readLine(curPrompt + "> ")) != null)
		{
			if (!prefix.equals(""))
			{
				prefix += '\n';
			}
			if (line.trim().endsWith(";") && !line.trim().endsWith("\\;"))
			{
				line = prefix + line;
				ret = cli.processLine(line, true);
				prefix = "";
				curDB = getFormattedDb(conf, ss);
				curPrompt = prompt + curDB;
				dbSpaces = dbSpaces.length() == curDB.length() ? dbSpaces
						: spacesForString(curDB);
			}
			else
			{
				prefix = prefix + line;
				curPrompt = prompt2 + dbSpaces;
				continue;
			}
		}

		ss.close();

		return ret;
	}

	/**
	 * Retrieve the current database name string to display, based on the
	 * configuration value.
	 * 
	 * @param conf
	 *            storing whether or not to show current db
	 * @param ss
	 *            CliSessionState to query for db name
	 * @return String to show user for current db value
	 */
	private static String getFormattedDb(HiveConf conf, CliSessionState ss)
	{
		if (!HiveConf.getBoolVar(conf, HiveConf.ConfVars.CLIPRINTCURRENTDB))
		{
			return "";
		}
		String currDb = ss.getCurrentDbName();

		if (currDb == null)
		{
			return "";
		}

		return " (" + currDb + ")";
	}

	/**
	 * Generate a string of whitespace the same length as the parameter
	 * 
	 * @param s
	 *            String for which to generate equivalent whitespace
	 * @return Whitespace
	 */
	private static String spacesForString(String s)
	{
		if (s == null || s.length() == 0)
		{
			return "";
		}
		return String.format("%1$-" + s.length() + "s", "");
	}
	
/*
 * End copy from CliDriver.
 */	

	public int processEmbeddedQuery(String hQry)
	{
		return super.processCmd(hQry);
	}

	protected boolean isWindowingMode()
	{
		return windowingMode;
	}

	protected WindowingClient getwClient()
	{
		return wClient;
	}

	protected HiveConf getCfg()
	{
		return cfg;
	}

	protected LogHelper getHiveConsole()
	{
		return hiveConsole;
	}
}
