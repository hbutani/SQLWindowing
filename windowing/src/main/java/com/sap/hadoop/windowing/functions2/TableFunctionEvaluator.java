package com.sap.hadoop.windowing.functions2;

import static com.sap.hadoop.Utils.sprintf;

import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.Utils;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.runtime2.Partition;

/**
 * Based on Hive {@link GenericUDAFEvaluator}. Break up the responsibility of the old AsbtractTableFunction class into a Resolver and Evaluator.
 * 
 *
 */
public abstract class TableFunctionEvaluator
{
	protected TableFunctionResolver resolver;
	transient protected StructObjectInspector OI;
	transient protected StructObjectInspector mapOI;
	protected TableFuncDef tDef;
	protected QueryDef qDef;
	String partitionClass;
	int partitionMemSize;
	
	static{
		Utils.makeTransient(TableFunctionEvaluator.class, "OI");
		Utils.makeTransient(TableFunctionEvaluator.class, "mapOI");
	}

	
	public TableFunctionResolver getResolver()
	{
		return resolver;
	}

	public void setResolver(TableFunctionResolver resolver)
	{
		this.resolver = resolver;
	}
	
	public StructObjectInspector getOutputOI()
	{
		return OI;
	}
	
	public void setTableDef(TableFuncDef tDef)
	{
		this.tDef = tDef;
	}

	public void setQueryDef(QueryDef qDef)
	{
		this.qDef = qDef;
	}

	public void setPartitionClass(String partitionClass)
	{
		this.partitionClass = partitionClass;
	}

	public void setPartitionMemSize(int partitionMemSize)
	{
		this.partitionMemSize = partitionMemSize;
	}

	public StructObjectInspector getMapOutputOI()
	{
		return mapOI;
	}
	
	public TableFuncDef getTableDef()
	{
		return tDef;
	}
	
	public QueryDef getQueryDef()
	{
		return qDef;
	}
	
	public abstract void setupOI() throws WindowingException; 
	
	public void setupMapOI() throws WindowingException
	{
		if (!resolver.hasMapPhase())
		{
			return;
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
	
	public boolean hasMapPhase()
	{
		return resolver.hasMapPhase();
	}
	
	public Partition execute(Partition iPart) throws WindowingException
	{
		Partition outP = new Partition(getPartitionClass(), getPartitionMemSize(), tDef.getSerde(), OI);
		execute(iPart, outP);
		return outP;
	}
	
	protected void execute(Partition iPart, Partition oPart) throws WindowingException
	{
		
	}

	public Partition mapExecute(Partition iPart) throws WindowingException
	{
		if ( !resolver.hasMapPhase())
		{
			throw new WindowingException(sprintf("Internal Error: mapExecute called on function (%s)that has no Map Phase", tDef.getName()));
		}
		return _mapExecute(iPart);
	}
	
	protected Partition _mapExecute(Partition iPart) throws WindowingException
	{
		return null;
	}
}
