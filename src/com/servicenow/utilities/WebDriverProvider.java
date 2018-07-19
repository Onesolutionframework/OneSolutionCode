package com.servicenow.utilities;

import com.servicenow.browser.Browser;
import com.servicenow.browser.SeleniumBrowser;
import com.servicenow.browser.SeleniumBrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Muni on 5/4/17.
 */
public class WebDriverProvider {

    static DesiredCapabilities caps = null;

    public static WebDriver configureDriver(WebDriver driver) {

        caps = new WebDriverCapabilities().setDesiredCapabilities();
        if (SauceLabs.isSauceEnabled())
            driver = createRemoteDriver(driver, caps);
        else
            driver = createLocalDriver(driver);

        //driver.get("http://qa1.kansascity.com");
        return driver;
    }

    public static WebDriver createRemoteDriver(WebDriver driver, DesiredCapabilities caps){
        try {
            driver = new RemoteWebDriver(new URL(SauceLabs.getSauceConnectionURL()), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    public static WebDriver createLocalDriver(WebDriver driver){
        SeleniumBrowserFactory op = new SeleniumBrowserFactory();
        driver= op.openBrowser();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver configureDriverForBrowsers(WebDriver driver, String os, String browser, String browserVersion) {
        caps = new WebDriverCapabilities().setDesiredCapabilities(os, browser, browserVersion);

        System.out.printf("Is Capability null ?");
        System.out.println(caps == null);
        System.out.println(os + " ::: " + browser + " ::: " + browserVersion);

        if(SauceLabs.isSauceEnabled())
            driver = createRemoteDriver(driver, caps);
        else
            driver = createLocalDriver(driver);

        //driver.get("http://qa1.kansascity.com");
        return driver;
    }

}
