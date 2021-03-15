package com.KPNSf.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.KPNSf.helper.ButtonHelper;
import com.KPNSf.helper.DropDownHelper;
import com.KPNSf.helper.TextBoxHelper;

public class CreateNewContractPageClass extends PageBase{

	private WebDriver driver;

	public CreateNewContractPageClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// WebElements
	@FindBy(how = How.ID, using = "iFrameResizer1")
	public WebElement iFrameResizer1;
	
	@FindBy(how = How.XPATH, using = "(//h1[contains(@class,'slds-page-header__title')])[1]")
	public WebElement pageTitle;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ContractName']")
	public WebElement contractName;
	
	@FindBy(how = How.XPATH, using = "//select[@id='SelectOption']")
	public WebElement termfield;
	
	@FindBy(how = How.XPATH, using = "//*[@id='Status|0']/div/div[1]/label[1]/input[@id='Status']")
	public WebElement statusDraft;
	
	@FindBy(how = How.XPATH, using = "//*[@id='Status|0']/div/div[1]/label[2]/input[@id='Status']")
	public WebElement statusSigned;
	
	@FindBy(how = How.XPATH, using = "//*[@id='CreateNew_nextBtn']")
	public WebElement done;
	
	@FindBy(how = How.XPATH, using = "//div[@id='alert-container']/div[3]/button")
	public WebElement alert;
	
	@FindBy(how = How.XPATH, using = "//div[@id='alert-container']/div[2]/p")
	public WebElement alertMsg;
	
	@FindBy(how = How.XPATH, using = "//div[@id='alert-container']/div[3]/button")
	public WebElement alertOkButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='Status|0']/div/div[2]/div/small")
	public WebElement errorOnPage;
	
	
	// Actions
	public void fillDetails(String contractname, String term) {

		TextBoxHelper tHelper = TextBoxHelper.getTextBoxInstance(driver);
		tHelper.setText(contractName, contractname);
		DropDownHelper dHelper = DropDownHelper.getDropDownInstance(driver);
		dHelper.selectByVisibleText(termfield, term);
		ButtonHelper bHelper = ButtonHelper.getButtonInstance(driver);
		bHelper.jsClick(statusDraft);
		System.out.println("The fields are filled with a contractName, 1 year term and Draft status");
	}

	public void fillDetailsForErr(String contractname, String term) {
		TextBoxHelper tHelper = TextBoxHelper.getTextBoxInstance(driver);
		tHelper.setText(contractName, contractname);
		DropDownHelper dHelper = DropDownHelper.getDropDownInstance(driver);
		dHelper.selectByVisibleText(termfield, term);
		ButtonHelper bHelper = ButtonHelper.getButtonInstance(driver);
		bHelper.jsClick(statusSigned);
		System.out.println("The fields are filled with a contractName, 2 years term and Signed status");
		bHelper.click(done);
		driver.switchTo().parentFrame();
	}

	public void errorPopUp() {

		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameResizer1));
		wait.until(ExpectedConditions.visibilityOf(alert));
		// • Verify the Error pop up	
		System.out.println("An error message pops up when the status is selected as Signed");
		System.out.println("The error on the pop up is - " +alertMsg.getText());
	}

	public void clickOkOnErr() {
		ButtonHelper bHelper = ButtonHelper.getButtonInstance(driver);
		bHelper.click(alertOkButton);
		System.out.println("The user clicks OK on the error pop up");
	}

	public void displayErrorOnPage() {
		System.out.println("The error message on the page is - " +errorOnPage.getText());
	}

	// Navigation
	public PageBase navigateToDocumentsPage() {
		DocumentsPageClass documentsPage = new DocumentsPageClass(driver);
		ButtonHelper bHelper = ButtonHelper.getButtonInstance(driver);
		bHelper.click(done);
		driver.switchTo().parentFrame();
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(documentsPage.contractNum));
		System.out.println("Process is completed by clicking on Done");
		return documentsPage;
	}
}
