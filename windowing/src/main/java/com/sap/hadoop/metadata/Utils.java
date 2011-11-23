package com.sap.hadoop.metadata;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Utils
{
    public static String sprintf(String format, Object... values)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        out.printf(format, values);
        return outputStream.toString();
    }

}
