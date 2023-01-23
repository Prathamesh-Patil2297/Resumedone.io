package com.resumedone.io.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertiesFile {

	
	Properties pro;
	
	public ReadPropertiesFile()
	{
		
		File src=new File("F:\\Resumedone\\resumedone.io\\src\\Properties File\\config.properties");
		
		try 
		{
			FileInputStream FIS=new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(FIS);
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public String getURL()
	{
		String URL=pro.getProperty("ProjectURL");
		
		return URL;
	}
	
}
