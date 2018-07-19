package com.project.utilities;

import org.testng.annotations.DataProvider;

/**
 * Created by Muni on 5/4/17.
 */
public class SauceDataProvider {

    // Tests run for below supported browsers.
    // Reference: http://confluence.mcclatchyinteractive.com/display/UXResearch/Browser+Support

    //    Chrome: current desktop version (54) and mobile
    //    Firefox: current desktop version (49)
    //    Safari: current desktop version (9.0-10.0) and mobile
    //    Internet Explorer: 10 - 11
    //    Edge: current version (14)

    @DataProvider(name="SupportedBrowsers", parallel = true)
    public static Object[][] getSupportedBrowser(){
        return new Object[][]{
                new Object[] {"Windows 10", "chrome", "58"},
                //new Object[] {"Windows 10", "firefox", "49"},
                //new Object[] {"OS X 10.11", "safari", "10.0"},
                //new Object[] {"Windows 8.1", "internet explorer", "11.0"}
        };
    }


//    @DataProvider(name="SupportedBrowsers123", parallel = true)
//    public static Object[][] getSupportedBrowser123(){
//        return new Object[][]{
//                {"Windows 10", "chrome", "54"},
//                {"Windows 10", "firefox", "49"},
//                //{"OS X 10.11", "safari", "9.0"},
//                {"OS X 10.11", "safari", "10.0"},
//                //{"Windows 8", "internet explorer", "10.0"},
//                {"Windows 8.1", "internet explorer", "11.0"}
//                //{"Windows 10", "MicrosoftEdge", "14.14393"}
//        };
//    }
}
