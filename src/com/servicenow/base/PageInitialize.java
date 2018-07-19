package com.servicenow.base;

import com.servicenow.utilities.BasePage;
import com.servicenow.pages.WebPage;
import com.servicenow.utilities.FuncLib;
import com.servicenow.utilities.Report;
import com.servicenow.utilities.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Name: PageInitialize
 * Description: this triger before class, before ctest, after class.
 * Author: Muni
 * Date: 05/04/2017
 * Notes: Every test class should inherit PageInitialize class
 *
 **/

/**
 * AfterMethod:
 * ends entent reprt test node for each test
 * stops driver instance
 **/

/**
 * BeforeMethod:
 * initializes driver
 * creates extent report test node for each test
 **/

/**
 * BeforeClass:
 * starts extent report
 **/

public abstract class PageInitialize {

    public WebDriver driver = null;
    public static WebDriverProvider webDriverProvider = null;
    protected WebPage webPage = null;

    @BeforeMethod
    public void setup(Method methodName){
        System.out.println("Inside @BeforeTest method");
        initializeDriver();
        webPage = new WebPage(driver);
        BasePage.driver=driver;
        System.out.println("current method: "+ methodName.getName());
        Report.createTest(methodName.getName());
    }

    @AfterMethod
    protected void tearDown(Method methodName){
        System.out.println("Inside @AfterTest method");
        System.out.println("end method: "+ methodName.getName());
        Report.endTest(methodName.getName());
        stopDriver();
    }

    @BeforeClass
    public void Initialize() throws Exception {
        Report.startReport();
    }
    private void stopDriver(){
        driver.quit();
    }

    public void initializeDriver(){
        driver = WebDriverProvider.configureDriver(driver);
    }

    public void createDriver(String os, String browser, String browserVersion){
        driver = WebDriverProvider.configureDriverForBrowsers(driver, os, browser, browserVersion);
        System.out.println(driver == null);
        webPage = new WebPage(driver);
    }
}
