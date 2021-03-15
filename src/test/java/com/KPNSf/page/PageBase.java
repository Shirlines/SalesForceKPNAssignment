package com.KPNSf.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.KPNSf.page.factory.CustomFactory;
import com.KPNSf.page.factory.PageName;

public class PageBase {
	
	private WebDriver driver;
	
	public PageBase(WebDriver driver ) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	protected WebDriverWait getWait() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		return wait;
	}
	
	protected PageBase navigateTo(PageName name,WebDriver driver,WebElement element){
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(element));
		return CustomFactory.getInstance(name, driver);
	}
}
