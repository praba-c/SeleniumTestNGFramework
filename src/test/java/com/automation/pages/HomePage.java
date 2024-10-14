package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCartLink;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    List<WebElement> addToCartBtnList;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement cartBtn;

    @FindBy(id = "react-burger-menu-btn")
    WebElement hamburgerBtn;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutBtn;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement filterBtn;

    @FindBy(xpath = "//option[@value='az']")
    WebElement sortInAsc;

    @FindBy(xpath = "//option[@value='za']")
    WebElement sortInDec;

    @FindBy(xpath = "//option[@value='lohi']")
    WebElement sortInAscPrice;

    @FindBy(xpath = "//option[@value='hilo']")
    WebElement sortInDecPrice;

    public boolean isHomePageDisplayed() {
        return shoppingCartLink.isDisplayed();
    }

    public String clickOnAddToCartOnFirstItem() {
        return addToCartBtnList.get(0).getText();
    }

    public void logout() {
        hamburgerBtn.click();
        logoutBtn.click();
    }

    public void clickOnShoppingCartLink() {
        shoppingCartLink.click();
    }

    public void clickFilterBtn(String opt) {
        filterBtn.click();
        switch (opt) {
            case "Z to A" -> sortInDec.click();
            case "A to Z" -> sortInAsc.click();
            case "High to Low" -> sortInDecPrice.click();
            case "Low to High" -> sortInAscPrice.click();
        }
    }

    @FindBy(xpath = "//button[contains(@id, 'add-to-cart')]")
    List<WebElement> filteredListOfAddToCartBtn;

    public boolean verifyProductsAreSorted() {
        List<String> orgOrder = new ArrayList<>();
        List<String> curOrder = new ArrayList<>();
        for (int i=0;i<addToCartBtnList.size();++i) {
            orgOrder.add(addToCartBtnList.get(i).getText());
            curOrder.add(filteredListOfAddToCartBtn.get(i).getText());
        }
        List<String> newOrder = orgOrder.stream().sorted(Comparator.reverseOrder()).toList();
        return newOrder.equals(curOrder);
    }

    public boolean verifyCartIconMatches() {
        int noOnCart = Integer.parseInt(cartBtn.getText());
        //System.out.println(noOnCart +" " + noOfItemsOnCart);
        return noOnCart == noOfItemsOnCart;

    }
    public void addItemsToCart() {
        noOfItemsOnCart = addToCartBtnList.size();
        for (WebElement prod : addToCartBtnList) {
            prod.click();
        }
    }
}
