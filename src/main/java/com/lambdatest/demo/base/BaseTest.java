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
	
	public String username = "sneha.pasarkar";
    public String accesskey = "QtAW5uQhVNm7fcOvwDSeSn7CQcgDY53c2GUeGzr28ai5eIfGkc";
    public static RemoteWebDriver driver1 = null;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
 
@BeforeTest
//@Parameters("browser")


public void setUp(String browser) throws Exception {
	
	df = new DriverFactory();
	prop = df.init_prop();
	driver = df.init_driver(prop);
	loginpage = new LTLoginPage(driver);
	
 
        DesiredCapabilities capabilities = new DesiredCapabilities();
 
        if (browser.equalsIgnoreCase("Chrome")) {
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("version", "93.0");
                capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
                capabilities.setCapability("build", "LoginTest");
                capabilities.setCapability("name", "LoginTestInChrome");
        }
        else if (browser.equalsIgnoreCase("Firefox")) {
                capabilities.setCapability("browserName", "Firefox");  //To specify the browser
                capabilities.setCapability("version", "76.0");    //To specify the browser version
                capabilities.setCapability("platform", "win10");      // To specify the OS
                capabilities.setCapability("build", "LoginTest");  //To identify the test
                capabilities.setCapability("name", "LoginTestInFirefox");
        }
        try {
        	driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
                System.out.println("Invalid grid URL");
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
 
}
      		
//	@BeforeTest
//	public void setup() {
//		df = new DriverFactory();
//		prop = df.init_prop();
//		driver = df.init_driver(prop);
//		loginpage = new LTLoginPage(driver);
		
		
//	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
