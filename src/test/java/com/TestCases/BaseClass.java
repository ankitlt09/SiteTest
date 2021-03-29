package com.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.Utilities.ReadConfig;

public class BaseClass 
{
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL =readconfig.getApplicationURL();
	public String username=readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser)
	{
		
		logger = Logger.getLogger("Amazon");
		PropertyConfigurator.configure("Log4j.properties");
		
		
		if(browser.equals("chrome"))                                                                      
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			
		}                   
		
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			// driver = new FirefoxDriver(); // I dont have firefox webdriver
			
		}
		else if(browser.equals("ie"))
		{


			
			
			
			  // driver = new InternetExplorerDriver();  I dont have firefox  and ie webdriver
		}
		
		driver.get(baseURL);
		
		
	}
	
	
	@AfterMethod 
	
	public void tearDown()                    
	{
		driver.close();
		
	}
	
	public static String getScreenshotPath(String tname, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path =System.getProperty("user.dir") + "./Screenshot" + tname +".png";
		//File target = new File(System.getProperty("user.dir ") + "./Screenshots" + tname + ".png");
		File target = new File(path);
		FileUtils.copyFile(source, target);
		//System.out.println("Screenshot taken");
		return path;

		
		
	}

}
