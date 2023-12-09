package com.ecommerce.tests;
import io.cucumber.java.Scenario;
import com.ecommerce.pages.ContactUsPage;
import com.ecommerce.utilities.ExcelDataProvider;
import com.ecommerce.utilities.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactUsTest {
    protected WebDriver driver;
    private ContactUsPage cu;
    private static final Logger logger = LogManager.getLogger(ContactUsTest.class);


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        cu = new ContactUsPage(driver);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.chilternoakfurniture.co.uk");
    }
    

    @Given("User navigates to the Contact Us page")
    public void userNavigatesToContactUsPage() {
        try {
            driver.findElement(By.xpath("//a[contains(text(),'Contact us')]")).click();
        } catch (Exception e) {
            logger.error("Error navigating to Contact Us page: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(driver, "NavigationError");
        }
    }

    @When("User fills in the contact form")
	public void userFillsInContactForm() throws EncryptedDocumentException, IOException, InterruptedException {
        try {
		List<Map<String,String>> testdata = ExcelDataProvider.getTestData("ContactUsData");
		
		for(Map<String , String>e : testdata) {
			
			  String name = String.valueOf(e.get("name"));
              String email = String.valueOf(e.get("email"));
              String phone = String.valueOf(e.get("phone"));
              String message = String.valueOf(e.get("message"));
                     
            cu.fillContactForm(name, email, phone, message);
			
			Thread.sleep(1000);
			
		}
		   
        
    } catch (Exception e) {
        logger.error("Error filling the contact form: " + e.getMessage());
        ScreenshotUtil.captureScreenshot(driver, "FormFillError");
    }
	}

    @When("User submits the form")
    public void userSubmitsForm() {
        try {
        
            cu.submitForm();
            Thread.sleep(40000);
       
        } catch (Exception e) {
            logger.error("Error submitting the form: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(driver, "FormSubmitError");
        }
    }

    @Then("User should see a confirmation message")
    public void userShouldSeeConfirmationMessage() {
        try {
        	logger.info(cu.isConfirmationMessageDisplayed());
        	 ScreenshotUtil.captureScreenshot(driver, "FormSubmit Confirmation Message");
 			
        } catch (Exception e) {
            logger.error("Error verifying confirmation message: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(driver, "ConfirmationError");
        }
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