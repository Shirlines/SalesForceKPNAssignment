package com.KPNSf.helper;

import org.openqa.selenium.WebDriver;

public class BrowserHelper {
	
	private static BrowserHelper browserHelper;
	private static WebDriver wbDriver;
	
	private BrowserHelper(WebDriver driver) {
		wbDriver = driver;
	}
	
	public static BrowserHelper getBrowserInstance(WebDriver driver) {
		
		if (browserHelper == null || wbDriver.hashCode() != driver.hashCode())	
		 browserHelper = new BrowserHelper (driver);
		return browserHelper;	
	}
	
	public void maximize() {
		wbDriver.manage().window().maximize();
	}
	
	public void refresh() {
		wbDriver.navigate().refresh();
	}
	
	public void moveForward() {
		wbDriver.navigate().forward();
	}

	public void moveBack() {
		wbDriver.navigate().back();
	}
}
