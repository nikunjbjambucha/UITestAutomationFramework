package Helpers;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelpers {
	public static String Screenshotpath = CreateDateTimeFolder();
    public static String Imagepath;
    static LocalDateTime today =  LocalDateTime.now();

	public static void captureScreenshot(WebDriver driver, String name) throws IOException {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dmmuuuu_hhmm");
		String Time = today.format(format);
		name = name + "_" + Time;
		Imagepath = name;
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(Screenshotpath+"\\"+name+".jpg");
		Imagepath = Screenshotpath+"\\"+name+".jpg";
		FileUtils.copyFile(SrcFile, DestFile);
		
	}
	
	 public static String CreateDateTimeFolder()
     {
         String OutputResultPath = System.getProperty("user.dir")+"\\Screenshots\\";
         OutputResultPath = OutputResultPath+DateHelpers.TodayDatenew() ;
         return OutputResultPath;
     }
}
