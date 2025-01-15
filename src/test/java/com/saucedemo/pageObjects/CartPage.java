package com.saucedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {

        super(driver);
    }

    public void proceedToCheckout() {
        click(checkoutButton);
    }

}
