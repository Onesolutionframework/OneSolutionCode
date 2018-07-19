package com.project.browser;

import org.openqa.selenium.WebDriver;

public abstract interface BrowserFactory {
    public abstract WebDriver openBrowser();
}
