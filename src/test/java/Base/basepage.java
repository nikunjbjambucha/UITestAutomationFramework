package Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;

public class basepage extends Page {
	JavascriptExecutor js;
	
	public basepage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	     js = (JavascriptExecutor) driver;
	}

	
}
