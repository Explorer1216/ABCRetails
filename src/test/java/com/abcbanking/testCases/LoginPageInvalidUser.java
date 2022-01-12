package com.abcbanking.testCases;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.abcbanking.pageObjects.LoginPage;

public class LoginPageInvalidUser extends BaseClass

{
	
	@Test
	
	public void invalidUserLogin() throws InterruptedException
	{
	driver.get(baseUrl);
	Thread.sleep(300);
	driver.manage().window().maximize();
	//logger.debug("This is debug");
	LoginPage lpginv=new LoginPage(driver);
	lpginv.enterUserName(InvalidUsername);
	logger.info("Entered Username");
	
	lpginv.enterPassword(Password);
	
	logger.info("Entered Password");
	lpginv.clickLoginButton();
	logger.info("Clicked loginButton");
	
	driver.manage().window().maximize();
	
	
	
	Alert alert=driver.switchTo().alert();
	String AlertText = alert.getText();
	System.out.println("Alert is "+AlertText);
	alert.accept();
	
	
	String PageTitle=driver.getTitle();
	System.out.println("Page Title is"+PageTitle);

	}
}
