package com.telegram.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	@FindBy(id="user-name") WebElement userName;
	@FindBy(id="password") WebElement password;
	@FindBy(id="login-button") WebElement loginButton;
	
	public void loginTo(String uname,String pass) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		userName.sendKeys(uname);
		password.sendKeys(pass);
		loginButton.click();
	}
	
	/*driver.get("https://www.saucedemo.com/");
	
	List <WebElement> webelements=driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
	System.out.println(webelements);
	Thread.sleep(5000);
*/
}
