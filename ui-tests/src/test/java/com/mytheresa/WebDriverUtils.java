package com.mytheresa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverUtils {

    private static WebDriver driver;

    public static WebDriver getNewChromeDriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        return driver;
    }

    public static WebDriver getExistingChromeDriver() {
        if (driver == null) {
            driver = getNewChromeDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

}
