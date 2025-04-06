package com.php.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.php.base.BaseTest;

public class AdminPage extends BaseTest{
	
	
	
	@FindBy(xpath="//span[@class='mainTab contMainTab Float contMainTabSel']")
	WebElement adminlink;
	
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_tbxEmail\"]")
	WebElement emailfield;
	
	@FindBy(xpath="//span[@id='select2-chosen-6']")
	WebElement admindropdown;
	
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$btnSubmitEmail']")
	WebElement submitbtn;
	

	public AdminPage() {
		PageFactory.initElements(driver, this);
	}

	
//	public void clickOnAdminPage() {
//		adminlink.click();
//		//return new AdminPage();
//	}
	
	
	public AdminPage addAdmin(String email, String role) {
		//adminlink.click();
		emailfield.sendKeys(email);
		Select select = new Select(admindropdown);
		select.selectByVisibleText(role);
		submitbtn.click();
		return new AdminPage();
		
	}
	

}
