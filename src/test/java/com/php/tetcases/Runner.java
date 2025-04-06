package com.php.tetcases;

import org.testng.TestNG;

public class Runner {
	
	static TestNG testng;

	public static void main(String[] args) {
		
		testng = new TestNG();
		
		testng.setTestClasses(new Class[] {LoginPageTest.class});
	testng.run();

	}

}
