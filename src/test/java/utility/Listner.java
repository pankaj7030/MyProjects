package utility;


import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listner extends TestListenerAdapter {
	
	public ExtentSparkReporter htmlReporter;					
	public ExtentReports extent;
	public ExtentTest test;
	

	public void onStart(ITestContext textContext) {
		
		//Specify location
	    htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/myReports.html");
		
		htmlReporter.config().setDocumentTitle("API AUTOMATION");//Title of report
		htmlReporter.config().setReportName("Rest Api Testing");//Name of report
		
		htmlReporter.config().setTheme(Theme.DARK);
		
	    extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project Name", "Employee database Api");
		extent.setSystemInfo("Host Name", "LocalHost");
		extent.setSystemInfo("Enviornment","QA");
		extent.setSystemInfo("user", "Pankaj");
	}
	public void onTestSuccess(ITestResult res) {
		test = extent.createTest(res.getName());
		test.log(Status.PASS,"Test case Pass is"+res.getName());
	}
	public void onTestFailure(ITestResult res) {
		test=extent.createTest(res.getName());
		test.log(Status.FAIL,"Test case failure is"+ res.getName());
	}
	public void onTestSkipped(ITestResult res) {
		test=extent.createTest(res.getName());
		test.log(Status.SKIP,"Test case Skip is"+ res.getName());
	}
	public void onFinish(ITestResult res) {
		extent.flush();
	}
}
