package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class LoginPage extends BasePage {

    private By blinkingText = By.cssSelector(".blinkingText");
    private By paraRedText = By.cssSelector(".im-para.red");
    private By usernameField = By.id("username");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnBlinkingText() {
        click(blinkingText);
    }

    public String extractEmailFromChildWindow() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();
        
        driver.switchTo().window(childId);
        String text = driver.findElement(paraRedText).getText();
        String emailId = text.split("at")[1].trim().split(" ")[0];
        
        driver.switchTo().window(parentId);
        return emailId;
    }

    public void enterUsername(String username) {
        type(usernameField, username);
    }
}
