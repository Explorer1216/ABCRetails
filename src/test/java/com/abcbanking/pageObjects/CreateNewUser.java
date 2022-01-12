package com.abcbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateNewUser {
	
	WebDriver ldriver;
	
	public  CreateNewUser(WebDriver rdriver)
	
	{
		
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
		
	}
	
	//WebDriver driver;
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	
	WebElement NewCustomerlink;
	
	
	//Thread.sleep(300);
	//WebElement NewCustomerlink=driver.findElement(By.linkText("New Customer"));
	
	//This is other way of finding elements using pagefactory methods , @FindBy(how=,using="")
	@FindBy(how=How.NAME, using="name")
	WebElement CustName;
	
	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;

	@CacheLookup
	@FindBy(how = How.NAME, using = "addr")
	WebElement txtaddress;

	@CacheLookup
	@FindBy(how = How.NAME, using = "city")
	WebElement txtcity;

	@CacheLookup
	@FindBy(how = How.NAME, using = "state")
	WebElement txtstate;

	@CacheLookup
	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtpinno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txttelephoneno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;

	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	WebElement txtpassword;

	@CacheLookup
	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;
	
	
	public void clickNewCustomerlink()
	{
		NewCustomerlink.click();
	}
	
	public void custName(String cname) {
		CustName.sendKeys(cname);
		
	}

	public void custgender(String cgender) {
		rdGender.click();
	}

	
	//For DOB its like dropdown box, we need to pass Month,Date,Year seperately
	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}

	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}

	//If Pin# is Integer we need to convert the Pincode in String format & pass through SendKeys as SendKeys wont send Integer formats
	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}

	public void custsubmit() {
		btnSubmit.click();
	}
	
	
	
	
	

}
