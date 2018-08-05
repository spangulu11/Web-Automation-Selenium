package com.wordpress.helper;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigReader {
	static Properties pro;
	
	
	public ConfigReader() {
		
try {
	 		File src=new File("./Configuration/config.properties");
			
			FileInputStream fis= new FileInputStream(src);		
		    pro=new Properties();
			pro.load(fis);
			
			} 

catch (Exception e) {
	System.out.println("Exception is:"+ e.getMessage());
			}}
	

 public String getAppUrl() {
	 
	 return pro.getProperty("url");
	  
 }
 
 
 public String getCalurl() {
	return pro.getProperty("url1");
	 
 }




}


