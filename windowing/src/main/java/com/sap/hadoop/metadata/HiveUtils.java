package com.sap.hadoop.metadata;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.api.StorageDescriptor;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.InputFormat;
import org.apache.hadoop.mapred.InputSplit;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;

import com.sap.hadoop.windowing.WindowingException;

public class HiveUtils
{
	@SuppressWarnings("unchecked")
	public static void addTableasJobInput(String db, String table, JobConf job, FileSystem fs) throws WindowingException, IOException
	{
		try
		{
			HiveMetaStoreClient client = getClient(job);

			// 1. get Table details from Hive metastore
			db = validateDB(client, db);
			Table t = getTable(client, db, table);
			StorageDescriptor sd = t.getSd();
			
			// 2. add table's location to job input
			FileInputFormat.addInputPath(job, new Path(sd.getLocation()));
			
			// 3. set job inputFormatClass, extract from StorageDescriptor
			Class<? extends InputFormat<? extends Writable, ? extends Writable>> inputFormatClass = 
				(Class<? extends InputFormat<? extends Writable, ? extends Writable>>) Class.forName(sd.getInputFormat());
		    job.setInputFormat(inputFormatClass);

		    // 4. set job OutputValueClass
		    //	- instantiate InputFormat
		    //	- get inputSplits
		    //	- instantiate Reader for the 1st split
		    //	- get valueClass from reader
			InputFormat<? extends Writable, ? extends Writable> iFmt = inputFormatClass.newInstance();
			if (iFmt instanceof TextInputFormat)
				((TextInputFormat)iFmt).configure(job);
			InputSplit[] iSplits = iFmt.getSplits(job, 1);
			org.apache.hadoop.mapred.RecordReader<Writable, Writable> rdr = 
				(org.apache.hadoop.mapred.RecordReader<Writable, Writable>) iFmt.getRecordReader(iSplits[0], job, Reporter.NULL);
		    job.setOutputValueClass(rdr.createValue().getClass());
		    
		    // 5. set num reducers to number of input splits
			job.setNumReduceTasks(iSplits.length);
		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
		
	}
	
	
	public static HiveMetaStoreClient getClient(Configuration conf) throws WindowingException
	{
		try
		{
			HiveConf hConf = new HiveConf(conf, conf.getClass());
			return new HiveMetaStoreClient(hConf);
		}
		catch(MetaException me)
		{
			throw new WindowingException(me);
		}
	}
	
	public static String validateDB(HiveMetaStoreClient client, String db) throws WindowingException
	{
		try
		{
			List<String> dbs = client.getAllDatabases();
	
			if ( db == null )
			{
				return dbs.get(0);
			}
			
			for(String d : dbs)
			{
				if (d.equals(db)) return db;
			}
			throw new WindowingException(Utils.sprintf("Unknown database %s", db));
		}
		catch(MetaException me)
		{
			throw new WindowingException(me);
		}
	}
	
	public static Table getTable(HiveMetaStoreClient client, String db, String tableName) throws WindowingException
	{
		try
		{
			return client.getTable(db, tableName);
		}
		catch(Exception me)
		{
			throw new WindowingException(me);
		}
	}
}
