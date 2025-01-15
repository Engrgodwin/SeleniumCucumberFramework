package com.saucedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage {

    // Static elements identified by @FindBy
    @FindBy(className = "inventory_item_name")
    private WebElement inventoryContainer;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Dynamic element for addItemButton
    private WebElement getAddItemButton(String itemName) {

        String productXpath = "//div[text()='" + itemName + "']/ancestor::div[@class='inventory_item']//button";

        return driver.findElement(By.xpath(productXpath));
    }

    public void addItemToCart(String itemName) {
        WebElement addItemButton = getAddItemButton(itemName);
        if (addItemButton.isDisplayed() && addItemButton.isEnabled()) {
            addItemButton.click();
        } else {
            throw new RuntimeException("Add to Cart button for item '" + itemName + "' is not clickable.");
        }
    }

    public void clickShoppingCartLink() {
        if (shoppingCartLink.isDisplayed() && shoppingCartLink.isEnabled()) {
            shoppingCartLink.click();
        } else {
            throw new RuntimeException("Shopping cart link is not clickable.");
        }
    }

    public boolean isPageDisplayed() {
        try {
            return inventoryContainer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }




}
