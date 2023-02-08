package com.lambdatest.demo.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.lambdatest.demo.driverfactory.DriverFactory;
//import org.xml.sax.Locator;



public class ElementUtil {

	private WebDriver driver;
	private JavaScriptUtil jsUtil;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil = new JavaScriptUtil(driver);
	}
	
	/**
	 * This method is used to create webelement on basis of By locator
	 * @param locator
	 * @return
	 */
	
	public WebElement getElement(By locator) {
		WebElement element = null;
		element = driver.findElement(locator);
		if(Boolean.parseBoolean(DriverFactory.highlight)) {
			jsUtil.flash(element);
		}
		return element;
	}
	public void getElements(By locator , String value) {
		List<WebElement> list = driver.findElements(locator);
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains(value)) {
				list.get(i).click();
				break;
			}
		}
	}
	public void doClick (By locator) {
		getElement(locator).click();
	}
	public void doSendKeys(By locator, String value) {
		doClear(locator);
		getElement(locator).sendKeys(value);
	}
	
	public void clickEnterBtn(By locator)
	{
		getElement(locator).sendKeys(Keys.ENTER);
	}
	public boolean doDisplayed(By locator) {
	 return	getElement(locator).isDisplayed();		
	}
	public void doClear(By locator) {
		 getElement(locator).clear();
	}
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	public void doClickOnReady(By locator, int timeOut) {
		waitForElementToBeClickable(locator, timeOut).click();
	}
	
	public void takePageScreenshot(WebDriver driver, String filename) {
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile, new File("./target/screenshot/"+filename+ ".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * Actions Utils
	 **/
	
	public void doActionSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		WebElement element = getElement(locator);
		action.sendKeys(element, value).perform();
	}
	
	public void doActionClick(By locator) {
		Actions action = new Actions(driver);
		WebElement element = getElement(locator);
		action.sendKeys(element).perform();
	}
	public WebElement doClickElement (WebDriver driver, String locator) {
		WebElement element = null;
		Actions actions = new Actions(driver);
		//element = driver.findElement(locator);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();//press enter
		return element;
		}
	
		
	
	/**
	 * Wait methods
	 **/
	public WebElement doVisibilityOfElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}
	
	public WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return getElement(locator);
	}
	
	public String waitForTitlePresent(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	 public WebElement waitForElementToBeClickable(By locator, int timeOut) {
		 WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			return getElement(locator);
	 }
	 
	 public WebElement waitForElementToBeVisibilityLocated(By locator, int timeOut) {
		 WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return getElement(locator);
	 }
	 
	 public WebElement waitForElementToBeVisible(By locator, int timeOut) {
		WebElement element = getElement(locator);
		 WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOf(element));
			return getElement(locator);
	 }
	 public List<WebElement> waitForElementsToBeVisible(By locator, int timeOut) {
			WebElement element = getElement(locator);
			 WebDriverWait wait = new WebDriverWait(driver, timeOut);
				wait.until(ExpectedConditions.visibilityOf(element));
				return getElements(locator);
		 }
	 
	 public Boolean invisibilityOfElementLocatedBy(By locator, int timeOut)
		{
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		}
	 
	private List<WebElement> getElements(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	  * this method is used to select multiple values in dropdown
	  * @param driver
	  * @param value
	  */
		public static void selectChoiceValue(WebDriver driver, String... value){
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='comboTreeDropDownContainer']//ul//li//span[@class='comboTreeItemTitle']"));
			
			if(!value[0].equalsIgnoreCase("ALL")) {
				for (int i =0; i<list.size(); i++) {
					System.out.println(list.get(i).getText());
					String text =list.get(i).getText();
					 
					for (int k =0; k<value.length; k++) { // this is to array 
						if(text.equals(value[k])) {
							list.get(i).click();
							break;
						}
					}
				}
			}
			// this code is for selection of all values
			else {
				try {
				for(int all=0; all<list.size(); all++) {
					list.get(all).click();
				}
			}
				catch (Exception e){
				}
			}
		}
		public void selectDropDownValueWithoutSelect(By locator, String value) {
			List<WebElement> optionsList = getElements(locator);
			System.out.println(optionsList.size());
			for (WebElement e : optionsList) {
				String text = e.getText();
				if (text.equals(value)) {
					e.click();
					break;
				}
			}
		}
//		public static void SelectDropdownWithoutSelect(WebDriver driver , String locator, String value) {
//			List<WebElement> dayslist = driver.findElements(By.xpath(locator));
//			System.out.println(dayslist.size());
//			
//			for(int i=0; i<dayslist.size();i++) {
//				String days = dayslist.get(i).getText();
//				System.out.println(days);
//				
//				if(days.equals(value)) {
//					dayslist.get(i).click();
//					break;
//				}
//			}
//		}
		public void doSelectDropDownByIndex(By locator, int index) {
			Select select = new Select(getElement(locator));
			select.selectByIndex(index);
			}

		public void doSelectDropDownByVisibleText(By locator, String text) {
			Select select = new Select(getElement(locator));
			select.selectByVisibleText(text);
		}

		public void doSelectDropDownByValue(By locator, String value) {
			Select select = new Select(getElement(locator));
			select.selectByValue(value);
		}
		
//		public static void selectDropdownValue(By locator, String type, String value) {
//			Select select = new Select(getElement(locator));
//		}
		public void printDropDownOptions(By locator) {
			getDropDownOptions(locator).stream().forEach(new Consumer<String>() {
				public void accept(String e) {
					System.out.println(e);
				}
			});
		}
		public List<String> getDropDownOptions(By locator) {
			Select select = new Select(getElement(locator));
			List<WebElement> optionsList = select.getOptions();
			List<String> optionsTextList = new ArrayList<String>();

			for (WebElement e : optionsList) {
				optionsTextList.add(e.getText());
			}
			return optionsTextList;
		}
		/**
		 * select date
		 */
	      public  void selectDate(WebDriver driver, String day, By locator) {
	    	  List<WebElement> dateList = driver.findElements(locator);
	    	  for (WebElement e: dateList) {
	    	  String date= e.getText();
	    	  if(date.equals(day)) {
	    			  e.click();
	    			  break;
	    		  }
	    	  }
	      }
	      public void selectValueFromCustomSelect(By dropDownLocator, By listLocator, By listFirstEleLocator, String value) {
	  		doClick(dropDownLocator);
	  		
	  		doPresenceOfElementLocated(listFirstEleLocator, Constants.DEFAULT_TIMEOUT);
	  		//waitForVisibilityOfElements(listFirstEleLocator, Constants.DEFAULT_TIMEOUT);
	  		waitForVisibilityOfElements(listFirstEleLocator, Constants.DEFAULT_TIMEOUT);
	  		List<WebElement> listOfOptions = getElements(listLocator);
	  		
	  		for (int i = 0; i < listOfOptions.size(); i++) {
	  			if (listOfOptions.get(i).getText().equals(value)) {
	  				listOfOptions.get(i).click();
	  				break;
	  			}
	  		}
	  	}
	      public WebElement doPresenceOfElementLocated(By locator, int timeOut) {
	  		WebDriverWait wait = new WebDriverWait(driver, timeOut);
	  		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	  	}
	      public List<WebElement> waitForVisibilityOfElements(By locator, int timeOut) {
	  		WebDriverWait wait = new WebDriverWait(driver, timeOut);
	  		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	  	}
	      
	    public void selectcomboboxdata(By dropdownlocator, By listlocator, int timeOut, String value) {
	    	doClear(dropdownlocator);
			getElement(dropdownlocator).sendKeys(value);
			doVisibilityOfElement(listlocator, timeOut); 
			clickEnterBtn(dropdownlocator);
				
	    }
	     
	     public void openAlert(WebDriver driver, By locator) {
	    	 Alert alert= driver.switchTo().alert();
	    	 alert.accept();
	     }
	     

	}

