package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;

    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;

    @CacheLookup
    @FindBy(xpath ="//a[contains(text(),'Log out')]")
    WebElement  logOutlink;

    public String getWelcomeText() {
        Reporter.log("Getting Welcome Text");
        return getTextFromElement(welcomeText);
    }
    public void enterEmailId(String email){
        Reporter.log("Enter email " +email+" to email field" + emailField.toString());
        sendTextToElement(emailField,email);
    }
    public void enterPassword(String password){
        Reporter.log("Enter password " +password+" to password field" + passwordField.toString());
        sendTextToElement(passwordField,password);
    }

    public void clickOnLogInButton(){
        Reporter.log("Clicking on Login Button"+ loginButton.toString());
        clickOnElement(loginButton);
    }

    public String getErrorMessage(){return getTextFromElement(errorMessage);
    }
    public String getlogOutlink() {
        Reporter.log("Getting LogOut link Display");
        return getTextFromElement(logOutlink);
    }

    public void clickOnLogOutLink(){
        Reporter.log("Clicking on Logout Button"+ logOutlink.toString());
        clickOnElement(logOutlink);
    }
}
