package com.sap.hadoop.windowing.runtime2.mr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.shims.ShimLoader;
import org.apache.hadoop.mapred.JobConf;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.SerializationUtils;

public class FileUtils {
	private static final Log LOG = LogFactory.getLog(FileUtils.class.getName());

	public static void addJars(JobConf job)
	{
		
		String s = HiveConf.getVar(job, HiveConf.ConfVars.HIVEJAR);
		
		// Transfer HIVEAUXJARS and HIVEADDEDJARS to "tmpjars" so hadoop understands
		// it
		String auxJars = HiveConf.getVar(job, HiveConf.ConfVars.HIVEAUXJARS);
		String addedJars = HiveConf.getVar(job, HiveConf.ConfVars.HIVEADDEDJARS);
		
		String hiveJars = null;
		try {
			hiveJars = getHiveJars(job);
		} catch (WindowingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String allJars = auxJars + "," +  addedJars + "," +  hiveJars;
		
		if (allJars != null) 
		{
		  LOG.info("adding libjars: " + allJars);
		  initializeFiles(job, "tmpjars", allJars);
		}
	
		// Transfer HIVEADDEDFILES to "tmpfiles" so hadoop understands it
		String addedFiles = HiveConf.getVar(job, HiveConf.ConfVars.HIVEADDEDFILES);
		if (StringUtils.isNotBlank(addedFiles)) 
		{
		  initializeFiles(job, "tmpfiles", addedFiles);
		}
		
		boolean noName = StringUtils.isEmpty(HiveConf.getVar(job, HiveConf.ConfVars.HADOOPJOBNAME));
	
		String addedArchives = HiveConf.getVar(job, HiveConf.ConfVars.HIVEADDEDARCHIVES);
		// Transfer HIVEADDEDARCHIVES to "tmparchives" so hadoop understands it
		if (StringUtils.isNotBlank(addedArchives)) {
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
	
	public static String getHiveJars(Configuration job) throws WindowingException, IOException
	{
		LocalFileSystem fs = FileSystem.getLocal(job);
		
		String hiveHome = System.getenv("HIVE_HOME");
		
		// for testing purposes
		hiveHome = hiveHome == null ? job.get("HIVE_HOME") : hiveHome;
		
		if (hiveHome == null )
		{
			throw new WindowingException("Environment variable HIVE_HOME must be set.");
		}
		
		hiveHome = hiveHome.endsWith(File.separator) ? hiveHome : hiveHome + File.separator;
		
		String hiveLib = hiveHome + "lib/";
		
		ArrayList<String> hiveJars = new ArrayList<String>();
		hiveJars.add("hive-exec-*.jar");
		hiveJars.add("hive-contrib-*.jar");
		hiveJars.add("groovy-all-*.jar");
		hiveJars.add("hive-metastore-*.jar");
		Collection<String> libFiles = resolveJar(fs, hiveLib);
		hiveJars.addAll(libFiles);
		return hiveJars.toString();
		
	
	}
	
	private static Collection<String> resolveJar(LocalFileSystem fs, String hivelib) throws IOException, WindowingException
	{
		Path p = new Path(hivelib + "*.jar");
		Collection<String> libFiles = new ArrayList<String>();
	
		FileStatus[] files = fs.globStatus(p);
		for (FileStatus fileStatus : files) {
			libFiles.add(fileStatus.getPath().getName());
		}
		return libFiles;
		
	}
	  

}

