package com.sap.hadoop.windowing.runtime2.mr;

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

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.SerializationUtils;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.translate.TranslateUtils;
import com.sap.hadoop.windowing.runtime2.Executor;
import com.sap.hadoop.windowing.runtime2.RuntimeUtils;
import com.sap.hadoop.windowing.runtime2.WindowingShell;

public class MRExecutor extends Executor
{

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

	@SuppressWarnings("unchecked")
	private void createOperatorTree(QueryDef qdef, MapredWork mr)
			throws SemanticException, WindowingException
	{
		mr.setNumReduceTasks(Integer.valueOf(1));
		MRUtils mrUtils = new MRUtils(qdef);
		mrUtils.initialize();

		// map-side work
		Operator<ReduceSinkDesc> op1 = OperatorFactory.get(PlanUtils
				.getReduceSinkDesc(mrUtils.getOrderCols(), mrUtils
						.getValueCols(), mrUtils.getOutputColumnNames(), true,
						-1, mrUtils.getPartCols(), mrUtils.getOrderString()
								.toString(), -1));

		Utilities.addMapWork(mr, mrUtils.getInputTable(), mrUtils
				.getHiveTableDef().getAlias(), op1);
		mr.setKeyDesc(op1.getConf().getKeySerializeInfo());
		mr.getTagToValueDesc().add(op1.getConf().getValueSerializeInfo());

		// reduce side work
		Operator<FileSinkDesc> op4 = OperatorFactory.get(new FileSinkDesc(
				mrUtils.getOutputPath(), Utilities.defaultTd, false));

		Operator<PTFDesc> op3 = RuntimeUtils.createPTFOperator(new PTFDesc(
				SerializationUtils.serializeQueryDef(qdef)), op4);

		Operator<ExtractDesc> op2 = OperatorFactory.get(
				new ExtractDesc(
						TranslateUtils
								.getStringColumn(Utilities.ReduceField.VALUE
										.toString())), op3);

		mr.setReducer(op2);
	}

	private void executePlan(MapredWork mr, HiveConf hiveConf) throws Exception
	{
		MapRedTask mrtask = new MapRedTask();
		DriverContext dctx = new DriverContext();
		mrtask.setWork(mr);
		mrtask.initialize(hiveConf, null, dctx);
		int exitVal = mrtask.execute(dctx);

		if (exitVal != 0)
		{
			System.out.println("Test execution failed with exit status: " + exitVal);
		}
		else
			System.out.println("Test execution completed successfully");

	}

}
