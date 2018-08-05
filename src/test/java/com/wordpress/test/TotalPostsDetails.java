package com.wordpress.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wordpress.helper.BrowserFactory;
import com.wordpress.helper.ConfigReader;
import com.wordpress.loginpage.LoginPage;


public class TotalPostsDetails {
	
	
	WebDriver driver;
	
	@BeforeClass
	public void BrowserInit() 
	{
		
	    driver= BrowserFactory.StartBrowser("chrome");
		driver.manage().window().maximize();			       
    }
	
	@Test(priority=1)
	public void addnewPostWordpress() 
	{	
		
				ConfigReader config=new ConfigReader();
				driver.get(config.getAppUrl());
				LoginPage lg=new LoginPage(driver);		
		        lg.loginWdpress("admin", "demo123");
		        
		        Assert.assertTrue(driver.getTitle().contains("Dashboard"),"User is not able to login-Invalid credntials");
		        System.out.println("User is able to login succesfully "+driver.getTitle());	
		        
		        driver.findElement((By.xpath("//div[contains(text(),'Posts')]"))).click();
		        driver.findElement(By.xpath("//a[@class='wp-first-item current']")).click();
		        		     
		        
		        WebElement table=driver.findElement(By.xpath("//table[contains(@class,'wp-list-table widefat fixed striped posts')]"));
		        List<WebElement> rows = table.findElements(By.tagName("tr"));
		        int nr=rows.size();
				System.out.println("Total no of rows "+(nr-2));
		        
				List<WebElement> cols = null;			
				
				for(int i=1; i<nr; i++) {
					cols= rows.get(i).findElements(By.tagName("td"));

					for(int j=0; j<cols.size(); j++) {
						System.out.print(cols.get(j).getText()+"\t\b");
				}
				}
		        	        
		          
	}
	
	@Test(priority=2)
	public void Totallinksinwordpress() 
	
	{
		
		driver.findElement(By.xpath(" //div[contains(text(),'Dashboard')]")).click();
		
		List<WebElement> list =driver.findElements(By.tagName("a"));	
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++) {
			
		System.out.println(list.get(i).getText()+"----->>"+list.get(i).getAttribute("href"));
		
		}
		
		
	}
	
	@AfterClass
	public void teardown() {
		
		driver.close();
	}
	
	
}


