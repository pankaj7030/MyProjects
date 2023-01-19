package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import configuration.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;

		public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
	    report=new ExtentReports("F:\\S\\B\\TestingAutomation\\Reports\\reports.html",true);
		test=report.startTest("Extent report demo");
		driver.get(Configuration.url);
	}
}
