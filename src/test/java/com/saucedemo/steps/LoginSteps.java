package com.saucedemo.steps;

import com.saucedemo.baseDriver.BaseDriver;
import com.saucedemo.pageObjects.LoginPage;
import com.saucedemo.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver = BaseDriver.getDriver("chrome");
    private LoginPage loginPage = new LoginPage(driver);


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page(){

        //Get the driver to call the application url
        String url = ConfigReader.getProperty("baseUrl");
        driver.get(url);


    }

    @When("the user enters valid credentials {string} and {string}")
    public void the_user_enters_valid_credentials_and(String username, String password){

        loginPage.login(username, password);

    }

    @Then("the user is redirected to the products page")
    public void the_user_is_redirected_to_the_products_page(){

        String investoryUrl =  driver.getCurrentUrl();
        assert investoryUrl.contains("inventory.html");


    }





}
