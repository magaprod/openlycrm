package com.openlycrm.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)


@CucumberOptions(

        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",},
        features = "src/test/resources/features",
        glue = "com/openlycrm/stepdefinitions",
        dryRun = false,
        tags = " @OP-979"

)





public class cukesRunner {
}
