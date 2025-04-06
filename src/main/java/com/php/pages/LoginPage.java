package com.php.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.php.base.BaseTest;

public class LoginPage extends BaseTest{
	
	
	@FindBy(name="ctl00$ContentPlaceHolder1$tbxEmail")
	WebElement username;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$tbxPassword")
	WebElement password;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$btnLogin")
	WebElement loginbtn;
	
	@FindBy(xpath="//button[@id='forgotpassword']")
	WebElement forgotPassword;

	
	public String LoginPagetitle() {
		return driver.getTitle();
		
		
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
}
