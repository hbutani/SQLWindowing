package com.sap.hadoop.windowing.runtime.mr

import org.apache.hadoop.conf.Configuration;

import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.runtime.Executor;

class MRExecutor extends Executor
{
	void execute(Query qry)
	{
		Job j = new Job();
		Configuration conf = qry.cfg
		conf.set("keep.failed.task.files", "true");
		conf.set("mapred.map.max.attempts", "2");
		conf.set("mapred.child.java.opts", "-Xmx2048m")
		j.setConf(conf);
		int eCode = j.run(qry);
	}
}
