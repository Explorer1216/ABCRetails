package com.abcbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfigurations {
	
	public Properties pro;
	
	public ReadConfigurations() 
	
	{
	File src=new File("./Configuration/Config.Properties");
	
	try
	{
	FileInputStream fis=new FileInputStream(src);
	pro=new Properties();
	pro.load(fis);
		
	}
	catch(Exception e)
	{
		System.out.println("File maynt be there or readable"+e.getMessage());
	}
	}
	
	public String getUrl()
	{
		String BasUrl=pro.getProperty("baseUrl");
		return BasUrl;
	}
	public String getUsername()
	{
		String UserName=pro.getProperty("UserName");
		return UserName;
	}
	public String getPassword()
	{
		String Password=pro.getProperty("Password");
		return Password;
	}
	
	public String getinvalidUsername()
	{
		String UserName=pro.getProperty("InvalidUserName");
		return UserName;
	}
	public String getinvalidPassword()
	{
		String Password=pro.getProperty("InvalidPassword");
		return Password;
	}

	public String chromePath()
	{
		String Chromepath=pro.getProperty("chromepath");
		return Chromepath;
	}
	public String IEPath()
	{
		String IEPath=pro.getProperty("IEpath");
		return IEPath;
	}

}
