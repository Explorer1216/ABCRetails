package com.abcbanking.testCases;

import java.io.IOException;
import com.abcbanking.pageObjects.LoginPage;
import com.abcbanking.utilities.ExcelUtilities;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginUsersDDT extends BaseClass {
	
	
	@Test(dataProvider="LoginData")
	
	public void loginUsersDDT(String user,String pwd) throws InterruptedException, IOException
	{
		//LoginPage lpg=new LoginPage(driver);
		
		
		driver.get(baseUrl);
		Thread.sleep(300);
		
		LoginPage lpg=new LoginPage(driver);
		
		lpg.enterUserName(user);
		logger.info("user name provided");
		lpg.enterPassword(pwd);
		logger.info("password provided");
		lpg.clickLoginButton();
		logger.info("Clicked login button");
		
		Thread.sleep(3000);
		
		String PageTitle=driver.getTitle();
		System.out.println("Title of login page is "+PageTitle);
		
		if(PageTitle.equals("GTPL Bank Manager HomePage"))
		{
			//System.out.println("SysOut: Login Page Case is passed");
			logger.info("Log: Login Page Case is passed");
		}
		
		else 
		{
			
		//	captureScreeshot(driver,"LoginUsersDDT");
			//System.out.println("Sysout: Login Page Case is failed");
			logger.info("Log: Login Page Case is failed");
			

		}
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			//Assert.assertTrue(false);
			//logger.warn("Login failed");
		}
		else
		{
			//Assert.assertTrue(true);
			logger.warn("Login passed");
			lpg.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
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
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/abcbanking/testData/LoginData.xlsx";
				//System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		//String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int rownum=ExcelUtilities.getRowcount(path, "Sheet1");
		int colcount=ExcelUtilities.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=ExcelUtilities.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	

}
