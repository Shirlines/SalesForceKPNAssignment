package com.KPNSf.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxHelper {
	
	private static TextBoxHelper textBoxHelper;
	private static WebDriver wbDriver;
	private WebElement element;
	
	private TextBoxHelper(WebDriver driver) {
		wbDriver = driver;
	}
	
	public static TextBoxHelper getTextBoxInstance(WebDriver driver) {
		if (textBoxHelper == null || wbDriver.hashCode() != driver.hashCode())
			textBoxHelper = new TextBoxHelper(driver);
		return textBoxHelper;
	}
	
	public void setText(By locator, String value) {
		element = wbDriver.findElement(locator);
		element.sendKeys(value);
	}
	public void setText(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public String getText(By locator) {
		element = wbDriver.findElement(locator);
		String textValue = element.getText();
		return textValue;
	}
	public String getText(WebElement element) {
		String textValue = element.getText();
		return textValue;
	}
	
	public void clearText(By locator) {
		element = wbDriver.findElement(locator);
		element.clear();
	}
	public void clearText(WebElement element) {
		element.clear();
	}
}
