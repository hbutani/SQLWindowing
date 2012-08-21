package com.sap.hadoop.windowing.runtime.mr

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.plan.ExprNodeDesc;
import org.apache.hadoop.hive.ql.plan.SelectDesc;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluator;
import org.apache.hadoop.hive.ql.exec.ExprNodeEvaluatorFactory;
import org.apache.hadoop.hive.ql.exec.FunctionRegistry;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.ql.parse.RowResolver;
import org.apache.hadoop.hive.ql.parse.TypeCheckCtx;
import org.apache.hadoop.hive.ql.parse.UnparseTranslator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDAFEvaluator.AggregationBuffer;
import org.apache.hadoop.hive.serde2.Deserializer;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.io.Writable;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sap.hadoop.HiveUtils;
import com.sap.hadoop.windowing.MRBaseTest;
import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.io.IOUtils;
import com.sap.hadoop.windowing.io.WindowingInput;
import com.sap.hadoop.windowing.parser.ParserTest2;
import com.sap.hadoop.windowing.parser.QSpecBuilder2;
import com.sap.hadoop.windowing.parser.Windowing2Lexer;
import com.sap.hadoop.windowing.parser.Windowing2Parser;
import com.sap.hadoop.windowing.query2.WindowingTypeCheckProcFactory;
import com.sap.hadoop.windowing.query2.specification.WindowFunctionSpec;

class HiveAggTest  extends MRBaseTest
{
	static RowResolver rr;
	static WindowingInput wIn;
	static Deserializer deS;
	static ObjectInspector inoI;
	static Writable w;
	static TypeCheckCtx typeChkCtx;
	
	@BeforeClass
	public static void setupClass()
	{
		MRBaseTest.setupClass();
		wIn = IOUtils.createTableWindowingInput(null, "lineitem", wshell.cfg)
		deS = wIn.getDeserializer()
		inoI = deS.getObjectInspector()
		w = wIn.createRow();
		rr = HiveUtils.getRowResolver(null, "lineitem", "lineitem", wshell.cfg)
		typeChkCtx = new TypeCheckCtx(rr);
		typeChkCtx.setUnparseTranslator(new UnparseTranslator());
	}
	
	@Before
	public void setup()
	{
		wIn = IOUtils.createTableWindowingInput(null, "lineitem", wshell.cfg)
	}
	
	@Test
	void test1()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			build("sum(L_EXTENDEDPRICE)"),
			build("min(L_EXTENDEDPRICE)"),
			build("max(L_EXTENDEDPRICE)"),
			build("avg(L_EXTENDEDPRICE)"),
		]
		aggregate("test1", exprs)
	}
	
	@Test
	void testCount()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			build("count(*)"),
			build("count(distinct l_extendedprice)"),
			build("count(distinct l_extendedprice, l_shipdate)"),
			build("count(l_shipdate)")
		]
		aggregate("testcount", exprs)
	}
	
	@Test
	void testStat()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			build("stddev(l_extendedprice)"),
			build("variance(l_extendedprice)"),
			build("corr(l_discount, l_extendedprice)"),
			build("covar_pop(l_discount, l_extendedprice)")
		]
		aggregate("testStat", exprs)
	}
	
	@Test
	void testDistribution()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			build("histogram_numeric(l_extendedprice, 5)"),
			build("percentile(l_linenumber, 0.5)")
		]
		aggregate("testDistribution", exprs)
	}
	
	@Test
	void testRank()
	{
		ArrayList<WindowFunctionSpec> exprs = [
			build("rownumber()")
		]
		aggregate("testDistribution", exprs)
	}

	public void aggregate(String testName, ArrayList<WindowFunctionSpec> funcSpecs)
	{
		println "$testName:\n"
		
		ArrayList<String> aliases = []
		0..<funcSpecs.size().each { i ->
			aliases << "c${i}".toString()
		}
		AggDesc aggDesc = new AggDesc(funcSpecs : funcSpecs, columnNames : aliases)
		AggOp agg = new AggOp()
		agg.initialize(aggDesc, inoI)
				
		agg.startAggregation()
		while( wIn.next(w) != -1)
		{
			Object r = deS.deserialize(w)
			agg.process(r)
		}
		agg.finishAggregation()
		println agg.output
	}

	public static WindowFunctionSpec build(String expr) throws WindowingException
	{
		Windowing2Lexer lexer;
		CommonTokenStream tokens;
		Windowing2Parser parser;
		CommonTree t;
		CommonTreeNodeStream nodes;
		QSpecBuilder2 qSpecBldr;
		String err;
		
		try
		{
			lexer = new Windowing2Lexer(new ANTLRStringStream(expr));
			tokens = new CommonTokenStream(lexer);
			parser = new Windowing2Parser(tokens);
			parser.setTreeAdaptor(ParserTest2.adaptor);
			t = parser.window_function().getTree()
			
			err = parser.getWindowingParseErrors()
			if ( err != null )
			{
				throw new WindowingException(err)
			}
		}
		catch(Throwable te)
		{
			err = parser.getWindowingParseErrors()
			if ( err != null )
			{
				throw new WindowingException(err)
			}
			throw new WindowingException("Parse Error:" + te.toString(), te)
		}
		
		try
		{
			
			nodes = new CommonTreeNodeStream(t);
			nodes.setTokenStream(tokens)
			qSpecBldr = new QSpecBuilder2(nodes);
			WindowFunctionSpec node = qSpecBldr.window_function()
	
			err = qSpecBldr.getWindowingParseErrors()
			if ( err != null )
			{
				throw new WindowingException(err)
			}
			
			return node
		}
		catch(Throwable te)
		{
			err = qSpecBldr.getWindowingParseErrors()
			if ( err != null )
			{
				throw new WindowingException(err)
			}
			throw new WindowingException("Parse Error:" + te.toString(), te)
		}
	}

}

class AggDesc
{
	ArrayList<WindowFunctionSpec> funcSpecs;
	ArrayList<String> columnNames;
}

class AggOp
{
	ObjectInspector inOI
	protected transient AggFunc[] funcs;
	transient Object[] output;
	ObjectInspector outOI
	
	protected void initialize(AggDesc desc, ObjectInspector inOI) throws HiveException
	{
		this.inOI = inOI
		funcs = new AggFunc[desc.funcSpecs.size()];
		
		for (int i = 0; i < desc.funcSpecs.size(); i++) 
		{
		  assert (desc.funcSpecs.get(i) != null);
		  funcs[i] = new AggFunc(funcSpec : desc.funcSpecs[i] )
		  funcs[i].setupFunction()
		  funcs[i].setupArgExprNodes()
		  funcs[i].setupEvaluator()
		  funcs[i].setupArgExprEvaluators();
		  funcs[i].setupFunctionArgOutput();
		  funcs[i].initEvaluators(inOI)
		}
	
		output = new Object[funcs.length];
		outOI = initEvaluatorsAndReturnStruct(funcs, desc.columnNames, inOI);
	}
	
	public void startAggregation() throws HiveException
	{
		for (int i = 0; i < funcs.length; i++) 
		{
			funcs[i].startAgg()
		}
	}
	
	public void process(Object row) throws HiveException
	{
		for (int i = 0; i < funcs.length; i++) 
		{
			funcs[i].process(row);
		}
	}
	
	public void finishAggregation() throws HiveException
	{
		for (int i = 0; i < funcs.length; i++)
		{
			output[i] = funcs[i].finishAgg()
		}
	}
	
	protected static StructObjectInspector initEvaluatorsAndReturnStruct(AggFunc[] funcs, List<String> outputColName, ObjectInspector rowInspector) throws HiveException
	{
		ObjectInspector[] fieldObjectInspectors = initFuncEvaluators(funcs, rowInspector);
		return ObjectInspectorFactory.getStandardStructObjectInspector(outputColName, Arrays.asList(fieldObjectInspectors));
	}
		
	protected static ObjectInspector[] initFuncEvaluators(AggFunc[] funcs, ObjectInspector  OI) throws HiveException
	{
		ObjectInspector[] funcOIs = new ObjectInspector[funcs.length];
		int i = 0;
		for(AggFunc f : funcs)
		{
			f.initEvaluators(OI)
			funcOIs[i++] = f.OI
		}
		return funcOIs
	}
}


class AggFunc
{
	String name;
	boolean isDistinct;
	boolean isAllColumns;
	GenericUDAFEvaluator funcEvaluator;
	WindowFunctionSpec funcSpec;
	
	ExprNodeDesc[] funcArgNodes;
	ExprNodeEvaluator[] funcArgEvaluators;
	Object[] funcArgVals;
	
	ObjectInspector[] funcArgOIs;
	ObjectInspector OI;
	
	AggregationBuffer aggBuffer;
	
	void setupFunction()
	{
		name = funcSpec.name
		isDistinct = funcSpec.isDistinct
		isAllColumns = funcSpec.isStar
	}
	
	void setupArgExprNodes()
	{
		// Convert children to aggParameters
		ArrayList<ExprNodeDesc> aggParameters = new ArrayList<ExprNodeDesc>();
		HashMap<Node, Object> map;
		for (int i = 0; i < funcSpec.getArgs().size(); i++) 
		{
		  ASTNode paraExpr = (ASTNode) funcSpec.args[i];
		  map = WindowingTypeCheckProcFactory.genExprNode(paraExpr, HiveAggTest.typeChkCtx)
		  aggParameters.add(map.get(paraExpr))
		}
		funcArgNodes = aggParameters.toArray(new ExprNodeDesc[aggParameters.size()])
	}
	
	void setupEvaluator() throws WindowingException
	{
		ArrayList<ObjectInspector> originalParameterTypeInfos = 	getWritableObjectInspector(funcArgNodes);
		funcEvaluator = FunctionRegistry.getGenericUDAFEvaluator(name, originalParameterTypeInfos, isDistinct, isAllColumns);
		if (null == funcEvaluator) {
			String reason = "Looking for UDAF Evaluator\"" + name 	+ "\" with parameters " + originalParameterTypeInfos;
			throw new WindowingException(reason);
		}
	}
	
	void setupArgExprEvaluators()
	{
		funcArgEvaluators = new ExprNodeEvaluator[funcArgNodes.length];
		for(int i=0; i < funcArgNodes.length; i++)
		{
			funcArgEvaluators[i] = ExprNodeEvaluatorFactory.get(funcArgNodes[i]);
		}
	}
	
	void setupFunctionArgOutput()
	{
		funcArgVals = new Object[funcArgNodes.length];
	}
	
	void initEvaluators(ObjectInspector inOI) throws HiveException
	{
		if (funcArgNodes != null )
		{
			funcArgOIs = new ObjectInspector[funcArgNodes.length];
			int i = 0;
			for(ExprNodeEvaluator funcArgEval : funcArgEvaluators)
			{
				funcArgOIs[i++] = funcArgEval.initialize(inOI);
			}
		}
		
		OI = funcEvaluator.init(GenericUDAFEvaluator.Mode.COMPLETE, funcArgOIs)
	}
	
	void startAgg()
	{
		aggBuffer = funcEvaluator.getNewAggregationBuffer()
	}
	
	void process(Object row) throws HiveException
	{
		for(int i=0; i < funcArgEvaluators.length; i++) processArg(i, row);
		funcEvaluator.aggregate(aggBuffer, funcArgVals)
	}
	
	Object finishAgg()
	{
		return funcEvaluator.evaluate(aggBuffer);
	}
	
	private void processArg(int i, Object row)
	{
		try
		{
			funcArgVals[i] = funcArgEvaluators[i].evaluate(row);
		}
		catch (HiveException e) 
		{
			throw e;
		}
		catch (RuntimeException e) 
		{
			throw new HiveException("Error evaluating " 	+ funcArgNodes[i].getExprString(), e);
		}
	}
	
	static ArrayList<ObjectInspector> getWritableObjectInspector(ExprNodeDesc[] exprNodes)
	{
		ArrayList<ObjectInspector> result = new ArrayList<ObjectInspector>();
		for (ExprNodeDesc expr : exprNodes)
		{
			result.add(expr.getWritableObjectInspector());
		}
		return result;
	}
	
}
