package com.saucedemo.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class WebElementsUtilities {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public WebElementsUtilities(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Set default timeout
    }

    /**
     * Wait for an element to be visible.
     *
     * @param locator By locator of the element
     * @return WebElement
     */
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait for an element to be clickable.
     *
     * @param locator By locator of the element
     * @return WebElement
     */
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Click on an element.
     *
     * @param locator By locator of the element
     */
    public void click(By locator) {
        waitForClickable(locator).click();
    }

    /**
     * Enter text into an input field.
     *
     * @param locator By locator of the input field
     * @param text    Text to enter
     */
    public void enterText(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Get the text of an element.
     *
     * @param locator By locator of the element
     * @return String text of the element
     */
    public String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    /**
     * Validate if an element is displayed.
     *
     * @param locator By locator of the element
     * @return boolean
     */
    public boolean isElementDisplayed(By locator) {
        try {
            return waitForVisibility(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Add an item to the cart based on the product name.
     *
     * @param productName Name of the product
     */
    public void addItemToCart(String productName) {
        String productXPath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button";
        click(By.xpath(productXPath));
    }

    /**
     * Remove an item from the cart based on the product name.
     *
     * @param productName Name of the product
     */
    public void removeItemFromCart(String productName) {
        String productXPath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button[text()='Remove']";
        click(By.xpath(productXPath));
    }

    /**
     * Get the number of items in the cart.
     *
     * @return int Number of items in the cart
     */
    public int getCartItemCount() {
        try {
            String countText = getText(By.className("shopping_cart_badge"));
            return Integer.parseInt(countText);
        } catch (NoSuchElementException e) {
            return 0; // Return 0 if the cart is empty
        }
    }

    /**
     * Hover over an element.
     *
     * @param locator By locator of the element
     */
    public void hoverOverElement(By locator) {
        Actions actions = new Actions(driver);
        WebElement element = waitForVisibility(locator);
        actions.moveToElement(element).perform();
    }

    /**
     * Take a screenshot and save it to a specified path.
     *
     * @param path Path to save the screenshot
     * @return String Path of the saved screenshot
     */
    public String takeScreenshot(String path) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("C://Users/Public/Documents/cucumberprojectstructure/Screentshot/");

        srcFile.renameTo(destFile);
        return destFile.getAbsolutePath();
    }

    /**
     * Scroll to an element.
     *
     * @param locator By locator of the element
     */
    public void scrollToElement(By locator) {
        WebElement element = waitForVisibility(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Perform a logout by clicking the menu and selecting the logout option.
     */
    public void performLogout() {
        click(By.id("react-burger-menu-btn")); // Open menu
        click(By.id("logout_sidebar_link"));  // Click logout
    }





}
