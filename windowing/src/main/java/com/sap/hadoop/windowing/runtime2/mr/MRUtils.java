package com.sap.hadoop.windowing.runtime2.mr;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hive.ql.exec.ColumnInfo;
import org.apache.hadoop.hive.ql.metadata.Table;
import org.apache.hadoop.hive.ql.parse.RowResolver;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;

import com.sap.hadoop.metadata.Order;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.HiveTableDef;
import com.sap.hadoop.windowing.query2.definition.OrderColumnDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.specification.QueryOutputSpec;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo.InputInfo;
import com.sap.hadoop.windowing.query2.translate.TranslateUtils;
import com.sap.hadoop.windowing.runtime2.RuntimeUtils;

/**
 * Utility class to construct and retrieve data structures required for
 * constructing an operator tree
 * 
 */
public class MRUtils
{
	QueryDef qdef;
	ArrayList<ExprNodeDesc> partCols = new ArrayList<ExprNodeDesc>();
	ArrayList<ExprNodeDesc> valueCols = new ArrayList<ExprNodeDesc>();
	ArrayList<ExprNodeDesc> orderCols = new ArrayList<ExprNodeDesc>();
	List<String> outputColumnNames = new ArrayList<String>();
	StringBuilder orderString = new StringBuilder();
	String outputPath;
	Table inputTable;
	HiveTableDef hiveTableDef;

	public MRUtils(QueryDef qdef)
	{
		this.qdef = qdef;
	}

	public ArrayList<ExprNodeDesc> getPartCols()
	{
		return partCols;
	}

	public void setPartCols(ArrayList<ExprNodeDesc> partCols)
	{
		this.partCols = partCols;
	}

	public ArrayList<ExprNodeDesc> getValueCols()
	{
		return valueCols;
	}

	public void setValueCols(ArrayList<ExprNodeDesc> valueCols)
	{
		this.valueCols = valueCols;
	}

	public ArrayList<ExprNodeDesc> getOrderCols()
	{
		return orderCols;
	}

	public void setOrderCols(ArrayList<ExprNodeDesc> orderCols)
	{
		this.orderCols = orderCols;
	}

	public List<String> getOutputColumnNames()
	{
		return outputColumnNames;
	}

	public void setOutputColumnNames(List<String> outputColumnNames)
	{
		this.outputColumnNames = outputColumnNames;
	}

	public StringBuilder getOrderString()
	{
		return orderString;
	}

	public void setOrderString(StringBuilder orderString)
	{
		this.orderString = orderString;
	}

	public String getOutputPath()
	{
		QueryOutputSpec qOutSpec = qdef.getOutput().getOutputSpec();
		outputPath = qOutSpec.getPath();
		return outputPath;
	}

	public void setOutputPath(String outputPath)
	{
		this.outputPath = outputPath;
	}

	public Table getInputTable()
	{
		inputTable = qdef.getTranslationInfo().getTbl();
		return inputTable;
	}

	public void setInputTable(Table inputTable)
	{
		this.inputTable = inputTable;
	}

	public HiveTableDef getHiveTableDef()
	{
		return hiveTableDef;
	}

	public void setHiveTableDef(HiveTableDef hiveTableDef)
	{
		this.hiveTableDef = hiveTableDef;
	}

	/**
	 * Returns true if the query needs a map-side reshape. PTFOperator is added
	 * on the map-side before ReduceSinkOperator in this scenario.
	 * 
	 * @param qdef
	 * @return
	 */
	public static boolean addPTFMapOperator(QueryDef qdef)
	{
		boolean hasMap = false;
		TableFuncDef tabDef = RuntimeUtils.getFirstTableFunction(qdef);
		TableFunctionEvaluator tEval = tabDef.getFunction();
		if (tEval.hasMapPhase())
		{
			hasMap = true;
		}
		return hasMap;

	}

	/**
	 * Construct the data structures containing ExprNodeDesc for partition
	 * columns and order columns. Use the input definition to construct the list
	 * of output columns for the ReduceSinkOperator
	 * 
	 * @throws WindowingException
	 */
	public void initialize() throws WindowingException
	{

		TableFuncDef tabDef = RuntimeUtils.getFirstTableFunction(qdef);
		hiveTableDef = tabDef.getHiveTableDef();
		InputInfo inputInfo;
		ArrayList<ColumnDef> partColList = tabDef.getWindow().getPartDef()
				.getColumns();

		TableFunctionEvaluator tEval = tabDef.getFunction();

		/*
		 * If the query has a map phase, the inputInfo is retrieved from the map
		 * output info of the table function definition. This is constructed
		 * using the map output oi of the table function definition. If the
		 * query does not have a map phase, the inputInfo is retrieved from the
		 * QueryInputDef (either HiveTableDef or HiveQueryDef) of the query.
		 */
		if (tEval.hasMapPhase())
		{
			inputInfo = qdef.getTranslationInfo().getMapInputInfo(tabDef);
		}
		else
		{
			inputInfo = qdef.getTranslationInfo().getInputInfo(hiveTableDef);
		}

		for (ColumnDef colDef : partColList)
		{
			partCols.add(colDef.getExprNode());
		}

		ArrayList<OrderColumnDef> orderColList = tabDef.getWindow()
				.getOrderDef().getColumns();

		for (OrderColumnDef colDef : orderColList)
		{
			Order order = colDef.getOrder();
			if (order.name().equals("ASC"))
			{
				orderString.append('+');
			}
			else
			{
				orderString.append('-');
			}

			orderCols.add(colDef.getExprNode());
			outputColumnNames.add(colDef.getAlias());
		}

		RowResolver rr = inputInfo.getRowResolver();
		ArrayList<ColumnInfo> colInfoList = rr.getColumnInfos();
		for (ColumnInfo colInfo : colInfoList)
		{
			String internalName = colInfo.getInternalName();
			TypeInfo type = colInfo.getType();
			valueCols.add(TranslateUtils.getExprDesc(internalName, type));
			outputColumnNames.add(internalName);
		}

	}

}
