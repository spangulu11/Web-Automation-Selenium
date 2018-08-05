package com.demo.sample;

import java.util.List;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;




public class Yahootrending {
	
	
    @Test
	public  void Test()	 {
		
		WebDriver driver=null;	
        String browserType = "FF";
		
		if(browserType.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();}
		else if(browserType.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();}
		else if(browserType.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", ".\\Drivers\\iedriverserve.exe");
			driver=new InternetExplorerDriver();}
		
		driver.manage().window().maximize();	
		
		driver.get("https://in.yahoo.com/");		
		WebElement trendingNow=driver.findElement(By.xpath("//*[@class='trending-list selected']"));
		List<WebElement> list=trendingNow.findElements(By.tagName("a"));
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++){
			
			list.get(i).click();				
			//*wait.until(ExpectedConditions.urlContains("search"));			
			driver.navigate().back();
			//*wait.until(ExpectedConditions.titleIs("Yahoo"));			
			trendingNow=driver.findElement(By.xpath("//*[@class='trending-list selected']"));
			list=trendingNow.findElements(By.tagName("a"));	
			System.out.println(list.get(i).getText());			
		}
					
		driver.close();

	}

}
