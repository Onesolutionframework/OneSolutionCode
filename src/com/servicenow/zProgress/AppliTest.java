/*
package com.corning.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.applitools.eyes.Eyes;
import java.util.concurrent.TimeUnit;

public class AppliTest {

    static WebDriver driver=null;
    private Eyes eyes;
    @BeforeMethod
    public void initiate(){
       */
/* Initializer obj= new Initializer();
        driver = obj.initiateDriver("chrome");*//*

    }
    @Test
    public void Main() {
        System.out.println("Hello AppliTools..Eyes..");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        eyes = new Eyes();
        eyes.setApiKey("nhGuw4qtzNhF6vBn06PTvoJ895dlRIBu7J0tYiuXORE110");
        eyes.setMatchTimeout(60);
        eyes.setForceFullPageScreenshot(true);
        eyes.open(driver,"the internet","successful");
        driver.get("http://qa1.kansascity.com/");
        System.out.println(driver.getTitle());
        driver.manage().window().setSize(new Dimension(1200, 1250));
        eyes.open(driver,"the internet","successful");
        eyes.checkRegion(By.xpath("//*[@id='site-search']/input"));
        eyes.checkRegion(By.xpath("//*[@id='ain-nav']"));
        eyes.setSaveNewTests(true);
        eyes.close();

    }
}
*/
