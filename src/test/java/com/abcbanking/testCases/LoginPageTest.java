package com.abcbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.abcbanking.pageObjects.LoginPage;


/* 
 * Consists of all Page objects & Action methods eg: enter details, click on button etc required for this page, 
 * Used PageFactory class @FindBy for object identifications
 *  
 */


public class LoginPageTest extends BaseClass
{
	
	
@Test
	public void loginTest() throws InterruptedException, IOException
	
	{
	

		//System.getProperty("user.dir") : Gives the path of the project directory 
		//WebDriver driver;
		//System.setProperty("Webdriver.chrome.driver", "D:\\JavaWS\\ABCRetails\\Drivers\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
	
		driver.get(baseUrl);
		Thread.sleep(300);
		
		//logger.debug("This is debug");
		LoginPage lpg=new LoginPage(driver);
		lpg.enterUserName(Username);
		logger.info("Entered Username");
		
		lpg.enterPassword(Password);
		
		logger.info("Entered Password");
		lpg.clickLoginButton();
		logger.info("Clicked loginButton");
		
		String PageTitle=driver.getTitle();
		System.out.println("Page Title is"+PageTitle);
		
		
		if(PageTitle.equals("GTPL Bank Manager HomePage"))
		{
			System.out.println("Sysout: Login Page Case is passed");
		}
		
		else 
		{
			
			System.out.println("Sysout: Login Page Case is failed");
			captureScreeshot(driver,"LoginPageTest");
			
			

		}
	}
	
}
