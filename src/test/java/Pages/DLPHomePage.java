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
	
}
