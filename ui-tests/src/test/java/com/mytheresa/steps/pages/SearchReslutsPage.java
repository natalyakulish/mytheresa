package com.mytheresa.steps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchReslutsPage extends Page {

    private static final String FOUND_PRODUCTS_REGEX = "(\\d*) products{0,1}";
    private static final Pattern FOUND_PRODUCTS_PATTERN = Pattern.compile(FOUND_PRODUCTS_REGEX);

    public SearchReslutsPage(WebDriver driver) {
        super(driver);
    }

    public int getAmountOfFoundProducts() {
        int result = 0;

        String textResult = driver.findElement(By.xpath("//div[@class='toolbar-top']//p[@class='amount amount-has-pages']")).getText();

        Matcher matcher = FOUND_PRODUCTS_PATTERN.matcher(textResult);
        if (matcher.matches()) {
            result = Integer.parseInt(matcher.group(1));
        }

        return result;
    }

    public boolean isSearchResultPage() {
        return getUrl().contains("catalogsearch/result");
    }
}
