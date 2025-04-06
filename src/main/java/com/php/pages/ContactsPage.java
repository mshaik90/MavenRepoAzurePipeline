package com.php.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.php.base.BaseTest;

public class ContactsPage extends BaseTest{
	
	
	
	@FindBy(id="FirstName")
	WebElement company;
	
	@FindBy(name="Infos[0].Value")
	WebElement phone;
	
	
	@FindBy(name="Infos[1].Value")
	WebElement email;
	
	

	@FindBy(xpath ="//*[@id='txtNewContact']")
	WebElement newcontactbtn;
	

	@FindBy(xpath ="//div[@class='lnkGray_Small AddItem lnkDataBottom Hid']")
	WebElement addphonebtn;
	
	

	@FindBy(xpath ="//div[@contdataid='contDataEmails']")
	WebElement addemailbtn;
	
	@FindBy(id="btnSaveNewContact")
	WebElement addbtn;
	
	

	public ContactsPage createnewContact(String com, String phone,String email) {
		
		
		
		newcontactbtn.click();
		//driver.switchTo().frame(2);
		company.sendKeys(com);
		addphonebtn.click();
		addemailbtn.click();
		
		company.sendKeys(com);
		this.phone.sendKeys(phone);
		this.email.sendKeys(email);
		
		addbtn.click();
		return new ContactsPage();
		
		
	}
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	
	
	

}
