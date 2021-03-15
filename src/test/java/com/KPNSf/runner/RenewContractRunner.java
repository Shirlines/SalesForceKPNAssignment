package com.KPNSf.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/featureFile"},
		glue = {"com.KPNSf.stepDfn",
				"com.KPNSf.hooks"},
		monochrome = true,
		plugin= {"pretty", "html:target/HTMLReport"}
		)
public class RenewContractRunner {
	
}
