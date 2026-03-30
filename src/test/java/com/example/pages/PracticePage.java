package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class PracticePage extends BasePage {

    // Locators for Alerts
    private By nameInput = By.id("name");
    private By alertBtn = By.id("alertbtn");
    private By confirmBtn = By.id("confirmbtn");

    // Locators for Dropdowns
    private By staticDropdown = By.id("dropdown-class-example");
    private By autoSuggestiveInput = By.id("autocomplete");
    private By autoSuggestOptions = By.cssSelector("li.ui-menu-item div");

    // Locators for Tables / Filter
    private By tableRows = By.cssSelector(".table-display tr td:nth-child(2)");

    public PracticePage(WebDriver driver) {
        super(driver);
    }

    // Alert Actions
    public void triggerAlert(String name) {
        type(nameInput, name);
        click(alertBtn);
    }

    public void triggerConfirm(String name) {
        type(nameInput, name);
        click(confirmBtn);
    }

    public String getAlertTextAndAccept() {
        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return text;
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    // Dropdown Actions
    public void selectStaticOption(String optionText) {
        Select select = new Select(driver.findElement(staticDropdown));
        select.selectByVisibleText(optionText);
    }

    public void selectAutoSuggestiveOption(String query, String expectedOption) {
        type(autoSuggestiveInput, query);
        waitForElementToBeVisible(autoSuggestOptions);
        List<WebElement> options = driver.findElements(autoSuggestOptions);
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(expectedOption)) {
                option.click();
                break;
            }
        }
    }

    // Table / Filter Actions
    public List<String> getProductList() {
        return driver.findElements(tableRows).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
