package globalSQL;

import java.time.Duration;

import org.openqa.selenium.By;
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

import baseClasses.BaseClass;
import configuration.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01_ValidationPage {

	static WebDriver driver;
	public static ExtentReports report;
	public ExtentTest test;
	@BeforeClass
	public void launch_Browser() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
	    report=new ExtentReports("F:\\S\\B\\TestingAutomation\\Reports\\reports.html",true);
		test=report.startTest("Extent report demo");
		driver.get(Configuration.url);
	
	}
	@Test
	public void validate_pageTitle() {
		String title=driver.getTitle();
		test.log(LogStatus.INFO, title);
		Assert.assertEquals(title,"Testing Demo Site | Practice Website For Automation - Global SQA");
		test.log(LogStatus.PASS, "page get verified");
	}
	@Test
	public void verifyText() {
		test.log(LogStatus.INFO,"text of the image verification");
		WebElement t=driver.findElement(By.xpath("//ul/li[@id='menu-item-1513']"));
		String text = t.getText();
		Assert.assertEquals(text,"HOME" );
		test.log(LogStatus.PASS, text);
		
	}
	@Test
	public void verifyCurrentURL() {
		test.log(LogStatus.INFO,"Get current url Started to verify");
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.globalsqa.com/demo-site/");
		test.log(LogStatus.PASS, url);
	}
	@AfterClass
    public void tearDown() {
		driver.close();
		report.endTest(test);
		report.flush();
	}
}
