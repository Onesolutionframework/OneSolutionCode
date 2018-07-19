package com.project.pages;

import com.project.utilities.ExceptionHandler;
import com.project.utilities.FuncLib;
import com.project.utilities.JSE;
import com.project.utilities.Report;
import org.openqa.selenium.WebDriver;

public class NavBar extends FuncLib {
    public NavBar(WebDriver inputDriver) {
        super(inputDriver);
    }

    public static String pNavBar="(//nav[contains(@class,'navbar navbar-default')])[1]";
    public static String pNavBarBtn="//button[contains(@class,'icon-menu navbar-btn')]";
    public static String pNavTitle="//*[contains(@class,'navbar-title list_title')]";
    public static String pFilterBy="//*[contains(@id,'_hide_search')]//*[@class='input-group']//*[@class='input-group-addon input-group-select']//select";
    public static String pSearchField="//*[contains(@id,'_hide_search')]//*[@class='input-group']/input";
    public static String pContextMenu = "//*[@id='context_1']";
    public static String ptitle=pNavBar + "//*[@class='navbar-header']//h2/span";
    public static String pvalue=ptitle + "/span";

    public static void RightClick() throws ExceptionHandler {
        JSE.RightClick(pNavBar);
        if(ContextMenu.isDisplayed(pContextMenu)){
            Report.log("pass","Context Menu is displayed When Right Click on Gray pane.");
        }else
        {
            throw new ExceptionHandler("Context Menu is not displayed When Right Click on Gray pane.");
        }
    }


    public static void Search(String filterby,String searchText) throws ExceptionHandler {
        FilterBy(filterby);
        SetSearchField(searchText);
        KeyPress(pSearchField,"enter");
    }

    public static void FilterBy(String filterby){
        selectByVisibleText(pFilterBy,filterby,"Goto");
    }

    public static void SetSearchField(String searchText){
        iSendData(pSearchField,searchText,"Search");
    }

    public static void NavMenu() throws ExceptionHandler {
        iClick(pNavBarBtn,"Nav Menu");
    }

    public static String getNavTitle(){
        return getElementText(ptitle);
    }
}
