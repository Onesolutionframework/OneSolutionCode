package com.project.pages;

import com.project.utilities.*;
import org.openqa.selenium.WebDriver;

public class IncidentDetails extends FuncLib {
    public static String pIncidentShortDescription = "//*[contains(@id,'.short_description') and @type='text']";
    public IncidentDetails(WebDriver inputDriver) {
        super(inputDriver);
    }
    public static String shortDescription;
    {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("gsft_main");
    }
    public static String getShortDescription(){
        try {
            shortDescription=getAttributeValue(pIncidentShortDescription,"value");
            return shortDescription;
        }catch (Exception e)
        {
            Report.log("fail",e.getLocalizedMessage());
            return null;
        }
    }

    public static void RightClickOnGrayPane() throws ExceptionHandler {
        String nav="//nav[@class='navbar navbar-default section_zero ']/div[@class='container-fluid']";
        //JSE.contextMenuClick(driver.findElement(By.xpath(nav)));
        NavBar.RightClick();
    }

    public static void selectOptionFromContextMenu(String txt) throws ExceptionHandler {
        String sMenuOption="//div[@id='context_1']/div[text()='"+txt+"']";
        iClick(sMenuOption,"Select menu option " + txt);
    }
}
