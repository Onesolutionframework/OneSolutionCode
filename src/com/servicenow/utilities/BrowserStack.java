package com.servicenow.utilities;

public class BrowserStack {

    public static String getUserName(){
        return "muni";
    }

    public static String getAccessKey(){
        return "deb26ecd-32a2-494f-8d5a-a37538287b80";
    }

    public static int getPort() {
        return 443;
    }

    public static Boolean isSauceEnabled(){
        return false;
    }

    public static String getBrowserStackConnectionURL(){
        //return String.format("http://%s:%s@ondemand.saucelabs.com:%s/wd/hub", getUserName(), getAccessKey(), getPort());
        return "https://" + getUserName() + ":" + getAccessKey() + "@ondemand.saucelabs.com:443/wd/hub";
    }
}
