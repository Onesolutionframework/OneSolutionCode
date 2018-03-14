package com.servicenow.pages;

import com.servicenow.utilities.FuncLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.asserts.SoftAssert;

/**
 * Created by Deepak on 5/4/17.
 */
public abstract class BasePage {

    public static WebDriver driver;
    /** Default wait time for an element. 7  seconds. */
    public static final int DEFAULT_WAIT_4_ELEMENT = 30;
    /** Default wait time for a page to be displayed.  12 seconds.
    * The average webpage load time is 6 seconds in 2012.
    * Based on your tests, please set this value.
    * "0" will nullify implicitlyWait and speed up a test. */
    public static final int DEFAULT_WAIT_4_PAGE = 60;
    public static String pMainFrame="gsft_main";
    public static SoftAssert softAssert = new SoftAssert();
    public BasePage(WebDriver inputDriver)  {
        this.driver = inputDriver;
        PageFactory.initElements(driver, this); //15, TimeUnit.SECONDS, this) {

        AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,100);
        PageFactory.initElements(factory,this);;
        FuncLib.waitForPageLoaded();
        System.out.println("Current page title: " + driver.getTitle());
    }
    public WebDriver getDriver() {
        return driver;
    }



}
