package com.mytheresa.steps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        timeoutSeconds(5);
    }

    public void timeoutSeconds(int howlong) {
        driver.manage().timeouts().implicitlyWait(howlong, TimeUnit.SECONDS);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public Page clickOnLinkText(String pageName) {
        driver.findElement(By.linkText(pageName)).click();
        return new Page(driver);
    }
}
