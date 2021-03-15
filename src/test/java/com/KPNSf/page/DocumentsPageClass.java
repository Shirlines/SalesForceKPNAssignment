package com.KPNSf.page;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocumentsPageClass extends PageBase {

	private WebDriver driver;

	public DocumentsPageClass(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// WebElements
	@FindBy(how = How.XPATH, using = "(//span[@class='uiOutputText'])[1]")
	public WebElement contractNum;

	@FindBy(how = How.XPATH, using = "//a[contains(@class,'textUnderline outputLookupLink slds')]")
	public WebElement accountName;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'slds-page-header slds-page-header_record-home s1FixedTop')]/ul/li[2]/div/div/div/span")
	public WebElement status;

	@FindBy(how = How.XPATH, using = "//span[@class='uiOutputNumber']")
	public WebElement term;

	// Actions
	public void verifyDetails() throws IOException {
		WebDriverWait wait = getWait();
		// • Get the contract number
		wait.until(ExpectedConditions.visibilityOf(contractNum));
		String contractNumber = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='uiOutputText'])[1]")))
				.getText();
		System.out.println("Contract number is " + contractNumber);
		// • Verify the account name
		String actualAccName = accountName.getText();
		String expectedAccName = "John Smith";
		assertEquals(actualAccName, expectedAccName);
		System.out.println("Account name '" + actualAccName + "' is verified");
		// • Verify the status
		String actualStatus = status.getText();
		String expectedStatus = "Draft";
		assertEquals(actualStatus, expectedStatus);
		System.out.println("Contract status '" + actualStatus + "' is verified");
		// • Verify the Contract Term
		String actualTerm = term.getText();
		String expectedTerm = "12";
		assertEquals(actualTerm, expectedTerm);
		System.out.println("Contract term  '" + actualTerm + "' is verified");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("Renewed Contract Screenshot.png"));
		System.out.println("The contract is renewed successfully");
		// Make a screenshot
		System.out.println("The screenshot is saved in the project directory as 'Renewed Contract Screenshot.png'");
	}
}
