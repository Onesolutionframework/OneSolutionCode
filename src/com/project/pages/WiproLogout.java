package com.project.pages;

import com.project.utilities.FuncLib;
import org.openqa.selenium.WebDriver;

public class WiproLogout extends FuncLib {
    public WiproLogout(WebDriver inputDriver) {
        super(inputDriver);
    }

    public static String taskContainer="//div[@class='mytask_popup']";
    public static String logout ="//span[@class='logout_btn']";

}
