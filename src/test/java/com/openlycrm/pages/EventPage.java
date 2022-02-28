package com.openlycrm.pages;

import com.openlycrm.utilities.BrowserUtils;
import com.openlycrm.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventPage extends BasePage{
    @FindBy(xpath = "(//span[.='Event'])[2]")
    public WebElement eventBtn;


    @FindBy(xpath = "//input[@name='DATE_FROM']")
    public WebElement dateFromBx;

    @FindBy(xpath = "//input[@name='DATE_TO']")
    public WebElement dateToBx;

    @FindBy(xpath = "//input[@name='TIME_FROM_']")
    public WebElement timeFromBx;

    @FindBy(xpath = "//input[@name='TIME_TO_']")
    public WebElement timeToBox;

    @FindBy(xpath = "//span[.='Specify time zone']")
    public WebElement specifyTZone;
    @FindBy(xpath = "//span[.='Hide time zone']")
    public WebElement hideTimeZ;

    @FindBy(xpath = "//input[@name='EVENT_REMIND']")
    public WebElement eventRemCkbox;

    @FindBy(xpath = "//input[@name='EVENT_REMIND_COUNT']")
    public WebElement reminderCount;

    @FindBy(xpath = "//select[@name='EVENT_REMIND_TYPE']/option")
    public List<WebElement> reminderOptions;

    @FindBy(xpath = "//div[@id='feed-event-dest-cont']")
    public WebElement addAtandeeInbox;

    @FindBy(xpath = "(//span/span[.='More'])[2]")
    public WebElement moreEvDetails;

    @FindBy(xpath = "(//tbody)[12]/tr/td/label")
    public List<WebElement> moreTable;
    public List<String> moreTableOpTxt = BrowserUtils.getElementsText(moreTable);


    public List<String> remOptionsTxt = BrowserUtils.getElementsText(reminderOptions);

    @FindBy(xpath = "//input[@id='event-locationcal_3Jcl']")
    public WebElement locationDdownForClick;

    @FindBy(xpath = "//input[@id='event-locationcal_3Jcl']")
    public List<WebElement> locationDdown;

    @FindBy(xpath = "(//button[.='Send'])[3]")
    public WebElement sendBtn;

    @FindBy(xpath = "(//tbody)[12]")
    public WebElement moreTableToSee;

    @FindBy(xpath = "//a[.='My Groups']")
    public WebElement mygroups;

    @FindBy(xpath = "(//div/a[.='Corporate Christmas Party'])[1]")
    public WebElement mygroupsOptions;



    @FindBy(xpath = "(//div [@style='display: block;'])[5]/div")
    public List<WebElement> locationRooms;
    public List<String> locationDdTxt = BrowserUtils.getElementsText(locationRooms);

    public void accessTab(String tabName) {
        BrowserUtils.waitForClickablility(eventBtn, 3);
        Driver.get().findElement(By.xpath("(//span[.='" + tabName + "'])[2]")).click();
    }


    public void setGroupName(String groupTab){

        Driver.get().findElement(By.xpath("//a[.='"+groupTab+"']")).click();

    }

    public void selectGroupOptions(String groupTabOptions){
        Actions actions =new Actions(Driver.get());

       WebElement option= Driver.get().findElement(By.xpath("(//div/a[.='"+groupTabOptions+"'])[1]"));

       actions.click();

    }





    public void setEventDates(String strtDate, String endDate) {
        BrowserUtils.waitFor(3);
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(dateFromBx);
        actions.click();
        actions.build().perform();
        dateFromBx.clear();
        BrowserUtils.waitFor(3);
        dateFromBx.sendKeys(strtDate);

        BrowserUtils.waitFor(3);
        Actions action1 = new Actions(Driver.get());
        action1.moveToElement(dateToBx);
        action1.click();
        action1.build().perform();
        for (int i = 1; i <= 10; i++) {

            action1.sendKeys(Keys.BACK_SPACE).perform();
        }


        BrowserUtils.waitFor(3);
        dateToBx.sendKeys(endDate);


    }

    public void setEventTimes(String strtTime, String endTime) {
        timeFromBx.click();
        BrowserUtils.waitFor(3);
        timeFromBx.clear();
        timeFromBx.sendKeys(strtTime);

        timeToBox.click();
        BrowserUtils.waitFor(3);
        timeToBox.clear();
        timeToBox.sendKeys(endTime);


        // timeToBox.sendKeys(endTime);

    }


    public void setSpecTZClick() {
        specifyTZone.click();
    }

    public void verDispDates(String expStart, String expEnd) {


        Assert.assertEquals("verify diplayed strdates", expStart, dateFromBx.getAttribute("value"));
        Assert.assertEquals("verify diplayed enddates", expEnd, dateToBx.getAttribute("value"));

    }

    public void verDispTimes(String exstrTime, String exendTime) {
        Assert.assertEquals("verify diplayed strt times", exstrTime, timeFromBx.getAttribute("value"));
        Assert.assertEquals("verify diplayed end times", exendTime, timeToBox.getAttribute("value"));


    }



}
