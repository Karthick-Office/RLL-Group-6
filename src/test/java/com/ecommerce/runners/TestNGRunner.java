package com.ecommerce.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Users\\karth\\eclipse-workspace\\RLLGroup6\\features",
                    glue = {"com.ecommerce.tests"},
					dryRun = false,
					plugin = {"html:target/Cucumberreport.html",
							 "pretty",
							 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							 "timeline:test-output-thread/"
							 }
					)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
