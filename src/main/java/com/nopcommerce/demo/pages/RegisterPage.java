package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerText;

    @CacheLookup
    @FindBy(id = "register-button")
    WebElement registerButton;

    @CacheLookup
    @FindBy(xpath = "//span[@id='FirstName-error']")
    WebElement firstNameReqText;

    @CacheLookup
    @FindBy(xpath = "//span[@id='LastName-error']")
    WebElement lastNameReqText;

    @CacheLookup
    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement emailReqText;

    @CacheLookup
    @FindBy(xpath = "//span[@id='Password-error']")
    WebElement passwordReqText;

    @CacheLookup
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    WebElement confirmpasswordReqText;

    @CacheLookup
    @FindBy(xpath = "//input[@id='gender-female']")
    WebElement selectFemale;

    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firstNameField;

    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement selectDay;

    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement selectMonth;

    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement selectYear;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement registerSuccessText;

    public String getRegisterText() {
        Reporter.log("Getting Register Text");
        return getTextFromElement(registerText);
    }

    public void clickOnRegisterButtonLink() {
        Reporter.log("Clicking on Register Button" + registerButton.toString());
        clickOnElement(registerButton);
    }

    public String getFirstNameRequiredMessage() {
        Reporter.log("Getting First name is required Message");
        return getTextFromElement(firstNameReqText);
    }

    /* public void softAssertVerifyFirstnameRequired(String expectedtext){
         softAssertVerifyText(firstNameReqText,expectedtext);
     }*/
    public String getLastNameRequiredMessage() {
        Reporter.log("Getting Last name is required Message");
        return getTextFromElement(lastNameReqText);
    }

    public String getEmailRequiredMessage() {
        Reporter.log("Getting Email is required Message");
        return getTextFromElement(emailReqText);
    }

    public String getPasswordRequiredMessage() {
        Reporter.log("Getting Password is required Message");
        return getTextFromElement(passwordReqText);
    }

    public String getConfirmPassRequiredMessage() {
        Reporter.log("Getting Password is required Message");
        return getTextFromElement(confirmpasswordReqText);
    }

    public void SelectGenderFemale() {
        Reporter.log("Click on radio button in Female");
        clickOnElement(selectFemale);
    }

    public void inputFirstname(String text) {
        Reporter.log("Send text in first name field");
        sendTextToElement(firstNameField, text);
    }

    public void inputLastname(String text) {
        Reporter.log("Send text in last name field");
        sendTextToElement(lastNameField, text);
    }

    public void selectDay(String text) {
        Reporter.log("Select day in Day dropdown");
        selectByVisibleTextFromDropDown(selectDay, text);
    }

    public void selectMonth(String text) {
        Reporter.log("Select day in Month dropdown");
        selectByVisibleTextFromDropDown(selectMonth, text);
    }

    public void selectYear(String text) {
        Reporter.log("Select day in Year dropdown");
        selectByVisibleTextFromDropDown(selectYear, text);
    }

    public void inputEmail(String text) {
        Reporter.log("Send text in email field");
        sendTextToElement(emailField, text);
    }

    public void inputPassword(String text) {
        Reporter.log("Send text in password field");
        sendTextToElement(passwordField, text);
    }

    public void inputConfirmPassword(String text) {
        Reporter.log("Send text in confirm password field");
        sendTextToElement(confirmPasswordField, text);
    }

    public String getYourRegisterText() {
        Reporter.log("Getting Your registration completed Text");
        return getTextFromElement(registerSuccessText);
    }


}