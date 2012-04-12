package com.sap.hadoop.windowing.runtime.mr;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.util.StringUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.common.FileUtils;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.shims.ShimLoader;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.serializer.Serialization;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.metadata.CompositeDataType;
import com.sap.hadoop.metadata.CompositeSerialization;
import com.sap.hadoop.metadata.CompositeWritable;
import com.sap.hadoop.metadata.WindowingKey;
import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QuerySpec;
import com.sap.hadoop.windowing.query.TableInput;
import com.sap.hadoop.windowing.query.TableOutput;

import org.apache.commons.lang.StringUtils as CStringUtils;

class JobBase extends Configured
{
	public static final String WINDOWING_JAR_FILE = Constants.WINDOWING_JAR_FILE;
	public static final String WINDOWING_PARTITION_COLS = Constants.WINDOWING_PARTITION_COLS;
	public static final String WINDOWING_SORT_COLS = Constants.WINDOWING_SORT_COLS;
	public static final String WINDOWING_SORT_COLS_ORDER = Constants.WINDOWING_SORT_COLS_ORDER;
	public static final String WINDOWING_INPUT_DATABASE = Constants.WINDOWING_INPUT_DATABASE;
	public static final String WINDOWING_INPUT_TABLE = Constants.WINDOWING_INPUT_TABLE;
	public static final String WINDOWING_KEY_TYPE = Constants.WINDOWING_KEY_TYPE;
	public static final String WINDOWING_NUM_PARTION_COLUMNS = Constants.WINDOWING_NUM_PARTION_COLUMNS;
	public static final String WINDOWING_QUERY_STRING = Constants.WINDOWING_QUERY_STRING;
	public static final String WINDOWING_TEMP_TABLE = Constants.WINDOWING_TEMP_TABLE;
	public static final String WINDOWING_JOB_WORKING_DIR = Constants.WINDOWING_JOB_WORKING_DIR;
	public static final String WINDOWING_JOB_QUERY_FILE = Constants.WINDOWING_JOB_QUERY_FILE;
	
	private static final Log LOG = LogFactory.getLog("com.sap.hadoop.windowing.runtime.mr");

	public JobBase()
	{
	}
	

	public void configureSortingDataType(List<FieldSchema> fields, Configuration jobconf) throws WindowingException
	{
		try {

			String sortColStr = jobconf.get(Job.WINDOWING_SORT_COLS);
			String[] sortCols = sortColStr.split(",");
			String partColStr = jobconf.get(Job.WINDOWING_PARTITION_COLS);
			String[] partCols = partColStr.split(",");
			jobconf.setInt(Job.WINDOWING_NUM_PARTION_COLUMNS, partCols.length); 

			// setup a OI from the sortColums; get datatypes from hive table Defn
			StringBuilder sortColType = new StringBuilder();
			getTypeString(fields, sortColStr, sortCols, sortColType, partColStr, partCols)
			
			Properties props = new Properties();
			props.setProperty(org.apache.hadoop.hive.serde.Constants.LIST_COLUMNS, sortColStr);
			props.setProperty(org.apache.hadoop.hive.serde.Constants.LIST_COLUMN_TYPES, sortColType.toString());
			TypedBytesSerDe sortColsSerDe = new TypedBytesSerDe();
			sortColsSerDe.initialize(jobconf, props);
			StructObjectInspector sortColsOI = (StructObjectInspector) sortColsSerDe.getObjectInspector();
			
			// create a CompositeDataType based on OI; add it to job
			CompositeDataType sortDataType = CompositeDataType.define(sortColsOI);
			jobconf.set(WINDOWING_KEY_TYPE, sortDataType.toString())
			jobconf.setClass("io.serializations", CompositeSerialization.class, Serialization.class);
		}
		catch(WindowingException we)
		{
			throw we;
		}
		catch(Exception me) 
		{
			throw new WindowingException(me);
		}
	}


	public static void getTypeString(List<FieldSchema> fields, String sortColStr, String[] sortCols, 
		StringBuilder sortColType, String partColStr, String[] partCols) throws WindowingException
	{
		boolean first = true;
		int j = 0;
		for(String sCol: sortCols) 
		{
			// check if partCols[j] == sortCils[j] for the first K columns; K = partCols.length
			if ( j < partCols.length)
			{
				if ( !partCols[j].equals(sCol) )
				{
					throw new WindowingException(sprintf("Sort Columns '%s' must be a superset of PartColumns '%s'", sortColStr, partColStr))
				}
			}
			int i=0;
			for(;i < fields.size(); i++) {
				FieldSchema f = fields.get(i);
				if ( f.getName().equals(sCol) ) {
					if (first)
						first = false;
					else
						sortColType.append(",");
					sortColType.append(f.getType());
					break;
				}
			}
			if ( i == fields.size()) {
				throw new RuntimeException("Unknown column " + sCol);
			}
			j++;
		}
	}
	
	/* 
	 * copied from org.apache.hadoop.hive.ql.Context
	 */
	public static boolean isLocalOnlyExecutionMode(Configuration conf) 
	{
		return HiveConf.getVar(conf, HiveConf.ConfVars.HADOOPJT).equals("local");
	  }
	
	public static String getJobWorkingDir(Configuration conf, int jobId)
	{
		try 
		{
			Path p
			FileSystem fs
			String jobDir = "windowingJob-${jobId}"
			if(isLocalOnlyExecutionMode(conf))
			{
				fs = FileSystem.getLocal(conf);
				String dirName = System.getProperty("java.io.tmpdir")+ Path.SEPARATOR + System.getProperty("user.name") + Path.SEPARATOR + jobDir;
				p = new Path(dirName)
			}
			else
			{
				fs = FileSystem.get(conf)
				p = new Path(HiveConf.getVar(conf, HiveConf.ConfVars.SCRATCHDIR) + "/windowing", jobDir)
				p = FileUtils.makeQualified(p, conf);
			}
			
			fs.mkdirs(p);
			conf.set(JobBase.WINDOWING_JOB_WORKING_DIR, p.toString())
			return p.toString()
		} 
		catch (Exception e) 
		{
			throw new RuntimeException(e);
		}
	}
	
	public static void deleteJobWorkingDir(Configuration conf)
	{
		String dir = conf.get(JobBase.WINDOWING_JOB_WORKING_DIR)
		try 
		{
			Path p = new Path(dir)
			p.getFileSystem(conf).delete(p, true);
		} 
		catch (Exception e) 
		{
			LOG.warn("Error Removing job working dir: " + StringUtils.stringifyException(e));
		}
	}
	
	public static void addQuerySpecToJob(Configuration conf, String jobWorkingDir, QuerySpec qSpec) throws WindowingException
	{
		try
		{
			Path p = new Path(jobWorkingDir, "querySpec")
			FileSystem fs
			if(isLocalOnlyExecutionMode(conf))
			{
				fs = FileSystem.getLocal(conf);
			}
			else
			{
				fs = FileSystem.get(conf)
			}
			FSDataOutputStream out = fs.create(p, true);
			qSpec.write(out)
			out.close()
			
			if (!isLocalOnlyExecutionMode(conf) ) {
				// Set up distributed cache
				DistributedCache.createSymlink(conf);
				String uriWithLink = p.toUri().toString() + "#WINDOWING_QUERY";
				DistributedCache.addCacheFile(new URI(uriWithLink), conf);

				// set replication of the plan file to a high number. we use the same
				// replication factor as used by the hadoop jobclient for job.xml etc.
				short replication = (short) conf.getInt("mapred.submit.replication", 10);
				fs.setReplication(p, replication);
			}
			
			conf.set(WINDOWING_JOB_QUERY_FILE, p.toString())
			
		}
		catch(Exception e)
		{
			throw new WindowingException(e)
		}
	}
	
	public static QuerySpec getQuerySpec(Configuration conf) throws WindowingException
	{
		try
		{
			String pName = conf.get(WINDOWING_JOB_QUERY_FILE)
			Path p = new Path(pName)
			FileSystem fs
			if(isLocalOnlyExecutionMode(conf))
			{
				fs = FileSystem.getLocal(conf);
			}
			else
			{
				fs = FileSystem.get(conf)
			}
			FSDataInputStream din = fs.open(p);
			QuerySpec qSpec = new QuerySpec()
			qSpec.readFields(din)
			return qSpec
			
		}
		catch(Exception e)
		{
			throw new WindowingException(e)
		}
	}
	
	/*
	 * Copied from org.apache.hadoop.hive.ql.exec.ExecDriver
	 */
	public static void addJars(JobConf job)
	{
		
		String s = HiveConf.getVar(job, HiveConf.ConfVars.HIVEJAR);
		
		// Transfer HIVEAUXJARS and HIVEADDEDJARS to "tmpjars" so hadoop understands
		// it
		String auxJars = HiveConf.getVar(job, HiveConf.ConfVars.HIVEAUXJARS);
		String addedJars = HiveConf.getVar(job, HiveConf.ConfVars.HIVEADDEDJARS);
		
		String hiveJars = getHiveJars(job)
		
		String allJars = [auxJars, addedJars, hiveJars].findAll{ e -> CStringUtils.isNotBlank(e) }.join(",")
		
		if (allJars) 
		{
		  LOG.info("adding libjars: " + allJars);
		  initializeFiles(job, "tmpjars", allJars);
		}
	
		// Transfer HIVEADDEDFILES to "tmpfiles" so hadoop understands it
		String addedFiles = HiveConf.getVar(job, HiveConf.ConfVars.HIVEADDEDFILES);
		if (CStringUtils.isNotBlank(addedFiles)) 
		{
		  initializeFiles(job, "tmpfiles", addedFiles);
		}
		
		boolean noName = CStringUtils.isEmpty(HiveConf.getVar(job, HiveConf.ConfVars.HADOOPJOBNAME));
	
		String addedArchives = HiveConf.getVar(job, HiveConf.ConfVars.HIVEADDEDARCHIVES);
		// Transfer HIVEADDEDARCHIVES to "tmparchives" so hadoop understands it
		if (CStringUtils.isNotBlank(addedArchives)) {
		  initializeFiles(job, "tmparchives", addedArchives);
		}
	}
	
	private static void initializeFiles(JobConf job, String prop, String files) 
	{
		if (files != null && files.length() > 0) 
		{
		  job.set(prop, files);
		  ShimLoader.getHadoopShims().setTmpFiles(prop, files);
		}
	}
	
	public static String getHiveJars(Configuration job) throws WindowingException
	{
		LocalFileSystem fs = FileSystem.getLocal(job)
		
		String hiveHome = System.getenv("HIVE_HOME")
		
		// for testing purposes
		hiveHome = hiveHome == null ? job.get("HIVE_HOME") : hiveHome
		
		if ( !hiveHome )
		{
			throw new WindowingException("Environment variable HIVE_HOME must be set.")
		}
		
		hiveHome = hiveHome.endsWith(File.separator) ? hiveHome : hiveHome + File.separator
		
		String hiveLib = hiveHome + "lib/"
		
		ArrayList<String> hiveJars = [
			"hive-exec-*.jar",
			"hive-contrib-*.jar",
			"groovy-all-*.jar",
			"hive-metastore-*.jar"]
		
		return hiveJars.collect { j -> resolveJar(fs, hiveLib, j) }.join(",")
		
	}
	
	private static String resolveJar(LocalFileSystem fs, String hivelib, String pattern)
	{
		Path p = new Path(hivelib + pattern)
		FileStatus[] files = fs.globStatus(p);
		 
		if (!files)
		{
			throw new WindowingException(sprintf("Failed to find jar %s", pattern))
		}
		
		return files.collect{ f -> f.path.toString() }.join(",")
		
	}

}
