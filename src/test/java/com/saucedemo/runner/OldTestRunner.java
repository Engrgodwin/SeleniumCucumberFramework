package com.saucedemo.runner;


import com.saucedemo.baseDriver.BaseDriver;
import com.saucedemo.utils.ConfigReader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

@CucumberOptions(
        features = "src/resources/features",
        glue = {"com.saucedemo.stepDefinitions", "com.saucedemo.hooks"},
        tags = "@login",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"},
        monochrome = true
)
public class OldTestRunner extends AbstractTestNGCucumberTests {
    private String browser;

    @Factory(dataProvider = "browsers")
    public OldTestRunner(String browser) {

        this.browser = browser;
    }

    @DataProvider
    public static Object[][] browsers() {
        String[] browserArray = ConfigReader.getBrowsers();
        Object[][] data = new Object[browserArray.length][1];
        for (int i = 0; i < browserArray.length; i++) {
            data[i][0] = browserArray[i];
        }
        return data;
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        BaseDriver.getDriver(browser); // Initialize driver for the given browser
        return super.scenarios();
    }

}
