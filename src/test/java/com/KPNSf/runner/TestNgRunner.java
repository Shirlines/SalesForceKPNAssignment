package com.KPNSf.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src/test/resources/featureFile"},
		glue = {"com.KPNSf.stepDfn",
				"com.KPNSf.hooks"},
		monochrome = true,
		plugin= {"pretty", "html:target/HTMLReport"}
		)
public class TestNgRunner extends AbstractTestNGCucumberTests {

}
