package com.KPNSf.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.KPNSf.helper.ButtonHelper;
import com.KPNSf.helper.TextBoxHelper;

public class LoginPageClass extends PageBase{
	
	private WebDriver driver;
	
	public LoginPageClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	//WebElements
	@FindBy(how=How.ID,using="username")
	public WebElement userName;
	
	@FindBy(how=How.ID,using="password")
	public WebElement password;
	
	@FindBy(how=How.ID,using="Login")
	public WebElement login;
	
	//Navigation
	public PageBase loginAndNavigateToAccountPage(String username, String pwd, String url) {
		UserAccountPageClass accountPage = new UserAccountPageClass(driver);
		TextBoxHelper tHelper = TextBoxHelper.getTextBoxInstance(driver);
		tHelper.setText(userName, username);
		tHelper.setText(password, pwd);
		ButtonHelper bHelper = ButtonHelper.getButtonInstance(driver);
		bHelper.click(login);
		driver.navigate().to(url);
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(accountPage.iFrameResizer0));
		wait.until(ExpectedConditions.visibilityOf(accountPage.renewContractLink));
		return accountPage;
	}
}
