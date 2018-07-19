package com.project.pages;

import com.project.utilities.ExceptionHandler;
import com.project.utilities.FuncLib;
import org.openqa.selenium.WebDriver;

public class WiproSearchApp extends FuncLib {
    public WiproSearchApp(WebDriver inputDriver) {
        super(inputDriver);
    }

    public static String findAppButton="//*[@id='Find_an_App']";
    public static String searchInput="//*[@id='findAppTxtId']";



    public static void ClickFindAppButton() throws ExceptionHandler {
        iClick(findAppButton,"Find Button");
    }

    public static void EnterSearchValue(String search) throws ExceptionHandler {
        iSendData(searchInput,"search","Search Input");
    }

    public static void SelectSearchResult() throws ExceptionHandler {
        iSendData(searchInput,"search","Search Input");
    }
}
