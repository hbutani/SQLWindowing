package com.sap.hadoop.windowing.runtime.mr

import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.contrib.serde2.TypedBytesSerDe;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils.ObjectInspectorCopyOption;
import org.apache.hadoop.hive.serde2.objectinspector.StructField;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.metastore.api.SerDeInfo;
import org.apache.hadoop.hive.metastore.api.StorageDescriptor;
import org.apache.hadoop.hive.metastore.api.Table;

import org.apache.hadoop.hive.ql.exec.Utilities;
import org.apache.hadoop.hive.ql.plan.TableDesc;

import com.sap.hadoop.metadata.WindowingKey;


@SuppressWarnings("deprecation")
class Map extends MapReduceBase implements Mapper<Writable, Writable, Writable, Writable> {
	Deserializer de;
	StructObjectInspector inputOI;

	TypedBytesSerDe partColsSerDe;
	StructObjectInspector partColsOI;
	StructObjectInspector partColsStdOI;
	ArrayList<Object> partitionColsRow;

	TypedBytesSerDe sortColsSerDe;
	StructObjectInspector sortColsOI;
	StructObjectInspector sortColsStdOI;
	ArrayList<Object> sortColsRow;
	WindowingKey wk = new WindowingKey();
	
	public void configure(JobConf jobconf) {
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
			de = getDeserializer(t);
			inputOI = (StructObjectInspector) de.getObjectInspector();

			String partColStr = jobconf.get(Job.WINDOWING_PARTITION_COLS);
			String[] partitionCols = partColStr.split(",");
			String sortColStr = jobconf.get(Job.WINDOWING_SORT_COLS);
			String[] sortCols = sortColStr.split(",");

			StringBuilder partColType = new StringBuilder();
			StringBuilder sortColType = new StringBuilder();
			StringBuilder sortColStrFixed = new StringBuilder();
			getTypeString(fields, partitionCols, partColType, sortCols, sortColType, sortColStrFixed);
			System.out.println(sortColStr + ":" + sortColType.toString());
			Properties props = new Properties();
			props.setProperty(org.apache.hadoop.hive.serde.Constants.LIST_COLUMNS, partColStr);
			props.setProperty(org.apache.hadoop.hive.serde.Constants.LIST_COLUMN_TYPES, partColType.toString());
			partColsSerDe = new TypedBytesSerDe();
			partColsSerDe.initialize(jobconf, props);
			partColsOI = (StructObjectInspector) partColsSerDe.getObjectInspector();
			partColsStdOI = (StructObjectInspector) ObjectInspectorUtils.getStandardObjectInspector(partColsOI, ObjectInspectorCopyOption.JAVA);
			partitionColsRow = new ArrayList<Object>();

			props.clear();
			props.setProperty(org.apache.hadoop.hive.serde.Constants.LIST_COLUMNS, sortColStrFixed.toString());
			props.setProperty(org.apache.hadoop.hive.serde.Constants.LIST_COLUMN_TYPES, sortColType.toString());
			sortColsSerDe = new TypedBytesSerDe();
			sortColsSerDe.initialize(jobconf, props);
			sortColsOI = (StructObjectInspector) sortColsSerDe.getObjectInspector();
			sortColsStdOI = (StructObjectInspector) ObjectInspectorUtils.getStandardObjectInspector(sortColsOI, ObjectInspectorCopyOption.JAVA);
			sortColsRow = new ArrayList<Object>();
			wk = new WindowingKey();
		}
		catch(Exception me) {
			throw new RuntimeException(me);
		}
	}

	@Override
	public void map(Writable key, Writable value,
	OutputCollector<Writable, Writable> output, Reporter reporter)
	throws IOException {
		
		try {
			Object o = de.deserialize(value);
			/*
			 * convert o into a Partition Object
			 */
			partitionColsRow.clear();
			for(StructField pField: partColsStdOI.getAllStructFieldRefs()) {
				StructField iField = inputOI.getStructFieldRef(pField.getFieldName());
				Object val = inputOI.getStructFieldData(o, iField);
				partitionColsRow.add(
						ObjectInspectorUtils.copyToStandardObject(val,
						iField.getFieldObjectInspector(),
						ObjectInspectorCopyOption.JAVA));
			}
			BytesWritable pk = (BytesWritable) partColsSerDe.serialize(partitionColsRow, partColsStdOI);

			sortColsRow.clear();
			for(StructField pField: sortColsStdOI.getAllStructFieldRefs()) {
				StructField iField = inputOI.getStructFieldRef(pField.getFieldName());
				Object val = inputOI.getStructFieldData(o, iField);
				sortColsRow.add(
						ObjectInspectorUtils.copyToStandardObject(val,
						iField.getFieldObjectInspector(),
						ObjectInspectorCopyOption.JAVA));
			}
			BytesWritable sk = (BytesWritable) sortColsSerDe.serialize(sortColsRow, sortColsStdOI);

			wk.setPartitionValue(pk);
			wk.setSortValue(sk);

			output.collect(wk, value);
		}
		catch(SerDeException se) {
			throw new IOException(se);
		}
	}

	public static Deserializer getDeserializer(Table tbl) throws Exception {
		TableDesc tDesc = Utilities.getTableDesc(new org.apache.hadoop.hive.ql.metadata.Table(tbl));
		return tDesc.getDeserializer();
	}

	public static void getTypeString(List<FieldSchema> fields, String[] partitionCols, StringBuilder partColType,
	String[] sortCols, StringBuilder sortColType, StringBuilder sortColStrFixed) {
		for(String pCol: partitionCols) {
			int i=0;
			boolean first = true;
			for(;i < fields.size(); i++) {
				FieldSchema f = fields.get(i);
				if ( f.getName().equals(pCol) ) {
					if (first) first = false; else partColType.append(",");
					partColType.append(f.getType());
					break;
				}
			}
			if ( i == fields.size()) {
				throw new RuntimeException("Unknown column " + pCol);
			}
		}

		int j = partitionCols.length;
		for(; j < sortCols.length; j++) {
			String sCol = sortCols[j];
			int i=0;
			boolean first = true;
			for(;i < fields.size(); i++) {
				FieldSchema f = fields.get(i);
				if ( f.getName().equals(sCol) ) {
					if (first)
						first = false;
					else {
						sortColType.append(",");
						sortColStrFixed.append(",");
					}
					sortColStrFixed.append(f.getName());
					sortColType.append(f.getType());
					break;
				}
			}
			if ( i == fields.size()) {
				throw new RuntimeException("Unknown column " + sCol);
			}
		}
	}
}


