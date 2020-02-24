package com.mytheresa.steps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage confirmCookies() {
        driver.switchTo().frame("privacy-iframe");
        driver.findElement(By.xpath("//div[@id='privacy-cat-modal']//button[@class='btn btn-all']")).click();
        driver.switchTo().defaultContent();
        return new HomePage(driver);
    }

}
