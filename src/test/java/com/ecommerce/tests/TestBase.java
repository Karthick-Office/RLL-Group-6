package com.ecommerce.tests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



public class TestBase {
	
public static WebDriver driver;
public static final Logger logger = LogManager.getLogger(TestBase.class);
	   @Before
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.get("https://www.chilternoakfurniture.co.uk");
	    }
	    
	
	public static WebDriver getdriver() {
		return driver;
	}
	
	@After
    public void tearDown(Scenario scenario) {
        try {
        	 if(!scenario.isFailed()) {
      			TakesScreenshot ts = (TakesScreenshot)driver;
      			final byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
      			scenario.attach(screenshot, "image/png", scenario.getName());
      		}
        } catch (WebDriverException e) {
            logger.error("Failed to take screenshot: " + e.getMessage());
        } finally {
        	
            if (driver != null) {
                driver.quit();
            }
        }
    }
	
	

}