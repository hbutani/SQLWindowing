package com.sap.hadoop.windowing.runtime2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.service.HiveInterface;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;


import com.sap.hadoop.windowing.Constants;
import com.sap.hadoop.windowing.WindowingException;
import org.apache.hadoop.hive.service.HiveClient;
import static com.sap.hadoop.Utils.sprintf;

public class ThriftBasedHiveQueryExecutor implements HiveQueryExecutor
{
	HiveInterface client;
	
	ThriftBasedHiveQueryExecutor(Configuration conf) throws WindowingException
	{
		String host = conf.get(Constants.HIVE_THRIFTSERVER, "localhost");
		int port = conf.getInt(Constants.HIVE_THRIFTSERVER_PORT, 10000);
		
		try
		{
			TTransport transport = new TSocket(host, port);
			TProtocol protocol = new TBinaryProtocol(transport);
			client = new HiveClient(protocol);
			transport.open();
		}
		catch(Throwable t)
		{
			throw new WindowingException("Failed to connect to Hive Thrift Server", t);
		}
	}
	
	public void executeHiveQuery(String hQry) throws WindowingException
	{
		try
		{
			client.execute(hQry);
		}
		catch(Throwable t)
		{
			throw new WindowingException(sprintf("Failed to execute Hive Query %s", hQry), t);
		}
	}
	
	public String createTableAsQuery(String hQry) throws WindowingException
	{
		String tableName = sprintf("WindowingTempTable_%d", System.currentTimeMillis());
		hQry = sprintf("Create table %s as %s", tableName, hQry);
		executeHiveQuery(hQry);
		return tableName;
	}
	
	public void dropTable(String tableName) throws WindowingException
	{
		String hQry = sprintf("drop table %s", tableName);
		executeHiveQuery(hQry);
	}
}
