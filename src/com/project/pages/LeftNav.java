package com.project.pages;

import com.project.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftNav extends FuncLib {
    public LeftNav(WebDriver inputDriver) {
        super(inputDriver);
    }

    public static void verifyOption(String text) throws ExceptionHandler {
        //pending
    }
    public static void selectOption(String text) throws ExceptionHandler {
        try {
            text = text.trim();
            if (text == "") {
                Report.log("fail", "Select option is blank!");
                return;
            }

            String[] arrStrings = text.split("#");

            int iArraySize = arrStrings.length;
            String mainOption = "//span[text()='<<<replace>>>']/ancestor::a[@role='button']";     //a tag
            //String subOption = "//div[text()='<<<replace>>>']/ancestor::a";
            String subOption = "//ul[@id='<<<collapse>>>']//div[text()='<<<replace>>>']/ancestor::a";

            String collapse="";
            if (iArraySize < 2) {
                String option=mainOption.replace("<<<replace>>>",text);
                String controlId = driver.findElement(By.xpath(option)).getAttribute("aria-expanded");

                if (controlId.equalsIgnoreCase("false")) {
                    iClick(subOption, arrStrings[0]);
                }else{
                    JSE.scroll(option);
                    Report.log("pass",arrStrings[0] + " menu already expanded.");
                }
            } else if (iArraySize >= 2) {
                boolean bOneTime=true;
                for (int i = 0; i < iArraySize; i++) {
                    //String collapse="";
                    if (i == iArraySize-1) {
                        String option=subOption.replace("<<<replace>>>",arrStrings[i]);
                        option=option.replace("<<<collapse>>>",collapse);
                        iClick(option, arrStrings[i]);
                    } else {
                        String option=mainOption.replace("<<<replace>>>",arrStrings[i]);
                        if(bOneTime==true) {
                            collapse = driver.findElement(By.xpath(option)).getAttribute("aria-controls");
                            bOneTime=false;
                        }
                        String controlId = driver.findElement(By.xpath(option)).getAttribute("aria-expanded");
                        if (controlId.equalsIgnoreCase("false"))
                            iClick(option, arrStrings[i]);
                        else {
                            JSE.scroll(option);
                            Report.log("pass", arrStrings[i] + " menu already expanded.");
                        }
                    }
                }
            }
        } catch (Exception ex) {
            throw new ExceptionHandler(ex);
        }
    }
}
