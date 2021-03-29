package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Config/Config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);    //which will load the complete file
			
		}catch(Exception e)
		{
			System.out.println("Exception is" + e.getMessage());                                                                                     
		}
	}

	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName()
	{
		String username = pro.getProperty("username");
		return username;
		
	}
	
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String path = pro.getProperty("chromePath");
		return path;
	} 
	
	public String getFirefoxPath()
	{
		String path = pro.getProperty("firefoxPath");
		return path;
	}

}
