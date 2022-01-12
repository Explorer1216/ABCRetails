package com.abcbanking.testCases;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.abcbanking.pageObjects.CreateNewUser;
import com.abcbanking.pageObjects.LoginPage;

public class TC_CreateNewUser extends BaseClass

{
	@Test

	public void CreateNewUserRegist() throws InterruptedException

	{
		driver.get(baseUrl);
		Thread.sleep(300);

		// logger.debug("This is debug");
		LoginPage lpg = new LoginPage(driver);
		lpg.enterUserName(Username);
		logger.info("Entered Username");

		lpg.enterPassword(Password);
		logger.info("Entered Password");

		lpg.clickLoginButton();
		logger.info("Clicked loginButton");

		Thread.sleep(5000);
		driver.manage().window().maximize();
		


		CreateNewUser NewUser = new CreateNewUser(driver);
		NewUser.clickNewCustomerlink();
		System.out.println("Clicked on New User link");
		logger.info("Clicked on New User link");
		Thread.sleep(5000);
		
		//AlertPresent();
		
		/*
		 * Alert alert=driver.switchTo().alert(); String AlertText=alert.getText();
		 * logger.info("Alert text is"+AlertText); alert.dismiss();
		 */
		
		//driver.findElement(By.xpath("//*[@id='dismiss-button']")).click();
			
		
		
		if(AlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.warn("Login passed");
			//lpg.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}

			
	
		
		
		logger.info("providing customer details....");

		
		NewUser.custName("Naga");

		NewUser.custgender("male");
		NewUser.custdob("10", "15", "1985");
		Thread.sleep(5000);
		NewUser.custaddress("INDIA");
		NewUser.custcity("HYD");
		NewUser.custstate("AP");
		NewUser.custpinno("5000074");
		NewUser.custtelephoneno("987890091");

		//String email = randomestring() + "@gmail.com";
		String email = "Abcdefgh@gmail.com";
		NewUser.custemailid(email);
		NewUser.custpassword("abcdef");
		NewUser.custsubmit();

		Thread.sleep(3000);

		logger.info("validation started....");

		
		/*
		 * public String randomestring() {
		 * 
		 * String generatedstring=RandomStringUtils.randomAlphabetic(8);
		 * return(generatedstring); }
		 */

		
		
	}
	

public boolean AlertPresent() //user defined method created to check alert is presetn or not
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