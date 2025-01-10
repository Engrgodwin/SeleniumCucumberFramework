package com.saucedemo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/resources/features",
        glue = "com.saucedemo.steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        tags = "@login",
        monochrome = true

)

public class TestRunner extends AbstractTestNGCucumberTests {
}
