package Testcase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import Base.baseclass;
import DataProvider.ConfigFileReader;
import Pages.DLPHomePage;

public class Testsuite1 extends baseclass{

	static ConfigFileReader configFileReader= new ConfigFileReader();;	
	public static String url = configFileReader.getPropertyvalue("url");
	public static String chromePath = configFileReader.getPropertyvalue("chromedriverPath");
	
	@BeforeClass
	public static void TestInitialize() {
		ExtentManager();
	}
	
	public static void OpenBrowser(BrowserType browserType) {
		switch (browserType) {
			
			case Chrome:
				// declaration and chromedriver
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--remote-allow-origins=*");
				System.setProperty("webdriver.chrome.driver",chromePath);
				driver = new ChromeDriver(option);
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		        System.out.println("Browser has been opened");
		        test.log(LogStatus.PASS, "Open Browser", "Browser has been opened ");
		}
		
	}

	@Test
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
