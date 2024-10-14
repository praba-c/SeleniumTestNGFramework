package com.automation.test;

import com.automation.pages.CartPage;
import com.automation.utils.ConfigReader;
import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ConcurrentModificationException;

public class AssignmentTests extends BaseTest {


    // 1 - Sort product from Z to A
    @Test
    public void sortProductsOnNames() throws InterruptedException {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickFilterBtn("Z to A");

        Assert.assertTrue(homePage.verifyProductsAreSorted());
        System.out.print("Test 1 Passed");
    }


    // 2 - Sort product from High to Low
    @Test
    public void sortProductsOnPrice() throws InterruptedException {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickFilterBtn("High to Low");

        Assert.assertTrue(homePage.verifyProductsAreSorted());
        System.out.print("Test 2 Passed");
    }

    // 3 - Verify cart quantity
    @Test
    public void verifyCartItems() {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.addItemsToCart();
        Assert.assertTrue(homePage.verifyCartIconMatches());
        homePage.clickOnShoppingCartLink();

        Assert.assertTrue(cartPage.isCartPageDisplayed());
        Assert.assertTrue(cartPage.prodsOnCartPageEqualsAddedItems());
        System.out.print("Test 3 Passed");
    }

    // 4 - Verify the total price
    @Test
    public void verifyTotalPrice() {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.addItemsToCart();

        Assert.assertTrue(homePage.verifyCartIconMatches());
        homePage.clickOnShoppingCartLink();

        Assert.assertTrue(cartPage.isCartPageDisplayed());
        cartPage.clickCheckOutBtn();

        Assert.assertTrue(checkoutPage.isCheckOutPageDisplayed());
        checkoutPage.fillShippingInfo();
        checkoutPage.clickOnContinueBtn();

        Assert.assertTrue(reviewPage.isReviewPageDisplayed());
        reviewPage.calculatedTotPrice();

        Assert.assertTrue(reviewPage.verifyPriceIsCorrect());
        System.out.print("Test 4 Passed");
    }

    // 5 - Confirm the order
    @Test
    public void orderConfirmation() {
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.addItemsToCart();

        Assert.assertTrue(homePage.verifyCartIconMatches());
        homePage.clickOnShoppingCartLink();

        Assert.assertTrue(cartPage.isCartPageDisplayed());
        cartPage.clickCheckOutBtn();

        Assert.assertTrue(checkoutPage.isCheckOutPageDisplayed());
        checkoutPage.fillShippingInfo();
        checkoutPage.clickOnContinueBtn();

        Assert.assertTrue(reviewPage.isReviewPageDisplayed());
        reviewPage.clickFinishBtn();

        Assert.assertTrue(orderConfirmationPage.isOrderPageDisplayed());
        orderConfirmationPage.clickBackHomeBtn();

        Assert.assertTrue(homePage.isHomePageDisplayed());
        Assert.assertEquals(homePage.clickOnAddToCartOnFirstItem(), "Add to cart");
        System.out.print("Test 5 Passed");
    }
}
