package com.sap.hadoop.ds;

import java.util.concurrent.locks.Lock;

public class LockUtils
{
	public static void lock(Lock lock) throws BaseException
	{
		try
		{
			lock.lockInterruptibly();

		}
		catch(InterruptedException ie)
		{
			Thread.currentThread().interrupt();
			throw new BaseException("Operation interrupted", ie);
		}
	}

}
