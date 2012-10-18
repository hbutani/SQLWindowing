package com.sap.hadoop.windowing.runtime2.mr;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluatorFactory;
import org.apache.hadoop.hive.ql.exec.ExtractOperator;
import org.apache.hadoop.hive.ql.exec.Operator;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.OperatorDesc;
import org.apache.hadoop.hive.ql.plan.api.OperatorType;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils.ObjectInspectorCopyOption;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.SerializationUtils;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.PartitionDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.translate.QueryDefDeserializer;
import com.sap.hadoop.windowing.query2.translate.QueryDefVisitor;
import com.sap.hadoop.windowing.query2.translate.QueryDefWalker;
import com.sap.hadoop.windowing.runtime2.Executor;
import com.sap.hadoop.windowing.runtime2.Executor.ForwardSink;
import com.sap.hadoop.windowing.runtime2.Partition;
import com.sap.hadoop.windowing.runtime2.RuntimeUtils;

public class PTFOperator extends Operator<PTFDesc> implements Serializable
{

	private static final long serialVersionUID = 1L;
	QueryDef qDef;
	Partition inputPart;
	boolean isMapOperator;
	
	transient boolean firstRow;
	transient WindowingKeyWrapperFactory keyWrapperFactory;
	protected transient WindowingKeyWrapper currentKeys;
	protected transient WindowingKeyWrapper newKeys;
	transient HiveConf hiveConf;

	@Override
	protected void initializeOp(Configuration jobConf) throws HiveException
	{
		hiveConf = new HiveConf(jobConf, PTFOperator.class);
		Operator<? extends OperatorDesc> parentOp = getParentOperators().get(0);
		if (parentOp instanceof ExtractOperator)
		{
			isMapOperator = false;
		}
		else
		{
			isMapOperator = true;
		}
		System.out.println("isMapOperator - " + isMapOperator);

		qDef = (QueryDef) SerializationUtils
				.deserialize(new ByteArrayInputStream(conf.getQueryDefStr()
						.getBytes()));
		try
		{
			reconstructQueryDef(hiveConf);
			inputPart = RuntimeUtils.createPartition(qDef,
					inputObjInspectors[0], hiveConf);
		}
		catch (WindowingException we)
		{
			throw new HiveException(
					"Cannot create input partition for PTFOperator.", we);
		}
		outputObjInspector = qDef.getSelectList().getOI();
		
		firstRow = true;
		setupKeysWrapper(inputObjInspectors[0]);
		
		super.initializeOp(jobConf);
	}

	@Override
	protected void closeOp(boolean abort) throws HiveException
	{
		super.closeOp(abort);
		processInputPartition();
	}

	@Override
	public void processOp(Object row, int tag) throws HiveException
	{
		try
		{
			/*
			 * checkif current row belongs to the current accumulated Partition:
			 * - If not:
			 * 	- process the current Partition
			 *  - reset input Partition
			 * - set currentKey to the newKey if it is null or has changed.
			 */
			newKeys.getNewKey(row, inputPart.getOI());
			boolean keysAreEqual = (currentKeys != null && newKeys != null)?
			        newKeys.equals(currentKeys) : false;
			        
			if (currentKeys != null && !keysAreEqual)
			{
				processInputPartition();
				inputPart = RuntimeUtils.createPartition(qDef, inputObjInspectors[0], hiveConf);
			}
			
			if (currentKeys == null || !keysAreEqual)
			{
				if (currentKeys == null)
				{
					currentKeys = newKeys.copyKey();
				}
				else
				{
					currentKeys.copyKey(newKeys);
				}
			}
			
			// add row to current Partition.			
			inputPart.append(row);
		}
		catch (WindowingException we)
		{
			throw new HiveException("Cannot process PTFOperator.", we);
		}
	}

	void reconstructQueryDef(HiveConf hiveConf) throws WindowingException
	{

		QueryDefVisitor qdd = new QueryDefDeserializer(hiveConf,
				inputObjInspectors[0]);
		QueryDefWalker qdw = new QueryDefWalker(qdd);
		qdw.walk(qDef);
	}

	protected void setupKeysWrapper(ObjectInspector inputOI) throws HiveException
	{
		PartitionDef pDef = RuntimeUtils.getFirstTableFunction(qDef).getWindow().getPartDef();
		ArrayList<ColumnDef> cols = pDef.getColumns();
		int numCols = cols.size();
		ExprNodeEvaluator[] keyFields = new ExprNodeEvaluator[numCols];
		ObjectInspector[] keyOIs = new ObjectInspector[numCols];
		ObjectInspector[] currentKeyOIs = new ObjectInspector[numCols];
		
		for(int i=0; i<numCols; i++)
		{
			ColumnDef cDef = cols.get(i);
			/*
			 * Why cannot we just use the ExprNodeEvaluator on the column?
			 * - because on the reduce-side it is initialized based on the rowOI of the HiveTable 
			 *   and not the OI of the ExtractOp ( the parent of this Operator on the reduce-side)
			 */
			keyFields[i] = ExprNodeEvaluatorFactory.get(cDef.getExprNode());
			keyOIs[i] = keyFields[i].initialize(inputOI);
			currentKeyOIs[i] = ObjectInspectorUtils.getStandardObjectInspector(keyOIs[i], ObjectInspectorCopyOption.WRITABLE);
		}
		
		keyWrapperFactory = new WindowingKeyWrapperFactory(keyFields, keyOIs, currentKeyOIs);

	    newKeys = keyWrapperFactory.getWindowingKeyWrapper();
	}
	
	protected void processInputPartition() throws HiveException
	{
		try
		{
			Partition outPart = Executor.executeChain(qDef, inputPart);
			Executor.executeSelectList(qDef, outPart, new ForwardPTF());
		}
		catch (WindowingException we)
		{
			throw new HiveException("Cannot close PTFOperator.", we);
		}
	}

	public class ForwardPTF implements ForwardSink
	{

		@Override
		public void collectOutput(Writable key, Writable value)
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public void collectOutput(Object[] o, ObjectInspector oi)
		{
			try
			{
				forward(o, outputObjInspector);
			}
			catch (HiveException e)
			{
				throw new RuntimeException(
						"Cannot forward output from PTF operator.", e);
			}
		}

		@Override
		public boolean acceptObject()
		{
			return true;
		}
	}
	
	/**
	 * @return the name of the operator
	 */
	@Override
	public String getName()
	{
		return "PTF";
	}

	@Override
	public OperatorType getType()
	{
		return null;
	}
}
