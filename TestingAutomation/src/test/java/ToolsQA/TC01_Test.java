package ToolsQA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import configuration.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01_Test {

	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	
	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		report=new ExtentReports("F:\\S\\B\\TestingAutomation\\Reports\\toolsQAReport.html",true );
		test=report.startTest("Automation testing ToolQA");
		driver.get(Configuration.toolsQA);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void verifyTitle() {
		Reporter.log("Verification started",true);
		String title=driver.getTitle();
		Assert.assertEquals(title, "ToolsQA");
	}
	@Test
	public void verifyTextofElements() {
		WebElement text=driver.findElement(By.xpath("//div[@class='header-text'][1]"));
		System.out.println(text);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		report.endTest(test);
		report.flush();
	}
	
	
}
