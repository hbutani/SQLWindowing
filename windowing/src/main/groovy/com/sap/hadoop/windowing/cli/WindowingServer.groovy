package com.sap.hadoop.windowing.cli

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;
import org.apache.hadoop.conf.Configuration;
import org.apache.log4j.Logger;

import com.sap.hadoop.windowing.WindowingException;
import com.sap.hadoop.windowing.WindowingHiveCliDriver;
import com.sap.hadoop.windowing.runtime.Mode;
import com.sap.hadoop.windowing.runtime.WindowingShell;
import com.sap.hadoop.windowing.runtime.mr.Job;

class WindowingServer
{
	ServerSocketChannel serverChannel;
	Selector selector;
	ExecutorService execSvc;
	Configuration conf;
	
	WindowingServer(int numThreads)
	{	
		conf = new Configuration();
		
		// apply values from environment
		for (Map.Entry<String, String> e : System.getenv().entrySet())
		{
			conf.set(e.key, e.value)
		}
		String wJar = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		conf.set(Job.WINDOWING_JAR_FILE, wJar);
		
		// turn off console logging.
		//WindowingHiveCliDriver.initHiveLog4j();
		Logger.getRootLogger().removeAllAppenders();

		/* setup serverChannel */
		serverChannel = ServerSocketChannel.open();
		ServerSocket serverSocket = serverChannel.socket();
		serverSocket.bind(null);
		serverChannel.configureBlocking(false);
		
		/* setup Selector */
		selector = Selector.open();
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		/* setup ExecService */
		execSvc = Executors.newFixedThreadPool(numThreads);
		
		// enable invoker to make connection.
		System.out.println(serverSocket.localPort);
		System.out.flush();
	}
	
	void start()
	{
		while(true)
		{
			int n = selector.select();
			
			if ( n == 0) continue;
			
			Iterator it = selector.selectedKeys().iterator();
			
			while(it.hasNext())
			{
				SelectionKey key = (SelectionKey) it.next();
				
				if ( key.isAcceptable() ) handleConnection(key);
				if ( key.isReadable() ) handleRead(key);
				
				// remove key from selected set, so readiness ops recomputed
				it.remove();
			}
		}
	}
	
	void handleConnection(SelectionKey key)
	{
		SocketChannel channel = serverChannel.accept();
		if ( channel != null)
		{
			SlaveConnection sConn = new SlaveConnection(conf);
			channel.configureBlocking(false);
			channel.register(selector, SelectionKey.OP_READ, sConn)
		}
	}
	
	void handleRead(final SelectionKey key)
	{
		key.interestOps(key.interestOps() & (~SelectionKey.OP_READ))
		final SlaveConnection conn = (SlaveConnection) key.attachment()
		execSvc.submit({
			conn.handleRequest(key);
		})
	}
	
	public static void main(String[] args) throws Exception
	{
		CommandLineParser parser = new PosixParser();
		Options opts = options();
		CommandLine cmdLine = parser.parse(opts, args);
		
		if ( cmdLine.hasOption('h'))
		{
			HelpFormatter hf = new HelpFormatter();
			hf.printHelp("WindowingServer", opts);
			System.exit(0);
		}
		
		int numThrds = 1
		if ( cmdLine.hasOption('t'))
		{
			numThrds = Integer.parseInt(cmdLine.getOptionValue('t'));
		}
		
		try
		{
			WindowingServer server = new WindowingServer(numThrds);
			server.start();
		}
		catch(Throwable t)
		{
			System.err.println(t.getMessage());
		}
	}

	
	static Options options()
	{
		Options options = new Options();
		options.addOption(OptionBuilder.withLongOpt("help").withDescription("help").hasArg(false).create('h'));
		options.addOption(OptionBuilder.withArgName("numThrds").withLongOpt("threads").withDescription("number threads").hasArg().create('t'));
		return options;
	}

}

enum SlaveConnectionState
{
	PROCESS_QUERY,
	PROCESS_RESPONSE;
}

class SlaveConnection
{
	WindowingShell wshell;
	SlaveConnectionState state;
	ByteBuffer szb;
	Response resp;
	
	SlaveConnection(Configuration conf)
	{
		state = SlaveConnectionState.PROCESS_QUERY
		szb = ByteBuffer.allocate(4)
		Mode wMode = Mode.MR
		wshell = new WindowingShell( conf, wMode.getTranslator(), wMode.getExecutor())
		resp = new Response();
	}
	
	void handleRequest(SelectionKey key)
	{
		SocketChannel socketChannel = key.channel();
		switch(state)
		{
			case SlaveConnectionState.PROCESS_QUERY:
				handleQuery(socketChannel);
				break;
			default:
				resp.type = ResponseType.ERROR;
				resp.errMsg = "Internal Error: Connection not in Query State"
		}
		resp.write(socketChannel, szb);
		key.interestOps (key.interestOps() | SelectionKey.OP_READ);
		key.selector().wakeup();
	}
	
	void handleQuery(SocketChannel socketChannel)
	{
		String qry = CommUtils.readString(socketChannel, szb)
		try
		{
			wshell.execute(qry); // todo: pass an Object to wshell that can be used to execute Hive Queries
			resp.type = ResponseType.OK;
		}
		catch(Throwable e)
		{
			resp.type = ResponseType.ERROR;
			resp.errMsg = e.getMessage();
		}
	}
	
}

enum ResponseType
{
	OK,
	QUERY,
	ERROR;
	
	static ResponseType fromInt(int i)
	{
		switch(i)
		{
			case 0: return OK;
			case 1: return QUERY;
			case 2: return ERROR;
			default: throw new RuntimeException(sprintf("Unknown ResponseType %d", i));
		}
	}
	
	static int toInt(ResponseType r)
	{
		switch(r)
		{
			case OK: return 0;
			case QUERY: return 1;
			case ERROR: return 2;
			default: throw new RuntimeException(sprintf("Unknown ResponseType %s", r));
		}
	}
}

class Response
{
	ResponseType type;
	String query;
	String errMsg;
	
	void read(SocketChannel socketChannel, ByteBuffer intb)
	{
		type = ResponseType.fromInt(CommUtils.readInt(socketChannel, intb));
		switch(type)
		{
			case ResponseType.OK: break;
			case ResponseType.QUERY: 
				query = CommUtils.readString(socketChannel, intb);
				break;
			case ResponseType.ERROR: 
				errMsg = CommUtils.readString(socketChannel, intb);
				break;
			default: throw new RuntimeException(sprintf("Unknown ResponseType %s", this));
		}
	}
	
	void write(SocketChannel socketChannel, ByteBuffer intb)
	{
		CommUtils.writeInt(socketChannel, intb, ResponseType.toInt(type));
		switch(type)
		{
			case ResponseType.OK: break;
			case ResponseType.QUERY: 
				CommUtils.writeString(socketChannel, intb, query);
				break;
			case ResponseType.ERROR: 
				CommUtils.writeString(socketChannel, intb, errMsg);
				break;
			default: throw new RuntimeException(sprintf("Unknown ResponseType %s", this));
		}
	}
}

class CommUtils
{
	static int readInt(SocketChannel socketChannel, ByteBuffer intb)
	{
		intb.clear();
		while (intb.hasRemaining() ) socketChannel.read(intb);
		intb.flip();
		return intb.getInt();
	}
	
	static String readString(SocketChannel socketChannel, ByteBuffer intb)
	{
		int sz = readInt(socketChannel, intb);
		ByteBuffer strb = ByteBuffer.allocate(sz);
		while(strb.hasRemaining()) socketChannel.read(strb);
		return new String(strb.array())
	}
	
	static void writeInt(SocketChannel socketChannel, ByteBuffer intb, int i)
	{
		intb.clear();
		intb.putInt(i);
		intb.flip();
		while (intb.hasRemaining() ) socketChannel.write(intb);
	}
	
	static void writeString(SocketChannel socketChannel, ByteBuffer intb, String s)
	{
		byte[] b = s.getBytes();
		writeInt(socketChannel, intb, b.length)
		ByteBuffer strb = ByteBuffer.wrap(b)
		while (strb.hasRemaining() ) socketChannel.write(strb);
	}
}