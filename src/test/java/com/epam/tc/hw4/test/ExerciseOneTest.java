package com.epam.tc.hw4.test;

import static com.epam.tc.hw4.config.AssertsData.FRAME_BTN;
import static com.epam.tc.hw4.config.AssertsData.HEADER_BUTTONS;
import static com.epam.tc.hw4.config.AssertsData.SIDE_BUTTONS;
import static com.epam.tc.hw4.config.AssertsData.TEXTS;

import com.epam.tc.hw4.page.MainPage;
import com.epam.tc.hw4.util.Listener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Feature("Home page functionality (@Feature)")
@Story("Checking of basic functionality and displaying of page elements (@Story)")
@Listeners(Listener.class)
public class ExerciseOneTest extends BaseTest {

    @Test(description = "Home page elements (@Test)")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This is test description (@Description)")
    @Feature("test method @Feature")
    @Story("test method @Story")
    @Epic("test method @Epic")
    public void firstTest() {

        //5. Assert that there are 4 items on the header section are displayed, and they have proper texts
        MainPage mainPage = new MainPage(driver);
        softAssert.assertTrue(mainPage.areHeaderButtonsDisplayed());
        softAssert.assertEquals(mainPage.getHeaderButtonsText(), HEADER_BUTTONS);

        // 6. Assert that there are 4 images on the Index Page, and they are displayed
        softAssert.assertTrue(mainPage.areImagesDisplayed());

        //7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
        softAssert.assertTrue(mainPage.areImageTextDisplayed());
        softAssert.assertEquals(mainPage.getImageTexts(), TEXTS);

        //8. Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(mainPage.areFrameDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        mainPage.switchToFrame();
        softAssert.assertEquals(mainPage.getFrameButton(), FRAME_BTN);

        //10. Switch to original window back
        mainPage.switchToParentFrame();

        //11. Assert that there are 5 items in the Left Section are displayed, and they have proper text
        softAssert.assertTrue(mainPage.areSideButtonsDisplayed());
        softAssert.assertEquals(mainPage.getSideButtons(), SIDE_BUTTONS);

        //12. Close Browser
        softAssert.assertAll();
    }
}