package com.motionintegrator.tests;

import com.motionintegrator.base.TestUtilities;
import com.motionintegrator.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class HomeTests extends TestUtilities {

    @Test(description = "Visit the webpage, navigate to workshop and check specific the information")
    public void myWorkshopTest() {
        HomePage homePage = new HomePage(driver, log);
        //Load the page url
        homePage.loadPageUrl();

        //Step 1: Scroll to the Button "Tires change", then mouse hover it and click
        homePage.myTiresBtn();

        //Step 2: Scroll to the button "Lublin" and click it
        homePage.choiceCity();

        //Step 3: Select the second car workshop from the list
        homePage.mySection();

        //Step 4: Verify visibility of text in Now open/closed position
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.openHours(), "The workshop's work time is not presented!");

        //Step 5: Verify that the workshop rating is equal to 5
        softAssert.assertTrue(homePage.checkStars().isDisplayed(), "Element stars is not displayed");
        softAssert.assertTrue(homePage.checkStars().isEnabled(), "Element stars is not enabled");
        softAssert.assertEquals("5", homePage.checkStars().getText(), "Stars rating does not match to our expectation");
        softAssert.assertAll();
    }
}
