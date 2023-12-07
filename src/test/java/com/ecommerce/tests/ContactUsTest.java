package com.ecommerce.tests;

import com.ecommerce.pages.ContactUsPage;
import com.ecommerce.utilities.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactUsTest{
	protected WebDriver driver;
    private ContactUsPage cu;
    private static final Logger logger = LogManager.getLogger(ContactUsTest.class);
    
	@Before
	public void setUp() {
	    	driver=new ChromeDriver();
	        driver.manage().window().maximize();
	       	driver.manage().deleteAllCookies();
	       	driver.get("https://www.chilternoakfurniture.co.uk"); 
	    }
  
    @Given("User navigates to the Contact Us page")
    public void userNavigatesToContactUsPage() throws InterruptedException {
        try {
    	 Thread.sleep(3000);
        cu.navigateToContactUs();
       
        } catch (Exception e) {
            logger.error("Error navigating to Contact Us page: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(driver, "NavigationError");
          
        }
    }

    @When("User fills in the contact form with the following details:")
    public void userFillsInContactForm(String name, String email, String phone, String message) {
        try {
     
            cu.fillContactForm(name, email, phone, message);
        } catch (Exception e) {
            logger.error("Error filling the contact form: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(driver, "FormFillError");
            
        }
    }

    @When("User submits the form")
    public void userSubmitsForm() {
        try {
          cu.submitForm();
        } catch (Exception e) {
            logger.error("Error submitting the form: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(driver, "FormSubmitError");

        }
    }

    @Then("User should see a confirmation message")
    public void userShouldSeeConfirmationMessage() {
        try {
         assert(cu.isConfirmationMessageDisplayed());
        } catch (Exception e) {
            logger.error("Error verifying confirmation message: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(driver, "ConfirmationError");
        }
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
