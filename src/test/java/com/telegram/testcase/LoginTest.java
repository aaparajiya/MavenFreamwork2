package com.telegram.testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.telegram.page.BaseClass;
import com.telegram.page.LoginPage;
import com.telegram.utility.Helper;

public class LoginTest extends BaseClass{
	
	@Test (priority=1)
	public static void loginApp() {
		test=extent.createTest("Test1 login start");
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.loginTo(excel.getStringData("Sheet1",0,0),excel.getStringData("Sheet1",0,1));
		test.log(Status.PASS, "Login test pass");
	}
	@Test (priority=2)
	public static void f1() {
		test=extent.createTest("Test2 secod test").assignAuthor("Ashwin")
				.assignCategory("Smoke test").assignDevice("Chrome");
		test.log(Status.PASS, "Test2 pass");
		test.info("This is information message");
		test.pass("This test is pass");
		test.warning("This is warning message");
		test.skip("This is test skip ");
		test.fail("This test is fail",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
	}

}
