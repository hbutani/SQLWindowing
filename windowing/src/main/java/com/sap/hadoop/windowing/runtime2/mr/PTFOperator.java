package com.sap.hadoop.windowing.runtime2.mr;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluatorFactory;
import org.apache.hadoop.hive.ql.exec.Operator;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
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
import com.sap.hadoop.windowing.query2.SerializationUtils;
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
    String queryDef;
    Partition inputPart;
    transient Object[] output;
    protected transient ExprNodeEvaluator[] eval;
    HiveConf hiveConf;


    @Override
    protected void initializeOp(Configuration jobConf) throws HiveException {
    	super.initializeOp(jobConf);
    	hiveConf = new HiveConf(jobConf, PTFOperator.class);
    	//qDef = conf.getQdef();
    	queryDef = conf.getQueryDef();
    	qDef = (QueryDef) SerializationUtils.deserialize(
    			new ByteArrayInputStream(queryDef.getBytes()));
    	reconstructQueryDef(qDef, hiveConf);
		
    	initOutputOI();
		inputPart = createPartition();
		initializeChildren(jobConf);
    }
    
    private void initOutputOI(){
	    ArrayList<ColumnDef> selColDefs = qDef.getSelectList().getColumns();
	    ArrayList<String> selectOutputColumns = new ArrayList<String>();
        eval = new ExprNodeEvaluator[selColDefs.size()];
        int colCnt = 0;
	    
	    for (ColumnDef colDef : selColDefs) {
	    	ExprNodeDesc colExpr = colDef.getExprNode();
	    	String colName = colDef.getExpression().getChild(0).getText();
	          assert (colExpr != null);
	          eval[colCnt++] = ExprNodeEvaluatorFactory.get(colExpr);
	          selectOutputColumns.add(colName);
	          System.out.print("Column - " + colName);
		}

        output = new Object[eval.length];
        try {
			outputObjInspector = initEvaluatorsAndReturnStruct(eval, 
					selectOutputColumns, qDef.getSelectList().getOI());
		} catch (HiveException e) {
			e.printStackTrace();
		}
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
	}

    @Override
    protected void closeOp(boolean abort) throws HiveException {
    	super.closeOp(abort);
		try {
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
			int colCnt = 0;
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
					Object newCol = cDef.getExprEvaluator().evaluate(oRow);
					output[colCnt++] = newCol;
					selectList.add(newCol);
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
