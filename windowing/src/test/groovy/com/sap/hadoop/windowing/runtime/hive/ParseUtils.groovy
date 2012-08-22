package com.sap.hadoop.windowing.runtime.hive

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.apache.hadoop.hive.ql.parse.ASTNode;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.parser.ParserTest2;
import com.sap.hadoop.windowing.parser.QSpecBuilder2;
import com.sap.hadoop.windowing.parser.Windowing2Lexer;
import com.sap.hadoop.windowing.parser.Windowing2Parser;
import com.sap.hadoop.windowing.query2.specification.WindowFunctionSpec;

class ParseUtils
{
	public static ASTNode buildExpression(String expr) throws WindowingException
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
			t = parser.expression().getTree()
			
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
			ASTNode node = qSpecBldr.expression()
	
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
	
	public static WindowFunctionSpec buildWindowFunction(String expr) throws WindowingException
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
