package com.project.pages;

import com.project.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListItems extends FuncLib {

    public ListItems(WebDriver inputDriver) {
        super(inputDriver);
    }


    public static String pTable = "//table[contains(@id,'_table') and contains(@class,'data_list_table list_table table table-hover')]";

    public static void clearFilter(){
        AppLib.FilterAll();
    }

    public static void verifyListDisplayed() throws InterruptedException, ExceptionHandler {

        String Rows = pTable + "/tbody/tr";
        AppLib.switchToMainFrame("gsft_main");

        if (SmartWait.waitForElement(driver,By.xpath(pTable),60)==null) {
            Report.log("fail", "Table is not displayed");
            throw new ExceptionHandler("Table is not displayed");
        }
        Report.log("pass", "List of items displayed.");

    }
}
