package com.openlycrm.pages;

import com.openlycrm.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement userNameInpBox;


    @FindBy(xpath = "//input[@name='USER_PASSWORD']")
    public WebElement passwInpBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitBtn;



    public void login(String username,String password){


        BrowserUtils.waitForPageToLoad(5);
        userNameInpBox.sendKeys(username);
        passwInpBox.sendKeys(password);
        submitBtn.click();


    }


}
