package com.php.tetcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.php.base.BaseTest;
import com.php.pages.AdminPage;
import com.php.pages.ContactsPage;
import com.php.pages.HomePage;
import com.php.pages.LoginPage;

public class AdminPageTest extends BaseTest{

	
	
	LoginPage loginpage;
	HomePage homepage;
	AdminPage adminpage;
	ContactsPage contactspage;
	

	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialzation();
		loginpage=new LoginPage();
		adminpage=new AdminPage();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
		Thread.sleep(3000);
		
		
	}
	@Test(priority = 1)
	public void addAdminTest() {
		adminpage=homepage.clickOnAdminPage();
		adminpage.addAdmin("mohsin@gmail.com", "Admin");
		
	}
	
	
	@AfterMethod
	public void teardown() {
		BaseTest.destruct();
	}
}
