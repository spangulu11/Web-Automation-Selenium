package com.wordpress.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.wordpress.helper.BrowserFactory;
import com.wordpress.helper.ConfigReader;
import com.wordpress.helper.UtilityScreenshots;

public class LoginTest {
	
	WebDriver driver;
	
@Test(dataProvider="Wordpressdata")
public void wordPressLogin1(String uname,String passwd)  {
	
	
	    driver= BrowserFactory.StartBrowser("chrome");
	    driver.manage().window().maximize();	
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	    	
		ConfigReader config=new ConfigReader();		
		driver.get(config.getAppUrl());		
	
		driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(passwd);
		driver.findElement(By.xpath("//input[@id='wp-submit']")).click();	
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
		String actual=driver.getTitle();
		String Expected="Dashboard ‹ Wordpress Demo Site at Demo.Center — WordPress";
		if(actual.equalsIgnoreCase(Expected)) {
			
			System.out.println("Valid credentials test case passed");
		}else {
			System.out.println("Invaid credntials test case failed");
		}
	
		UtilityScreenshots.captureScreenshot(driver, "WordpresLogin");

     }

@AfterMethod
public void teaDown()
       {		
	   driver.close();
       
       }

@DataProvider(name="Wordpressdata")
public Object[][] passData1(){
	
		
		
		Object[][] data=new Object[3][2];
		
		data[0][0]="admin1";
		data[0][1]="demo1";
		

		data[1][0]="admin";
		data[1][1]="demo123";
		

		data[2][0]="admin2";
		data[2][1]="demo2";
		
		return data;
		
		
	}
	}

	





		
	



