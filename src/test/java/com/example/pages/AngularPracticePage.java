package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class AngularPracticePage extends BasePage {

    private By nameEditBox = By.cssSelector("[name='name']");
    private By dateOfBirth = By.cssSelector("[for='dateofBirth']");
    private By iceCreamLabel = By.xpath("//label[text()='Check me out if you Love IceCreams!']");
    private By firstRadioButton = By.id("inlineRadio1");

    public AngularPracticePage(WebDriver driver) {
        super(driver);
    }

    public String getNameLabelUsingAbove() {
        WebElement nameField = driver.findElement(nameEditBox);
        return driver.findElement(with(By.tagName("label")).above(nameField)).getText();
    }

    public void clickIceCreamCheckboxUsingLeftOf() {
        WebElement label = driver.findElement(iceCreamLabel);
        driver.findElement(with(By.tagName("input")).toLeftOf(label)).click();
    }

    public String getRadioButtonLabelUsingToRightOf() {
        WebElement rdb = driver.findElement(firstRadioButton);
        return driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText();
    }
}
