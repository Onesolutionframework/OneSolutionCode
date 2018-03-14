package com.servicenow.utilities;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.servicenow.pages.BasePage;
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
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

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
            /*htmlReporter.config().setReportName("<img src='E:\\ISBAN\\santander_logo.jpg' />");
            String css = ".report-name { padding-left: 10px; } .report-name > img { float: left;height: 90%;margin-left: 30px;margin-top: 2px;width: auto; }";
            //String css1 = ".brand-logo blue darken-3 { visibility: hidden; }";
            htmlReporter.config().setCSS(css);*/
            htmlReporter.config().setChartVisibilityOnOpen(true);
            
            //htmlReporter.config().setCSS(css1);
            /*// make the charts visible on report open
            

            // report title
            htmlReporter.config().setDocumentTitle("Microsoft CRM Test");

            // encoding, default = UTF-8
            htmlReporter.config().setEncoding("UTF-8");

            // report or build name
            htmlReporter.config().setReportName("Microsoft CRM Test");

            // chart location - top, bottom
            htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);


            // theme - standard, dark
            htmlReporter.config().setTheme(Theme.DARK);

            // set timeStamp format
            htmlReporter.config().setTimeStampFormat("mm/dd/yyyy hh:mm:ss a");

            */
            // add custom css
            //htmlReporter.config().setCSS("css-string");

            // add custom javascript
            //htmlReporter.config().setJS("js-string");
            /*// make the charts visible on report open
            htmlReporter.config().setChartVisibilityOnOpen(true);

            // report title
            String documentTitle = "Microsoft CRM";
            htmlReporter.config().setDocumentTitle(documentTitle);


            // report or build name
            //String reportName = prop.getProperty("reportName", "ExtentReports");
            htmlReporter.config().setReportName(documentTitle);


            String chartLocation = prop.getProperty("chartLocation", "top").toUpperCase();
            htmlReporter.config().setTestViewChartLocation(Enum.valueOf(ChartLocation.class, chartLocation));
*//*
            // theme - standard, dark
            //String theme = prop.getProperty("theme", "standard").toUpperCase();
            htmlReporter.config().setTheme(Enum.valueOf(Theme.class, "STANDARD"));*/

           /* String css = "#topbar { background-color: #8bb1ec; }" +
                    ".topbar-items-right span { color: white; }" +
                    ".menu span { color: darkgreen; }" +
                    ".menu-item-selected span { border-bottom: 1px solid green; }" +
                    "#dashboard { background-color: transparent; }" +
                    ".test { border: 1px solid lightseagreen; }" +
                    ".description { background-color: transparent; border-left: 2px solid orange; padding: 2px 15px;}" +
                    ".name { color: darkgreen; }" +
                    ".extent-table { border: 1px solid #bbb; }" +
                    ".extent-table th { background: none repeat scroll 0 0 olivedrab; color: #fff; }" +
                    ".extent-table td { border-bottom: 1px solid #bbb; }";
            htmlReporter.config().setCSS(css);
            htmlReporter.config().setTheme(Enum.valueOf(Theme.class, "STANDARD"));
            css = ".report-name { padding-left: 10px; } .report-name > img { float: left;height: 90%;margin-left: 30px;margin-top: 2px;width: auto; }";
            htmlReporter.config().setCSS(css);*/

            // suite view:
            htmlReporter.setAnalysisStrategy(AnalysisStrategy.SUITE);



        }



        if (extent == null) {
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);

        }

        /*System.setOut(new PrintStream(System.out) {
            public void println(String s) {
                Report.log("info",s);
                super.println(s);
            }
            // override some other methods?
        });*/

        //return htmlReporter;


    }

    public static synchronized void closeReporter() {
        htmlReporter.flush();
        //reporter.close();
    }

    public static void log(String status,String desc){
        boolean bGeneral=false;
        if(test==null){
            return;
        }
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

    public static void message(String status,String desc){
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