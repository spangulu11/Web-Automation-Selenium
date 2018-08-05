package com.wordpress.loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



	public class LoginPage {
		WebDriver driver;	
		By username=By.id("user_login");
		By password=By.xpath("//input[@id='user_pass']");
		By login=By.name("wp-submit");
		
		public LoginPage(WebDriver driver) {
			
			this.driver= driver;
		}
		
		
		public void loginWdpress(String uname,String pswd) {
			driver.findElement(username).sendKeys(uname);
			driver.findElement(password).sendKeys(pswd);
			driver.findElement(login).click();
			
		}

}