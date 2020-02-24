package com.mytheresa;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        plugin = {
          "pretty",
          "html:target/cucumber/html",
          "json:target/cucumber/report.json"
        }
)
public class RunnerTest {

}
