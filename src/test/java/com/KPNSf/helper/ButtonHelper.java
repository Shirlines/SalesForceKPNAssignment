package com.KPNSf.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonHelper {
	
	private static ButtonHelper buttonhelper;
	private static WebDriver wbDriver;
	private WebElement element;
	
	private  ButtonHelper(WebDriver driver) {
		wbDriver = driver;
	}
	
	public static ButtonHelper getButtonInstance(WebDriver driver) {
		if (buttonhelper == null || wbDriver.hashCode() != driver.hashCode())
			buttonhelper = new ButtonHelper(driver);
		return buttonhelper;
	}
	
	public void click(By locator) {
		wbDriver.findElement(locator).click();
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void jsClick(By locator){
		element = wbDriver.findElement(locator);
		((JavascriptExecutor) wbDriver).executeScript("arguments[0].click();", element);
	}
	public void jsClick(WebElement element){
		((JavascriptExecutor) wbDriver).executeScript("arguments[0].click();", element);
	}
	
	public void sendKeysClick(By locator) {
		element = wbDriver.findElement(locator);
		element.sendKeys(Keys.ENTER);
	}
	
	public void sendKeysClick(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}
	
}
