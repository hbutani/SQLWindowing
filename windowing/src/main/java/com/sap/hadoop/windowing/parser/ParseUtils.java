package com.sap.hadoop.windowing.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.apache.hadoop.hive.ql.parse.ASTNode;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.query2.specification.SelectSpec;
import com.sap.hadoop.windowing.query2.translate.TranslateUtils;

public class ParseUtils
{
	public static QuerySpec parse(String query) throws WindowingException
	{
		Windowing2Lexer lexer;
		CommonTokenStream tokens;
		Windowing2Parser parser = null;
		CommonTree t;
		CommonTreeNodeStream nodes;
		QSpecBuilder2 qSpecBldr = null;
		String err;
		
		try
		{
			lexer = new Windowing2Lexer(new ANTLRStringStream(query));
			tokens = new CommonTokenStream(lexer);
			parser = new Windowing2Parser(tokens);
			parser.setTreeAdaptor(TranslateUtils.adaptor);
			t = (CommonTree)  parser.query().getTree();
			
			err = parser.getWindowingParseErrors();
			if ( err != null )
			{
				throw new WindowingException(err);
			}
		}
		catch(WindowingException we)
		{
			throw we;
		}
		catch(Throwable te)
		{
			err = parser.getWindowingParseErrors();
			if ( err != null )
			{
				throw new WindowingException(err);
			}
			throw new WindowingException("Parse Error:" + te.toString(), te);
		}
		
		TranslateUtils.unescapeStringLiterals((ASTNode) t);
		
		try
		{
			
			nodes = new CommonTreeNodeStream(t);
			nodes.setTokenStream(tokens);
			qSpecBldr = new QSpecBuilder2(nodes);
			qSpecBldr.query();
	
			err = qSpecBldr.getWindowingParseErrors();
			if ( err != null )
			{
				throw new WindowingException(err);
			}
			
			return qSpecBldr.getQuerySpec();
		}
		catch(WindowingException we)
		{
			throw we;
		}
		catch(Throwable te)
		{
			err = qSpecBldr.getWindowingParseErrors();
			if ( err != null )
			{
				throw new WindowingException(err);
			}
			throw new WindowingException("Parse Error:" + te.toString(), te);
		}
	}
	
	public static SelectSpec parseSelect(String selectExprStr) throws WindowingException
	{
		Windowing2Lexer lexer;
		CommonTokenStream tokens;
		Windowing2Parser parser = null;
		CommonTree t;
		CommonTreeNodeStream nodes;
		QSpecBuilder2 qSpecBldr = null;
		String err;
		
		try
		{
			lexer = new Windowing2Lexer(new ANTLRStringStream(selectExprStr));
			tokens = new CommonTokenStream(lexer);
			parser = new Windowing2Parser(tokens);
			parser.setTreeAdaptor(TranslateUtils.adaptor);
			t = (CommonTree)  parser.select().getTree();
			
			err = parser.getWindowingParseErrors();
			if ( err != null )
			{
				throw new WindowingException(err);
			}
		}
		catch(WindowingException we)
		{
			throw we;
		}
		catch(Throwable te)
		{
			err = parser.getWindowingParseErrors();
			if ( err != null )
			{
				throw new WindowingException(err);
			}
			throw new WindowingException("Parse Error:" + te.toString(), te);
		}
		
		TranslateUtils.unescapeStringLiterals((ASTNode) t);
		
		try
		{
			
			nodes = new CommonTreeNodeStream(t);
			nodes.setTokenStream(tokens);
			qSpecBldr = new QSpecBuilder2(nodes);
			SelectSpec selectSpec = qSpecBldr.select();
	
			err = qSpecBldr.getWindowingParseErrors();
			if ( err != null )
			{
				throw new WindowingException(err);
			}
			return selectSpec;
			
		}
		catch(WindowingException we)
		{
			throw we;
		}
		catch(Throwable te)
		{
			err = qSpecBldr.getWindowingParseErrors();
			if ( err != null )
			{
				throw new WindowingException(err);
			}
			throw new WindowingException("Parse Error:" + te.toString(), te);
		}
	}
}
