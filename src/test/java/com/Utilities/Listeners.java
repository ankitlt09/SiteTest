package com.Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TestCases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseClass implements ITestListener {

	ExtentReports extent = ExtentReporterNG.extentReporterGenerator();
	ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); 
	
	public void onTestStart(ITestResult result)
	{
		 test= extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		 
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Successful");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Screenshot and attach to report
		
		WebDriver driver = null;
		extentTest.get().fail(result.getThrowable());
		Object testObject = result.getInstance();
		Class clasz = result.getTestClass().getRealClass();
		try {
			driver = (WebDriver) clasz.getDeclaredField("driver").get(testObject);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			extentTest.get().addScreenCaptureFromPath(BaseClass.getScreenshotPath(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub 
		extent.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

}
