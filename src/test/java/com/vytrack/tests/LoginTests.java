package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {

    private WebDriver driver;
    private String environment = "https://qa1.vytrack.com/";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");


    @Test(description = "Login as store manager")
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys("storemanager85");
        driver.findElement(passwordBy).sendKeys("UserUser123");
        BrowserUtilities.wait(3);
    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get(environment);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }

}
