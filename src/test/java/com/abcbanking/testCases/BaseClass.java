package com.abcbanking.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

import org.apache.commons.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;

import com.abcbanking.utilities.*;
import com.aventstack.extentreports.utils.FileUtil;
import com.google.common.io.Files;
//import org.apache.logging.log4j.

//import com.abcbanking.pageObjects.LoginPage;

public class BaseClass
{
	
	/* Consists of all Intializtions methods, teardown methods */
	
	ReadConfigurations Readprop=new ReadConfigurations();
	
	public String baseUrl=Readprop.getUrl();		
	public String Username=Readprop.getUsername();
	public String Password=Readprop.getPassword();
	public String InvalidUsername=Readprop.getinvalidUsername();
	public String InvalidPassword=Readprop.getinvalidPassword();
	//System.setProperty("Webdriver.chrome.driver", "D:\\JavaWS\\ABCRetails\\Drivers\\chromedriver.exe");
	public  WebDriver driver;
	
	public static Logger logger;
	
	
	@Parameters ("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		logger=LogManager.getLogger(BaseClass.class);
	
		if(br.equals("chrome"))
		{
		//System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe"
		System.setProperty("webdriver.chrome.driver",Readprop.chromePath());
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable-notifications");
		driver=new ChromeDriver(options);
		
		//WebDriverManager.chromedriver().setup();
		
		
		
		}
		
		else
		
		{	
			
			System.setProperty("webdriver.ie.driver",Readprop.IEPath());
			driver=new InternetExplorerDriver();
			
		}
		

		
	}
		

	/*
	 * @AfterClass public void Tear() {
	 * 
	 * driver.quit();
	 * 
	 * }
	 */
	public void captureScreeshot(WebDriver driver,String TCName) throws IOException
	{
		
		
		//Take the Screenshot 
		TakesScreenshot snap= (TakesScreenshot)driver;
		
		
		// Get Source & Destination
		File ScreenshotSource=snap.getScreenshotAs(OutputType.FILE);
		File ScreenshotTarget= new File(System.getProperty("user.dir")+"\\Screenshots\\"+TCName+".png");
		
		//Copy from source to destination
		//FileUtils.copyFile() method is Used if Java 1.7 or before
		
		Files.copy(ScreenshotSource, ScreenshotTarget);
		System.out.println("Screenshot is captured");
		
	}
	
	/*
	 * public void AlertPresent() { Alert alert=driver.switchTo().alert(); String
	 * AlertText=alert.getText(); logger.info("Alert text is"+AlertText);
	 * alert.dismiss();
	 * 
	 * }
	 */

	

}
