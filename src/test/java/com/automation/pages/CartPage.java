package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    @FindBy(xpath = "//div[@class='cart_item']")
    List<WebElement> productsOnCartPage;

    public boolean isCartPageDisplayed() {
        return checkoutBtn.isDisplayed();
    }

    public void clickCheckOutBtn() {
        checkoutBtn.click();
    }

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement cartBtn;

    public boolean prodsOnCartPageEqualsAddedItems() {
        //System.out.print(cartBtn.getText() +" " + productsOnCartPage.size());
        return Integer.parseInt(cartBtn.getText()) == productsOnCartPage.size();
    }
}
