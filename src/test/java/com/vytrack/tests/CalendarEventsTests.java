package com.vytrack.tests;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.DateTimeUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class CalendarEventsTests extends TestBase {

    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();


    @Test(description = "Verify that view, edit, and delete options are available")
    public void testCase1(){
        test = report.createTest("Verify three options");

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
       loginPage.login();
       calendarEventsPage.navigateTo("Activities", "Calendar Events");
       calendarEventsPage.hoverOnThreeDots();

        Assert.assertTrue(calendarEventsPage.viewOption().isDisplayed());
        Assert.assertTrue(calendarEventsPage.editOption().isDisplayed());
        Assert.assertTrue(calendarEventsPage.deleteOption().isDisplayed());

    }

    @Test(description = "Verify that Title column still displayed")
        public void testCase2(){
        test = report.createTest("Verify Title still displayed");

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");

        calendarEventsPage.clickGrid();

        calendarEventsPage.deselectTitle();

        Assert.assertTrue(calendarEventsPage.getTitle().isDisplayed());


    }

    @Test(description = "Verify that Save and Close, Save and New, Save options displayed")
    public void testCase3() {
        test = report.createTest("Verify Save options are displayed");

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");

        calendarEventsPage.createCalendarEvent();
        calendarEventsPage.clickSaveAndClose();

        Assert.assertTrue(calendarEventsPage.saveAndCloseOption().isDisplayed());
        Assert.assertTrue(calendarEventsPage.saveAndNewOption().isDisplayed());
        Assert.assertTrue(calendarEventsPage.saveOption().isDisplayed());
    }

        @Test(description = "Verify that All Calendar Events page subtitle is  displayed")
        public void testCase4() {
            test = report.createTest("Verify All Calendar Events Page is displayed");

            LoginPage loginPage = new LoginPage();
            CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
            loginPage.login();
            calendarEventsPage.navigateTo("Activities", "Calendar Events");

            calendarEventsPage.createCalendarEvent();
            calendarEventsPage.clickCancelButton();

            Assert.assertTrue(calendarEventsPage.AllCalendarEventsTitle().isDisplayed());
    }

         @Test(description = "Verify that time difference between end and start time is 1 hour")
        public void testCase5() {
             test = report.createTest("Verify that end and start time difference 1 hour");

             LoginPage loginPage = new LoginPage();
             CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
             loginPage.login();
             calendarEventsPage.navigateTo("Activities", "Calendar Events");

             calendarEventsPage.createCalendarEvent();

             String startTime =calendarEventsPage.getStartTime();
             String endTime = calendarEventsPage.getEndTime();
             String format = "h:mm a";

             Assert.assertEquals(DateTimeUtilities.getTimeDifference(startTime, endTime, format),1);


             test.pass("Time difference verified");

         }

    @Test(description = "Verify that time difference between starts at 9:00 pm and ends at 10:00 pm")
    public void testCase6() {
        test = report.createTest("Verify that end time is 10 pm");

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");

        calendarEventsPage.createCalendarEvent();
        calendarEventsPage.selectNinePm();

        String tenPM = calendarEventsPage.getEndTime();
        String actual = "10:00 PM";

        Assert.assertEquals(actual, tenPM);

    }

    @Test(description = "Verify that All Day Event checkbox selected and start, end dates are displayed")
    public void testCase7() {
        test = report.createTest("Verify that All Day Event checkbox selected");

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");

        calendarEventsPage.createCalendarEvent();
        calendarEventsPage.selectAllDayEvents();
        Assert.assertTrue(calendarEventsPage.verifyAllDayEvents().isSelected());

        Assert.assertFalse(calendarEventsPage.startTimeInput().isDisplayed());
        Assert.assertFalse(calendarEventsPage.endTimeInput().isDisplayed());
        Assert.assertTrue(calendarEventsPage.getStartDate().isDisplayed());
        Assert.assertTrue(calendarEventsPage.getEndDate().isDisplayed());

    }

    @Test(description = "Verify that Repeat checkbox is selected and dropdown available")
    public void testCase8() {
        test = report.createTest("Verify Repeat dropdown");

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.createCalendarEvent();

        calendarEventsPage.clickRepeatCheckbox();
      Assert.assertFalse(calendarEventsPage.selectRepeatCheckbox().isSelected());

        Select select = new Select(calendarEventsPage.dailyDropDown());
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Daily");

        List<WebElement> repeatsDropDown = select.getOptions();
        Assert.assertEquals(repeatsDropDown.get(0).getText(), "Daily");
        Assert.assertEquals(repeatsDropDown.get(1).getText(), "Weekly");
        Assert.assertEquals(repeatsDropDown.get(2).getText(), "Monthly");
        Assert.assertEquals(repeatsDropDown.get(3).getText(), "Yearly");

    }


    @Test(description = "Verify that Repeat,Repeat Every,Never buttons selected and Summary message is displayed")
    public void testCase9() {
        test = report.createTest("Verify Radio buttons");

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.createCalendarEvent();

        calendarEventsPage.clickRepeatCheckbox();
        Assert.assertTrue(calendarEventsPage.selectRepeatCheckbox().isSelected());

        Assert.assertTrue(calendarEventsPage.selectRepeatEvery().isSelected());
        Assert.assertTrue(calendarEventsPage.selectNeverEnds().isSelected());
        Assert.assertTrue(calendarEventsPage.displaySummaryMessage().isDisplayed());

    }

    @Test(description = "Verify that after 10 occurencess summary message is displayed")
    public void testCase10() {
        test = report.createTest("Verify after 10 occurences");

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.createCalendarEvent();

        calendarEventsPage.clickRepeatCheckbox();
        calendarEventsPage.selectAfterBtn();
        calendarEventsPage.send10Occurences("10");

        String expected = "Summary: Daily every 1day, end after 10 occurrences";
        String actual = calendarEventsPage.verifySummaryMessage();

    }

    @Test(description = "Verify by Nov 18, 2021 summary message is displayed")
    public void testCase11() {
        test = report.createTest("Verify that dates are displayed");

        LoginPage loginPage = new LoginPage();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.createCalendarEvent();

        calendarEventsPage.clickRepeatCheckbox();
        calendarEventsPage.clickOnByButton();
        calendarEventsPage.selectDateOptions("Nov 18, 2021");

        String expected = "Summary: Daily every 1 day, end by Nov 18, 2021";
        String actual = calendarEventsPage.verifyEndSummaryMsg();
        Assert.assertEquals(actual,expected);

    }





    }
