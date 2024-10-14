package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderConfirmationTest extends BaseTest {

    @Test
    public void verifyUserCanPlaceOrder() {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnAddToCartOnFirstItem();


        Assert.assertTrue(cartPage.isCartPageDisplayed());
        cartPage.clickCheckOutBtn();

        Assert.assertTrue(checkoutPage.isCheckOutPageDisplayed());
        checkoutPage.fillShippingInfo();
        checkoutPage.clickOnContinueBtn();

        Assert.assertTrue(reviewPage.isReviewPageDisplayed());
        reviewPage.clickFinishBtn();

        Assert.assertTrue(orderConfirmationPage.isOrderPageDisplayed());

    }
}
