package com.lambdatest.demo.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
