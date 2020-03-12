package com.pageFactoryDemo.loginTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GitHubStatus {
	
	WebDriver driver;
	
	@BeforeMethod()
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.githubstatus.com");
	}
	
	@Test
	public void getImpactedDay()
	{
		String str = "Git Operations";
		List<WebElement> category = driver.findElements(By.xpath("//*[@class='component-inner-container status-green showcased']/span[@class='name']"));
	    int index=0; 
	    int counter=0; 
		for(int i =0 ;i<category.size();i++)
		{
			if(category.get(i).getText().contains(str))
			{
				index=i+1;
			    break;
			}
		}
		System.out.println("Category "+str+ " is present at "+index+ " index");
		Actions action = new Actions(driver);
		List<WebElement> individuaBars = driver.findElements(By.xpath("(//*[@class='availability-time-line-graphic'])["+index+"]/*"));
		for(int i = 0; i< individuaBars.size(); i++)
		{
			if(!(individuaBars.get(i).getAttribute("fill").contains("#28a745")))
					{
					action.moveToElement(individuaBars.get(i));
					action.build().perform();
					System.out.println(driver.findElement(By.xpath("//*[@class='tooltip-content']//div[@class='date']")).getText());
					counter++;
					}
		}
		System.out.println("Number of days impacted :"+counter);
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
