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
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.serializer.Serialization;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.InputSplit;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.mapred.InputFormat;
import org.apache.hadoop.mapred.OutputFormat;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.metadata.CompositeDataType;
import com.sap.hadoop.metadata.CompositeSerialization;
import com.sap.hadoop.metadata.CompositeWritable;
import com.sap.hadoop.metadata.WindowingKey;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.TableInput;
import com.sap.hadoop.windowing.query.TableOutput;

class Job extends Configured
{
	public static final String WINDOWING_JAR_FILE = "windowing.jar.file";
	public static final String WINDOWING_PARTITION_COLS = "windowing.partition.cols";
	public static final String WINDOWING_SORT_COLS = "windowing.sort.cols";
	public static final String WINDOWING_INPUT_DATABASE = "windowing.input.database";
	public static final String WINDOWING_INPUT_TABLE = "windowing.input.table";
	public static final String WINDOWING_KEY_TYPE = CompositeDataType.COMPOSITE_DATA_TYPE;
	public static final String WINDOWING_NUM_PARTION_COLUMNS = "windowing.number.of.partition.columns";
	public static final String WINDOWING_QUERY_STRING = "windowing.query.string";

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
		String partitionCols, String sortColumns, String windowingJarFile,
		String outputURI, Class<? extends OutputFormat> outputFormatClass) throws Exception
	{
	    FileSystem fs = FileSystem.get(URI.create(outputURI), getConf());
		Path outputPath = new Path(outputURI)
	    fs.delete(outputPath, true);
	    
		JobConf conf = new JobConf(getConf());
		if ( db != null )
			conf.set(WINDOWING_INPUT_DATABASE, db);
		conf.set(WINDOWING_INPUT_TABLE, tableName);
		conf.set(WINDOWING_PARTITION_COLS, partitionCols);
		conf.set(WINDOWING_SORT_COLS, sortColumns);
		
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
			conf.setOutputValueClass(Text.class);
			conf.setJar(windowingJarFile);
		}

		FileOutputFormat.setOutputPath(conf, outputPath);
					
	    conf.setJobName(jobName);
	    //getConf().setBoolean("mapred.compress.map.output", true);
	    conf.setMapperClass(Map.class);
	    conf.setReducerClass(Reduce.class);
	    conf.setOutputFormat(outputFormatClass);
	    conf.setOutputKeyClass(NullWritable.class);
	    conf.setMapOutputKeyClass(CompositeWritable.class);
		conf.setPartitionerClass(Partition.class);
		
		conf.setOutputKeyComparatorClass(CompositeDataType.CompositeWritableComparator.class);
		
		conf.setOutputValueGroupingComparator(OutputGroupingComparator.class);
		
		configureSortingDataType(fields, conf);
	    
	    JobClient.runJob(conf);
		
		return 0;
	}
	
	public int run(Query query) throws WindowingException
	{
		try
		{
			TableInput tblIn = query.qSpec.tableIn
			TableOutput tblOut = query.qSpec.tableOut
			
			String jobName = "Windowing Query: " + query.qSpec.toString()
			
			String db = null
			String tableName = tblIn.tableName
			
			String partitionCols = query.input.partitionColumns*.name.join(",")
			String sortCols = query.input.orderColumns*.name.join(",")
			String windowingJar = conf.get(WINDOWING_JAR_FILE)
			String outputURI = tblOut.outputPath
			String outputFormatClassName = tblOut.outputFormat;
			Class<? extends OutputFormat> outputFormatClass = (outputFormatClassName != null) ?
						(Class<? extends OutputFormat>) Class.forName(outputFormatClassName) : SequenceFileOutputFormat.class;
			return run(jobName, false, db, tableName, partitionCols, sortCols, windowingJar, outputURI, outputFormatClass)
		}
		catch(Throwable t)
		{
			throw new WindowingException(t);
		}
	}
	
	public void configureSortingDataType(List<FieldSchema> fields, JobConf jobconf) throws WindowingException
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

}
