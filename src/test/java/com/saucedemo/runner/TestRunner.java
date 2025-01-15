package com.saucedemo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(

        features = "src/resources/features",
        glue = {"com.saucedemo.stepDefinitions", "com.saucedemo.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        tags = " @EndToEnd",
        monochrome = true

)

public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
