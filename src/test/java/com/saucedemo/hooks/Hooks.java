package com.saucedemo.hooks;

import com.saucedemo.basedriver.WebDriverUtilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Hooks {
    @BeforeClass
    public void setUp() {
        // Initialize driver before each scenario
        WebDriverUtilities.getDriver();
    }

    @AfterClass
    public void tearDown() {
        // Quit driver after each scenario
        WebDriverUtilities.quitDriver();
    }









}
