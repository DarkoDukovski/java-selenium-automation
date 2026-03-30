package com.example;

import com.example.base.BaseTest;
import com.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChildWindowTest extends BaseTest {

    @Test
    public void windowHandleAndLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        
        loginPage.clickOnBlinkingText();
        String email = loginPage.extractEmailFromChildWindow();
        loginPage.enterUsername(email);
        
        // Final assertion to verify email was entered properly
        Assert.assertFalse(email.isEmpty(), "Email should not be empty.");
    }
}
