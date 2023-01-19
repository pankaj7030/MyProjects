package globalSQL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import configuration.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Pomclasses;

public class TC02_tabs {

	static WebDriver driver;
	public static ExtentReports report;
	public ExtentTest test;
	public Pomclasses pom;
	@BeforeClass
	public void launch_Browser() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    pom=new Pomclasses(driver);
		driver.manage().window().maximize();
	    report=new ExtentReports("F:\\S\\B\\TestingAutomation\\Reports\\reports.html",true);
		test=report.startTest("Extent report demo");
		driver.get(Configuration.url);
	
	}
	@Test
	public void verifySectionText() {
		pom.clickTab();
		pom.clickOnSection();
	    pom.getText();
	}
	
	@AfterClass
    public void tearDown() {
		driver.close();
		report.endTest(test);
		report.flush();
	}
}


