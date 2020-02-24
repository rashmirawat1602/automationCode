package com.pageFactoryDemo.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	String mailID;
	String pwd;

	@FindBy(xpath = "//*[contains(text(),'Sign in')]")
	WebElement signInBtn;
	
	@FindBy(xpath="(//*[contains(text(),'Use another account')])[2]")
	WebElement useAnotherAccount;

	@FindBy(xpath = "//input[@type='email']")
	WebElement email;

	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextButon;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwd;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setEmail(String email) {
		this.mailID = email;
	}

	public void setPassword(String password) {
		this.pwd = password;
	}

	public void signIn() {
		signInBtn.click();
	}
	
	public void useAnotherAcc()
	{
		useAnotherAccount.click();
	}

	public void clickNext() {
		nextButon.click();
	}

	public void login(String username, String password) {
		signIn();
	//	useAnotherAcc();
		email.sendKeys(username);
		clickNext();
		passwd.sendKeys(password);
	}
}
