package Testcase;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.LogStatus;
import Base.baseclass;
import DataProvider.*;
import Helpers.ScreenshotHelpers;
import Pages.*;

public class Testsuite1 extends baseclass{

	static ConfigFileReader configFileReader= new ConfigFileReader();
	public static String url = configFileReader.getPropertyvalue("url");
	public static String chromePath = configFileReader.getPropertyvalue("chromedriverPath");
	public static String DownloadPath = System.getProperty("user.dir")+configFileReader.getPropertyvalue("DownloadPath");
	public static String Screenshotspath = System.getProperty("user.dir")+configFileReader.getPropertyvalue("Screenshotpath");
	
	
	@BeforeClass
	public static void TestInitialize() throws Exception {
		ExtentManager();
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


	@Test()
	public void Login_standard_user() 
	{
		try
		{
			test = extent.startTest("Login with standard user Test case");
			OpenBrowser(BrowserType.Chrome);
			String filename = "TestData1";
			TestDataRowTitle testdata = ReadCSV.TestData(filename);
            GotoUrl(url);
            currentpage.GetInstance(LoginPage.class).GetLogin(testdata);
            currentpage.GetInstance(LoginPage.class).VerifyLogin_standard_user();
            
            System.out.println("Login with standard use Test Completed successfully");
    		test.log(LogStatus.PASS, "Login with standard use Test Completed successfully", "Pass");
    		
		}
		
		catch(Exception ex) 
		{
			ex.toString();
            System.out.println("Test case got failed as: "+ex);
            test.log(LogStatus.FAIL, "Test case got fail ", ex);
		}
		
	}
	
	@Test()
	public void Login_locked_user() 
	{
		try
		{
			test = extent.startTest("Login with locked user Test case");
			OpenBrowser(BrowserType.Chrome);
			String filename = "TestData2";
			TestDataRowTitle testdata = ReadCSV.TestData(filename);
            GotoUrl(url);
            currentpage.GetInstance(LoginPage.class).GetLogin(testdata);
            currentpage.GetInstance(LoginPage.class).VerifyLogin_locked_user();
            ScreenshotHelpers.captureScreenshot(driver, "Login_locked_user");
            test.log(LogStatus.INFO,"Screenshot",test.addBase64ScreenShot(ScreenshotHelpers.Imagepath));
            
            System.out.println("Login with locked use Test Completed successfully");
    		test.log(LogStatus.PASS, "Login with locked use Test Completed successfully", "Pass");
    		
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
