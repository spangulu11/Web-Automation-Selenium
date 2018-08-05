package com.wordpress.test;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.wordpress.helper.BrowserFactory;
import com.wordpress.helper.ConfigReader;
import com.wordpress.helper.UtilityScreenshots;
import com.wordpress.loginpage.LoginPage;


public class AddDelBinPosts {	
	WebDriver driver;

@BeforeClass	
public void BrowserInit() 
	{
		
	    driver= BrowserFactory.StartBrowser("chrome");
		driver.manage().window().maximize();	}
		       
    
	
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
		        WebDriverWait wait = new WebDriverWait(driver, 10);
		        WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='post-new.php']")));
		        ele.click();		        
		        WebElement ele1= driver.findElement(By.xpath("//input[@id='title']"));
		        ele1.sendKeys("WORDPRESS DEMO"); 
		        driver.findElement(By.xpath("//button[@id='content-html']")).click();
		        driver.findElement(By.xpath(" //textarea[@id='content']")).sendKeys("Hello wordpress");		        
		        
		        /*Due to Demo environment page load issues, click is not working and page is not saving
		        getting timeout exception invoked Thread.sleep as Implicit ,explicit waits or not working*/
		  
		        try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        JavascriptExecutor js = (JavascriptExecutor)driver;		        
		        WebElement savedft=driver.findElement(By.xpath("//input[@id='save-post']"));
		        js.executeScript("arguments[0].click();", savedft);
		        WebElement publish=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='publish']")));
		        js.executeScript("arguments[0].click();", publish); 
		        
		        WebElement status=driver.findElement(By.xpath("//span[@id='post-status-display']"));		        
		        String actual=status.getText();
		        System.out.println("Status of the created Post in Wordpress demo site "+actual);
		        Assert.assertEquals(actual, "Published");  
		        System.out.println("WordPress Demo post has been created successfully");
		                    
		       
		        /* This utility to capture the screen shot*/
		        
		        UtilityScreenshots.captureScreenshot(driver,"Addpost");
		        
	}
    
	
@Test(priority=2)
public void deleteAllPost() {
		
		
				driver.findElement((By.xpath("//div[contains(text(),'Posts')]"))).click();        
				driver.findElement(By.xpath("//a[@class='wp-first-item current']")).click();  
        
				driver.findElement(By.xpath("//td[@id='cb'] ")).click(); 
				Actions action = new Actions(driver);
				WebElement we = driver.findElement(By.xpath("//select[@id='bulk-action-selector-top']"));
				action.moveToElement(we).click().build().perform();
				Select s=new Select(driver.findElement(By.name("action")));
				s.selectByVisibleText("Move to Bin");		
				driver.findElement(By.xpath("//input[@id='doaction']")).click();
        
				WebElement count=driver.findElement(By.cssSelector("#wpbody-content > div.wrap > ul > li > a > span"));       
				List<WebElement> rows = count.findElements(By.tagName("tr"));        
				int tcount=rows.size();        
				System.out.println("Total number of posts in the Delete all method "+tcount);
        
				if(tcount==0) {
					System.out.println("All post has been deleted succesfully");
				}else
				{
						System.out.println("Posts has not been deleted,Test case failed ");
				}
				
				UtilityScreenshots.captureScreenshot(driver, "DeletePost");
        
       
				
	}
	
	
	
	
@Test(priority=3)
public void deleteBinPost() {
		
				driver.findElement(By.xpath("//a[@href='edit.php?post_status=trash&post_type=post']")).click();
				driver.findElement(By.xpath("//td[@id='cb'] ")).click();
				Actions action = new Actions(driver);
				WebElement we = driver.findElement(By.xpath("//select[@id='bulk-action-selector-top']"));
				action.moveToElement(we).click().build().perform();        
				Select s=new Select(driver.findElement(By.name("action")));     
				s.selectByVisibleText("Delete Permanently");		
				driver.findElement(By.xpath("//input[@id='doaction']")).click();
        
				UtilityScreenshots.captureScreenshot(driver, "DeletBinPost");   
        
             
}
	
	
@AfterClass
public void teardown() 
   			{
		
			driver.close();
   			}
	
}	



