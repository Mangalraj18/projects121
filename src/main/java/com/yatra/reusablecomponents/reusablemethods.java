package com.yatra.reusablecomponents;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class reusablemethods 
{

	public static void loadurl(WebDriver driver)
	{
		driver.get(com.yatra.utilities.Propertyfilereader.loadurl());	
	}
	
	public static void timelapse(WebDriver driver) {
		int wait = Integer.parseInt(com.yatra.utilities.Propertyfilereader.propfile().getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}
   public static boolean findElement(By selector, WebDriver driver)
   {
	   try
	   {
	   driver.findElement(selector);
	   return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println("No element found exception");
		   return false;
	   }  
   }
   public static boolean enter(By selector, WebDriver driver)
   {
	   try
	   {
	   driver.findElement(selector).sendKeys(Keys.ENTER);
	   return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println("No element found exception in enter part");
		   return false;
	   }    
   }
   public static boolean clear(By selector, WebDriver driver)
   {
	   try
	   {
	   driver.findElement(selector).clear();
	   return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println("No element found exception in enter part");
		   return false;
	   }    
   }
   public static boolean sendkeys(By selector, String value, WebDriver driver)
   {
	   try
	   {
	   driver.findElement(selector).sendKeys(value);
	  return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println("Sending key error");
		  return false;
	   }
	   
   }
   public static boolean click(By selector, WebDriver driver)
   {
	   try
	   {
	   driver.findElement(selector).click();
	   return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println("Not clicking");
		   return false;
	   }
	   
   }
  
	
	
	
	
}
