package com.sap.hadoop.windowing.functions2;

import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFResolver;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.ds.list.ByteBasedList;
import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;

import static com.sap.hadoop.Utils.sprintf;

/**
 * Based on Hive {@link GenericUDAFResolver}. Break up the responsibility of the old AsbtractTableFunction class into a Resolver and Evaluator.
 * 
 *
 */
@SuppressWarnings("deprecation")
public abstract class TableFunctionResolver
{
	protected boolean hasMapPhase;
	protected StructObjectInspector OI;
	protected StructObjectInspector mapOI;
	protected TableFuncDef tDef;
	protected QueryDef qDef;
	String partitionClass;
	int partitionMemSize;
	
	public TableFunctionEvaluator initialize(QueryDef qDef, TableFuncDef tDef) throws WindowingException
	{
		this.tDef = tDef;
		this.qDef = qDef;
		setHasMapPhase();
		setupOI();
		if ( hasMapPhase())
		{
			setupMapOI();
		}
		
		HiveConf cfg = qDef.getTranslationInfo().getHiveCfg();
		partitionClass = cfg.get(Constants.WINDOW_PARTITION_CLASS, Constants.DEFAULT_WINDOW_PARTITION_CLASS);
		partitionMemSize = cfg.getInt(Constants.WINDOW_PARTITION_MEM_SIZE, ByteBasedList.LARGE_SIZE);
		
		
		TableFunctionEvaluator tfEval =  setupEvaluator();
		tfEval.setResolver(this);
		return tfEval;
	}
	
	public boolean hasMapPhase()
	{
		return hasMapPhase;
	}
	
	public StructObjectInspector getOutputOI()
	{
		return OI;
	}
	
	public StructObjectInspector getMapOutputOI()
	{
		return mapOI;
	}
	
	public TableFuncDef getDef()
	{
		return tDef;
	}
	
	public QueryDef getQueryDef()
	{
		return qDef;
	}
	
	protected void setHasMapPhase() throws WindowingException
	{
		hasMapPhase = false;
	}
	
	protected abstract void setupOI() throws WindowingException; 
	
	protected void setupMapOI() throws WindowingException
	{
		if (!hasMapPhase())
		{
			throw new WindowingException(sprintf("Internal Error: setup Map OI called on function (%s)that has no Map Phase", tDef.getName()));
		}
		mapOI = OI;
	}
	
	public String getPartitionClass()
	{
		return partitionClass;
	}

	public int getPartitionMemSize()
	{
		return partitionMemSize;
	}

	protected abstract TableFunctionEvaluator setupEvaluator();
	
}
