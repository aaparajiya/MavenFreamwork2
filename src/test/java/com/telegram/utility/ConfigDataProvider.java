package com.telegram.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	//Properties class and declare global variable
	Properties pro;
	
	//Create constructor inicialize variables and objects 
	public ConfigDataProvider() {
		
		File src=new File("./config/Config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);	
			//Create object
			pro=new Properties();
			//Load the file
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load cofig file >>>"+e.getMessage());
		}
	}
	public String getDataFromConfig(String keyToSearch) {
		return pro.getProperty(keyToSearch);
	}
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	public String getStagingURL() {
		return pro.getProperty("qaUrl");
	}
}
