package com.vytrack.utilities;

import com.aventstack.extentreports.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowserUtilities {


    public static void wait(int seconds){
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param elements represents collection of WebElements
     * @return collection of Strings
     */
    public static List<String> getTextFromWebElements(List<WebElement> elements){
        List<String> textValues = new ArrayList<>();
        for(WebElement element : elements){
            if(!element.getText().isEmpty()){
                textValues.add(element.getText());
            }
        }
        return textValues;
    }

    /**
     * waits for backgrounds processes on the browser to complete
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).
                executeScript("return document.readyState").equals("complete");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);


    }

    /**
     * Clicks on an element using Javascript
     * @param element
     */
    public static void clickWithJS(WebElement element){
        ( (JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);

    }

    /**
     * scroll to element using JavaScript
     * @param element
     */
    public static void scrollTo(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);

    }

    /**
     * method that takes a screenshot
     * @param name
     * @return
     */
    public static String getScreenShot(String name){
        //addinf date and time to screenshot name
        name = new Date().toString().replace(" ", "_").replace(":", "_") + "_"+name;
        name = new Date().toString() + "_" + name;

        String path = "";
        if(System.getProperty("os.name").toLowerCase().contains("mac")){
            path = System.getProperty("user.dir")+"/test-output/screenshots/"+name+".png";
        }else{
            //is this path for windows?
            path = System.getProperty("user.dir")+ "\\test-output\\screenshots\\"+ name + ".png";
        }
        System.out.println("OS name: "+ System.getProperty("os.name"));
        System.out.println("Screenshot is here: " + path);
        TakesScreenshot takesScreenshot = (TakesScreenshot)Driver.getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(path);

        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return path;
    }
}
