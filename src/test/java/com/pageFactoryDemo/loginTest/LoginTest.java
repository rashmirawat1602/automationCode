package com.pageFactoryDemo.loginTest;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PgeFactoryExtentReport.ExtentReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pageFactoryDemo.loginPage.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends ExtentReport {
	public WebDriver driver;
	LoginPage loginObj=null;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void setupExtentReport() {
		extent = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/testExtentReport.html");
		extent.attachReporter(htmlReporter);

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		// htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		// htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}	
	
	@BeforeMethod()
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.linkedin.com/home");
	}

	@Test
	public void Login() {
		test = extent.createTest("Test Case 1", "Passed TC");
		loginObj = new LoginPage(driver);
        loginObj.login("rashmi.rawat.1602@gmail.com", "Summer1991");  
        Assert.assertTrue(true);
	}
	
	@Test
	public void Login1() {
		test = extent.createTest("Test Case 2", "Failed TC");
		loginObj = new LoginPage(driver);
        loginObj.login("rashmi@gmail.com", "Rashmi123");  
        Assert.assertTrue(false);
        System.out.println("TC failed");
	}
	
	@Test
	public void Login3() {
		test = extent.createTest("Test Case 3", "Passed TC");
		loginObj = new LoginPage(driver);
        loginObj.login("rashmi.rawat.1602@gmail.com", "Summer1991");  
        Assert.assertTrue(true);
        System.out.println("TC passed");
	}

	@AfterMethod()
	public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
        driver.close();
    }
	
	@AfterTest
	public void tearDown() {
		extent.flush();
	}

}
