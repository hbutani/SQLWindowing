package com.sap.hadoop.windowing.runtime.mr

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.serializer.Serialization;
import org.apache.hadoop.mapred.ClusterStatus;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.InputSplit;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.RunningJob;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.mapred.InputFormat;
import org.apache.hadoop.mapred.OutputFormat;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.metadata.CompositeWritable;
import com.sap.hadoop.metadata.OutputGroupingComparator;
import com.sap.hadoop.metadata.OutputKeyComparator;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.TableInput;
import com.sap.hadoop.windowing.query.TableOutput;

class Job extends JobBase
{
	public Job()
	{
	}
	
	public static void main(String[] args) throws Exception
	{
		Job j = new Job();
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://hbserver1.dhcp.pal.sap.corp:8020");
	    conf.set("mapred.job.tracker", "hbserver1.dhcp.pal.sap.corp:8021");
		
	    conf.set("hive.metastore.uris", "thrift://hbserver7.dhcp.pal.sap.corp:9083");
		//conf.set("hive.metastore.uris", "thrift://localhost:9083");
		conf.set("hive.metastore.local", "false");
	    //conf.addResource("hadoop-local.xml");
	    conf.set("keep.failed.task.files", "true");
	    conf.set("mapred.map.max.attempts", "2");
		conf.set("mapred.child.java.opts", "-Xmx2048m")
	    j.setConf(conf);
		int exitCode = j.run("Hive Windowing", false, null, "part_test", "p_mfgr", "p_mfgr,p_name", "e:/windowing/windowing.jar", 
			"windowing-output/", TextOutputFormat.class);
		System.exit(exitCode);
	}

	/**
	 * 
	 * @param jobName
	 * @param localMode		used to test on dev env. tableName used as directory in local hdfs; fmt assumed to be TextInputFormat
	 * @param db
	 * @param tableName
	 * @param partitionCols
	 * @param sortColumns
	 * @param windowingJarFile
	 * @param outputURI
	 * @param outputFormatClass
	 * @return
	 * @throws Exception
	 */
	@Override
	public int run(String jobName, boolean localMode, String db, String tableName,
		String partitionCols, String sortColumns, String sortOrder, String windowingJarFile,
		String outputURI, Class<? extends OutputFormat> outputFormatClass,
		boolean hasMapSideProcessing, Query query) throws Exception
	{
	    FileSystem fs = FileSystem.get(URI.create(outputURI), getConf());
		Path outputPath = new Path(outputURI)
	    fs.delete(outputPath, true);
	    
		JobConf conf = new JobConf(getConf(), this.getClass());
		if ( db != null )
			conf.set(WINDOWING_INPUT_DATABASE, db);
		conf.set(WINDOWING_INPUT_TABLE, tableName);
		conf.set(WINDOWING_PARTITION_COLS, partitionCols);
		conf.set(WINDOWING_SORT_COLS, sortColumns);
		conf.set(WINDOWING_SORT_COLS_ORDER, sortOrder)
		
		List<FieldSchema> fields;
		
		if (localMode)
		{
			FileInputFormat.addInputPath(conf, new Path(tableName));
			
			conf.setInputFormat(TextInputFormat.class);
			TextInputFormat iFmt = new TextInputFormat();
			iFmt.configure(conf);
			InputSplit[] iSplits = iFmt.getSplits(conf, 1);
			org.apache.hadoop.mapred.RecordReader<Writable, Writable> rdr = 
					(org.apache.hadoop.mapred.RecordReader<Writable, Writable>) iFmt.getRecordReader(iSplits[0], conf, Reporter.NULL);
		    conf.setOutputValueClass(rdr.createValue().getClass());
			conf.setNumReduceTasks(iSplits.length);
			fields = HiveUtils.getFields(db, tableName, conf);
		}
		else
		{
			fields = HiveUtils.addTableasJobInput(db, tableName, conf, fs);
			
			conf.setMapOutputValueClass(query.input.deserializer.getSerializedClass());
			
			//conf.setOutputValueClass(Text.class);
			
			conf.setOutputValueClass(query.output.serDe.getSerializedClass())
			
			if ( windowingJarFile != null )
			{
				conf.setJar(windowingJarFile);
			}
		}

		FileOutputFormat.setOutputPath(conf, outputPath);
					
	    conf.setJobName(jobName);
	    //getConf().setBoolean("mapred.compress.map.output", true);
		if ( !hasMapSideProcessing )
	    	conf.setMapperClass(Map.class);
		else
			conf.setMapperClass(TableFuncMap.class)
	    conf.setReducerClass(Reduce.class);
	    conf.setOutputFormat(outputFormatClass);
	    conf.setOutputKeyClass(NullWritable.class);
	    conf.setMapOutputKeyClass(CompositeWritable.class);
		conf.setPartitionerClass(Partition.class);
		
		conf.setOutputKeyComparatorClass(OutputKeyComparator.class);
		
		conf.setOutputValueGroupingComparator(OutputGroupingComparator.class);
		
		if (localMode)
		{
			configureSortingDataType(fields, conf);
		}
		else
		{
			configureSortingDataType(query, conf)
		}
	    
		JobBase.addJars(conf);
		
	    //JobClient.runJob(conf);
		
		JobClient jC = new JobClient(conf);
		
		/*
		 * if num reducers is set to -1; then set it to (number of free slots in cluster)/2
		 */
		int numReducers = conf.getNumReduceTasks()
		if ( numReducers == -1)
		{
			ClusterStatus cs = jC.getClusterStatus()
			numReducers = (cs.getMaxReduceTasks() - cs.getReduceTasks()) / 2
			numReducers = numReducers <= 0 ? 1 : numReducers
			conf.setNumReduceTasks(numReducers)
		}
		
		RunningJob rj = jC.submitJob(conf);
		
		WindowingJobTracker jT = new WindowingJobTracker(conf)
		return jT.progress(rj, jC)

	}
	
	public int run(Query query) throws WindowingException
	{
		try
		{
			TableInput tblIn = query.qSpec.tableIn
			TableOutput tblOut = query.qSpec.tableOut
			
			String jobName = "Windowing Query: " + query.qSpec.toString()
			
			String db = Hive.get(query.cfg).getCurrentDatabase()
			String tableName = tblIn.tableName
			
			String partitionCols = query.input.partitionColumns*.name.join(",")
			String sortCols = query.input.orderColumns*.name.join(",")
			String sortOrder = query.input.orderColumns*.order.join(",")
			String windowingJar = conf.get(WINDOWING_JAR_FILE)
			String outputURI = tblOut.outputPath
			String outputFormatClassName = tblOut.outputFormat;
			Class<? extends OutputFormat> outputFormatClass = (outputFormatClassName != null) ?
						(Class<? extends OutputFormat>) Class.forName(outputFormatClassName) : SequenceFileOutputFormat.class;
			boolean hasMapSideProcessing = query.mapPhase != null
			return run(jobName, false, db, tableName, partitionCols, sortCols, sortOrder, 
				windowingJar, outputURI, outputFormatClass, hasMapSideProcessing, query)
		}
		catch(Throwable t)
		{
			throw new WindowingException(t);
		}
	}
	
}
