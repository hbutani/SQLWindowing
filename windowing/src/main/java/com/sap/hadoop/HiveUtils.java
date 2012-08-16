package com.sap.hadoop;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.metastore.MetaStoreUtils;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.metastore.api.MetaException;
import org.apache.hadoop.hive.metastore.api.StorageDescriptor;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.hadoop.hive.ql.exec.ColumnInfo;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.apache.hadoop.hive.ql.metadata.VirtualColumn;
import org.apache.hadoop.hive.ql.parse.RowResolver;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoUtils;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.InputFormat;
import org.apache.hadoop.mapred.InputSplit;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;

import com.sap.hadoop.metadata.Utils;
import com.sap.hadoop.windowing.WindowingException;

public class HiveUtils
{
	private static final Log LOG = LogFactory.getLog("com.sap.hadoop.windowing");
	
	@SuppressWarnings("unchecked")
	public static List<FieldSchema> addTableasJobInput(String db, String table, JobConf job, FileSystem fs) throws WindowingException
	{
		LOG.info("HiveUtils::addTableasJobInput invoked");
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
		    
		    
		    /*
		     * Creating a namespace and reading the Splits is not needed here anymore
		     */
//			InputFormat<? extends Writable, ? extends Writable> iFmt = inputFormatClass.newInstance();
//			if (iFmt instanceof TextInputFormat)
//				((TextInputFormat)iFmt).configure(job);
//			InputSplit[] iSplits = iFmt.getSplits(job, 1);
//			org.apache.hadoop.mapred.RecordReader<Writable, Writable> rdr = 
//				(org.apache.hadoop.mapred.RecordReader<Writable, Writable>) iFmt.getRecordReader(iSplits[0], job, Reporter.NULL);
		    
			/*
			 * this is no more always valid. The MapOutput Value calss is dictated by the query.input.deserializer
			 */
			//job.setMapOutputValueClass(rdr.createValue().getClass());
		    
		    // 5. set num reducers to number of input splits
//			job.setNumReduceTasks(iSplits.length);
			
			return client.getFields(db, table);
		}
		catch(WindowingException w)
		{
			throw w;
		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
		
	}
	
	public static List<FieldSchema> getFields(String db, String table, JobConf job) throws WindowingException
	{
		LOG.info("HiveUtils::getFields invoked");
		try
		{
			HiveMetaStoreClient client = getClient(job);
			db = validateDB(client, db);
			getTable(client, db, table);
			return client.getFields(db, table);
		}
		catch(WindowingException w)
		{
			throw w;
		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
	}
	
	public static Deserializer getDeserializer(String db, String table, Configuration conf) throws WindowingException
	{
		LOG.info("HiveUtils::getDeserializer invoked");
		try
		{
			HiveMetaStoreClient client = getClient(conf);
			db = validateDB(client, db);
			Table t = getTable(client, db, table);
			return MetaStoreUtils.getDeserializer(conf, t);
		}
		catch(WindowingException w)
		{
			throw w;
		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
	}
	
	
	public static HiveMetaStoreClient getClient(Configuration conf) throws WindowingException
	{
		LOG.info("HiveUtils::getClient invoked");
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
	
	public static HiveConf getHiveConf(Configuration conf) throws WindowingException
	{
		LOG.info("HiveUtils::getHiveConf invoked");
		try
		{
			return new HiveConf(conf, conf.getClass());
		}
		catch(Exception me)
		{
			throw new WindowingException(me);
		}
	}
	
	public static String validateDB(HiveMetaStoreClient client, String db) throws WindowingException
	{
		LOG.info("HiveUtils::validateDB invoked");
		try
		{
			List<String> dbs = client.getAllDatabases();
	
			if ( db == null )
			{
				return "default";
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
		LOG.info("HiveUtils::getTable invoked on " + tableName);
		try
		{
			return client.getTable(db, tableName);
		}
		catch(Exception me)
		{
			throw new WindowingException(me);
		}
	}
	
	public static Table getTable(String db, String tableName, Configuration conf) throws WindowingException
	{
		HiveMetaStoreClient client = getClient(conf);
		db = validateDB(client, db);
		return getTable(client, db, tableName);
	}
	
	/**
	 * copied from hive.ql.exec.Utilities: keep dependency on exec jar to minimum
	 * @param cloader
	 * @param newPaths
	 * @return
	 * @throws Exception
	 */
	public static ClassLoader addToClassPath(ClassLoader cloader,
			String[] newPaths) throws Exception
	{
		LOG.info("HiveUtils::addToClassPath invoked");
		URLClassLoader loader = (URLClassLoader) cloader;
		List<URL> curPath = Arrays.asList(loader.getURLs());
		ArrayList<URL> newPath = new ArrayList<URL>();

		// get a list with the current classpath components
		for (URL onePath : curPath)
		{
			newPath.add(onePath);
		}
		curPath = newPath;

		for (String onestr : newPaths)
		{
			// special processing for hadoop-17. file:// needs to be removed
			if (StringUtils.indexOf(onestr, "file://") == 0)
			{
				onestr = StringUtils.substring(onestr, 7);
			}

			URL oneurl = (new File(onestr)).toURL();
			if (!curPath.contains(oneurl))
			{
				curPath.add(oneurl);
			}
		}

		return new URLClassLoader(curPath.toArray(new URL[0]), loader);
	}
	
	public static RowResolver getRowResolver(String db, String table, String alias, HiveConf conf) throws WindowingException
	{
		LOG.info("HiveUtils::getRowResolver invoked on " + table);
		try
		{
			HiveMetaStoreClient client = getClient(conf);

			db = validateDB(client, db);
			org.apache.hadoop.hive.ql.metadata.Table t = Hive.get(conf).getTable(db, table);
			 StructObjectInspector rowObjectInspector = (StructObjectInspector) t.getDeserializer().getObjectInspector();
			RowResolver rwsch = getRowResolver(alias, rowObjectInspector ) ;
			 
			 for (FieldSchema part_col : t.getPartCols()) 
			 {
			        LOG.trace("Adding partition col: " + part_col);
			        rwsch.put(alias, part_col.getName(), 
			        		new ColumnInfo(part_col.getName(),
			        				TypeInfoFactory.getPrimitiveTypeInfo(part_col.getType()), alias, true)
			        );
			  }
			 
			 Iterator<VirtualColumn> vcs = VirtualColumn.getRegistry(conf).iterator();
		      //use a list for easy cumtomize
		      List<VirtualColumn> vcList = new ArrayList<VirtualColumn>();
		      while (vcs.hasNext()) 
		      {
		        VirtualColumn vc = vcs.next();
		        rwsch.put(alias, vc.getName(), 
		        		new ColumnInfo(vc.getName(),
		        				vc.getTypeInfo(), alias, true, vc.getIsHidden()
		        				)
		        );
		        vcList.add(vc);
		      }
			
			
			return rwsch;
		}
		catch(WindowingException w)
		{
			throw w;
		}
		catch(Exception me)
		{
			throw new WindowingException(me);
		}
	}

	public static RowResolver getRowResolver(String tabAlias, StructObjectInspector rowObjectInspector ) throws WindowingException
	{
		LOG.info("HiveUtils::getRowResolver invoked on ObjectInspector");
		try
		{
			RowResolver rwsch = new RowResolver();
			 List<? extends StructField> fields = rowObjectInspector.getAllStructFieldRefs();
			 for (int i = 0; i < fields.size(); i++)
			 {
				 rwsch.put(tabAlias, fields.get(i).getFieldName(), 
						 	new ColumnInfo(fields.get(i).getFieldName(), 
						 			TypeInfoUtils.getTypeInfoFromObjectInspector(fields.get(i).getFieldObjectInspector()), 
						 			tabAlias, 
						 			false)
				 );
			 }
			return rwsch;
		}
		catch(Exception me)
		{
			throw new WindowingException(me);
		}
	}
}
