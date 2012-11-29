package com.sap.hadoop.windowing.functions2;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFResolver;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.ds.list.ByteBasedList;
import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;

/**
 * Based on Hive {@link GenericUDAFResolver}. Break up the responsibility of the
 * old AbstractTableFunction class into a Resolver and Evaluator.
 * The Resolver is responsible for:
 * <ol>
 * <li> setting up the {@link tableFunctionEvaluator}
 * <li> Setting up the The raw and output ObjectInspectors of the Evaluator.
 * <li> The Evaluator also holds onto the {@link TableFunctionDef}. This provides information
 * about the arguments to the function, the shape of the Input partition and the Partitioning details.
 * </ol>
 * The Resolver for a function is obtained from the {@link FunctionRegistry}. The Resolver is initialized
 * by the following 4 step process:
 * <ol>
 * <li> The initialize method is called; which is passed the {@link QueryDef} and the {@link TableFunctionDef}.
 * <li> The resolver is then asked to setup the Raw ObjectInspector. This is only required if the Function reshapes
 * the raw input.
 * <li> Once the Resolver has had a chance to compute the shape of the Raw Input that is fed to the partitioning 
 * machinery; the translator sets up the partitioning details on the tableFuncDef.
 * <li> finally the resolver is asked to setup the output ObjectInspector.
 * </ol> 
 */
@SuppressWarnings("deprecation")
public abstract class TableFunctionResolver
{
	TableFunctionEvaluator evaluator;
	QueryDef qDef;

	/*
	 * - called during translation.
	 * - invokes createEvaluator which must be implemented by a subclass
	 * - sets up the evaluator with references to the TableDef, PartitionClass, PartitonMemsize and
	 *   the transformsRawInput boolean.
	 */
	public void initialize(QueryDef qDef, TableFuncDef tDef)
			throws WindowingException
	{
		this.qDef = qDef;
		HiveConf cfg = qDef.getTranslationInfo().getHiveCfg();
		String partitionClass = cfg.get(Constants.WINDOW_PARTITION_CLASS,
				Constants.DEFAULT_WINDOW_PARTITION_CLASS);
		int partitionMemSize = cfg.getInt(Constants.WINDOW_PARTITION_MEM_SIZE,
				ByteBasedList.MEDIUM_SIZE);

		evaluator = createEvaluator(qDef, tDef);
		evaluator.setTransformsRawInput(transformsRawInput());
		evaluator.setTableDef(tDef);
		evaluator.setQueryDef(qDef);
		evaluator.setPartitionClass(partitionClass);
		evaluator.setPartitionMemSize(partitionMemSize);

	}
	
	/*
	 * called during deserialization of a QueryDef during runtime.
	 */
	public void initialize(QueryDef qDef, TableFuncDef tDef, TableFunctionEvaluator evaluator)
			throws WindowingException 
	{
		this.evaluator = evaluator;
		this.qDef = qDef;
		evaluator.setTableDef(tDef);
		evaluator.setQueryDef(qDef);
	}
	
	public TableFunctionEvaluator getEvaluator()
	{
		return evaluator;
	}

	/*
	 * - a subclass must provide this method.
	 * - this method is invoked during translation and also when the Operator is initialized during runtime.
	 * - a subclass must use this call to setup the shape of its output.
	 * - subsequent to this call, a call to getOutputOI call on the {@link TableFunctionEvaluator} must return the OI
	 * of the output of this function.
	 */
	public abstract void setupOutputOI() throws WindowingException;

	/*
	 * - Called on functions that transform the raw input.
	 * - this method is invoked during translation and also when the Operator is initialized during runtime.
	 * - a subclass must use this call to setup the shape of the raw input, that is fed to the partitioning mechanics.
	 * - subsequent to this call, a call to getRawInputOI call on the {@link TableFunctionEvaluator} must return the OI
	 *   of the output of this function.
	 */
	public void setupRawInputOI() throws WindowingException
	{
		if (!transformsRawInput())
		{
			return;
		}
		throw new WindowingException(
				"Function has map phase, must extend setupMapOI");
	}
	
	/*
	 * callback method used by subclasses to set the RawInputOI on the Evaluator.
	 */
	protected void setRawInputOI(StructObjectInspector rawInputOI)
	{
		evaluator.setRawInputOI(rawInputOI);
	}
	
	/*
	 * callback method used by subclasses to set the OutputOI on the Evaluator.
	 */
	protected void setOutputOI(StructObjectInspector outputOI)
	{
		evaluator.setOutputOI(outputOI);
	}

	public QueryDef getQueryDef()
	{
		return qDef;
	}

	/*
	 * a subclass must indicate whether it will transform the raw input before it is fed through the
	 * partitioning mechanics.
	 */
	public abstract boolean transformsRawInput();

	/*
	 * a subclass must provide the {@link TableFunctionEvaluator} instance.
	 */
	protected abstract TableFunctionEvaluator createEvaluator(QueryDef qDef,
			TableFuncDef tDef);
}
