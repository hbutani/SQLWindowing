package com.sap.hadoop.windowing.query2.translate;

import static com.sap.hadoop.Utils.sprintf;

import java.util.Iterator;

import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.StorageDescriptor;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.FunctionRegistry;
import com.sap.hadoop.windowing.query2.definition.HiveQueryDef;
import com.sap.hadoop.windowing.query2.definition.HiveTableDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.specification.HiveQuerySpec;
import com.sap.hadoop.windowing.query2.specification.HiveTableSpec;
import com.sap.hadoop.windowing.query2.specification.OrderSpec;
import com.sap.hadoop.windowing.query2.specification.PartitionSpec;
import com.sap.hadoop.windowing.query2.specification.QueryInputSpec;
import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.query2.specification.TableFuncSpec;
import com.sap.hadoop.windowing.runtime2.HiveQueryExecutor;

/*
 * All the functionality dealing with translating input specifcations.
 */
public class InputTranslation
{
	
	public static void translate(QueryDef qDef) throws WindowingException
	{
		EnsureTableFunctionInQuery.execute(qDef);
		SlidePartitionAndOrderSpecs.execute(qDef);
		TranslateInputSpecs.execute(qDef);
	}
	
	
	static ITranslationTask TranslateInputSpecs = new ITranslationTask() {
		public void execute(QueryDef qDef) throws WindowingException
		{
			QuerySpec qSpec = qDef.getSpec();
			Iterator<QueryInputSpec> it = TranslateUtils.iterateInputSpecs(qSpec, true);
			QueryInputDef currentIDef = null;
			while(it.hasNext())
			{
				QueryInputSpec nextSpec = it.next();
				if (nextSpec instanceof HiveTableSpec)
				{
					currentIDef = translate(qDef, (HiveTableSpec) nextSpec, null);
				}
				else if (nextSpec instanceof HiveQuerySpec)
				{
					currentIDef = translate(qDef, (HiveQuerySpec) nextSpec);
				}
				else
				{
					//handle a TableFunction.
				}
			}
			
			qDef.setInput(currentIDef);
		}
		
		private HiveTableDef translate(QueryDef qDef, HiveTableSpec spec, HiveTableDef def) throws WindowingException
		{
			def = def == null ? new HiveTableDef() : def;
			HiveMetaStoreClient hiveMSC = qDef.getTranslationInfo().getHiveMSClient();
			Hive hive = qDef.getTranslationInfo().getHive();
			
			def.setSpec(spec);
			
			if ( spec.getDbName() == null )
			{
				spec.setDbName(hive.getCurrentDatabase());
			}
			
			try
			{
				Table t = hiveMSC.getTable(spec.getDbName(), spec.getTableName());
				StorageDescriptor sd = t.getSd();
				def.setInputFormatClassName(sd.getInputFormat());
				def.setTableSerdeClassName(sd.getSerdeInfo().getSerializationLib());
				def.setTableSerdeProps(sd.getSerdeInfo().getParameters());
				def.setLocation(sd.getLocation());
				
				Deserializer serde = HiveUtils.getDeserializer(qDef.getTranslationInfo().getHiveCfg(), t);
				def.setOI((StructObjectInspector)serde.getObjectInspector());
			}
			catch(WindowingException we)
			{
				throw we;
			}
			catch(Exception he)
			{
				throw new WindowingException(he);
			}
			
			return def;
		}
		
		private HiveQueryDef translate(QueryDef qDef, HiveQuerySpec spec) throws WindowingException
		{
			HiveQueryDef def = new HiveQueryDef();
			HiveQueryExecutor hiveQryExec = qDef.getTranslationInfo().getHiveQueryExecutor();
			Hive hive = qDef.getTranslationInfo().getHive();
			
			String tableName = hiveQryExec.createTableAsQuery(spec.getHiveQuery());
			HiveTableSpec tSpec = new HiveTableSpec();
			tSpec.setDbName(hive.getCurrentDatabase());
			tSpec.setTableName(tableName);
			tSpec.setPartition(spec.getPartition());
			tSpec.setOrder(spec.getOrder());
			def = (HiveQueryDef) translate(qDef, tSpec, (HiveTableDef) def);
			return def;
		}
	};

	/*
	 * If query has no table function, then add one: if query has window functions add the WindowingTableFunc; else add the Noop table function.
	 */
	static ITranslationTask EnsureTableFunctionInQuery = new ITranslationTask() {
		public void execute(QueryDef qDef) throws WindowingException
		{
			QuerySpec qSpec = qDef.getSpec();
			boolean hasTableFunction = TranslateUtils.hasTableFunctions(qSpec);
			if ( hasTableFunction)
			{
				return;
			}
			
			boolean hasWindowFunctions = TranslateUtils.hasWindowFunctions(qSpec);
			String fnName = hasWindowFunctions ? FunctionRegistry.WINDOWING_TABLE_FUNCTION : FunctionRegistry.NOOP_TABLE_FUNCTION;
			TableFuncSpec tSpec = new TableFuncSpec();
			tSpec.setName(fnName);
			tSpec.setInput(qSpec.getInput());
			qSpec.setInput(tSpec);
		}
	};
	
	/*
	 * Shift the Partition & OrderSpec in the Input Chain.
	 * During passing the Partition & Order Specs are associated with the Input that needs to be partitioned.
	 * But for Query building it is better to associate the Part & Order specs with the TableFunc that acts on the input i.e. the next one in the chain.
	 * Also make the following checks:
	 * <ol>
	 * <li> First Input in chain must have an Partition & Order specified.
	 * <li> Last Input in chain must not have a Partition & Order specified.
	 * </ol>
	 */
	static ITranslationTask SlidePartitionAndOrderSpecs =  new ITranslationTask() {
		public void execute(QueryDef qDef) throws WindowingException
		{
			QuerySpec qSpec = qDef.getSpec();
			Iterator<QueryInputSpec> it = TranslateUtils.iterateInputSpecs(qSpec, true);
			QueryInputSpec curr = it.next();
			PartitionSpec prevPSpec = curr.getPartition();
			OrderSpec prevOSpec = curr.getOrder();
			validateFirst(curr);
			while(it.hasNext())
			{
				curr = it.next();
				PartitionSpec nextPSpec = curr.getPartition();
				OrderSpec nextOSpec = curr.getOrder();
				curr.setPartition(prevPSpec);
				curr.setOrder(prevOSpec);
				prevPSpec = nextPSpec;
				prevOSpec = nextOSpec;
			}
			validateLast(curr);
		}
		
		void validateFirst(QueryInputSpec qInSpec) throws WindowingException
		{
			if ( qInSpec.getPartition() == null  )
			{
				throw new WindowingException(sprintf("Input must have a Partition specified: %s", qInSpec));
			}
		}
		
		void validateLast(QueryInputSpec qInSpec) throws WindowingException
		{
			if ( qInSpec.getPartition() != null )
			{
				throw new WindowingException(sprintf("Last Function in Chain cannot have a Partitioning specified: %s", qInSpec));
			}
		}
	};
}
