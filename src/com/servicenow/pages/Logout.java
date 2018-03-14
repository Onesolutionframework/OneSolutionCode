package com.servicenow.pages;

import com.servicenow.utilities.ExceptionHandler;
import com.servicenow.utilities.FuncLib;
import com.servicenow.utilities.JSE;
import com.servicenow.utilities.Report;
import org.openqa.selenium.WebDriver;

public class Logout extends FuncLib {
    public Logout(WebDriver inputDriver) {
        super(inputDriver);
    }

    static String UserInfoDropDown= "//*[@id='user_info_dropdown']";
    static String logout = "//a[text()='Logout']";

    public static void Logout() throws ExceptionHandler {
        try {
            navigateToUserInfo();
            logout();
        }catch (Exception e){
            throw new ExceptionHandler(e);
        }
    }

    public static void navigateToUserInfo(){
        try {
            driver.switchTo().defaultContent();
            iClick(UserInfoDropDown, "User Info");
        }catch (Exception e){
            Report.log("fail","logout: " + e.getLocalizedMessage());
        }
    }

    public static void logout(){
        try {
            //iClick(logout, "Logout");
            JSE.iClick(logout,"Logout");
        }catch (Exception e){
            Report.log("fail","logout: " + e.getLocalizedMessage());
        }
    }
}
