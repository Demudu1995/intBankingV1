package com.inetbankin.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	public ReadConfig() 
	{
		File src=new File("./Configuration/config.properties")	;
		try {
	FileInputStream fis= new FileInputStream(src);
	pro=new Properties();
		pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+ e.getMessage());
		}}
	public String getAppl()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUser()
	{
		String user=pro.getProperty("username");
		return user;
	}
	public String getpass()
	{
		String pass=pro.getProperty("password");
		return pass;
	}
	public String getChromeUrl()
	{
		String Chrome=pro.getProperty("chromepath");
		return Chrome;
	}
	public String getFirefoxUrl()
	{
		String Chrome=pro.getProperty("firefoxpath");
		return Chrome;
	}
	
	
	
	
	
	
	
}
