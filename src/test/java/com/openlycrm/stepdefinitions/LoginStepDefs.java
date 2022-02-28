package com.openlycrm.stepdefinitions;

import com.openlycrm.pages.LoginPage;
import com.openlycrm.utilities.BrowserUtils;
import com.openlycrm.utilities.ConfigurationReader;
import com.openlycrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefs {
    @Then("homepage should have the title {string}")
    public void homepageShouldHaveTheTitle(String exptitle) {

        String acctualTitle = Driver.get().getTitle();

        Assert.assertEquals("verify title is equal", exptitle, acctualTitle);

        BrowserUtils.waitFor(3);
    }


    @Given("the user is on homepage")
    public void theUserIsOnHomepage() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();

        new LoginPage().login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));


    }
}
