package com.Utilities;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG
{
	
	
	
	static ExtentSparkReporter reporter;
	static ExtentReports extent;
	
	@BeforeTest
	public static ExtentReports extentReporterGenerator()
	{
		//ExtentReport, ExtentSparkReporter
		String path = System.getProperty("user.dir") + "\\report\\index.html";
		
	    reporter =  new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ankit Tiwari");
		return extent;
		
		
		
	}
	
	

}
