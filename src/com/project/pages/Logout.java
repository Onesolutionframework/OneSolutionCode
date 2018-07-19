package com.project.pages;

import com.project.utilities.ExceptionHandler;
import com.project.utilities.FuncLib;
import com.project.utilities.JSE;
import com.project.utilities.Report;
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
