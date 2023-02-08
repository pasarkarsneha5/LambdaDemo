package com.lambdatest.demo.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
	private static WebDriver driver;
	public String arguments;
	
	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
	}
	
//	public static void clickElementByJs(WebElement element, WebDriver driver) {
//		JavascriptExecutor js = ((JavascriptExecutor)driver);
//		js.executeScript("document.getElementById('\" + id +\"').value = \"+ value+ \", element);
//	}
	
	public static void refreshBrowserByJs(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	
	public static String getBrowserInfo(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String uagent = js.executeScript("return navigator.userAgent").toString();
		return uagent;
	}
	
	public static void sendkeysUsingJsWithId(WebDriver driver, String id, String value) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("document.getElementById('" + id +"').value = "+ value+ "");
	}
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red", element);
	}
	
	public static void flash(WebElement element) {
		String Bgcolor = element.getCssValue("backgroundcolor");
		for (int i=0; i < 3; i++) {
			changeColor("rgb(0,200,0)", element);
			changeColor(Bgcolor, element);
		}
	}
	
	public static void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor='" + color+ "'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		  }
	}
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String pageText = js.executeScript("return document.documentElement.innerText").toString();
		return pageText;
	}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public void scrollPageDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
}
