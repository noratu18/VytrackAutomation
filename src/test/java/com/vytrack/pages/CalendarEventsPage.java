package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

public class CalendarEventsPage extends BasePage{

    @FindBy(xpath = "//tbody[@class='grid-body']/tr[1]//a[.='...']")
    private WebElement threeDots;
    @FindBy(xpath="//a[@href='/calendar/event/view/1846']/i[@class='fa-eye hide-text']")
    private WebElement view;
    @FindBy(xpath = "//a[@href='/calendar/event/update/1846']/i[@class='fa-pencil-square-o hide-text']")
    private WebElement edit;
    @FindBy(xpath="//*[@href='/calendar/event/update/1846']/../following-sibling::*//a")
    private WebElement delete;

    @FindBy(xpath = "//*[@title='Grid Settings']")
    private WebElement gridIcon;
    @FindBy(xpath = "//label[.='Title']")
    private WebElement title;

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;
    @FindBy(xpath = "(//*[@data-toggle='dropdown'])[4]")
    private WebElement saveAndCloseExpand;
    @FindBy(xpath = "//ul/li/button[contains(text(),'Save and Close')]")
    private WebElement saveAndClose;
    @FindBy(xpath = "//ul/li/button[contains(text(),'Save and New')]")
    private WebElement saveAndNew;
    @FindBy(xpath = "(//ul/li/button[contains(text(),'Save')])[3]")
    private WebElement save;

    @FindBy(xpath = "//a[@title='Cancel']")
    private WebElement cancelButton;
    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement allCalendarEvents;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;
    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(xpath = "//li[text()='9:00 PM']")
    private WebElement ninePm;

    @FindBy(id= "oro_calendar_event_form_allDay-uid-5eb44ea3ae475")
    private WebElement allDayEventCheckbox;
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;
    @FindBy(id = "date_selector_oro_calendar_event_form_end-uid-5eb44ea3ae392")
    private WebElement endDate;

    @FindBy(css="[id^='recurrence-repeat-view']")
    private WebElement repeatCheckbox;
    @FindBy(css = "select[id^='recurrence-repeats-view']")
    private WebElement dailyDefault;

    @FindBy(xpath = "//input[@checked='checked']")
    private WebElement repeatEveryRadioBtn;
    @FindBy(xpath = "(//input[@type='radio'])[3]")
    private WebElement neverEndsRadiobtn;
    @FindBy(xpath = "//div[@class='control-group recurrence-summary alert-info']")
    private WebElement summaryMessage;

    @FindBy(xpath = "(//input[@type=\"radio\"])[4]")
    private WebElement afterRadioBtn;
    @FindBy(xpath = "//*[@data-related-field='occurrences']")
    private WebElement occurencesBox;
    @FindBy(xpath = "//div[@class='control-group recurrence-summary alert-info']")
    private WebElement summaryDailyMsg;

    @FindBy(xpath = "(//input[@type='radio'])[5]")
    private WebElement byRadioBtn;
    @FindBy(xpath = "//*[@class='datepicker-input hasDatepicker']")
    private WebElement dateBox;
    @FindBy(xpath = "//div[@class='control-group recurrence-summary alert-info']")
    private WebElement summaryDateMsg;
















    //Test Case 1
    public void hoverOnThreeDots(){
        Actions actions = new Actions(driver);
        BrowserUtilities.waitForPageToLoad(10);
        actions.moveToElement(threeDots).pause(2000).perform();
        BrowserUtilities.wait(4);

    }
    public WebElement viewOption(){
        BrowserUtilities.wait(2);
        wait.until(ExpectedConditions.visibilityOf(view));

        return view;
    }

    public WebElement editOption(){
       BrowserUtilities.wait(2);
        wait.until(ExpectedConditions.visibilityOf(edit));

        return edit;
    }

    public WebElement deleteOption(){
     BrowserUtilities.wait(2);
        wait.until(ExpectedConditions.visibilityOf(delete));

        return delete;
    }

    //Test Case 2
    public void clickGrid(){
        BrowserUtilities.wait(2);
        wait.until(ExpectedConditions.visibilityOf(gridIcon)).click();

    }
    public void  deselectTitle(){
        BrowserUtilities.wait(2);
        List<WebElement> gridSettings= driver.findElements(By.xpath("//*[@data-role='renderable']"));
        for (int i = 1; i < gridSettings.size(); i++) {
            gridSettings.get(i).click();
            BrowserUtilities.wait(2);
        }
    }

    public WebElement getTitle(){
        BrowserUtilities.wait(2);
        return title;
    }

    //Test Case 3
    public void createCalendarEvent(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
    }

    public void clickSaveAndClose(){
        BrowserUtilities.wait(10);
        wait.until(ExpectedConditions.visibilityOf(saveAndCloseExpand)).click();
        BrowserUtilities.wait(2);
    }

    public WebElement saveAndCloseOption(){
        wait.until(ExpectedConditions.visibilityOf(saveAndClose));
        BrowserUtilities.wait(2);
        return saveAndClose;
    }

    public WebElement saveAndNewOption(){
        wait.until(ExpectedConditions.visibilityOf(saveAndNew));
        BrowserUtilities.wait(2);
        return saveAndNew;
    }

    public WebElement saveOption(){
        wait.until(ExpectedConditions.visibilityOf(save));
        BrowserUtilities.wait(2);
        return save;
    }

    //Test Case 4
    public void clickCancelButton(){
        wait.until(ExpectedConditions.visibilityOf(cancelButton)).click();
        BrowserUtilities.wait(2);
    }

    public WebElement AllCalendarEventsTitle(){
        BrowserUtilities.waitForPageToLoad(5);
        wait.until(ExpectedConditions.elementToBeClickable(allCalendarEvents)).click();
        BrowserUtilities.wait(2);
        return allCalendarEvents;
    }

    //Test Case 5
    public String getStartTime() {
        BrowserUtilities.waitForPageToLoad(10);
        //we can use if giving error no such element found in startTime
        //  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^='time_selector_oro_calendar_event_form_start']")));
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }


    public String getEndTime() {
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");
    }

    //Test Case 6
    public void selectNinePm(){
        //Actions actions = new Actions(driver);
        BrowserUtilities.waitForPageToLoad(15);
        //actions.moveToElement(ninePm).click().perform();
        wait.until(ExpectedConditions.visibilityOf(ninePm)).click();
       // ninePm.click();


        BrowserUtilities.wait(8);

    }
    public String verifyTenPm() {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");
    }

    // Test Case 7
    public void selectAllDayEvents(){
        wait.until(ExpectedConditions.visibilityOf(allDayEventCheckbox)).click();
        BrowserUtilities.wait(2);

    }
    public WebElement verifyAllDayEvents() {
        wait.until(ExpectedConditions.visibilityOf(allDayEventCheckbox)).isSelected();
        BrowserUtilities.wait(2);
        return allDayEventCheckbox;

    }
    public WebElement startTimeInput() {
        BrowserUtilities.waitForPageToLoad(10);
        //we can use if giving error no such element found in startTime
        //  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id^='time_selector_oro_calendar_event_form_start']")));
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime;
    }


    public WebElement endTimeInput() {
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime;
    }

    public WebElement getStartDate() {
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        return startDate;
    }


    public WebElement getEndDate() {
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endDate));
        return endDate;
    }

    //Test case 8
    public void clickRepeatCheckbox(){
        BrowserUtilities.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(repeatCheckbox)).click();
        BrowserUtilities.wait(2);

    }


    public WebElement dailyDropDown(){
        BrowserUtilities.wait(2);

//        List<WebElement> repeatsDropDown= driver.findElements(By.cssSelector("select[id^='recurrence-repeats-view']"));
//        for (int i = 0; i < repeatsDropDown.size(); i++) {
//            repeatsDropDown.get(i);
//            BrowserUtilities.wait(2);
//
//        }
        return dailyDefault;
    }

    public WebElement selectRepeatCheckbox(){
        BrowserUtilities.waitForPageToLoad(15);
        wait.until(ExpectedConditions.elementToBeClickable(repeatCheckbox));
        BrowserUtilities.wait(2);
        return repeatCheckbox;
    }

    //Test Case 9
    public WebElement selectRepeatEvery(){
        BrowserUtilities.waitForPageToLoad(10);
        return repeatEveryRadioBtn;
    }
    public WebElement selectNeverEnds(){
        BrowserUtilities.wait(2);
        return neverEndsRadiobtn;
    }
    public WebElement displaySummaryMessage(){
        BrowserUtilities.wait(2);
        return summaryMessage;
    }

    //Test Case 10
    public void selectAfterBtn(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(afterRadioBtn)).click();
        BrowserUtilities.wait(2);

    }
    public void send10Occurences(String number){
        BrowserUtilities.wait(2);
        wait.until(ExpectedConditions.visibilityOf(occurencesBox));
        occurencesBox.sendKeys(number, Keys.ENTER);
        BrowserUtilities.wait(2);
    }
    public String verifySummaryMessage(){
        BrowserUtilities.wait(2);
        return summaryDailyMsg.getText();
    }

    //Test Case 11
    public void clickOnByButton(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(byRadioBtn)).click();
        BrowserUtilities.wait(2);

    }
    public void selectDateOptions(String date){
        BrowserUtilities.wait(2);
        wait.until(ExpectedConditions.visibilityOf(dateBox));
        dateBox.sendKeys("Nov 18, 2021", Keys.ENTER);
        BrowserUtilities.wait(2);
    }
    public String verifyEndSummaryMsg(){
        BrowserUtilities.wait(2);
        return summaryDateMsg.getText();
    }




}
