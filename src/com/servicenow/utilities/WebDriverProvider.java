package com.servicenow.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Deepak on 5/4/17.
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
        /*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")  + "/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();*/

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")  + "/src/main/resources/chromedriver.exe");
       // System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")  + "/src/main/resources/IEDriverServer.exe");
        /*DesiredCapabilities returnCapabilities = DesiredCapabilities.internetExplorer();
        returnCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
        returnCapabilities.setJavascriptEnabled(true);*/

//        var options = new InternetExplorerOptions();

  //      driver = new InternetExplorerDriver();

        driver=new ChromeDriver();

        //driver.manage().window().maximize();
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
