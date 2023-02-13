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


//	@Test(priority = 4)
//	
//	public void loginPageTitleTest() { 
//		String fmTitle = loginpage.getLoginPageTitle();
//		System.out.println("Page Title is :" + fmTitle);
//		Assert.assertEquals(fmTitle, Constants.LOGIN_PAGE_TITLE);
//	
//		
//	}
//	@Test(priority = 3)
//	public void loginPageUrlTest() {
//		String fmUrl = loginpage.getLoginPageUrl(); 
//		System.out.println("Login Url is :"+ fmUrl);
//		Assert.assertTrue(fmUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));
//		
//	}
//	@Test(priority = 1)
//	public void ForgetPasswordLinkPresent() {
//		Assert.assertTrue(loginpage.isForgetPasswordLinkPresent());
//	
//		
//	}
	@Test(priority = 1)
	public void enterOrg() {
		loginpage.enterOrg(prop.getProperty("orgname").trim());
	}

	@Test(priority = 2)
	public void doLogin() {
		homepage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(homepage.getTitleOfThePage(), Constants.HOME_PAGE_TITLE);
		
	}
}
