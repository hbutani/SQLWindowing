package com.sap.hadoop.windowing.query2.translate;

import static com.sap.hadoop.Utils.sprintf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.hadoop.hive.metastore.HiveMetaStoreClient;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.metastore.api.StorageDescriptor;
import org.apache.hadoop.hive.metastore.api.Table;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.FunctionRegistry;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.functions2.TableFunctionResolver;
import com.sap.hadoop.windowing.query2.definition.ArgDef;
import com.sap.hadoop.windowing.query2.definition.HiveQueryDef;
import com.sap.hadoop.windowing.query2.definition.HiveTableDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.specification.HiveQuerySpec;
import com.sap.hadoop.windowing.query2.specification.HiveTableSpec;
import com.sap.hadoop.windowing.query2.specification.OrderSpec;
import com.sap.hadoop.windowing.query2.specification.PartitionSpec;
import com.sap.hadoop.windowing.query2.specification.QueryInputSpec;
import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.query2.specification.TableFuncSpec;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo.InputInfo;
import com.sap.hadoop.windowing.runtime2.HiveQueryExecutor;

/*
 * All the functionality dealing with translating input specifcations.
 */
public class InputTranslation
{
	
	public static void translate(QueryDef qDef) throws WindowingException
	{
		QuerySpec spec = qDef.getSpec();
		
		/*
		 * validate that input chain ends in a Hive Query or TAble.
		 */
		if ( !spec.getInput().sourcedFromHive() )
		{
			throw new WindowingException("Translation not supported for HdfsLocation based queries");
		}
		
		EnsureTableFunctionInQuery.execute(qDef);
		SlidePartitionAndOrderSpecs.execute(qDef);
		TranslateInputSpecs.execute(qDef);
	}
	
	
	static ITranslationTask TranslateInputSpecs = new ITranslationTask() {
		public void execute(QueryDef qDef) throws WindowingException
		{
			QueryTranslationInfo tInfo = qDef.getTranslationInfo();
			QuerySpec qSpec = qDef.getSpec();
			Iterator<QueryInputSpec> it = TranslateUtils.iterateInputSpecs(qSpec, true);
			QueryInputDef currentIDef = null;
			int inputNum = 0;
			while(it.hasNext())
			{
				QueryInputSpec nextSpec = it.next();
				if (nextSpec instanceof HiveTableSpec)
				{
					currentIDef = InputTranslation.translate(qDef, (HiveTableSpec) nextSpec, (HiveTableDef) null);
				}
				else if (nextSpec instanceof HiveQuerySpec)
				{
					currentIDef = InputTranslation.translate(qDef, (HiveQuerySpec) nextSpec);
				}
				else
				{
					currentIDef = translate(qDef, (TableFuncSpec) nextSpec, currentIDef);
				}
				String alias = getTableAlias(qDef, inputNum, currentIDef);
				currentIDef.setAlias(alias);
				tInfo.addInput(currentIDef);
				inputNum++;
			}
			
			qDef.setInput(currentIDef);
		}
		
	};
	
	private static String getTableAlias(QueryDef qDef, int inputNum, QueryInputDef inputDef) throws WindowingException
	{
		if ( inputDef instanceof HiveTableDef)
		{
			HiveTableDef hTbldef = (HiveTableDef) inputDef;
			String db = ((HiveTableSpec)hTbldef.getSpec()).getDbName();
			String tableName = ((HiveTableSpec)hTbldef.getSpec()).getTableName();
			return db + "." + tableName;
		}
		else if ( inputDef instanceof TableFuncDef)
		{
			return "ptf_" + inputNum;
		}
		throw new WindowingException(sprintf("Internal Error: attempt to translate %s", inputDef.getSpec()));
	}

	private static HiveTableDef translate(QueryDef qDef, HiveTableSpec spec, HiveTableDef def) throws WindowingException
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
			//def.setTableSerdeProps(sd.getSerdeInfo().getParameters());
			def.setTableSerdeProps(setupSerdeProps(qDef,sd));
			def.setLocation(sd.getLocation());
			
			Deserializer serde = HiveUtils.getDeserializer(qDef.getTranslationInfo().getHiveCfg(), t);
			def.setOI((StructObjectInspector)serde.getObjectInspector());
			def.setSerde((SerDe) serde);
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
	
	private static Map<String,String> setupSerdeProps(QueryDef qDef, StorageDescriptor sd){
		Map<String,String> serdePropsMap = new HashMap<String, String>();
		StringBuilder colNames = new StringBuilder();
		StringBuilder colTypes = new StringBuilder();
		List<FieldSchema> sdCols = sd.getCols();
		boolean first = true;

		for (FieldSchema fieldSchema : sdCols) {
			if (!first)
			{
				colNames.append(",");
				colTypes.append(",");
			}
			else
				first = false;
			colNames.append(fieldSchema.getName());
			colTypes.append(fieldSchema.getType());
		}
		
		serdePropsMap.put(org.apache.hadoop.hive.serde.Constants.LIST_COLUMNS, colNames.toString());
		serdePropsMap.put(org.apache.hadoop.hive.serde.Constants.LIST_COLUMN_TYPES, colTypes.toString());
		
		return serdePropsMap;
	}
	
	private static HiveQueryDef translate(QueryDef qDef, HiveQuerySpec spec) throws WindowingException
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
		def = (HiveQueryDef) InputTranslation.translate(qDef, tSpec, (HiveTableDef) def);
		return def;
	}
	
	/*
	 * <ol>
	 * <li> Get the <code>TableFunctionResolver</code> for this Function from the FunctionRegistry.
	 * <li> Create the TableFuncDef object.
	 * <li> Get the InputInfo for the input to this function.
	 * <li> Translate the Arguments to this Function in the Context of the InputInfo.
	 * <li> ask the  TableFunctionResolver to create a TableFunctionEvaluator based on the Args passed in.
	 * <li> ask the TableFunctionEvaluator to setup the Map-side ObjectInspector. Gives a chance to functions that 
	 * reshape the Input before it is partitioned to define the Shape after raw data is transformed.
	 * <li> Setup the Window Definition for this Function. The Window Definition is resolved wrt to the InputDef's
	 * Shape or the MapOI, for Functions that reshape the raw input.
	 * <li> ask the TableFunctionEvaluator to setup the Output ObjectInspector for this Function.
	 * <li> setup a Serde for the Output partition based on the OutputOI. 
	 * </ol> 
	 */
	private static TableFuncDef translate(QueryDef qDef, TableFuncSpec tSpec, QueryInputDef inputDef) throws WindowingException
	{
		QueryTranslationInfo tInfo = qDef.getTranslationInfo();
		
		TableFunctionResolver tFn = FunctionRegistry.getTableFunctionResolver(tSpec.getName());
		if ( tFn == null)
		{
			throw new WindowingException(sprintf("Unknown Table Function %s", tSpec.getName()));
		}
		
		TableFuncDef tDef = new TableFuncDef();
		tDef.setSpec(tSpec);
		tDef.setInput(inputDef);
		InputInfo iInfo = tInfo.getInputInfo(inputDef); 
		
		/*
		 * translate args
		 */
		ArrayList<ASTNode> args = tSpec.getArgs();
		if ( args != null)
		{
			for(ASTNode expr : args)
			{
				ArgDef argDef = translateTableFunctionArg(qDef, tDef, iInfo,  expr);
				tDef.addArg(argDef);
			}
		}
		
		TableFunctionEvaluator tEval = tFn.initialize(qDef, tDef);
		tDef.setFunction(tEval);
		
		tEval.setupMapOI();
		tDef.setWindow(WindowSpecTranslation.translateWindow(qDef, tDef));
		tEval.setupOI();
		
		
		/*
		 * setup the SerDe.
		 */
		SerDe serde = TranslateUtils.createLazyBinarySerDe(tInfo.getHiveCfg(), tEval.getOutputOI());
		tDef.setSerde(serde);
		
		try
		{
			tDef.setOI((StructObjectInspector) serde.getObjectInspector());
		}
		catch(SerDeException se)
		{
			throw new WindowingException(se);
		}
		
		if ( tEval.hasMapPhase() )
		{
			serde = TranslateUtils.createLazyBinarySerDe(tInfo.getHiveCfg(), tEval.getMapOutputOI());
			try
			{
				tDef.setMapOI((StructObjectInspector) serde.getObjectInspector());
			}
			catch(SerDeException se)
			{
				throw new WindowingException(se);
			}
		}

		return tDef;
	}
		
	private static ArgDef translateTableFunctionArg(QueryDef qDef, TableFuncDef tDef, InputInfo iInfo, ASTNode arg) throws WindowingException
	{
		return TranslateUtils.buildArgDef(qDef, iInfo, arg);
	}
	
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
			validateLast(prevPSpec, curr);
		}
		
		void validateFirst(QueryInputSpec qInSpec) throws WindowingException
		{
			if ( qInSpec.getPartition() == null  )
			{
				throw new WindowingException(sprintf("Input must have a Partition specified: %s", qInSpec));
			}
		}
		
		void validateLast(PartitionSpec pSpec, QueryInputSpec inSpec) throws WindowingException
		{
			if ( pSpec != null )
			{
				throw new WindowingException(sprintf("Last Function in Chain cannot have a Partitioning specified: %s", inSpec));
			}
		}
	};
}
