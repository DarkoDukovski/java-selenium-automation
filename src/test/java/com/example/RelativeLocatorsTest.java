package com.example;

import com.example.base.BaseTest;
import com.example.pages.AngularPracticePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RelativeLocatorsTest extends BaseTest {

    @Test
    public void testRelativeLocators() {
        AngularPracticePage practicePage = new AngularPracticePage(driver);
        
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        
        // 1. Text Label above Name Edit Box
        String labelName = practicePage.getNameLabelUsingAbove();
        log.info("Name Label: " + labelName);
        Assert.assertEquals(labelName, "Name", "Parent label of name field should be 'Name'");
        
        // 2. Checkbox to the Left of Ice Cream Label
        practicePage.clickIceCreamCheckboxUsingLeftOf();
        
        // 3. Label to the Right of Radio Button
        String radioLabel = practicePage.getRadioButtonLabelUsingToRightOf();
        log.info("Radio Label: " + radioLabel);
        Assert.assertEquals(radioLabel, "Student", "Label next to first radio button should be 'Student'");
    }
}
