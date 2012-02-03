package com.sap.hadoop.windowing


/**
 * @author harish.butani
 *
 */
public class WindowingException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6790552757682430214L;

	public WindowingException()
	{
	}

	public WindowingException(String message)
	{
		super(message);
	}

	public WindowingException(Throwable cause)
	{
		super(cause);
	}

	public WindowingException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
