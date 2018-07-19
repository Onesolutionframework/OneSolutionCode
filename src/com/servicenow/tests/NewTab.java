package com.servicenow.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class NewTab {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        /*String strdriverpath = "D:\\AssureNXT Projects\\myTest\\lib\\Selenium\\utils\\chrome\\chromedriver_win.exe";


        System.setProperty("webdriver.chrome.driver",strdriverpath);
        WebDriver driverchrome = new ChromeDriver();

                    driverchrome.get("C:\\Users\\mu372014\\Desktop\\junit-noframes.html");
        try {

            //((JavascriptExecutor) driverchrome.executeScript("window.open();");
            JavascriptExecutor js = (JavascriptExecutor) driverchrome;
            js.executeScript("window.open();");

            Thread.sleep(500);
        } catch (Exception e){

        }*/

        //Run batch file using java
        String filePath = "C:\\Users\\mu372014\\Desktop\\test.bat";
        try {

            String path="cmd /c start /wait" + filePath;
            Runtime rn=Runtime.getRuntime();
            Process pr=rn.exec(path);
            pr.waitFor();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
