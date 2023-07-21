package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DesktopsPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Desktops')]")
    WebElement verifyDesktops;

    @CacheLookup
    @FindBy(xpath ="//h2[@class='product-title']//a[normalize-space()='Build your own computer']")
    WebElement buildYourComputerlink;


    public String getDesktopsText(){
        Reporter.log("Verify Desktops Text");
        return getTextFromElement(verifyDesktops);
    }
    public void clickOnBuildYourComputer(){
        Reporter.log("Clicking on Build Your Computer Product name "+ buildYourComputerlink.toString());
        clickOnElement(buildYourComputerlink);
    }
}
