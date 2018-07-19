package com.servicenow.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
/**
 * Created by Muni on 5/4/17.
 */
public class WebTable extends FuncLib {
    public WebTable(WebDriver inputDriver) {
        super(inputDriver);
    }

    public static int getRowCount(String pTable){
        String Rows = pTable + "/tbody//tr";

        List<WebElement> eles = SmartWait.waitForListElementsPresent(driver, By.xpath(Rows), 60);
        return eles.size();
    }

    public static int getColumnCount(String TableLocator){
        return 0;
    }

    public static String getCellData(String TableLocator){
        return null;
    }

    public static int searchByColumn(String TableLocator, int iCol){
        return 0;
    }

    public static void clickElementInCell(String TableLocator, String TagName, int iRow, int iCol) throws ExceptionHandler {
        try {
            String pLocator = TableLocator + "/tbody" + "/tr[" + iRow + "]" + "/td[" + iCol + "]" + "/" + TagName;
            String sText = getElementText(pLocator);
            if (sText == "" || sText == null) {
                sText = TagName;
            }
            driver.findElement(By.xpath(pLocator)).click();
            Report.log("pass", "'" + TagName + "' element from Table");
        }catch (Exception e){
            Report.log("fail", "Unable to click element from Table");
            throw new ExceptionHandler(e);
        }
    }



    public static void clickElementInCell(String TableLocator, By eleLocator, int iRow, int iCol) throws ExceptionHandler {
        String pLocator= TableLocator + "/tbody" + "/tr[" + iRow + "]" + "/td[" + iCol + "]";
        WebElement eTable= driver.findElement(By.xpath(pLocator));
        WebElement eLe=eTable.findElement(eleLocator);
        iClick((By) eLe,"Incident item");
    }

    public static void clickElementInCell_SearchByColumn(String TableLocator, String eleLocator, int iCol){
    }

    public static void clickElementInCell_SearchByColumn(String TableLocator, String eleLocator, String Colname, String searchVal){
    }

    public static void SetValInCell(String TableLocator, String eleLocator,String val, int iRow, int iCol){
    }

    public static void SetValInCell_SearchByColumn(String TableLocator, String eleLocator,String val, int iCol, String searchVal){
    }

    public static void SetValInCell_SearchByColumn(String TableLocator, String eleLocator, String val, String Colname, String searchVal){
    }

    public static boolean isTableDisplayed(String TableLocator){
        return true;
    }

    public static void selectRow(String TableLocator, int iRow){

    }

    public static void selectRow_SearchByColumn(String TableLocator, int iCol){

    }
}
