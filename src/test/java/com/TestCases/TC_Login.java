package com.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.TestCases.BaseClass;
import com.PageObject.LoginPage;

public class TC_Login extends BaseClass{

	@Test
	public void Login() throws InterruptedException
	{
		
		

		logger.info("URL is opened");
		
		WebDriver driver=BaseClass.driver;
		
		LoginPage lp = new LoginPage(driver);
		
		
		
		lp.clickLoginButton();
		
		
	}
	
}
