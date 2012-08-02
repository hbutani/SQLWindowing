package com.sap.hadoop.windowing.parser;

import static org.junit.Assert.*;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.Token;

import org.apache.hadoop.hive.ql.parse.ASTNode;

import org.junit.Test;

import com.sap.hadoop.query2.specification.QuerySpec;
import com.sap.hadoop.windowing.BaseTest;
import com.sap.hadoop.windowing.WindowingException;


public class QSpecBldr2Test extends BaseTest
{
	
	@Test
	void test1()
	{
		QuerySpec qSpec = build("""
from part
		partition by p_mfgr
		order by p_mfgr, p_name
select p_mfgr,p_name, p_size,
		rank() as r,
		denserank() as dr,
		cumedist() as cud,
		percentrank() as pr,
		ntile(3) as nt,
		count(p_size) as c,
		count(p_size, 'all') as ca,
		count(p_size, 'distinct') as cd,
		avg(p_size) as avg, stddev(p_size) as st,
		first_value(p_size) as fv, last_value(p_size) as lv,
		first_value(p_size, 'true') over rows between 2 preceding and 2 following as fv2
		into path='/tmp/wout2'
		serde 'org.apache.hadoop.hive.serde2.lazy.LazySimpleSerDe'
		with serdeproperties('field.delim'=',')
		format 'org.apache.hadoop.mapred.TextOutputFormat'""")
		
		println qSpec
	}

	public static QuerySpec build(String query) throws WindowingException
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
			lexer = new Windowing2Lexer(new ANTLRStringStream(query));
			tokens = new CommonTokenStream(lexer);
			parser = new Windowing2Parser(tokens);
			parser.setTreeAdaptor(ParserTest2.adaptor);
			t = parser.query().getTree()
			
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
			qSpecBldr.query()
	
			err = qSpecBldr.getWindowingParseErrors()
			if ( err != null )
			{
				throw new WindowingException(err)
			}
			
			return qSpecBldr.qSpec
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
