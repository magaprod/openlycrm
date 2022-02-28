package com.openlycrm.pages;

import com.openlycrm.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
