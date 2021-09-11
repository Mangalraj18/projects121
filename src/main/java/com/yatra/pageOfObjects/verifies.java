package com.yatra.pageOfObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.yatra.reusablecomponents.reusablemethods;
import com.yatra.uistore.verify;

public class verifies 
{
	public static boolean verifies(WebDriver driver)
	{
	  if(reusablemethods.click(verify.ver, driver))
	  {
	  Set<String> wind =driver.getWindowHandles();
	  Iterator<String> it=wind.iterator();
	  String parent=it.next();
	  String child=it.next();
	  driver.switchTo().window(child);
	  String title=driver.getTitle();
	  Assert.assertEquals(title,"Travelguru: Book Homestays, Vacation Rentals, Hotels & More");
	  System.out.println("Title valid successfully");
	  driver.switchTo().window(parent);
	  return true;
	  }
	  return false;
	}
}
