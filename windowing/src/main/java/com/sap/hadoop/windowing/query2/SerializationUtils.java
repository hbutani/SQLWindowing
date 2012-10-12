package com.sap.hadoop.windowing.query2;

import java.beans.BeanInfo;
import java.beans.Encoder;
import java.beans.ExceptionListener;
import java.beans.Expression;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PersistenceDelegate;
import java.beans.PropertyDescriptor;
import java.beans.Statement;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.BaseTree;
import org.antlr.runtime.tree.CommonTree;
import org.apache.hadoop.hive.ql.exec.Utilities.EnumDelegate;
import org.apache.hadoop.hive.ql.parse.ASTNode;
import org.apache.hadoop.hive.serde2.typeinfo.PrimitiveTypeInfo;
import org.apache.hadoop.hive.serde2.typeinfo.TypeInfoFactory;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.query2.definition.QueryDef;
import com.sap.hadoop.windowing.query2.specification.WindowFrameSpec.Direction;

public class SerializationUtils
{
	public static void serialize(OutputStream out, Object o)
	{
		XMLEncoder e = new XMLEncoder(out);
		e.setExceptionListener(new EL());
		SerializationUtils.addPersistenceDelegates(e);
		e.writeObject(o);
		e.close();
	}

	public static Object deserialize(InputStream in1)
	{
		XMLDecoder d = null;
		try
		{
			d = new XMLDecoder(in1, null, null);
			return d.readObject();
		}
		finally
		{
			if (null != d)
			{
				d.close();
			}
		}
	}

	public static void addPersistenceDelegates(XMLEncoder e)
	{
		addAntlrPersistenceDelegates(e);
		addHivePersistenceDelegates(e);
		addEnumDelegates(e);
	}

	public static void addEnumDelegates(XMLEncoder e)
	{
		e.setPersistenceDelegate(Direction.class, new EnumDelegate());
	}

	public static void addAntlrPersistenceDelegates(XMLEncoder e)
	{
		e.setPersistenceDelegate(ASTNode.class, new PersistenceDelegate()
		{

			protected Expression instantiate(Object oldInstance, Encoder out)
			{
				return new Expression(oldInstance, oldInstance.getClass(),
						"new", new Object[]
						{ ((ASTNode) oldInstance).getToken() });
			}
		});
		e.setPersistenceDelegate(CommonTree.class, new PersistenceDelegate()
		{
			protected Expression instantiate(Object oldInstance, Encoder out)
			{
				return new Expression(oldInstance, oldInstance.getClass(),
						"new", new Object[]
						{ ((CommonTree) oldInstance).getToken() });
			}
		});
		e.setPersistenceDelegate(BaseTree.class, new PersistenceDelegate()
		{
			protected Expression instantiate(Object oldInstance, Encoder out)
			{
				return new Expression(oldInstance, oldInstance.getClass(),
						"new", new Object[]
						{});
			}

			@SuppressWarnings("rawtypes")
			protected void initialize(Class type, Object oldInstance,
					Object newInstance, Encoder out)
			{
				super.initialize(type, oldInstance, newInstance, out);

				BaseTree t = (BaseTree) oldInstance;

				for (int i = 0; i < t.getChildCount(); i++)
				{
					out.writeStatement(new Statement(oldInstance, "addChild",
							new Object[]
							{ t.getChild(i) }));
				}
			}
		});
		e.setPersistenceDelegate(CommonToken.class, new PersistenceDelegate()
		{
			protected Expression instantiate(Object oldInstance, Encoder out)
			{
				return new Expression(oldInstance, oldInstance.getClass(),
						"new", new Object[]
						{ ((CommonToken) oldInstance).getType(),
								((CommonToken) oldInstance).getText() });
			}
		});
	}

	public static void addHivePersistenceDelegates(XMLEncoder e)
	{
		e.setPersistenceDelegate(PrimitiveTypeInfo.class,
				new PersistenceDelegate()
				{
					protected Expression instantiate(Object oldInstance,
							Encoder out)
					{
						return new Expression(oldInstance,
								TypeInfoFactory.class, "getPrimitiveTypeInfo",
								new Object[]
								{ ((PrimitiveTypeInfo) oldInstance)
										.getTypeName() });
					}
				});
	}

	static class EL implements ExceptionListener
	{
		public void exceptionThrown(Exception e)
		{
			throw new RuntimeException("Cannot serialize the query plan", e);
		}
	}

	public static String serializeQueryDef(QueryDef qdef)
	{
		String queryDef = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		SerializationUtils.serialize(out, qdef);
		queryDef = out.toString();
		return queryDef;
	}

	public static void makeTransient(Class<?> beanClass, String pdName)
	{
		BeanInfo info;
		try
		{
			info = Introspector.getBeanInfo(beanClass);
			PropertyDescriptor[] propertyDescriptors = info
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; ++i)
			{
				PropertyDescriptor pd = propertyDescriptors[i];
				if (pd.getName().equals(pdName))
				{
					pd.setValue("transient", Boolean.TRUE);
				}
			}
		}
		catch (IntrospectionException ie)
		{
			throw new RuntimeException(ie);
		}
	}

}
