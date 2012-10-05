package com.sap.hadoop.windowing.query2.translate;

import static com.sap.hadoop.Utils.sprintf;

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.functions2.FunctionRegistry;
import com.sap.hadoop.windowing.functions2.TableFunctionEvaluator;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.OrderColumnDef;
import com.sap.hadoop.windowing.query2.definition.OrderDef;
import com.sap.hadoop.windowing.query2.definition.PartitionDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.definition.QueryInputDef;
import com.sap.hadoop.windowing.query2.definition.TableFuncDef;
import com.sap.hadoop.windowing.query2.definition.WindowDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.BoundaryDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.CurrentRowDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.RangeBoundaryDef;
import com.sap.hadoop.windowing.query2.definition.WindowFrameDef.ValueBoundaryDef;
import com.sap.hadoop.windowing.query2.specification.ColumnSpec;
import com.sap.hadoop.windowing.query2.specification.OrderColumnSpec;
import com.sap.hadoop.windowing.query2.specification.OrderSpec;
import com.sap.hadoop.windowing.query2.specification.PartitionSpec;
import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.query2.specification.TableFuncSpec;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.BoundarySpec;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.CurrentRowSpec;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.RangeBoundarySpec;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.ValueBoundarySpec;
import com.sap.hadoop.windowing.query2.specification.WindowSpec;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo.InputInfo;

public class WindowSpecTranslation
{
	/*
	 * compute the Description to use for the Input.
	 * get the inputInfo for the input: if the function has a MapPhase use the Map Inputfo. 
	 * invoke translateWindowSpecOnInput on WdwSpec of TblFunc
	 * If TableFunc is the FunctionRegistry.WINDOWING_TABLE_FUNCTION:
	 * - 
	 */
	static WindowDef translateWindow(QueryDef qDef, TableFuncDef tFnDef) throws WindowingException
	{
		QueryTranslationInfo tInfo = qDef.getTranslationInfo();
		TableFuncSpec tFnSpec = tFnDef.getTableFuncSpec();
		
		/*
		 * for now the Language only allows explicit specification of Partition & Order clauses.
		 * Easy to allow references to a Global Window Spec.
		 */
		WindowSpec wSpec = new WindowSpec();
		wSpec.setPartition(tFnSpec.getPartition());
		wSpec.setOrder(tFnSpec.getOrder());
		QueryInputDef iDef = tFnDef.getInput();
		
		if ( wSpec.getPartition() == null )
		{
			return null;
		}
		
		String desc = getInputDescription(qDef, tFnDef);
		TableFunctionEvaluator tFn = tFnDef.getFunction();
		InputInfo iInfo = null;
		if ( tFn.hasMapPhase() )
		{
			iInfo = tInfo.getMapInputInfo(tFnDef);
		}
		else
		{
			iInfo = tInfo.getInputInfo(iDef);
		}
		
		return translateWindowSpecOnInput(qDef, wSpec, iInfo, desc);
	}
	
	/*
	 * <ol>
	 * <li> If wSpec points to a source WindowSpec. Validate that it is valid. If it hasn't been already translated then translate it.
	 * <li> Start with an empty WdwDef or a cloned WdwDef from the source WdwDef.
	 * <li> translate the PartitionSpec if it exists. Replace the existing PDef with this; also remove the OrderDef.
	 * <li> translate the OrderSpec if it exists. Replace existing OrderDef with this.
	 * <li> add in Partition Columns if not in OrderDef already.
	 * <li> translate the WindowSpec if it exists. Replace existing WdwDef with it.
	 * <li> If name is non-null add this def to TranslationInfo::nameToWdwDef map.
	 * </ol>
	 */
	static WindowDef translateWindowSpecOnInput(QueryDef qDef, WindowSpec wSpec, InputInfo iInfo, String inputDesc) throws WindowingException
	{
		QuerySpec qSpec = qDef.getSpec();
		WindowDef wDef;
		
		fillInWindowSpec(qSpec, wSpec.getSourceId(), wSpec);
		wDef = new WindowDef(wSpec);
		
		PartitionSpec pSpec = wSpec.getPartition();
		OrderSpec oSpec = wSpec.getOrder();
		WindowFrameSpec wFrameSpec = wSpec.getWindow();
		PartitionDef pDef = translatePartition(qDef, iInfo, pSpec);
		OrderDef oDef = translateOrder(qDef, inputDesc, iInfo, oSpec, pDef);
		WindowFrameDef wdwDef = translateWindowFrame(qDef, wFrameSpec, iInfo);
		
		wDef.setPartDef(pDef);
		wDef.setOrderDef(oDef);
		wDef.setWindow(wdwDef);
		
		return wDef;
	}
	
	static void fillInWindowSpec(QuerySpec qSpec, String sourceId, WindowSpec destWSpec) throws WindowingException
	{
		if ( sourceId != null )
		{
			WindowSpec sourceWSpec = qSpec.getWindowSpecs().get(sourceId);
			if (sourceWSpec == null)
			{
				throw new WindowingException(sprintf("Window Spec %s refers to an unknown source", destWSpec));
			}
			
			if ( destWSpec.getPartition() == null )
			{
				destWSpec.setPartition(sourceWSpec.getPartition());
			}
			
			if ( destWSpec.getOrder() == null )
			{
				destWSpec.setOrder(sourceWSpec.getOrder());
			}
			
			if ( destWSpec.getWindow() == null)
			{
				destWSpec.setWindow(sourceWSpec.getWindow());
			}
			
			fillInWindowSpec(qSpec, sourceWSpec.getSourceId(), destWSpec);
		}
	}
	
	static PartitionDef translatePartition(QueryDef qDef, InputInfo iInfo, PartitionSpec spec) throws WindowingException
	{
		if ( spec == null || spec.getColumns() == null || spec.getColumns().size() == 0) 
			return null;
		
		PartitionDef pDef = new PartitionDef(spec);
		for(ColumnSpec colSpec : spec.getColumns())
		{
			ColumnDef cDef = translatePartitionColumn(qDef, iInfo, colSpec);
			pDef.addColumn(cDef);
		}
		return pDef;
	}
	
	static OrderDef translateOrder(QueryDef qDef, String inputDesc, InputInfo iInfo, OrderSpec spec, PartitionDef pDef) throws WindowingException
	{
		
		if ( spec == null || spec.getColumns() == null || spec.getColumns().size() == 0) 
		{
			if ( pDef == null )
				return null;
			return new OrderDef(pDef);
		}
		
		if ( pDef == null )
		{
			throw new WindowingException(sprintf("Input %s cannot have an Order spec w/o a Partition spec", inputDesc));
		}
		
		OrderDef oDef = new OrderDef(spec);
		for(OrderColumnSpec colSpec : spec.getColumns())
		{
			OrderColumnDef cDef = translateOrderColumn(qDef, iInfo, colSpec);
			oDef.addColumn(cDef);
		}
		
		/*
		 * either all partition columns must be in Order list or none must be specified.
		 * If none are specified then add them all.
		 */
		int numOfPartColumns = 0;
		List<OrderColumnDef> orderCols = oDef.getColumns();
		List<ColumnDef> partCols = pDef.getColumns();
		int chkSize = partCols.size();
		chkSize = chkSize > orderCols.size() ? orderCols.size() : chkSize;
		for(int i=0; i < chkSize; i++)
		{
			if ( orderCols.get(i).getSpec().getColumnName().equals(partCols.get(i).getSpec().getColumnName()))
			{
				numOfPartColumns++;
			}
			else
				break;
		}
		
		if ( numOfPartColumns != 0 && numOfPartColumns != partCols.size())
		{
			throw new WindowingException(
					sprintf("For Input %s:n all partition columns must be in order clause or none should be specified", 
							inputDesc) 
					);
		}
		
		ArrayList<OrderColumnDef> combinedOrderCols = new ArrayList<OrderColumnDef>();
		if ( numOfPartColumns == 0)
		{
			for(ColumnDef cDef : partCols)
			{
				OrderColumnDef ocDef = new OrderColumnDef(cDef);
				combinedOrderCols.add(ocDef);
			}
			combinedOrderCols.addAll(orderCols);
			oDef.setColumns(combinedOrderCols);
		}
		
		return oDef;
	}
	
	static OrderColumnDef translateOrderColumn(QueryDef qDef, InputInfo iInfo, OrderColumnSpec oSpec) throws WindowingException
	{
		OrderColumnDef ocDef = new OrderColumnDef(oSpec);
		translateColumn(qDef, ocDef, iInfo, oSpec);
		TranslateUtils.validateComparable(ocDef.getOI(), sprintf("Partition Column %s is not comparable", oSpec));
		return ocDef;
	}


	static ColumnDef translatePartitionColumn(QueryDef qDef, InputInfo iInfo, ColumnSpec cSpec) throws WindowingException
	{
		ColumnDef cDef = new ColumnDef(cSpec);
		translateColumn(qDef, cDef, iInfo,  cSpec);
		TranslateUtils.validateComparable(cDef.getOI(), sprintf("Partition Column %s is not comparable", cSpec));
		return cDef;
	}
	
	static void  translateColumn(QueryDef qDef, ColumnDef cDef, InputInfo iInfo, ColumnSpec cSpec) throws WindowingException
	{
		String colTabName = cSpec.getTableName();
		if (  colTabName != null && !colTabName.equals(iInfo.getAlias()))
		{
			throw new WindowingException(sprintf("Unknown Table Reference in column", cSpec));
		}
		
		ASTNode expr = TranslateUtils.buildASTNode(cSpec.getColumnName());
		ExprNodeDesc exprNode = TranslateUtils.buildExprNode(expr, iInfo.getTypeCheckCtx());
		ExprNodeEvaluator exprEval = WindowingExprNodeEvaluatorFactory.get(qDef.getTranslationInfo(), exprNode);
		ObjectInspector oi = TranslateUtils.initExprNodeEvaluator(exprEval, iInfo);
		
		cDef.setExpression(expr);
		cDef.setExprNode(exprNode);
		cDef.setExprEvaluator(exprEval);
		cDef.setOI(oi);
	}
		
	
	static WindowFrameDef translateWindowFrame(QueryDef qDef, WindowFrameSpec wfSpec, InputInfo iInfo) throws WindowingException
	{
		if ( wfSpec == null )
		{
			return null;
		}
		
		BoundarySpec s = wfSpec.getStart();
		BoundarySpec e = wfSpec.getEnd();
		WindowFrameDef wfDef = new WindowFrameDef(wfSpec);
		
		wfDef.setStart(translateBoundary(qDef, s, iInfo));
		wfDef.setEnd(translateBoundary(qDef, e, iInfo));
		
		int cmp = s.compareTo(e);
		if ( cmp > 0 ) 
		{
			throw new WindowingException(sprintf("Window range invalid, start boundary is greater than end boundary: %s", wfSpec));
		}
		return wfDef;
	}
	
	static BoundaryDef translateBoundary(QueryDef qDef, BoundarySpec bndSpec, InputInfo iInfo) throws WindowingException
	{
		if ( bndSpec instanceof ValueBoundarySpec )
		{
			ValueBoundarySpec vBndSpec = (ValueBoundarySpec) bndSpec;
			ValueBoundaryDef vbDef = new ValueBoundaryDef(vBndSpec);
			ExprNodeDesc exprNode = TranslateUtils.buildExprNode(vBndSpec.getExpression(), iInfo.getTypeCheckCtx());
			vbDef.setExprNode(exprNode);
			ExprNodeEvaluator exprEval = WindowingExprNodeEvaluatorFactory.get(qDef.getTranslationInfo(), exprNode);
			ObjectInspector OI = TranslateUtils.initExprNodeEvaluator(exprEval, iInfo);
			TranslateUtils.validateValueBoundaryExprType(OI);
			vbDef.setExprEvaluator(exprEval);
			vbDef.setOI(OI);
			return vbDef;
		}
		else if ( bndSpec instanceof RangeBoundarySpec)
		{
			RangeBoundarySpec rBndSpec = (RangeBoundarySpec) bndSpec;
			RangeBoundaryDef rbDef = new RangeBoundaryDef(rBndSpec);
			return rbDef;
		}
		else if ( bndSpec instanceof CurrentRowSpec)
		{
			CurrentRowSpec cBndSpec = (CurrentRowSpec) bndSpec;
			CurrentRowDef cbDef = new CurrentRowDef(cBndSpec);
			return cbDef;
		}
		throw new WindowingException("Unknown Boundary: " + bndSpec);
	}
	
	static String getInputDescription(QueryDef qDef, TableFuncDef tDef)
	{
		if ( qDef.getInput() == tDef && 
				(tDef.getName().equals(FunctionRegistry.NOOP_TABLE_FUNCTION) ||
				 tDef.getName().equals(FunctionRegistry.WINDOWING_TABLE_FUNCTION))
			)
		{
			return "Query";
		}
		return sprintf("TableFunction %s[alias:%s]", tDef.getName(), tDef.getAlias());
		
	}
	

}
