package com.wordpress.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.wordpress.excelutil.ExceldataConfig;
import com.wordpress.helper.BrowserFactory;
import com.wordpress.helper.ConfigReader;
import com.wordpress.helper.UtilityScreenshots;

public class LoginTestExcelUtility {
	
	WebDriver driver;
	
	@Test(dataProvider="Wordpressdata")
	
	public void wordPressLogin(String uname,String pwd) {
		
		driver= BrowserFactory.StartBrowser("chrome");
		driver.manage().window().maximize();
		
		ConfigReader config=new ConfigReader();
		
		driver.get(config.getAppUrl());
		
		driver.findElement(By.xpath("//*[@id=\"user_login\"]")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys(pwd);
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
	public void teaDown()	{		
		driver.close();
	}		
	
	@DataProvider(name="Wordpressdata")
	public Object[][] passData() throws Exception
		{
			ExceldataConfig excel=new ExceldataConfig("C:\\Java Home\\com.gka.demo\\TestData\\Inputdata.xlsx");			
			int row=excel.getRowCount(0);	
			System.out.println("Total no of Rows  "+row);
			Object[][] data=new Object[row][2];			
			for (int i=0;i<row;i++) 
			{
				data[i][0]=excel.getData(0,i,0);
				data[i][1]=excel.getData(0,i,1);	
											
			}
			return data;
			
		}
	}

		
	



