package com.abcbanking.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
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
	driver.manage().window().maximize();

	lpginv.clickLoginButton();
	logger.info("Clicked loginButton");
	

	if (alertPresent()==true)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	else
	{
		System.out.println("no alert present");
	}
	

	
	String PageTitle=driver.getTitle();
	System.out.println("Page Title is"+PageTitle);

	}
	public boolean alertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
}
