package com.php.tetcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.php.base.BaseTest;
import com.php.pages.HomePage;
import com.php.pages.LoginPage;

public class LoginPageTest extends BaseTest {
	
	LoginPage loginpage;
	HomePage homepage;
	

	
	
	@BeforeMethod
	public void setup() {
		initialzation();
		loginpage=new LoginPage();
		
	}
	
	@DataProvider(name="logindata")
	public  Object[][] getData(){
		return new Object[][] {
			{"user1","password1"},
			{"user2","password2"}
		};
		}
	
	@Test(dataProvider = "logindata")
	public void filllogindetails(String username,String Password) {
		System.out.println(username+Password);
	}
	
	
	@Test(priority = 1)
	public void pageTitleTest() {
		String title=loginpage.LoginPagetitle();
		Assert.assertEquals(title, "Existing User - Team.Do", "title not matched");
		
	}
//	@Test(priority = 2)
//public void LoginTest() {
//		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
//		
//	}
	
	@AfterMethod
	public void teardown() {
		BaseTest.destruct();
	}

}
