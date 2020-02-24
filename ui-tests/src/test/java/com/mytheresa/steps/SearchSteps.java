package com.mytheresa.steps;


import com.mytheresa.WebDriverUtils;
import com.mytheresa.steps.pages.SearchPage;
import com.mytheresa.steps.pages.SearchReslutsPage;
import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SearchSteps {

    private WebDriver driver = WebDriverUtils.getExistingChromeDriver();

    @And("User searches for {string}")
    public void userSearchesFor(String text) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search(text);
    }

    @And("User sees positive amount of products")
    public void userSeesPositiveAmountOfProducts() {
        SearchReslutsPage searchReslutsPage = new SearchReslutsPage(driver);
        int amountOfFoundProducts = searchReslutsPage.getAmountOfFoundProducts();
        Assert.assertTrue(amountOfFoundProducts > 0);
    }
}
