package com.servicenow.utilities;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Report extends BasePage{
	
    @SuppressWarnings("rawtypes")
	public Report(AndroidDriver inputDriver) {
		super(inputDriver);
	}
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static void startReport(){
        if (htmlReporter == null) {
            htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/TestReport/Report.html");
            htmlReporter.setAppendExisting(false);
            System.out.println(System.getProperty("user.dir") + "/src/main/resources/extent-config.xml");
            htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/src/main/resources/extent-config.xml"));
            htmlReporter.setAnalysisStrategy(AnalysisStrategy.CLASS);
            htmlReporter.config().setChartVisibilityOnOpen(true);

            // suite view:
            htmlReporter.setAnalysisStrategy(AnalysisStrategy.SUITE);
        }

        if (extent == null) {
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
    }

    public static synchronized void closeReporter() {
        htmlReporter.flush();
    }

    public static void message(String status,String desc){
        boolean bGeneral=false;
        if(test==null){
            return;
        }
        //log.info(desc);

        if(status.equalsIgnoreCase("pass")) {
            try {
				test.log(Status.PASS, desc, MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot(driver,test)).build());
				System.out.println(getTime() + " : " + "PASS : " + desc);
                softAssert.assertTrue(true, desc);
			} catch (IOException e) {
				e.printStackTrace();
			}
            }
        else if(status.equalsIgnoreCase("fail")) {
        	 try {
 				test.log(Status.FAIL, desc, MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot(driver,test)).build());
 				System.out.println(getTime() + " : " + "FAIL : " + desc);
                 softAssert.assertTrue(false,desc);
 			} catch (IOException e) {
 				e.printStackTrace();
 			}
        }
        else {
        	 try {
 				test.log(Status.INFO, desc, MediaEntityBuilder.createScreenCaptureFromPath(getScreenShot(driver,test)).build());
 				System.out.println(getTime() + " : " + "INFO : " + desc);
                 softAssert.assertTrue(true, desc);
 			} catch (IOException e) {
 				e.printStackTrace();
 			}
        }
            
        if(bGeneral==true)
            Report.endTest("General");
    }

    public static void log(String status,String desc){
        //Assert.assertTrue(true, "test Report");
        boolean bGeneral=false;
        if(test==null){
            return;
        }
        if(status.equalsIgnoreCase("pass")) {
            //test.pass(desc);
            test.log(Status.PASS, desc);
            System.out.println(getTime() + " : " + "PASS : " + desc);
            softAssert.assertTrue(true, desc);
            //captureAndDisplayScreenShot(webDriver,test);
        }
        else if(status.equalsIgnoreCase("fail")) {
            test.log(Status.FAIL, desc);
            System.out.println(getTime() + " : " + "FAIL : " + desc);
            softAssert.assertTrue(false, desc);
        }
        else {
            test.log(Status.INFO, desc);
            System.out.println(getTime() + " : " + "INFO : " + desc);
            softAssert.assertTrue(true, desc);
        }


        if(bGeneral==true)
            Report.endTest("General");

    }

    public static String getTime(){
        Date dte = new Date();
        DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz YYYY");
        String ed = df.format(dte).toString();
        return ed;

    }

    public static void captureAndDisplayScreenShot(WebDriver ldriver, ExtentTest eTest){
    	String extentReportImage = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
	   	// Take screenshot and store as a file format
	   	File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
	   	try {
	   		// now copy the screenshot to desired location using copyFile method
	   		FileUtils.copyFile(src, new File(extentReportImage));
	   		eTest.log(Status.INFO, "Screenshot from : " + extentReportImage, MediaEntityBuilder.createScreenCaptureFromPath(extentReportImage).build());
	   	} catch (IOException e)
	   	{
	   		System.out.println("Error in the captureAndDisplayScreenShot method: " + e.getMessage());
	   	}
   }
    
    public static String getScreenShot(WebDriver ldriver, ExtentTest eTest){
    	String extentReportImage = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";
	   	// Take screenshot and store as a file format
	   	File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
	   	try {
	   		// now copy the screenshot to desired location using copyFile method
	   		FileUtils.copyFile(src, new File(extentReportImage));
	   		return extentReportImage;
	   	} catch (IOException e)
	   	{
	   		System.out.println("Error in the captureAndDisplayScreenShot method: " + e.getMessage());
	   	}
		return extentReportImage;
   }
    public static void createTest(String sTest){
        test=extent.createTest(sTest);
    }
    public static void endTest(String sTest){
        extent.flush();
        BasePage.softAssert.assertAll();
    }

    /*public void takeScreen(String text, Boolean addReport) {

        log(text, false);

        // set file name and destination for screen shot
        File scrFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat(
                "dd_MMM_yyyy__hh_mm_ssaa");
        String destDir = "./surefire-reports/html/screenshots/";
        new File(destDir).mkdirs();
        String destFile = testName + "_" + target + "_" + getNetwork()
                + "_Step" + step + "_" + dateFormat.format(new Date())
                + ".png";

        // copy screen shot to directory for jenkins
        try {
            FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        log("screenShot: " + destDir + "/" + destFile, false);
        // Display screenshot to ReportNG
        if (addReport) {

            String userDirector = "./screenshots/";
            log("<u><b>||||||" + text + "</b></u><br><a href=\""
                    + userDirector + destFile + "\"><img src=\""
                    + userDirector + destFile + "\" alt=\"\""
                    + "height='100' width='100'/> " + "<br />", addReport);
        }

    }


    // writes to console or/and report log
    // boolean controls whether report log is written to
    public void log(String text, Boolean addReport) {
        String newLine = System.getProperty("line.separator");

        if (addReport) {
            final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
            System.setProperty(ESCAPE_PROPERTY, "false");
            Reporter.log(text.replace("<u><b>||||||", "<u><b>" + testName + "_"
                    + target + "_" + getNetwork() + "_Step" + step + "_"));
        } else {
            System.out.println(testName + "_" + target + "_" + getNetwork()
                    + "_Step" + step + "_" + text + newLine);
        }
    }*/


}