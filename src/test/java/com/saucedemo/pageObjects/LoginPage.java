package com.saucedemo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    /* On every page get all the UI elements that the webdriver can interract with and represent them as
    object in each individual page class e.g links, menu, buttons, form fills, logo.
    You can find them findelement By ID, class, Xpath
    If you using page factory, use Annotations e.g @FindBy (id = "user-name")
    */

 private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement username;

    // Do for password
    // Do for Login button

    @FindBy(id = "password")
    private  WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    //Create the constructor of the page

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void login(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();



    }










}
