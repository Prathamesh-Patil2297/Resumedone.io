package com.resumedone.io.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateMyCV {
	
	WebDriver d1;
	
	@FindBy(xpath="//a[@class='Container-sc-1l16c1e-1 hMYzdj']")
	private WebElement CMCVButn;

	
	public void clickOnCMCVButn()
	{
		CMCVButn.click();
	}
	
	public CreateMyCV(WebDriver d2)
	{
		d1=d2;
		
		PageFactory.initElements(d2, this);
	}
}
