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
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.metadata.CompositeDataType;
import com.sap.hadoop.metadata.CompositeSerialization;
import com.sap.hadoop.metadata.CompositeWritable;
import com.sap.hadoop.metadata.WindowingKey;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query.Query;
import com.sap.hadoop.windowing.query.TableInput;
import com.sap.hadoop.windowing.query.TableOutput;

class JobBase extends Configured
{
	public static final String WINDOWING_JAR_FILE = "windowing.jar.file";
	public static final String WINDOWING_PARTITION_COLS = "windowing.partition.cols";
	public static final String WINDOWING_SORT_COLS = "windowing.sort.cols";
	public static final String WINDOWING_SORT_COLS_ORDER = "windowing.sort.order";
	public static final String WINDOWING_INPUT_DATABASE = "windowing.input.database";
	public static final String WINDOWING_INPUT_TABLE = "windowing.input.table";
	public static final String WINDOWING_KEY_TYPE = CompositeDataType.COMPOSITE_DATA_TYPE;
	public static final String WINDOWING_NUM_PARTION_COLUMNS = "windowing.number.of.partition.columns";
	public static final String WINDOWING_QUERY_STRING = "windowing.query.string";
	public static final String WINDOWING_TEMP_TABLE = "windowing.hivequery.temptable";

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

}
