package com.lambdatest.demo.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.lambdatest.demo.driverfactory.DriverFactory;
import com.lambdatest.demo.pages.LTHomePage;
import com.lambdatest.demo.pages.LTLoginPage;




public class BaseTest {
	public DriverFactory df;
	public WebDriver driver;
	public Properties prop;
	public LTLoginPage loginpage;
	public LTHomePage homepage;
	
   		
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginpage = new LTLoginPage(driver);
		
		
	}
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
}
