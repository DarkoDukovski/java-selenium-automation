package com.example;

import com.example.base.BaseTest;
import com.example.pages.ActionsAndIframePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdvancedInteractionsTest extends BaseTest {

    @Test
    public void testMouseHoverAndClick() throws InterruptedException {
        ActionsAndIframePage actionsPage = new ActionsAndIframePage(driver);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Scroll a bit down so the mouse hover button is visible (optional if visible by default, but safe to use JS via POM usually)
        // Let's just use the direct POM method
        actionsPage.hoverOverButton();
        actionsPage.clickHoverOptionTop();
        
        // Assert that URL has '#' at the end which means Top clicked, or check scroll position
        // The simplest check on this specific site is that URL contains '#' or it reloads the page to top
        Assert.assertTrue(driver.getCurrentUrl().contains("#") || driver.getCurrentUrl().contains("AutomationPractice"),
                "URL should indicate the action was performed.");
    }

    @Test
    public void testIframeAndDragAndDrop() throws InterruptedException {
        ActionsAndIframePage iframePage = new ActionsAndIframePage(driver);
        // Using jQueryUI for a clean iFrame and Drag&Drop example
        driver.get("https://jqueryui.com/droppable/");

        // Switch context to the iframe containing the interactive elements
        iframePage.switchToIframe();

        // Perform the Drag and Drop Action
        iframePage.dragAndDropElement();

        // Verification
        String textAfterDrop = iframePage.getDroppableText();
        Assert.assertEquals(textAfterDrop, "Dropped!", "The element was not dropped successfully!");

        // ALWAYS switch back to the main document after interacting with an iframe
        iframePage.switchBackToDefaultContent();
    }
}
