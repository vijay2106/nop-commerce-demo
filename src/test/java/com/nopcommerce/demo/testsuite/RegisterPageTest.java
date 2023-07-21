package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {

    HomePage homePage ;
    RegisterPage registerPage;
    SoftAssert softAssert = new SoftAssert();
    @BeforeMethod
    public void inIt(){
        homePage =new HomePage();
        registerPage = new RegisterPage();

    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
        // Click on Register Link
        homePage.clickOnRegisterLink();
        //   Verify "Register" text
        softAssert.assertEquals(registerPage.getRegisterText(),
                "Register","Expected text not found");
        softAssert.assertAll();
    }
    @Test
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory(){
        // Click on Register Link
        homePage.clickOnRegisterLink();
        //  Click on "REGISTER" button
        registerPage.clickOnRegisterButtonLink();
        //  Verify the error message "First name is required."
        softAssert.assertEquals(registerPage.getFirstNameRequiredMessage(),
                "First name is required.","Expected text not found");
        softAssert.assertAll();
        //  Verify the error message "Last name is required."
        softAssert.assertEquals(registerPage.getLastNameRequiredMessage(),
                "Last name is required.","Expected text not found");
        softAssert.assertAll();
        //  Verify the error message "Email is required."
        softAssert.assertEquals(registerPage.getEmailRequiredMessage(),
                "Email is required.","Expected text not found");
        softAssert.assertAll();
        //  Verify the error message "Password is required."
        softAssert.assertEquals(registerPage.getPasswordRequiredMessage(),
                "Password is required.","Expected text not found");
        softAssert.assertAll();
        //  Verify the error message "Password is required."
        softAssert.assertEquals(registerPage.getConfirmPassRequiredMessage(),
                "Password is required.","Expected text not found");
        softAssert.assertAll();
    }
    @Test
    public void VerifyThatUserShouldCreateAccountSuccessfully( ){
        //  Click on Register Link
        homePage.clickOnRegisterLink();
        //  Select gender "Female"
        registerPage.SelectGenderFemale();
        //  Enter firstname
        registerPage.inputFirstname("Divesh");
        //  Enter lastname
        registerPage.inputLastname("Roman");
        //  Select day
        registerPage.selectDay("25");
        //  Select month
        registerPage.selectMonth("June");
        //  Select year
        registerPage.selectYear("1999");
        //  Enter email
        registerPage.inputEmail("register@gmail.com");
        //  Enter password
        registerPage.inputPassword("123Diuesh");
        //  Enter Confirm Password
        registerPage.inputConfirmPassword("123Diuesh");
        //  Click on "REGISTER" button
        registerPage.clickOnRegisterButtonLink();
        //  Verify message "Your registration completed"
        softAssert.assertEquals(registerPage.getYourRegisterText(),
                "Your registration completed","Expected text not found");
        softAssert.assertAll();
    }
}