package com.example;

import com.example.base.BaseTest;
import com.example.pages.BrokenLinksPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class BrokenLinksTest extends BaseTest {

    @Test
    public void testFindBrokenLinks() {
        BrokenLinksPage linksPage = new BrokenLinksPage(driver);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Use SoftAssert because we don't want the test to stop at the first broken link found.
        // We want to collect ALL broken links and report them at the end.
        SoftAssert softAssert = new SoftAssert();

        List<WebElement> links = linksPage.getFooterLinks();
        
        log.info("Total footer links to check: " + links.size());

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            
            try {
                HttpURLConnection conn = (HttpURLConnection) new URI(url).toURL().openConnection();
                conn.setRequestMethod("HEAD"); // Only requesting Headers is faster than full GET
                conn.connect();
                
                int responseCode = conn.getResponseCode();
                
                log.info(link.getText() + " -> " + url + " is " + responseCode);
                
                // Assert that the response code is less than 400 (4xx and 5xx are errors)
                softAssert.assertTrue(responseCode < 400, "The link with Text: " + link.getText() + " is broken with code " + responseCode);
                
            } catch (IOException | URISyntaxException e) {
                softAssert.fail("Exception while trying to connect to " + url);
            }
        }
        
        // This will fail the test if any of the above assertions failed
        softAssert.assertAll();
    }
}
