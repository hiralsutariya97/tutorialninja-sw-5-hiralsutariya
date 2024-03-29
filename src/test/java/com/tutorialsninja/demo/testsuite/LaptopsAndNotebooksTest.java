package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class LaptopsAndNotebooksTest extends BaseTest {

    DesktopsPage desktopsPage;

    @Test(dataProvider = "data set", dataProviderClass = TestData.class)
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty, String successMessage,
                                                             String productName, String model, String total) throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
        desktopsPage.mouseHoverOnDesktopLinkAndClick();

        //2.2 Click on “Show All Desktops”
        desktopsPage.clickOnShowAllDesktops();

        //2.3 Select Sort By position "Name: A to Z"
        desktopsPage.selectPositionByAtoZ();

        //2.4 Select product “HP LP3065”
        desktopsPage.clickOnProductHPLP3065();

        //2.5 Verify the Text "HP LP3065"
        String expectedText = product;
        String actualText = desktopsPage.getTextHPLp3065();
        Assert.assertEquals(actualText, expectedText, "Error found");

        //2.6 Select Delivery Date "2022-11-30"
        desktopsPage.selectDateFromCalender();

        //2.7.Enter Qty "1” using Select class.
        desktopsPage.enterQuantity();

        //2.8 Click on “Add to Cart” button
        desktopsPage.clickOnAddToCart();

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expectedText1 = successMessage;
        String actualText1 = desktopsPage.getSuccessText();
        boolean message = actualText1.contains(expectedText1.trim());

        //2.10 Click on link “shopping cart” display into success message
        Thread.sleep(2000);
        desktopsPage.clickOnShoppingCart();

        //2.11 Verify the text "Shopping Cart"
        String expectedMessage = "Shopping Cart  (1.00kg)";
        String actualMessage = desktopsPage.getShoppingCartText();
        Assert.assertEquals(actualMessage, expectedMessage, "Error found");

        //2.12 Verify the Product name "HP LP3065"
        String expectedMessage1 = productName;
        String actualMessage1 = desktopsPage.getProductNameHPLPText();
        Assert.assertEquals(actualMessage1, expectedMessage1, "Error found");

        //2.13 Verify the Delivery Date "2022-11-30"
        String expectedMessage2 = "Delivery Date:2023-11-30";
        String actualMessage2 = desktopsPage.verifyDeliveryDate();
        Assert.assertEquals(actualMessage2, expectedMessage2, "Error found");

        //2.14 Verify the Model "Product21"
        String expectedMessage3 = model;
        String actualMessage3 = desktopsPage.verifyModelProduct21();
        Assert.assertEquals(actualMessage3, expectedMessage3, "Error found");

        //2.15 Verify the Todal "£74.73"
        String expectedTotal = total;
        String actualTotal = desktopsPage.verifyTotal();
        Assert.assertEquals(actualTotal, expectedTotal, "Error found");
    }
}
