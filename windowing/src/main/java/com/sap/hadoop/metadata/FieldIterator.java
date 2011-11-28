package com.sap.hadoop.metadata;

import java.util.Iterator;

public class FieldIterator implements Iterator<String>
{
	String s;
	String fieldSep;
	String recordBegin;
	String recordEnd;
	int currentLoc;
	int len;

	public FieldIterator(String s, String fieldSep, String recordBegin, String recordEnd)
	{
		super();
		this.s = s;
		this.fieldSep = fieldSep;
		this.recordBegin = recordBegin;
		this.recordEnd = recordEnd;
		this.len = s.length();
		currentLoc = 0;
	}

	@Override
	public boolean hasNext()
	{
		return currentLoc < len;
	}

	@Override
	public String next()
	{
		if ( s.indexOf(recordBegin, currentLoc ) == currentLoc )
		{
			int endIdx = s.indexOf(recordEnd, currentLoc + recordBegin.length());
			if ( endIdx == -1 )
			{
				throw new InternalError("No recordEnd marker found: " + recordEnd);
			}
			String rs = s.substring(currentLoc, endIdx + recordEnd.length());
			currentLoc = endIdx + recordEnd.length() + fieldSep.length();
			return rs;
		}
		else
		{
			int endIdx = s.indexOf(fieldSep, currentLoc + fieldSep.length());
			endIdx = endIdx == -1 ? len : endIdx;
			String rs = s.substring(currentLoc, endIdx);
			currentLoc = endIdx + fieldSep.length();
			return rs;
		}
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();
		
	}

}

