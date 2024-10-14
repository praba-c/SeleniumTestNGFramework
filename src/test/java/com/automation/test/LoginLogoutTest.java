package com.automation.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginLogoutTest extends BaseTest{

    @Test(dataProvider = "getValidCredentials")
    public void verifyUserCanLoginWithCredentials(String username, String password) {
        loginPage.openWebsite();
        loginPage.doLogin(username, password);

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnAddToCartOnFirstItem();

        homePage.logout();

    }
    @DataProvider
    public Object[][] getValidCredentials() {
        Object[][] credentials = {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"},
        };
        return credentials;
    }

}
