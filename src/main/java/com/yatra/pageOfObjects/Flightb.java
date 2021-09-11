package com.yatra.pageOfObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.yatra.reusablecomponents.reusablemethods;
import com.yatra.uistore.Flightbookin;
import com.yatra.utilities.logger;

public class Flightb 
{
   
	public static boolean book(WebDriver driver, Logger log)
	{
		if(reusablemethods.click(Flightbookin.offerclick,driver))
		{
			logger.loginfo(log, "Clicked on the boking page");
			boolean val=driver.findElement(Flightbookin.display).isDisplayed();
			Assert.assertTrue(val);
			logger.loginfo(log, "Elements is highlighted");
		return true;
		}
		return false;
	}
	
	
	
}
