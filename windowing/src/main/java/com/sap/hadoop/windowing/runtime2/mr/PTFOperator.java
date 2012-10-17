package com.sap.hadoop.windowing.runtime2.mr;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.exec.ExtractOperator;
import org.apache.hadoop.hive.ql.exec.Operator;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.OperatorDesc;
import org.apache.hadoop.hive.ql.plan.api.OperatorType;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.SerializationUtils;
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

	@Override
	protected void initializeOp(Configuration jobConf) throws HiveException
	{
		HiveConf hiveConf = new HiveConf(jobConf, PTFOperator.class);
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
		// outputObjInspector =
		// ObjectInspectorUtils.getStandardObjectInspector(qDef.getSelectList().getOI());
		super.initializeOp(jobConf);
	}

	@Override
	protected void closeOp(boolean abort) throws HiveException
	{
		super.closeOp(abort);
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

	@Override
	public void processOp(Object row, int tag) throws HiveException
	{
		// hold on to all the rows in partition; required later to execute PTF
		// chain
		try
		{
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
