package com.KPNSf.services;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.KPNSf.browser.CustomChromeDriver;
import com.KPNSf.helper.BrowserHelper;
import com.KPNSf.helper.ButtonHelper;
import com.KPNSf.helper.DropDownHelper;
import com.KPNSf.helper.TextBoxHelper;
import com.KPNSf.utils.IReader;
import com.KPNSf.utils.ReadConfigProperties;

public class DriverServices {

	private WebDriver driver;
	private BrowserHelper browserHelper;
	private TextBoxHelper textBoxHelper;
	private ButtonHelper buttonHelper;
	private DropDownHelper dropDownHelper;
	private IReader reader;

	public DriverServices() throws IOException {
		launchBrowser();
	}

	public IReader getReader() {
		return reader;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public BrowserHelper getBrowserHelper() {
		return browserHelper;
	}

	public TextBoxHelper getTextBoxHelper() {
		return textBoxHelper;
	}

	public ButtonHelper getButtonHelper() {
		return buttonHelper;
	}

	public DropDownHelper getDropDownHelper() {
		return dropDownHelper;
	}

	public void launchBrowser() throws IOException {
		CustomChromeDriver chromeDriver = new CustomChromeDriver();
		reader = new ReadConfigProperties();
		driver = chromeDriver.getChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		browserHelper = BrowserHelper.getBrowserInstance(driver);
		textBoxHelper = TextBoxHelper.getTextBoxInstance(driver);
		buttonHelper = ButtonHelper.getButtonInstance(driver);
		dropDownHelper = DropDownHelper.getDropDownInstance(driver);

		browserHelper.maximize();
	}

}
