package com.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignPage{
	
	
	@FindBy(css="a.toolbar-account > svg")
	static WebElement SignIn_icon;
	
	@FindBy(id="customer_email")
	static WebElement Txtbox_Emailid;
	
	@FindBy(id="customer_password")
	static WebElement Txtbox_Password;
	
	@FindBy(xpath="//input[@value='Sign In']")
	static WebElement Btn_SignIn;
	
	
	
    
    public SignPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
     

	public void clickSignInIcon() {
		SignIn_icon.click();
	}
	
	
	public void enterSignInDetails(String user1, String user2) {
		Txtbox_Emailid.sendKeys(user1);
		Txtbox_Password.sendKeys(user2);
	}
	
	public void clickSignInSubmitButton() {
		Btn_SignIn.click();
	}
	public String validateURL(WebDriver driver) {
		String Url = driver.getCurrentUrl();
		return Url;
	}

    
    
}
