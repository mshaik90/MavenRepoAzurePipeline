  package com.php.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.php.base.BaseTest;

public class HomePage extends BaseTest{
	@FindBy(xpath="//*[@id=\"tabContacts\"]/span")
	WebElement contactslink;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$tbxPassword")
	WebElement password;
	
	@FindBy(name="ctl00$ContentPlaceHolder1$btnLogin")
	WebElement loginbtn;
	
	@FindBy(xpath="//span[@class='mainTab contMainTab Float contMainTabSel']")
	WebElement adminlink;
	

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public ContactsPage ClickOnContacts() {
		contactslink.click();
		return new ContactsPage();
	}
	
	public AdminPage clickOnAdminPage() {
		adminlink.click();
		return new AdminPage();
	}
	

	
	
}
