package com.project.utilities;

import com.project.base.PageInitialize;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

public class AppLib extends FuncLib {
    public static int timeOutInSeconds=20000;
    public static Logger logger = LoggerFactory.getLogger(PageInitialize.class);

    static WebDriver myDriver;
    private static SoftAssert soft = new SoftAssert();

    public AppLib(WebDriver inputDriver) {

        super(inputDriver);
        myDriver = inputDriver;

    }

    public static void FilterAll(){
        String prop="//*[@id='incident_breadcrumb']/a[text()='All']";
    }

    public static void switchToMainFrame(String frame){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frame);
    }


}
