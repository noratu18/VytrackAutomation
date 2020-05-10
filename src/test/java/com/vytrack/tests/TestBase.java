package com.vytrack.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public abstract class TestBase {

    //will be visible in subclasses
    protected WebDriverWait wait;
    protected Actions actions;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;


    @BeforeTest
    @Parameters("reportName")
    public void setupTest(@Optional String reportName){
        System.out.println("Report name: " + reportName);
        reportName = reportName == null ? "report.html" : reportName + " .html";
        report = new ExtentReports();

        String reportPath = System.getProperty("user.dir") + "/test-output/" + reportName;

        htmlReporter = new ExtentHtmlReporter(reportPath);
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Homework Results");


    }

    @AfterTest
    public void afterTest(){
        report.flush();// to release a report
    }

    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("environment");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 20);
        actions = new Actions(Driver.getDriver());
    }

    @AfterMethod
    public  void tearDown(ITestResult iTestResult) throws IOException {
        //ITestResult class dscribes the result of a test
        //if test fails, takes a screenshot
        if(iTestResult.getStatus()==ITestResult.FAILURE){
            String screenshotPath = BrowserUtilities.getScreenShot(iTestResult.getName());
            test.fail(iTestResult.getName());

            test.addScreenCaptureFromPath(screenshotPath, "Failed");
            test.fail(iTestResult.getThrowable());


        }

        BrowserUtilities.wait(2);
        Driver.closeDriver();
    }
}
