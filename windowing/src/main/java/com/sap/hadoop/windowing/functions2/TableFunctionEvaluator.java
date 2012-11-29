package com.sap.hadoop.windowing.functions2;

import static com.sap.hadoop.Utils.sprintf;

import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.SerializationUtils;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.runtime2.Partition;
import com.sap.hadoop.windowing.runtime2.PartitionIterator;
import com.sap.hadoop.windowing.runtime2.RuntimeUtils;

/**
 * Based on Hive {@link GenericUDAFEvaluator}. Break up the responsibility of the old AsbtractTableFunction 
 * class into a Resolver and Evaluator.
 * <p>
 * The Evaluator also holds onto the {@link TableFunctionDef}. This provides information
 * about the arguments to the function, the shape of the Input partition and the Partitioning details. 
 * The Evaluator is responsible for providing the 2 execute methods:
 * <ol>
 * <li><b>execute:</b> which is invoked after the input is partitioned; the contract
 * is, it is given an input Partition and must return an output Partition. The shape of the output
 * Partition is obtained from the getOutputOI call. 
 * <li><b>transformRawInput:</b> In the case where this function indicates that it will transform the raw input
 * before it is fed through the partitioning mechanics, this function is called. Again the contract is
 * t is given an input Partition and must return an Partition. The shape of the output Partition is
 * obtained from getRawInputOI() call.
 * </ol>

 * </ol> 
 *
 */
public abstract class TableFunctionEvaluator
{
	transient protected StructObjectInspector OI;
	transient protected StructObjectInspector rawInputOI;
	protected TableFuncDef tDef;
	protected QueryDef qDef;
	String partitionClass;
	int partitionMemSize;
	boolean transformsRawInput;

	static{
		SerializationUtils.makeTransient(TableFunctionEvaluator.class, "OI");
		SerializationUtils.makeTransient(TableFunctionEvaluator.class, "rawInputOI");
	}


	public StructObjectInspector getOutputOI()
	{
		return OI;
	}
	
	protected void setOutputOI(StructObjectInspector outputOI)
	{
		OI = outputOI;
	}

	public TableFuncDef getTableDef()
	{
		return tDef;
	}

	public void setTableDef(TableFuncDef tDef)
	{
		this.tDef = tDef;
	}

	protected QueryDef getQueryDef()
	{
		return qDef;
	}

	protected void setQueryDef(QueryDef qDef)
	{
		this.qDef = qDef;
	}

	public String getPartitionClass()
	{
		return partitionClass;
	}

	public void setPartitionClass(String partitionClass)
	{
		this.partitionClass = partitionClass;
	}

	public int getPartitionMemSize()
	{
		return partitionMemSize;
	}

	public void setPartitionMemSize(int partitionMemSize)
	{
		this.partitionMemSize = partitionMemSize;
	}

	public StructObjectInspector getRawInputOI()
	{
		return rawInputOI;
	}
	
	protected void setRawInputOI(StructObjectInspector rawInputOI)
	{
		this.rawInputOI = rawInputOI;
	}

	public boolean isTransformsRawInput() {
    return transformsRawInput;
  }

  public void setTransformsRawInput(boolean transformsRawInput) {
    this.transformsRawInput = transformsRawInput;
  }

	public Partition execute(Partition iPart)
			throws WindowingException
	{
		PartitionIterator<Object> pItr = iPart.iterator();
		RuntimeUtils.connectLeadLagFunctionsToPartition(qDef, pItr);
		Partition outP = new Partition(getPartitionClass(),
				getPartitionMemSize(), tDef.getSerde(), OI);
		execute(pItr, outP);
		return outP;
	}

	protected abstract void execute(PartitionIterator<Object> pItr, Partition oPart) throws WindowingException;

	public Partition transformRawInput(Partition iPart) throws WindowingException
	{
		if ( !isTransformsRawInput())
		{
			throw new WindowingException(sprintf("Internal Error: mapExecute called on function (%s)that has no Map Phase", tDef.getName()));
		}
		return _transformRawInput(iPart);
	}

	protected Partition _transformRawInput(Partition iPart) throws WindowingException
	{
		return null;
	}
}
