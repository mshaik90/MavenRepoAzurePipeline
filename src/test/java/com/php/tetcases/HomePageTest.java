package com.php.tetcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.php.base.BaseTest;
import com.php.pages.ContactsPage;
import com.php.pages.HomePage;
import com.php.pages.LoginPage;

public class HomePageTest extends BaseTest {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	

	
	
	@BeforeMethod
	public void setup() {
		initialzation();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}
	@Test(priority = 1)
	public void contactsPageTest() {
		contactspage=homepage.ClickOnContacts();
		
	}

	
	@AfterMethod
	public void teardown() {
		BaseTest.destruct();
	}


}
