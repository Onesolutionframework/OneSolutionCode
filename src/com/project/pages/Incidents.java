package com.project.pages;

import com.project.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Incidents extends FuncLib {

    public Incidents(WebDriver inputDriver) {
        super(inputDriver);
    }


    public static String pTable = "//table[contains(@id,'_table') and contains(@class,'data_list_table list_table table table-hover')]";

    public static void clearFilter(){
        AppLib.FilterAll();
    }

    public static void selectIndcident() throws InterruptedException, ExceptionHandler {

        String Rows = pTable + "/tbody/tr";
        AppLib.switchToMainFrame("gsft_main");

        if (SmartWait.waitForElement(driver,By.xpath(pTable),60)==null) {
            Report.log("fail", "Table is not displayed");
            throw new ExceptionHandler("Table is not displayed");
        }

        int iRowCount = WebTable.getRowCount(pTable);

        if(iRowCount==0){
            Report.log("fail","No records displayed in Incident table");
            return;
        }

        Report.log("pass","There are " + iRowCount + " incidents displayed");

        WebTable.clickElementInCell(pTable,"a",1,3);
    }
}
