package com.php.tetcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.php.base.BaseTest;
import com.php.pages.ContactsPage;
import com.php.pages.HomePage;
import com.php.pages.LoginPage;

public class ContactsPageTest extends BaseTest{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	

	
	
	@BeforeMethod
	public void setup() {
		initialzation();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		contactspage=homepage.ClickOnContacts();
		
		
	}
	@Test(priority = 1)
	public void createNewContacttest() {
		contactspage=contactspage.createnewContact("atos","8237417125","mohsin@ggmail.com");
		
	}

	
	@AfterMethod
	public void teardown() {
		BaseTest.destruct();
	}

}
