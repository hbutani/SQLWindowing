package com.sap.hadoop.windowing.functions2;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFResolver;

import com.sap.hadoop.ds.list.ByteBasedList;
import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;

/**
 * Based on Hive {@link GenericUDAFResolver}. Break up the responsibility of the
 * old AsbtractTableFunction class into a Resolver and Evaluator.
 * 
 * 
 */
@SuppressWarnings("deprecation")
public abstract class TableFunctionResolver {
	protected boolean hasMapPhase;

	public TableFunctionEvaluator initialize(QueryDef qDef, TableFuncDef tDef)
			throws WindowingException {
		HiveConf cfg = qDef.getTranslationInfo().getHiveCfg();
		String partitionClass = cfg.get(Constants.WINDOW_PARTITION_CLASS,
				Constants.DEFAULT_WINDOW_PARTITION_CLASS);
		int partitionMemSize = cfg.getInt(Constants.WINDOW_PARTITION_MEM_SIZE,
				ByteBasedList.MEDIUM_SIZE);

		TableFunctionEvaluator tfEval = createEvaluator(qDef, tDef);
		tfEval.setResolver(this);
		tfEval.setQueryDef(qDef);
		tfEval.setTableDef(tDef);
		tfEval.setPartitionClass(partitionClass);
		tfEval.setPartitionMemSize(partitionMemSize);

		return tfEval;
	}

	public boolean hasMapPhase() {
		return hasMapPhase;
	}

	protected void setHasMapPhase() throws WindowingException {
		hasMapPhase = false;
	}

	protected abstract TableFunctionEvaluator createEvaluator(QueryDef qDef,
			TableFuncDef tDef);

}
