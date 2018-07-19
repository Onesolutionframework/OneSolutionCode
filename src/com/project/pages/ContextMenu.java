package com.project.pages;

import com.project.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContextMenu extends FuncLib {
    public ContextMenu(WebDriver inputDriver) {
        super(inputDriver);
    }

    public static String pContextMenuMain="//*[contains(@id,'context_1') and @class='context_menu']";
    public static String pConextItem="//*[contains(@class,'context_item') and text()='<<<replace>>>']";

    public static boolean isDisplayed(String locatorVal) throws ExceptionHandler {
        try {
            return isDisplayed(locatorVal, "Context Menu");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void selectOption(String txt) throws ExceptionHandler, InterruptedException {
        try {
            txt = txt.trim();
            if (txt == "") {
                Report.log("fail", "Select option is blank!");
                return;
            }

            if (SmartWait.waitForElement(driver, By.xpath(pContextMenuMain), 30) == null) {
                Report.log("fail", "Context Menu is not displayed!");
                return;
            }

            String[] arrStrings = txt.split("#");

            int iArraySize = arrStrings.length;

            if (iArraySize < 2) {
                String option = pConextItem.replace("<<<replace>>>", txt);
                JSE.mouseHover(driver.findElement(By.xpath(option)));
                //JSE.iClick(option,arrStrings[0]);
                iClick(option, arrStrings[0]);
            } else if (iArraySize >= 2) {
                for (int i = 0; i < iArraySize; i++) {
                    if (i == iArraySize - 1) {
                        String option = pConextItem.replace("<<<replace>>>", arrStrings[i]);
                        JSE.mouseHover(driver.findElement(By.xpath(option)));
                        iClick(option, arrStrings[i]);
                    } else {
                        String option = pConextItem.replace("<<<replace>>>", arrStrings[i]);
                        JSE.mouseHover(driver.findElement(By.xpath(option)));
                    }
                }
            }
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }
}
