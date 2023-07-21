package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement loginLink;

    @CacheLookup
    @FindBy(xpath = "//a[starts-with(text(),'Reg')]")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computerTab;


    public void clickOnLoginLink(){
        Reporter.log("Clicking on login link" + loginLink.toString());
        clickOnElement(loginLink);
    }
    public String getLogininlink(){
        return getTextFromElement(loginLink);
    }

    public void clickOnRegisterLink(){
        Reporter.log("Clicking on Register link");
        clickOnElement(registerLink);
    }

    public void clickOnComputers(){
        clickOnElement( computerTab);
    }



}




