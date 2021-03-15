package com.KPNSf.page.factory;

import org.openqa.selenium.WebDriver;
import com.KPNSf.page.LoginPageClass;
import com.KPNSf.page.PageBase;

public class CustomFactory {
	
	public static PageBase getInstance(PageName name, WebDriver driver) {
		
		switch (name) {
		case LoginPage: return new LoginPageClass(driver);
		case UserAccountPage: return new LoginPageClass(driver);
		case CreateNewContractPage: return new LoginPageClass(driver);
		case DocumentsPage: return new LoginPageClass(driver);

		default:
			throw new RuntimeException("Invalid Page Name");
		}
	}

}
