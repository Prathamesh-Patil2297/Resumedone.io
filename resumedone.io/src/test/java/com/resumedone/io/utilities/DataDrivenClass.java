package com.resumedone.io.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class DataDrivenClass {

	public static String path="";
	
	Workbook book;
	
	Sheet sheet;
	
	public Object[][] getTestData(String sheetname)
	{     FileInputStream file=null;
	   
	    try {
	    	
	    	file= new FileInputStream(path);
	     	
	    }
		catch(Exception e)
	    {
			e.printStackTrace();
			
	    }
	      
	    sheet = book.getSheet(sheetname);
	    
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i < sheet.getLastRowNum(); i++)
		{
			for(int k=0;k < sheet.getRow(0).getLastCellNum();k++)
			{
				
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
			}
			
			
		}
		
		
		
		
		
		return data;
		
		
		
		
		
		
	}
}
