package com.project.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
/**
 * Created by Muni on 5/4/17.
 */
public class IActions extends FuncLib {
    public IActions(WebDriver inputDriver) {
        super(inputDriver);
    }

    public static void iClick(String locatorVal,String name) throws ExceptionHandler {
        Actions ob = new Actions(driver);

        By by=By.xpath(locatorVal);
        try {
            WebElement strTempElement = driver.findElement(by);
            ob.moveToElement(strTempElement).click().build().perform();
            Report.message("pass", "Clicked on "+"'"+name+"'"+ " button");
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }
}
