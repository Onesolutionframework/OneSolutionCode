package com.servicenow.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

/**
 * Created by Muni on 5/4/17.
 */
public abstract class BasePage  {

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
        driver = inputDriver;
        PageFactory.initElements(driver, this); //15, TimeUnit.SECONDS, this) {

        AjaxElementLocatorFactory factory= new AjaxElementLocatorFactory(driver,100);
        PageFactory.initElements(factory,this);
        FuncLib.waitForPageLoaded();
        System.out.println("Current page title: " + driver.getTitle());
    }
    public WebDriver getDriver() {
        return driver;
    }

    public static void waitForPageLoaded()  {
        try {
            ExpectedCondition<Boolean> expectation = new
                    ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver driver) {
                            return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                        }
                    };
            Thread.sleep(500);
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_PAGE);
            wait.until(expectation);
        } catch (Exception error) {
            System.out.println("Timeout waiting for Page Load Request to complete.");
        }
    }

}
