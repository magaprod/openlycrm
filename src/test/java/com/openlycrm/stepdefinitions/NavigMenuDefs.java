package com.openlycrm.stepdefinitions;

import com.openlycrm.pages.EventPage;
import com.openlycrm.utilities.BrowserUtils;
import com.openlycrm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class NavigMenuDefs {
    @Given("the user accesses {string} tab")
    public void the_user_accesses_tab(String tabName) {
        BrowserUtils.waitForPageToLoad(10);
        new EventPage().accessTab(tabName);
    }

    @When("the user enters start {string} and ending {string} dates")
    public void the_user_enters_start_and_ending_dates(String startdate, String endDate) {


        new EventPage().setEventDates(startdate, endDate);

    }


    @And("the user enters start {string} and ending {string} times")
    public void theUserEntersStartAndEndingTimes(String strtTime, String endTime) {

        new EventPage().setEventTimes(strtTime, endTime);


    }

    @When("the user specify time zone")
    public void the_user_specify_time_zone() {
        EventPage eventPage = new EventPage();
        eventPage.setSpecTZClick();
        Assert.assertTrue("verify if tZone displayed", eventPage.hideTimeZ.isDisplayed());

    }


    @And("the given {string} {string} dates should be displayed")
    public void theGivenDatesShouldBeDiplayed(String expStartDate, String expEndDate) {

        new EventPage().verDispDates(expStartDate, expEndDate);


    }

    @Then("the given {string} {string}times should be displayed")
    public void theGivenTimesShouldBeDisplayed(String strTime, String endTime) {


    }

    @Given("the user select set reminder")
    public void theUserSelectSetReminder() {
        BrowserUtils.waitForClickablility(new EventPage().eventRemCkbox, 5);
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(new EventPage().eventRemCkbox).build().perform();
        actions.click().build().perform();


    }

    @When("the user set the reminder with {string}")
    public void theUserSetTheReminderWith(String setUnit) {
        Actions actions = new Actions(Driver.get());
        EventPage eventPage = new EventPage();
        BrowserUtils.waitFor(3);
        actions.moveToElement(eventPage.reminderCount).build().perform();
        actions.click().build().perform();
        eventPage.reminderCount.clear();
        BrowserUtils.waitFor(3);
        actions.sendKeys(setUnit);


        eventPage.reminderCount.sendKeys(setUnit);


    }

    @Then("reminder count box should display {string}")
    public void reminderCountboxShouldDisplay(String expUnit) {
        EventPage eventPage = new EventPage();
        Assert.assertEquals("verify set unit", expUnit, eventPage.reminderCount.getAttribute("value"));


    }

    @Then("the unit dropdown should have following options")
    public void theUnitDropdownShoulHaveFollowingOptions(List<String> unitOptions) {
        EventPage eventPage = new EventPage();
        BrowserUtils.waitFor(5);
        Assert.assertTrue("verify options", unitOptions.equals(eventPage.remOptionsTxt));
        System.out.println(new EventPage().remOptionsTxt);


    }

    @When("the user clicks unit dropdown")
    public void theUserClicksUnitDropdown() {


    }

    @Given("the user clicks location dropdown")
    public void theUserClicksLocationDropdown() {
        BrowserUtils.waitForClickablility(new EventPage().locationDdownForClick, 7);
        new EventPage().locationDdownForClick.click();
        BrowserUtils.waitFor(5);
//        System.out.println("new EventPage().locationDdTxt = " + new EventPage().locationDdTxt);
//        Select select = new Select((new EventPage().locationDdownForClick));
        System.out.println("new EventPage().locationDdTxt = " + new EventPage().locationDdTxt);


    }

    @Then("the location dropdown should have following options")
    public void theLocationDropdownShouldHaveFollowingOptions(List<String> expecDDOptions) {
        //impossible to select or as list of loacators and when user try to select locator options are not active but visible


    }


    @Given("the user adds {string} in member box")
    public void theUserAddsInMemberBox(String attandeeName) {

        EventPage eventPage = new EventPage();
        BrowserUtils.waitForClickablility(eventPage.addAtandeeInbox, 7);
        eventPage.addAtandeeInbox.click();
        BrowserUtils.waitFor(3);

        //for hidden HTML I use JS code

        String js = "arguments[0].setAttribute('value','" + attandeeName + "')";
        ((JavascriptExecutor) Driver.get()).executeScript(js, eventPage.addAtandeeInbox);


        BrowserUtils.waitFor(3);
        Actions actions = new Actions(Driver.get());
        actions.sendKeys(Keys.ENTER).build().perform();


    }

    @Then("attendee member or grup {string} should be displayed")
    public void attendeeMemberOrGrupShouldBeDisplayed(String expAttandeeName) {
        EventPage eventPage = new EventPage();
        String accAttandee = eventPage.addAtandeeInbox.getAttribute("value");
        System.out.println("accAttandee = " + accAttandee);
        Assert.assertEquals("verify names", expAttandeeName, accAttandee);


    }

    @Given("the user clicks on dropdown more")
    public void theUserClicksOnDropdownMore() {

        BrowserUtils.waitForClickablility(new EventPage().moreEvDetails, 5);
        new EventPage().moreEvDetails.click();


    }

    @Then("opened more dropdown should have following options")
    public void openedMoreDropdownShouldHaveFollowingOptions(List<String> expMoreOptions) {

        System.out.println("new EventPage().moreTableOpTxt = " + new EventPage().moreTableOpTxt);

        Assert.assertTrue("verify more options", expMoreOptions.equals(new EventPage().moreTableOpTxt));
    }

    @Then("the more dropdown should be displayed")
    public void theMoreDropdownShouldBeDisplayed() {

        BrowserUtils.waitForVisibility(new EventPage().moreTableToSee, 4);
        Assert.assertTrue(new EventPage().moreTableToSee.isDisplayed());


    }

    @Given("the user clicks  send button")
    public void theUserClicksSendButton() {

        BrowserUtils.waitForClickablility(new EventPage().sendBtn, 5);
        new EventPage().sendBtn.click();

    }


    @Given("the user clicks on {string}")
    public void theUserClicksOn(String groupName) {
        new EventPage().setGroupName(groupName);


    }

    @Then("the user select group {string} from options")
    public void theUserGroupFromOptions(String groupOtions) {
        BrowserUtils.waitFor(3);
        new EventPage().selectGroupOptions(groupOtions);

    }

    @When("the user clicks on members input box")
    public void theUserClicksOnMembersInputBox() {
        EventPage eventPage = new EventPage();
        BrowserUtils.waitForClickablility( eventPage.addAtandeeInbox,7);
        eventPage.addAtandeeInbox.click();
        String addedMember=eventPage.addAtandeeInbox.getAttribute("value");

    }
}
