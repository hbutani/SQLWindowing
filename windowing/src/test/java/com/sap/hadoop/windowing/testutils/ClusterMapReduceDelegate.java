package com.sap.hadoop.windowing.testutils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import junit.framework.TestResult;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.MiniDFSCluster;
import org.apache.hadoop.mapred.ClusterMapReduceTestCase;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MiniMRCluster;
import org.apache.log4j.Logger;
import org.junit.AfterClass;

/*
 * Copied from Pro Hadoop book source code.
 */


public class ClusterMapReduceDelegate
{

	protected static Logger LOG = Logger
			.getLogger(ClusterMapReduceDelegate.class);

	/**
	 * The base JobConf object to use for all operations in the TestCases and
	 * classes under Test. Will be null if the cluster is not running.
	 */
	public static JobConf conf;

	/**
	 * The list of regular expressions for required hadoop core jars.
	 * 
	 * @return the coreJarPatterns
	 */
	public static String[] getCoreJarPatterns()
	{
		return coreJarPatterns;
	}

	/**
	 * The set of core jar file patterns to use.
	 * 
	 * @param coreJarPatterns
	 *            the coreJarPatterns to set
	 */
	public static void setCoreJarPatterns(String[] coreJarPatterns)
	{
		ClusterMapReduceDelegate.coreJarPatterns = coreJarPatterns;
	}

	/**
	 * Return the base {@link JobConf} object to use for any virtual cluster
	 * operations.
	 * 
	 * @return the conf may be null if the cluster is not running.
	 */
	public static JobConf getConf()
	{
		return conf;
	}

	/**
	 * Return the {@link FileSystem} object to use for interacting with the
	 * virtual cluster's HDFS.
	 * 
	 * @return the fs may be null if the cluster is not running.
	 */
	public static FileSystem getFs()
	{
		return fs;
	}

	/**
	 * Return the {@link Configuration} used to setup the Namenode.
	 * 
	 * @return the namenodeConf may be null if the cluster is not running.
	 */
	public static Configuration getNamenodeConf()
	{
		return namenodeConf;
	}

	/**
	 * Return the {@link Configuration} used to setup the Jobtracker.
	 * 
	 * @return the jobtrackerConf may be null if the cluster is not running.
	 */
	public static Configuration getJobtrackerConf()
	{
		return jobtrackerConf;
	}

	/**
	 * Return the URI to use for interacting with HDFS from the command line.
	 * 
	 * @return the hdfsURI may be null if the cluster is not running.
	 */
	public static URI getHdfsURI()
	{
		return hdfsURI;
	}

	/**
	 * Return the HTTP URL of the Namenode.
	 * 
	 * @return the namenodeURL may be null if the cluster is not running.
	 */
	public static String getNamenodeURL()
	{
		return namenodeURL;
	}

	/**
	 * Return the HTTP URL of the Jobtracker.
	 * 
	 * @return the jobtrackerURL may be null if the cluster is not running.
	 */
	public static String getJobtrackerURL()
	{
		return jobtrackerURL;
	}

	/**
	 * Return the directory used for log files by the cluster.
	 * 
	 * @return the logfileDir may be null if the cluster is not running.
	 */
	public static String getLogfileDir()
	{
		return logfileDir;
	}

	/**
	 * Return the list of System Properties considered important for Hadoop Core
	 * 
	 * @return the systemProperties
	 */
	public static String[] getSystemProperties()
	{
		return systemProperties;
	}

	/**
	 * Return the list of core resources required by Hadoop Core
	 * 
	 * @return the coreResources
	 */
	public static String[] getCoreResources()
	{
		return coreResources;
	}

	/**
	 * The base file system object to use to interact with HDFS. Will be null if
	 * the cluster is not running.
	 */
	protected static FileSystem fs;

	/**
	 * The {@link Configuration} object of the Namenode for the cluster. Will be
	 * null if the cluster is not running.
	 */
	protected static Configuration namenodeConf;

	/**
	 * The {@link Configuration} object of the Jobtracker for the cluster. Will
	 * be null if the cluster is not running.
	 */
	protected static Configuration jobtrackerConf;

	/**
	 * The URI to use for interacting with HDFS from the command line, the
	 * argument to pass to the -fs flag on the bin/hadoop command line. Will be
	 * null if the cluster is not running.
	 */
	protected static URI hdfsURI;

	/**
	 * The URL of the Namenode web interface. Use HTTP protocol. Will be null if
	 * the cluster is not running.
	 */
	protected static String namenodeURL;

	/**
	 * The URL of the Jobtracker web interface. Use HTTP protocol. Will be null
	 * if the cluster is not running.
	 */
	protected static String jobtrackerURL;

	/**
	 * The directory in the local file system that log files will be written to.
	 * Will be null if the cluster is not running.
	 */
	protected static String logfileDir;

	/**
	 * This is the ideal method to call in your @BeforeClass test case method.
	 * It sets up the cluster and initializes useful variables.
	 * 
	 * @throws Exception
	 */
	public static void setupTestClass() throws Exception
	{
		setupTestClass(false);
	}

	/**
	 * This is the ideal method to call in your @BeforeClass test case method.
	 * It sets up the cluster and initializes useful variables.
	 * 
	 * @param local
	 *            TODO
	 * 
	 * @throws Exception
	 */
	public static void setupTestClass(boolean local) throws Exception
	{
		internSetUpBeforeClass(local);
		conf = createJobConf();
		if (local)
		{
			conf.set("fs.default.name", "file:///");
			conf.set("mapred.job.tracker", "local");
			fs = new Path(".").getFileSystem(conf);
			hdfsURI = new URI("file:///");
		}
		else
		{
			fs = getFileSystem();
			hdfsURI = fs.getUri();

			namenodeConf = getHDFSConfiguration();
			if (namenodeConf != null)
			{
				namenodeURL = namenodeConf.get("dfs.http.address");
			}

			jobtrackerConf = getJobTrackerConfiguration();
			if (jobtrackerConf != null)
			{
				jobtrackerURL = jobtrackerConf
						.get("mapred.job.tracker.http.address");
			}
			
			//Configuration.dumpConfiguration(jobtrackerConf, new OutputStreamWriter(System.out));
		}
	}

	/**
	 * This is the ideal method to call in your @AfterClass test case method. It
	 * cleans up the cluster and de-initializes variables.
	 */
	@AfterClass
	public static void teardownTestClass() throws Exception
	{
		internTearDownAfterClass();
		conf = null;
		fs = null;
		namenodeConf = null;
		jobtrackerConf = null;
		hdfsURI = null;
		namenodeURL = null;
		jobtrackerURL = null;
		logfileDir = null;
	}

	/**
	 * The HadoopCore code uses JUnit3 and does not support the annotations of
	 * JUnit4. This wrapper provides a way of handling that and of handling the
	 * static nature of the JUnit4 setup and teardown annotations.
	 * 
	 * @author Jason
	 * 
	 */
	static public class Wrapper extends ClusterMapReduceTestCase
	{
		/**
		 * Extracted configuration from the {@link MiniDFSCluster} object after
		 * cluster start.
		 */
		protected static Configuration hDFSConfiguration = null;

		/**
		 * Extracted configuration from the {@link MiniMRCluster} after cluster
		 * start.
		 */
		protected static Configuration jobTrackerConfiguration = null;

		/**
		 * This method launches a mini virtual cluster. It takes wall clock time
		 * for this to start. If the cluster is already running, this is a noop.
		 * 
		 * This method eventually will call the startCluster method, which
		 * actually does the cluster setup.
		 * 
		 * The underlying code accepts many parameters but the exposed interface
		 * uses the defaults.
		 */
		public void setUp() throws Exception
		{
			super.setUp();

		}

		/**
		 * Return the Configuration objected in use by the
		 * {@link MiniDFSCluster} private object in the base class. This will be
		 * null if the cluster has not been started or has been torn down.
		 * 
		 * @return the hDFSConfiguration
		 */
		public static Configuration getHDFSConfiguration()
		{
			return hDFSConfiguration;
		}

		/**
		 * Return the Configuration objected in use by the {@link MiniMRCluster}
		 * private object in the base class. This will be null if the cluster
		 * has not been started or has been torn down.
		 * 
		 * @return the jobTrackerConfiguration
		 */
		public static Configuration getJobTrackerConfiguration()
		{
			return jobTrackerConfiguration;
		}

		/**
		 * Actually start a cluster. If the cluster is already running this will
		 * be a noop.
		 * 
		 * It is unclear if it is ever possible to restart a stopped cluster and
		 * get old data.
		 * 
		 * @param reformatDFS
		 *            If true, the DFS will be reformatted on start, wiping any
		 *            prior state.
		 * @param props
		 *            The key value pairs are stored directly in the JobConf
		 *            objected used to start the HDFS cluster and to the
		 *            Map/Reduce Cluster. Value may be null.
		 * 
		 */
		protected synchronized void startCluster(boolean reformatDFS,
				Properties props) throws Exception
		{
			LOG.info("Virtual Cluster Starting");
			super.startCluster(reformatDFS, props);
			LOG.info("Virtual Cluster Started");
			setHDFSConfiguration();
			setJobTrackerConfiguration();

		}

		/**
		 * Attempt to extract the {@link Configuration} object from the
		 * {@link MiniMRCluster} object in the base class.
		 * 
		 * Note: This uses reflection to extract private members out of objects,
		 * and will fail if the underlying object structure changes.
		 * 
		 * @throws IllegalAccessException
		 *             under unexpected situations
		 */
		protected void setJobTrackerConfiguration()
				throws IllegalAccessException
		{
			/** Only do something if the value is unset. */
			if (jobTrackerConfiguration == null)
			{
				/**
				 * Get the field information for the
				 * {@link ClusterMapReduceTestCase#mrCluster} field.
				 */
				FieldMappingData<ClusterMapReduceTestCase, MiniMRCluster> mrClusterField = new FieldMappingData<ClusterMapReduceTestCase, MiniMRCluster>(
						"org.apache.hadoop.mapred.ClusterMapReduceTestCase",
						"mrCluster");

				if (!mrClusterField.isValid())
				{
					LOG.warn(
							"Unable to find the field mrCluster in ClusterMapReduceTestCase",
							mrClusterField.getFailed());
					return;
				}
				/**
				 * Get the {@link MiniMRCluster#job} field out of the mrCluster.
				 */
				FieldMappingData<MiniMRCluster, Configuration> mrConfField = new FieldMappingData<MiniMRCluster, Configuration>(
						"org.apache.hadoop.mapred.MiniMRCluster", "job");
				if (!mrConfField.isValid())
				{
					LOG.warn("Unable to find the field job in MiniMRCluster",
							mrConfField.getFailed());
					return;
				}

				/** Now try to actually extract the member fields. */
				MiniMRCluster mrCluster = mrClusterField.getField(realObject);
				if (mrCluster == null)
				{
					LOG.warn("Unable to get the actual MiniRMCluster object out of the base class");
					return;
				}

				jobTrackerConfiguration = mrConfField.getField(mrCluster);
				if (jobTrackerConfiguration == null)
				{
					LOG.warn("Unable to get the actual job tracker configuration object out of the base class MiniMRCluster object");
				}
			}
		}

		/**
		 * Attempt to extract the {@link Configuration} object from the
		 * {@link MiniDFSCluster} object in the base class.
		 * 
		 * Note: This uses reflection to extract private members out of objects,
		 * and will fail if the underlying object structure changes.
		 * 
		 * @throws IllegalAccessException
		 */
		protected void setHDFSConfiguration() throws IllegalAccessException
		{
			if (hDFSConfiguration == null)
			{
				FieldMappingData<ClusterMapReduceTestCase, MiniDFSCluster> dfsClusterField = new FieldMappingData<ClusterMapReduceTestCase, MiniDFSCluster>(
						"org.apache.hadoop.mapred.ClusterMapReduceTestCase",
						"dfsCluster");
				if (!dfsClusterField.isValid())
				{
					LOG.warn(
							"Unable to find the field dfsCluster in ClusterMapReduceTestCase",
							dfsClusterField.getFailed());
					return;
				}
				/** Get the conf field out of the dfsCluster. */
				FieldMappingData<MiniDFSCluster, Configuration> dfsConfField = new FieldMappingData<MiniDFSCluster, Configuration>(
						"org.apache.hadoop.hdfs.MiniDFSCluster", "conf");
				if (!dfsConfField.isValid())
				{
					LOG.warn(
							"Unable to find the field conf in ClusterMapReduceTestCase",
							dfsClusterField.getFailed());
					return;
				}

				/** Now try to actually extract the member fields. */
				MiniDFSCluster dfsCluster = dfsClusterField
						.getField(realObject);
				if (dfsCluster == null)
				{
					LOG.warn("Unable to get the actual MiniDFSCluster object out of the base class");
					return;
				}

				hDFSConfiguration = dfsConfField.getField(dfsCluster);
				if (hDFSConfiguration == null)
				{
					LOG.warn("Unable to get the actual Namnode configuration object out of the base class MiniDFSCluster object");
				}
			}
		}

		/**
		 * This method will shutdown the HDFS and Map/Reduce clusters if they
		 * are running. No space is reclaimed.
		 * 
		 */
		public synchronized void stopCluster() throws Exception
		{
			LOG.info("Virtual Cluster Stopping");
			super.stopCluster();
			LOG.info("Virtual Cluster Stopped");
			hDFSConfiguration = null;
			jobTrackerConfiguration = null;
		}

		/**
		 * This method calls stopCluster and the JUnit3 teardown methods.
		 * 
		 */
		public void tearDown() throws Exception
		{
			super.tearDown();
		}

		/**
		 * Return the {@link FileSystem} to use for creating files on the
		 * virtual HDFS cluster. <Strong>This must be used or created files may
		 * not end up in the expected file system.</Strong>
		 * 
		 */
		public FileSystem getFileSystem()
		{
			try
			{
				return super.getFileSystem();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				throw new IllegalStateException("Can't get file system object",
						e);
			}
		}

		/**
		 * Return the root dir of the virtual HDFS cluster.
		 * 
		 * @return the {@link Path} to the / of the virtual hdfs cluster.
		 */
		public Path getTestRootDir()
		{
			return super.getTestRootDir();
		}

		/**
		 * Return the path to use for input to the map reduce test job,
		 * 
		 * @see org.apache.hadoop.mapred.ClusterMapReduceTestCase#getInputDir()
		 * 
		 * @return "input" as a {@link Path} object.
		 */
		public Path getInputDir()
		{
			return super.getInputDir();
		}

		/*
		 * Return the output directory to use for a map reduce test job.
		 * 
		 * @return "output" as a {@link Path} object.
		 * 
		 * @see org.apache.hadoop.mapred.ClusterMapReduceTestCase#getOutputDir()
		 */
		public Path getOutputDir()
		{
			return super.getOutputDir();
		}

		/**
		 * THe obj
		 */
		/**
		 * Return a properly configured JobConf object. The object is properly
		 * configured because the default file system and job tracker are set up
		 * to point to the virtual cluster.
		 * 
		 * <Strong>This JobConf object must be the base object used for any
		 * Map/Reduce jobs</conf>.
		 * 
		 * @return the JobConf object.
		 * @see org.apache.hadoop.mapred.ClusterMapReduceTestCase#createJobConf()
		 */
		public JobConf createJobConf()
		{
			return super.createJobConf();
		}
	};

	/** A singleton that holds the wrapped Hadoop Core Virtual Cluster class. */

	public static Wrapper realObject = new Wrapper();

	/**
	 * @return the hDFSConfiguration
	 */
	public static Configuration getHDFSConfiguration()
	{
		return Wrapper.getHDFSConfiguration();
	}

	/**
	 * @return the jobTrackerConfiguration
	 */
	public static Configuration getJobTrackerConfiguration()
	{
		return Wrapper.getJobTrackerConfiguration();
	}

	/** properties that must be defined. */
	protected static String[] systemProperties =
	{ "hadoop.log.dir", "hadoop.log.file", "hadoop.root.logger" };

	/** Resources that are good to have. */
	protected static String[] coreResources =
	{ "hadoop-default.xml", "webapps/datanode/WEB-INF/web.xml",
			"webapps/hdfs/WEB-INF/web.xml", "webapps/job/WEB-INF/web.xml",
			"webapps/task/WEB-INF/web.xml", "log4j.properties",
			"hadoop-metrics.properties" };

	/** Jars that are good to have. */
	protected static String[] coreJarPatterns =
	{ "hadoop-[^/\\\\]+?-core\\.jar$", "xmlenc-[^/\\\\]+?\\.jar$",
			"junit-[^/\\\\]+?\\.jar$", "commons-codec-[^/\\\\]+?\\.jar$",
			"commons-cli-[^/\\\\]+?\\.jar$",
			"commons-logging-[^/\\\\]+?\\.jar$", "jetty-[^/\\\\]+?\\.jar$",
			"jets3t-[^/\\\\]+?\\.jar$",
			"commons-logging-api-[^/\\\\]+?\\.jar$",
			"commons-httpclient-[^/\\\\]+?\\.jar$", "kfs-[^/\\\\]+?\\.jar$",
			"slf4j-log4j12-[^/\\\\]+?\\.jar$", "slf4j-api-[^/\\\\]+?\\.jar$",
			"servlet-api\\.jar$", "commons-el\\.jar$",
			"jasper-compiler\\.jar$", "jsp-api\\.jar$",
			"jasper-runtime\\.jar$", "commons-net-[^/\\\\]+?\\.jar$",
			"oro-[^/\\\\]+?\\.jar$", "log4j-[^/\\\\]+?\\.jar" };

	/**
	 * Given a Job Conf object, log useful fields to the passed in logger at
	 * info level.
	 * 
	 * This method will also reach into the DFSCluster and MRCluster config to
	 * print out their configurations and web addresses.
	 * 
	 * @param conf
	 *            The conf object to examine - should be the result of
	 *            {@link ClusterMapReduceTestCase#createJobConf()}.
	 * @param log
	 *            The {@link Logger} object to use for logging.
	 * 
	 * @throws IOException
	 *             If there is any error working with the parameters.
	 */
	public static void logConfiguration(JobConf conf, Logger log)
			throws IllegalAccessException, IOException
	{
		if (conf == null)
		{
			log.error("must supply a valid JobConf object, not null");
			return;
		}

		log.info("fs.default.name, the HDFS url: "
				+ conf.get("fs.default.name"));
		log.info("mapred.job.tracker.http.address, Jobtracker Web UI URL: "
				+ conf.get("mapred.job.tracker.http.address"));

		if (conf.get("dfs.http.address").startsWith("0.0.0.0:"))
		{
			ClusterMapReduceDelegate.extractVirtualDFSParameters(conf);
		}
		log.info("dfs.http.address, The Namenode Web UI URL:"
				+ conf.get("dfs.http.address"));
		log.info("hadoop.log.dir, The directory for logfiles: "
				+ System.getProperty("hadoop.log.dir"));
		log.info("hadoop.root.logger, The log4j root logger config: "
				+ System.getProperty("hadoop.root.logger"));
		log.info("hadoop.log.file, The log4j log file: "
				+ System.getProperty("hadoop.log.file"));
		log.info("JVM working directory, the root of relative paths: "
				+ System.getProperty("user.dir"));

		log.info("mapred.system.dir, System directory for Job Files: "
				+ conf.get("mapred.system.dir"));
		log.info("mapred.job.tracker, internal address: "
				+ conf.get("mapred.job.tracker"));

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		Configuration dfsConf = getHDFSConfiguration();
		if (dfsConf != null)
		{
			dfsConf.writeXml(baos);
			log.info("HDFS Configuration File: " + baos.toString("UTF-8"));
		}

		Configuration jobConf = getJobTrackerConfiguration();
		if (jobConf != null)
		{
			baos.reset();
			jobConf.writeXml(baos);
			log.info("JobTracker Configuration File: " + baos.toString("UTF-8"));
		}

	}

	/**
	 * Log to info, the locations of all of the default resources in the class
	 * path.
	 * 
	 * @param log
	 *            The {@link Logger} objec to log to at info level.
	 * 
	 * @throws MalformedURLException
	 *             If a resource name is maformed in some unexpected manner.
	 */
	public static void logDefaults(Logger log) throws MalformedURLException
	{
		/** Collect the locations of the default resourcs in this map. */
		Set<Map.Entry<String, URL>> defaultResources = findDefaults()
				.entrySet();

		/** Log the missing resources first. */
		for (Map.Entry<String, URL> missingResource : defaultResources)
		{
			if (missingResource.getValue() == null)
			{
				log.error("Missing Resource " + missingResource.getKey());
			}
		}

		/** Log the found resources. */
		for (Map.Entry<String, URL> foundResource : defaultResources)
		{
			if (foundResource.getValue() != null)
			{
				log.error("Resource " + foundResource.getKey() + " maps to "
						+ foundResource.getValue());
			}
		}

	}

	/**
	 * Return a map of needed resources and the URL it was found at.
	 * 
	 * The URL may be null if the resource was not found.
	 * 
	 * This method does not search within archives for jars.
	 * 
	 * @return THe map of resource names to the url it was found at.
	 * @throws MalformedURLException
	 */
	public static SortedMap<String, URL> findDefaults()
			throws MalformedURLException
	{
		/** Set of all jar pattern with their {@link Matcher}. */
		TreeMap<String, Matcher> patterns = new TreeMap<String, Matcher>();

		/** Map of the resource and the found URL, which may be null. */
		TreeMap<String, URL> found = new TreeMap<String, URL>();

		/** The classloader to load with for simple resources. */
		ClassLoader loader = found.getClass().getClassLoader();

		/** Get the properties. */
		for (String property : getSystemProperties())
		{
			String value = System.getProperty(property);
			if (value == null)
			{
				found.put(property, null);
			}
			else
			{
				found.put(property, new URL("file", "System.Property", value));
			}
		}

		/**
		 * Walk the list of simple resources and determine what the resource URL
		 * is, and save the result away in found.
		 */
		for (String simpleResouce : getCoreResources())
		{
			URL url = loader.getResource(simpleResouce);
			found.put(simpleResouce, url);
			/** url may be null. */
		}
		/** We only expect to do this once, so just compile the patterns here. */
		/**
		 * Compile the jar patterns and store them in our map. A map is used so
		 * we can remove the ones that have been found in the test loop.
		 */
		for (String jarPattern : getCoreJarPatterns())
		{
			try
			{
				Pattern p = Pattern.compile(jarPattern,
						Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
				patterns.put(jarPattern, p.matcher(""));
			}
			catch (PatternSyntaxException e)
			{
				/** Add a message about which pattern could not be compiled. */
				throw new IllegalArgumentException("Can't compile jar pattern "
						+ jarPattern, e);
			}
		}

		/**
		 * Burst the class path and store the elements. If the System runtime is
		 * badly setup this will NPE.
		 */
		String[] classPathElements = StringUtils.split(
				System.getProperty("java.class.path"),
				System.getProperty("path.separator"));

		/**
		 * Run the path elements against our map. Note: This will not find jars
		 * nested in jars.
		 */
		for (String pathElement : classPathElements)
		{
			String foundPattern = null;
			if (patterns.isEmpty())
			{
				break;
				/** Found all of our patterns. */
			}
			/**
			 * walk through all of the patterns and see if this entry is a match
			 * for one of them.
			 */
			for (Map.Entry<String, Matcher> matchEntry : patterns.entrySet())
			{
				String pattern = matchEntry.getKey();
				Matcher matcher = matchEntry.getValue();
				matcher.reset(pathElement);
				/**
				 * If pathElement is a match, try to construct a URL out of it
				 * if it is not one already.
				 */
				if (matcher.find())
				{
					URL resource;
					try
					{
						resource = new URL(pathElement);
					}
					catch (MalformedURLException e)
					{
						resource = new URL("file", null, pathElement);
					}
					if (resource.getProtocol() == null)
					{
						resource = new URL("file", null, pathElement);
					}
					/** Store it away and mark it as found. */
					found.put(pattern, resource);
					foundPattern = pattern;
					break;
				}
			}
			if (foundPattern != null)
			{
				patterns.remove(foundPattern);
			}
		}
		for (String missingJarPattern : patterns.keySet())
		{
			found.put(missingJarPattern, null);
		}
		return found;
	}

	/**
	 * For JUnit3 compatibility.
	 * 
	 * @return The number of test cases.
	 * @see junit.framework.TestCase#countTestCases()
	 */
	public int countTestCases()
	{
		return realObject.countTestCases();
	}

	/**
	 * Return the JobConf object to use for interacting with the virtual
	 * cluster.
	 * 
	 * @return A {@link JobConf} object to use for test cases.
	 * 
	 * @see org.apache.hadoop.mapred.ClusterMapReduceTestCase#createJobConf()
	 */
	public static JobConf createJobConf()
	{
		return realObject.createJobConf();
	}

	/**
	 * Delegate for wrapped object equals
	 * 
	 * @param obj
	 * @return true if obj == realObject
	 * @see org.apache.hadoop.mapred.ClusterMapReduceTestCase#equals(java.lang.Object)
	 */
	public boolean equals(Object obj)
	{
		return realObject.equals(obj);
	}

	/**
	 * @return
	 * @see org.apache.hadoop.mapred.ClusterMapReduceTestCase#getFileSystem()
	 */
	public static FileSystem getFileSystem()
	{
		return realObject.getFileSystem();
	}

	/**
	 * @return
	 * @see org.apache.hadoop.mapred.ClusterMapReduceTestCase#getInputDir()
	 */
	public Path getInputDir()
	{
		return realObject.getInputDir();
	}

	/**
	 * @return
	 * @see junit.framework.TestCase#getName()
	 */
	public String getName()
	{
		return realObject.getName();
	}

	/**
	 * @return
	 * @see org.apache.hadoop.mapred.ClusterMapReduceTestCase#getOutputDir()
	 */
	public Path getOutputDir()
	{
		return realObject.getOutputDir();
	}

	/**
	 * Return a path to the root.
	 * 
	 * @return a {@link Path} object that points to the parent of the current
	 *         working directory in the virtual file system.
	 * @see org.apache.hadoop.mapred.ClusterMapReduceTestCase#getTestRootDir()
	 */
	public Path getTestRootDir()
	{
		return realObject.getTestRootDir();
	}

	/**
	 * Since this is wrapping an object return the hash code of the wrapped
	 * object.
	 * 
	 * @return The hash code of {@link #realObject}.
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode()
	{
		return realObject.hashCode();
	}

	/**
	 * Run the test case, per JUnit3, using the wrapped object.
	 * 
	 * @return the test results
	 * @see junit.framework.TestCase#run()
	 */
	public TestResult run()
	{
		return realObject.run();
	}

	/**
	 * Run the test via the JUnit3, using the wrapped object.
	 * 
	 * @param result
	 *            The {@link TestResult} object to store the test results in.
	 * @see junit.framework.TestCase#run(junit.framework.TestResult)
	 */
	public void run(TestResult result)
	{
		realObject.run(result);
	}

	/**
	 * Another JUnit3 method, passed through to the the wrapped object.
	 * 
	 * @throws Throwable
	 * @see junit.framework.TestCase#runBare()
	 */
	public void runBare() throws Throwable
	{
		realObject.runBare();
	}

	/**
	 * Set the test case name on the wrapped object JUnit3 style.
	 * 
	 * @param name
	 *            The name of the test case
	 * @see junit.framework.TestCase#setName(java.lang.String)
	 */
	public void setName(String name)
	{
		realObject.setName(name);
	}

	/**
	 * This is a stub for JUnit3 users. It does nothing.
	 * 
	 * @throws Exception
	 * @see org.apache.hadoop.mapred.ClusterMapReduceTestCase#setUp()
	 */
	protected void setUp() throws Exception
	{

	}

	/**
	 * Actually run the cluster setup on the real object.
	 * 
	 * @param local
	 *            TODO
	 * 
	 * @throws Exception
	 * @see org.apache.hadoop.mapred.ClusterMapReduceTestCase#setUp()
	 */
	protected static void internSetUpBeforeClass(boolean local)
			throws Exception
	{
		setupDefaultSystemPropertiesIf();
		if (!local)
		{
			realObject.setUp();
		}
	}

	/**
	 * Setup sensible property values for the 3 core properties normally
	 * configured by bin/hadoop.
	 * 
	 * Only sets the values if they are missing.
	 * <ul>
	 * <li>Sets hadoop.log.dir, to java.io.tmpdir's value, or .</code></li>
	 * <li>Sets hadoop.log.file to hadoop.log</code></li>
	 * <li>Sets hadoop.root.logger to INFO,console</code></li>
	 * </ul>
	 */
	public static void setupDefaultSystemPropertiesIf()
	{
		if (System.getProperty("hadoop.log.dir") == null)
		{
			System.setProperty("hadoop.log.dir",
					System.getProperty("java.io.tmpdir", "."));
		}
		if (System.getProperty("hadoop.log.file") == null)
		{
			System.setProperty("hadoop.log.file", "hadoop.log");
		}
		if (System.getProperty("hadoop.root.logger") == null)
		{
			System.setProperty("hadoop.root.logger", "INFO,console");
		}
				
		if (System.getProperty("test.build.data") == null)
		{
			System.setProperty("test.build.data",
					System.getProperty("java.io.tmpdir", "."));
		}
		
		if (System.getProperty("mapred.local.dir") == null)
		{
			System.setProperty("mapred.local.dir",
					System.getProperty("java.io.tmpdir", "."));
		}
		
		System.setProperty("javax.xml.parsers.SAXParserFactory",
				"com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");
	}

	/**
	 * Pass a start request through to the wrapped object.
	 * 
	 * @param reformatDFS
	 *            Reformat the dfs cluster on start
	 * @param props
	 *            May be null, properties to store in the {@link JobConf} Object
	 *            for the virtual cluster.
	 * @throws Exception
	 * @see org.apache.hadoop.mapred.ClusterMapReduceTestCase#startCluster(boolean,
	 *      java.util.Properties)
	 */
	protected void startCluster(boolean reformatDFS, Properties props)
			throws Exception
	{
		realObject.startCluster(reformatDFS, props);
	}

	/**
	 * Really stop the cluster if it is running. This wipes the objects used to
	 * reference the running cluster after stopping them.
	 * 
	 * @throws Exception
	 * @see org.apache.hadoop.mapred.ClusterMapReduceTestCase#stopCluster()
	 */
	protected void stopCluster() throws Exception
	{
		realObject.stopCluster();
	}

	/**
	 * JUnit3 stub, does nothing.
	 * 
	 * @throws Exception
	 * @see org.apache.hadoop.mapred.ClusterMapReduceTestCase#tearDown()
	 */
	protected void tearDown() throws Exception
	{
		;
	}

	/**
	 * Tear Down the cluster.
	 * 
	 * @throws Exception
	 * @see org.apache.hadoop.mapred.ClusterMapReduceTestCase#tearDown()
	 */
	protected static void internTearDownAfterClass() throws Exception
	{
		realObject.tearDown();
	}

	/**
	 * Return the {@link #realObject}'s to string result.
	 * 
	 * @return
	 * @see junit.framework.TestCase#toString()
	 */
	public String toString()
	{
		return realObject.toString();
	}

	/**
	 * This method does bad things to get at the private Configuration field in
	 * the {@link MiniDFSCluster#conf} object that is private inside of the
	 * {@link ClusterMapReduceTestCase#dfsCluster}
	 * 
	 * If the private fields can be found, any configuration key that starts
	 * with "dfs." will be transcribed into the passed in <code>conf</code>
	 * 
	 * @param conf
	 *            The configuration object to store the dfs parameters.
	 */
	public static void extractVirtualDFSParameters(JobConf conf)
	{

		Configuration dfsConf = getHDFSConfiguration();
		if (dfsConf == null)
		{
			return;
		}

		/**
		 * Copy the keys that start with dfs out of the dfsCluster configuration
		 * into the passed in configuration.
		 */
		for (Entry<String, String> entry : dfsConf)
		{
			if (entry.getKey().startsWith("dfs."))
			{
				/** Do the get to ensure that variable expansion is correct. */
				conf.set(entry.getKey(), dfsConf.get(entry.getKey()));
			}
		}
	}
	
	public static class FieldMappingData<T, F>
	{
		final String className;
		final String fieldName;
		final Class<? extends T> working;
		final Field field;
		final Throwable failed;

		@SuppressWarnings("unchecked")
		public FieldMappingData(final String className, final String fieldName)
		{
			this.className = className;
			this.fieldName = fieldName;
			Class<? extends T> workingDummy = null;
			Field fieldDummy = null;
			Throwable failedDummy = null;
			try
			{
				Class<?> dummy1 = Class.forName(className);
				workingDummy = (Class<? extends T>) dummy1;

				Field[] fields = workingDummy.getDeclaredFields();
				for (Field field : fields)
				{
					if (this.fieldName.equals(field.getName()))
					{
						fieldDummy = field;
						fieldDummy.setAccessible(true);
						break;
					}
				}
			}
			catch (Throwable e)
			{
				failedDummy = e;
			}
			finally
			{
				failed = failedDummy;
				working = (Class<? extends T>) workingDummy;
				field = fieldDummy;
			}
		}

		@SuppressWarnings("unchecked")
		public F getField(T obj) throws IllegalAccessException
		{
			if (failed != null)
			{
				return null;
			}
			return (F) field.get(obj);
		}

		public boolean isValid()
		{
			return failed == null;
		}

		/**
		 * @return the className
		 */
		public String getClassName()
		{
			return className;
		}

		/**
		 * @return the fieldName
		 */
		public String getFieldName()
		{
			return fieldName;
		}

		/**
		 * @return the working
		 */
		public Class<? extends T> getWorking()
		{
			return working;
		}

		/**
		 * @return the field
		 */
		public Field getField()
		{
			return field;
		}

		/**
		 * @return the failed
		 */
		public Throwable getFailed()
		{
			return failed;
		}

	}
}
