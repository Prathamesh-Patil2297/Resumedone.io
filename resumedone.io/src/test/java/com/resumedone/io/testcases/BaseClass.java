package com.resumedone.io.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.resumedone.io.utilities.ReadPropertiesFile;

public class BaseClass {
	
	ReadPropertiesFile read=new ReadPropertiesFile();
	
	public String ProjectURL=read.getURL();
	
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void setupBrowser(String br)
	{
		
		if(br.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src"+File.separator+"main"+File.separator+"chromedriver.exe");
		
		    driver=new ChromeDriver();
		
		
		}
		else if(br.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "src"+File.separator+"main"+File.separator+"msedgedriver.exe");
			
		    driver=new EdgeDriver();
		
				
		}
		else if(br.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src"+File.separator+"main"+File.separator+"geckodriver.exe");
			
		    driver=new FirefoxDriver();
			
		}
		
		  driver.navigate().to(ProjectURL);
		  
		  driver.manage().window().maximize();
	}
	
	
	@AfterMethod()
	public void tearDown()
	{
		
		driver.quit();
		
	}
	
    public void screenShot(String Name) throws IOException
    {
    	File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	File Destination=new File(System.getProperty("user.dir")+"/Screenshots/"+Name+".jpg");
    	FileHandler.copy(Source, Destination);
    	
    	
    }
    

		
}
