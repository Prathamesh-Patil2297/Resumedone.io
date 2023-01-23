package Listerner;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ImplementationClass implements ITestListener{
	
	public void onTestFailure(WebDriver driver, ITestResult result) throws IOException {
		
		File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	File Destination=new File(System.getProperty("user.dir")+"/FailedTCSS/"+result+".jpg");
    	FileHandler.copy(Source, Destination);
    	
	}
	
	
	
	
}
