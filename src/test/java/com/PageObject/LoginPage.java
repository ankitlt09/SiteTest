package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage<WebDriver> 
{
	
	WebDriver ldriver;  // local driver
	
	
	public LoginPage(WebDriver rdriver)    // remote driver
	{
		ldriver = rdriver;
		//ldriver = rdriver;
		PageFactory.initElements((org.openqa.selenium.WebDriver) rdriver, this);
		
		
	}
	
	@FindBy(xpath="//span[@class= 'nav-line-2 nav-long-width']")
	@CacheLookup
	WebElement loginButton;
	
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	

}
