package com.pageFactoryDemo.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "(//*[contains(text(),'Sign in')])[1]")
	WebElement pageSignInBtn;

	@FindBy(xpath = "//input[@name='session_key']")
	WebElement email;

	@FindBy(xpath = "(//*[contains(text(),'Sign in')])[3]")
	WebElement signInBtn;

	@FindBy(xpath = "//input[@name='session_password']")
	WebElement passwd;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSignIn()
	{
		signInBtn.click();
	}
	public void login(String username, String password)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	{
		email.sendKeys(username);
		clickSignIn();
		passwd.sendKeys(password);
	}
}	

