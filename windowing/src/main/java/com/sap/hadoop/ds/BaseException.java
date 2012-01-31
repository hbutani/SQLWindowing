package com.sap.hadoop.ds;

public class BaseException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1771659249314282058L;

	public BaseException()
	{
		super();
	}

	public BaseException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public BaseException(String message)
	{
		super(message);
	}

	public BaseException(Throwable cause)
	{
		super(cause);
	}

}
