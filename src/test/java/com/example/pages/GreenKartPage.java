package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class GreenKartPage extends BasePage {

    private By searchBox = By.id("search-field");
    private By productNamesInTable = By.xpath("//tr/td[1]");
    private By nextButton = By.xpath("//a[@aria-label='Next']");

    public GreenKartPage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String name) {
        type(searchBox, name);
    }

    public List<String> getProductNamesFromTable() {
        return driver.findElements(productNamesInTable).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickNextPage() {
        click(nextButton);
    }
}
