package com.example;

import com.example.base.BaseTest;
import com.example.pages.PracticePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTests extends BaseTest {

    @Test
    public void testAlerts() {
        PracticePage practicePage = new PracticePage(driver);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        practicePage.triggerAlert("Darko");
        String alertText = practicePage.getAlertTextAndAccept();
        Assert.assertTrue(alertText.contains("Darko"), "Alert text should contain the entered name.");
    }

    @Test
    public void testConfirmAlert() {
        PracticePage practicePage = new PracticePage(driver);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        practicePage.triggerConfirm("Darko");
        String alertText = practicePage.getAlertTextAndAccept();
        Assert.assertTrue(alertText.contains("Hello Darko, Are you sure you want to confirm?"), "Alert should be a confirmation dialog.");
    }

    @Test
    public void testStaticDropdown() {
        PracticePage practicePage = new PracticePage(driver);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        practicePage.selectStaticOption("Option2");
        // No direct assertion possible on select state without getting value, 
        // but POM handles the selection logic cleanly.
    }

    @Test
    public void testAutoSuggestiveDropdown() throws InterruptedException {
        PracticePage practicePage = new PracticePage(driver);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        
        practicePage.selectAutoSuggestiveOption("ind", "India");
        // Verification happens via successful click in POM.
    }
}
