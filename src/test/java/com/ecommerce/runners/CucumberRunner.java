package com.ecommerce.runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\karth\\eclipse-workspace\\RLLGroup6\\features",
					glue = {"com.ecommerce.tests"},
					dryRun = false,
					plugin = {"html:target/Cucumberreport.html",
							 "pretty",
							 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							 "timeline:test-output-thread/"
							 }
					)
public class CucumberRunner {

}
