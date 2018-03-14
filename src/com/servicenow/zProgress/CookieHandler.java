package com.servicenow.zProgress;

/**
 *
 */
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieHandler{
   public static WebDriver driver;

    public static void setCookieByName(String cookiename,String value)
    {
       Cookie name = new Cookie(cookiename, value);
        System.out.println(name);
        driver.manage().addCookie(name);
    }
    public static void deleteCookieByName(String cookiename)
    {
        driver.manage().deleteCookieNamed(cookiename);


    }
}





/*
public abstract class  CookieHandler {
    protected final WebDriver.Options options;
    public CookieHandler(WebDriver driver) {
        this.options = driver.manage();
    }
    public Set<Cookie> getCookies() {
        return getOptions().getCookies();
    }
    public Cookie getCookie(String name) {
        if (hasCookie(name)) {
            return getOptions().getCookieNamed(name);
        } else {
            return new Cookie("", "");
        }
    }
    public void deleteCookie(String name) {
        getOptions().deleteCookie(getCookie(name));
    }
    private WebDriver.Options getOptions() {
        return options;
    }

    public void setCookie(String key, String value) {
        Cookie oldCookie = getCookie(key);
        Cookie newCookie = new Cookie(key, value);
        getOptions().deleteCookie(oldCookie);
        getOptions().addCookie(newCookie);
    }
    public boolean hasCookie(String name) {
        final Cookie cookie = getOptions().getCookieNamed(name);
        if (!Strings.isNullOrEmpty(cookie.getName()))
            return true;
        else
            return false;
    }

    public String getValue(String key) {
        return getCookie(key).getValue();
    }
}
*/
