package com.resumedone.io.testcases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.resumedone.io.pom.CreateMyCV;

@Listeners(Listerner.ImplementationClass.class)

public class TC_CreateMyCv_001 extends BaseClass{
	
	@Test
	public void test1() throws InterruptedException, IOException
	{  
		ExtentHtmlReporter Report=new ExtentHtmlReporter("./test-output/ExtentReporter.html");
		
		ExtentReports Extent=new ExtentReports();
		
		Extent.attachReporter(Report);
		
		ExtentTest test=Extent.createTest("Verify After Clicking Create My CV Button");
		
		test.log(Status.INFO, "Browser opened & site loading");
		
		CreateMyCV btn=new CreateMyCV(driver);
		
		test.pass("Resumedone site loaded Succefully");
		
		Thread.sleep(5000);
		
		btn.clickOnCMCVButn();
		
		Thread.sleep(5000);
		
		test.pass("Select your template page loaded Succefully");
			
		screenShot("AfterClickingCreateMyCV");
		
		String CURL=driver.getCurrentUrl();
		
		System.out.println(CURL);
		
		SoftAssert s=new SoftAssert();
		
		s.assertNotEquals(CURL, ProjectURL);
		
		s.assertAll();
		
		test.pass("Browser quit Succefully");
		
		
		
		
		
		
		
	}

}
