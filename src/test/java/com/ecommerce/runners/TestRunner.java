package com.ecommerce.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "/RLLGroup6/features",
    tags = "@contact",
    glue = "com.ecommerce.tests",
    plugin = {"pretty", "html:target/cucumber-reports", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
