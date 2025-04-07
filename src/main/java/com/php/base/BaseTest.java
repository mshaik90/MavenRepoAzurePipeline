package com.php.base;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.php.utility.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistner;
	
	
	
	public BaseTest()  {
		try {
			prop=new Properties();
		FileInputStream ip=new FileInputStream(".//src//main//java//com//php/config//config.properties"); 
		prop.load(ip);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public static void initialzation() {
		
		//String methodname=name.getName();
		String browser=prop.getProperty("browser");
		
		/*MutableCapabilities sauceOpts= new MutableCapabilities();
		//sauceOpts.setCapability("name", methodName);
		sauceOpts.setCapability("build", "Java-W3C-Examples");
		sauceOpts.setCapability("seleniumVersion", "3.141.59");
		sauceOpts.setCapability("username", "oauth-mohsin82374-c5d4f");
		sauceOpts.setCapability("accessKey", "6924fb4b-e09e-4587-beb2-bddbd5da65b1");
		sauceOpts.setCapability("tags", "w3c-chrome-tests");
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("sauce:options", sauceOpts);
		cap.setCapability("browserVersion","latest");
		cap.setCapability("platformName","windows 10");
	*/
		
		if(browser.equalsIgnoreCase("edge")) {
		//System.setProperty("webdriver.edge.driver", "C://Users//mohsi//Downloads//msedgedriver.exe");
	      WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
	     // cap.setCapability("browserName", "chrome");
	       
		}else if(browser.equalsIgnoreCase("chrome")) {
			
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohsi\\Downloads\\chromedriver_win32\\chromedriver.exe");
		    WebDriverManager.chromedriver().setup();  
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--headless");
		    options.addArguments("--disable-gpu");
		    options.addArguments("--no-sandbox");
		    options.addArguments("--disable-dev-shm-usage");
		    driver = new ChromeDriver(options);
		   // cap.setCapability("browserName", "edge");
		       
		}
		
		/*try {
			driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		*/
		e_driver= new EventFiringWebDriver(driver);
		eventlistner =new WebEventListener();
		e_driver.register(eventlistner);
		driver=e_driver;
		
		
		
		driver.manage().window().maximize();
	       driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       driver.get(prop.getProperty("url"));
	       
	}
	
	public static void destruct() {
		driver.quit();
	}

}
