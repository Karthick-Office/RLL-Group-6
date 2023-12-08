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
    
    @FindBy(css = ".notification > p")
    WebElement confirmationMessage;
    
    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
 
    public void fillContactForm(String name, String email, String phone, String message) {
        contactFormName.sendKeys(name);
        contactFormEmail.sendKeys(email);
        contactFormPhone.sendKeys(phone);
        contactFormMessage.sendKeys(message);
    }

    public void submitForm() {
        contactFormSubmit.click();
    }

    public boolean isConfirmationMessageDisplayed() {
    	boolean isDisplayed = confirmationMessage.isDisplayed();
        Assert.assertTrue(isDisplayed, "Confirmation message is not displayed!");
        return isDisplayed;
    }
    
    
}
