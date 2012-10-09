package com.sap.hadoop.windowing.runtime2.mr;

import java.io.File;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.Operator;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.api.OperatorType;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorConverters;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorConverters.Converter;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Writable;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.definition.WhereDef;
import com.sap.hadoop.windowing.query2.translate.QueryDefDeserializer;
import com.sap.hadoop.windowing.query2.translate.QueryDefVisitor;
import com.sap.hadoop.windowing.query2.translate.QueryDefWalker;
import com.sap.hadoop.windowing.query2.translate.TranslateUtils;
import com.sap.hadoop.windowing.runtime2.Executor.ReduceSink;
import com.sap.hadoop.windowing.runtime2.Partition;
import com.sap.hadoop.windowing.runtime2.PartitionIterator;
import com.sap.hadoop.windowing.runtime2.RuntimeUtils;

public class PTFOperator extends Operator<PTFDesc> implements
Serializable {

    private static final long serialVersionUID = 1L;
    QueryDef qDef;
    Partition inputPart;
    transient Object output;
    HiveConf hiveConf;
    int rowCnt = 0;


    @Override
    protected void initializeOp(Configuration jobConf) throws HiveException {
    	super.initializeOp(jobConf);
    	System.out.println("Initializing PTFOperator...");

    	hiveConf = new HiveConf(jobConf, PTFOperator.class);
    	qDef = conf.getQdef();
    	
    	reconstructQueryDef(qDef, hiveConf);
		
    	outputObjInspector = qDef.getSelectList().getOI();
		inputPart = createPartition();
    }
    
	void reconstructQueryDef(QueryDef qDef, HiveConf hiveConf){
		QueryDefVisitor qdd = new QueryDefDeserializer(hiveConf, inputObjInspectors[0]);
		QueryDefWalker qdw = new QueryDefWalker(qdd);
		try {
			qdw.walk(qDef);
		} catch (WindowingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finished deserializing QueryDef");
	}

    @Override
    protected void closeOp(boolean abort) throws HiveException {
    	super.closeOp(abort);
		try {
			System.out.println("Accumulated " + rowCnt + " rows..");
	    	Partition outPart = executePTF(inputPart);
	    	executeSelectList(qDef, outPart, new SysOutRS(System.out)
	    			);
    	} catch (WindowingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	@Override
	public void processOp(Object row, int tag) throws HiveException {
		//hold on to all the rows in partition; required later to execute PTF chain
		try {
			rowCnt++;
			inputPart.append(row);
		} catch (WindowingException e) {
			e.printStackTrace();
		}
	}

	private Partition createPartition()
	{
		TableFuncDef tabDef = (TableFuncDef) qDef.getInput();
		TableFunctionEvaluator tEval = tabDef.getFunction();
		String partClassName = tEval.getPartitionClass();
		int partMemSize = tEval.getPartitionMemSize();

		Partition part = null;
		try {
			SerDe serDe = TranslateUtils.createLazyBinarySerDe(hiveConf, 
					tEval.getOutputOI());
			part = new Partition(partClassName, partMemSize,
					serDe, (StructObjectInspector) inputObjInspectors[0]);
		} catch (WindowingException e) {
			e.printStackTrace();
		}
		return part;

	}


	private Partition executePTF(Partition part){
		Stack<TableFuncDef> fnDefs = new Stack<TableFuncDef>();
		QueryInputDef iDef = qDef.getInput();
		while(true)
		{
			if (iDef instanceof TableFuncDef ){
				fnDefs.push((TableFuncDef)iDef);
				iDef = ((TableFuncDef) iDef).getInput();
			}
			else
			{
				break;
			}
		}

		TableFuncDef currFnDef;
		try {
			while( !fnDefs.isEmpty() ){
			currFnDef = fnDefs.pop();
				part = currFnDef.getFunction().execute(part);
			}
		} catch (WindowingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return part;
	}
	
	
	@SuppressWarnings("unchecked")
	public void executeSelectList(QueryDef qDef, Partition oPart, ReduceSink rS
			) throws WindowingException, HiveException
	{
		ArrayList<ColumnDef> cols = qDef.getSelectList().getColumns();
		ObjectInspector selectOI = qDef.getSelectList().getOI();
		SerDe oSerDe = qDef.getOutput().getSerDe();
		
		WhereDef whDef = qDef.getWhere();
		boolean applyWhere = whDef != null;
		Converter whConverter = !applyWhere ? null : 
				ObjectInspectorConverters.getConverter(
						whDef.getOI(), 
						PrimitiveObjectInspectorFactory.javaBooleanObjectInspector);
		ExprNodeEvaluator whCondEval = !applyWhere ? null : whDef.getExprEvaluator();
				
		Writable value = null;
		PartitionIterator<Object> pItr = oPart.iterator();
		RuntimeUtils.connectLeadLagFunctionsToPartition(qDef, pItr);
		while(pItr.hasNext())
		{
			System.out.println("Processing select on next row...");
			@SuppressWarnings("rawtypes")
			ArrayList selectList = new ArrayList();
			Object oRow = pItr.next();
			
			if ( applyWhere )
			{
				Object whCond = null;
				try
				{
					whCond = whCondEval.evaluate(oRow);
					whCond = whConverter.convert(whCond);
				}
				catch(HiveException he)
				{
					throw new WindowingException(he);
				}
				if ( whCond == null || !((Boolean)whCond).booleanValue() )
				{
					continue;
				}
			}
			
			for(ColumnDef cDef : cols)
			{
				try
				{
					selectList.add(cDef.getExprEvaluator().evaluate(oRow));
				}
				catch(HiveException he)
				{
					throw new WindowingException(he);
				}
			}
			
			try
			{
				value = oSerDe.serialize(selectList, selectOI);
			}
			catch(SerDeException se)
			{
				throw new WindowingException(se);
			}
			rS.collectOutput(NullWritable.get(), value);
			output = selectList;
			forward(output, outputObjInspector);
		}
	}
	


	  /**
	   * @return the name of the operator
	   */
	  @Override
	  public String getName() {
	    return "PTF";
	  }

	@Override
	public OperatorType getType() {
		return null;
	}

	public static class SysOutRS implements ReduceSink
	{
		PrintStream out;
		private static final Log LOG = LogFactory.getLog(SysOutRS.class.getName());
		
		public SysOutRS(PrintStream out)
		{
			this.out = out;
		}
		
		public void collectOutput(Writable key, Writable value)
		{
			out.println(value);
			//System.out.println("Value=" + value);
		}
	}

}
