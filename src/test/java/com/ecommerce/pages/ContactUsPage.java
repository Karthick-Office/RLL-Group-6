package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactUsPage{
    @FindBy(id = "contactFormName")
    WebElement contactFormName;
     
    @FindBy(id = "contactFormEmail")
    WebElement contactFormEmail;

    @FindBy(id = "contactFormTelephone")
    WebElement contactFormPhone;

    @FindBy(id = "contactFormMessage")
    WebElement contactFormMessage;

    @FindBy(id = "contactFormSubmit")
    WebElement contactFormSubmit;

    @FindBy(xpath = "//*[text() = 'Contact us']")
    WebElement contact;
    
    @FindBy(xpath = "//label[text() = 'Email']/following-sibling::input")
    WebElement emailInput;

    @FindBy(xpath = "//label[text() = 'Password']/following-sibling::input")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@value = 'Sign In']")
    WebElement signInButton;

    
    @FindBy(css = ".notification > p")
    WebElement confirmationMessage;
    
    @FindBy(css="a.toolbar-account>svg")
    WebElement login;
   
    
    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
     public void fillContactForm(String name, String email, String phone, String message) {
    	Assert.assertNotNull(contactFormName);
    	Assert.assertNotNull(contactFormEmail);
    	Assert.assertNotNull(contactFormPhone);
    	Assert.assertNotNull(contactFormMessage);
    	Assert.assertTrue(contactFormName.isEnabled()&& contactFormName.isDisplayed());
    	contactFormName.sendKeys(name);
    	Assert.assertTrue(contactFormEmail.isEnabled()&& contactFormEmail.isDisplayed());
        contactFormEmail.sendKeys(email);
        Assert.assertTrue(contactFormPhone.isEnabled()&& contactFormPhone.isDisplayed());
        contactFormPhone.sendKeys(phone);
        Assert.assertTrue(contactFormMessage.isEnabled()&& contactFormMessage.isDisplayed());
        contactFormMessage.sendKeys(message);
       
    }

    public void submitForm() {
        contactFormSubmit.click();
        
    }

    public boolean isConfirmationMessageDisplayed() throws InterruptedException {
    	
    	Thread.sleep(5000);
        boolean isDisplayed = confirmationMessage.isDisplayed();
        Assert.assertTrue(isDisplayed, "Confirmation message is not displayed!");
        return isDisplayed;
    }
    
    
}
