package com.mytheresa.steps;


import com.mytheresa.WebDriverUtils;
import com.mytheresa.steps.pages.HomePage;
import com.mytheresa.steps.pages.Page;
import com.mytheresa.steps.pages.SearchPage;
import com.mytheresa.steps.pages.SearchReslutsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class GeneralSteps {

    private WebDriver driver = WebDriverUtils.getExistingChromeDriver();

    @Given("User opens {string} page")
    public void user_is_on_page(String pageName) {
        if (pageName.equals("Home")) {
            driver.get("https://www.mytheresa.com/en-de/");
        } else {
            throw new IllegalArgumentException(pageName + " is invalid page");
        }
    }

    @Then("User is on {string} page")
    public void verify_page(String pageName) {
        if (pageName.equals("Women")) {
            SearchPage searchPage = new SearchPage(driver);
            Assert.assertTrue(searchPage.isSearchPage());
        } else if (pageName.equals("Search")) {
            SearchReslutsPage searchResultsPage = new SearchReslutsPage(driver);
            Assert.assertTrue(searchResultsPage.isSearchResultPage());
        } else {
            throw new IllegalArgumentException(pageName + " is invalid page");
        }
    }

    @When("User clicks on {string} link")
    public void userClicksOnLink(String fieldName) {
        Page page = new Page(driver);
        page.clickOnLinkText(fieldName);
    }

    @When("User accepts {string} popup")
    public void userAcceptsCookiePopup(String popupName) {
        if (popupName.equals("Cookie")) {
            HomePage homePage = new HomePage(driver);
            homePage.confirmCookies();
        } else {
            throw new IllegalArgumentException(popupName + " is invalid pop up");
        }
    }
}
