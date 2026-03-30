package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsAndIframePage extends BasePage {

    // Locators for Mouse Hover (Rahul Shetty Practice Page)
    private By mouseHoverBtn = By.id("mousehover");
    private By mouseHoverTopOption = By.xpath("//a[text()='Top']");

    // Locators for Drag and Drop & iFrame (jQueryUI Droppable)
    private By iframeElement = By.cssSelector("iframe.demo-frame");
    private By draggable = By.id("draggable");
    private By droppable = By.id("droppable");

    public ActionsAndIframePage(WebDriver driver) {
        super(driver);
    }

    // --- Mouse Hover Methods ---
    
    public void hoverOverButton() {
        WebElement hoverElement = driver.findElement(mouseHoverBtn);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverElement).build().perform();
    }

    public void clickHoverOptionTop() {
        waitForElementToBeVisible(mouseHoverTopOption);
        WebElement topOption = driver.findElement(mouseHoverTopOption);
        Actions actions = new Actions(driver);
        actions.moveToElement(topOption).click().build().perform();
    }

    // --- iFrame & Drag and Drop Methods ---

    public void switchToIframe() {
        WebElement frame = driver.findElement(iframeElement);
        driver.switchTo().frame(frame);
    }

    public void switchBackToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void dragAndDropElement() {
        WebElement source = driver.findElement(draggable);
        WebElement target = driver.findElement(droppable);
        
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
    }

    public String getDroppableText() {
        return driver.findElement(droppable).getText();
    }
}
