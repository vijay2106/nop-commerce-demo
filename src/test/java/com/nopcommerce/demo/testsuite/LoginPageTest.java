package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void inIT(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessFully(){
        // Click on login link
        homePage.clickOnLoginLink();
        // verify that "Welcome, Please Sign In!" message display
        softAssert.assertEquals(loginPage.getWelcomeText(),
                "Welcome, Please Sign In!","Expected text not found");
        softAssert.assertAll();
    }
    @Test
    public void verifyTheErrorMessageWithInValidCredentials(){
        // Click on login link
        homePage.clickOnLoginLink();
        //	 Enter EmailId
        loginPage.enterEmailId("Reg21@gmail.com");
        //	 Enter Password
        loginPage.enterPassword("143Vijay");
        //	 Click on Login Button
        loginPage.clickOnLogInButton();
        //	 Verify that the Error message
        softAssert.assertEquals(loginPage.getErrorMessage(),
                "Login was unsuccessful. Please correct the errors and try again." +
                        "No customer account found",
                "Expected text not found");
        softAssert.assertAll();
    }
    @Test
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        // Click on login link
        homePage.clickOnLoginLink();
        //	 Enter EmailId
        loginPage.enterEmailId("Reg21@gmail.com");
        //	 Enter Password
        loginPage.enterPassword("143Vijay");
        //	 Click on Login Button
        loginPage.clickOnLogInButton();
        //	 Verify that LogOut link is display
        softAssert.assertEquals(loginPage.getlogOutlink(),
                "Log out","Expected text not found");
        softAssert.assertAll();

    }
    @Test
    public void VerifyThatUserShouldLogOutSuccessFully(){
        //  Click on login link
        homePage.clickOnLoginLink();
        //  Enter EmailId
        loginPage.enterEmailId("Reg21@gmail.com");
        //	Enter Password
        loginPage.enterPassword("143Vijay");
        //	Click on Login Button
        loginPage.clickOnLogInButton();
        //	Click on LogOut Link
        loginPage.clickOnLogOutLink();
        //	Verify that LogIn Link Display
        softAssert.assertEquals(homePage.getLogininlink(),
                "Log in","Expected text not found");
        softAssert.assertAll();
    }
}
