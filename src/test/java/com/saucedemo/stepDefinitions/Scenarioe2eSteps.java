package com.saucedemo.stepDefinitions;

import com.saucedemo.baseDriver.BaseDriver;
import com.saucedemo.pageObjects.*;
import com.saucedemo.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Scenarioe2eSteps {
    // Declare the WebDriver instance to pass to page objects
    private static final String browser = ConfigReader.getProperty("browser").split(",")[0]; // Use the first browser
    private static final WebDriver driver = BaseDriver.getDriver(browser);

    // Page object instances
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    ConfirmationPage confirmationPage = new ConfirmationPage(driver);


    /**
     * Navigates to the login page.
     */
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        String url = ConfigReader.getProperty("baseUrl");
        driver.get(url);
    }

    @When("user logs in with {string} and {string}")
    public void user_logs_in_with_and(String username, String password) {

        loginPage.login(username, password);
    }

    @Then("user should see the inventory page")
    public void user_should_see_the_inventory_page() {

        Assert.assertTrue(inventoryPage.isPageDisplayed());
    }

    @When("user adds item {string} to the cart")
    public void user_adds_item_to_the_cart(String itemName) {

        inventoryPage.addItemToCart(itemName);
    }

    @And("user proceeds to the cart")
    public  void the_user_proceeds_to_the_cart() {
        inventoryPage.clickShoppingCartLink();
    }

    @And("user proceeds to checkout")
    public void user_proceeds_to_checkout() {

        cartPage.proceedToCheckout();
    }

    @And("user enters shipping details {string}, {string}, {string}")
    public void user_enters_shipping_details(String firstName, String lastName, String zipCode) {
        checkoutPage.enterShippingDetails(firstName, lastName, zipCode);
    }

    @When("user completes the purchase")
    public void user_completes_the_purchase() {

        checkoutPage.completePurchase();
    }

    @Then("user should see the confirmation page")
    public void user_should_see_the_confirmation_page() {
        Assert.assertTrue(confirmationPage.isConfirmationDisplayed(), "Confirmation page is not displayed after completing the purchase.");
    }
}
