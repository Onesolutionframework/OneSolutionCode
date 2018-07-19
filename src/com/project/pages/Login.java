package com.project.pages;

import com.project.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.TreeMap;

public class Login extends FuncLib {

    public Login(WebDriver inputDriver) {
        super(inputDriver);
    }

    public static String sTestDataFile = System.getProperty("user.dir") + "\\ObjectRepo\\LocatorsRepo.xlsx";
    public static DataTable DataRead = new DataTable(sTestDataFile, "Locators","Login");
    public static TreeMap<String, String> ObjMap = DataRead.readObjects();
    public static String UserName= ObjMap.get("UserName");
    public static String Password= ObjMap.get("Password");
    public static String Login= ObjMap.get("Login");



    public static void login(String UserID,String dPassword){
        try {

            if(UserID.trim()=="") {
                Report.log("fail", "User id is blank!");
            }
            System.out.println(sTestDataFile);
            setUserID(UserID);
            setPassword(dPassword);
            submitLogin();
            AppLib.switchToMainFrame("gsft_main");
            SmartWait.waitForPageLoaded();
            SmartWait.waitForElement(driver, By.xpath("//html/body[@data-formname='home']"),DEFAULT_WAIT_4_ELEMENT);
            driver.switchTo().defaultContent();

        }catch (Exception e){
            Report.log("fail","login: " + e.getLocalizedMessage());
        }
    }

    public static void setUserID(String UserID){
        try {
            iSendData(UserName, UserID,"User name");
        }catch (Exception e){
            Report.log("fail","login: " + e.getLocalizedMessage());
        }
    }

    public static void setPassword(String dPassword) throws ExceptionHandler {
        try {
            iSendData(Password, dPassword,"Password");
        }catch (Exception e){
            Report.log("fail","login: " + e.getLocalizedMessage());
            throw new ExceptionHandler(e);
        }
    }

    public static void submitLogin(){
        try {
            iClick(Login,"Login");
        }catch (Exception e){
            Report.log("fail","login: " + e.getLocalizedMessage());
        }
    }
}
