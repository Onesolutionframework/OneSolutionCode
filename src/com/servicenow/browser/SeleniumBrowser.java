package com.servicenow.browser;

import com.galenframework.page.selenium.SeleniumPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class SeleniumBrowser implements Browser
{
    public static WebDriver driver;

    public SeleniumBrowser(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebDriver getDriver()
    {
        return this.driver;
    }

    public void quit()
    {
        this.driver.quit();
    }

    public void changeWindowSize(java.awt.Dimension windowSize)
    {
        WebUtils.resizeDriver(this.driver, windowSize.width, windowSize.height);
    }

    public void load(String url)
    {
        this.driver.get(url);
    }

    public Object executeJavascript(String javascript)
    {
        return ((JavascriptExecutor)this.driver).executeScript(javascript, new Object[0]);
    }

    /*public WebPage getPage()
    {
        return new SeleniumPage(this.driver);
    }*/

    public String getUrl()
    {
        return this.driver.getCurrentUrl();
    }

    public Dimension getScreenSize()
    {
        org.openqa.selenium.Dimension windowSize = this.driver.manage().window().getSize();
        return new java.awt.Dimension(windowSize.getWidth(), windowSize.getHeight());
    }

    public void refresh()
    {
        this.driver.navigate().refresh();
    }
}

