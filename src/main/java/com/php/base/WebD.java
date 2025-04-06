package com.php.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebD {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		
		driver.get("http://www.google.com");
		
		
	}

}
