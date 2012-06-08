package com.sap.hadoop.windowing.runtime

import java.util.Properties;

import org.apache.hadoop.hive.common.JavaUtils;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.ql.exec.ColumnInfo;
import org.apache.hadoop.hive.ql.exec.FetchOperator;
import org.apache.hadoop.hive.ql.exec.RowSchema;
import org.apache.hadoop.hive.ql.exec.Utilities;
import org.apache.hadoop.hive.ql.io.RCFileInputFormat;
import org.apache.hadoop.hive.ql.io.RCFileOutputFormat;
import org.apache.hadoop.hive.ql.plan.FetchWork;
import org.apache.hadoop.hive.ql.plan.PlanUtils;
import org.apache.hadoop.hive.ql.plan.TableDesc;
import org.apache.hadoop.hive.ql.session.SessionState.LogHelper;
import org.apache.hadoop.hive.serde.Constants;
import org.apache.hadoop.hive.serde2.DelimitedJSONSerDe;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.objectinspector.InspectableObject;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.InputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputFormat;
import org.apache.hadoop.mapred.SequenceFileInputFormat;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.util.ReflectionUtils;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query.OutputColumn;
import com.sap.hadoop.windowing.query.Query;

class QueryOutputPrinter
{
	LogHelper hiveConsole;
	
	public QueryOutputPrinter() {}
	
	public QueryOutputPrinter(LogHelper hiveConsole)
	{
		this.hiveConsole = hiveConsole;
	}
	
	public void printQueryOutput(Query qry, HiveConf cfg)
	{
		JobConf jCfg = new JobConf(cfg)
		SerDe outSerDe = setupOutputSerDe(qry, jCfg)
		RowSchema rSchema = getQueryOutputRowSchema(qry, jCfg)
		TableDesc tDesc = setupTableDesc(rSchema)

		tDesc.setDeserializerClass(qry.output.serDe.getClass())
		String outputFormatClassName = qry.qSpec.tableOut.outputFormat;
		Class<? extends OutputFormat> outputFormatClass = (outputFormatClassName != null) ?
					(Class<? extends OutputFormat>) Class.forName(outputFormatClassName) : SequenceFileOutputFormat.class;
		//todo this is hack; check how this is done in Hive
		tDesc.setInputFileFormatClass(mapToInputFormat(outputFormatClass))
		
		FetchOperator ftOp = setupFetchOperator(qry, tDesc, jCfg)
		
		while (true) 
		{
			InspectableObject io = ftOp.getNextRow();
			if (io == null) 
			{
				return;
			}
	
			String s = ((Text) outSerDe.serialize(io.o, io.oi)).toString();
			printOutput(s)
		}
	}
	
	protected printOutput(String s)
	{
		hiveConsole.printInfo(s)
	}
	
	private SerDe setupOutputSerDe(Query qry, JobConf jcfg)
	{
		StructObjectInspector qOI = qry.output.outputOI;
		String cols = ObjectInspectorUtils.getFieldNames(qOI);
		String ctypes = ObjectInspectorUtils.getFieldTypes(qOI);
		
		/* from FetchWork initialize */
		String serdeName = HiveConf.getVar(jcfg, HiveConf.ConfVars.HIVEFETCHOUTPUTSERDE);
		Class<? extends SerDe> serdeClass = Class.forName(serdeName, true,
			JavaUtils.getClassLoader()).asSubclass(SerDe.class);
		
		SerDe serDe = (SerDe) ReflectionUtils.newInstance(serdeClass, null);
  
		Properties serdeProp = new Properties();
  
		// this is the default serialization format
		if (serDe instanceof DelimitedJSONSerDe) {
		  serdeProp.put(Constants.SERIALIZATION_FORMAT, "" + Utilities.tabCode);
		  serdeProp.put(Constants.SERIALIZATION_NULL_FORMAT, "NULL");
		}
  
		serDe.initialize(jcfg, serdeProp);
		/* end: from FetchWork initialize */
		
		return serDe;
	}
	
	RowSchema getQueryOutputRowSchema(Query qry, JobConf jcfg)
	{
		String tabAlias = qry.qSpec.tableOut.tableName
		tabAlias = tabAlias == null ? "wtemp" : tabAlias
		ArrayList<ColumnInfo> cInfos = []
		qry.output.columns.each { OutputColumn oc ->
			cInfos << new ColumnInfo(oc.alias, oc.typeInfo, tabAlias, false) 
		}
		return new RowSchema(cInfos)
	}
	
	TableDesc setupTableDesc(RowSchema rSchema)
	{
		List<FieldSchema> fields = PlanUtils.getFieldSchemasFromRowSchema(rSchema, null);
		return PlanUtils.getIntermediateFileTableDesc(fields)
	}
	
	FetchOperator setupFetchOperator(Query qry, TableDesc tDesc, JobConf jcfg)
	{
		FetchWork fW = new FetchWork(qry.qSpec.tableOut.outputPath, tDesc)
		FetchOperator fOp = new FetchOperator(fW, jcfg);
	}
	
	static Class<? extends InputFormat> mapToInputFormat(Class<? extends OutputFormat> qryOutClass) throws WindowingException
	{
		if ( qryOutClass.equals(TextOutputFormat.class))
		{
			return TextInputFormat.class
		}
		else if ( qryOutClass.equals(SequenceFileOutputFormat.class))
		{
			return SequenceFileInputFormat.class
		}
		else if ( qryOutClass.equals(RCFileOutputFormat.class))
		{
			return RCFileInputFormat.class
		}
		
		throw new WindowingException(sprintf("Mapping to InputFormat from Qry OutputFormat (%s) not registered ", qryOutClass))
	}
}

class TestQueryOutputPrinter extends QueryOutputPrinter
{
	protected printOutput(String s)
	{
		println s
	}
}