//package com.servicenow.tests;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.winium.DesktopOptions;
//import org.openqa.selenium.winium.WiniumDriver;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//
//public class Windows {
//    public static void main(String[] args) throws MalformedURLException, InterruptedException {
//        DesktopOptions option = new DesktopOptions();
//
//        option.setApplicationPath("C:\\Windows\\System32\\calc.exe");
//        WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"),option);
////        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        Thread.sleep(5000);
//
//
//        driver.findElement(By.name("7")).click();
//        driver.findElement(By.id("93")).click();
//        driver.findElement(By.name("8")).click();
//        driver.findElement(By.name("Equals")).click();
//        String output=driver.findElement(By.id("150")).getAttribute("name");
//        System.out.println("Result is "+ output);
//
//    }
//}
