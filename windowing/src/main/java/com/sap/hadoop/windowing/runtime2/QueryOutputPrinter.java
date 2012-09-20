package com.sap.hadoop.windowing.runtime2;

import static com.sap.hadoop.Utils.sprintf;

import java.util.List;
import java.util.Properties;

import org.apache.hadoop.hive.common.JavaUtils;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.ql.exec.FetchOperator;
import org.apache.hadoop.hive.ql.exec.RowSchema;
import org.apache.hadoop.hive.ql.exec.Utilities;
import org.apache.hadoop.hive.ql.io.RCFileInputFormat;
import org.apache.hadoop.hive.ql.io.RCFileOutputFormat;
import org.apache.hadoop.hive.ql.parse.RowResolver;
import org.apache.hadoop.hive.ql.plan.FetchWork;
import org.apache.hadoop.hive.ql.plan.PlanUtils;
import org.apache.hadoop.hive.ql.plan.TableDesc;
import org.apache.hadoop.hive.ql.session.SessionState.LogHelper;
import org.apache.hadoop.hive.serde.Constants;
import org.apache.hadoop.hive.serde2.DelimitedJSONSerDe;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.objectinspector.InspectableObject;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.InputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.OutputFormat;
import org.apache.hadoop.mapred.SequenceFileInputFormat;
import org.apache.hadoop.mapred.SequenceFileOutputFormat;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.util.ReflectionUtils;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.QueryDef;

class QueryOutputPrinter
{
	LogHelper hiveConsole;
	
	public QueryOutputPrinter() {}
	
	public QueryOutputPrinter(LogHelper hiveConsole)
	{
		this.hiveConsole = hiveConsole;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void printQueryOutput(QueryDef qry, HiveConf cfg) throws WindowingException
	{
		try
		{
			JobConf jCfg = new JobConf(cfg);
			SerDe outSerDe = setupOutputSerDe(qry, jCfg);
			RowSchema rSchema = getQueryOutputRowSchema(qry, jCfg);
			TableDesc tDesc = setupTableDesc(rSchema);

			tDesc.setDeserializerClass(qry.getOutput().getSerDe().getClass());
			String outputFormatClassName = qry.getOutput().getSpec()
					.getOutputFormatClass();
			Class<? extends OutputFormat> outputFormatClass = (outputFormatClassName != null) ? (Class<? extends OutputFormat>) Class
					.forName(outputFormatClassName)
					: SequenceFileOutputFormat.class;
			// todo this is hack; check how this is done in Hive
			tDesc.setInputFileFormatClass(mapToInputFormat(outputFormatClass));

			tDesc.setProperties(qry.getOutput().getSpec().getSerDeProps());

			FetchOperator ftOp = setupFetchOperator(qry, tDesc, jCfg);

			while (true)
			{
				InspectableObject io = ftOp.getNextRow();
				if (io == null)
				{
					return;
				}

				String s = ((Text) outSerDe.serialize(io.o, io.oi)).toString();
				printOutput(s);
			}
		}
		catch (WindowingException we)
		{
			throw we;
		}
		catch (Exception e)
		{
			throw new WindowingException(e);
		}
	}
	
	protected void printOutput(String s)
	{
		hiveConsole.printInfo(s);
	}
	
	private SerDe setupOutputSerDe(QueryDef qry, JobConf jcfg) throws WindowingException
	{
		try
		{
//			StructObjectInspector qOI = qry.getOutput().getOI();
//			String cols = ObjectInspectorUtils.getFieldNames(qOI);
//			String ctypes = ObjectInspectorUtils.getFieldTypes(qOI);
			
			/* from FetchWork initialize */
			String serdeName = HiveConf.getVar(jcfg, HiveConf.ConfVars.HIVEFETCHOUTPUTSERDE);
			Class<? extends SerDe> serdeClass = Class.forName(serdeName, true, JavaUtils.getClassLoader()).asSubclass(SerDe.class);
			
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
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
	}
	
	RowSchema getQueryOutputRowSchema(QueryDef qry, JobConf jcfg) throws WindowingException
	{
		String tabAlias = qry.getOutput().getSpec().getHiveTable();
		StructObjectInspector rowObjectInspector = qry.getSelectList().getOI();
		RowResolver rr = HiveUtils.getRowResolver(tabAlias, rowObjectInspector );
		return rr.getRowSchema();
	}
	
	TableDesc setupTableDesc(RowSchema rSchema)
	{
		List<FieldSchema> fields = PlanUtils.getFieldSchemasFromRowSchema(rSchema, null);
		return PlanUtils.getIntermediateFileTableDesc(fields);
	}
	
	FetchOperator setupFetchOperator(QueryDef qry, TableDesc tDesc, JobConf jcfg)
	{
		FetchWork fW = new FetchWork(qry.getOutput().getSpec().getPath(), tDesc);
		FetchOperator fOp = new FetchOperator(fW, jcfg);
		return fOp;
	}
	
	@SuppressWarnings("rawtypes")
	static Class<? extends InputFormat> mapToInputFormat(Class<? extends OutputFormat> qryOutClass) throws WindowingException
	{
		if ( qryOutClass.equals(TextOutputFormat.class))
		{
			return TextInputFormat.class;
		}
		else if ( qryOutClass.equals(SequenceFileOutputFormat.class))
		{
			return SequenceFileInputFormat.class;
		}
		else if ( qryOutClass.equals(RCFileOutputFormat.class))
		{
			return RCFileInputFormat.class;
		}
		
		throw new WindowingException(sprintf("Mapping to InputFormat from Qry OutputFormat (%s) not registered ", qryOutClass));
	}
	
	static class TestQueryOutputPrinter extends QueryOutputPrinter
	{
		protected void printOutput(String s)
		{
			System.out.println(s);
		}
	}

}

