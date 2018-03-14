package com.servicenow.base;

import com.servicenow.pages.BasePage;
import com.servicenow.pages.WebPage;
import com.servicenow.utilities.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 * Created by Deepak on 5/4/17.
 */
public abstract class PageInitialize {

    public WebDriver driver = null;
    public static WebDriverProvider webDriverProvider = null;
    protected WebPage webPage = null;
    public String sDem="||";



    @BeforeMethod
    public void setup(){
        System.out.println("Inside @BeforeTest method");

            System.out.println("Inside IF condition of setup method");
            initializeDriver();
            webPage = new WebPage(driver);
            BasePage.driver=driver;
    }

    @AfterMethod
    protected void tearDown(){
        System.out.println("Inside @AfterTest method");
        stopDriver();
    }

    private void stopDriver(){
        driver.quit();
    }

    public void initializeDriver(){

        driver = webDriverProvider.configureDriver(driver);
    }

    public void createDriver(String os, String browser, String browserVersion){
        driver = webDriverProvider.configureDriverForBrowsers(driver, os, browser, browserVersion);

        System.out.println(driver == null);
        webPage = new WebPage(driver);
    }


}
