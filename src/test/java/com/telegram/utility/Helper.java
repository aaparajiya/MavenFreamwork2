package com.telegram.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	//Screenshot, alerts, frames, windows, Sync issue, javascript executor

	
	public static String  captureScreenshot(WebDriver driver) {
		String filepath=("./screenshot/test"+getCurrentDataTime()+".png");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target=new File(filepath);
	
		try {
			FileUtils.copyFile(src,target);
			System.out.println("Screenshot captured");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot "+e.getMessage());
		}return filepath;	
	}
	public static String getCurrentDataTime() {
		SimpleDateFormat sdf=new SimpleDateFormat("MM_dd_yy_HH_mm_ss");
		Date currentDate=new Date();
		return sdf.format(currentDate);
	}
}
