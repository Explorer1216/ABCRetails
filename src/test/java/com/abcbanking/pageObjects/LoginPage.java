package com.abcbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/* 
 * Consists of all Page objects & Action methods eg: enter details, click on button etc required for this page, 
 * Used PageFactory class @FindBy for object identifications
 *  
 */

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	
/*@CacheLookup: Annotation when applied over a WebElement, instructs Selenium to keep a cache of the WebElement 
	instead of searching for the WebElement every time from the WebPage. This helps us save a lot of time */
	
	
@FindBy(name="uid")
@CacheLookup
WebElement lgnUsername;

@FindBy(name="password")
WebElement lgnPassword;


@FindBy(name="btnLogin")
WebElement lgn_lgnbutton;

@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
WebElement lnkLogout;



//http://demo.guru99.com/V1/index.php//

public void enterUserName(String UsrName)
{
	lgnUsername.sendKeys(UsrName);
}


public void enterPassword(String Password)
{
	lgnPassword.sendKeys(Password);
}


public void clickLoginButton()
{
	lgn_lgnbutton.click();
}


public void clickLogout()
{
	lnkLogout.click();
}

}
