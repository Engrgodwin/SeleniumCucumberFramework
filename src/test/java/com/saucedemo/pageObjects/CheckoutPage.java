package com.saucedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By zipCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");

    public CheckoutPage(WebDriver driver) {

        super(driver);
    }

    public void enterShippingDetails(String firstName, String lastName, String zipCode) {
        enterText(firstNameField, firstName);
        enterText(lastNameField, lastName);
        enterText(zipCodeField, zipCode);
        click(continueButton);
    }

    public void completePurchase() {

        click(finishButton);
    }


}
