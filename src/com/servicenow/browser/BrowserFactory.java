package com.servicenow.browser;

import org.openqa.selenium.WebDriver;

public abstract interface BrowserFactory {
    public abstract WebDriver openBrowser();
}
