package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    @FindBy(id = "prependedInput")
    private WebElement username;


    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;


    /**
     * to connect our WebDriver, page class and pageFactory
     * pageFactory--> used to @FindBy annotations
     */
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    /**
     * credentials are coming from configuration.properties
     */
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);

    }


}
