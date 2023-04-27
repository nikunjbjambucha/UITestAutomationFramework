package Testcase;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import com.google.common.primitives.Ints;
import com.relevantcodes.extentreports.LogStatus;
import Base.baseclass;
import DataProvider.*;
import Pages.DLPHomePage;

public class Testsuite1 extends baseclass{

	static ConfigFileReader configFileReader= new ConfigFileReader();;	
	public static String url = configFileReader.getPropertyvalue("url");
	public static String chromePath = configFileReader.getPropertyvalue("chromedriverPath");
	public static String DownloadPath = System.getProperty("user.dir")+configFileReader.getPropertyvalue("DownloadPath");
	
	@BeforeClass
	public static void TestInitialize() throws Exception {
		ExtentManager();
		//DBConnection.DBconnection();
	}
	
	public static void OpenBrowser(BrowserType browserType) {
		switch (browserType) {
			
			case Chrome:
				// declaration and chromedriver
				
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--remote-allow-origins=*");
				
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("download.default_directory", DownloadPath);
				option.setExperimentalOption("prefs", prefs);
				
				
				System.setProperty("webdriver.chrome.driver",chromePath);
				driver = new ChromeDriver(option);
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		        test.log(LogStatus.PASS, "Open Browser", "Browser has been opened ");
		}
		
	}

	@Test(enabled=false)
	public void test1() 
	{
		try
		{
			test = extent.startTest("Test case 1");
			OpenBrowser(BrowserType.Chrome);
            GotoUrl(url);
            currentpage.GetInstance(DLPHomePage.class).Search_collection();
            
            System.out.println("Test Completed successfully");
    		test.log(LogStatus.PASS, "Test case 1", "Pass");
    		
		}
		
		catch(Exception ex) 
		{
			ex.toString();
            System.out.println("Test case got failed as: "+ex);
            test.log(LogStatus.FAIL, "Test case got fail ", ex);
		}
		
	}
	
	@Test(enabled=false)
	public void test2() 
	{
		try
		{
			test = extent.startTest("Test case 2");
			String[] ParameterName = { "DealId", "Strike", "BaseCurrencyAbbreviation", "TermCurrencyAbbreviation", "DeliveryDate", "TradeID", "NotionalCurrency", "Cut"};  
			DBConnection.GetDataFromDB(ParameterName,"10107");
			
			
			String DealId = DBConnection.Getvalue("DealId");
			System.out.println("value of deal id is: "+ DealId);

			String Strike = DBConnection.Getvalue("Strike");
			System.out.println("value of Strike id is: "+ Strike);
			
			String DeliveryDate = DBConnection.Getvalue("DeliveryDate");
			System.out.println("value of DeliveryDate id is: "+ DeliveryDate);
			
			
			
            System.out.println("Test Completed successfully");
    		test.log(LogStatus.PASS, "Test case 2", "Pass");
    		
		}
		
		catch(Exception ex) 
		{
			ex.toString();
            System.out.println("Test case got failed as: "+ex);
            test.log(LogStatus.FAIL, "Test case got fail ", ex);
		}
		
	}
	
	@Test
	public void test3() 
	{
		try
		{
			test = extent.startTest("Test case 3");
			OpenBrowser(BrowserType.Chrome);
            GotoUrl("http://xcal1.vodafone.co.uk/");
            currentpage.GetInstance(DLPHomePage.class).DownloadFile();
			
            System.out.println("Test Completed successfully");
    		test.log(LogStatus.PASS, "Test case 3", "Pass");
    		
		}
		
		catch(Exception ex) 
		{
			ex.toString();
            System.out.println("Test case got failed as: "+ex);
            test.log(LogStatus.FAIL, "Test case got fail ", ex);
		}
		
	}
	
	
	@AfterMethod
	public void TeardownTest() {	
		//Close the driver
		driver.close();
		driver.quit();
		extent.endTest(test);
	}
	
	@AfterClass
	public static void ClassCleanup() {	
		extent.flush();
		extent.close();
	}

}
