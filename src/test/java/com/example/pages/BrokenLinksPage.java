package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrokenLinksPage extends BasePage {

    // Locator to find all links in the page
    private By allLinks = By.tagName("a");
    // Specific footer link area on Rahul Shetty site (often used for broken links tasks)
    private By footerLinks = By.cssSelector("li[class='gf-li'] a");

    public BrokenLinksPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllLinks() {
        return driver.findElements(allLinks);
    }

    public List<WebElement> getFooterLinks() {
        return driver.findElements(footerLinks);
    }
}
