package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class StorePage extends BasePage {

    private By productNames = By.cssSelector("h4.product-name");
    private By addToCartButtons = By.xpath("//div[@class='product-action']/button");
    private By cartIcon = By.cssSelector("img[alt='Cart']");
    private By proceedToCheckoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    private By promoCodeInput = By.cssSelector("input.promoCode");
    private By promoApplyButton = By.cssSelector("button.promoBtn");
    private By promoInfo = By.cssSelector("span.promoInfo");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void addItemsToCart(String[] itemsNeeded) {
        int count = 0;
        List<WebElement> products = driver.findElements(productNames);
        List<String> itemsNeededList = Arrays.asList(itemsNeeded);

        for (int i = 0; i < products.size(); i++) {
            String formattedName = products.get(i).getText().split("-")[0].trim();
            if (itemsNeededList.contains(formattedName)) {
                count++;
                driver.findElements(addToCartButtons).get(i).click();
                if (count == itemsNeeded.length) break;
            }
        }
    }

    public void proceedToCheckout() {
        click(cartIcon);
        click(proceedToCheckoutButton);
    }

    public void applyPromoCode(String promoCode) {
        type(promoCodeInput, promoCode);
        click(promoApplyButton);
    }

    public String getPromoInfoText() {
        waitForElementToBeVisible(promoInfo);
        return driver.findElement(promoInfo).getText();
    }
}
