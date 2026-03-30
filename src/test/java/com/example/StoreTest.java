package com.example;

import com.example.base.BaseTest;
import com.example.pages.StorePage;
import com.example.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class StoreTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void addItemAndCheckoutTest(HashMap<String, Object> input) throws InterruptedException {
        // Parse data from HashMap provided by the JSON Array
        List<String> itemsList = (List<String>) input.get("items");
        String[] itemsNeeded = itemsList.toArray(new String[0]);
        String promoCode = (String) input.get("promoCode");
        String expectedMessage = (String) input.get("expectedMessage");

        log.info("Starting checkout test with items: " + itemsList.toString());

        StorePage storePage = new StorePage(driver);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        storePage.addItemsToCart(itemsNeeded);
        storePage.proceedToCheckout();
        storePage.applyPromoCode(promoCode);

        String promoMessage = storePage.getPromoInfoText();
        Assert.assertEquals(promoMessage, expectedMessage, "Promo code response didn't match!");
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        // Provides execution data by reading the JSON file
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\storeData.json";
        List<HashMap<String, Object>> data = JsonReader.getJsonDataToMap(path);
        
        return new Object[][] {
                {data.get(0)},
                {data.get(1)}
        };
    }
}
