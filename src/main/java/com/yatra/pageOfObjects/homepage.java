package com.yatra.pageOfObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.yatra.utilities.logger;
import com.yatra.reusablecomponents.reusablemethods;
import com.yatra.uistore.Homepage;

public class homepage 
{
  public static boolean search(WebDriver driver, String searchKey,String pass, Logger log) throws InterruptedException
  {
	  Thread.sleep(2000);
	  if(reusablemethods.click(Homepage.pop_up, driver))
	  {
	if(reusablemethods.click(Homepage.start, driver))
	{
		Thread.sleep(2000);
		if(reusablemethods.sendkeys(Homepage.start, searchKey, driver))
		{
			Thread.sleep(2000);
			if(reusablemethods.enter(Homepage.start, driver))
			{
			 if(reusablemethods.click(Homepage.going_to, driver))
			 {
				 Thread.sleep(2000);
				 if(reusablemethods.sendkeys(Homepage.going_to, pass, driver))
				 {
					 Thread.sleep(2000);
					 if(reusablemethods.enter(Homepage.going_to, driver))
					 {
						 Thread.sleep(2000);
						 if(reusablemethods.click(Homepage.calender, driver))
						 {
							 Thread.sleep(2000);
							 if(reusablemethods.click(Homepage.date, driver))
							 {
								 String values=driver.findElement(Homepage.datetext).getText();
								 System.out.println(values);
								 Assert.assertEquals(values, "16 Sep' 21");
								 logger.loginfo(log, "date verified successfully");
								 if(reusablemethods.click(Homepage.search_button, driver))
							return true;
						 }
					 }
				 }
				
		}
	}
		}
		}
	}
	  }
	  
	return false;
  }
	
	
	
}
