package com.wordpress.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver StartBrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("FF")) {
			
			System.setProperty("webdriver.gecko.driver", ".\\Driver\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.disable_beforeunload", true);
			 driver = new FirefoxDriver(options);			
			}			
			
		 else if(browserName.equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "C:\\BD\\chromedriver.exe");			
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("--disable-popup-blocking");
			 driver = new ChromeDriver(options);
			 }
			
			
				
				return driver;
	
		
	}
	}

