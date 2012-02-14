package com.sap.hadoop.windowing.cli

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

class WindowingClassLoader extends URLClassLoader
{
	private WindowingClassLoader(URL[] urls, ClassLoader parent)
	{
		super(urls, parent);
	}
	
	public static ClassLoader create(ClassLoader cloader, String windowingJar) throws Exception {
		URLClassLoader loader = (URLClassLoader) cloader;
		List<URL> curPath = Arrays.asList(loader.getURLs());
		ArrayList<URL> newPath = new ArrayList<URL>();
	
		newPath.add((new File(windowingJar)).toURL());
		for (URL onePath : curPath) 
		{
		  newPath.add(onePath);
		}
		return new WindowingClassLoader(newPath.toArray(new URL[0]), loader);
	  }
	
	protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException 
	{
		// First, check if the class has already been loaded
		Class c = findLoadedClass(name);
		if (c == null) 
		{
			if (name.startsWith("org.antlr") ||
				name.startsWith("com.sap"))
			{
				try 
				{
					c = findClass(name);
				} 
				catch (ClassNotFoundException e) {}
			}
			if (c == null) 
			{
				return super.loadClass(name, resolve);
			}
		}
		
		if (resolve) 
		{
			resolveClass(c);
		}
		return c;
	}
	
	public URL getResource(String name) 
	{
		// Try to find it locally first
		URL url = findResource(name);
		// If not, try parent
		if(url == null) 
		{
			url = super.findResource(name);
		}
		return url;
	}
	
	protected void setParentAsThreadLoader()
	{
		Thread.currentThread().setContextClassLoader(parent);
	}
}
