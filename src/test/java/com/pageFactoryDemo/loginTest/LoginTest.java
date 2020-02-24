package com.pageFactoryDemo.loginTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageFactoryDemo.loginPage.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	public WebDriver driver;
	LoginPage loginObj=null;

	@BeforeMethod()
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}

	@Test
	public void Login() {
		loginObj = new LoginPage(driver);
        loginObj.login("rashmi@gmail.com", "Rashmi123");  
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
