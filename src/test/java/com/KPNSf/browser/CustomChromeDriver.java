package com.KPNSf.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomChromeDriver {
	private void setDriverExecutable() {
		WebDriverManager.chromedriver().setup();
	}
	
	private ChromeOptions getChromeOptions() {
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.addArguments("--disable-notifications");
		return options;
	}
	
	public WebDriver getChromeDriver() {
		setDriverExecutable();
		ChromeOptions options = getChromeOptions();
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
	}

}
