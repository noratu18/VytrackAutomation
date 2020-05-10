package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 15);

    /**
     * my constructor
     * PageFactory helps find elements easier, more organized
     */
    public BasePage(){

        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String tabName, String moduleName){

        String tabActivities = "//span[@class='title title-level-1' and contains (text(),'Activities')]";
        String moduleCalendarEvent ="//span[@class='title title-level-2' and text()='Calendar Events']";

        WebElement tabElement = driver.findElement(By.xpath(tabActivities));
        WebElement moduleElement = driver.findElement(By.xpath(moduleCalendarEvent));

        Actions actions = new Actions(driver);

        BrowserUtilities.wait(4);

        actions.moveToElement(tabElement).pause(2000).click(moduleElement).build().perform();

        BrowserUtilities.wait(4);



    }



}
