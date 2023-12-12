package com.ecommerce.tests;
import com.ecommerce.pages.SignPage;
import com.ecommerce.utilities.ExcelDataProvider;
import io.cucumber.java.en.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInTest{
	
	SignPage sign =new SignPage(TestBase.driver);
	public static final Logger logger = LogManager.getLogger(SignInTest.class);
	
    @When("I click on Sign In icon")
	public void i_click_on_sign_in_icon() {
    	sign.clickSignInIcon();
	   String Expected_title = "Account – Chiltern Oak Furniture";
	   String Actual_title = TestBase.driver.getTitle();
	   Assert.assertEquals(Expected_title, Actual_title);
	}
    
    
    
    @When("I enter EmailId and Password")
	public void i_enter_email_id_and_password() throws InterruptedException, EncryptedDocumentException, IOException {
        List<Map<String,String>>testdata = ExcelDataProvider.getTestData("Signin");
		
		for(Map<String, String>e : testdata) {
			
			
			String Txtbox_Emailid =String.valueOf(e.get("EmailId")); 
			
			String Txtbox_Password =String.valueOf(e.get("Password"));
			
			sign.enterSignInDetails(Txtbox_Emailid, Txtbox_Password);
			
	     }
	}
	
    

    @Then("I click on Sign In button")
    public void i_click_on_sign_in_button() throws InterruptedException {
        sign.clickSignInSubmitButton();

        // Explicit wait for the URL to not be the expected URL
        WebDriverWait wait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(120));
        String expectedURL = "https://www.chilternoakfurniture.co.uk/challenge";

        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(expectedURL)));


//	    String Expected_URL = "https://www.chilternoakfurniture.co.uk/challenge";
//	    String Actual_URL = sign.validateURL(TestBase.driver);
//	    Assert.assertEquals(Expected_URL, Actual_URL);
	}
	
    
}