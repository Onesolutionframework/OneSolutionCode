package com.project.pages;

import com.project.utilities.FuncLib;

import org.openqa.selenium.*;

public class WebPage {

    public static WebDriver webDriver = null;

    public WebPage(WebDriver inputDriver) {
        webDriver = inputDriver;
    }





    public FuncLib getFunctionLibrary(){
        handlePopUps();
        return new FuncLib(webDriver);
    }





    public void handlePopUps(){
        if (webDriver.findElements(By.xpath("//*[@id='wm_interstitial_discovery_pop']")).size()>0) {
            if (webDriver.findElements(By.xpath("//*[@id='wm_interstitial_discovery_pop']//*[@class='wm_close']")).size()>0) {
                int iW = webDriver.manage().window().getSize().width;
                int iH = webDriver.manage().window().getSize().width;
                webDriver.manage().window().maximize();
                webDriver.findElement(By.xpath("//*[@id='wm_interstitial_discovery_pop']//*[@class='wm_close']")).click();
                webDriver.manage().window().setSize(new Dimension(iW, iH));

            }
            try {
                WebElement fr = webDriver.findElement(By.id("wm_interstitial_header_iframe"));
                webDriver.switchTo().frame("wm_interstitial_header_iframe");
                if (webDriver.findElements(By.xpath("//html/body/div/span")).size()>0)
                    webDriver.findElement(By.xpath("/html/body/div/span")).click();
                webDriver.switchTo().defaultContent();
            }catch(NoSuchElementException e){
                System.out.println("no frame");

            }catch(Exception e){
                System.out.println("no frame");

            }
        }

    }
}
