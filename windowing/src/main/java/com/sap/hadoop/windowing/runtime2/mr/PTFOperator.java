package com.sap.hadoop.windowing.runtime2.mr;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluatorFactory;
import org.apache.hadoop.hive.ql.exec.Operator;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.api.OperatorType;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorConverters;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorConverters.Converter;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

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
    	queryDef = conf.getPlan();
    	qDef = (QueryDef) SerializationUtils.deserialize(
    			new ByteArrayInputStream(queryDef.getBytes()));
    	reconstructQueryDef(qDef, hiveConf);
		
    	initOutputOI();
		inputPart = createPartition();
		initializeChildren(jobConf);
    }
    
    @Override
    protected void closeOp(boolean abort) throws HiveException {
    	super.closeOp(abort);
		try {
	    	Partition outPart = executePTF(inputPart);
	    	executeSelectList(qDef, outPart);
    	} catch (WindowingException e) {
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
			if (iDef instanceof TableFuncDef )
			{
				fnDefs.push((TableFuncDef)iDef);
				iDef = ((TableFuncDef) iDef).getInput();
			}
			else
			{
				break;
			}
		}
		
		TableFuncDef currFnDef;
		while( !fnDefs.isEmpty() )
		{
			currFnDef = fnDefs.pop();
			try {
				part = currFnDef.getFunction().execute(part);
			} catch (WindowingException e) {
				e.printStackTrace();
			}
		}
		return part;
	}
	
	
	//@SuppressWarnings("unchecked")
	public void executeSelectList(QueryDef qDef, Partition oPart
			) throws WindowingException, HiveException
	{
		
		ArrayList<ColumnDef> cols = qDef.getSelectList().getColumns();
		WhereDef whDef = qDef.getWhere();
		boolean applyWhere = whDef != null;
		Converter whConverter = !applyWhere ? null : 
				ObjectInspectorConverters.getConverter(
						whDef.getOI(), 
						PrimitiveObjectInspectorFactory.javaBooleanObjectInspector);
		ExprNodeEvaluator whCondEval = !applyWhere ? null : whDef.getExprEvaluator();
				
		//Writable value = null;
		PartitionIterator<Object> pItr = oPart.iterator();
		RuntimeUtils.connectLeadLagFunctionsToPartition(qDef, pItr);
		while(pItr.hasNext())
		{
			int colCnt = 0;
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
				}
				catch(HiveException he)
				{
					throw new WindowingException(he);
				}
			}
			
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
}
