package com.sap.hadoop.windowing.query2.translate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;
import org.antlr.runtime.tree.TreeWizard;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluatorFactory;
import org.apache.hadoop.hive.ql.lib.Node;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.apache.hadoop.hive.ql.parse.TypeCheckCtx;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.serde2.SerDe;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.lazybinary.LazyBinarySerDe;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector.Category;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector.PrimitiveCategory;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.typeinfo.StructTypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoUtils;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.parser.Windowing2Parser;
import com.sap.hadoop.windowing.query2.definition.ArgDef;
import com.sap.hadoop.windowing.query2.definition.ColumnDef;
import com.sap.hadoop.windowing.query2.definition.OrderColumnDef;
import com.sap.hadoop.windowing.query2.definition.OrderDef;
import com.sap.hadoop.windowing.query2.definition.PartitionDef;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.specification.ColumnSpec;
import com.sap.hadoop.windowing.query2.specification.OrderColumnSpec;
import com.sap.hadoop.windowing.query2.specification.QueryInputSpec;
import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.query2.specification.TableFuncSpec;
import com.sap.hadoop.windowing.query2.translate.QueryTranslationInfo.InputInfo;
import com.sap.hadoop.windowing.query2.translate.TableFunctionChainIterators.QueryInputSpecIterator;
import com.sap.hadoop.windowing.query2.translate.TableFunctionChainIterators.ReverseQueryInputSpecIterator;
import com.sap.hadoop.windowing.query2.translate.TableFunctionChainIterators.ReverseTableFunctionSpecIterator;
import com.sap.hadoop.windowing.query2.translate.TableFunctionChainIterators.TableFunctionSpecIterator;

import static com.sap.hadoop.Utils.sprintf;

public class TranslateUtils
{
	public static boolean hasWindowFunctions(QuerySpec qSpec)
	{
		if ( qSpec == null) return false;
		ArrayList<Boolean> isWFns = qSpec.getSelectList().getIsWindowFn();
		return isWFns.contains(true);
	}
	
	public static boolean hasTableFunctions(QuerySpec qSpec)
	{
		return new TableFunctionChainIterators.TableFunctionSpecIterator(qSpec).hasNext();
	}

	public static Iterator<QueryInputSpec> iterateInputSpecs(QuerySpec qSpec, boolean reverse)
	{
		return reverse ? new ReverseQueryInputSpecIterator(qSpec) : new QueryInputSpecIterator(qSpec);
	}
	
	public static Iterator<TableFuncSpec> iterateTableFuncSpecs(QuerySpec qSpec, boolean reverse)
	{
		return reverse ? new ReverseTableFunctionSpecIterator(qSpec) : new TableFunctionSpecIterator(qSpec);
	}
	
	public static ExprNodeDesc buildExprNode(ASTNode expr, TypeCheckCtx typeCheckCtx) throws WindowingException
	{
		try
		{
			HashMap<Node, Object> map = WindowingTypeCheckProcFactory.genExprNode(expr, typeCheckCtx);
			return (ExprNodeDesc) map.get(expr);
		}
		catch(SemanticException se)
		{
			throw new WindowingException(se);
		}
	}
	
	public static ObjectInspector initExprNodeEvaluator(ExprNodeEvaluator exprEval, InputInfo iInfo) throws WindowingException
	{
		try
		{
			return exprEval.initialize(iInfo.getOI());
		}
		catch(HiveException he)
		{
			throw new WindowingException(he);
		}
	}
	
	public static ArgDef buildArgDef(QueryDef qDef, InputInfo iInfo, ASTNode arg) throws WindowingException
	{
		ArgDef argDef = new ArgDef();
		
		ExprNodeDesc exprNode = TranslateUtils.buildExprNode(arg, iInfo.getTypeCheckCtx());
		ExprNodeEvaluator exprEval = ExprNodeEvaluatorFactory.get(exprNode);
		ObjectInspector oi = initExprNodeEvaluator(exprEval, iInfo);
		
		argDef.setExpression(arg);
		argDef.setExprNode(exprNode);
		argDef.setExprEvaluator(exprEval);
		argDef.setOI(oi);
		return argDef;
	}
	
	public static ArrayList<? extends Object>[] getTypeMap(StructObjectInspector oi)
	{
		StructTypeInfo t = (StructTypeInfo) TypeInfoUtils.getTypeInfoFromObjectInspector(oi);
		ArrayList<String> fnames = t.getAllStructFieldNames();
		ArrayList<TypeInfo> fields = t.getAllStructFieldTypeInfos();
		return new ArrayList<?>[] { fnames, fields };
	}
	
	@SuppressWarnings("unchecked")
	public static SerDe createLazyBinarySerDe(Configuration cfg, StructObjectInspector oi) throws WindowingException
	{
		ArrayList<? extends Object>[] tInfo = getTypeMap(oi);
		
		ArrayList<String> columnNames = (ArrayList<String>) tInfo[0];
		ArrayList<TypeInfo> fields = (ArrayList<TypeInfo>) tInfo[1];
		StringBuilder cNames = new StringBuilder();
		StringBuilder cTypes = new StringBuilder();
		
		for(int i=0; i < fields.size(); i++)
		{
			cNames.append(i > 0 ? "," : "");
			cTypes.append(i > 0 ? "," : "");
			cNames.append(columnNames.get(i));
			cTypes.append(fields.get(i).getTypeName());
		}
		
		
		try
		{
			SerDe serDe = new LazyBinarySerDe();
			Properties p = new Properties();
			p.setProperty(org.apache.hadoop.hive.serde.Constants.LIST_COLUMNS, cNames.toString());
			p.setProperty(org.apache.hadoop.hive.serde.Constants.LIST_COLUMN_TYPES, cTypes.toString());
			serDe.initialize(cfg, p);
			return serDe;
		}
		catch(SerDeException se)
		{
			throw new WindowingException(se);
		}
	}
	
	public static ASTNode buildASTNode(String colName)
	{
		TreeWizard tw = new TreeWizard(adaptor, Windowing2Parser.tokenNames);
		Object o = tw.create(sprintf("(TABLEORCOL Identifier[%s])", colName));
		return (ASTNode) o;
	}
	
	public static void validateComparable(ObjectInspector OI, String errMsg) throws WindowingException
	{
		if ( !ObjectInspectorUtils.compareSupported(OI))
		{
			throw new WindowingException(errMsg);
		}
	}
	
	/*
	 * - equal if there columnName & tableName match
	 * - a null tableName is interpreted as matching the other tableName
	 */
	public static boolean isEqual(ColumnSpec spec1, ColumnSpec spec2)
	{
		if ( spec1 == null && spec2 == null ) return false;
		if ( spec1 == null && spec2 != null ) return false;
		if ( spec1 != null && spec2 == null ) return false;
		
		if ( !spec1.getColumnName().equals(spec2.getColumnName()) ) return false;
		
		String t1 = spec1.getTableName();
		String t2 = spec2.getTableName();
		if ( t1 == null || t2 == null ) return true;
		
		return t1.equals(t2);
	}
	
	public static boolean isEqual(ColumnDef def1, ColumnDef def2)
	{
		if ( def1 == null && def2 == null ) return false;
		if ( def1 == null && def2 != null ) return false;
		if ( def1 != null && def2 == null ) return false;
		
		return isEqual(def1.getSpec(), def2.getSpec());
	}
	
	/*
	 * A Window Function's partition clause must exactly match that of the associated tableFn.
	 */
	public static boolean isCompatible(PartitionDef tFnPartDef, PartitionDef wFnPartDef)
	{
		if ( tFnPartDef == null && wFnPartDef == null ) return true;
		if ( tFnPartDef == null && wFnPartDef != null ) return false;
		if ( tFnPartDef != null && wFnPartDef == null ) return true;
		
		ArrayList<ColumnDef> cols1 = tFnPartDef.getColumns();
		ArrayList<ColumnDef> cols2 = wFnPartDef.getColumns();
		if ( cols1.size() != cols2.size()) return false;
		for(int i=0; i< cols1.size(); i++)
		{
			boolean e = isEqual(cols1.get(i), cols2.get(i));
			if (!e) return false;
		}
		return true;
	}
	
	public static boolean isEqual(OrderColumnSpec spec1, OrderColumnSpec spec2)
	{
		if ( spec1 == null && spec2 == null ) return false;
		if ( spec1 == null && spec2 != null ) return false;
		if ( spec1 != null && spec2 == null ) return false;
		
		if ( !spec1.getColumnName().equals(spec2.getColumnName()) ) return false;
		if ( !spec1.getOrder().equals(spec2.getOrder())) return false;
		
		String t1 = spec1.getTableName();
		String t2 = spec2.getTableName();
		if ( t1 == null || t2 == null ) return true;
		
		return t1.equals(t2);
	}
	
	public static boolean isEqual(OrderColumnDef def1, OrderColumnDef def2)
	{
		if ( def1 == null && def2 == null ) return false;
		if ( def1 == null && def2 != null ) return false;
		if ( def1 != null && def2 == null ) return false;
		
		return isEqual((OrderColumnSpec)def1.getSpec(), (OrderColumnSpec)def2.getSpec());
	}
	
	public static boolean isCompatible(OrderDef tFnPartDef, OrderDef wFnPartDef)
	{
		if ( tFnPartDef == null && wFnPartDef == null ) return true;
		if ( tFnPartDef == null && wFnPartDef != null ) return false;
		if ( tFnPartDef != null && wFnPartDef == null ) return true;
		
		ArrayList<OrderColumnDef> cols1 = tFnPartDef.getColumns();
		ArrayList<OrderColumnDef> cols2 = wFnPartDef.getColumns();
		if ( cols1.size() != cols2.size()) return false;
		for(int i=0; i< cols1.size(); i++)
		{
			boolean e = isEqual(cols1.get(i), cols2.get(i));
			if (!e) return false;
		}
		return true;
	}
	
	public static void validateValueBoundaryExprType(ObjectInspector OI) throws WindowingException
	{
		if ( !OI.getCategory().equals(Category.PRIMITIVE) )
		{
			throw new WindowingException("Value Boundary expression must be of primitve type");
		}
		
		PrimitiveObjectInspector pOI = (PrimitiveObjectInspector) OI;
		PrimitiveCategory pC = pOI.getPrimitiveCategory();
		
		switch(pC)
		{
		case BYTE:
		case DOUBLE:
		case FLOAT:
		case INT:
		case LONG:
		case SHORT:
		case TIMESTAMP:
			break;
		default:
			throw new WindowingException(sprintf("Primitve type %s not supported in Value Boundary expression", pC));
		}
		
	}
	
	/**
	* Copied from Hive ParserDriver.
	*/
   public static final TreeAdaptor adaptor = new CommonTreeAdaptor() {
	 /**
	  * Creates an ASTNode for the given token. The ASTNode is a wrapper around
	  * antlr's CommonTree class that implements the Node interface.
	  *
	  * @param payload
	  *          The token.
	  * @return Object (which is actually an ASTNode) for the token.
	  */
	 @Override
	 public Object create(Token payload) {
	   return new ASTNode(payload);
	 }
   };
}
