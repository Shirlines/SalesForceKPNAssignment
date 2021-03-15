package com.KPNSf.helper;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHelper {
	
	private ArrayList<String> windowIds;
	private static WindowHelper windowHelper;
	private static WebDriver wdDriver;
	
	
	private WindowHelper(WebDriver driver) {
		wdDriver = driver;
	}
	
	public static WindowHelper getInstance(WebDriver driver) {
		if (windowHelper == null || wdDriver.hashCode() != driver.hashCode()) 
		windowHelper = new WindowHelper(driver);
		return windowHelper;
	}
	
	private ArrayList<String> getWindowIds() {
		ArrayList<String> windowIds = new ArrayList<String>(wdDriver.getWindowHandles());
		return (ArrayList<String>) Collections.unmodifiableList(windowIds);
	}
	
	private WebDriverWait getWait() {
		WebDriverWait wait = new WebDriverWait(wdDriver, 60);
		return wait;
	}
	
	public void switchToWindow(int index) {
		
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.numberOfWindowsToBe(index));
		windowIds = getWindowIds();
		
		if (index < 0 || index > windowIds.size()) {
			throw new IllegalArgumentException("Index is invalid" + index);
		}
		wdDriver.switchTo().window(windowIds.get(index));
	}
	
	public void switchToParent() {
		ArrayList<String> windowIds = getWindowIds();
		wdDriver.switchTo().window(windowIds.get(0));
	}
	
	public void switchToParentCloseAllChild() {
		
		windowIds = getWindowIds();
	
		for (int i=1; i<=windowIds.size(); i++) {
			wdDriver.switchTo().window(windowIds.get(i));
			wdDriver.close();
		}
			
		switchToParent();
			
	}
}
