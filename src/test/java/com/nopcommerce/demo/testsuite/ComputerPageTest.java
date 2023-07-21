package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;

public class ComputerPageTest extends BaseTest {
    HomePage homePage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void inIT(){
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    }

    @Test
    public void verifyUserShouldNavigateToComputerPageSuccessfully(){
        //Click on Computer tab
        homePage.clickOnComputers();
        //   Verify "Computer" text
        softAssert.assertEquals(computerPage.getComputersText(),
                "Computers","Expected text not found");
        softAssert.assertAll();
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        //  Click on Computer tab
        homePage.clickOnComputers();
        //   Click on Desktops link
        computerPage.clickOnDesktops();
        //   Verify "Desktops" text
        softAssert.assertEquals(desktopsPage.getDesktopsText(),
                "Desktops","Expected text not found");
        softAssert.assertAll();
    }
    @Test(dataProvider ="Build You Own Computer",dataProviderClass = TestData.class)
    public void VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully
            (String processor, String ram, String hdd, String os, String software) throws InterruptedException {
        //   Click on Computer tab
        homePage.clickOnComputers();
        Thread.sleep(2000);
        //   Click on Desktops link
        computerPage.clickOnDesktops();
        Thread.sleep(2000);
        //   Click on product name "Build your own computer"
        desktopsPage.clickOnBuildYourComputer();
        Thread.sleep(2000);
        //   Select processor "processor"
        buildYourOwnComputerPage.selectProcessor(processor);
        Thread.sleep(2000);
        //   Select RAM "ram"
        buildYourOwnComputerPage.selectRAM(ram);
        Thread.sleep(2000);
        //   Select HDD "hdd"
        buildYourOwnComputerPage.selectHDDRadio(hdd);
        Thread.sleep(2000);
        //   Select OS "os"
        buildYourOwnComputerPage.selectOSRadio(os);
        Thread.sleep(2000);
        //   Select Software "software"
        buildYourOwnComputerPage.selectSoftwareMS(software);
        Thread.sleep(2000);
        //   Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCartButton();
        Thread.sleep(2000);
        //   Verify message "The product has been added to your shopping cart"
        softAssert.assertEquals(buildYourOwnComputerPage.verifyTheProductHasBeenAddedToYourShoppingCart(),
                "The product has been added to your shopping cart","Expected text not found");
        softAssert.assertAll();
        //
        //   DATA SET
        //    | processor                                       | ram           | hdd               | os                      | software                   |
        //    | 2.2 GHz Intel Pentium Dual-Core E2200           | 2 GB          | 320 GB            | Vista Home [+$50.00]    | Microsoft Office [+$50.00] |
        //    | 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00] | 4GB [+$20.00] | 400 GB [+$100.00] | Vista Premium [+$60.00] | Acrobat Reader [+$10.00]   |
        //    | 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00] | 8GB [+$60.00] | 320 GB            | Vista Home [+$50.00]    | Total Commander [+$5.00]   |
    }
}

