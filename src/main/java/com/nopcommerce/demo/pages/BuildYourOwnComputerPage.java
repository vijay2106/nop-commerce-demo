package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BuildYourOwnComputerPage extends Utility {


    @CacheLookup
    @FindBy(xpath ="//select[@name='product_attribute_1']")
    WebElement processor;

    @CacheLookup
    @FindBy(css ="#product_attribute_2")
    WebElement ram;

    @CacheLookup
    @FindBy(xpath = "//input[@name='product_attribute_3']")
    //List<WebElement> hddRadio;
    WebElement    hddRadio;

    @CacheLookup
    @FindBy(xpath = "//input[@name= 'product_attribute_4']")
    WebElement osRadio;

    @CacheLookup
    @FindBy(xpath = "//input[@name= 'product_attribute_5']")
    WebElement msOfficeSoftware;

    @CacheLookup
    @FindBy(xpath ="//button[@id='add-to-cart-button-1']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath ="//p[@class='content']")
    WebElement verifyProductAddedToCart;
    public void selectProcessor(String text){
        Reporter.log("Select Processor in Processor dropdown");
        selectByVisibleTextFromDropDown(processor,text);
    }
    public void selectRAM(String text){
        Reporter.log("Select RAM in RAM dropdown");
        selectByVisibleTextFromDropDown(ram,text);
    }
    public void selectHDDRadio(String text) {
        Reporter.log("Clicking on HDD Radio");
        mouseHoverToElementAndClick(hddRadio);
    }


    public void selectOSRadio(String text){
        Reporter.log("Clicking on OS Radio");
        mouseHoverToElementAndClick(osRadio);
    }
    public void selectSoftwareMS(String text) {
        Reporter.log("Clicking on Software check box");
        mouseHoverToElementAndClick(msOfficeSoftware);
    }
    public void clickOnAddToCartButton() {
        Reporter.log("Clicking on add to cart button"+ addToCartButton.toString());
        clickOnElement(addToCartButton);
    }

    public String verifyTheProductHasBeenAddedToYourShoppingCart(){
        Reporter.log("Getting The product has been added to your shopping cart Message");
        return getTextFromElement(verifyProductAddedToCart);
    }

}