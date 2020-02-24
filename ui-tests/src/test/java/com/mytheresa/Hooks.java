package com.mytheresa;

import cucumber.api.java.After;
import org.junit.Before;

public class Hooks {

    @Before
    public void setup() {
        WebDriverUtils.getNewChromeDriver();
    }

    @After
    public void tearDown() {
        WebDriverUtils.closeDriver();
    }
}
