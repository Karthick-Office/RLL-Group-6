package com.ecommerce.tests;

import com.ecommerce.pages.ContactUsPage;
import com.ecommerce.utilities.ExcelDataProvider;
import com.ecommerce.utilities.ScreenshotUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
            Thread.sleep(5000);
            driver.findElement(By.xpath("//a[contains(text(),'Contact us')]")).click();
        } catch (Exception e) {
            logger.error("Error navigating to Contact Us page: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(driver, "NavigationError");
        }
    }

    @When("User fills in the contact form with the following details")
    public void userFillsInContactForm(DataTable dataTable) {
        try {
            Thread.sleep(3000);

            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

            for (Map<String, String> entry : data) {
                String name = entry.get("Name");
                String email = entry.get("Email");
                String phone = entry.get("Phone");
                String message = entry.get("Message");
                cu.fillContactForm(name, email, phone, message);
                
               
            }
        } catch (Exception e) {
            logger.error("Error filling the contact form: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(driver, "FormFillError");
        }
    }



    @When("User submits the form")
    public void userSubmitsForm() {
        try {
        	Thread.sleep(3000);
            cu.submitForm();
            ScreenshotUtil.captureScreenshot(driver, "FormSubmit");
            Thread.sleep(3000);
        } catch (Exception e) {
            logger.error("Error submitting the form: " + e.getMessage());
            ScreenshotUtil.captureScreenshot(driver, "FormSubmitError");
        }
    }

    @Then("User should see a confirmation message")
    public void userShouldSeeConfirmationMessage() {
        try {
        	Thread.sleep(5000);
        	logger.info(cu.isConfirmationMessageDisplayed());
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
