package com.KPNSf.hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.KPNSf.services.DriverServices;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class GeneralHooks {
	
	private DriverServices services;
	private WebDriver driver;
	
	public GeneralHooks(DriverServices services) {
		this.services = services;
		this.driver = this.services.getDriver();
	}
	
	@Before
	public void setUp(Scenario name) {
		System.out.println("Scenario: "+name.getName());
	}
	
	@After
	public void tearDown(Scenario name ) {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		if (driver!=null) 
		driver.quit();
		
		System.out.println("Scenario status: "+name.getStatus());
		System.out.println("------------------------------------------------");
	}
}
