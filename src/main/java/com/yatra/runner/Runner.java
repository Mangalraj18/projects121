package com.yatra.runner;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.yatra.pageOfObjects.Flightb;
import com.yatra.pageOfObjects.homepage;
import com.yatra.pageOfObjects.verifies;
import com.yatra.reusablecomponents.reusabledriver;
import com.yatra.reusablecomponents.reusablemethods;
import com.yatra.utilities.ExcelReader;
import com.yatra.utilities.Propertyfilereader;
import com.yatra.utilities.logger;
public class Runner extends reusabledriver
{
	public static Logger log=LogManager.getLogger( Runner.class.getName());
	
   @BeforeSuite
   public void browserget()
   {
	   reusabledriver.chromedriver();
   }
   
   @BeforeTest
   @DataProvider
	public static Object[][] data() throws IOException
	{
		Object data[][]=ExcelReader.getexceldata(Propertyfilereader.getSheetName());
		return data;
	}
	@Test(priority =0)
	public void loadsite() throws InterruptedException
	{
		reusablemethods.loadurl(driver);		
	}
	
	@Test(priority =1, dataProvider="data")
	public void search(String searchKey, String pass) throws InterruptedException
	{
		boolean result=homepage.search(driver, searchKey,pass, log);
		try
		{
			Assert.assertTrue(result);
			logger.loginfo(log, "Flight details page success");
		}
		catch(AssertionError e)
		{
		  logger.logerror(log, "Some error happened in login page");
		}
	}
	
	@Test(priority =2)
	   public void landingpage()
		{
			boolean result=Flightb.book(driver, log);
			try
			{
				Assert.assertEquals(result, true);
			logger.loginfo(log, "Successfully landing page reached");
			}
			catch(AssertionError e)
			{
				logger.logerror(log, "Some error happened in landing page");
			}
		}
	
	
	@Test(priority=3)
	public void page()
	{
		boolean result=verifies.verifies(driver);
		try
		{
			Assert.assertEquals(result, true);
			logger.loginfo(log,"Title and all verified");
		}
		catch(AssertionError e)
		{
			logger.logerror(log, "Some error happened in  page");
		}
	}
	
	@AfterSuite
	public void end()
	{
	driver.quit();
	driver=null;
	}
	}