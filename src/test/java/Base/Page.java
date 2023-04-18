package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class Page {
	public WebDriver driver;
    
    //Constructor
    public Page(WebDriver driver){
        this.driver = driver;
    }
    
    //JAVA Generics to Create and return a New Page
    public  <TPage extends basepage> TPage GetInstance (Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}