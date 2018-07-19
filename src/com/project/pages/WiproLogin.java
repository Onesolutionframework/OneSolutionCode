package com.project.pages;

import com.project.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WiproLogin extends FuncLib {

    public WiproLogin(WebDriver inputDriver) {
        super(inputDriver);
    }

    public static String pUserName= "//*[@id='userNameInput']";
    public static String pPassword= "//*[@id='passwordInput']";
    public static String pLogin= "//*[@id='submitButton']";



    public static void login(String UserID,String dPassword){
        try {

            if (driver.getTitle().equalsIgnoreCase("sign in")) {

                setUserID(UserID);
                setPassword(dPassword);
                submitLogin();
                AppLib.switchToMainFrame("gsft_main");
                SmartWait.waitForPageLoaded();
                SmartWait.waitForElement(driver, By.xpath("//html/body[@data-formname='home']"), DEFAULT_WAIT_4_ELEMENT);
                driver.switchTo().defaultContent();
            }
        }catch (Exception e){
            Report.log("fail","login: " + e.getLocalizedMessage());
        }
    }

    public static void setUserID(String UserID){
        try {
            iSendData(pUserName, UserID,"User name");
        }catch (Exception e){
            Report.log("fail","login: " + e.getLocalizedMessage());
        }
    }

    public static void setPassword(String dPassword) throws ExceptionHandler {
        try {
            iSendData(pPassword, dPassword,"Password");
        }catch (Exception e){
            Report.log("fail","login: " + e.getLocalizedMessage());
            throw new ExceptionHandler(e);
        }
    }

    public static void submitLogin(){
        try {
            iClick(pLogin,"Login");
        }catch (Exception e){
            Report.log("fail","login: " + e.getLocalizedMessage());
        }
    }
}
