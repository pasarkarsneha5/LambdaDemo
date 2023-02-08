package com.lambdatest.demo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lambdatest.demo.base.BaseTest;
import com.lambdatest.demo.utils.Constants;


public class LTHomePageTest extends BaseTest{

	@BeforeClass 
	public void FMHomePage() {
		 homepage = loginpage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
	@Test
	public void homePageTitle() {
		String homeTitle = homepage.getTitleOfThePage();
		System.out.println("The Homepage Title is :"+ homeTitle);
		Assert.assertEquals(homeTitle, Constants.HOME_PAGE_TITLE);
	}
	@Test
	public void checkUsername() {
		homepage.clickOnUserNameMenu();
	}
	@Test
	public void signOut() {
		homepage.clickOnSignout();
	}
}
