package com.sap.hadoop.windowing.runtime.mr

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.api.SerDeInfo;
import org.apache.hadoop.hive.metastore.api.StorageDescriptor;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.hadoop.hive.ql.exec.Utilities;
import org.apache.hadoop.hive.ql.plan.TableDesc;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils.ObjectInspectorCopyOption;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.LongWritable;
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

import com.sap.hadoop.metadata.CompositeDataType;
import com.sap.hadoop.metadata.CompositeSerialization;
import com.sap.hadoop.metadata.CompositeWritable;
import com.sap.hadoop.metadata.WindowingKey;

@SuppressWarnings("deprecation")
class Job extends Configured
{
	public static final String WINDOWING_PARTITION_COLS = "windowing.partition.cols";
	public static final String WINDOWING_SORT_COLS = "windowing.sort.cols";
	public static final String WINDOWING_INPUT_TABLE = "windowing.input.table";
	public static final String WINDOWING_KEY_TYPE = CompositeSerialization.COMPOSITE_DATA_TYPE;

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
		conf.set("hive.metastore.local", "false");
	    //conf.addResource("hadoop-local.xml");
	    conf.set("keep.failed.task.files", "true");
	    conf.set("mapred.map.max.attempts", "2");
		conf.set("mapred.child.java.opts", "-Xmx2048m")
	    j.setConf(conf);
		int exitCode = j.run("part_test", "p_mfgr", "p_mfgr,p_name", "e:/windowing/windowing.jar");
		System.exit(exitCode);
	}

	@Override
	public int run(String tableName, String partitionCols, String sortColumns, String windowingJarFile) throws Exception
	{
		String uri = "windowing-output/"; //args[0];
	    FileSystem fs = FileSystem.get(URI.create(uri), getConf());
	    fs.delete(new Path(uri), true);
	    
		HiveConf hConf = new HiveConf(getConf(), getClass());
		HiveMetaStoreClient client = new HiveMetaStoreClient(hConf);
		List<String> dbs = client.getAllDatabases();
		String db = dbs.get(0);
		List<String> tableNames = client.getAllTables(db);
		Table t = client.getTable(db, tableName);
		StorageDescriptor sd = t.getSd();
		SerDeInfo sInfo = sd.getSerdeInfo();
		
		Configuration cfg = getConf();
		//cfg.set("tmpjars", "file:///e:/hadoop/hive2/hive/build/dist/lib/hive-exec-0.9.0-SNAPSHOT.jar,file:///e:/hadoop/hive2/hive/build/dist/lib/hive-metastore-0.9.0-SNAPSHOT.jar");
		cfg.set(WINDOWING_INPUT_TABLE, tableName);
		cfg.set(WINDOWING_PARTITION_COLS, partitionCols);
		cfg.set(WINDOWING_SORT_COLS, sortColumns);
		
		JobConf conf = new JobConf(getConf());
	    conf.setJar(windowingJarFile);
	    FileInputFormat.addInputPath(conf, new Path(sd.getLocation()));
	    FileOutputFormat.setOutputPath(conf, new Path("windowing-output"));
		
		Class<? extends InputFormat<? extends Writable, ? extends Writable>> inputFormatClass = 
			(Class<? extends InputFormat<? extends Writable, ? extends Writable>>) Class.forName(sd.getInputFormat());
		Path tableDirPath = new Path(sd.getLocation());
		FileStatus tableDir = fs.getFileStatus(tableDirPath);
		assert tableDir.isDir();
		FileStatus[] tableFiles = fs.listStatus(tableDirPath);
		InputFormat<? extends Writable, ? extends Writable> iFmt = inputFormatClass.newInstance();
		if (iFmt instanceof TextInputFormat)
			((TextInputFormat)iFmt).configure(conf);

		if (iFmt instanceof TextInputFormat)
			((TextInputFormat)iFmt).configure(conf);
		InputSplit[] iSplits = iFmt.getSplits(conf, 1);
		org.apache.hadoop.mapred.RecordReader<Writable, Writable> rdr = (org.apache.hadoop.mapred.RecordReader<Writable, Writable>) iFmt.getRecordReader(iSplits[0], conf, Reporter.NULL);
		

	    
	    conf.setJobName("Hive Windowing");
	    //getConf().setBoolean("mapred.compress.map.output", true);
	    conf.setNumMapTasks(4);
	    conf.setNumReduceTasks(1);
	    conf.setMapperClass(Map.class);
	    conf.setReducerClass(Reduce.class);
	    conf.setInputFormat(inputFormatClass);
	    //conf.setOutputFormat(SequenceFileOutputFormat.class);
	    conf.setOutputFormat(TextOutputFormat.class);
	    
	    conf.setOutputKeyClass(NullWritable.class);
	    conf.setMapOutputKeyClass(CompositeWritable.class);
	    conf.setOutputValueClass(rdr.createValue().getClass());
		configureMapTask(conf);
	    
	    JobClient.runJob(conf);
		
		return 0;
	}
	
	public void configureMapTask(JobConf jobconf) {
		try {
			HiveConf hConf = new HiveConf(jobconf, getClass());
			HiveMetaStoreClient client = new HiveMetaStoreClient(hConf);
			List<String> dbs = client.getAllDatabases();
			String db = dbs.get(0);
			String tableName = jobconf.get(Job.WINDOWING_INPUT_TABLE);
			Table t = client.getTable(db, tableName);
			List<FieldSchema> fields = client.getFields(db, tableName);
			StorageDescriptor sd = t.getSd();
			SerDeInfo sInfo = sd.getSerdeInfo();

			String sortColStr = jobconf.get(Job.WINDOWING_SORT_COLS);
			String[] sortCols = sortColStr.split(",");

			StringBuilder sortColType = new StringBuilder();
			getTypeString(fields, sortCols, sortColType)
			Properties props = new Properties();
			props.setProperty(org.apache.hadoop.hive.serde.Constants.LIST_COLUMNS, sortColStr);
			props.setProperty(org.apache.hadoop.hive.serde.Constants.LIST_COLUMN_TYPES, sortColType.toString());
			TypedBytesSerDe sortColsSerDe = new TypedBytesSerDe();
			sortColsSerDe.initialize(jobconf, props);
			StructObjectInspector sortColsOI = (StructObjectInspector) sortColsSerDe.getObjectInspector();
			CompositeDataType sortDataType = CompositeDataType.define(sortColsOI);
			jobconf.set(WINDOWING_KEY_TYPE, sortDataType.toString())
			jobconf.setClass("io.serializations", CompositeSerialization.class, Serialization.class);
		}
		catch(Exception me) {
			throw new RuntimeException(me);
		}
	}


	public static void getTypeString(List<FieldSchema> fields, String[] sortCols, StringBuilder sortColType) {
		boolean first = true;
		for(String sCol: sortCols) {
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
		}
	}

	public static Deserializer getDeserializer(Table tbl) throws Exception 
	{
		TableDesc tDesc = Utilities.getTableDesc(new org.apache.hadoop.hive.ql.metadata.Table(tbl));
		return tDesc.getDeserializer();
	}

}
