package com.servicenow.pages;

import com.servicenow.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.TreeMap;

public class MyLoginPage extends FuncLib {

    public MyLoginPage(WebDriver inputDriver) {
        super(inputDriver);
    }

    public static String strUserName= "//*[@id=\"txtUsername\"]";
    public static String strCode= "//*[@id=\"txtPassword\"]";
    public static String strLogin= "//*[@id=\"btnLogin\"]";



    public static void login(String UserID,String dPassword){
        try {
            int iCounter=0;
            while(iCounter==60){
                if(driver.findElement(By.xpath(strUserName)).isDisplayed()){
                    setUserID(UserID);
                    setPassword(dPassword);
                    submitLogin();
                    break;
                }else if(driver.findElement(By.xpath(strUserName)).isDisplayed()){
                    break;
                }else{

                }

            }
        }catch (Exception e){
            Report.log("fail","login: " + e.getLocalizedMessage());
        }
    }

    public static void setUserID(String UserID){
        try {
            iSendData(strUserName, UserID,"User name");
        }catch (Exception e){
            Report.log("fail","login: " + e.getLocalizedMessage());
        }
    }

    public static void setPassword(String dPassword) throws ExceptionHandler {
        try {
            iSendData(strCode, dPassword,"Password");
        }catch (Exception e){
            Report.log("fail","login: " + e.getLocalizedMessage());
            throw new ExceptionHandler(e);
        }
    }

    public static void submitLogin(){
        try {
            iClick(strLogin,"Login");
        }catch (Exception e){
            Report.log("fail","login: " + e.getLocalizedMessage());
        }
    }
}
