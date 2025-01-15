package com.saucedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePage {
    private By confirmationMessage = By.className("complete-header");

    public ConfirmationPage(WebDriver driver) {

        super(driver);
    }

    public boolean isConfirmationDisplayed() {

        return isElementDisplayed(confirmationMessage);
    }
}
