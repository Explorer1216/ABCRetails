package com.abcbanking.testCases;

import java.sql.Driver;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTest {
	
	WebDriver cdriver;
	
    public static void main(String[] args) throws NoAlertPresentException,InterruptedException {
        // TODO Auto-generated method stub

        /*        System.setProperty("Webdriver.chrome.driver", "D:\\JavaWS\\ABCRetails\\Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://demo.guru99.com/V1/index.php//");*/
        
    //    String path=System.getProperty("user.dir");
      //  System.out.println(path);
    	//logger.debug("This is debug");
	/*
	 * logger.info("This is Info"); logger.warn("This is Warn");
	 * logger.error("This is error"); logger.fatal("This is fatal");
	 */
		
		//@Test
    	System.setProperty("webdriver.chrome.driver","D:\\JavaWS\\ABCRetails\\Drivers\\chromedriver.exe");
		WebDriver cdriver=new ChromeDriver();
		cdriver.get("https://demo.guru99.com/V1/index.php");
		WebElement user=cdriver.findElement(By.name("uid"));
		WebElement pass=cdriver.findElement(By.name("password"));
		WebElement lgnbtn=cdriver.findElement(By.name("btnLogin"));
		
		
		user.sendKeys("mngr378074");
		pass.sendKeys("rEtadev");
		lgnbtn.click();
		Thread.sleep(3000);
		WebElement NewCust=cdriver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a"));
		cdriver.manage().window().maximize();

		NewCust.click();
		System.out.println("Clicked on new cus link");
		Thread.sleep(3000);
		//cdriver.navigate().refresh();
	    //WebElement NewCust1=cdriver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a"));
		//NewCust1.click();
		//System.out.println("Again Clicked on new cus link");
		Set<String> handler= cdriver.getWindowHandles();
		
		Iterator<String> itr=	handler.iterator();

		String ParentwindowId=itr.next();
		System.out.println("Parent Window is"+ParentwindowId);
		
		while(itr.hasNext())
		{
			
			String windowhandles=itr.next();
			System.out.println("window handles are"+windowhandles);
			
		}
		
		/*
		 * String ChildWindow = itr.next();
		 * System.out.println("Child Window is"+ChildWindow);
		 * cdriver.switchTo().window(ParentwindowId); //cdriver.close();
		 */		
		cdriver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		cdriver.findElement(By.xpath("//*[@id='dismiss-button']")).click();
		
		/*
		 * if(alerpresent()==true)
		 * 
		 * { Alert al=cdriver.switchTo().alert(); al.dismiss(); }
		 * 
		 * else { System.out.println("No alert"); }
		 */

		/*
		 * Alert alert = cdriver.switchTo().alert();
		 * 
		 * // Capturing alert message. String alertMessage=
		 * cdriver.switchTo().alert().getText();
		 * 
		 * // Displaying alert message
		 * System.out.println("alert text is "+alertMessage); Thread.sleep(5000);
		 * 
		 * // Accepting alert alert.accept();
		 */
}
    
		


/*
 * public static boolean alerpresent() {
 * 
 * 
 * try { //cdriver.switchTo().alert(); return true; }
 * catch(NoAlertPresentException e) { return false; }
 * 
 * }
 */

}

