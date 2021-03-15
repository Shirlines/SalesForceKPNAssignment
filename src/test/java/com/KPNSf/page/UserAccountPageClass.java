package com.KPNSf.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.KPNSf.helper.ButtonHelper;

public class UserAccountPageClass extends PageBase{
	
	private WebDriver driver;
	
	public UserAccountPageClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	//WebElements
	@FindBy(how=How.XPATH,using="(//a[contains(@class,'via-action-link')])[2]")
	public WebElement renewContractLink;
	
	@FindBy(how=How.ID,using="iFrameResizer0")
	public WebElement iFrameResizer0;
	
	//Navigation
	public PageBase navigateTocreateNewContractPage() {
		CreateNewContractPageClass createNewContractPage = new CreateNewContractPageClass(driver);
		ButtonHelper helper = ButtonHelper.getButtonInstance(driver);
		helper.sendKeysClick(renewContractLink);
		System.out.println("The Renew Contract link is clicked by the user to create a new contract");
		driver.switchTo().parentFrame();
		System.out.println("Create New Contract page title: "+driver.getTitle());
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(createNewContractPage.iFrameResizer1));	
		System.out.println("The create new contract page is loaded: "+driver.findElement(By.xpath("(//h1[contains(@class,'slds-page-header__title')])[1]")).getText().trim());
		return createNewContractPage;		
	}
}
