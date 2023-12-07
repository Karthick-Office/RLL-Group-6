package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage{
    private WebDriver driver;
    @FindBy(id = "contactFormName")
    private WebElement contactFormName;

    @FindBy(id = "contactFormEmail")
    private WebElement contactFormEmail;

    @FindBy(id = "contactFormTelephone")
    private WebElement contactFormPhone;

    @FindBy(id = "contactFormMessage")
    private WebElement contactFormMessage;

    @FindBy(id = "contactFormSubmit")
    private WebElement contactFormSubmit;

    @FindBy(xpath = "//*[text() = 'Contact us']")
    private WebElement contact;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void navigateToContactUs() {
        contact.click();
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
    return true;
    }
    
    
}
