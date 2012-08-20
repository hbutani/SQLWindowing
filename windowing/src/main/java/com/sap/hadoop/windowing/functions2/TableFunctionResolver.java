package com.sap.hadoop.windowing.functions2;

import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFResolver;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

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
	
	public TableFunctionEvaluator initialize(QueryDef qDef, TableFuncDef tDef) throws WindowingException
	{
		setHasMapPhase();
		setupOI();
		tDef.setOI(OI);
		if ( hasMapPhase())
		{
			setupMapOI();
		}
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
	}
	
	public abstract TableFunctionEvaluator setupEvaluator();
	
}
