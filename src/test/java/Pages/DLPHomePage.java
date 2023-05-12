package Pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.baseclass;
import Base.basepage;
import DataProvider.ReadExcel;
import DataProvider.TestDataRowTitle;

public class DLPHomePage extends basepage{
	
	public ExtentTest test;
	
	public DLPHomePage(WebDriver driver) {
		super(driver);
		this.test = baseclass.test;
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.ID, using = "navbarDropdown") 
	private WebElement MordernUploadMethods;
	
	@FindBy(how = How.XPATH, using = ".//div[@id='navbarNav']/ul/li[1]/ul/li[1]") 
	private WebElement WebSocket;
	
	@FindBy(how = How.XPATH, using = ".//div[@id='navbarNav']/ul/li[1]/ul/li[2]") 
	private WebElement HTML;
	
	@FindBy(how = How.XPATH, using = ".//div[@id='navbarNav']/ul/li[1]/ul/li[3]") 
	private WebElement JQUERY;
	
	
	public void Search_collection() {	
		Assert.assertTrue(MordernUploadMethods.isDisplayed());
		MordernUploadMethods.click();	
		test.log(LogStatus.PASS, "MordernUploadMethods", "MordernUploadMethods clicked");
	}
	
	
	/*----------------------Dummy path for check download locations-------------------------*/
	
	@FindBy(how = How.XPATH, using = ".//table[@class='dltable']/tbody/tr[16]/td/a") 
	private WebElement ExtreaSmalFile;
	
	public void DownloadFile() throws InterruptedException {	
		Assert.assertTrue(ExtreaSmalFile.isDisplayed());
		ExtreaSmalFile.click();	
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Click on download", "clicked on download");
	}
	
	/*-----------------------Check Data from excel file----------------------------------------*/
	@FindBy(how = How.ID, using = "txtUserName")
	private WebElement Username;

	@FindBy(how = How.ID, using = "txtPassword")
	private WebElement Password;

	@FindBy(how = How.ID, using = "btnSave")
	private WebElement Submit;

	public void GetLogin() throws InterruptedException
	{
		String UserName = ReadExcel.getData(0,1,0);
		String PassWord = ReadExcel.getData(0,1,1);
		Username.sendKeys(UserName);
		Password.sendKeys(PassWord);
		Submit.click();
		Thread.sleep(10000);
	}
	
	public void GetLogin(TestDataRowTitle testdata ) throws InterruptedException
	{
		Username.sendKeys(testdata.Username);
		Password.sendKeys(testdata.Password);
		Submit.click();
		Thread.sleep(10000);
	}
	
	
	
	
}
