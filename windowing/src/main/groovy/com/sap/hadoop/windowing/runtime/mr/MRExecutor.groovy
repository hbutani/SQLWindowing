package com.sap.hadoop.windowing.runtime.mr

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.runtime.Executor;

class MRExecutor extends Executor
{
	void execute(Query qry)
	{
		Job j = new Job();
		Configuration conf = qry.cfg
		HiveConf hConf = HiveUtils.getHiveConf(conf);
		hConf.set("keep.failed.task.files", "true");
		hConf.set("mapred.map.max.attempts", "2");
		hConf.set("mapred.child.java.opts", "-Xmx2048m")
		hConf.set(Job.WINDOWING_QUERY_STRING, qry.qSpec.queryStr)
		j.setConf(hConf);
		int eCode = j.run(qry);
	}
}
