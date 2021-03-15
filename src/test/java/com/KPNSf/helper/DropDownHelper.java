package com.KPNSf.helper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownHelper {
	
	private static DropDownHelper dropDownHelper;
	private static WebDriver wbDriver;
	
	private  DropDownHelper(WebDriver driver) {
		wbDriver = driver;
	}
	
	public static DropDownHelper getDropDownInstance(WebDriver driver) {
		if (dropDownHelper == null || wbDriver.hashCode() != driver.hashCode())
		dropDownHelper = new DropDownHelper(driver);
		return dropDownHelper;
	}
	
	public void selectByVisibleText(By locator,String visibleValue){
		Select select = new Select(wbDriver.findElement(locator));
		select.selectByVisibleText(visibleValue);
	}
	
	public void selectByVisibleText (WebElement element, String visibleValue) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleValue);
	}

	public void selectByIndex(By locator,int index){
		Select select = new Select(wbDriver.findElement(locator));
		select.selectByIndex(index);
		
	}
	public void selectByIndex(WebElement element,int index){
		Select select = new Select(element);
		select.selectByIndex(index);
		
	}

	public void selectByValue(By locator,String valueAttribute){
		Select select = new Select(wbDriver.findElement(locator));
		select.selectByValue(valueAttribute);
	}
	
	public void selectByValue(WebElement element,String valueAttribute){
		Select select = new Select(element);
		select.selectByValue(valueAttribute);
	}

	public List<WebElement> getAllValues(By locator){
		Select select = new Select(wbDriver.findElement(locator));
		return select.getOptions();
	}
	
	public List<WebElement> getAllValues(WebElement element){
		Select select = new Select(element);
		return select.getOptions();
	}
}
