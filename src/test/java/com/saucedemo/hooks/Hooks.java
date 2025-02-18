package com.saucedemo.hooks;


import com.saucedemo.baseDriver.BaseDriver;
import com.saucedemo.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Hooks {
    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Starting scenario: " + scenario.getName());
        String browser = ConfigReader.getProperty("browser").split(",")[0];
        BaseDriver.getDriver(browser);
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Scenario " + scenario.getName() + " finished with status: " + scenario.getStatus());
        BaseDriver.quitDriver();
    }

}
