package com.demo.sample;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import com.wordpress.helper.ConfigReader;

public class IncomeCalcDemo {
	static WebDriver driver=null;
	
	public static void StartBrowser(){
		String browserType = "Chrome";
		
		if(browserType.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();}
		else if(browserType.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();}
		else if(browserType.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", ".\\Drivers\\iedriverserve.exe");
			driver=new InternetExplorerDriver();}		
	}
	
    public static void getUrl(String str)
    {
    	
    	ConfigReader config=new ConfigReader();		
		driver.get(config.getCalurl());
    }
    
    
    
    public static void calculate(){
    	
    	driver.findElement(By.xpath("//*[@id='hl1']/li[5]/a")).click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	WebElement anualinc=driver.findElement(By.xpath("//*[@id='cannualincome']"));
    	anualinc.clear();
    	anualinc.sendKeys("100000");
    	
    	WebElement pfreq=driver.findElement(By.xpath("//*[@id='cpayfrequency']"));
    	Select s=new Select(pfreq);
    	s.selectByVisibleText("Monthly"); 	
    	
    	WebElement Filests=driver.findElement(By.xpath("//*[@id='cfilestatus']"));
    	Select s1=new Select(Filests);
    	s1.selectByVisibleText("Married Filing Separately");
    	
    	WebElement fedalow=driver.findElement(By.xpath("//input[@name='callowance']"));
    	fedalow.clear();
    	fedalow.sendKeys("3");
    	
    	WebElement taxded=driver.findElement(By.xpath("//*[@id='cdeduction']"));
    	taxded.clear();
    	taxded.sendKeys("900");
    	
    	driver.findElement(By.xpath("//*[@id='cadditionat1']")).click();
    	driver.findElement(By.xpath("//*[@id='calinputtable']/tbody/tr[10]/td/input[2]")).click();
    	
    	String finalvalue=driver.findElement(By.xpath("//*[@id='content']/table[1]/tbody/tr[9]/td[2]/b")).getText();
    	
    	System.out.println("FInal value of the cals is:"+finalvalue);
    }
	
	public static void main(String[] args) {
		StartBrowser();		
		getUrl(null);		
	   calculate();
	   driver.close();
	}
	

}