package com.telegram.page;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.telegram.utility.Browser;
import com.telegram.utility.ConfigDataProvider;
import com.telegram.utility.ExcelDataProvider;
import com.telegram.utility.Helper;

public class BaseClass {
	
	public static WebDriver driver;
	public static ExcelDataProvider excel;
	public static ConfigDataProvider config;
	public static ExtentReports extent=new ExtentReports();
	public static ExtentSparkReporter spark=new ExtentSparkReporter("./reports/testreport.html");
	public static ExtentTest test;
	
	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setting up reports and Test is getting ready",true);
		//Create object
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		Reporter.log("Setting done Test is started",true);
	}
	@BeforeClass
	public void setup() {
		Reporter.log("Browser and url setup start",true);
		extent.attachReporter(spark);
		driver=Browser.startApplication(driver,config.getBrowser(),config.getStagingURL());
		Reporter.log("Browser and url setup done",true);
	}
	@AfterClass
	public void tearDown() {
		System.out.println("Test is finish : "+driver.getTitle());
		Browser.quitBrowser(driver);
		Reporter.log("Test complited >>>>> and report generated",true);
		
	}
	@AfterMethod
	public void teadDownMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			//Helper.captureScreenshot(driver);
			test.fail("This test is fail",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		extent.flush();
	}

	
}
