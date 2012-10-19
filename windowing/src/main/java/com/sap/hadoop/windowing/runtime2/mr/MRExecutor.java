package com.sap.hadoop.windowing.runtime2.mr;

import java.util.Properties;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.DriverContext;
import org.apache.hadoop.hive.ql.exec.MapRedTask;
import org.apache.hadoop.hive.ql.exec.Operator;
import org.apache.hadoop.hive.ql.exec.OperatorFactory;
import org.apache.hadoop.hive.ql.exec.Utilities;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.apache.hadoop.hive.ql.plan.ExtractDesc;
import org.apache.hadoop.hive.ql.plan.FileSinkDesc;
import org.apache.hadoop.hive.ql.plan.MapredWork;
import org.apache.hadoop.hive.ql.plan.PlanUtils;
import org.apache.hadoop.hive.ql.plan.ReduceSinkDesc;
import org.apache.hadoop.hive.ql.plan.TableDesc;
import org.apache.hadoop.hive.serde.Constants;
import org.apache.hadoop.hive.serde2.SerDe;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.SerializationUtils;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryOutputDef;
import com.sap.hadoop.windowing.query2.translate.TranslateUtils;
import com.sap.hadoop.windowing.runtime2.Executor;
import com.sap.hadoop.windowing.runtime2.RuntimeUtils;
import com.sap.hadoop.windowing.runtime2.WindowingShell;

public class MRExecutor extends Executor
{

	/* 
	 * Create a MapRedWork object and an operator tree 
	 * for processing queries with table functions. 
	 * Execute the plan defined in the MapRedWork using 
	 * the Hive runtime environment. 
	 */
	@Override
	public void execute(QueryDef qdef, WindowingShell wShell)
			throws WindowingException
	{
		MapredWork mr = PlanUtils.getMapRedWork();
		try
		{
			createOperatorTree(qdef, mr);
			executePlan(mr, wShell.getCfg());
		}
		catch (SemanticException se)
		{
			throw new WindowingException(se);
		}
		catch (Exception e)
		{
			throw new WindowingException(e);
		}
	}

	/**
	 * Initialize the data structures required to create 
	 * the operator tree. Create the Map-side and 
	 * reduce-side operator trees.
	 * @param qdef
	 * @param mr
	 * @throws SemanticException
	 * @throws WindowingException
	 */
	private void createOperatorTree(QueryDef qdef, MapredWork mr)
			throws SemanticException, WindowingException
	{
		MRUtils mrUtils = new MRUtils(qdef);
		mrUtils.initialize();
		createMapSideTree(qdef, mrUtils, mr);
		createReduceSideTree(qdef, mrUtils, mr);

	}
	
	/**
	 * The map-side operator tree consists of:
	 * MapOperator->ReduceSinkOperator if the query does 
	 * not have a map phase. 
	 * If the query has a map phase, the PTFOperator needs to be 
	 * invoked at the map-side of the query tree. The map-side plan then 
	 * looks like MapOperator->PTFOperator->ReduceSinkOperator. 
	 * @param qdef
	 * @param mrUtils
	 * @param mr
	 * @throws WindowingException
	 */
	@SuppressWarnings("unchecked")
	private void createMapSideTree(QueryDef qdef, MRUtils mrUtils, MapredWork mr) throws WindowingException{
		// map-side work
		if (MRUtils.addPTFMapOperator(qdef))
		{

			Operator<ReduceSinkDesc> op2 = OperatorFactory.get(PlanUtils
					.getReduceSinkDesc(mrUtils.getOrderCols(), mrUtils
							.getValueCols(), mrUtils.getOutputColumnNames(), true,
							-1, mrUtils.getPartCols(), mrUtils.getOrderString()
									.toString(), -1));

			Operator<PTFDesc> op1 = RuntimeUtils.createPTFOperator(new PTFDesc(
					SerializationUtils.serializeQueryDef(qdef)), op2);

			Utilities.addMapWork(mr, mrUtils.getInputTable(), mrUtils
					.getHiveTableDef().getAlias(), op1);
			mr.setKeyDesc(op2.getConf().getKeySerializeInfo());
			mr.getTagToValueDesc().add(op2.getConf().getValueSerializeInfo());

		}
		else
		{
			Operator<ReduceSinkDesc> op1 = OperatorFactory.get(PlanUtils
					.getReduceSinkDesc(mrUtils.getOrderCols(), mrUtils
							.getValueCols(), mrUtils.getOutputColumnNames(), true,
							-1, mrUtils.getPartCols(), mrUtils.getOrderString()
									.toString(), -1));
			Utilities.addMapWork(mr, mrUtils.getInputTable(), mrUtils
					.getHiveTableDef().getAlias(), op1);
			mr.setKeyDesc(op1.getConf().getKeySerializeInfo());
			mr.getTagToValueDesc().add(op1.getConf().getValueSerializeInfo());
		}


		
	}

	/**
	 * The reduce-side plan always looks like 
	 * ExtratOperator->PTFOperator->FileSinkOperator.
	 * Use the data structures initialized in MRUtils to 
	 * create the operators here.
	 * @param qdef
	 * @param mrUtils
	 * @param mr
	 * @throws WindowingException
	 */
	@SuppressWarnings("unchecked")
	private void createReduceSideTree(QueryDef qdef, MRUtils mrUtils, MapredWork mr) throws WindowingException{
		// reduce side work
		Operator<FileSinkDesc> op4 = OperatorFactory.get(new FileSinkDesc(
				mrUtils.getOutputPath(), createOutputTableDesc(qdef), false));

		Operator<PTFDesc> op3 = RuntimeUtils.createPTFOperator(new PTFDesc(
				SerializationUtils.serializeQueryDef(qdef)), op4);

		Operator<ExtractDesc> op2 = OperatorFactory.get(
				new ExtractDesc(
						TranslateUtils
								.getStringColumn(Utilities.ReduceField.VALUE
										.toString())), op3);

		mr.setReducer(op2);
	}

	/**
	 * Invoke the MapRedTask and set the MapRedWork 
	 * query plan to be used for execution.  
	 * MapRedTask (an extension to the ExecDriver) is 
	 * used to execute the query plan on Hadoop.
	 * @param mr
	 * @param hiveConf
	 * @throws Exception
	 */
	private void executePlan(MapredWork mr, HiveConf hiveConf) throws Exception
	{
		MapRedTask mrtask = new MapRedTask();
		DriverContext dctx = new DriverContext();
		mrtask.setWork(mr);
		mrtask.initialize(hiveConf, null, dctx);
		int exitVal = mrtask.execute(dctx);

		if (exitVal != 0)
		{
			System.out.println("Test execution failed with exit status: "
					+ exitVal);
			throw new WindowingException(
					"Test execution failed with exit status: " + exitVal);
		}
		else
			System.out.println("Test execution completed successfully");

	}
	
	/**
	 * Use the settings on the QueryOutputDef to define the 
	 * properties for the output table in hive.
	 * @param qDef
	 * @return
	 * @throws WindowingException
	 */
	static TableDesc createOutputTableDesc(QueryDef qDef) throws WindowingException
	{
		QueryOutputDef oDef = qDef.getOutput();
		Class<? extends SerDe> serDeClass = oDef.getSerDe().getClass();
		Properties p = oDef.getSpec().getSerDeProps();
		String columnNamesList = p.getProperty(Constants.LIST_COLUMNS);
		String columnTypesList = p.getProperty(Constants.LIST_COLUMN_TYPES);
		String fieldSeparator = p.getProperty(Constants.FIELD_DELIM, Integer.toString(Utilities.ctrlaCode));
		return PlanUtils.getTableDesc(serDeClass, fieldSeparator,
			      columnNamesList, columnTypesList, false);
	}

}
