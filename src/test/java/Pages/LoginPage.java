package Pages;

import static org.testng.Assert.assertTrue;

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

public class LoginPage extends basepage{
	
	public ExtentTest test;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.test = baseclass.test;
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.ID, using = "user-name") 
	private WebElement UserName;
	
	@FindBy(how = How.ID, using = "password") 
	private WebElement Password;
	
	@FindBy(how = How.ID, using = "login-button") 
	private WebElement LoginButton;
	
	@FindBy(how = How.XPATH, using = ".//button[contains(text(),'Open Menu')]") 
	private WebElement Navbar;
	
	@FindBy(how = How.ID, using = "logout_sidebar_link") 
	private WebElement Logoutbutton;

	public void GetLogin(TestDataRowTitle testdata ) throws InterruptedException
	{
		UserName.sendKeys(testdata.Username);
		Password.sendKeys(testdata.Password);
		LoginButton.click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Enter Username and Password ", "Username and Password enterd");
	}
	
	public void VerifyLogin_standard_user() throws InterruptedException {
		Thread.sleep(2000);
		Navbar.click();
		Thread.sleep(1000);
		assertTrue(Logoutbutton.isDisplayed());
		test.log(LogStatus.PASS, "Verify User is logged in", "User is logged in verified");
	}
	
	@FindBy(how = How.XPATH, using = ".//h3[contains(text(),'Epic sadface')]") 
	private WebElement ErrorMessage;
	
	public void VerifyLogin_locked_user() throws InterruptedException {
		Thread.sleep(2000);
		Thread.sleep(1000);
		assertTrue(ErrorMessage.isDisplayed());
		test.log(LogStatus.PASS, "Verify Locked User is not logged in", "Locked User is not logged in and got error message as: "+ErrorMessage.getText());
	}
	
	
	
	
}
