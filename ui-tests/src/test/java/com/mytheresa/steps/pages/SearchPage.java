package com.mytheresa.steps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends Page {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        WebElement searchElement = driver.findElement(By.id("search"));
        searchElement.sendKeys(text);
        searchElement.submit();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.urlContains("catalogsearch/result"));
    }

    public boolean isSearchPage() {
        return getUrl().endsWith("women.html");
    }
}
