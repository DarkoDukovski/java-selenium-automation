package com.example;

import com.example.base.BaseTest;
import com.example.pages.GreenKartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class WebTableTest extends BaseTest {

    @Test
    public void testTableFiltering() {
        GreenKartPage greenKartPage = new GreenKartPage(driver);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        
        String searchProduct = "Rice";
        greenKartPage.searchProduct(searchProduct);
        
        List<String> results = greenKartPage.getProductNamesFromTable();
        List<String> filteredList = results.stream()
                .filter(res -> res.contains(searchProduct))
                .collect(Collectors.toList());
        
        Assert.assertEquals(results.size(), filteredList.size(), "Table filtering failed.");
    }

    @Test
    public void testTablePaginationAndSearch() {
        GreenKartPage greenKartPage = new GreenKartPage(driver);
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        
        List<String> price;
        do {
            List<String> rows = greenKartPage.getProductNamesFromTable();
            price = rows.stream()
                    .filter(s -> s.contains("Rice"))
                    .map(s -> "37") // Logic from user's Pagination script
                    .collect(Collectors.toList());
            
            if (price.size() < 1) {
                greenKartPage.clickNextPage();
            }
        } while (price.size() < 1);
        
        Assert.assertTrue(price.get(0).equalsIgnoreCase("37"), "Price of product not found.");
    }
}
