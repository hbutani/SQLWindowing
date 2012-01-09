package com.sap.hadoop.windowing.cli

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;

import com.sap.hadoop.windowing.WindowingException;

class WindowingClient
{
	String windowingJar;
	HiveConf hConf;
	Process server
	int serverPort
	SocketChannel socketChannel;
	ByteBuffer intb
	Response resp
	String serverError
	
	WindowingClient(HiveConf hConf, String windowingJar) throws WindowingException
	{
		this.hConf = hConf
		this.windowingJar = windowingJar
		intb = ByteBuffer.allocate(4)
		resp = new Response();
		spawnServer();
		connect();
		startServerStreamThreads();
	}
	
	void executeQuery(String query) throws WindowingException
	{
		validateServer();
		try
		{
			CommUtils.writeString(socketChannel, intb, query);
			resp.read(socketChannel, intb); 
		}
		catch(Exception e)
		{
			killServer();
			throw new WindowingException(e);
		}
		
		switch(resp.type)
		{
			case ResponseType.OK: return;
			case ResponseType.ERROR: throw new WindowingException(resp.errMsg);
			case ResponseType.QUERY:
				// todo:
				// execute hive Query
				// send Resp.OK
				// read Resp
				break;
			default: throw new WindowingException(sprintf("Unknown ResponseType %s", resp));
		}
	}
	
	private void spawnServer() throws WindowingException
	{
		try
		{
			ProcessBuilder pb = new ProcessBuilder(
				"java", "-cp", windowingJar, 
				//"-Xdebug", "-Xrunjdwp:transport=dt_socket,address=9015,server=y,suspend=y",
				"com.sap.hadoop.windowing.cli.WindowingServer",
				"-t", "1");
			Map<String, String> env = pb.environment();
			ClientUtils.addJobConfToEnvironment(hConf, env);
			server = pb.start(); 
		}
		catch(Exception e)
		{
			throw new WindowingException(e);
		}
	}
	
	private int readPort() throws IOException
	{
		BufferedReader rdr = new BufferedReader(new InputStreamReader(server.getInputStream()));
		String s = rdr.readLine();
		//s = rdr.readLine()
		return Integer.parseInt(s);
	}

	private void connect() throws WindowingException
	{
		try
		{
			int port = readPort();
			InetSocketAddress addr = new InetSocketAddress(port);
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(true);
			socketChannel.connect(addr);
		}
		catch(Throwable ie)
		{
			killServer();
			throw new WindowingException(ie);
		}
	}
	
	private void startServerStreamThreads()
	{
		ServerStreamThread t = new ServerStreamThread(this, server.getErrorStream());
		t.start();
		ServerOutStreamThread t1 = new ServerOutStreamThread(this, server.getInputStream());
		t1.start();
	}
	
	void killServer()
	{
		if ( server != null )
		{
			server.destroy();
			server = null;
			if ( socketChannel != null ) socketChannel.close();
		}
	}
	
	private validateServer() throws WindowingException
	{
		if ( serverError != null )
		{
			killServer();
			throw new WindowingException("Server Error:\n" + serverError);
		}
	}
	
}

class ClientUtils
{
	static void addJobConfToEnvironment(Configuration conf, Map<String, String> env) {
	  Iterator<Map.Entry<String, String>> it = conf.iterator();
	  
	  while (it.hasNext()) {
		Map.Entry<String, String> en = it.next();
		String name = en.getKey();
		String value = conf.get(name); // does variable expansion
		//name = safeEnvVarName(name);
		env.put(name, value);
	  }
	}
  
  /**
   * addJobConfToEnvironment is shamelessly copied from hadoop streaming.
   */
  static String safeEnvVarName(String var) {
    StringBuilder safe = new StringBuilder();
    int len = var.length();
    for (int i = 0; i < len; i++) {
      char c = var.charAt(i);
      char s;
      if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')
          || (c >= 'a' && c <= 'z')) {
        s = c;
      } else {
        s = '_';
      }
      safe.append(s);
    }
    return safe.toString();
  }
}

class ServerStreamThread extends Thread
{
	WindowingClient client;
	InputStream inputStream;
	StringBuilder errorString = new StringBuilder();
	
	ServerStreamThread(WindowingClient client, InputStream inputStream)
	{
		this.client = client;
		this.inputStream = inputStream;
	}
  
  
	public void run()
	{
		try
		{
			BufferedReader rdr = new BufferedReader(new InputStreamReader(inputStream));
			String line = null
			while( (line = rdr.readLine()) != null)
			{
				errorString.append(line);
			}
			client.serverError = errorString.toString();
		}
		catch(IOException ioe)
		{
		}
	}
}

class ServerOutStreamThread extends Thread
{
	WindowingClient client;
	InputStream inputStream;
	
	ServerOutStreamThread(WindowingClient client, InputStream inputStream)
	{
		this.client = client;
		this.inputStream = inputStream;
	}
  
	public void run()
	{
		try
		{
			BufferedReader rdr = new BufferedReader(new InputStreamReader(inputStream));
			String line = null
			while( (line = rdr.readLine()) != null)
			{
				println line
			}
		}
		catch(IOException ioe)
		{
		}
	}
}