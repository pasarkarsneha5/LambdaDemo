package com.lambdatest.demo.tests;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lambdatest.demo.base.BaseTest;
import com.lambdatest.demo.pages.LTLoginPage;
import com.lambdatest.demo.utils.Constants;




public class LTLoginPageTest extends BaseTest {

//	ChromeOptions browserOptions = new ChromeOptions();
//	browserOptions.setPlatformName("Windows 10");
//	browserOptions.setBrowserVersion("110.0");
//	HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//	ltOptions.put("username", "sneha.pasarkar");
//	ltOptions.put("accessKey", "QtAW5uQhVNm7fcOvwDSeSn7CQcgDY53c2GUeGzr28ai5eIfGkc");
//	ltOptions.put("visual", true);
//	ltOptions.put("video", true);
//	ltOptions.put("build", "FM Demo1");
//	ltOptions.put("project", "FM Demo1");
//	ltOptions.put("name", "FM Login");
//	ltOptions.put("selenium_version", "4.0.0");
//	ltOptions.put("w3c", true);
//	browserOptions.setCapability("LT:Options", ltOptions);
	
	
	@Test(priority = 4)
	
	public void loginPageTitleTest() { 
		String fmTitle = loginpage.getLoginPageTitle();
		System.out.println("Page Title is :" + fmTitle);
		Assert.assertEquals(fmTitle, Constants.LOGIN_PAGE_TITLE);
	
		
	}
	@Test(priority = 3)
	public void loginPageUrlTest() {
		String fmUrl = loginpage.getLoginPageUrl(); 
		System.out.println("Login Url is :"+ fmUrl);
		Assert.assertTrue(fmUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));
		
	}
	@Test(priority = 1)
	public void ForgetPasswordLinkPresent() {
		Assert.assertTrue(loginpage.isForgetPasswordLinkPresent());
	
		
	}
	
	
	@Test(priority = 2)
	public void doLogin() {
		homepage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(homepage.getTitleOfThePage(), Constants.HOME_PAGE_TITLE);
		
	}
}
