package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ReviewPage extends BasePage{

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    List<WebElement> priceList;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    WebElement priceOnPage;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    WebElement tax;

    @FindBy(id = "finish")
    WebElement finishBtn;

    public boolean isReviewPageDisplayed() {
        return finishBtn.isDisplayed();
    }

    public void clickFinishBtn() {
        finishBtn.click();
    }

    public void price() {
        System.out.print(priceList.get(0).getText());
    }
    public void calculatedTotPrice() {
        priceSum = 0;
        for (WebElement price : priceList) {
            String str = price.getText();
            double d = Double.parseDouble(str.replace("$",""));
            priceSum += d;
        }
        //System.out.println(priceSum);
    }

    public boolean verifyPriceIsCorrect() {
        String pricePart = priceOnPage.getText().replace("Item total: $", "");
        double price = Double.parseDouble(pricePart);
        //System.out.println(price);

        String taxPart = tax.getText().replace("Tax: $", "");
        double taxPrice = Double.parseDouble(taxPart);
        //System.out.println(taxPrice);
        return (price + taxPrice) == (priceSum + taxPrice);
    }
}
