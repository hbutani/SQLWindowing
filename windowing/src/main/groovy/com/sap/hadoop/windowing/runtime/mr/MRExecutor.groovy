package com.sap.hadoop.windowing.runtime.mr

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions.FunctionRegistry;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.QuerySpec;
import com.sap.hadoop.windowing.runtime.Executor;
import com.sap.hadoop.windowing.runtime.WindowingShell;

class MRExecutor extends Executor
{
	private static final Log LOG = LogFactory.getLog("com.sap.hadoop.windowing.runtime.mr");
	
	void execute(Query qry, WindowingShell wShell) throws WindowingException
	{
		Job j = new Job();
		Configuration conf = qry.cfg
		HiveConf hConf = HiveUtils.getHiveConf(conf);
		hConf.set("keep.failed.task.files", "true");
		hConf.set("mapred.map.max.attempts", "2");
		hConf.set("mapred.child.java.opts", "-Xmx2048m")
		hConf.set(Job.WINDOWING_QUERY_STRING, qry.qSpec.queryStr)
		if ( qry.qSpec.tableIn.hiveQuery != null )
		{
			hConf.set(Job.WINDOWING_TEMP_TABLE, qry.qSpec.tableIn.tableName)
		}

		j.setConf(hConf);
		
		String jobWorkingDir = hConf.get(Job.WINDOWING_JOB_WORKING_DIR);
		JobBase.addQuerySpecToJob(hConf, jobWorkingDir, qry.qSpec)
		
		int eCode = j.run(qry);
	}
	
	/*
	 * Marker method to let WShell if Executor can componentize the User Query.
	 * Componentization only supported in MR mode.
	 */
	boolean allowQueryComponentization()
	{
		return true;
	}
	
	/*
	 * hook to allow Executor to setup execution for 1 or more component Queries.
	 */
	void beforeExecute(Query qry, ArrayList<Query> componentQueries, WindowingShell wShell)
	{
		/*
		* create a temp directory for the Job
		*/
	   int jobId = System.currentTimeMillis()
	   JobBase.getJobWorkingDir(qry.cfg, jobId)
	   
	   JobSpec jSpec = new JobSpec(componentQueries);
	   LOG.debug(sprintf("Query executed as following Job chain:\n %s", jSpec.toString()))
	}
	
	/*
	* hook to allow Executor to cleanup execution after 1 or more component Query executions.
	*/
   void afterExecute(Query qry, WindowingShell wShell)
   {
	   JobBase.deleteJobWorkingDir(qry.cfg)
   }
}

/**
 * Container for individual Component Query Job Specification's
 * @author harish.butani
 *
 */
class JobSpec
{
	ArrayList<JobComponentSpec> componentJobs
	
	public JobSpec(ArrayList<Query> componentQueries)
	{
		componentJobs = []
		JobComponentSpec jCSpec = null
		componentQueries.eachWithIndex { Query q, int idx ->
			jCSpec = new JobComponentSpec(num : idx, qry : q, previousJob : jCSpec);
			componentJobs << jCSpec
		}
	}
	
	public String toString()
	{
		StringBuilder buf = new StringBuilder();
		componentJobs.each { j -> buf.append(j.toString()).append("\n"); }
		return buf.toString();
	}
}

/**
 * Wrapper for each Component Query Spec.
 * @author harish.butani
 *
 */
class JobComponentSpec
{
	int num
	Query qry;
	JobComponentSpec previousJob;
	
	public String toString()
	{
		QuerySpec qSpec = qry.qSpec
		sprintf("Job %d[input=%s, map=%s, partition,order=([%s], [%s]), reduceChain=%s]",
				num, 
				previousJob == null ? qSpec.tableIn : "Job ${previousJob.num}",
				qSpec.tblFuncSpec != null && FunctionRegistry.hasMapPhase(qSpec.getFirstFunction().name) ? qSpec.getFirstFunction().name : "identity",
				qSpec.tableIn.partitionColumns.join(", "),  
				qSpec.tableIn.orderColumns.join(", "),
				qSpec.getFunctionChainStr())
	}
	
}