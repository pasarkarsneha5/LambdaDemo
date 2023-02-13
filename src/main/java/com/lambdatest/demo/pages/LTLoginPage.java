package com.lambdatest.demo.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lambdatest.demo.utils.Constants;
import com.lambdatest.demo.utils.ElementUtil;




public class LTLoginPage {

	//1.Declare private driver
		private WebDriver driver;
		public ElementUtil eleUtil;
		
		//3. By locators: OR
		
		//private By email = By.xpath("//input[@type='email']");
		private By orgname = By.id("Name");
		private By saveorgname = By.id("btn-tenant-confirm");
		private By email = By.id("Request_Email");
		private By password = By.xpath("//input[@type='password']");
		private By loginButton = By.xpath("//button[@id='btn-identity-confirm']");
		
		
		//2. constructor of the page class
		
		public LTLoginPage(WebDriver driver) {
			this.driver= driver;
			eleUtil = new ElementUtil(driver);
		}
		
		//4. page actions:features of page in the form of methods
		
		public String getLoginPageTitle() {
			return eleUtil.waitForTitlePresent(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
			
		}
		
		public String getLoginPageUrl() {
			return driver.getCurrentUrl();
			}
		public void enterOrg(String org)
		{
			eleUtil.doSendKeys(orgname, org);
			eleUtil.doClick(saveorgname);
		}
				
		public LTHomePage doLogin(String un, String pwd) {
			
			eleUtil.doSendKeys(email, un);
			eleUtil.doSendKeys(password, pwd);
			eleUtil.doClick(loginButton);
			return new LTHomePage(driver);
			
			
		}
}
